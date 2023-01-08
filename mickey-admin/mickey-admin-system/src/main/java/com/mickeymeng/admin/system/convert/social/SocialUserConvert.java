package com.mickeymeng.admin.system.convert.social;

import com.mickeymeng.framework.common.service.dto.SocialUserBindReqDTO;
import com.mickeymeng.framework.common.service.dto.SocialUserUnbindReqDTO;
import com.mickeymeng.admin.system.controller.admin.socail.vo.SocialUserBindReqVO;
import com.mickeymeng.admin.system.controller.admin.socail.vo.SocialUserUnbindReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialUserConvert {

    SocialUserConvert INSTANCE = Mappers.getMapper(SocialUserConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, SocialUserBindReqVO reqVO);

    SocialUserUnbindReqDTO convert(Long userId, Integer userType, SocialUserUnbindReqVO reqVO);

}
