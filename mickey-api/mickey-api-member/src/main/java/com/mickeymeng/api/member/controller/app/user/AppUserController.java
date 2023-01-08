package com.mickeymeng.api.member.controller.app.user;

import com.mickeymeng.framework.common.constants.ErrorCodeConstants;
import com.mickeymeng.framework.common.pojo.CommonResult;
import com.mickeymeng.framework.security.core.annotations.PreAuthenticated;
import com.mickeymeng.api.member.controller.app.user.vo.AppUserInfoRespVO;
import com.mickeymeng.api.member.controller.app.user.vo.AppUserUpdateMobileReqVO;
import com.mickeymeng.api.member.convert.user.UserConvert;
import com.mickeymeng.api.member.dal.dataobject.user.MemberUserDO;
import com.mickeymeng.api.member.service.user.MemberUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.mickeymeng.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.mickeymeng.framework.common.pojo.CommonResult.success;
import static com.mickeymeng.framework.common.core.util.security.SecurityFrameworkUtils.getLoginUserId;

@Api(tags = "用户 APP - 用户个人中心")
@RestController
@RequestMapping("/member/user")
@Validated
@Slf4j
public class AppUserController {

    @Resource
    private MemberUserService userService;

    @PutMapping("/update-nickname")
    @ApiOperation("修改用户昵称")
    @PreAuthenticated
    public CommonResult<Boolean> updateUserNickname(@RequestParam("nickname") String nickname) {
        userService.updateUserNickname(getLoginUserId(), nickname);
        return success(true);
    }

    @PostMapping("/update-avatar")
    @ApiOperation("修改用户头像")
    @PreAuthenticated
    public CommonResult<String> updateUserAvatar(@RequestParam("avatarFile") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw exception(ErrorCodeConstants.FILE_IS_EMPTY);
        }
        String avatar = userService.updateUserAvatar(getLoginUserId(), file.getInputStream());
        return success(avatar);
    }

    @GetMapping("/get")
    @ApiOperation("获得基本信息")
    @PreAuthenticated
    public CommonResult<AppUserInfoRespVO> getUserInfo() {
        MemberUserDO user = userService.getUser(getLoginUserId());
        return success(UserConvert.INSTANCE.convert(user));
    }

    @PostMapping("/update-mobile")
    @ApiOperation(value = "修改用户手机")
    @PreAuthenticated
    public CommonResult<Boolean> updateMobile(@RequestBody @Valid AppUserUpdateMobileReqVO reqVO) {
        userService.updateUserMobile(getLoginUserId(), reqVO);
        return success(true);
    }

}

