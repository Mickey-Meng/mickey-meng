package cn.iocoder.yudao.module.promotion.convert.coupon;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.coupon.CouponPageItemRespVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.coupon.CouponDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:07+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CouponConvertImpl implements CouponConvert {

    @Override
    public PageResult<CouponPageItemRespVO> convertPage(PageResult<CouponDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<CouponPageItemRespVO> pageResult = new PageResult<CouponPageItemRespVO>();

        pageResult.setList( couponDOListToCouponPageItemRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected CouponPageItemRespVO couponDOToCouponPageItemRespVO(CouponDO couponDO) {
        if ( couponDO == null ) {
            return null;
        }

        CouponPageItemRespVO couponPageItemRespVO = new CouponPageItemRespVO();

        couponPageItemRespVO.setTemplateId( couponDO.getTemplateId() );
        couponPageItemRespVO.setName( couponDO.getName() );
        couponPageItemRespVO.setStatus( couponDO.getStatus() );
        couponPageItemRespVO.setUserId( couponDO.getUserId() );
        couponPageItemRespVO.setTakeType( couponDO.getTakeType() );
        couponPageItemRespVO.setUsePrice( couponDO.getUsePrice() );
        couponPageItemRespVO.setValidStartTime( couponDO.getValidStartTime() );
        couponPageItemRespVO.setValidEndTime( couponDO.getValidEndTime() );
        couponPageItemRespVO.setProductScope( couponDO.getProductScope() );
        List<Long> list = couponDO.getProductSpuIds();
        if ( list != null ) {
            couponPageItemRespVO.setProductSpuIds( new ArrayList<Long>( list ) );
        }
        couponPageItemRespVO.setDiscountType( couponDO.getDiscountType() );
        couponPageItemRespVO.setDiscountPercent( couponDO.getDiscountPercent() );
        couponPageItemRespVO.setDiscountPrice( couponDO.getDiscountPrice() );
        couponPageItemRespVO.setDiscountLimitPrice( couponDO.getDiscountLimitPrice() );
        couponPageItemRespVO.setUseOrderId( couponDO.getUseOrderId() );
        couponPageItemRespVO.setUseTime( couponDO.getUseTime() );
        couponPageItemRespVO.setId( couponDO.getId() );
        couponPageItemRespVO.setCreateTime( couponDO.getCreateTime() );

        return couponPageItemRespVO;
    }

    protected List<CouponPageItemRespVO> couponDOListToCouponPageItemRespVOList(List<CouponDO> list) {
        if ( list == null ) {
            return null;
        }

        List<CouponPageItemRespVO> list1 = new ArrayList<CouponPageItemRespVO>( list.size() );
        for ( CouponDO couponDO : list ) {
            list1.add( couponDOToCouponPageItemRespVO( couponDO ) );
        }

        return list1;
    }
}
