package cn.iocoder.yudao.module.finance.controller.admin.refunddetailed;

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

import cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.refunddetailed.RefundDetailedDO;
import cn.iocoder.yudao.module.finance.convert.refunddetailed.RefundDetailedConvert;
import cn.iocoder.yudao.module.finance.service.refunddetailed.RefundDetailedService;

@Api(tags = "管理后台 - 退款明细")
@RestController
@RequestMapping("/finance/refundDetailed")
@Validated
public class RefundDetailedController {

    @Resource
    private RefundDetailedService refundDetailedService;

    @PostMapping("/create")
    @ApiOperation("创建退款明细")
    @PreAuthorize("@ss.hasPermission('finance:refundDetailed:create')")
    public CommonResult<String> createRefundDetailed(@Valid @RequestBody RefundDetailedCreateReqVO createReqVO) {
        return success(refundDetailedService.createRefundDetailed(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新退款明细")
    @PreAuthorize("@ss.hasPermission('finance:refundDetailed:update')")
    public CommonResult<Boolean> updateRefundDetailed(@Valid @RequestBody RefundDetailedUpdateReqVO updateReqVO) {
        refundDetailedService.updateRefundDetailed(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除退款明细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('finance:refundDetailed:delete')")
    public CommonResult<Boolean> deleteRefundDetailed(@RequestParam("id") String id) {
        refundDetailedService.deleteRefundDetailed(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得退款明细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('finance:refundDetailed:query')")
    public CommonResult<RefundDetailedRespVO> getRefundDetailed(@RequestParam("id") String id) {
        RefundDetailedDO refundDetailed = refundDetailedService.getRefundDetailed(id);
        return success(RefundDetailedConvert.INSTANCE.convert(refundDetailed));
    }

    @GetMapping("/list")
    @ApiOperation("获得退款明细列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('finance:refundDetailed:query')")
    public CommonResult<List<RefundDetailedRespVO>> getRefundDetailedList(@RequestParam("ids") Collection<String> ids) {
        List<RefundDetailedDO> list = refundDetailedService.getRefundDetailedList(ids);
        return success(RefundDetailedConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得退款明细分页")
    @PreAuthorize("@ss.hasPermission('finance:refundDetailed:query')")
    public CommonResult<PageResult<RefundDetailedRespVO>> getRefundDetailedPage(@Valid RefundDetailedPageReqVO pageVO) {
        PageResult<RefundDetailedDO> pageResult = refundDetailedService.getRefundDetailedPage(pageVO);
        return success(RefundDetailedConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出退款明细 Excel")
    @PreAuthorize("@ss.hasPermission('finance:refundDetailed:export')")
    @OperateLog(type = EXPORT)
    public void exportRefundDetailedExcel(@Valid RefundDetailedExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<RefundDetailedDO> list = refundDetailedService.getRefundDetailedList(exportReqVO);
        // 导出 Excel
        List<RefundDetailedExcelVO> datas = RefundDetailedConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "退款明细.xls", "数据", RefundDetailedExcelVO.class, datas);
    }

}
