package com.mickeymeng.framework.module.pay.dal.mysql.notify;

import com.mickeymeng.framework.middleware.mybatis.mybatis.core.mapper.BaseMapperX;
import com.mickeymeng.framework.module.pay.dal.dataobject.notify.PayNotifyLogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayNotifyLogCoreMapper extends BaseMapperX<PayNotifyLogDO> {
}
