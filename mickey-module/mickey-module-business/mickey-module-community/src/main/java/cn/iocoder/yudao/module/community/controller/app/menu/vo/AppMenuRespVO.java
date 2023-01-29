package cn.iocoder.yudao.module.community.controller.app.menu.vo;

import cn.iocoder.yudao.module.community.controller.admin.menu.vo.MenuBaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@ApiModel("用户端 - 服务列表菜单 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMenuRespVO extends MenuBaseVO {

    @ApiModelProperty(value = "ID主键", required = true, example = "10271")
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
