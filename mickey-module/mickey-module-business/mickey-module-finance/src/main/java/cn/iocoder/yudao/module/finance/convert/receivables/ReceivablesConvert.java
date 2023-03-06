package cn.iocoder.yudao.module.finance.convert.receivables;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.finance.controller.admin.receivables.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivables.ReceivablesDO;

/**
 * 键值参数 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ReceivablesConvert {

    ReceivablesConvert INSTANCE = Mappers.getMapper(ReceivablesConvert.class);

    ReceivablesDO convert(ReceivablesCreateReqVO bean);

    ReceivablesDO convert(ReceivablesUpdateReqVO bean);

    ReceivablesRespVO convert(ReceivablesDO bean);

    List<ReceivablesRespVO> convertList(List<ReceivablesDO> list);

    PageResult<ReceivablesRespVO> convertPage(PageResult<ReceivablesDO> page);

    List<ReceivablesExcelVO> convertList02(List<ReceivablesDO> list);

}
