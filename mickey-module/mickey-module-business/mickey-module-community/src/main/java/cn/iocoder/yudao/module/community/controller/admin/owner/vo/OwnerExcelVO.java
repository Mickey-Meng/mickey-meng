package cn.iocoder.yudao.module.community.controller.admin.owner.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.experimental.Accessors;

/**
 * 业主信息 Excel VO
 *
 * @author Mickey
 */
@Data
@Accessors(chain = true)
public class OwnerExcelVO {

    @ExcelProperty("ID主键")
    private Integer id;

    @ExcelProperty("昵称")
    private String nickname;

    @ExcelProperty("真实姓名")
    private String realName;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("性别:M-男,F-女")
    private String gender;

    @ExcelProperty("身份证号码")
    private String idCardNumber;

    @ExcelProperty("手机号码")
    private String phoneNumber;

    @ExcelProperty("微信号")
    private String wechatId;

    @ExcelProperty("QQ号码")
    private String qqNumber;

    @ExcelProperty("邮箱")
    private String email;

    @ExcelProperty("出生日期")
    private LocalDate birthday;

    @ExcelProperty("头像")
    private String portrait;

    @ExcelProperty("个性签名")
    private String signature;

    @ExcelProperty("状态（0正常 1停用）")
    private Integer status;

    @ExcelProperty("注册方式")
    private String logonMode;

    @ExcelProperty("业主类型")
    private String ownerType;

    @ExcelProperty("密码")
    private String password;

    @ExcelProperty("排序")
    private Integer sort;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
