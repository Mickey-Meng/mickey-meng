package cn.iocoder.yudao.module.community.dal.dataobject.address;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 用户收件地址 DO
 *
 * @author 芋道源码
 */
@TableName("community_address")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 用户编号
     */
    private Long ownerId;
    /**
     * 收件人名称
     */
    private String receiverName;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 地区编号
     */
    private Long areaId;
    /**
     * 邮编
     */
    private String postCode;
    /**
     * 收件详细地址
     */
    private String detailedAddress;
    /**
     * 是否默认
     *
     * true - 默认收件地址
     */
    private Boolean defaulted;

}
