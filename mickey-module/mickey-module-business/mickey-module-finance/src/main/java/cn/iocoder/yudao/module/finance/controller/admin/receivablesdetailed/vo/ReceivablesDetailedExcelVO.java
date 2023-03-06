package cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo;

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
public class ReceivablesDetailedExcelVO {

    @ExcelProperty("主键ID")
    private String receivablesDetailedId;

    @ExcelProperty("收款单ID - 外键")
    private String receivablesId;

    @ExcelProperty("收据单号")
    private String receiptNumber;

    @ExcelProperty("收款账户")
    private String collectionAccount;

    @ExcelProperty("收款金额")
    private BigDecimal itemCollectedAmount;

    @ExcelProperty("收款人")
    private String collectionUser;

    @ExcelProperty("收银员(财务)")
    private String cashierCode;

    @ExcelProperty("收款时间")
    private LocalDateTime collectionDate;

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
