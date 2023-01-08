package com.mickeymeng.framework.common.service.dto.sms.code;

import com.mickeymeng.framework.common.enums.sms.SmsSceneEnum;
import com.mickeymeng.framework.common.validation.InEnum;
import com.mickeymeng.framework.common.validation.Mobile;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 短信验证码的发送 Request DTO
 *
 * @author 芋道源码
 */
@Data
@Accessors(chain = true)
public class SmsCodeSendReqDTO {

    /**
     * 手机号
     */
    @Mobile
    @NotEmpty(message = "手机号不能为空")
    private String mobile;
    /**
     * 发送场景
     */
    @NotNull(message = "发送场景不能为空")
    @InEnum(SmsSceneEnum.class)
    private Integer scene;
    /**
     * 发送 IP
     */
    @NotEmpty(message = "发送 IP 不能为空")
    private String createIp;

}
