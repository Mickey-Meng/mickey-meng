package cn.iocoder.yudao.module.community.convert.user;

import cn.iocoder.yudao.module.community.controller.app.user.vo.AppUserInfoRespVO;
import cn.iocoder.yudao.module.community.dal.dataobject.user.CommunityUserDO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-05T17:10:38+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public AppUserInfoRespVO convert(CommunityUserDO bean) {
        if ( bean == null ) {
            return null;
        }

        AppUserInfoRespVO appUserInfoRespVO = new AppUserInfoRespVO();

        appUserInfoRespVO.setNickname( bean.getNickname() );
        appUserInfoRespVO.setRealName( bean.getRealName() );
        appUserInfoRespVO.setGender( bean.getGender() );
        appUserInfoRespVO.setIdCardNumber( bean.getIdCardNumber() );
        appUserInfoRespVO.setPhoneNumber( bean.getPhoneNumber() );
        appUserInfoRespVO.setWechatId( bean.getWechatId() );
        appUserInfoRespVO.setQqNumber( bean.getQqNumber() );
        appUserInfoRespVO.setEmail( bean.getEmail() );
        appUserInfoRespVO.setBirthday( bean.getBirthday() );
        appUserInfoRespVO.setPortrait( bean.getPortrait() );
        appUserInfoRespVO.setSignature( bean.getSignature() );
        appUserInfoRespVO.setLogonMode( bean.getLogonMode() );
        appUserInfoRespVO.setOwnerType( bean.getOwnerType() );
        appUserInfoRespVO.setRegisterIp( bean.getRegisterIp() );
        appUserInfoRespVO.setLoginIp( bean.getLoginIp() );
        appUserInfoRespVO.setLoginDate( bean.getLoginDate() );
        appUserInfoRespVO.setAuthenticated( bean.getAuthenticated() );

        return appUserInfoRespVO;
    }
}
