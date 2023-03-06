package cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed;

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

import cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivablesdetailed.ReceivablesDetailedDO;
import cn.iocoder.yudao.module.finance.convert.receivablesdetailed.ReceivablesDetailedConvert;
import cn.iocoder.yudao.module.finance.service.receivablesdetailed.ReceivablesDetailedService;

@Api(tags = "管理后台 - 应收款明细")
@RestController
@RequestMapping("/finance/receivablesDetailed")
@Validated
public class ReceivablesDetailedController {

    @Resource
    private ReceivablesDetailedService receivablesDetailedService;

    @PostMapping("/create")
    @ApiOperation("创建应收款明细")
    @PreAuthorize("@ss.hasPermission('finance:receivablesDetailed:create')")
    public CommonResult<String> createReceivablesDetailed(@Valid @RequestBody ReceivablesDetailedCreateReqVO createReqVO) {
        return success(receivablesDetailedService.createReceivablesDetailed(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新应收款明细")
    @PreAuthorize("@ss.hasPermission('finance:receivablesDetailed:update')")
    public CommonResult<Boolean> updateReceivablesDetailed(@Valid @RequestBody ReceivablesDetailedUpdateReqVO updateReqVO) {
        receivablesDetailedService.updateReceivablesDetailed(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除应收款明细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('finance:receivablesDetailed:delete')")
    public CommonResult<Boolean> deleteReceivablesDetailed(@RequestParam("id") String id) {
        receivablesDetailedService.deleteReceivablesDetailed(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得应收款明细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('finance:receivablesDetailed:query')")
    public CommonResult<ReceivablesDetailedRespVO> getReceivablesDetailed(@RequestParam("id") String id) {
        ReceivablesDetailedDO receivablesDetailed = receivablesDetailedService.getReceivablesDetailed(id);
        return success(ReceivablesDetailedConvert.INSTANCE.convert(receivablesDetailed));
    }

    @GetMapping("/list")
    @ApiOperation("获得应收款明细列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('finance:receivablesDetailed:query')")
    public CommonResult<List<ReceivablesDetailedRespVO>> getReceivablesDetailedList(@RequestParam("ids") Collection<String> ids) {
        List<ReceivablesDetailedDO> list = receivablesDetailedService.getReceivablesDetailedList(ids);
        return success(ReceivablesDetailedConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得应收款明细分页")
    @PreAuthorize("@ss.hasPermission('finance:receivablesDetailed:query')")
    public CommonResult<PageResult<ReceivablesDetailedRespVO>> getReceivablesDetailedPage(@Valid ReceivablesDetailedPageReqVO pageVO) {
        PageResult<ReceivablesDetailedDO> pageResult = receivablesDetailedService.getReceivablesDetailedPage(pageVO);
        return success(ReceivablesDetailedConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出应收款明细 Excel")
    @PreAuthorize("@ss.hasPermission('finance:receivablesDetailed:export')")
    @OperateLog(type = EXPORT)
    public void exportReceivablesDetailedExcel(@Valid ReceivablesDetailedExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ReceivablesDetailedDO> list = receivablesDetailedService.getReceivablesDetailedList(exportReqVO);
        // 导出 Excel
        List<ReceivablesDetailedExcelVO> datas = ReceivablesDetailedConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "应收款明细.xls", "数据", ReceivablesDetailedExcelVO.class, datas);
    }

}
