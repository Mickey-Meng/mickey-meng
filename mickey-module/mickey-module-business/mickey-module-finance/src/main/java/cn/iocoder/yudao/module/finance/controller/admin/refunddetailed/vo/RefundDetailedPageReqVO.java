package cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 键值参数分页 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RefundDetailedPageReqVO extends PageParam {

    @ApiModelProperty(value = "退款单ID - 外键", example = "26182")
    private String receivablesId;

    @ApiModelProperty(value = "退款单号")
    private String refundNumber;

    @ApiModelProperty(value = "退款账户", example = "11211")
    private String refundAccount;

    @ApiModelProperty(value = "退款金额")
    private BigDecimal itemRefundAmount;

    @ApiModelProperty(value = "退款人")
    private String refundUser;

    @ApiModelProperty(value = "收银员(财务)")
    private String cashierCode;

    @ApiModelProperty(value = "退款时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] refundDate;

    @ApiModelProperty(value = "审核状态(0:未审核;1:已审核)")
    private String approvalState;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @ApiModelProperty(value = "创建用户")
    private String creator;

    @ApiModelProperty(value = "修改用户")
    private String updater;

}
