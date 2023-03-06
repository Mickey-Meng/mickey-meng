package cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@ApiModel("管理后台 - 键值参数创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RefundDetailedCreateReqVO extends RefundDetailedBaseVO {

}
