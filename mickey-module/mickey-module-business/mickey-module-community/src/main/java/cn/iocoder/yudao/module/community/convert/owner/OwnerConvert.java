package cn.iocoder.yudao.module.community.convert.owner;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.community.controller.admin.owner.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.owner.OwnerDO;

/**
 * 业主信息 Convert
 *
 * @author Mickey
 */
@Mapper
public interface OwnerConvert {

    OwnerConvert INSTANCE = Mappers.getMapper(OwnerConvert.class);

    OwnerDO convert(OwnerCreateReqVO bean);

    OwnerDO convert(OwnerUpdateReqVO bean);

    OwnerRespVO convert(OwnerDO bean);

    List<OwnerRespVO> convertList(List<OwnerDO> list);

    PageResult<OwnerRespVO> convertPage(PageResult<OwnerDO> page);

    List<OwnerExcelVO> convertList02(List<OwnerDO> list);

}
