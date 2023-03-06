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

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.experimental.Accessors;

/**
 * 键值参数 Excel VO
 *
 * @author 芋道源码
 */
@Data
@Accessors(chain = true)
public class ReceivablesExcelVO {

    @ExcelProperty("ID主键")
    private Integer id;

    @ExcelProperty("客户编码")
    private String customerCode;

    @ExcelProperty("客户名称")
    private String customerName;

    @ExcelProperty("联系电话")
    private String telephoneNo;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("销售渠道0:线上;1:线下")
    private String salesChannel;

    @ExcelProperty("导购员")
    private String shoppingGuide;

    @ExcelProperty("销售金额")
    private BigDecimal salesAmount;

    @ExcelProperty("优惠金额")
    private BigDecimal preferentialAmount;

    @ExcelProperty("退货金额")
    private BigDecimal refundGoodsAmount;

    @ExcelProperty("退款金额")
    private BigDecimal refundAmount;

    @ExcelProperty("收款金额")
    private BigDecimal collectedAmount;

    @ExcelProperty("应收余额")
    private BigDecimal receivableBalance;

    @ExcelProperty("应收金额")
    private BigDecimal receivableAmount;

    @ExcelProperty("是否结清(Y:是;N:否)")
    private String isSettle;

    @ExcelProperty("备注")
    private String remarks;

    @ExcelProperty("审核状态")
    private String approvalState;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("创建用户")
    private String creator;

    @ExcelProperty("修改用户")
    private String updater;

    @ExcelProperty("货物类型")
    private String goodsType;

}
