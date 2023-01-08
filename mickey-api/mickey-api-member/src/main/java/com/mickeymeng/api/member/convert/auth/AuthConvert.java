package com.mickeymeng.api.member.convert.auth;

import com.mickeymeng.api.member.controller.app.auth.vo.*;
import com.mickeymeng.api.member.controller.app.social.vo.AppSocialUserUnbindReqVO;
import com.mickeymeng.framework.common.enums.sms.SmsSceneEnum;
import com.mickeymeng.framework.common.service.dto.OAuth2AccessTokenRespDTO;
import com.mickeymeng.framework.common.service.dto.SocialUserBindReqDTO;
import com.mickeymeng.framework.common.service.dto.SocialUserUnbindReqDTO;
import com.mickeymeng.framework.common.service.dto.sms.code.SmsCodeSendReqDTO;
import com.mickeymeng.framework.common.service.dto.sms.code.SmsCodeUseReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthConvert {

    AuthConvert INSTANCE = Mappers.getMapper(AuthConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, AppAuthSocialLoginReqVO reqVO);
    SocialUserUnbindReqDTO convert(Long userId, Integer userType, AppSocialUserUnbindReqVO reqVO);

    SmsCodeSendReqDTO convert(AppAuthSmsSendReqVO reqVO);
    SmsCodeUseReqDTO convert(AppAuthResetPasswordReqVO reqVO, SmsSceneEnum scene, String usedIp);
    SmsCodeUseReqDTO convert(AppAuthSmsLoginReqVO reqVO, Integer scene, String usedIp);

    AppAuthLoginRespVO convert(OAuth2AccessTokenRespDTO bean);

}
