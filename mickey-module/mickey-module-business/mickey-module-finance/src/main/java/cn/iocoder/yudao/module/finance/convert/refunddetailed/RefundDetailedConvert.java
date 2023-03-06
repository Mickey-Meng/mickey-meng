package cn.iocoder.yudao.module.finance.convert.refunddetailed;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.refunddetailed.RefundDetailedDO;

/**
 * 键值参数 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface RefundDetailedConvert {

    RefundDetailedConvert INSTANCE = Mappers.getMapper(RefundDetailedConvert.class);

    RefundDetailedDO convert(RefundDetailedCreateReqVO bean);

    RefundDetailedDO convert(RefundDetailedUpdateReqVO bean);

    RefundDetailedRespVO convert(RefundDetailedDO bean);

    List<RefundDetailedRespVO> convertList(List<RefundDetailedDO> list);

    PageResult<RefundDetailedRespVO> convertPage(PageResult<RefundDetailedDO> page);

    List<RefundDetailedExcelVO> convertList02(List<RefundDetailedDO> list);

}
