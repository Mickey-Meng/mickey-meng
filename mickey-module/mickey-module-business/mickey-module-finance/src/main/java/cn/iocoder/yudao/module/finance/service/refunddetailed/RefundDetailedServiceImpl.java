package cn.iocoder.yudao.module.finance.service.refunddetailed;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.refunddetailed.RefundDetailedDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.finance.convert.refunddetailed.RefundDetailedConvert;
import cn.iocoder.yudao.module.finance.dal.mysql.refunddetailed.RefundDetailedMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.finance.enums.ErrorCodeConstants.*;

/**
 * 键值参数 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class RefundDetailedServiceImpl implements RefundDetailedService {

    @Resource
    private RefundDetailedMapper refundDetailedMapper;

    @Override
    public String createRefundDetailed(RefundDetailedCreateReqVO createReqVO) {
        // 插入
        RefundDetailedDO refundDetailed = RefundDetailedConvert.INSTANCE.convert(createReqVO);
        refundDetailedMapper.insert(refundDetailed);
        // 返回
        return refundDetailed.getRefundDetailedId();
    }

    @Override
    public void updateRefundDetailed(RefundDetailedUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRefundDetailedExists(updateReqVO.getRefundDetailedId());
        // 更新
        RefundDetailedDO updateObj = RefundDetailedConvert.INSTANCE.convert(updateReqVO);
        refundDetailedMapper.updateById(updateObj);
    }

    @Override
    public void deleteRefundDetailed(String id) {
        // 校验存在
        this.validateRefundDetailedExists(id);
        // 删除
        refundDetailedMapper.deleteById(id);
    }

    private void validateRefundDetailedExists(String id) {
        if (refundDetailedMapper.selectById(id) == null) {
            throw exception(REFUND_DETAILED_NOT_EXISTS);
        }
    }

    @Override
    public RefundDetailedDO getRefundDetailed(String id) {
        return refundDetailedMapper.selectById(id);
    }

    @Override
    public List<RefundDetailedDO> getRefundDetailedList(Collection<String> ids) {
        return refundDetailedMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<RefundDetailedDO> getRefundDetailedPage(RefundDetailedPageReqVO pageReqVO) {
        return refundDetailedMapper.selectPage(pageReqVO);
    }

    @Override
    public List<RefundDetailedDO> getRefundDetailedList(RefundDetailedExportReqVO exportReqVO) {
        return refundDetailedMapper.selectList(exportReqVO);
    }

}
