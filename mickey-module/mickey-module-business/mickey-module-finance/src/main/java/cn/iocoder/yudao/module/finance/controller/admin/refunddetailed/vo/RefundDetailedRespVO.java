package cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - 键值参数 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RefundDetailedRespVO extends RefundDetailedBaseVO {

    @ApiModelProperty(value = "主键ID", required = true, example = "395")
    private String refundDetailedId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
