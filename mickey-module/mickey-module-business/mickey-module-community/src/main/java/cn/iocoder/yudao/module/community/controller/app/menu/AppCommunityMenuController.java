package cn.iocoder.yudao.module.community.controller.app.menu;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.community.controller.app.menu.vo.*;
import cn.iocoder.yudao.module.community.convert.menu.MenuConvert;
import cn.iocoder.yudao.module.community.dal.dataobject.menu.CommunityMenuDO;
import cn.iocoder.yudao.module.community.service.menu.CommunityMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "管理后台 - 社区服务列表菜单")
@RestController
@RequestMapping("/community/menu")
@Validated
public class AppCommunityMenuController {

    @Resource
    private CommunityMenuService menuService;

    @GetMapping("/list")
    @ApiOperation("获得开启的服务列表菜单列表")
    public CommonResult<List<AppMenuRespVO>> getMenuList() {
        AppMenuEnableReqVO appMenuEnableReqVO = new AppMenuEnableReqVO();
        appMenuEnableReqVO.setStatus(0);
        List<CommunityMenuDO> list = menuService.getMenuList(appMenuEnableReqVO);
        return success(MenuConvert.INSTANCE.convertAppList(list));
    }

}
