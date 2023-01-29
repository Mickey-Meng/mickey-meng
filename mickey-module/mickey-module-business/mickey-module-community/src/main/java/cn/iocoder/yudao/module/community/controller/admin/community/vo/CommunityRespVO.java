package cn.iocoder.yudao.module.community.controller.admin.community.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 小区信息 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommunityRespVO extends CommunityBaseVO {

    @ApiModelProperty(value = "ID主键", required = true, example = "8276")
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
