package com.mickeymeng.api.member.convert.address;

import com.mickeymeng.framework.common.service.dto.AddressRespDTO;
import com.mickeymeng.api.member.controller.app.address.vo.AppAddressCreateReqVO;
import com.mickeymeng.api.member.controller.app.address.vo.AppAddressRespVO;
import com.mickeymeng.api.member.controller.app.address.vo.AppAddressUpdateReqVO;
import com.mickeymeng.api.member.dal.dataobject.address.AddressDO;
import com.mickeymeng.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户收件地址 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AddressConvert {

    AddressConvert INSTANCE = Mappers.getMapper(AddressConvert.class);

    AddressDO convert(AppAddressCreateReqVO bean);

    AddressDO convert(AppAddressUpdateReqVO bean);

    AppAddressRespVO convert(AddressDO bean);

    List<AppAddressRespVO> convertList(List<AddressDO> list);

    PageResult<AppAddressRespVO> convertPage(PageResult<AddressDO> page);

    AddressRespDTO convert02(AddressDO bean);

}
