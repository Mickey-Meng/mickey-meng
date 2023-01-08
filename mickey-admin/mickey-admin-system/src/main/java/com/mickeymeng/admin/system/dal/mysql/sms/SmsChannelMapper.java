package com.mickeymeng.admin.system.dal.mysql.sms;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.middleware.mybatis.mybatis.core.mapper.BaseMapperX;
import com.mickeymeng.framework.middleware.mybatis.mybatis.core.query.LambdaQueryWrapperX;
import com.mickeymeng.admin.system.controller.admin.sms.vo.channel.SmsChannelPageReqVO;
import com.mickeymeng.admin.system.dal.dataobject.sms.SmsChannelDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

@Mapper
public interface SmsChannelMapper extends BaseMapperX<SmsChannelDO> {

    default PageResult<SmsChannelDO> selectPage(SmsChannelPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SmsChannelDO>()
                .likeIfPresent(SmsChannelDO::getSignature, reqVO.getSignature())
                .eqIfPresent(SmsChannelDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SmsChannelDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SmsChannelDO::getId));
    }

    @Select("SELECT COUNT(*) FROM system_sms_channel WHERE update_time > #{maxUpdateTime}")
    Long selectCountByUpdateTimeGt(LocalDateTime maxUpdateTime);

}
