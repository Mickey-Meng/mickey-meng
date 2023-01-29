package cn.iocoder.yudao.module.community.convert.menu;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.community.controller.app.community.vo.AppCommunityRespVO;
import cn.iocoder.yudao.module.community.controller.app.menu.vo.AppMenuRespVO;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.community.controller.admin.menu.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.menu.CommunityMenuDO;

/**
 * 服务列表菜单 Convert
 *
 * @author Mickey
 */
@Mapper
public interface MenuConvert {

    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);

    CommunityMenuDO convert(MenuCreateReqVO bean);

    CommunityMenuDO convert(MenuUpdateReqVO bean);

    MenuRespVO convert(CommunityMenuDO bean);

    List<MenuRespVO> convertList(List<CommunityMenuDO> list);

    PageResult<MenuRespVO> convertPage(PageResult<CommunityMenuDO> page);

    List<MenuExcelVO> convertList02(List<CommunityMenuDO> list);

    List<AppMenuRespVO> convertAppList(List<CommunityMenuDO> list);

}
