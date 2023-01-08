package com.mickeymeng.framework.module.bpm.controller.admin.oa.vo;

import com.mickeymeng.framework.common.core.util.date.DateUtils;
import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import com.mickeymeng.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel("管理后台 - 请假申请分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmOALeavePageReqVO extends PageParam {

    @ApiModelProperty(value = "状态", example = "1", notes = "参见 bpm_process_instance_result 枚举")
    private Integer result;

    @ApiModelProperty(value = "请假类型", example = "1", notes = "参见 bpm_oa_type")
    private Integer type;

    @ApiModelProperty(value = "原因", example = "阅读芋道源码", notes = "模糊匹配")
    private String reason;

    @DateTimeFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @ApiModelProperty(value = "申请时间")
    private LocalDateTime[] createTime;

}