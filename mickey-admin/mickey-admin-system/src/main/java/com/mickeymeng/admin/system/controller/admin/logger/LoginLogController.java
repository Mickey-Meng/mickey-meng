package com.mickeymeng.admin.system.controller.admin.logger;

import com.mickeymeng.framework.common.pojo.CommonResult;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.common.core.util.excel.ExcelUtils;
import com.mickeymeng.framework.logging.core.annotations.OperateLog;
import com.mickeymeng.framework.logging.core.enums.OperateTypeEnum;
import com.mickeymeng.admin.system.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.loginlog.LoginLogExportReqVO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import com.mickeymeng.admin.system.convert.logger.LoginLogConvert;
import com.mickeymeng.admin.system.dal.dataobject.logger.LoginLogDO;
import com.mickeymeng.admin.system.service.logger.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Api(tags = "管理后台 - 登录日志")
@RestController
@RequestMapping("/system/login-log")
@Validated
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @GetMapping("/page")
    @ApiOperation("获得登录日志分页列表")
    @PreAuthorize("@ss.hasPermission('system:login-log:query')")
    public CommonResult<PageResult<LoginLogRespVO>> getLoginLogPage(@Valid LoginLogPageReqVO reqVO) {
        PageResult<LoginLogDO> page = loginLogService.getLoginLogPage(reqVO);
        return CommonResult.success(LoginLogConvert.INSTANCE.convertPage(page));
    }

    @GetMapping("/export")
    @ApiOperation("导出登录日志 Excel")
    @PreAuthorize("@ss.hasPermission('system:login-log:export')")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    public void exportLoginLog(HttpServletResponse response, @Valid LoginLogExportReqVO reqVO) throws IOException {
        List<LoginLogDO> list = loginLogService.getLoginLogList(reqVO);
        // 拼接数据
        List<LoginLogExcelVO> data = LoginLogConvert.INSTANCE.convertList(list);
        // 输出
        ExcelUtils.write(response, "登录日志.xls", "数据列表", LoginLogExcelVO.class, data);
    }

}
