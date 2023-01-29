package cn.iocoder.yudao.module.community.dal.mysql.owner;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.community.dal.dataobject.owner.OwnerDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.community.controller.admin.owner.vo.*;

/**
 * 业主信息 Mapper
 *
 * @author Mickey
 */
@Mapper
public interface OwnerMapper extends BaseMapperX<OwnerDO> {

    default PageResult<OwnerDO> selectPage(OwnerPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OwnerDO>()
                .likeIfPresent(OwnerDO::getNickname, reqVO.getNickname())
                .likeIfPresent(OwnerDO::getRealName, reqVO.getRealName())
                .eqIfPresent(OwnerDO::getAge, reqVO.getAge())
                .eqIfPresent(OwnerDO::getGender, reqVO.getGender())
                .eqIfPresent(OwnerDO::getIdCardNumber, reqVO.getIdCardNumber())
                .eqIfPresent(OwnerDO::getPhoneNumber, reqVO.getPhoneNumber())
                .eqIfPresent(OwnerDO::getWechatId, reqVO.getWechatId())
                .eqIfPresent(OwnerDO::getQqNumber, reqVO.getQqNumber())
                .eqIfPresent(OwnerDO::getEmail, reqVO.getEmail())
                .eqIfPresent(OwnerDO::getBirthday, reqVO.getBirthday())
                .eqIfPresent(OwnerDO::getPortrait, reqVO.getPortrait())
                .eqIfPresent(OwnerDO::getSignature, reqVO.getSignature())
                .eqIfPresent(OwnerDO::getStatus, reqVO.getStatus())
                .eqIfPresent(OwnerDO::getLogonMode, reqVO.getLogonMode())
                .eqIfPresent(OwnerDO::getOwnerType, reqVO.getOwnerType())
                .eqIfPresent(OwnerDO::getPassword, reqVO.getPassword())
                .eqIfPresent(OwnerDO::getSort, reqVO.getSort())
                .eqIfPresent(OwnerDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(OwnerDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OwnerDO::getId));
    }

    default List<OwnerDO> selectList(OwnerExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OwnerDO>()
                .likeIfPresent(OwnerDO::getNickname, reqVO.getNickname())
                .likeIfPresent(OwnerDO::getRealName, reqVO.getRealName())
                .eqIfPresent(OwnerDO::getAge, reqVO.getAge())
                .eqIfPresent(OwnerDO::getGender, reqVO.getGender())
                .eqIfPresent(OwnerDO::getIdCardNumber, reqVO.getIdCardNumber())
                .eqIfPresent(OwnerDO::getPhoneNumber, reqVO.getPhoneNumber())
                .eqIfPresent(OwnerDO::getWechatId, reqVO.getWechatId())
                .eqIfPresent(OwnerDO::getQqNumber, reqVO.getQqNumber())
                .eqIfPresent(OwnerDO::getEmail, reqVO.getEmail())
                .eqIfPresent(OwnerDO::getBirthday, reqVO.getBirthday())
                .eqIfPresent(OwnerDO::getPortrait, reqVO.getPortrait())
                .eqIfPresent(OwnerDO::getSignature, reqVO.getSignature())
                .eqIfPresent(OwnerDO::getStatus, reqVO.getStatus())
                .eqIfPresent(OwnerDO::getLogonMode, reqVO.getLogonMode())
                .eqIfPresent(OwnerDO::getOwnerType, reqVO.getOwnerType())
                .eqIfPresent(OwnerDO::getPassword, reqVO.getPassword())
                .eqIfPresent(OwnerDO::getSort, reqVO.getSort())
                .eqIfPresent(OwnerDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(OwnerDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OwnerDO::getId));
    }

}
