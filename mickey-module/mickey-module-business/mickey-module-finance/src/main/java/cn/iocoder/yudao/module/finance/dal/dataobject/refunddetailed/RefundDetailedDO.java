package cn.iocoder.yudao.module.finance.dal.dataobject.refunddetailed;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@TableName("finance_refund_detailed")
@KeySequence("finance_refund_detailed_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefundDetailedDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    private String refundDetailedId;
    /**
     * 退款单ID - 外键
     */
    private String receivablesId;
    /**
     * 退款单号
     */
    private String refundNumber;
    /**
     * 退款账户
     */
    private String refundAccount;
    /**
     * 退款金额
     */
    private BigDecimal itemRefundAmount;
    /**
     * 退款人
     */
    private String refundUser;
    /**
     * 收银员(财务)
     */
    private String cashierCode;
    /**
     * 退款时间
     */
    private LocalDateTime refundDate;
    /**
     * 审核状态(0:未审核;1:已审核)
     */
    private String approvalState;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 创建用户
     */
    private String creator;
    /**
     * 修改用户
     */
    private String updater;

}
