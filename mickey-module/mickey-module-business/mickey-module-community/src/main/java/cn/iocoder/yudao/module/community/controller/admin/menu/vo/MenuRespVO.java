package cn.iocoder.yudao.module.community.controller.admin.menu.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 服务列表菜单 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuRespVO extends MenuBaseVO {

    @ApiModelProperty(value = "ID主键", required = true, example = "10271")
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
