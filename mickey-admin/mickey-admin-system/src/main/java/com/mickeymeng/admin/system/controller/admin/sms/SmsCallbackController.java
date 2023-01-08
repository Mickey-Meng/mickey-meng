package com.mickeymeng.admin.system.controller.admin.sms;

import cn.hutool.extra.servlet.ServletUtil;
import com.mickeymeng.framework.common.pojo.CommonResult;
import com.mickeymeng.framework.common.core.util.excel.ExcelUtils;
import com.mickeymeng.framework.logging.core.annotations.OperateLog;
import com.mickeymeng.framework.logging.core.enums.OperateTypeEnum;
import com.mickeymeng.framework.middleware.sms.core.enums.SmsChannelEnum;
import com.mickeymeng.admin.system.service.sms.SmsSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;

import static com.mickeymeng.framework.common.pojo.CommonResult.success;

@Api(tags = "管理后台 - 短信回调")
@RestController
@RequestMapping("/system/sms/callback")
public class SmsCallbackController {

    @Resource
    private SmsSendService smsSendService;

    @PostMapping("/aliyun")
    @PermitAll
    @ApiOperation(value = "阿里云短信的回调", notes = "参见 https://help.aliyun.com/document_detail/120998.html 文档")
    @OperateLog(enable = false)
    public CommonResult<Boolean> receiveAliyunSmsStatus(HttpServletRequest request) throws Throwable {
        String text = ServletUtil.getBody(request);
        smsSendService.receiveSmsStatus(SmsChannelEnum.ALIYUN.getCode(), text);
        return success(true);
    }

    @PostMapping("/tencent")
    @PermitAll
    @ApiOperation(value = "腾讯云短信的回调", notes = "参见 https://cloud.tencent.com/document/product/382/52077 文档")
    @OperateLog(enable = false)
    public CommonResult<Boolean> receiveTencentSmsStatus(HttpServletRequest request) throws Throwable {
        String text = ServletUtil.getBody(request);
        smsSendService.receiveSmsStatus(SmsChannelEnum.TENCENT.getCode(), text);
        return success(true);
    }

}
