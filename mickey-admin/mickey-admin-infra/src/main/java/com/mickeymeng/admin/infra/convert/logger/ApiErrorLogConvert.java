package com.mickeymeng.admin.infra.convert.logger;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.admin.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import com.mickeymeng.admin.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import com.mickeymeng.admin.infra.dal.dataobject.logger.ApiErrorLogDO;
import com.mickeymeng.framework.common.service.dto.ApiErrorLogCreateReqDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 错误日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
