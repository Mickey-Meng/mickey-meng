package com.mickeymeng.framework.module.pay.controller.admin.notify;

import com.mickeymeng.framework.logging.core.annotations.OperateLog;
import com.mickeymeng.framework.module.pay.core.client.PayClient;
import com.mickeymeng.framework.module.pay.core.client.PayClientFactory;
import com.mickeymeng.framework.module.pay.core.client.dto.PayNotifyDataDTO;
import com.mickeymeng.framework.module.pay.service.order.PayOrderService;
import com.mickeymeng.framework.module.pay.service.refund.PayRefundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import java.util.Map;

import static com.mickeymeng.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.mickeymeng.framework.module.pay.enums.ErrorCodeConstants.PAY_CHANNEL_CLIENT_NOT_FOUND;

@Api(tags = "管理后台 - 支付通知")
@RestController
@RequestMapping("/pay/notify")
@Validated
@Slf4j
public class PayNotifyController {

    @Resource
    private PayOrderService orderService;
    @Resource
    private PayRefundService refundService;

    @Resource
    private PayClientFactory payClientFactory;

    /**
     * 统一的跳转页面，支付宝跳转参数说明
     *
     * <a href="https://opendocs.alipay.com/open/203/105285#前台回跳参数说明">支付宝 - 前台回跳参数说明</a>
     *
     * @param channelId 渠道编号
     * @return 返回跳转页面
     */
    @GetMapping(value = "/return/{channelId}")
    @ApiOperation("渠道统一的支付成功返回地址")
    @Deprecated // TODO yunai：如果是 way 的情况，应该是跳转回前端地址
    public String returnCallback(@PathVariable("channelId") Long channelId,
                                 @RequestParam Map<String, String> params) {
        log.info("[returnCallback][app_id({}) 跳转]", params.get("app_id"));
        return String.format("渠道[%s]支付成功", channelId);
    }

    /**
     * 统一的渠道支付回调，支付宝的退款回调
     *
     * @param channelId 渠道编号
     * @param params form 参数
     * @param body request body
     * @return 成功返回 "success"
     */
    @PostMapping(value = "/callback/{channelId}")
    @ApiOperation(value = "支付渠道的统一回调接口", notes = "包括支付回调，退款回调")
    @PermitAll
    @OperateLog(enable = false) // 回调地址，无需记录操作日志
    public String notifyCallback(@PathVariable("channelId") Long channelId,
                                 @RequestParam Map<String, String> params,
                                 @RequestBody String body) throws Exception {
        // 校验支付渠道是否存在
        PayClient payClient = payClientFactory.getPayClient(channelId);
        if (payClient == null) {
            log.error("[notifyCallback][渠道编号({}) 找不到对应的支付客户端]", channelId);
            throw exception(PAY_CHANNEL_CLIENT_NOT_FOUND);
        }
        // 校验通知数据是否合法
        PayNotifyDataDTO notifyData = PayNotifyDataDTO.builder().params(params).body(body).build();
        payClient.verifyNotifyData(notifyData);

        // 情况一：如果是退款，则发起退款通知
        if (payClient.isRefundNotify(notifyData)) {
            refundService.notifyPayRefund(channelId, PayNotifyDataDTO.builder().params(params).body(body).build());
            return "success";
        }

        // 情况二：如果非退款，则发起支付通知
        orderService.notifyPayOrder(channelId, PayNotifyDataDTO.builder().params(params).body(body).build());
        return "success";
    }


}
