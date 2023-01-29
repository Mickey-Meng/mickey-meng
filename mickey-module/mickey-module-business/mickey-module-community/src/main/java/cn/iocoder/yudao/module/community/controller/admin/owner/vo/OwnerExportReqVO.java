package cn.iocoder.yudao.module.community.controller.admin.owner.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;

import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 业主信息 Excel 导出 Request VO", description = "参数和 OwnerPageReqVO 是一致的")
@Data
@Accessors(chain = true)
public class OwnerExportReqVO {

    @ApiModelProperty(value = "昵称", example = "赵六")
    private String nickname;

    @ApiModelProperty(value = "真实姓名", example = "李四")
    private String realName;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别:M-男,F-女")
    private String gender;

    @ApiModelProperty(value = "身份证号码")
    private String idCardNumber;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "微信号", example = "1461")
    private String wechatId;

    @ApiModelProperty(value = "QQ号码")
    private String qqNumber;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "头像")
    private String portrait;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "状态（0正常 1停用）", example = "2")
    private Integer status;

    @ApiModelProperty(value = "注册方式")
    private String logonMode;

    @ApiModelProperty(value = "业主类型", example = "1")
    private String ownerType;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "备注", example = "你说的对")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
