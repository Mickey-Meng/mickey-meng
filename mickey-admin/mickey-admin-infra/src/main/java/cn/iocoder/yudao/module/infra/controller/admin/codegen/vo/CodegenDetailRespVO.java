package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo;

import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.column.CodegenColumnRespVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table.CodegenTableRespVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel("管理后台 - 代码生成表和字段的明细 Response VO")
@Data
@Accessors(chain = true)
public class CodegenDetailRespVO {

    @ApiModelProperty("表定义")
    private CodegenTableRespVO table;

    @ApiModelProperty("字段定义")
    private List<CodegenColumnRespVO> columns;

}
