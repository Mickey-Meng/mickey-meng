package com.mickeymeng.admin.system.mq.consumer.permission;

import com.mickeymeng.framework.middleware.mq.core.pubsub.AbstractChannelMessageListener;
import com.mickeymeng.admin.system.mq.message.permission.RoleRefreshMessage;
import com.mickeymeng.admin.system.service.permission.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link RoleRefreshMessage} 的消费者
 *
 * @author 芋道源码
 */
@Component
@Slf4j
public class RoleRefreshConsumer extends AbstractChannelMessageListener<RoleRefreshMessage> {

    @Resource
    private RoleService roleService;

    @Override
    public void onMessage(RoleRefreshMessage message) {
        log.info("[onMessage][收到 Role 刷新消息]");
        roleService.initLocalCache();
    }

}