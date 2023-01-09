package cn.iocoder.yudao.module.system.mq.message.dept;

import cn.iocoder.yudao.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;

/**
 * 部门数据刷新 Message
 *
 * @author 芋道源码
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DeptRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.dept.refresh";
    }

}
