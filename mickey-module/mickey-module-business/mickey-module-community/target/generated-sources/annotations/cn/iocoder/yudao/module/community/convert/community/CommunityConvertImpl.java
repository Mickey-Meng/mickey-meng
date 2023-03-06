package cn.iocoder.yudao.module.community.convert.community;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.community.controller.admin.community.vo.CommunityCreateReqVO;
import cn.iocoder.yudao.module.community.controller.admin.community.vo.CommunityExcelVO;
import cn.iocoder.yudao.module.community.controller.admin.community.vo.CommunityRespVO;
import cn.iocoder.yudao.module.community.controller.admin.community.vo.CommunityUpdateReqVO;
import cn.iocoder.yudao.module.community.controller.app.community.vo.AppCommunityRespVO;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-05T17:10:38+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CommunityConvertImpl implements CommunityConvert {

    @Override
    public CommunityDO convert(CommunityCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        CommunityDO.CommunityDOBuilder communityDO = CommunityDO.builder();

        communityDO.communityName( bean.getCommunityName() );
        communityDO.communityCode( bean.getCommunityCode() );
        communityDO.provincesCode( bean.getProvincesCode() );
        communityDO.cityCode( bean.getCityCode() );
        communityDO.districtCode( bean.getDistrictCode() );
        communityDO.townCode( bean.getTownCode() );
        communityDO.detailedAddress( bean.getDetailedAddress() );
        communityDO.longitude( bean.getLongitude() );
        communityDO.latitude( bean.getLatitude() );
        communityDO.propertyId( bean.getPropertyId() );
        communityDO.sort( bean.getSort() );
        communityDO.remark( bean.getRemark() );

        return communityDO.build();
    }

    @Override
    public CommunityDO convert(CommunityUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        CommunityDO.CommunityDOBuilder communityDO = CommunityDO.builder();

        communityDO.id( bean.getId() );
        communityDO.communityName( bean.getCommunityName() );
        communityDO.communityCode( bean.getCommunityCode() );
        communityDO.provincesCode( bean.getProvincesCode() );
        communityDO.cityCode( bean.getCityCode() );
        communityDO.districtCode( bean.getDistrictCode() );
        communityDO.townCode( bean.getTownCode() );
        communityDO.detailedAddress( bean.getDetailedAddress() );
        communityDO.longitude( bean.getLongitude() );
        communityDO.latitude( bean.getLatitude() );
        communityDO.propertyId( bean.getPropertyId() );
        communityDO.sort( bean.getSort() );
        communityDO.remark( bean.getRemark() );

        return communityDO.build();
    }

    @Override
    public CommunityRespVO convert(CommunityDO bean) {
        if ( bean == null ) {
            return null;
        }

        CommunityRespVO communityRespVO = new CommunityRespVO();

        communityRespVO.setCommunityName( bean.getCommunityName() );
        communityRespVO.setCommunityCode( bean.getCommunityCode() );
        communityRespVO.setProvincesCode( bean.getProvincesCode() );
        communityRespVO.setCityCode( bean.getCityCode() );
        communityRespVO.setDistrictCode( bean.getDistrictCode() );
        communityRespVO.setTownCode( bean.getTownCode() );
        communityRespVO.setDetailedAddress( bean.getDetailedAddress() );
        communityRespVO.setLongitude( bean.getLongitude() );
        communityRespVO.setLatitude( bean.getLatitude() );
        communityRespVO.setPropertyId( bean.getPropertyId() );
        communityRespVO.setSort( bean.getSort() );
        communityRespVO.setRemark( bean.getRemark() );
        communityRespVO.setId( bean.getId() );
        communityRespVO.setCreateTime( bean.getCreateTime() );

        return communityRespVO;
    }

    @Override
    public List<CommunityRespVO> convertList(List<CommunityDO> list) {
        if ( list == null ) {
            return null;
        }

        List<CommunityRespVO> list1 = new ArrayList<CommunityRespVO>( list.size() );
        for ( CommunityDO communityDO : list ) {
            list1.add( convert( communityDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<CommunityRespVO> convertPage(PageResult<CommunityDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<CommunityRespVO> pageResult = new PageResult<CommunityRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<CommunityExcelVO> convertList02(List<CommunityDO> list) {
        if ( list == null ) {
            return null;
        }

        List<CommunityExcelVO> list1 = new ArrayList<CommunityExcelVO>( list.size() );
        for ( CommunityDO communityDO : list ) {
            list1.add( communityDOToCommunityExcelVO( communityDO ) );
        }

        return list1;
    }

    @Override
    public List<AppCommunityRespVO> convertAppList(List<CommunityDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppCommunityRespVO> list1 = new ArrayList<AppCommunityRespVO>( list.size() );
        for ( CommunityDO communityDO : list ) {
            list1.add( communityDOToAppCommunityRespVO( communityDO ) );
        }

        return list1;
    }

    protected CommunityExcelVO communityDOToCommunityExcelVO(CommunityDO communityDO) {
        if ( communityDO == null ) {
            return null;
        }

        CommunityExcelVO communityExcelVO = new CommunityExcelVO();

        communityExcelVO.setId( communityDO.getId() );
        communityExcelVO.setCommunityName( communityDO.getCommunityName() );
        communityExcelVO.setCommunityCode( communityDO.getCommunityCode() );
        communityExcelVO.setProvincesCode( communityDO.getProvincesCode() );
        communityExcelVO.setCityCode( communityDO.getCityCode() );
        communityExcelVO.setDistrictCode( communityDO.getDistrictCode() );
        communityExcelVO.setTownCode( communityDO.getTownCode() );
        communityExcelVO.setDetailedAddress( communityDO.getDetailedAddress() );
        communityExcelVO.setLongitude( communityDO.getLongitude() );
        communityExcelVO.setLatitude( communityDO.getLatitude() );
        communityExcelVO.setPropertyId( communityDO.getPropertyId() );
        communityExcelVO.setSort( communityDO.getSort() );
        communityExcelVO.setRemark( communityDO.getRemark() );
        communityExcelVO.setCreateTime( communityDO.getCreateTime() );

        return communityExcelVO;
    }

    protected AppCommunityRespVO communityDOToAppCommunityRespVO(CommunityDO communityDO) {
        if ( communityDO == null ) {
            return null;
        }

        AppCommunityRespVO appCommunityRespVO = new AppCommunityRespVO();

        appCommunityRespVO.setId( communityDO.getId() );
        appCommunityRespVO.setCreateTime( communityDO.getCreateTime() );
        appCommunityRespVO.setCommunityName( communityDO.getCommunityName() );
        appCommunityRespVO.setCommunityCode( communityDO.getCommunityCode() );
        appCommunityRespVO.setProvincesCode( communityDO.getProvincesCode() );
        appCommunityRespVO.setCityCode( communityDO.getCityCode() );
        appCommunityRespVO.setDistrictCode( communityDO.getDistrictCode() );
        appCommunityRespVO.setTownCode( communityDO.getTownCode() );
        appCommunityRespVO.setDetailedAddress( communityDO.getDetailedAddress() );
        appCommunityRespVO.setLongitude( communityDO.getLongitude() );
        appCommunityRespVO.setLatitude( communityDO.getLatitude() );
        appCommunityRespVO.setPropertyId( communityDO.getPropertyId() );
        appCommunityRespVO.setSort( communityDO.getSort() );
        appCommunityRespVO.setRemark( communityDO.getRemark() );

        return appCommunityRespVO;
    }
}
