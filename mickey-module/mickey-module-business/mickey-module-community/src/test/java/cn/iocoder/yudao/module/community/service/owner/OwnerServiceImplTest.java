package cn.iocoder.yudao.module.community.service.owner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.community.controller.admin.owner.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.owner.OwnerDO;
import cn.iocoder.yudao.module.community.dal.mysql.owner.OwnerMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.community.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link OwnerServiceImpl} 的单元测试类
*
* @author Mickey
*/
@Import(OwnerServiceImpl.class)
public class OwnerServiceImplTest extends BaseDbUnitTest {

    @Resource
    private OwnerServiceImpl ownerService;

    @Resource
    private OwnerMapper ownerMapper;

    @Test
    public void testCreateOwner_success() {
        // 准备参数
        OwnerCreateReqVO reqVO = randomPojo(OwnerCreateReqVO.class);

        // 调用
        Long ownerId = ownerService.createOwner(reqVO);
        // 断言
        assertNotNull(ownerId);
        // 校验记录的属性是否正确
        OwnerDO owner = ownerMapper.selectById(ownerId);
        assertPojoEquals(reqVO, owner);
    }

    @Test
    public void testUpdateOwner_success() {
        // mock 数据
        OwnerDO dbOwner = randomPojo(OwnerDO.class);
        ownerMapper.insert(dbOwner);// @Sql: 先插入出一条存在的数据
        // 准备参数
        OwnerUpdateReqVO reqVO = randomPojo(OwnerUpdateReqVO.class, o -> {
            o.setId(dbOwner.getId()); // 设置更新的 ID
        });

        // 调用
        ownerService.updateOwner(reqVO);
        // 校验是否更新正确
        OwnerDO owner = ownerMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, owner);
    }

    @Test
    public void testUpdateOwner_notExists() {
        // 准备参数
        OwnerUpdateReqVO reqVO = randomPojo(OwnerUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> ownerService.updateOwner(reqVO), OWNER_NOT_EXISTS);
    }

    @Test
    public void testDeleteOwner_success() {
        // mock 数据
        OwnerDO dbOwner = randomPojo(OwnerDO.class);
        ownerMapper.insert(dbOwner);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbOwner.getId();

        // 调用
        ownerService.deleteOwner(id);
       // 校验数据不存在了
       assertNull(ownerMapper.selectById(id));
    }

    @Test
    public void testDeleteOwner_notExists() {
        // 准备参数
        //Integer id = randomIntegerId();

        // 调用, 并断言异常
        //assertServiceException(() -> ownerService.deleteOwner(id), OWNER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOwnerPage() {
       // mock 数据
       OwnerDO dbOwner = randomPojo(OwnerDO.class, o -> { // 等会查询到
           o.setNickname(null);
           o.setRealName(null);
           o.setAge(null);
           o.setGender(null);
           o.setIdCardNumber(null);
           o.setPhoneNumber(null);
           o.setWechatId(null);
           o.setQqNumber(null);
           o.setEmail(null);
           o.setBirthday(null);
           o.setPortrait(null);
           o.setSignature(null);
           o.setStatus(null);
           o.setLogonMode(null);
           o.setOwnerType(null);
           o.setPassword(null);
           o.setSort(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       ownerMapper.insert(dbOwner);
       // 测试 nickname 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setNickname(null)));
       // 测试 realName 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setRealName(null)));
       // 测试 age 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setAge(null)));
       // 测试 gender 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setGender(null)));
       // 测试 idCardNumber 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setIdCardNumber(null)));
       // 测试 phoneNumber 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setPhoneNumber(null)));
       // 测试 wechatId 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setWechatId(null)));
       // 测试 qqNumber 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setQqNumber(null)));
       // 测试 email 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setEmail(null)));
       // 测试 birthday 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setBirthday(null)));
       // 测试 portrait 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setPortrait(null)));
       // 测试 signature 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setSignature(null)));
       // 测试 status 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setStatus(null)));
       // 测试 logonMode 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setLogonMode(null)));
       // 测试 ownerType 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setOwnerType(null)));
       // 测试 password 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setPassword(null)));
       // 测试 sort 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setSort(null)));
       // 测试 remark 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setCreateTime(null)));
       // 准备参数
       OwnerPageReqVO reqVO = new OwnerPageReqVO();
       reqVO.setNickname(null);
       reqVO.setRealName(null);
       reqVO.setAge(null);
       reqVO.setGender(null);
       reqVO.setIdCardNumber(null);
       reqVO.setPhoneNumber(null);
       reqVO.setWechatId(null);
       reqVO.setQqNumber(null);
       reqVO.setEmail(null);
       reqVO.setBirthday(null);
       reqVO.setPortrait(null);
       reqVO.setSignature(null);
       reqVO.setStatus(null);
       reqVO.setLogonMode(null);
       reqVO.setOwnerType(null);
       reqVO.setPassword(null);
       reqVO.setSort(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<OwnerDO> pageResult = ownerService.getOwnerPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbOwner, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOwnerList() {
       // mock 数据
       OwnerDO dbOwner = randomPojo(OwnerDO.class, o -> { // 等会查询到
           o.setNickname(null);
           o.setRealName(null);
           o.setAge(null);
           o.setGender(null);
           o.setIdCardNumber(null);
           o.setPhoneNumber(null);
           o.setWechatId(null);
           o.setQqNumber(null);
           o.setEmail(null);
           o.setBirthday(null);
           o.setPortrait(null);
           o.setSignature(null);
           o.setStatus(null);
           o.setLogonMode(null);
           o.setOwnerType(null);
           o.setPassword(null);
           o.setSort(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       ownerMapper.insert(dbOwner);
       // 测试 nickname 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setNickname(null)));
       // 测试 realName 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setRealName(null)));
       // 测试 age 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setAge(null)));
       // 测试 gender 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setGender(null)));
       // 测试 idCardNumber 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setIdCardNumber(null)));
       // 测试 phoneNumber 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setPhoneNumber(null)));
       // 测试 wechatId 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setWechatId(null)));
       // 测试 qqNumber 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setQqNumber(null)));
       // 测试 email 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setEmail(null)));
       // 测试 birthday 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setBirthday(null)));
       // 测试 portrait 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setPortrait(null)));
       // 测试 signature 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setSignature(null)));
       // 测试 status 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setStatus(null)));
       // 测试 logonMode 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setLogonMode(null)));
       // 测试 ownerType 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setOwnerType(null)));
       // 测试 password 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setPassword(null)));
       // 测试 sort 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setSort(null)));
       // 测试 remark 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       ownerMapper.insert(cloneIgnoreId(dbOwner, o -> o.setCreateTime(null)));
       // 准备参数
       OwnerExportReqVO reqVO = new OwnerExportReqVO();
       reqVO.setNickname(null);
       reqVO.setRealName(null);
       reqVO.setAge(null);
       reqVO.setGender(null);
       reqVO.setIdCardNumber(null);
       reqVO.setPhoneNumber(null);
       reqVO.setWechatId(null);
       reqVO.setQqNumber(null);
       reqVO.setEmail(null);
       reqVO.setBirthday(null);
       reqVO.setPortrait(null);
       reqVO.setSignature(null);
       reqVO.setStatus(null);
       reqVO.setLogonMode(null);
       reqVO.setOwnerType(null);
       reqVO.setPassword(null);
       reqVO.setSort(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<OwnerDO> list = ownerService.getOwnerList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbOwner, list.get(0));
    }

}
