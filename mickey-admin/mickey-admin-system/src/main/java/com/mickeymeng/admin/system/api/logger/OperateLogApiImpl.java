package com.mickeymeng.admin.system.api.logger;

import com.mickeymeng.framework.common.service.dto.OperateLogCreateReqDTO;
import com.mickeymeng.admin.system.service.logger.OperateLogService;
import com.mickeymeng.framework.common.service.api.OperateLogApi;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 操作日志 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
    }

}
