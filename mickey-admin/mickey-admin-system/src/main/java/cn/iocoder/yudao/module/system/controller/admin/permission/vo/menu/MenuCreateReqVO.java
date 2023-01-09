package cn.iocoder.yudao.module.system.controller.admin.permission.vo.menu;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 菜单创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MenuCreateReqVO extends MenuBaseVO {
}
