package com.mickeymeng.admin.infra.service.file;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.IdUtil;
import com.mickeymeng.admin.infra.controller.admin.file.vo.config.FileConfigCreateReqVO;
import com.mickeymeng.admin.infra.controller.admin.file.vo.config.FileConfigPageReqVO;
import com.mickeymeng.admin.infra.controller.admin.file.vo.config.FileConfigUpdateReqVO;
import com.mickeymeng.admin.infra.convert.file.FileConfigConvert;
import com.mickeymeng.admin.infra.dal.dataobject.file.FileConfigDO;
import com.mickeymeng.admin.infra.dal.mysql.file.FileConfigMapper;
import com.mickeymeng.admin.infra.mq.producer.file.FileConfigProducer;
import com.mickeymeng.framework.common.constants.ErrorCodeConstants;
import com.mickeymeng.framework.common.core.util.collection.CollectionUtils;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.common.core.util.json.JsonUtils;
import com.mickeymeng.framework.common.core.util.validation.ValidationUtils;
import com.mickeymeng.framework.middleware.file.core.client.FileClient;
import com.mickeymeng.framework.middleware.file.core.client.FileClientConfig;
import com.mickeymeng.framework.middleware.file.core.client.FileClientFactory;
import com.mickeymeng.framework.middleware.file.core.enums.FileStorageEnum;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.mickeymeng.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 文件配置 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Slf4j
public class FileConfigServiceImpl implements FileConfigService {

    /**
     * 定时执行 {@link #schedulePeriodicRefresh()} 的周期
     * 因为已经通过 Redis Pub/Sub 机制，所以频率不需要高
     */
    private static final long SCHEDULER_PERIOD = 5 * 60 * 1000L;

    /**
     * 缓存菜单的最大更新时间，用于后续的增量轮询，判断是否有更新
     */
    @Getter
    private volatile LocalDateTime maxUpdateTime;

    @Resource
    private FileClientFactory fileClientFactory;
    /**
     * Master FileClient 对象，有且仅有一个，即 {@link FileConfigDO#getMaster()} 对应的
     */
    @Getter
    private FileClient masterFileClient;

    @Resource
    private FileConfigMapper fileConfigMapper;

    @Resource
    private FileConfigProducer fileConfigProducer;

    @Resource
    private Validator validator;

    @Override
    @PostConstruct
    public void initFileClients() {
        initLocalCacheIfUpdate(null);
    }

    @Scheduled(fixedDelay = SCHEDULER_PERIOD, initialDelay = SCHEDULER_PERIOD)
    public void schedulePeriodicRefresh() {
        initLocalCacheIfUpdate(this.maxUpdateTime);
    }

    /**
     * 刷新本地缓存
     *
     * @param maxUpdateTime 最大更新时间
     *                      1. 如果 maxUpdateTime 为 null，则“强制”刷新缓存
     *                      2. 如果 maxUpdateTime 不为 null，判断自 maxUpdateTime 是否有数据发生变化，有的情况下才刷新缓存
     */
    private void initLocalCacheIfUpdate(LocalDateTime maxUpdateTime) {
        // 第一步：基于 maxUpdateTime 判断缓存是否刷新。
        // 如果没有增量的数据变化，则不进行本地缓存的刷新
        if (maxUpdateTime != null
                && fileConfigMapper.selectCountByUpdateTimeGt(maxUpdateTime) == 0) {
            log.info("[initLocalCacheIfUpdate][数据未发生变化({})，本地缓存不刷新]", maxUpdateTime);
            return;
        }
        List<FileConfigDO> configs = fileConfigMapper.selectList();
        log.info("[initLocalCacheIfUpdate][缓存文件配置，数量为:{}]", configs.size());

        // 第二步：构建缓存。创建或更新文件 Client
        configs.forEach(config -> {
            fileClientFactory.createOrUpdateFileClient(config.getId(), config.getStorage(), config.getConfig());
            // 如果是 master，进行设置
            if (Boolean.TRUE.equals(config.getMaster())) {
                masterFileClient = fileClientFactory.getFileClient(config.getId());
            }
        });

        // 第三步：设置最新的 maxUpdateTime，用于下次的增量判断。
        this.maxUpdateTime = CollectionUtils.getMaxValue(configs, FileConfigDO::getUpdateTime);
    }

