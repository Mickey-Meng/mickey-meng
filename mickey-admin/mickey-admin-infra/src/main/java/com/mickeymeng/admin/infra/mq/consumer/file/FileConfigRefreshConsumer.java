package com.mickeymeng.admin.infra.mq.consumer.file;

import com.mickeymeng.admin.infra.mq.message.file.FileConfigRefreshMessage;
import com.mickeymeng.admin.infra.service.file.FileConfigService;
import com.mickeymeng.framework.middleware.mq.core.pubsub.AbstractChannelMessageListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link FileConfigRefreshMessage} 的消费者
 *
 * @author 芋道源码
 */
@Component
@Slf4j
public class FileConfigRefreshConsumer extends AbstractChannelMessageListener<FileConfigRefreshMessage> {

    @Resource
    private FileConfigService fileConfigService;

    @Override
    public void onMessage(FileConfigRefreshMessage message) {
        log.info("[onMessage][收到 FileConfig 刷新消息]");
        fileConfigService.initFileClients();
    }

}
