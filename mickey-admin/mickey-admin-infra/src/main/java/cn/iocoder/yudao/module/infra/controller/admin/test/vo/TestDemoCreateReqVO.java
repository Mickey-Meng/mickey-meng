package cn.iocoder.yudao.module.infra.controller.admin.test.vo;

import lombok.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 字典类型创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TestDemoCreateReqVO extends TestDemoBaseVO {

}
