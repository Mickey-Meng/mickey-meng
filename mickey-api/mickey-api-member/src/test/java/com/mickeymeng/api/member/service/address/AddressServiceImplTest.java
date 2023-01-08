package com.mickeymeng.api.member.service.address;

import com.mickeymeng.api.member.controller.app.address.vo.AppAddressCreateReqVO;
import com.mickeymeng.api.member.dal.dataobject.address.AddressDO;
import com.mickeymeng.api.member.dal.mysql.address.AddressMapper;
import com.mickeymeng.api.member.enums.ErrorCodeConstants;
import com.mickeymeng.framework.common.core.util.random.RandomUtils;
import com.mickeymeng.framework.test.core.ut.BaseDbUnitTest;
import com.mickeymeng.api.member.controller.app.address.vo.AppAddressUpdateReqVO;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

import static com.mickeymeng.framework.test.core.util.AssertUtils.assertPojoEquals;
import static com.mickeymeng.framework.test.core.util.AssertUtils.assertServiceException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
* {@link AddressServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(AddressServiceImpl.class)
public class AddressServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AddressServiceImpl addressService;

    @Resource
    private AddressMapper addressMapper;

    @Test
    public void testCreateAddress_success() {
        // 准备参数
        AppAddressCreateReqVO reqVO = RandomUtils.randomPojo(AppAddressCreateReqVO.class);

        // 调用
        Long addressId = addressService.createAddress(RandomUtils.randomLongId(), reqVO);
        // 断言
        assertNotNull(addressId);
        // 校验记录的属性是否正确
        AddressDO address = addressMapper.selectById(addressId);
        assertPojoEquals(reqVO, address);
    }

    @Test
    public void testUpdateAddress_success() {
        // mock 数据
        AddressDO dbAddress = RandomUtils.randomPojo(AddressDO.class);
        addressMapper.insert(dbAddress);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AppAddressUpdateReqVO reqVO = RandomUtils.randomPojo(AppAddressUpdateReqVO.class, o -> {
            o.setId(dbAddress.getId()); // 设置更新的 ID
        });

        // 调用
        addressService.updateAddress(dbAddress.getUserId(), reqVO);
        // 校验是否更新正确
        AddressDO address = addressMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, address);
    }

    @Test
    public void testUpdateAddress_notExists() {
        // 准备参数
        AppAddressUpdateReqVO reqVO = RandomUtils.randomPojo(AppAddressUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> addressService.updateAddress(RandomUtils.randomLongId(), reqVO), ErrorCodeConstants.ADDRESS_NOT_EXISTS);
    }

    @Test
    public void testDeleteAddress_success() {
        // mock 数据
        AddressDO dbAddress = RandomUtils.randomPojo(AddressDO.class);
        addressMapper.insert(dbAddress);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAddress.getId();

        // 调用
        addressService.deleteAddress(dbAddress.getUserId(), id);
       // 校验数据不存在了
       assertNull(addressMapper.selectById(id));
    }

    @Test
    public void testDeleteAddress_notExists() {
        // 准备参数
        Long id = RandomUtils.randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> addressService.deleteAddress(RandomUtils.randomLongId(), id), ErrorCodeConstants.ADDRESS_NOT_EXISTS);
    }

}
