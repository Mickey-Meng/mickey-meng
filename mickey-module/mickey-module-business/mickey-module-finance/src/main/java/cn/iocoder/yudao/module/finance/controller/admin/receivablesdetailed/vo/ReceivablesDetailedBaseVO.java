package cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo;

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
public class ReceivablesDetailedBaseVO {

    @ApiModelProperty(value = "收款单ID - 外键", required = true, example = "15899")
    @NotNull(message = "收款单ID - 外键不能为空")
    private Integer receivablesId;

    @ApiModelProperty(value = "收据单号")
    private String receiptNumber;

    @ApiModelProperty(value = "收款账户", example = "8076")
    private String collectionAccount;

    @ApiModelProperty(value = "收款金额")
    private BigDecimal itemCollectedAmount;

    @ApiModelProperty(value = "收款人")
    private String collectionUser;

    @ApiModelProperty(value = "收银员(财务)")
    private String cashierCode;

    @ApiModelProperty(value = "收款时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime collectionDate;

    @ApiModelProperty(value = "审核状态(0:未审核;1:已审核)")
    private String approvalState;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "创建用户")
    private String creator;

    @ApiModelProperty(value = "修改用户")
    private String updater;

}
