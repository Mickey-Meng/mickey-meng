package cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
public class RefundDetailedExcelVO {

    @ExcelProperty("主键ID")
    private String refundDetailedId;

    @ExcelProperty("退款单ID - 外键")
    private String receivablesId;

    @ExcelProperty("退款单号")
    private String refundNumber;

    @ExcelProperty("退款账户")
    private String refundAccount;

    @ExcelProperty("退款金额")
    private BigDecimal itemRefundAmount;

    @ExcelProperty("退款人")
    private String refundUser;

    @ExcelProperty("收银员(财务)")
    private String cashierCode;

    @ExcelProperty("退款时间")
    private LocalDateTime refundDate;

    @ExcelProperty("审核状态(0:未审核;1:已审核)")
    private String approvalState;

    @ExcelProperty("备注")
    private String remarks;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("创建用户")
    private String creator;

    @ExcelProperty("修改用户")
    private String updater;

}
