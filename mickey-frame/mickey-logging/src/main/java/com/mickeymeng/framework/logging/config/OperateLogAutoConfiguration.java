package com.mickeymeng.framework.logging.config;

import com.mickeymeng.framework.common.service.api.OperateLogApi;
import com.mickeymeng.framework.logging.core.aop.OperateLogAspect;
import com.mickeymeng.framework.logging.core.service.OperateLogFrameworkService;
import com.mickeymeng.framework.logging.core.service.OperateLogFrameworkServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class OperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
