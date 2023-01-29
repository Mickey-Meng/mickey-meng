package cn.iocoder.yudao.module.community.service.menu;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.community.controller.admin.menu.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.menu.CommunityMenuDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 服务列表菜单 Service 接口
 *
 * @author Mickey
 */
public interface CommunityMenuService {

    /**
     * 创建服务列表菜单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createMenu(@Valid MenuCreateReqVO createReqVO);

    /**
     * 更新服务列表菜单
     *
     * @param updateReqVO 更新信息
     */
    void updateMenu(@Valid MenuUpdateReqVO updateReqVO);

    /**
     * 删除服务列表菜单
     *
     * @param id 编号
     */
    void deleteMenu(Integer id);

    /**
     * 获得服务列表菜单
     *
     * @param id 编号
     * @return 服务列表菜单
     */
    CommunityMenuDO getMenu(Integer id);

    /**
     * 获得服务列表菜单列表
     *
     * @param ids 编号
     * @return 服务列表菜单列表
     */
    List<CommunityMenuDO> getMenuList(Collection<Integer> ids);

    /**
     * 获得服务列表菜单分页
     *
     * @param pageReqVO 分页查询
     * @return 服务列表菜单分页
     */
    PageResult<CommunityMenuDO> getMenuPage(MenuPageReqVO pageReqVO);

    /**
     * 获得服务列表菜单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 服务列表菜单列表
     */
    List<CommunityMenuDO> getMenuList(MenuExportReqVO exportReqVO);

}
