package com.mickeymeng.admin.infra.convert.db;

import com.mickeymeng.admin.infra.controller.admin.db.vo.DataSourceConfigCreateReqVO;
import com.mickeymeng.admin.infra.controller.admin.db.vo.DataSourceConfigRespVO;
import com.mickeymeng.admin.infra.controller.admin.db.vo.DataSourceConfigUpdateReqVO;
import com.mickeymeng.admin.infra.dal.dataobject.db.DataSourceConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据源配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DataSourceConfigConvert {

    DataSourceConfigConvert INSTANCE = Mappers.getMapper(DataSourceConfigConvert.class);

    DataSourceConfigDO convert(DataSourceConfigCreateReqVO bean);

    DataSourceConfigDO convert(DataSourceConfigUpdateReqVO bean);

    DataSourceConfigRespVO convert(DataSourceConfigDO bean);

    List<DataSourceConfigRespVO> convertList(List<DataSourceConfigDO> list);

}
