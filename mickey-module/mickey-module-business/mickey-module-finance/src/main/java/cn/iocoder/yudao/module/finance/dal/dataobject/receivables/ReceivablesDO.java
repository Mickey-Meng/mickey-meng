package cn.iocoder.yudao.module.finance.dal.dataobject.receivables;

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
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import lombok.experimental.Accessors;

/**
 * 键值参数 DO
 *
 * @author 芋道源码
 */
@TableName("finance_receivables")
@KeySequence("finance_receivables_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceivablesDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private String receivablesId;
    /**
     * 客户编码
     */
    private String customerCode;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 联系电话
     */
    private String telephoneNo;
    /**
     * 地址
     */
    private String address;
    /**
     * 销售渠道0:线上;1:线下
     */
    private String salesChannel;
    /**
     * 导购员
     */
    private String shoppingGuide;
    /**
     * 销售金额
     */
    private BigDecimal salesAmount;
    /**
     * 优惠金额
     */
    private BigDecimal preferentialAmount;
    /**
     * 退货金额
     */
    private BigDecimal refundGoodsAmount;
    /**
     * 退款金额
     */
    private BigDecimal refundAmount;
    /**
     * 收款金额
     */
    private BigDecimal collectedAmount;
    /**
     * 应收余额
     */
    private BigDecimal receivableBalance;
    /**
     * 应收金额
     */
    private BigDecimal receivableAmount;
    /**
     * 是否结清(Y:是;N:否)
     */
    private String isSettle;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 审核状态
     */
    private String approvalState;

    /**
     * 货物类型
     */
    private String goodsType;

}
