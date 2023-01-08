package com.mickeymeng.admin.system.service.logger;

import cn.hutool.core.util.RandomUtil;
import com.mickeymeng.framework.common.enums.UserTypeEnum;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.common.core.util.monitor.TracerUtils;
import com.mickeymeng.framework.common.core.util.object.ObjectUtils;
import com.mickeymeng.framework.test.core.ut.BaseDbUnitTest;
import com.mickeymeng.framework.common.core.util.random.RandomUtils;
import com.mickeymeng.framework.common.service.dto.LoginLogCreateReqDTO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.loginlog.LoginLogExportReqVO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import com.mickeymeng.admin.system.dal.dataobject.logger.LoginLogDO;
import com.mickeymeng.admin.system.dal.mysql.logger.LoginLogMapper;
import com.mickeymeng.framework.common.enums.logger.LoginLogTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import static cn.hutool.core.util.RandomUtil.randomEle;
import static com.mickeymeng.framework.common.core.util.date.LocalDateTimeUtils.buildTime;
import static com.mickeymeng.framework.test.core.util.AssertUtils.assertPojoEquals;
import static com.mickeymeng.framework.common.enums.logger.LoginResultEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(LoginLogServiceImpl.class)
public class LoginLogServiceImplTest extends BaseDbUnitTest {

    @Resource
    private LoginLogServiceImpl loginLogService;

    @Resource
    private LoginLogMapper loginLogMapper;

    @Test
    public void testGetLoginLogPage() {
        // 构造测试数据
        // 登录成功的
        LoginLogDO loginLogDO = RandomUtils.randomPojo(LoginLogDO.class, logDO -> {
            logDO.setLogType(RandomUtil.randomEle(LoginLogTypeEnum.values()).getType());
            logDO.setTraceId(TracerUtils.getTraceId());
            logDO.setUserType(RandomUtil.randomEle(UserTypeEnum.values()).getValue());

            logDO.setUserIp("192.168.199.16");
            logDO.setUsername("wangkai");
            logDO.setCreateTime(buildTime(2021, 3, 6));
            logDO.setResult(SUCCESS.getResult());
        });
        loginLogMapper.insert(loginLogDO);

        // 下面几个都是不匹配的数据
        // 登录失败的
        loginLogMapper.insert(ObjectUtils.cloneIgnoreId(loginLogDO, logDO -> logDO.setResult(CAPTCHA_CODE_ERROR.getResult())));
        // 不同ip段的
        loginLogMapper.insert(ObjectUtils.cloneIgnoreId(loginLogDO, logDO -> logDO.setUserIp("192.168.128.18")));
        // 不同username
        loginLogMapper.insert(ObjectUtils.cloneIgnoreId(loginLogDO, logDO -> logDO.setUsername("yunai")));
        // 构造一个早期时间 2021-02-06 00:00:00
        loginLogMapper.insert(ObjectUtils.cloneIgnoreId(loginLogDO, logDO -> logDO.setCreateTime(buildTime(2021, 2, 6))));


        // 构造调用参数
        LoginLogPageReqVO reqVO = new LoginLogPageReqVO();
        reqVO.setUsername("wangkai");
        reqVO.setUserIp("192.168.199");
        reqVO.setStatus(true);
        reqVO.setCreateTime((new LocalDateTime[]{buildTime(2021, 3, 5),
                buildTime(2021, 3, 7)}));

        // 调用service方法
        PageResult<LoginLogDO> pageResult = loginLogService.getLoginLogPage(reqVO);

        // 断言，只查到了一条符合条件的
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(loginLogDO, pageResult.getList().get(0));
    }

    @Test
    public void testGetLoginLogList() {
        // 构造测试数据

        // 登录成功的
        LoginLogDO loginLogDO = RandomUtils.randomPojo(LoginLogDO.class, logDO -> {
            logDO.setLogType(RandomUtil.randomEle(LoginLogTypeEnum.values()).getType());
            logDO.setTraceId(TracerUtils.getTraceId());
            logDO.setUserType(RandomUtil.randomEle(UserTypeEnum.values()).getValue());

            logDO.setUserIp("192.168.111.16");
            logDO.setUsername("wangxiaokai");
            logDO.setCreateTime(buildTime(2021, 3, 6));
            logDO.setResult(SUCCESS.getResult());
        });
        loginLogMapper.insert(loginLogDO);

        // 下面几个都是不匹配的数据
        // 登录失败的
        loginLogMapper.insert(ObjectUtils.cloneIgnoreId(loginLogDO, logDO -> logDO.setResult(CAPTCHA_CODE_ERROR.getResult())));
        // 不同ip段的
        loginLogMapper.insert(ObjectUtils.cloneIgnoreId(loginLogDO, logDO -> logDO.setUserIp("192.168.128.18")));
        // 不同username
        loginLogMapper.insert(ObjectUtils.cloneIgnoreId(loginLogDO, logDO -> logDO.setUsername("yunai")));
        // 构造一个早期时间 2021-02-06 00:00:00
        loginLogMapper.insert(ObjectUtils.cloneIgnoreId(loginLogDO, logDO -> logDO.setCreateTime(buildTime(2021, 2, 6))));

        // 构造调用参数
        LoginLogExportReqVO reqVO = new LoginLogExportReqVO();
        reqVO.setUsername("wangxiaokai");
        reqVO.setUserIp("192.168.111");
        reqVO.setStatus(true);
        reqVO.setCreateTime((new LocalDateTime[]{buildTime(2021, 3, 5),
                buildTime(2021, 3, 7)}));

        // 调用service方法
        List<LoginLogDO> loginLogList = loginLogService.getLoginLogList(reqVO);

        // 断言
        assertEquals(1, loginLogList.size());
        assertPojoEquals(loginLogDO, loginLogList.get(0));
    }

    @Test
    public void testCreateLoginLog() {
        LoginLogCreateReqDTO reqDTO = RandomUtils.randomPojo(LoginLogCreateReqDTO.class, vo -> {
            // 指定随机的范围,避免超出范围入库失败
            vo.setUserType(randomEle(UserTypeEnum.values()).getValue());
            vo.setLogType(randomEle(LoginLogTypeEnum.values()).getType());
            vo.setResult(randomEle(values()).getResult());
            vo.setTraceId(TracerUtils.getTraceId());
        });

        // 调用
        loginLogService.createLoginLog(reqDTO);
        // 断言，忽略基本字段
        LoginLogDO sysLoginLogDO = loginLogMapper.selectOne(null);
        assertPojoEquals(reqDTO, sysLoginLogDO);
    }

}
