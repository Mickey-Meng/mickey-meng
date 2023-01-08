package com.mickeymeng.framework.middleware.sms.config;

import com.mickeymeng.framework.middleware.sms.core.client.SmsClientFactory;
import com.mickeymeng.framework.middleware.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 短信配置类
 *
 * @author 芋道源码
 */
@AutoConfiguration
public class  SmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
