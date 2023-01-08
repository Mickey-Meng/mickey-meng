package com.mickeymeng.admin.system.api.logger;

import com.mickeymeng.framework.common.service.dto.LoginLogCreateReqDTO;
import com.mickeymeng.admin.system.service.logger.LoginLogService;
import com.mickeymeng.framework.common.service.api.LoginLogApi;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 登录日志的 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class LoginLogApiImpl implements LoginLogApi {

    @Resource
    private LoginLogService loginLogService;

    @Override
    public void createLoginLog(LoginLogCreateReqDTO reqDTO) {
        loginLogService.createLoginLog(reqDTO);
    }

}
