package cn.iocoder.yudao.module.community.controller.app.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel("用户 APP - 用户个人信息 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserInfoRespVO {

    @ApiModelProperty(value = "用户昵称", required = true, example = "Mickey")
    private String nickname;

    @ApiModelProperty(value = "真实姓名", required = true, example = "潇梦")
    private String realName;

    @ApiModelProperty(value = "性别(M-男,F-女)", required = true, example = "M")
    private String gender;

    @ApiModelProperty(value = "身份证号码", required = true, example = "610101200012121234")
    private String idCardNumber;

    @ApiModelProperty(value = "用户手机号", required = true, example = "15601691300")
    private String phoneNumber;

    @ApiModelProperty(value = "微信号", required = true)
    private String wechatId;

    @ApiModelProperty(value = "QQ号码", required = true)
    private String qqNumber;

    @ApiModelProperty(value = "邮箱", required = true)
    private String email;

    @ApiModelProperty(value = "出生日期", required = true)
    private LocalDate birthday;

    @ApiModelProperty(value = "用户头像", required = true, example = "/infra/file/get/35a12e57-4297-4faa-bf7d-7ed2f211c952")
    private String portrait;

    @ApiModelProperty(value = "个性签名", required = true)
    private String signature;

    @ApiModelProperty(value = "注册方式", required = true)
    private String logonMode;

    @ApiModelProperty(value = "业主类型", required = true)
    private String ownerType;

    @ApiModelProperty(value = "注册IP", required = true)
    private String registerIp;

    @ApiModelProperty(value = "登录IP", required = true)
    private String loginIp;

    @ApiModelProperty(value = "登录日期", required = true)
    private LocalDateTime loginDate;

    @ApiModelProperty(value = "实名认证通过", required = true)
    private Boolean authenticated;
}
