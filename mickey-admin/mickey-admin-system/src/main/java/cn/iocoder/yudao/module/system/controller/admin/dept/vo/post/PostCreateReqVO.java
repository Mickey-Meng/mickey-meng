package cn.iocoder.yudao.module.system.controller.admin.dept.vo.post;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;

@ApiModel("管理后台 - 岗位创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class PostCreateReqVO extends PostBaseVO {
}
