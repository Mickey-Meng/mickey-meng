package cn.iocoder.yudao.module.finance.controller.admin.receivables;

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

import cn.iocoder.yudao.module.finance.controller.admin.receivables.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivables.ReceivablesDO;
import cn.iocoder.yudao.module.finance.convert.receivables.ReceivablesConvert;
import cn.iocoder.yudao.module.finance.service.receivables.ReceivablesService;

@Api(tags = "管理后台 - 应收款")
@RestController
@RequestMapping("/finance/receivables")
@Validated
public class ReceivablesController {

    @Resource
    private ReceivablesService receivablesService;

    @PostMapping("/create")
    @ApiOperation("创建应收款")
    @PreAuthorize("@ss.hasPermission('finance:receivables:create')")
    public CommonResult<String> createReceivables(@Valid @RequestBody ReceivablesCreateReqVO createReqVO) {
        return success(receivablesService.createReceivables(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新应收款")
    @PreAuthorize("@ss.hasPermission('finance:receivables:update')")
    public CommonResult<Boolean> updateReceivables(@Valid @RequestBody ReceivablesUpdateReqVO updateReqVO) {
        receivablesService.updateReceivables(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除应收款")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('finance:receivables:delete')")
    public CommonResult<Boolean> deleteReceivables(@RequestParam("id") String id) {
        receivablesService.deleteReceivables(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得应收款")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('finance:receivables:query')")
    public CommonResult<ReceivablesRespVO> getReceivables(@RequestParam("id") String id) {
        ReceivablesDO receivables = receivablesService.getReceivables(id);
        return success(ReceivablesConvert.INSTANCE.convert(receivables));
    }

    @GetMapping("/list")
    @ApiOperation("获得应收款列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('finance:receivables:query')")
    public CommonResult<List<ReceivablesRespVO>> getReceivablesList(@RequestParam("ids") Collection<String> ids) {
        List<ReceivablesDO> list = receivablesService.getReceivablesList(ids);
        return success(ReceivablesConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得应收款分页")
    @PreAuthorize("@ss.hasPermission('finance:receivables:query')")
    public CommonResult<PageResult<ReceivablesRespVO>> getReceivablesPage(@Valid ReceivablesPageReqVO pageVO) {
        PageResult<ReceivablesDO> pageResult = receivablesService.getReceivablesPage(pageVO);
        return success(ReceivablesConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出应收款 Excel")
    @PreAuthorize("@ss.hasPermission('finance:receivables:export')")
    @OperateLog(type = EXPORT)
    public void exportReceivablesExcel(@Valid ReceivablesExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ReceivablesDO> list = receivablesService.getReceivablesList(exportReqVO);
        // 导出 Excel
        List<ReceivablesExcelVO> datas = ReceivablesConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "应收款.xls", "数据", ReceivablesExcelVO.class, datas);
    }

}
