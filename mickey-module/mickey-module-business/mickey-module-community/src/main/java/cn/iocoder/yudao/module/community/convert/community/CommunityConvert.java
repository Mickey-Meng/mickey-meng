package cn.iocoder.yudao.module.community.convert.community;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.community.controller.app.community.vo.AppCommunityRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.community.controller.admin.community.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;

/**
 * 小区信息 Convert
 *
 * @author Mickey
 */
@Mapper
public interface CommunityConvert {

    CommunityConvert INSTANCE = Mappers.getMapper(CommunityConvert.class);

    CommunityDO convert(CommunityCreateReqVO bean);

    CommunityDO convert(CommunityUpdateReqVO bean);

    CommunityRespVO convert(CommunityDO bean);

    List<CommunityRespVO> convertList(List<CommunityDO> list);

    PageResult<CommunityRespVO> convertPage(PageResult<CommunityDO> page);

    List<CommunityExcelVO> convertList02(List<CommunityDO> list);

    List<AppCommunityRespVO> convertAppList(List<CommunityDO> list);

}
