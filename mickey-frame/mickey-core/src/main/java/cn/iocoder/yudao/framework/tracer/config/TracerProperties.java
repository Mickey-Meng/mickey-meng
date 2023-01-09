package cn.iocoder.yudao.framework.tracer.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * BizTracer配置类
 *
 * @author 麻薯
 */
@ConfigurationProperties("mickey.tracer")
@Data
@Accessors(chain = true)
public class TracerProperties {
}
