package com.mickeymeng.admin.infra.mq.message.file;

import com.mickeymeng.framework.middleware.mq.core.pubsub.AbstractChannelMessage;

import lombok.Data;

/**
 * 文件配置数据刷新 Message
 */
@Data
public class FileConfigRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "infra.file-config.refresh";
    }

}
