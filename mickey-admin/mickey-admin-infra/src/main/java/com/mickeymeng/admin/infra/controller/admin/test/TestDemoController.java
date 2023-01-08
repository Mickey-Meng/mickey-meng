package com.mickeymeng.admin.infra.controller.admin.test;

import com.mickeymeng.admin.infra.controller.admin.test.vo.*;
import com.mickeymeng.admin.infra.convert.test.TestDemoConvert;
import com.mickeymeng.admin.infra.dal.dataobject.test.TestDemoDO;
import com.mickeymeng.admin.infra.service.test.TestDemoService;
import com.mickeymeng.framework.common.core.util.excel.ExcelUtils;
import com.mickeymeng.framework.common.pojo.CommonResult;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.logging.core.annotations.OperateLog;
import com.mickeymeng.framework.logging.core.enums.OperateTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.mickeymeng.framework.common.pojo.CommonResult.success;

@Api(tags = "管理后台 - 字典类型")
@RestController
@RequestMapping("/infra/test-demo")
@Validated
public class TestDemoController {

    @Resource
    private TestDemoService testDemoService;

    @PostMapping("/create")
    @ApiOperation("创建字典类型")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:create')")
    public CommonResult<Long> createTestDemo(@Valid @RequestBody TestDemoCreateReqVO createReqVO) {
        return success(testDemoService.createTestDemo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新字典类型")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:update')")
    public CommonResult<Boolean> updateTestDemo(@Valid @RequestBody TestDemoUpdateReqVO updateReqVO) {
        testDemoService.updateTestDemo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除字典类型")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('infra:test-demo:delete')")
    public CommonResult<Boolean> deleteTestDemo(@RequestParam("id") Long id) {
        testDemoService.deleteTestDemo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得字典类型")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")
    public CommonResult<TestDemoRespVO> getTestDemo(@RequestParam("id") Long id) {
        TestDemoDO testDemo = testDemoService.getTestDemo(id);
        return success(TestDemoConvert.INSTANCE.convert(testDemo));
    }

    @GetMapping("/list")
    @ApiOperation("获得字典类型列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")
    public CommonResult<List<TestDemoRespVO>> getTestDemoList(@RequestParam("ids") Collection<Long> ids) {
        List<TestDemoDO> list = testDemoService.getTestDemoList(ids);
        return success(TestDemoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得字典类型分页")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")    public CommonResult<PageResult<TestDemoRespVO>> getTestDemoPage(@Valid TestDemoPageReqVO pageVO) {
        PageResult<TestDemoDO> pageResult = testDemoService.getTestDemoPage(pageVO);
        return success(TestDemoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出字典类型 Excel")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:export')")    @OperateLog(type = OperateTypeEnum.EXPORT)
    public void exportTestDemoExcel(@Valid TestDemoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TestDemoDO> list = testDemoService.getTestDemoList(exportReqVO);
        // 导出 Excel
        List<TestDemoExcelVO> datas = TestDemoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "字典类型.xls", "数据", TestDemoExcelVO.class, datas);
    }

}
