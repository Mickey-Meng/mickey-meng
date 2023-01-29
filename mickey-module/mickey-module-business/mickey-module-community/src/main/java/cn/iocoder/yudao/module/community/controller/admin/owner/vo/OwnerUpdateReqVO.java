package cn.iocoder.yudao.module.community.controller.admin.owner.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@ApiModel("管理后台 - 业主信息更新 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OwnerUpdateReqVO extends OwnerBaseVO {

    @ApiModelProperty(value = "ID主键", required = true, example = "807")
    @NotNull(message = "ID主键不能为空")
    private Long id;

}
