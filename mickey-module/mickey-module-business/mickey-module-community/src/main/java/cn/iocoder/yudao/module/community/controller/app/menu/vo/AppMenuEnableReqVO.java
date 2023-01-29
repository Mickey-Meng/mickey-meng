package cn.iocoder.yudao.module.community.controller.app.menu.vo;

import cn.iocoder.yudao.module.community.controller.admin.menu.vo.MenuExportReqVO;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@ApiModel("用户端 - 服务列表菜单查询 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMenuEnableReqVO extends MenuExportReqVO {

}
