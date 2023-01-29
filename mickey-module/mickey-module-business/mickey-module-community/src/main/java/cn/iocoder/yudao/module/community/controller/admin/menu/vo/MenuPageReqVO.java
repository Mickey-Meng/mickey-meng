package cn.iocoder.yudao.module.community.controller.admin.menu.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 服务列表菜单分页 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuPageReqVO extends PageParam {

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

    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
