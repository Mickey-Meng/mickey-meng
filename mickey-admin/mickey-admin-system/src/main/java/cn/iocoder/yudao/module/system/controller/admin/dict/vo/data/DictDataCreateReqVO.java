package cn.iocoder.yudao.module.system.controller.admin.dict.vo.data;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;

@ApiModel("管理后台 - 字典数据创建 Request VO")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DictDataCreateReqVO extends DictDataBaseVO {

}
