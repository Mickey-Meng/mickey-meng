package cn.iocoder.yudao.module.finance.convert.receivablesdetailed;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivablesdetailed.ReceivablesDetailedDO;

/**
 * 键值参数 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ReceivablesDetailedConvert {

    ReceivablesDetailedConvert INSTANCE = Mappers.getMapper(ReceivablesDetailedConvert.class);

    ReceivablesDetailedDO convert(ReceivablesDetailedCreateReqVO bean);

    ReceivablesDetailedDO convert(ReceivablesDetailedUpdateReqVO bean);

    ReceivablesDetailedRespVO convert(ReceivablesDetailedDO bean);

    List<ReceivablesDetailedRespVO> convertList(List<ReceivablesDetailedDO> list);

    PageResult<ReceivablesDetailedRespVO> convertPage(PageResult<ReceivablesDetailedDO> page);

    List<ReceivablesDetailedExcelVO> convertList02(List<ReceivablesDetailedDO> list);

}
