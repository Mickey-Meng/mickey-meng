package cn.iocoder.yudao.module.infra.mq.message.file;

import cn.iocoder.yudao.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件配置数据刷新 Message
 */
@Data
@Accessors(chain = true)
public class FileConfigRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "infra.file-config.refresh";
    }

}
