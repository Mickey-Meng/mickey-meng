package cn.iocoder.yudao.module.promotion.convert.price;

import cn.iocoder.yudao.module.promotion.api.price.dto.CouponMeetRespDTO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.coupon.CouponDO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:07+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class PriceConvertImpl implements PriceConvert {

    @Override
    public CouponMeetRespDTO convert(CouponDO coupon) {
        if ( coupon == null ) {
            return null;
        }

        CouponMeetRespDTO couponMeetRespDTO = new CouponMeetRespDTO();

        couponMeetRespDTO.setId( coupon.getId() );

        return couponMeetRespDTO;
    }
}
