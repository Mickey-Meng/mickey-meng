package cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@ApiModel("管理后台 - 租户套餐更新 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantPackageUpdateReqVO extends TenantPackageBaseVO {

    @ApiModelProperty(value = "套餐编号", required = true, example = "1024")
    @NotNull(message = "套餐编号不能为空")
    private Long id;

}
