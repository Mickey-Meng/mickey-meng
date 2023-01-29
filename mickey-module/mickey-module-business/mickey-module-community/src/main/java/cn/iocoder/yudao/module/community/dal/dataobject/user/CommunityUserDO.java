package cn.iocoder.yudao.module.community.dal.dataobject.user;

import cn.iocoder.yudao.module.community.dal.dataobject.owner.OwnerDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 会员用户 DO
 *
 * uk_mobile 索引：基于 {@link } 字段
 *
 * @author 芋道源码
 */
@TableName(value = "community_owner", autoResultMap = true)
@KeySequence("community_owner_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@NoArgsConstructor
public class CommunityUserDO extends OwnerDO {



}
