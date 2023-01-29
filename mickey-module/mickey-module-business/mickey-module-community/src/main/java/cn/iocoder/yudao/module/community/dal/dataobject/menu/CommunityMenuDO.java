package cn.iocoder.yudao.module.community.dal.dataobject.menu;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import lombok.experimental.Accessors;

/**
 * 服务列表菜单 DO
 *
 * @author Mickey
 */
@TableName("community_menu")
@KeySequence("community_menu_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityMenuDO extends BaseDO {

    /**
     * ID主键
     */
    @TableId
    private Integer id;
    /**
     * 菜单名称(中文)
     */
    private String menuZhName;
    /**
     * 菜单名称(英文)
     */
    private String menuEnName;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 图标样式
     */
    private String iconStyle;
    /**
     * 路由地址
     */
    private String routePath;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;
    /**
     * 是否缓存
     *
     * 只有菜单、目录使用
     * 是否使用 Vue 路由的 keep-alive 特性
     */
    private Boolean keepAlive;
    /**
     * 显示顺序
     */
    private Integer sort;

}
