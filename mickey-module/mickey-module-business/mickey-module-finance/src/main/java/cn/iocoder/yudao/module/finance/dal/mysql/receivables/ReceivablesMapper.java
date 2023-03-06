package cn.iocoder.yudao.module.finance.dal.mysql.receivables;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivables.ReceivablesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.finance.controller.admin.receivables.vo.*;

/**
 * 键值参数 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ReceivablesMapper extends BaseMapperX<ReceivablesDO> {

    default PageResult<ReceivablesDO> selectPage(ReceivablesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ReceivablesDO>()
                .eqIfPresent(ReceivablesDO::getCustomerCode, reqVO.getCustomerCode())
                .likeIfPresent(ReceivablesDO::getCustomerName, reqVO.getCustomerName())
                .eqIfPresent(ReceivablesDO::getTelephoneNo, reqVO.getTelephoneNo())
                .eqIfPresent(ReceivablesDO::getAddress, reqVO.getAddress())
                .eqIfPresent(ReceivablesDO::getSalesChannel, reqVO.getSalesChannel())
                .eqIfPresent(ReceivablesDO::getShoppingGuide, reqVO.getShoppingGuide())
                .eqIfPresent(ReceivablesDO::getSalesAmount, reqVO.getSalesAmount())
                .eqIfPresent(ReceivablesDO::getPreferentialAmount, reqVO.getPreferentialAmount())
                .eqIfPresent(ReceivablesDO::getRefundGoodsAmount, reqVO.getRefundGoodsAmount())
                .eqIfPresent(ReceivablesDO::getRefundAmount, reqVO.getRefundAmount())
                .eqIfPresent(ReceivablesDO::getCollectedAmount, reqVO.getCollectedAmount())
                .eqIfPresent(ReceivablesDO::getReceivableBalance, reqVO.getReceivableBalance())
                .eqIfPresent(ReceivablesDO::getReceivableAmount, reqVO.getReceivableAmount())
                .eqIfPresent(ReceivablesDO::getIsSettle, reqVO.getIsSettle())
                .eqIfPresent(ReceivablesDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ReceivablesDO::getApprovalState, reqVO.getApprovalState())
                .betweenIfPresent(ReceivablesDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ReceivablesDO::getCreator, reqVO.getCreator())
                .eqIfPresent(ReceivablesDO::getUpdater, reqVO.getUpdater())
                .eqIfPresent(ReceivablesDO::getGoodsType, reqVO.getGoodsType())
                .orderByDesc(ReceivablesDO::getCreateTime));
    }

    default List<ReceivablesDO> selectList(ReceivablesExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ReceivablesDO>()
                .eqIfPresent(ReceivablesDO::getCustomerCode, reqVO.getCustomerCode())
                .likeIfPresent(ReceivablesDO::getCustomerName, reqVO.getCustomerName())
                .eqIfPresent(ReceivablesDO::getTelephoneNo, reqVO.getTelephoneNo())
                .eqIfPresent(ReceivablesDO::getAddress, reqVO.getAddress())
                .eqIfPresent(ReceivablesDO::getSalesChannel, reqVO.getSalesChannel())
                .eqIfPresent(ReceivablesDO::getShoppingGuide, reqVO.getShoppingGuide())
                .eqIfPresent(ReceivablesDO::getSalesAmount, reqVO.getSalesAmount())
                .eqIfPresent(ReceivablesDO::getPreferentialAmount, reqVO.getPreferentialAmount())
                .eqIfPresent(ReceivablesDO::getRefundGoodsAmount, reqVO.getRefundGoodsAmount())
                .eqIfPresent(ReceivablesDO::getRefundAmount, reqVO.getRefundAmount())
                .eqIfPresent(ReceivablesDO::getCollectedAmount, reqVO.getCollectedAmount())
                .eqIfPresent(ReceivablesDO::getReceivableBalance, reqVO.getReceivableBalance())
                .eqIfPresent(ReceivablesDO::getReceivableAmount, reqVO.getReceivableAmount())
                .eqIfPresent(ReceivablesDO::getIsSettle, reqVO.getIsSettle())
                .eqIfPresent(ReceivablesDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ReceivablesDO::getApprovalState, reqVO.getApprovalState())
                .betweenIfPresent(ReceivablesDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ReceivablesDO::getCreator, reqVO.getCreator())
                .eqIfPresent(ReceivablesDO::getUpdater, reqVO.getUpdater())
                .eqIfPresent(ReceivablesDO::getGoodsType, reqVO.getGoodsType())
                .orderByDesc(ReceivablesDO::getCreateTime));
    }

}
