package cn.iocoder.yudao.module.finance.dal.mysql.receivablesdetailed;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivablesdetailed.ReceivablesDetailedDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo.*;

/**
 * 键值参数 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ReceivablesDetailedMapper extends BaseMapperX<ReceivablesDetailedDO> {

    default PageResult<ReceivablesDetailedDO> selectPage(ReceivablesDetailedPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ReceivablesDetailedDO>()
                .eqIfPresent(ReceivablesDetailedDO::getReceivablesId, reqVO.getReceivablesId())
                .eqIfPresent(ReceivablesDetailedDO::getReceiptNumber, reqVO.getReceiptNumber())
                .eqIfPresent(ReceivablesDetailedDO::getCollectionAccount, reqVO.getCollectionAccount())
                .eqIfPresent(ReceivablesDetailedDO::getItemCollectedAmount, reqVO.getItemCollectedAmount())
                .eqIfPresent(ReceivablesDetailedDO::getCollectionUser, reqVO.getCollectionUser())
                .eqIfPresent(ReceivablesDetailedDO::getCashierCode, reqVO.getCashierCode())
                .betweenIfPresent(ReceivablesDetailedDO::getCollectionDate, reqVO.getCollectionDate())
                .eqIfPresent(ReceivablesDetailedDO::getApprovalState, reqVO.getApprovalState())
                .eqIfPresent(ReceivablesDetailedDO::getRemarks, reqVO.getRemarks())
                .betweenIfPresent(ReceivablesDetailedDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ReceivablesDetailedDO::getCreator, reqVO.getCreator())
                .eqIfPresent(ReceivablesDetailedDO::getUpdater, reqVO.getUpdater())
                .orderByDesc(ReceivablesDetailedDO::getCreateTime));
    }

    default List<ReceivablesDetailedDO> selectList(ReceivablesDetailedExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ReceivablesDetailedDO>()
                .eqIfPresent(ReceivablesDetailedDO::getReceivablesId, reqVO.getReceivablesId())
                .eqIfPresent(ReceivablesDetailedDO::getReceiptNumber, reqVO.getReceiptNumber())
                .eqIfPresent(ReceivablesDetailedDO::getCollectionAccount, reqVO.getCollectionAccount())
                .eqIfPresent(ReceivablesDetailedDO::getItemCollectedAmount, reqVO.getItemCollectedAmount())
                .eqIfPresent(ReceivablesDetailedDO::getCollectionUser, reqVO.getCollectionUser())
                .eqIfPresent(ReceivablesDetailedDO::getCashierCode, reqVO.getCashierCode())
                .betweenIfPresent(ReceivablesDetailedDO::getCollectionDate, reqVO.getCollectionDate())
                .eqIfPresent(ReceivablesDetailedDO::getApprovalState, reqVO.getApprovalState())
                .eqIfPresent(ReceivablesDetailedDO::getRemarks, reqVO.getRemarks())
                .betweenIfPresent(ReceivablesDetailedDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ReceivablesDetailedDO::getCreator, reqVO.getCreator())
                .eqIfPresent(ReceivablesDetailedDO::getUpdater, reqVO.getUpdater())
                .orderByDesc(ReceivablesDetailedDO::getCreateTime));
    }

}
