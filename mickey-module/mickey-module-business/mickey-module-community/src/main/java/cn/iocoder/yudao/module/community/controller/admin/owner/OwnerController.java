package cn.iocoder.yudao.module.community.controller.admin.owner;

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

import cn.iocoder.yudao.module.community.controller.admin.owner.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.owner.OwnerDO;
import cn.iocoder.yudao.module.community.convert.owner.OwnerConvert;
import cn.iocoder.yudao.module.community.service.owner.OwnerService;

@Api(tags = "管理后台 - 业主信息")
@RestController
@RequestMapping("/community/owner")
@Validated
public class OwnerController {

    @Resource
    private OwnerService ownerService;

    @PostMapping("/create")
    @ApiOperation("创建业主信息")
    @PreAuthorize("@ss.hasPermission('community:owner:create')")
    public CommonResult<Long> createOwner(@Valid @RequestBody OwnerCreateReqVO createReqVO) {
        return success(ownerService.createOwner(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新业主信息")
    @PreAuthorize("@ss.hasPermission('community:owner:update')")
    public CommonResult<Boolean> updateOwner(@Valid @RequestBody OwnerUpdateReqVO updateReqVO) {
        ownerService.updateOwner(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除业主信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('community:owner:delete')")
    public CommonResult<Boolean> deleteOwner(@RequestParam("id") Long id) {
        ownerService.deleteOwner(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得业主信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('community:owner:query')")
    public CommonResult<OwnerRespVO> getOwner(@RequestParam("id") Long id) {
        OwnerDO owner = ownerService.getOwner(id);
        return success(OwnerConvert.INSTANCE.convert(owner));
    }

    @GetMapping("/list")
    @ApiOperation("获得业主信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('community:owner:query')")
    public CommonResult<List<OwnerRespVO>> getOwnerList(@RequestParam("ids") Collection<Long> ids) {
        List<OwnerDO> list = ownerService.getOwnerList(ids);
        return success(OwnerConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得业主信息分页")
    @PreAuthorize("@ss.hasPermission('community:owner:query')")
    public CommonResult<PageResult<OwnerRespVO>> getOwnerPage(@Valid OwnerPageReqVO pageVO) {
        PageResult<OwnerDO> pageResult = ownerService.getOwnerPage(pageVO);
        return success(OwnerConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出业主信息 Excel")
    @PreAuthorize("@ss.hasPermission('community:owner:export')")
    @OperateLog(type = EXPORT)
    public void exportOwnerExcel(@Valid OwnerExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<OwnerDO> list = ownerService.getOwnerList(exportReqVO);
        // 导出 Excel
        List<OwnerExcelVO> datas = OwnerConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "业主信息.xls", "数据", OwnerExcelVO.class, datas);
    }

}
