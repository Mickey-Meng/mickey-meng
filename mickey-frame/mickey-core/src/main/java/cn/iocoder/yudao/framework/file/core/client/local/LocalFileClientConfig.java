package cn.iocoder.yudao.framework.file.core.client.local;

import cn.iocoder.yudao.framework.file.core.client.FileClientConfig;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

/**
 * 本地文件客户端的配置类
 *
 * @author 芋道源码
 */
@Data
@Accessors(chain = true)
public class LocalFileClientConfig implements FileClientConfig {

    /**
     * 基础路径
     */
    @NotEmpty(message = "基础路径不能为空")
    private String basePath;

    /**
     * 自定义域名
     */
    @NotEmpty(message = "domain 不能为空")
    @URL(message = "domain 必须是 URL 格式")
    private String domain;

}
