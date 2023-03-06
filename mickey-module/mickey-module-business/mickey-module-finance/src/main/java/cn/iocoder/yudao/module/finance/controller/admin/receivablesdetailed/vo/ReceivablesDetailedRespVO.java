package cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 键值参数 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReceivablesDetailedRespVO extends ReceivablesDetailedBaseVO {

    @ApiModelProperty(value = "主键ID", required = true, example = "29379")
    private String receivablesDetailedId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
