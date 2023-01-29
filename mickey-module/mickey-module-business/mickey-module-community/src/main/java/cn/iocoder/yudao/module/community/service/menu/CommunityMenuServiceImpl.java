package cn.iocoder.yudao.module.community.service.menu;

import cn.iocoder.yudao.module.community.dal.mysql.menu.CommunityMenuMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.community.controller.admin.menu.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.menu.CommunityMenuDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.community.convert.menu.MenuConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.community.enums.ErrorCodeConstants.*;

/**
 * 服务列表菜单 Service 实现类
 *
 * @author Mickey
 */
@Service
@Validated
public class CommunityMenuServiceImpl implements CommunityMenuService {

    @Resource
    private CommunityMenuMapper communityMenuMapper;

    @Override
    public Integer createMenu(MenuCreateReqVO createReqVO) {
        // 插入
        CommunityMenuDO menu = MenuConvert.INSTANCE.convert(createReqVO);
        communityMenuMapper.insert(menu);
        // 返回
        return menu.getId();
    }

    @Override
    public void updateMenu(MenuUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMenuExists(updateReqVO.getId());
        // 更新
        CommunityMenuDO updateObj = MenuConvert.INSTANCE.convert(updateReqVO);
        communityMenuMapper.updateById(updateObj);
    }

    @Override
    public void deleteMenu(Integer id) {
        // 校验存在
        this.validateMenuExists(id);
        // 删除
        communityMenuMapper.deleteById(id);
    }

    private void validateMenuExists(Integer id) {
        if (communityMenuMapper.selectById(id) == null) {
            throw exception(MENU_NOT_EXISTS);
        }
    }

    @Override
    public CommunityMenuDO getMenu(Integer id) {
        return communityMenuMapper.selectById(id);
    }

    @Override
    public List<CommunityMenuDO> getMenuList(Collection<Integer> ids) {
        return communityMenuMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommunityMenuDO> getMenuPage(MenuPageReqVO pageReqVO) {
        return communityMenuMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommunityMenuDO> getMenuList(MenuExportReqVO exportReqVO) {
        return communityMenuMapper.selectList(exportReqVO);
    }

}
