package cn.iocoder.yudao.module.community.dal.mysql.community;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.community.controller.admin.community.vo.*;

/**
 * 小区信息 Mapper
 *
 * @author Mickey
 */
@Mapper
public interface CommunityMapper extends BaseMapperX<CommunityDO> {

    default PageResult<CommunityDO> selectPage(CommunityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommunityDO>()
                .likeIfPresent(CommunityDO::getCommunityName, reqVO.getCommunityName())
                .eqIfPresent(CommunityDO::getCommunityCode, reqVO.getCommunityCode())
                .eqIfPresent(CommunityDO::getProvincesCode, reqVO.getProvincesCode())
                .eqIfPresent(CommunityDO::getCityCode, reqVO.getCityCode())
                .eqIfPresent(CommunityDO::getDistrictCode, reqVO.getDistrictCode())
                .eqIfPresent(CommunityDO::getTownCode, reqVO.getTownCode())
                .eqIfPresent(CommunityDO::getDetailedAddress, reqVO.getDetailedAddress())
                .eqIfPresent(CommunityDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(CommunityDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(CommunityDO::getPropertyId, reqVO.getPropertyId())
                .eqIfPresent(CommunityDO::getSort, reqVO.getSort())
                .eqIfPresent(CommunityDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(CommunityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommunityDO::getId));
    }

    default List<CommunityDO> selectList(CommunityExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CommunityDO>()
                .likeIfPresent(CommunityDO::getCommunityName, reqVO.getCommunityName())
                .eqIfPresent(CommunityDO::getCommunityCode, reqVO.getCommunityCode())
                .eqIfPresent(CommunityDO::getProvincesCode, reqVO.getProvincesCode())
                .eqIfPresent(CommunityDO::getCityCode, reqVO.getCityCode())
                .eqIfPresent(CommunityDO::getDistrictCode, reqVO.getDistrictCode())
                .eqIfPresent(CommunityDO::getTownCode, reqVO.getTownCode())
                .eqIfPresent(CommunityDO::getDetailedAddress, reqVO.getDetailedAddress())
                .eqIfPresent(CommunityDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(CommunityDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(CommunityDO::getPropertyId, reqVO.getPropertyId())
                .eqIfPresent(CommunityDO::getSort, reqVO.getSort())
                .eqIfPresent(CommunityDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(CommunityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommunityDO::getId));
    }

}
