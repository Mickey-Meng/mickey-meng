package cn.iocoder.yudao.module.community.convert.address;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.community.controller.app.address.vo.AppAddressCreateReqVO;
import cn.iocoder.yudao.module.community.controller.app.address.vo.AppAddressRespVO;
import cn.iocoder.yudao.module.community.controller.app.address.vo.AppAddressUpdateReqVO;
import cn.iocoder.yudao.module.community.dal.dataobject.address.AddressDO;
import cn.iocoder.yudao.module.member.api.address.dto.AddressRespDTO;
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
