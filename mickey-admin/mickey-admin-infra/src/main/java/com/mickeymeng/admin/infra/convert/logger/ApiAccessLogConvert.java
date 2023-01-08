package com.mickeymeng.admin.infra.convert.logger;

import com.mickeymeng.admin.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExcelVO;
import com.mickeymeng.admin.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogRespVO;
import com.mickeymeng.admin.infra.dal.dataobject.logger.ApiAccessLogDO;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.common.service.dto.ApiAccessLogCreateReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 访问日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiAccessLogConvert {

    ApiAccessLogConvert INSTANCE = Mappers.getMapper(ApiAccessLogConvert.class);

    ApiAccessLogRespVO convert(ApiAccessLogDO bean);

    List<ApiAccessLogRespVO> convertList(List<ApiAccessLogDO> list);

    PageResult<ApiAccessLogRespVO> convertPage(PageResult<ApiAccessLogDO> page);

    List<ApiAccessLogExcelVO> convertList02(List<ApiAccessLogDO> list);

    ApiAccessLogDO convert(ApiAccessLogCreateReqDTO bean);

}
