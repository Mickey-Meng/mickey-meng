package com.mickeymeng.admin.system.mq.consumer.auth;

import com.mickeymeng.framework.middleware.mq.core.pubsub.AbstractChannelMessageListener;
import com.mickeymeng.framework.middleware.mq.core.pubsub.AbstractChannelMessageListener;
import com.mickeymeng.admin.system.mq.message.auth.OAuth2ClientRefreshMessage;
import com.mickeymeng.admin.system.service.oauth2.OAuth2ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link OAuth2ClientRefreshMessage} 的消费者
 *
 * @author 芋道源码
 */
@Component
@Slf4j
public class OAuth2ClientRefreshConsumer extends AbstractChannelMessageListener<OAuth2ClientRefreshMessage> {

    @Resource
    private OAuth2ClientService oauth2ClientService;

    @Override
    public void onMessage(OAuth2ClientRefreshMessage message) {
        log.info("[onMessage][收到 OAuth2Client 刷新消息]");
        oauth2ClientService.initLocalCache();
    }

}
