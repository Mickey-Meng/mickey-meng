package com.mickeymeng.framework.middleware.monitor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * BizTracer配置类
 *
 * @author 麻薯
 */
@ConfigurationProperties("mickey.tracer")
@Data
public class TracerProperties {
}
