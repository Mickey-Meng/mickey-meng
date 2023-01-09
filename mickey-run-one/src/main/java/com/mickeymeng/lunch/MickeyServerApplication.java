package com.mickeymeng.lunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${mickey.info.base-package}
//@SpringBootApplication(scanBasePackages = {"${mickey.info.base-package}.lunch", "${mickey.info.base-package}.module"})
public class MickeyServerApplication implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        /**
         * 所有请求都允许跨域，使用这种配置就不需要
         * 在interceptor中配置header了
         */
        corsRegistry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }

    public static void main(String[] args) {
        //SpringApplication.run(MickeyServerApplication.class, args);
        SpringApplication springApplication = new SpringApplication(MickeyServerApplication.class);
        springApplication.setAllowCircularReferences(Boolean.TRUE);
        springApplication.run(args);
    }
}
