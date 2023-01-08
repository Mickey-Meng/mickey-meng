package com.mickeymeng.api.member.convert.social;

import com.mickeymeng.api.member.controller.app.social.vo.AppSocialUserBindReqVO;
import com.mickeymeng.api.member.controller.app.social.vo.AppSocialUserUnbindReqVO;
import com.mickeymeng.framework.common.service.dto.SocialUserBindReqDTO;
import com.mickeymeng.framework.common.service.dto.SocialUserUnbindReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialUserConvert {

    SocialUserConvert INSTANCE = Mappers.getMapper(SocialUserConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, AppSocialUserBindReqVO reqVO);

    SocialUserUnbindReqDTO convert(Long userId, Integer userType, AppSocialUserUnbindReqVO reqVO);

}
