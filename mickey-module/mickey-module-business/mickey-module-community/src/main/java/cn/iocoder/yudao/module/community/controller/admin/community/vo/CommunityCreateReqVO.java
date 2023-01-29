package cn.iocoder.yudao.module.community.controller.admin.community.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@ApiModel("管理后台 - 小区信息创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommunityCreateReqVO extends CommunityBaseVO {

}
