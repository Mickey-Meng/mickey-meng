package cn.iocoder.yudao.module.community.service.menu;

import cn.iocoder.yudao.framework.test.core.util.RandomUtils;
import cn.iocoder.yudao.module.community.dal.mysql.menu.CommunityMenuMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.community.controller.admin.menu.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.menu.CommunityMenuDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.module.community.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link CommunityMenuServiceImpl} 的单元测试类
*
* @author Mickey
*/
@Import(CommunityMenuServiceImpl.class)
public class MenuServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CommunityMenuServiceImpl menuService;

    @Resource
    private CommunityMenuMapper menuMapper;

    @Test
    public void testCreateMenu_success() {
        // 准备参数
        MenuCreateReqVO reqVO = randomPojo(MenuCreateReqVO.class);

        // 调用
        Integer menuId = menuService.createMenu(reqVO);
        // 断言
        assertNotNull(menuId);
        // 校验记录的属性是否正确
        CommunityMenuDO menu = menuMapper.selectById(menuId);
        assertPojoEquals(reqVO, menu);
    }

    @Test
    public void testUpdateMenu_success() {
        // mock 数据
        CommunityMenuDO dbMenu = randomPojo(CommunityMenuDO.class);
        menuMapper.insert(dbMenu);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MenuUpdateReqVO reqVO = randomPojo(MenuUpdateReqVO.class, o -> {
            o.setId(dbMenu.getId()); // 设置更新的 ID
        });

        // 调用
        menuService.updateMenu(reqVO);
        // 校验是否更新正确
        CommunityMenuDO menu = menuMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, menu);
    }

    @Test
    public void testUpdateMenu_notExists() {
        // 准备参数
        MenuUpdateReqVO reqVO = randomPojo(MenuUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> menuService.updateMenu(reqVO), MENU_NOT_EXISTS);
    }

    @Test
    public void testDeleteMenu_success() {
        // mock 数据
        CommunityMenuDO dbMenu = randomPojo(CommunityMenuDO.class);
        menuMapper.insert(dbMenu);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbMenu.getId();

        // 调用
        menuService.deleteMenu(id);
       // 校验数据不存在了
       assertNull(menuMapper.selectById(id));
    }

    @Test
    public void testDeleteMenu_notExists() {
        // 准备参数
        //Integer id = randomIntegerId();

        // 调用, 并断言异常
        //assertServiceException(() -> menuService.deleteMenu(id), MENU_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMenuPage() {
       // mock 数据
       CommunityMenuDO dbMenu = randomPojo(CommunityMenuDO.class, o -> { // 等会查询到
           o.setMenuZhName(null);
           o.setMenuEnName(null);
           o.setMenuIcon(null);
           o.setIconStyle(null);
           o.setRoutePath(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       menuMapper.insert(dbMenu);
       // 测试 menuZhName 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setMenuZhName(null)));
       // 测试 menuEnName 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setMenuEnName(null)));
       // 测试 menuIcon 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setMenuIcon(null)));
       // 测试 icon-style 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setIconStyle(null)));
       // 测试 route-path 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setRoutePath(null)));
       // 测试 sort 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setCreateTime(null)));
       // 准备参数
       MenuPageReqVO reqVO = new MenuPageReqVO();
       reqVO.setMenuZhName(null);
       reqVO.setMenuEnName(null);
       reqVO.setMenuIcon(null);
       reqVO.setIconStyle(null);
       reqVO.setRoutePath(null);
       reqVO.setSort(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<CommunityMenuDO> pageResult = menuService.getMenuPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMenu, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMenuList() {
       // mock 数据
       CommunityMenuDO dbMenu = randomPojo(CommunityMenuDO.class, o -> { // 等会查询到
           o.setMenuZhName(null);
           o.setMenuEnName(null);
           o.setMenuIcon(null);
           o.setIconStyle(null);
           o.setRoutePath(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       menuMapper.insert(dbMenu);
       // 测试 menuZhName 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setMenuZhName(null)));
       // 测试 menuEnName 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setMenuEnName(null)));
       // 测试 menuIcon 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setMenuIcon(null)));
       // 测试 icon-style 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setIconStyle(null)));
       // 测试 route-path 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setRoutePath(null)));
       // 测试 sort 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       menuMapper.insert(cloneIgnoreId(dbMenu, o -> o.setCreateTime(null)));
       // 准备参数
       MenuExportReqVO reqVO = new MenuExportReqVO();
       reqVO.setMenuZhName(null);
       reqVO.setMenuEnName(null);
       reqVO.setMenuIcon(null);
       reqVO.setIconStyle(null);
       reqVO.setRoutePath(null);
       reqVO.setSort(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<CommunityMenuDO> list = menuService.getMenuList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMenu, list.get(0));
    }

}
