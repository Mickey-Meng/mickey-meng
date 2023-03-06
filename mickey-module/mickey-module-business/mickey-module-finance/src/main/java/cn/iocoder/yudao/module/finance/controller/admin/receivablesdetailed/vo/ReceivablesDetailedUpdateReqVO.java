package cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@ApiModel("管理后台 - 键值参数更新 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReceivablesDetailedUpdateReqVO extends ReceivablesDetailedBaseVO {

    @ApiModelProperty(value = "主键ID", required = true, example = "29379")
    @NotNull(message = "主键ID不能为空")
    private String receivablesDetailedId;

}
