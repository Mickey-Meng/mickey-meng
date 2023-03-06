package cn.iocoder.yudao.module.finance.dal.mysql.refunddetailed;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.finance.dal.dataobject.refunddetailed.RefundDetailedDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo.*;

/**
 * 键值参数 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface RefundDetailedMapper extends BaseMapperX<RefundDetailedDO> {

    default PageResult<RefundDetailedDO> selectPage(RefundDetailedPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RefundDetailedDO>()
                .eqIfPresent(RefundDetailedDO::getReceivablesId, reqVO.getReceivablesId())
                .eqIfPresent(RefundDetailedDO::getRefundNumber, reqVO.getRefundNumber())
                .eqIfPresent(RefundDetailedDO::getRefundAccount, reqVO.getRefundAccount())
                .eqIfPresent(RefundDetailedDO::getItemRefundAmount, reqVO.getItemRefundAmount())
                .eqIfPresent(RefundDetailedDO::getRefundUser, reqVO.getRefundUser())
                .eqIfPresent(RefundDetailedDO::getCashierCode, reqVO.getCashierCode())
                .betweenIfPresent(RefundDetailedDO::getRefundDate, reqVO.getRefundDate())
                .eqIfPresent(RefundDetailedDO::getApprovalState, reqVO.getApprovalState())
                .eqIfPresent(RefundDetailedDO::getRemarks, reqVO.getRemarks())
                .betweenIfPresent(RefundDetailedDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(RefundDetailedDO::getCreator, reqVO.getCreator())
                .eqIfPresent(RefundDetailedDO::getUpdater, reqVO.getUpdater())
                .orderByDesc(RefundDetailedDO::getCreateTime));
    }

    default List<RefundDetailedDO> selectList(RefundDetailedExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<RefundDetailedDO>()
                .eqIfPresent(RefundDetailedDO::getReceivablesId, reqVO.getReceivablesId())
                .eqIfPresent(RefundDetailedDO::getRefundNumber, reqVO.getRefundNumber())
                .eqIfPresent(RefundDetailedDO::getRefundAccount, reqVO.getRefundAccount())
                .eqIfPresent(RefundDetailedDO::getItemRefundAmount, reqVO.getItemRefundAmount())
                .eqIfPresent(RefundDetailedDO::getRefundUser, reqVO.getRefundUser())
                .eqIfPresent(RefundDetailedDO::getCashierCode, reqVO.getCashierCode())
                .betweenIfPresent(RefundDetailedDO::getRefundDate, reqVO.getRefundDate())
                .eqIfPresent(RefundDetailedDO::getApprovalState, reqVO.getApprovalState())
                .eqIfPresent(RefundDetailedDO::getRemarks, reqVO.getRemarks())
                .betweenIfPresent(RefundDetailedDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(RefundDetailedDO::getCreator, reqVO.getCreator())
                .eqIfPresent(RefundDetailedDO::getUpdater, reqVO.getUpdater())
                .orderByDesc(RefundDetailedDO::getCreateTime));
    }

}
