package cn.iocoder.yudao.module.infra.controller.admin.config.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 参数配置创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConfigUpdateReqVO extends ConfigBaseVO {

    @ApiModelProperty(value = "参数配置序号", required = true, example = "1024")
    @NotNull(message = "参数配置编号不能为空")
    private Long id;

}