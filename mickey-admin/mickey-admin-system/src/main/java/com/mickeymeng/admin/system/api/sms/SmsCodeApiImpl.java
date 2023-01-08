package com.mickeymeng.admin.system.api.sms;

import com.mickeymeng.framework.common.service.dto.sms.code.SmsCodeCheckReqDTO;
import com.mickeymeng.framework.common.service.dto.sms.code.SmsCodeSendReqDTO;
import com.mickeymeng.framework.common.service.dto.sms.code.SmsCodeUseReqDTO;
import com.mickeymeng.admin.system.service.sms.SmsCodeService;
import com.mickeymeng.framework.common.service.api.SmsCodeApi;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 短信验证码 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SmsCodeApiImpl implements SmsCodeApi {

    @Resource
    private SmsCodeService smsCodeService;

    @Override
    public void sendSmsCode(SmsCodeSendReqDTO reqDTO) {
        smsCodeService.sendSmsCode(reqDTO);
    }

    @Override
    public void useSmsCode(SmsCodeUseReqDTO reqDTO) {
        smsCodeService.useSmsCode(reqDTO);
    }

    @Override
    public void checkSmsCode(SmsCodeCheckReqDTO reqDTO) {
        smsCodeService.checkSmsCode(reqDTO);
    }

}
