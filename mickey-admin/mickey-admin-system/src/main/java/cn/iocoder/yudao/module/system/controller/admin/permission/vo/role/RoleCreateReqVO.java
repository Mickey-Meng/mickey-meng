package cn.iocoder.yudao.module.system.controller.admin.permission.vo.role;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;

@ApiModel("管理后台 - 角色创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class RoleCreateReqVO extends RoleBaseVO {

}
