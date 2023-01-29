package cn.iocoder.yudao.module.community.dal.dataobject.owner;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import lombok.experimental.Accessors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 业主信息 DO
 *
 * @author Mickey
 */
@TableName(value = "community_owner", autoResultMap = true)
@KeySequence("community_owner_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDO extends BaseDO {

    /**
     * ID主键
     */
    @TableId
    public Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别:M-男,F-女
     */
    private String gender;
    /**
     * 身份证号码
     */
    private String idCardNumber;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 微信号
     */
    private String wechatId;
    /**
     * QQ号码
     */
    private String qqNumber;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 出生日期
     */
    private LocalDate birthday;
    /**
     * 头像
     */
    private String portrait;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 注册方式
     */
    private String logonMode;
    /**
     * 业主类型
     */
    private String ownerType;
    /**
     * 注册IP
     */
    private String registerIp;
    /**
     * 登录IP
     */
    private String loginIp;
    /**
     * 登录日期
     */
    private LocalDateTime loginDate;
    /**
     * 密码 因为目前使用 {@link BCryptPasswordEncoder} 加密器，所以无需自己处理 salt 盐
     */
    private String password;

    /**
     * 实名认证通过
     */
    private Boolean authenticated;

    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remark;

    /**
     * 多租户编号
     */
    private Long tenantId;

}
