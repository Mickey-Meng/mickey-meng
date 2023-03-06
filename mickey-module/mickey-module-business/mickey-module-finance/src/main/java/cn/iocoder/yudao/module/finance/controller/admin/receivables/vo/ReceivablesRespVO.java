package cn.iocoder.yudao.module.finance.controller.admin.receivables.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 键值参数 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReceivablesRespVO extends ReceivablesBaseVO {

    @ApiModelProperty(value = "主键ID", required = true, example = "31360")
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
