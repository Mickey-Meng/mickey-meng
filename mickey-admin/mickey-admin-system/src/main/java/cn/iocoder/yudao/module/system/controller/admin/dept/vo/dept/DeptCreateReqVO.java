package cn.iocoder.yudao.module.system.controller.admin.dept.vo.dept;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 部门创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeptCreateReqVO extends DeptBaseVO {
}
