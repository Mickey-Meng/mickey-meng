package cn.iocoder.yudao.module.infra.controller.admin.test.vo;

import lombok.*;

import java.time.LocalDateTime;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 字典类型 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TestDemoRespVO extends TestDemoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
