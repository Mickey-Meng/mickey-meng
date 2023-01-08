package com.mickeymeng.framework.assistant.apilog.config;

import com.mickeymeng.framework.assistant.apilog.core.filter.ApiAccessLogFilter;
import com.mickeymeng.framework.common.service.api.ApiAccessLogFrameworkService;
import com.mickeymeng.framework.assistant.apilog.core.service.ApiAccessLogFrameworkServiceImpl;
import com.mickeymeng.framework.common.service.api.ApiErrorLogFrameworkService;
import com.mickeymeng.framework.assistant.apilog.core.service.ApiErrorLogFrameworkServiceImpl;
import com.mickeymeng.framework.assistant.web.config.MickeyWebAutoConfiguration;
import com.mickeymeng.framework.common.enums.WebFilterOrderEnum;
import com.mickeymeng.framework.common.core.config.WebProperties;
import com.mickeymeng.framework.common.service.api.ApiAccessLogApi;
import com.mickeymeng.framework.common.service.api.ApiErrorLogApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@AutoConfiguration(after = MickeyWebAutoConfiguration.class)
public class  ApiLogAutoConfiguration {

    @Bean
    public ApiAccessLogFrameworkService apiAccessLogFrameworkService(ApiAccessLogApi apiAccessLogApi) {
        return new ApiAccessLogFrameworkServiceImpl(apiAccessLogApi);
    }

    @Bean
    public ApiErrorLogFrameworkService apiErrorLogFrameworkService(ApiErrorLogApi apiErrorLogApi) {
        return new ApiErrorLogFrameworkServiceImpl(apiErrorLogApi);
    }

    /**
     * 创建 ApiAccessLogFilter Bean，记录 API 请求日志
     */
    @Bean
    @ConditionalOnProperty(prefix = "mickey.access-log", value = "enable", matchIfMissing = true) // 允许使用 yudao.access-log.enable=false 禁用访问日志
    public FilterRegistrationBean<ApiAccessLogFilter> apiAccessLogFilter(WebProperties webProperties,
                                                                         @Value("${spring.application.name}") String applicationName,
                                                                         ApiAccessLogFrameworkService apiAccessLogFrameworkService) {
        ApiAccessLogFilter filter = new ApiAccessLogFilter(webProperties, applicationName, apiAccessLogFrameworkService);
        return createFilterBean(filter, WebFilterOrderEnum.API_ACCESS_LOG_FILTER);
    }

    private static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }

}
