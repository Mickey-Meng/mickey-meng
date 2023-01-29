package cn.iocoder.yudao.module.community.controller.admin.menu;

import cn.iocoder.yudao.module.community.service.menu.CommunityMenuService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.community.controller.admin.menu.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.menu.CommunityMenuDO;
import cn.iocoder.yudao.module.community.convert.menu.MenuConvert;

@Api(tags = "管理后台 - 社区服务列表菜单")
@RestController
@RequestMapping("/community/menu")
@Validated
public class CommunityMenuController {

    @Resource
    private CommunityMenuService menuService;

    @PostMapping("/create")
    @ApiOperation("创建服务列表菜单")
    @PreAuthorize("@ss.hasPermission('community:menu:create')")
    public CommonResult<Integer> createMenu(@Valid @RequestBody MenuCreateReqVO createReqVO) {
        return success(menuService.createMenu(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新服务列表菜单")
    @PreAuthorize("@ss.hasPermission('community:menu:update')")
    public CommonResult<Boolean> updateMenu(@Valid @RequestBody MenuUpdateReqVO updateReqVO) {
        menuService.updateMenu(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除服务列表菜单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('community:menu:delete')")
    public CommonResult<Boolean> deleteMenu(@RequestParam("id") Integer id) {
        menuService.deleteMenu(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得服务列表菜单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('community:menu:query')")
    public CommonResult<MenuRespVO> getMenu(@RequestParam("id") Integer id) {
        CommunityMenuDO menu = menuService.getMenu(id);
        return success(MenuConvert.INSTANCE.convert(menu));
    }

    @GetMapping("/list")
    @ApiOperation("获得服务列表菜单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('community:menu:query')")
    public CommonResult<List<MenuRespVO>> getMenuList(@RequestParam("ids") Collection<Integer> ids) {
        List<CommunityMenuDO> list = menuService.getMenuList(ids);
        return success(MenuConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得服务列表菜单分页")
    @PreAuthorize("@ss.hasPermission('community:menu:query')")
    public CommonResult<PageResult<MenuRespVO>> getMenuPage(@Valid MenuPageReqVO pageVO) {
        PageResult<CommunityMenuDO> pageResult = menuService.getMenuPage(pageVO);
        return success(MenuConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出服务列表菜单 Excel")
    @PreAuthorize("@ss.hasPermission('community:menu:export')")
    @OperateLog(type = EXPORT)
    public void exportMenuExcel(@Valid MenuExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CommunityMenuDO> list = menuService.getMenuList(exportReqVO);
        // 导出 Excel
        List<MenuExcelVO> datas = MenuConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "服务列表菜单.xls", "数据", MenuExcelVO.class, datas);
    }

}
