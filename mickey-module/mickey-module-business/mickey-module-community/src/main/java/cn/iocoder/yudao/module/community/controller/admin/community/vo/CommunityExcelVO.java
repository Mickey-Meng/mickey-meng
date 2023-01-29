package cn.iocoder.yudao.module.community.controller.admin.community.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.experimental.Accessors;

/**
 * 小区信息 Excel VO
 *
 * @author Mickey
 */
@Data
@Accessors(chain = true)
public class CommunityExcelVO {

    @ExcelProperty("ID主键")
    private Integer id;

    @ExcelProperty("小区名称")
    private String communityName;

    @ExcelProperty("小区编码")
    private String communityCode;

    @ExcelProperty("省区划码")
    private String provincesCode;

    @ExcelProperty("市区划码")
    private String cityCode;

    @ExcelProperty("区县区划码")
    private String districtCode;

    @ExcelProperty("乡镇划码")
    private String townCode;

    @ExcelProperty("详细地址")
    private String detailedAddress;

    @ExcelProperty("经度")
    private String longitude;

    @ExcelProperty("纬度")
    private String latitude;

    @ExcelProperty("物业ID")
    private Integer propertyId;

    @ExcelProperty("排序")
    private Integer sort;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
