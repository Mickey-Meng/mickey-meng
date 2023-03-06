package cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 键值参数 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
@Accessors(chain = true)
public class RefundDetailedBaseVO {

    @ApiModelProperty(value = "退款单ID - 外键", required = true, example = "26182")
    @NotNull(message = "退款单ID - 外键不能为空")
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
    private LocalDateTime refundDate;

    @ApiModelProperty(value = "审核状态(0:未审核;1:已审核)")
    private String approvalState;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "创建用户")
    private String creator;

    @ApiModelProperty(value = "修改用户")
    private String updater;

}