    @Override
    public Long createFileConfig(FileConfigCreateReqVO createReqVO) {
        // 插入
        FileConfigDO fileConfig = FileConfigConvert.INSTANCE.convert(createReqVO)
                .setConfig(parseClientConfig(createReqVO.getStorage(), createReqVO.getConfig()))
                .setMaster(false); // 默认非 master
        fileConfigMapper.insert(fileConfig);
        // 发送刷新配置的消息
        fileConfigProducer.sendFileConfigRefreshMessage();
        // 返回
        return fileConfig.getId();
    }

    @Override
    public void updateFileConfig(FileConfigUpdateReqVO updateReqVO) {
        // 校验存在
        FileConfigDO config = this.validateFileConfigExists(updateReqVO.getId());
        // 更新
        FileConfigDO updateObj = FileConfigConvert.INSTANCE.convert(updateReqVO)
                .setConfig(parseClientConfig(config.getStorage(), updateReqVO.getConfig()));
        fileConfigMapper.updateById(updateObj);
        // 发送刷新配置的消息
        fileConfigProducer.sendFileConfigRefreshMessage();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFileConfigMaster(Long id) {
        // 校验存在
        this.validateFileConfigExists(id);
        // 更新其它为非 master
        fileConfigMapper.updateBatch(new FileConfigDO().setMaster(false));
        // 更新
        fileConfigMapper.updateById(new FileConfigDO().setId(id).setMaster(true));
        // 发送刷新配置的消息
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {

            @Override
            public void afterCommit() {
                fileConfigProducer.sendFileConfigRefreshMessage();
            }

        });
    }

    private FileClientConfig parseClientConfig(Integer storage, Map<String, Object> config) {
        // 获取配置类
        Class<? extends FileClientConfig> configClass = FileStorageEnum.getByStorage(storage)
                .getConfigClass();
        FileClientConfig clientConfig = JsonUtils.parseObject2(JsonUtils.toJsonString(config), configClass);
        // 参数校验
        ValidationUtils.validate(validator, clientConfig);
        // 设置参数
        return clientConfig;
    }

    @Override
    public void deleteFileConfig(Long id) {
        // 校验存在
        FileConfigDO config = this.validateFileConfigExists(id);
        if (Boolean.TRUE.equals(config.getMaster())) {
             throw exception(ErrorCodeConstants.FILE_CONFIG_DELETE_FAIL_MASTER);
        }
        // 删除
        fileConfigMapper.deleteById(id);
        // 发送刷新配置的消息
        fileConfigProducer.sendFileConfigRefreshMessage();
    }

    private FileConfigDO validateFileConfigExists(Long id) {
        FileConfigDO config = fileConfigMapper.selectById(id);
        if (config == null) {
            throw exception(ErrorCodeConstants.FILE_CONFIG_NOT_EXISTS);
        }
        return config;
    }

    @Override
    public FileConfigDO getFileConfig(Long id) {
        return fileConfigMapper.selectById(id);
    }

    @Override
    public List<FileConfigDO> getFileConfigList(Collection<Long> ids) {
        return fileConfigMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<FileConfigDO> getFileConfigPage(FileConfigPageReqVO pageReqVO) {
        return fileConfigMapper.selectPage(pageReqVO);
    }

    @Override
    public String testFileConfig(Long id) throws Exception {
        // 校验存在
        this.validateFileConfigExists(id);
        // 上传文件
        byte[] content = ResourceUtil.readBytes("file/erweima.jpg");
        return fileClientFactory.getFileClient(id).upload(content, IdUtil.fastSimpleUUID() + ".jpg", "image/jpeg");
    }

    @Override
    public FileClient getFileClient(Long id) {
        return fileClientFactory.getFileClient(id);
    }

}
