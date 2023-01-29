package cn.iocoder.yudao.module.community.controller.app.community.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@ApiModel("用户端 - 小区信息 Response VO")
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class AppCommunityRespVO {

    @ApiModelProperty(value = "ID主键", required = true, example = "8276")
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

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

}
