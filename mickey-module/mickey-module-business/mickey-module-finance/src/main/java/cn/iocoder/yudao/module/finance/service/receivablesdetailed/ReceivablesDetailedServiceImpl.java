package cn.iocoder.yudao.module.finance.service.receivablesdetailed;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivablesdetailed.ReceivablesDetailedDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.finance.convert.receivablesdetailed.ReceivablesDetailedConvert;
import cn.iocoder.yudao.module.finance.dal.mysql.receivablesdetailed.ReceivablesDetailedMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.finance.enums.ErrorCodeConstants.*;

/**
 * 键值参数 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ReceivablesDetailedServiceImpl implements ReceivablesDetailedService {

    @Resource
    private ReceivablesDetailedMapper receivablesDetailedMapper;

    @Override
    public String createReceivablesDetailed(ReceivablesDetailedCreateReqVO createReqVO) {
        // 插入
        ReceivablesDetailedDO receivablesDetailed = ReceivablesDetailedConvert.INSTANCE.convert(createReqVO);
        receivablesDetailedMapper.insert(receivablesDetailed);
        // 返回
        return receivablesDetailed.getReceivablesDetailedId();
    }

    @Override
    public void updateReceivablesDetailed(ReceivablesDetailedUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateReceivablesDetailedExists(updateReqVO.getReceivablesDetailedId());
        // 更新
        ReceivablesDetailedDO updateObj = ReceivablesDetailedConvert.INSTANCE.convert(updateReqVO);
        receivablesDetailedMapper.updateById(updateObj);
    }

    @Override
    public void deleteReceivablesDetailed(String id) {
        // 校验存在
        this.validateReceivablesDetailedExists(id);
        // 删除
        receivablesDetailedMapper.deleteById(id);
    }

    private void validateReceivablesDetailedExists(String id) {
        if (receivablesDetailedMapper.selectById(id) == null) {
            throw exception(RECEIVABLES_DETAILED_NOT_EXISTS);
        }
    }

    @Override
    public ReceivablesDetailedDO getReceivablesDetailed(String id) {
        return receivablesDetailedMapper.selectById(id);
    }

    @Override
    public List<ReceivablesDetailedDO> getReceivablesDetailedList(Collection<String> ids) {
        return receivablesDetailedMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ReceivablesDetailedDO> getReceivablesDetailedPage(ReceivablesDetailedPageReqVO pageReqVO) {
        return receivablesDetailedMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ReceivablesDetailedDO> getReceivablesDetailedList(ReceivablesDetailedExportReqVO exportReqVO) {
        return receivablesDetailedMapper.selectList(exportReqVO);
    }

}
