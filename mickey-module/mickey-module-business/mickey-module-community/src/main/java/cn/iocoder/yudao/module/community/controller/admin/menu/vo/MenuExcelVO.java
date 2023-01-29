package cn.iocoder.yudao.module.community.controller.admin.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.experimental.Accessors;

/**
 * 服务列表菜单 Excel VO
 *
 * @author Mickey
 */
@Data
@Accessors(chain = true)
public class MenuExcelVO {

    @ExcelProperty("ID主键")
    private Integer id;

    @ExcelProperty("菜单名称(中文)")
    private String menuZhName;

    @ExcelProperty("菜单名称(英文)")
    private String menuEnName;

    @ExcelProperty("菜单图标")
    private String menuIcon;

    @ExcelProperty("图标样式")
    private String iconStyle;

    @ExcelProperty("路由地址")
    private String routePath;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("是否缓存")
    private Boolean keepAlive;

    @ExcelProperty("显示顺序")
    private Integer sort;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
