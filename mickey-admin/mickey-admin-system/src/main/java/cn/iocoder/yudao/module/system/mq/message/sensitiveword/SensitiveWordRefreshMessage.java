package cn.iocoder.yudao.module.system.mq.message.sensitiveword;

import cn.iocoder.yudao.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;

/**
 * 敏感词的刷新 Message
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SensitiveWordRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.sensitive-word.refresh";
    }

}
