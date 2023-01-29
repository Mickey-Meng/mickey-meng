package cn.iocoder.yudao.module.community.service.user;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.module.community.dal.dataobject.user.CommunityUserDO;
import cn.iocoder.yudao.module.community.dal.mysql.user.CommunityUserMapper;
import cn.iocoder.yudao.module.infra.api.file.FileApi;
import cn.iocoder.yudao.module.community.controller.app.user.vo.AppUserUpdateMobileReqVO;
import cn.iocoder.yudao.module.system.api.sms.SmsCodeApi;
import cn.iocoder.yudao.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import cn.iocoder.yudao.module.system.enums.sms.SmsSceneEnum;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.servlet.ServletUtils.getClientIP;
import static cn.iocoder.yudao.module.member.enums.ErrorCodeConstants.USER_NOT_EXISTS;

/**
 * 会员 User Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Valid
@Slf4j
public class CommunityUserServiceImpl implements CommunityUserService {

    @Resource
    private CommunityUserMapper memberUserMapper;

    @Resource
    private FileApi fileApi;
    @Resource
    private SmsCodeApi smsCodeApi;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public CommunityUserDO getUserByMobile(String mobile) {
        return memberUserMapper.selectByMobile(mobile);
    }

    @Override
    public List<CommunityUserDO> getUserListByNickname(String nickname) {
        return memberUserMapper.selectListByNicknameLike(nickname);
    }

    @Override
    public CommunityUserDO createUserIfAbsent(String mobile, String registerIp) {
        // 用户已经存在
        CommunityUserDO user = memberUserMapper.selectByMobile(mobile);
        if (user != null) {
            return user;
        }
        // 用户不存在，则进行创建
        return this.createUser(mobile, registerIp);
    }

    private CommunityUserDO createUser(String mobile, String registerIp) {
        // 生成密码
        String password = IdUtil.fastSimpleUUID();
        // 插入用户
        CommunityUserDO user = new CommunityUserDO();
        user.setPhoneNumber(mobile);
        user.setStatus(CommonStatusEnum.ENABLE.getStatus()); // 默认开启
        user.setPassword(encodePassword(password)); // 加密密码
        user.setRegisterIp(registerIp);
        memberUserMapper.insert(user);
        return user;
    }

    @Override
    public void updateUserLogin(Long id, String loginIp) {

        CommunityUserDO communityUserDO = new CommunityUserDO();
        communityUserDO.setId(id)
                       .setLoginIp(loginIp)
                       .setLoginDate(LocalDateTime.now());
        memberUserMapper.updateById(communityUserDO);
    }

    @Override
    public CommunityUserDO getUser(Long id) {
        return memberUserMapper.selectById(id);
    }

    @Override
    public List<CommunityUserDO> getUserList(Collection<Long> ids) {
        return memberUserMapper.selectBatchIds(ids);
    }

    @Override
    public void updateUserNickname(Long userId, String nickname) {
        CommunityUserDO user = this.checkUserExists(userId);
        // 仅当新昵称不等于旧昵称时进行修改
        if (nickname.equals(user.getNickname())){
            return;
        }
        CommunityUserDO userDO = new CommunityUserDO();
        userDO.setId(user.getId());
        userDO.setNickname(nickname);
        memberUserMapper.updateById(userDO);
    }

    @Override
    public String updateUserAvatar(Long userId, InputStream avatarFile) throws Exception {
        this.checkUserExists(userId);
        // 创建文件
        String avatar = fileApi.createFile(IoUtil.readBytes(avatarFile));
        // 更新头像路径
        CommunityUserDO communityUserDO = new CommunityUserDO();
        communityUserDO.setId(userId).setPortrait(avatar);
        memberUserMapper.updateById(communityUserDO);
        return avatar;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserMobile(Long userId, AppUserUpdateMobileReqVO reqVO) {
        // 检测用户是否存在
        checkUserExists(userId);
        // TODO 芋艿：oldMobile 应该不用传递

        // 校验旧手机和旧验证码
        smsCodeApi.useSmsCode(new SmsCodeUseReqDTO().setMobile(reqVO.getOldMobile()).setCode(reqVO.getOldCode())
                .setScene(SmsSceneEnum.MEMBER_UPDATE_MOBILE.getScene()).setUsedIp(getClientIP()));
        // 使用新验证码
        smsCodeApi.useSmsCode(new SmsCodeUseReqDTO().setMobile(reqVO.getMobile()).setCode(reqVO.getCode())
                .setScene(SmsSceneEnum.MEMBER_UPDATE_MOBILE.getScene()).setUsedIp(getClientIP()));

        // 更新用户手机
        CommunityUserDO communityUserDO = new CommunityUserDO();
        communityUserDO.setId(userId).setPhoneNumber(reqVO.getMobile());
        memberUserMapper.updateById(communityUserDO);
    }

    @Override
    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 对密码进行加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @VisibleForTesting
    public CommunityUserDO checkUserExists(Long id) {
        if (id == null) {
            return null;
        }
        CommunityUserDO user = memberUserMapper.selectById(id);
        if (user == null) {
            throw exception(USER_NOT_EXISTS);
        }
        return user;
    }

}
