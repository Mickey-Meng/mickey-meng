package cn.iocoder.yudao.module.finance.controller.admin.receivables.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

/**
* 键值参数 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
@Accessors(chain = true)
public class ReceivablesBaseVO {

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

    @ApiModelProperty(value = "创建用户")
    private String createBy;

    @ApiModelProperty(value = "修改用户")
    private String updateBy;

    @ApiModelProperty(value = "货物类型", example = "2")
    private String goodsType;

}
