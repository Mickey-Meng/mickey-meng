package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.client;

import lombok.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

@ApiModel("管理后台 - OAuth2 客户端创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OAuth2ClientCreateReqVO extends OAuth2ClientBaseVO {

}
