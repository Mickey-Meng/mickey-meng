package com.mickeymeng.admin.infra.controller.admin.config.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.mickeymeng.framework.common.core.convert.excel.DictConvert;
import com.mickeymeng.framework.dict.annotations.DictFormat;
import com.mickeymeng.admin.infra.enums.DictTypeConstants;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 参数配置 Excel 导出响应 VO
 */
@Data
public class ConfigExcelVO {

    @ExcelProperty("参数配置序号")
    private Long id;

    @ExcelProperty("参数键名")
    private String key;

    @ExcelProperty("参数分组")
    private String group;

    @ExcelProperty("参数名称")
    private String name;

    @ExcelProperty("参数键值")
    private String value;

    @ExcelProperty(value = "参数类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CONFIG_TYPE)
    private Integer type;

    @ExcelProperty(value = "是否敏感", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean sensitive;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
