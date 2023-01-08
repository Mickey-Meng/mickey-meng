package com.mickeymeng.admin.system.convert.logger;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.common.service.dto.LoginLogCreateReqDTO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import com.mickeymeng.admin.system.dal.dataobject.logger.LoginLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    PageResult<LoginLogRespVO> convertPage(PageResult<LoginLogDO> page);

    List<LoginLogExcelVO> convertList(List<LoginLogDO> list);

    LoginLogDO convert(LoginLogCreateReqDTO bean);

}
