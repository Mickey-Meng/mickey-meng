package com.mickeymeng.framework.assistant.apilog.core.service;

import cn.hutool.core.bean.BeanUtil;
import com.mickeymeng.framework.common.pojo.ApiErrorLog;
import com.mickeymeng.framework.common.service.api.ApiErrorLogApi;
import com.mickeymeng.framework.common.service.api.ApiErrorLogFrameworkService;
import com.mickeymeng.framework.common.service.dto.ApiErrorLogCreateReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * API 错误日志 Framework Service 实现类
 *
 * 基于 {@link ApiErrorLogApi} 服务，记录错误日志
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
public class ApiErrorLogFrameworkServiceImpl implements ApiErrorLogFrameworkService {

    private final ApiErrorLogApi apiErrorLogApi;

    @Override
    @Async
    public void createApiErrorLog(ApiErrorLog apiErrorLog) {
        ApiErrorLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiErrorLog, ApiErrorLogCreateReqDTO.class);
        apiErrorLogApi.createApiErrorLog(reqDTO);
    }

}
