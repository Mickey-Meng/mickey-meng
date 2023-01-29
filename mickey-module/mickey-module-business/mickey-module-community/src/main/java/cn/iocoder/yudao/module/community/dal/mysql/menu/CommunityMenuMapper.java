package cn.iocoder.yudao.module.community.dal.mysql.menu;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.community.dal.dataobject.menu.CommunityMenuDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.community.controller.admin.menu.vo.*;

/**
 * 服务列表菜单 Mapper
 *
 * @author Mickey
 */
@Mapper
public interface CommunityMenuMapper extends BaseMapperX<CommunityMenuDO> {

    default PageResult<CommunityMenuDO> selectPage(MenuPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommunityMenuDO>()
                .likeIfPresent(CommunityMenuDO::getMenuZhName, reqVO.getMenuZhName())
                .likeIfPresent(CommunityMenuDO::getMenuEnName, reqVO.getMenuEnName())
                .eqIfPresent(CommunityMenuDO::getMenuIcon, reqVO.getMenuIcon())
                .eqIfPresent(CommunityMenuDO::getIconStyle, reqVO.getIconStyle())
                .eqIfPresent(CommunityMenuDO::getRoutePath, reqVO.getRoutePath())
                .eqIfPresent(CommunityMenuDO::getStatus, reqVO.getStatus())
                .eqIfPresent(CommunityMenuDO::getKeepAlive, reqVO.getKeepAlive())
                .eqIfPresent(CommunityMenuDO::getSort, reqVO.getSort())
                .betweenIfPresent(CommunityMenuDO::getCreateTime, reqVO.getCreateTime())
                .orderByAsc(CommunityMenuDO::getSort));
    }

    default List<CommunityMenuDO> selectList(MenuExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CommunityMenuDO>()
                .likeIfPresent(CommunityMenuDO::getMenuZhName, reqVO.getMenuZhName())
                .likeIfPresent(CommunityMenuDO::getMenuEnName, reqVO.getMenuEnName())
                .eqIfPresent(CommunityMenuDO::getMenuIcon, reqVO.getMenuIcon())
                .eqIfPresent(CommunityMenuDO::getIconStyle, reqVO.getIconStyle())
                .eqIfPresent(CommunityMenuDO::getRoutePath, reqVO.getRoutePath())
                .eqIfPresent(CommunityMenuDO::getStatus, reqVO.getStatus())
                .eqIfPresent(CommunityMenuDO::getKeepAlive, reqVO.getKeepAlive())
                .eqIfPresent(CommunityMenuDO::getSort, reqVO.getSort())
                .betweenIfPresent(CommunityMenuDO::getCreateTime, reqVO.getCreateTime())
                .orderByAsc(CommunityMenuDO::getSort));
    }

}
