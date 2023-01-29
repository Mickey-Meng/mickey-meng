package cn.iocoder.yudao.module.community.dal.dataobject.community;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import lombok.experimental.Accessors;

/**
 * 小区信息 DO
 *
 * @author Mickey
 */
@TableName("community_community")
@KeySequence("community_community_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDO extends BaseDO {

    /**
     * ID主键
     */
    @TableId
    private Integer id;
    /**
     * 小区名称
     */
    private String communityName;
    /**
     * 小区编码
     */
    private String communityCode;
    /**
     * 省区划码
     */
    private String provincesCode;
    /**
     * 市区划码
     */
    private String cityCode;
    /**
     * 区县区划码
     */
    private String districtCode;
    /**
     * 乡镇划码
     */
    private String townCode;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 物业ID
     */
    private Integer propertyId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remark;

}
