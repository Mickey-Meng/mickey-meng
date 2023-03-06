package cn.iocoder.yudao.module.finance.dal.dataobject.receivablesdetailed;

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
@TableName("finance_receivables_detailed")
@KeySequence("finance_receivables_detailed_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceivablesDetailedDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    private String receivablesDetailedId;
    /**
     * 收款单ID - 外键
     */
    private String receivablesId;
    /**
     * 收据单号
     */
    private String receiptNumber;
    /**
     * 收款账户
     */
    private String collectionAccount;
    /**
     * 收款金额
     */
    private BigDecimal itemCollectedAmount;
    /**
     * 收款人
     */
    private String collectionUser;
    /**
     * 收银员(财务)
     */
    private String cashierCode;
    /**
     * 收款时间
     */
    private LocalDateTime collectionDate;
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
