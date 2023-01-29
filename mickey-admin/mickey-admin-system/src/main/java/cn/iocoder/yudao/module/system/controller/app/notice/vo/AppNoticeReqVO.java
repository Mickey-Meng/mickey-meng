package cn.iocoder.yudao.module.system.controller.app.notice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("用户APP - 通知公告 Request VO")
@Data
@Accessors(chain = true)
public class AppNoticeReqVO {

    @ApiModelProperty(value = "公告类型", example = "1" , notes = "参见 NoticeTypeEnum.NOTICE 枚举类")
    private Integer type;

    @ApiModelProperty(value = "展示状态", example = "1", notes = "参见 CommonStatusEnum 枚举类")
    private Integer status;

    @ApiModelProperty(value = "通知渠道", example = "1", notes = "参见 NoticeChannelEnum 枚举类")
    private Integer channel;


}
