package cn.iocoder.yudao.module.community.convert.address;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.community.controller.app.address.vo.AppAddressCreateReqVO;
import cn.iocoder.yudao.module.community.controller.app.address.vo.AppAddressRespVO;
import cn.iocoder.yudao.module.community.controller.app.address.vo.AppAddressUpdateReqVO;
import cn.iocoder.yudao.module.community.dal.dataobject.address.AddressDO;
import cn.iocoder.yudao.module.member.api.address.dto.AddressRespDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-05T17:10:38+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class AddressConvertImpl implements AddressConvert {

    @Override
    public AddressDO convert(AppAddressCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        AddressDO.AddressDOBuilder addressDO = AddressDO.builder();

        addressDO.areaId( bean.getAreaId() );
        addressDO.postCode( bean.getPostCode() );
        addressDO.defaulted( bean.getDefaulted() );

        return addressDO.build();
    }

    @Override
    public AddressDO convert(AppAddressUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        AddressDO.AddressDOBuilder addressDO = AddressDO.builder();

        addressDO.id( bean.getId() );
        addressDO.areaId( bean.getAreaId() );
        addressDO.postCode( bean.getPostCode() );
        addressDO.defaulted( bean.getDefaulted() );

        return addressDO.build();
    }

    @Override
    public AppAddressRespVO convert(AddressDO bean) {
        if ( bean == null ) {
            return null;
        }

        AppAddressRespVO appAddressRespVO = new AppAddressRespVO();

        appAddressRespVO.setAreaId( bean.getAreaId() );
        appAddressRespVO.setPostCode( bean.getPostCode() );
        appAddressRespVO.setDefaulted( bean.getDefaulted() );
        appAddressRespVO.setId( bean.getId() );
        appAddressRespVO.setCreateTime( bean.getCreateTime() );

        return appAddressRespVO;
    }

    @Override
    public List<AppAddressRespVO> convertList(List<AddressDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppAddressRespVO> list1 = new ArrayList<AppAddressRespVO>( list.size() );
        for ( AddressDO addressDO : list ) {
            list1.add( convert( addressDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<AppAddressRespVO> convertPage(PageResult<AddressDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<AppAddressRespVO> pageResult = new PageResult<AppAddressRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public AddressRespDTO convert02(AddressDO bean) {
        if ( bean == null ) {
            return null;
        }

        AddressRespDTO addressRespDTO = new AddressRespDTO();

        addressRespDTO.setId( bean.getId() );
        addressRespDTO.setAreaId( bean.getAreaId() );
        addressRespDTO.setPostCode( bean.getPostCode() );
        addressRespDTO.setDefaulted( bean.getDefaulted() );

        return addressRespDTO;
    }
}
