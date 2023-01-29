package cn.iocoder.yudao.module.community.convert.user;

import cn.iocoder.yudao.module.community.controller.app.user.vo.AppUserInfoRespVO;
import cn.iocoder.yudao.module.community.dal.dataobject.user.CommunityUserDO;
import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    AppUserInfoRespVO convert(CommunityUserDO bean);

}
