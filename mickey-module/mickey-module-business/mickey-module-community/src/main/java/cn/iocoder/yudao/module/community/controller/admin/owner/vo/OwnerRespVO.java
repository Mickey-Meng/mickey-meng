package cn.iocoder.yudao.module.community.controller.admin.owner.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 业主信息 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OwnerRespVO extends OwnerBaseVO {

    @ApiModelProperty(value = "ID主键", required = true, example = "807")
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
