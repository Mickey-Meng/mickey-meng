package com.mickeymeng.framework.middleware.file.config;

import com.mickeymeng.framework.middleware.file.core.client.FileClientFactory;
import com.mickeymeng.framework.middleware.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 *
 * @author
 */
@AutoConfiguration
public class  FileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
