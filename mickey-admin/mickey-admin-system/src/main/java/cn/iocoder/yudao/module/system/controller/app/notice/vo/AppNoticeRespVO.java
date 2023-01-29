package cn.iocoder.yudao.module.system.controller.app.notice.vo;

import cn.iocoder.yudao.module.system.controller.admin.notice.vo.NoticeBaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@ApiModel("管理后台 - 通知公告信息 Response VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class AppNoticeRespVO extends NoticeBaseVO {

    @ApiModelProperty(value = "通知公告序号", required = true, example = "1024")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true, example = "时间戳格式")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "通知渠道", example = "1", notes = "参见 NoticeChannelEnum 枚举类")
    private Integer channel;

}
