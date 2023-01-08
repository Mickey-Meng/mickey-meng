package com.mickeymeng.admin.system.mq.producer.sensitiveword;

import com.mickeymeng.framework.middleware.mq.core.RedisMQTemplate;
import com.mickeymeng.admin.system.mq.message.sensitiveword.SensitiveWordRefreshMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 敏感词相关的 Producer
 */
@Component
public class SensitiveWordProducer {

    @Resource
    private RedisMQTemplate redisMQTemplate;

    /**
     * 发送 {@link SensitiveWordRefreshMessage} 消息
     */
    public void sendSensitiveWordRefreshMessage() {
        SensitiveWordRefreshMessage message = new SensitiveWordRefreshMessage();
        redisMQTemplate.send(message);
    }

}
