package com.mickeymeng.framework.common.service.api;

import com.mickeymeng.framework.common.service.dto.AddressRespDTO;

/**
 * 用户收件地址 API 接口
 *
 * @author 芋道源码
 */
public interface AddressApi {

    /**
     * 获得用户收件地址
     *
     * @param id 收件地址编号
     * @param userId 用户编号
     * @return 用户收件地址
     */
    AddressRespDTO getAddress(Long id, Long userId);

}
