package cn.iocoder.yudao.module.community.controller.admin.menu.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import lombok.*;
import io.swagger.annotations.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

/**
* 服务列表菜单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
@Accessors(chain = true)
public class MenuBaseVO {

    @ApiModelProperty(value = "菜单名称(中文)", example = "王五")
    private String menuZhName;

    @ApiModelProperty(value = "菜单名称(英文)", example = "张三")
    private String menuEnName;

    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;

    @ApiModelProperty(value = "图标样式")
    private String iconStyle;

    @ApiModelProperty(value = "路由地址")
    private String routePath;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否缓存")
    private Boolean keepAlive;

    @ApiModelProperty(value = "显示顺序", required = true)
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

}
