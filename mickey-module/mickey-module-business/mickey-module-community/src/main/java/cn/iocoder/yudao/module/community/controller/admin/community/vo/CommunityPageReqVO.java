package cn.iocoder.yudao.module.community.controller.admin.community.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 小区信息分页 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommunityPageReqVO extends PageParam {

    @ApiModelProperty(value = "小区名称", example = "芋艿")
    private String communityName;

    @ApiModelProperty(value = "小区编码")
    private String communityCode;

    @ApiModelProperty(value = "省区划码")
    private String provincesCode;

    @ApiModelProperty(value = "市区划码")
    private String cityCode;

    @ApiModelProperty(value = "区县区划码")
    private String districtCode;

    @ApiModelProperty(value = "乡镇划码")
    private String townCode;

    @ApiModelProperty(value = "详细地址")
    private String detailedAddress;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "物业ID", example = "11255")
    private Integer propertyId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "备注", example = "随便")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
