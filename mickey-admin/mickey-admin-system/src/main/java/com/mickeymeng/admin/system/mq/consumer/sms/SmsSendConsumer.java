package com.mickeymeng.admin.system.mq.consumer.sms;

import com.mickeymeng.framework.middleware.mq.core.stream.AbstractStreamMessageListener;
import com.mickeymeng.admin.system.mq.message.sms.SmsSendMessage;
import com.mickeymeng.admin.system.service.sms.SmsSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link SmsSendMessage} 的消费者
 *
 * @author zzf
 */
@Component
@Slf4j
public class SmsSendConsumer extends AbstractStreamMessageListener<SmsSendMessage> {

    @Resource
    private SmsSendService smsSendService;

    @Override
    public void onMessage(SmsSendMessage message) {
        log.info("[onMessage][消息内容({})]", message);
        smsSendService.doSendSms(message);
    }

}
