package service.config;

import com.mickeymeng.admin.infra.controller.admin.config.vo.ConfigCreateReqVO;
import com.mickeymeng.admin.infra.controller.admin.config.vo.ConfigExportReqVO;
import com.mickeymeng.admin.infra.controller.admin.config.vo.ConfigPageReqVO;
import com.mickeymeng.admin.infra.controller.admin.config.vo.ConfigUpdateReqVO;
import com.mickeymeng.admin.infra.dal.dataobject.config.ConfigDO;
import com.mickeymeng.admin.infra.dal.mysql.config.ConfigMapper;
import com.mickeymeng.admin.infra.enums.config.ConfigTypeEnum;
import com.mickeymeng.admin.infra.service.config.ConfigServiceImpl;
import com.mickeymeng.framework.common.core.util.collection.ArrayUtils;
import com.mickeymeng.framework.common.core.util.random.RandomUtils;
import com.mickeymeng.framework.common.core.util.object.ObjectUtils;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.test.core.ut.BaseDbUnitTest;
import com.mickeymeng.framework.test.core.util.AssertUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

import static cn.hutool.core.util.RandomUtil.randomEle;
import static com.mickeymeng.framework.common.core.util.date.LocalDateTimeUtils.buildTime;
import static com.mickeymeng.framework.test.core.util.AssertUtils.assertPojoEquals;
import static com.mickeymeng.framework.test.core.util.AssertUtils.assertServiceException;

import static org.junit.jupiter.api.Assertions.*;

@Import(ConfigServiceImpl.class)
public class ConfigServiceTest extends BaseDbUnitTest {

    @Resource
    private ConfigServiceImpl configService;

    @Resource
    private ConfigMapper configMapper;

    @Test
    public void testCreateConfig_success() {
        // 准备参数
        ConfigCreateReqVO reqVO = RandomUtils.randomPojo(ConfigCreateReqVO.class);

        // 调用
        Long configId = configService.createConfig(reqVO);
        // 断言
        assertNotNull(configId);
        // 校验记录的属性是否正确
        ConfigDO config = configMapper.selectById(configId);
        AssertUtils.assertPojoEquals(reqVO, config);
        Assertions.assertEquals(ConfigTypeEnum.CUSTOM.getType(), config.getType());
    }

