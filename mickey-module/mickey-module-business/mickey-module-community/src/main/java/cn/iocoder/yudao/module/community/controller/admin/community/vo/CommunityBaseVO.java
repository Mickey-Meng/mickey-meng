package cn.iocoder.yudao.module.community.controller.admin.community.vo;

import lombok.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

/**
* 小区信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
@Accessors(chain = true)
public class CommunityBaseVO {

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
