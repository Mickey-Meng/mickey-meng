package cn.iocoder.yudao.module.community.convert.owner;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.community.controller.admin.owner.vo.OwnerCreateReqVO;
import cn.iocoder.yudao.module.community.controller.admin.owner.vo.OwnerExcelVO;
import cn.iocoder.yudao.module.community.controller.admin.owner.vo.OwnerRespVO;
import cn.iocoder.yudao.module.community.controller.admin.owner.vo.OwnerUpdateReqVO;
import cn.iocoder.yudao.module.community.dal.dataobject.owner.OwnerDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-27T18:19:09+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class OwnerConvertImpl implements OwnerConvert {

    @Override
    public OwnerDO convert(OwnerCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        OwnerDO.OwnerDOBuilder ownerDO = OwnerDO.builder();

        ownerDO.nickname( bean.getNickname() );
        ownerDO.realName( bean.getRealName() );
        ownerDO.age( bean.getAge() );
        ownerDO.gender( bean.getGender() );
        ownerDO.idCardNumber( bean.getIdCardNumber() );
        ownerDO.phoneNumber( bean.getPhoneNumber() );
        ownerDO.wechatId( bean.getWechatId() );
        ownerDO.qqNumber( bean.getQqNumber() );
        ownerDO.email( bean.getEmail() );
        ownerDO.birthday( bean.getBirthday() );
        ownerDO.portrait( bean.getPortrait() );
        ownerDO.signature( bean.getSignature() );
        ownerDO.status( bean.getStatus() );
        ownerDO.logonMode( bean.getLogonMode() );
        ownerDO.ownerType( bean.getOwnerType() );
        ownerDO.password( bean.getPassword() );
        ownerDO.sort( bean.getSort() );
        ownerDO.remark( bean.getRemark() );

        return ownerDO.build();
    }

    @Override
    public OwnerDO convert(OwnerUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        OwnerDO.OwnerDOBuilder ownerDO = OwnerDO.builder();

        ownerDO.id( bean.getId() );
        ownerDO.nickname( bean.getNickname() );
        ownerDO.realName( bean.getRealName() );
        ownerDO.age( bean.getAge() );
        ownerDO.gender( bean.getGender() );
        ownerDO.idCardNumber( bean.getIdCardNumber() );
        ownerDO.phoneNumber( bean.getPhoneNumber() );
        ownerDO.wechatId( bean.getWechatId() );
        ownerDO.qqNumber( bean.getQqNumber() );
        ownerDO.email( bean.getEmail() );
        ownerDO.birthday( bean.getBirthday() );
        ownerDO.portrait( bean.getPortrait() );
        ownerDO.signature( bean.getSignature() );
        ownerDO.status( bean.getStatus() );
        ownerDO.logonMode( bean.getLogonMode() );
        ownerDO.ownerType( bean.getOwnerType() );
        ownerDO.password( bean.getPassword() );
        ownerDO.sort( bean.getSort() );
        ownerDO.remark( bean.getRemark() );

        return ownerDO.build();
    }

    @Override
    public OwnerRespVO convert(OwnerDO bean) {
        if ( bean == null ) {
            return null;
        }

        OwnerRespVO ownerRespVO = new OwnerRespVO();

        ownerRespVO.setNickname( bean.getNickname() );
        ownerRespVO.setRealName( bean.getRealName() );
        ownerRespVO.setAge( bean.getAge() );
        ownerRespVO.setGender( bean.getGender() );
        ownerRespVO.setIdCardNumber( bean.getIdCardNumber() );
        ownerRespVO.setPhoneNumber( bean.getPhoneNumber() );
        ownerRespVO.setWechatId( bean.getWechatId() );
        ownerRespVO.setQqNumber( bean.getQqNumber() );
        ownerRespVO.setEmail( bean.getEmail() );
        ownerRespVO.setBirthday( bean.getBirthday() );
        ownerRespVO.setPortrait( bean.getPortrait() );
        ownerRespVO.setSignature( bean.getSignature() );
        ownerRespVO.setStatus( bean.getStatus() );
        ownerRespVO.setLogonMode( bean.getLogonMode() );
        ownerRespVO.setOwnerType( bean.getOwnerType() );
        ownerRespVO.setPassword( bean.getPassword() );
        ownerRespVO.setSort( bean.getSort() );
        ownerRespVO.setRemark( bean.getRemark() );
        if ( bean.getId() != null ) {
            ownerRespVO.setId( bean.getId().intValue() );
        }
        ownerRespVO.setCreateTime( bean.getCreateTime() );

        return ownerRespVO;
    }

    @Override
    public List<OwnerRespVO> convertList(List<OwnerDO> list) {
        if ( list == null ) {
            return null;
        }

        List<OwnerRespVO> list1 = new ArrayList<OwnerRespVO>( list.size() );
        for ( OwnerDO ownerDO : list ) {
            list1.add( convert( ownerDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<OwnerRespVO> convertPage(PageResult<OwnerDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<OwnerRespVO> pageResult = new PageResult<OwnerRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<OwnerExcelVO> convertList02(List<OwnerDO> list) {
        if ( list == null ) {
            return null;
        }

        List<OwnerExcelVO> list1 = new ArrayList<OwnerExcelVO>( list.size() );
        for ( OwnerDO ownerDO : list ) {
            list1.add( ownerDOToOwnerExcelVO( ownerDO ) );
        }

        return list1;
    }

    protected OwnerExcelVO ownerDOToOwnerExcelVO(OwnerDO ownerDO) {
        if ( ownerDO == null ) {
            return null;
        }

        OwnerExcelVO ownerExcelVO = new OwnerExcelVO();

        if ( ownerDO.getId() != null ) {
            ownerExcelVO.setId( ownerDO.getId().intValue() );
        }
        ownerExcelVO.setNickname( ownerDO.getNickname() );
        ownerExcelVO.setRealName( ownerDO.getRealName() );
        ownerExcelVO.setAge( ownerDO.getAge() );
        ownerExcelVO.setGender( ownerDO.getGender() );
        ownerExcelVO.setIdCardNumber( ownerDO.getIdCardNumber() );
        ownerExcelVO.setPhoneNumber( ownerDO.getPhoneNumber() );
        ownerExcelVO.setWechatId( ownerDO.getWechatId() );
        ownerExcelVO.setQqNumber( ownerDO.getQqNumber() );
        ownerExcelVO.setEmail( ownerDO.getEmail() );
        ownerExcelVO.setBirthday( ownerDO.getBirthday() );
        ownerExcelVO.setPortrait( ownerDO.getPortrait() );
        ownerExcelVO.setSignature( ownerDO.getSignature() );
        ownerExcelVO.setStatus( ownerDO.getStatus() );
        ownerExcelVO.setLogonMode( ownerDO.getLogonMode() );
        ownerExcelVO.setOwnerType( ownerDO.getOwnerType() );
        ownerExcelVO.setPassword( ownerDO.getPassword() );
        ownerExcelVO.setSort( ownerDO.getSort() );
        ownerExcelVO.setRemark( ownerDO.getRemark() );
        ownerExcelVO.setCreateTime( ownerDO.getCreateTime() );

        return ownerExcelVO;
    }
}
