package cn.iocoder.yudao.framework.errorcode.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 错误码的配置属性类
 *
 * @author dlyan
 */
@ConfigurationProperties("yudao.error-code")
@Data
@Accessors(chain = true)
@Validated
public class ErrorCodeProperties {

    /**
     * 是否开启
     */
    private Boolean enable = true;
    /**
     * 错误码枚举类
     */
    @NotNull(message = "错误码枚举类不能为空")
    private List<String> constantsClassList;

}
