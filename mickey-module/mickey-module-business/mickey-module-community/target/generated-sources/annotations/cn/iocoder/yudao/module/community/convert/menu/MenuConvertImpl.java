package cn.iocoder.yudao.module.community.convert.menu;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.community.controller.admin.menu.vo.MenuCreateReqVO;
import cn.iocoder.yudao.module.community.controller.admin.menu.vo.MenuExcelVO;
import cn.iocoder.yudao.module.community.controller.admin.menu.vo.MenuRespVO;
import cn.iocoder.yudao.module.community.controller.admin.menu.vo.MenuUpdateReqVO;
import cn.iocoder.yudao.module.community.controller.app.menu.vo.AppMenuRespVO;
import cn.iocoder.yudao.module.community.dal.dataobject.menu.CommunityMenuDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-27T18:19:09+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class MenuConvertImpl implements MenuConvert {

    @Override
    public CommunityMenuDO convert(MenuCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        CommunityMenuDO.CommunityMenuDOBuilder communityMenuDO = CommunityMenuDO.builder();

        communityMenuDO.menuZhName( bean.getMenuZhName() );
        communityMenuDO.menuEnName( bean.getMenuEnName() );
        communityMenuDO.menuIcon( bean.getMenuIcon() );
        communityMenuDO.iconStyle( bean.getIconStyle() );
        communityMenuDO.routePath( bean.getRoutePath() );
        communityMenuDO.status( bean.getStatus() );
        communityMenuDO.keepAlive( bean.getKeepAlive() );
        communityMenuDO.sort( bean.getSort() );

        return communityMenuDO.build();
    }

    @Override
    public CommunityMenuDO convert(MenuUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        CommunityMenuDO.CommunityMenuDOBuilder communityMenuDO = CommunityMenuDO.builder();

        communityMenuDO.id( bean.getId() );
        communityMenuDO.menuZhName( bean.getMenuZhName() );
        communityMenuDO.menuEnName( bean.getMenuEnName() );
        communityMenuDO.menuIcon( bean.getMenuIcon() );
        communityMenuDO.iconStyle( bean.getIconStyle() );
        communityMenuDO.routePath( bean.getRoutePath() );
        communityMenuDO.status( bean.getStatus() );
        communityMenuDO.keepAlive( bean.getKeepAlive() );
        communityMenuDO.sort( bean.getSort() );

        return communityMenuDO.build();
    }

    @Override
    public MenuRespVO convert(CommunityMenuDO bean) {
        if ( bean == null ) {
            return null;
        }

        MenuRespVO menuRespVO = new MenuRespVO();

        menuRespVO.setMenuZhName( bean.getMenuZhName() );
        menuRespVO.setMenuEnName( bean.getMenuEnName() );
        menuRespVO.setMenuIcon( bean.getMenuIcon() );
        menuRespVO.setIconStyle( bean.getIconStyle() );
        menuRespVO.setRoutePath( bean.getRoutePath() );
        menuRespVO.setStatus( bean.getStatus() );
        menuRespVO.setKeepAlive( bean.getKeepAlive() );
        menuRespVO.setSort( bean.getSort() );
        menuRespVO.setId( bean.getId() );
        menuRespVO.setCreateTime( bean.getCreateTime() );

        return menuRespVO;
    }

    @Override
    public List<MenuRespVO> convertList(List<CommunityMenuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MenuRespVO> list1 = new ArrayList<MenuRespVO>( list.size() );
        for ( CommunityMenuDO communityMenuDO : list ) {
            list1.add( convert( communityMenuDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<MenuRespVO> convertPage(PageResult<CommunityMenuDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<MenuRespVO> pageResult = new PageResult<MenuRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<MenuExcelVO> convertList02(List<CommunityMenuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MenuExcelVO> list1 = new ArrayList<MenuExcelVO>( list.size() );
        for ( CommunityMenuDO communityMenuDO : list ) {
            list1.add( communityMenuDOToMenuExcelVO( communityMenuDO ) );
        }

        return list1;
    }

    @Override
    public List<AppMenuRespVO> convertAppList(List<CommunityMenuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppMenuRespVO> list1 = new ArrayList<AppMenuRespVO>( list.size() );
        for ( CommunityMenuDO communityMenuDO : list ) {
            list1.add( communityMenuDOToAppMenuRespVO( communityMenuDO ) );
        }

        return list1;
    }

    protected MenuExcelVO communityMenuDOToMenuExcelVO(CommunityMenuDO communityMenuDO) {
        if ( communityMenuDO == null ) {
            return null;
        }

        MenuExcelVO menuExcelVO = new MenuExcelVO();

        menuExcelVO.setId( communityMenuDO.getId() );
        menuExcelVO.setMenuZhName( communityMenuDO.getMenuZhName() );
        menuExcelVO.setMenuEnName( communityMenuDO.getMenuEnName() );
        menuExcelVO.setMenuIcon( communityMenuDO.getMenuIcon() );
        menuExcelVO.setIconStyle( communityMenuDO.getIconStyle() );
        menuExcelVO.setRoutePath( communityMenuDO.getRoutePath() );
        menuExcelVO.setStatus( communityMenuDO.getStatus() );
        menuExcelVO.setKeepAlive( communityMenuDO.getKeepAlive() );
        menuExcelVO.setSort( communityMenuDO.getSort() );
        menuExcelVO.setCreateTime( communityMenuDO.getCreateTime() );

        return menuExcelVO;
    }

    protected AppMenuRespVO communityMenuDOToAppMenuRespVO(CommunityMenuDO communityMenuDO) {
        if ( communityMenuDO == null ) {
            return null;
        }

        AppMenuRespVO appMenuRespVO = new AppMenuRespVO();

        appMenuRespVO.setMenuZhName( communityMenuDO.getMenuZhName() );
        appMenuRespVO.setMenuEnName( communityMenuDO.getMenuEnName() );
        appMenuRespVO.setMenuIcon( communityMenuDO.getMenuIcon() );
        appMenuRespVO.setIconStyle( communityMenuDO.getIconStyle() );
        appMenuRespVO.setRoutePath( communityMenuDO.getRoutePath() );
        appMenuRespVO.setStatus( communityMenuDO.getStatus() );
        appMenuRespVO.setKeepAlive( communityMenuDO.getKeepAlive() );
        appMenuRespVO.setSort( communityMenuDO.getSort() );
        appMenuRespVO.setId( communityMenuDO.getId() );
        appMenuRespVO.setCreateTime( communityMenuDO.getCreateTime() );

        return appMenuRespVO;
    }
}
