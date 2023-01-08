package com.mickeymeng.api.member.api.address;

import com.mickeymeng.framework.common.service.dto.AddressRespDTO;
import com.mickeymeng.api.member.convert.address.AddressConvert;
import com.mickeymeng.api.member.service.address.AddressService;

import com.mickeymeng.framework.common.service.api.AddressApi;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 用户收件地址 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AddressApiImpl implements AddressApi {

    @Resource
    private AddressService addressService;

    @Override
    public AddressRespDTO getAddress(Long id, Long userId) {
        return AddressConvert.INSTANCE.convert02(addressService.getAddress(userId, id));
    }

}
