package cn.iocoder.yudao.module.finance.controller.admin.receivables.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;

import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 键值参数 Excel 导出 Request VO", description = "参数和 ReceivablesPageReqVO 是一致的")
@Data
@Accessors(chain = true)
public class ReceivablesExportReqVO {

    @ApiModelProperty(value = "客户编码")
    private String customerCode;

    @ApiModelProperty(value = "客户名称", example = "赵六")
    private String customerName;

    @ApiModelProperty(value = "联系电话")
    private String telephoneNo;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "销售渠道0:线上;1:线下")
    private String salesChannel;

    @ApiModelProperty(value = "导购员")
    private String shoppingGuide;

    @ApiModelProperty(value = "销售金额")
    private BigDecimal salesAmount;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal preferentialAmount;

    @ApiModelProperty(value = "退货金额")
    private BigDecimal refundGoodsAmount;

    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundAmount;

    @ApiModelProperty(value = "收款金额")
    private BigDecimal collectedAmount;

    @ApiModelProperty(value = "应收余额")
    private BigDecimal receivableBalance;

    @ApiModelProperty(value = "应收金额")
    private BigDecimal receivableAmount;

    @ApiModelProperty(value = "是否结清(Y:是;N:否)")
    private String isSettle;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "审核状态")
    private String approvalState;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @ApiModelProperty(value = "创建用户")
    private String creator;

    @ApiModelProperty(value = "修改用户")
    private String updater;

    @ApiModelProperty(value = "货物类型", example = "2")
    private String goodsType;

}
