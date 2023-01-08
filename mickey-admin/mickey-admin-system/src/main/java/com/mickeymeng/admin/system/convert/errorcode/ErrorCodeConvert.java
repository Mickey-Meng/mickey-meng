package com.mickeymeng.admin.system.convert.errorcode;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.common.service.dto.ErrorCodeAutoGenerateReqDTO;
import com.mickeymeng.framework.common.service.dto.ErrorCodeRespDTO;
import com.mickeymeng.admin.system.controller.admin.errorcode.vo.ErrorCodeCreateReqVO;
import com.mickeymeng.admin.system.controller.admin.errorcode.vo.ErrorCodeExcelVO;
import com.mickeymeng.admin.system.controller.admin.errorcode.vo.ErrorCodeRespVO;
import com.mickeymeng.admin.system.controller.admin.errorcode.vo.ErrorCodeUpdateReqVO;
import com.mickeymeng.admin.system.dal.dataobject.errorcode.ErrorCodeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 错误码 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ErrorCodeConvert {

    ErrorCodeConvert INSTANCE = Mappers.getMapper(ErrorCodeConvert.class);

    ErrorCodeDO convert(ErrorCodeCreateReqVO bean);

    ErrorCodeDO convert(ErrorCodeUpdateReqVO bean);

    ErrorCodeRespVO convert(ErrorCodeDO bean);

    List<ErrorCodeRespVO> convertList(List<ErrorCodeDO> list);

    PageResult<ErrorCodeRespVO> convertPage(PageResult<ErrorCodeDO> page);

    List<ErrorCodeExcelVO> convertList02(List<ErrorCodeDO> list);

    ErrorCodeDO convert(ErrorCodeAutoGenerateReqDTO bean);

    List<ErrorCodeRespDTO> convertList03(List<ErrorCodeDO> list);

}
