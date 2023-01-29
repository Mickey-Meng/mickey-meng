package cn.iocoder.yudao.module.community.controller.admin.community;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

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

import cn.iocoder.yudao.module.community.controller.admin.community.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;
import cn.iocoder.yudao.module.community.convert.community.CommunityConvert;
import cn.iocoder.yudao.module.community.service.community.CommunityService;

@Api(tags = "管理后台 - 小区信息")
@RestController
@RequestMapping("/community/community")
@Validated
public class CommunityController {

    @Resource
    private CommunityService communityService;

    @PostMapping("/create")
    @ApiOperation("创建小区信息")
    @PreAuthorize("@ss.hasPermission('community:community:create')")
    public CommonResult<Integer> create(@Valid @RequestBody CommunityCreateReqVO createReqVO) {
        return success(communityService.create(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新小区信息")
    @PreAuthorize("@ss.hasPermission('community:community:update')")
    public CommonResult<Boolean> update(@Valid @RequestBody CommunityUpdateReqVO updateReqVO) {
        communityService.update(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除小区信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('community:community:delete')")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        communityService.delete(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得小区信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('community:community:query')")
    public CommonResult<CommunityRespVO> get(@RequestParam("id") Integer id) {
        CommunityDO  communityDO = communityService.get(id);
        return success(CommunityConvert.INSTANCE.convert(communityDO));
    }

    @GetMapping("/list")
    @ApiOperation("获得小区信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('community:community:query')")
    public CommonResult<List<CommunityRespVO>> getList(@RequestParam("ids") Collection<Integer> ids) {
        List<CommunityDO> list = communityService.getList(ids);
        return success(CommunityConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得小区信息分页")
    @PreAuthorize("@ss.hasPermission('community:community:query')")
    public CommonResult<PageResult<CommunityRespVO>> getPage(@Valid CommunityPageReqVO pageVO) {
        PageResult<CommunityDO> pageResult = communityService.getPage(pageVO);
        return success(CommunityConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出小区信息 Excel")
    @PreAuthorize("@ss.hasPermission('community:community:export')")
    @OperateLog(type = EXPORT)
    public void exportExcel(@Valid CommunityExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CommunityDO> list = communityService.getList(exportReqVO);
        // 导出 Excel
        List<CommunityExcelVO> datas = CommunityConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "小区信息.xls", "数据", CommunityExcelVO.class, datas);
    }

}
