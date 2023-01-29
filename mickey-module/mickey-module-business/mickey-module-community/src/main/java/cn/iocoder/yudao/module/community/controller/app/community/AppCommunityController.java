package cn.iocoder.yudao.module.community.controller.app.community;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.community.controller.app.community.vo.*;
import cn.iocoder.yudao.module.community.convert.community.CommunityConvert;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;
import cn.iocoder.yudao.module.community.service.community.CommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "用户端 - 小区信息")
@RestController
@RequestMapping("/community/community")
@Validated
public class AppCommunityController {

    @Resource
    private CommunityService communityService;

    @GetMapping("/list")
    @ApiOperation("获得小区列表")
    public CommonResult<List<AppCommunityRespVO>> getAddressList() {
        List<CommunityDO> list = communityService.getAllList();
        return success(CommunityConvert.INSTANCE.convertAppList(list));
    }

}
