package com.mickeymeng.framework.middleware.protection.idempotent.config;

import com.mickeymeng.framework.middleware.protection.idempotent.core.aop.IdempotentAspect;
import com.mickeymeng.framework.middleware.protection.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.mickeymeng.framework.middleware.protection.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.mickeymeng.framework.middleware.protection.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.mickeymeng.framework.middleware.protection.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = RedisAutoConfiguration.class)
public class  IdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
