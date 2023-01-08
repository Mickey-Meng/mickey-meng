package com.mickeymeng.admin.infra.dal.mysql.db;

import com.mickeymeng.admin.infra.dal.dataobject.db.DataSourceConfigDO;
import com.mickeymeng.framework.middleware.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
