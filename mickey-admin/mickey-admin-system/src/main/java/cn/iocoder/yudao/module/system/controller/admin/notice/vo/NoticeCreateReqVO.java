package cn.iocoder.yudao.module.system.controller.admin.notice.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;

@ApiModel("管理后台 - 通知公告创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class NoticeCreateReqVO extends NoticeBaseVO {
}