    @Test
    public void testUpdateConfig_success() {
        // mock 数据
        ConfigDO dbConfig = randomConfigDO();
        configMapper.insert(dbConfig);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ConfigUpdateReqVO reqVO = RandomUtils.randomPojo(ConfigUpdateReqVO.class, o -> {
            o.setId(dbConfig.getId()); // 设置更新的 ID
        });

        // 调用
        configService.updateConfig(reqVO);
        // 校验是否更新正确
        ConfigDO config = configMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, config);
    }

    @Test
    public void testDeleteConfig_success() {
        // mock 数据
        ConfigDO dbConfig = randomConfigDO(o -> {
            o.setType(ConfigTypeEnum.CUSTOM.getType()); // 只能删除 CUSTOM 类型
        });
        configMapper.insert(dbConfig);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbConfig.getId();

        // 调用
        configService.deleteConfig(id);
        // 校验数据不存在了
        assertNull(configMapper.selectById(id));
    }

    @Test
    public void testDeleteConfig_canNotDeleteSystemType() {
        // mock 数据
        ConfigDO dbConfig = randomConfigDO(o -> {
            o.setType(ConfigTypeEnum.SYSTEM.getType()); // SYSTEM 不允许删除
        });
        configMapper.insert(dbConfig);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbConfig.getId();

        // 调用, 并断言异常
        assertServiceException(() -> configService.deleteConfig(id), ErrorCodeConstants.CONFIG_CAN_NOT_DELETE_SYSTEM_TYPE);
    }

    @Test
    public void testCheckConfigExists_success() {
        // mock 数据
        ConfigDO dbConfigDO = randomConfigDO();
        configMapper.insert(dbConfigDO);// @Sql: 先插入出一条存在的数据

        // 调用成功
        configService.checkConfigExists(dbConfigDO.getId());
    }

    @Test
    public void testCheckConfigExist_notExists() {
        assertServiceException(() -> configService.checkConfigExists(RandomUtils.randomLongId()), ErrorCodeConstants.CONFIG_NOT_EXISTS);
    }

    @Test
    public void testCheckConfigKeyUnique_success() {
        // 调用，成功
        configService.checkConfigKeyUnique(RandomUtils.randomLongId(), RandomUtils.randomString());
    }

    @Test
    public void testCheckConfigKeyUnique_keyDuplicateForCreate() {
        // 准备参数
        String key = RandomUtils.randomString();
        // mock 数据
        configMapper.insert(randomConfigDO(o -> o.setConfigKey(key)));

        // 调用，校验异常
        assertServiceException(() -> configService.checkConfigKeyUnique(null, key),
                ErrorCodeConstants.CONFIG_KEY_DUPLICATE);
    }

    @Test
    public void testCheckConfigKeyUnique_keyDuplicateForUpdate() {
        // 准备参数
        Long id = RandomUtils.randomLongId();
        String key = RandomUtils.randomString();
        // mock 数据
        configMapper.insert(randomConfigDO(o -> o.setConfigKey(key)));

        // 调用，校验异常
        assertServiceException(() -> configService.checkConfigKeyUnique(id, key),
                ErrorCodeConstants.CONFIG_KEY_DUPLICATE);
    }

    @Test
    public void testGetConfigPage() {
        // mock 数据
        ConfigDO dbConfig = randomConfigDO(o -> { // 等会查询到
            o.setName("芋艿");
            o.setConfigKey("yunai");
            o.setType(ConfigTypeEnum.SYSTEM.getType());
            o.setCreateTime(buildTime(2021, 2, 1));
        });
        configMapper.insert(dbConfig);
        // 测试 name 不匹配
        configMapper.insert(ObjectUtils.cloneIgnoreId(dbConfig, o -> o.setName("土豆")));
        // 测试 key 不匹配
        configMapper.insert(ObjectUtils.cloneIgnoreId(dbConfig, o -> o.setConfigKey("tudou")));
        // 测试 type 不匹配
        configMapper.insert(ObjectUtils.cloneIgnoreId(dbConfig, o -> o.setType(ConfigTypeEnum.CUSTOM.getType())));
        // 测试 createTime 不匹配
        configMapper.insert(ObjectUtils.cloneIgnoreId(dbConfig, o -> o.setCreateTime(buildTime(2021, 1, 1))));
        // 准备参数
        ConfigPageReqVO reqVO = new ConfigPageReqVO();
        reqVO.setName("艿");
        reqVO.setKey("nai");
        reqVO.setType(ConfigTypeEnum.SYSTEM.getType());
        reqVO.setCreateTime((new LocalDateTime[]{buildTime(2021, 1, 15),buildTime(2021, 2, 15)}));

        // 调用
        PageResult<ConfigDO> pageResult = configService.getConfigPage(reqVO);
        // 断言
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(dbConfig, pageResult.getList().get(0));
    }

    @Test
    public void testGetConfigList() {
        // mock 数据
        ConfigDO dbConfig = randomConfigDO(o -> { // 等会查询到
            o.setName("芋艿");
            o.setConfigKey("yunai");
            o.setType(ConfigTypeEnum.SYSTEM.getType());
            o.setCreateTime(buildTime(2021, 2, 1));
        });
        configMapper.insert(dbConfig);
        // 测试 name 不匹配
        configMapper.insert(ObjectUtils.cloneIgnoreId(dbConfig, o -> o.setName("土豆")));
        // 测试 key 不匹配
        configMapper.insert(ObjectUtils.cloneIgnoreId(dbConfig, o -> o.setConfigKey("tudou")));
        // 测试 type 不匹配
        configMapper.insert(ObjectUtils.cloneIgnoreId(dbConfig, o -> o.setType(ConfigTypeEnum.CUSTOM.getType())));
        // 测试 createTime 不匹配
        configMapper.insert(ObjectUtils.cloneIgnoreId(dbConfig, o -> o.setCreateTime(buildTime(2021, 1, 1))));
        // 准备参数
        ConfigExportReqVO reqVO = new ConfigExportReqVO();
        reqVO.setName("艿");
        reqVO.setKey("nai");
        reqVO.setType(ConfigTypeEnum.SYSTEM.getType());
        reqVO.setCreateTime((new LocalDateTime[]{buildTime(2021, 1, 15),buildTime(2021, 2, 15)}));

        // 调用
        List<ConfigDO> list = configService.getConfigList(reqVO);
        // 断言
        assertEquals(1, list.size());
        assertPojoEquals(dbConfig, list.get(0));
    }

    @Test
    public void testGetConfigByKey() {
        // mock 数据
        ConfigDO dbConfig = randomConfigDO();
        configMapper.insert(dbConfig);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String key = dbConfig.getConfigKey();

        // 调用
        ConfigDO config = configService.getConfigByKey(key);
        // 断言
        assertNotNull(config);
        assertPojoEquals(dbConfig, config);
    }

    // ========== 随机对象 ==========

    @SafeVarargs
    private static ConfigDO randomConfigDO(Consumer<ConfigDO>... consumers) {
        Consumer<ConfigDO> consumer = (o) -> {
            o.setType(randomEle(ConfigTypeEnum.values()).getType()); // 保证 key 的范围
        };
        return RandomUtils.randomPojo(ConfigDO.class, ArrayUtils.append(consumer, consumers));
    }

}
