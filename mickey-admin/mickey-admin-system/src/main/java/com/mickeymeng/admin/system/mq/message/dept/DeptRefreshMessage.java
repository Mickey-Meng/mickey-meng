package com.mickeymeng.admin.system.mq.message.dept;

import com.mickeymeng.framework.middleware.mq.core.pubsub.AbstractChannelMessage;
import com.mickeymeng.framework.middleware.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门数据刷新 Message
 *
 * @author 芋道源码
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.dept.refresh";
    }

}
