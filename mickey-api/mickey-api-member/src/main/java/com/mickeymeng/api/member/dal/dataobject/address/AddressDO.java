package com.mickeymeng.api.member.dal.dataobject.address;

import com.mickeymeng.framework.common.base.mybatis.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 用户收件地址 DO
 *
 * @author 芋道源码
 */
@TableName("member_address")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Accessors(chain = true)
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
    private Long userId;
    /**
     * 收件人名称
     */
    private String name;
    /**
     * 手机号
     */
    private String mobile;
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
    private String detailAddress;
    /**
     * 是否默认
     *
     * true - 默认收件地址
     */
    private Boolean defaulted;

}
