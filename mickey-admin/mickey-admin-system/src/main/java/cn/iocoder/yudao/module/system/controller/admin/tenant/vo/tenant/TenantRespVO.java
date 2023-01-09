package cn.iocoder.yudao.module.system.controller.admin.tenant.vo.tenant;

import lombok.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@ApiModel("管理后台 - 租户 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantRespVO extends TenantBaseVO {

    @ApiModelProperty(value = "租户编号", required = true, example = "1024")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
