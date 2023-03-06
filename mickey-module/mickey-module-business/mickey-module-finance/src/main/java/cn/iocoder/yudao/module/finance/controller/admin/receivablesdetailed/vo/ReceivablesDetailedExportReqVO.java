package cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;

import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 键值参数 Excel 导出 Request VO", description = "参数和 ReceivablesDetailedPageReqVO 是一致的")
@Data
@Accessors(chain = true)
public class ReceivablesDetailedExportReqVO {

    @ApiModelProperty(value = "收款单ID - 外键", example = "15899")
    private String receivablesId;

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
    private LocalDateTime[] collectionDate;

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
