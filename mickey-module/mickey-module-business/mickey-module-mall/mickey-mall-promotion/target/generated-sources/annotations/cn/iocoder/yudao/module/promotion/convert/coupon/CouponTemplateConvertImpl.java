package cn.iocoder.yudao.module.promotion.convert.coupon;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template.CouponTemplateCreateReqVO;
import cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template.CouponTemplateRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template.CouponTemplateUpdateReqVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.coupon.CouponTemplateDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:07+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CouponTemplateConvertImpl implements CouponTemplateConvert {

    @Override
    public CouponTemplateDO convert(CouponTemplateCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        CouponTemplateDO couponTemplateDO = new CouponTemplateDO();

        couponTemplateDO.setName( bean.getName() );
        couponTemplateDO.setTotalCount( bean.getTotalCount() );
        couponTemplateDO.setTakeLimitCount( bean.getTakeLimitCount() );
        couponTemplateDO.setTakeType( bean.getTakeType() );
        couponTemplateDO.setUsePrice( bean.getUsePrice() );
        couponTemplateDO.setProductScope( bean.getProductScope() );
        List<Long> list = bean.getProductSpuIds();
        if ( list != null ) {
            couponTemplateDO.setProductSpuIds( new ArrayList<Long>( list ) );
        }
        couponTemplateDO.setValidityType( bean.getValidityType() );
        couponTemplateDO.setValidStartTime( bean.getValidStartTime() );
        couponTemplateDO.setValidEndTime( bean.getValidEndTime() );
        couponTemplateDO.setFixedStartTerm( bean.getFixedStartTerm() );
        couponTemplateDO.setFixedEndTerm( bean.getFixedEndTerm() );
        couponTemplateDO.setDiscountType( bean.getDiscountType() );
        couponTemplateDO.setDiscountPercent( bean.getDiscountPercent() );
        couponTemplateDO.setDiscountPrice( bean.getDiscountPrice() );
        couponTemplateDO.setDiscountLimitPrice( bean.getDiscountLimitPrice() );

        return couponTemplateDO;
    }

    @Override
    public CouponTemplateDO convert(CouponTemplateUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        CouponTemplateDO couponTemplateDO = new CouponTemplateDO();

        couponTemplateDO.setId( bean.getId() );
        couponTemplateDO.setName( bean.getName() );
        couponTemplateDO.setTotalCount( bean.getTotalCount() );
        couponTemplateDO.setTakeLimitCount( bean.getTakeLimitCount() );
        couponTemplateDO.setTakeType( bean.getTakeType() );
        couponTemplateDO.setUsePrice( bean.getUsePrice() );
        couponTemplateDO.setProductScope( bean.getProductScope() );
        List<Long> list = bean.getProductSpuIds();
        if ( list != null ) {
            couponTemplateDO.setProductSpuIds( new ArrayList<Long>( list ) );
        }
        couponTemplateDO.setValidityType( bean.getValidityType() );
        couponTemplateDO.setValidStartTime( bean.getValidStartTime() );
        couponTemplateDO.setValidEndTime( bean.getValidEndTime() );
        couponTemplateDO.setFixedStartTerm( bean.getFixedStartTerm() );
        couponTemplateDO.setFixedEndTerm( bean.getFixedEndTerm() );
        couponTemplateDO.setDiscountType( bean.getDiscountType() );
        couponTemplateDO.setDiscountPercent( bean.getDiscountPercent() );
        couponTemplateDO.setDiscountPrice( bean.getDiscountPrice() );
        couponTemplateDO.setDiscountLimitPrice( bean.getDiscountLimitPrice() );

        return couponTemplateDO;
    }

    @Override
    public CouponTemplateRespVO convert(CouponTemplateDO bean) {
        if ( bean == null ) {
            return null;
        }

        CouponTemplateRespVO couponTemplateRespVO = new CouponTemplateRespVO();

        couponTemplateRespVO.setName( bean.getName() );
        couponTemplateRespVO.setTotalCount( bean.getTotalCount() );
        couponTemplateRespVO.setTakeLimitCount( bean.getTakeLimitCount() );
        couponTemplateRespVO.setTakeType( bean.getTakeType() );
        couponTemplateRespVO.setUsePrice( bean.getUsePrice() );
        couponTemplateRespVO.setProductScope( bean.getProductScope() );
        List<Long> list = bean.getProductSpuIds();
        if ( list != null ) {
            couponTemplateRespVO.setProductSpuIds( new ArrayList<Long>( list ) );
        }
        couponTemplateRespVO.setValidityType( bean.getValidityType() );
        couponTemplateRespVO.setValidStartTime( bean.getValidStartTime() );
        couponTemplateRespVO.setValidEndTime( bean.getValidEndTime() );
        couponTemplateRespVO.setFixedStartTerm( bean.getFixedStartTerm() );
        couponTemplateRespVO.setFixedEndTerm( bean.getFixedEndTerm() );
        couponTemplateRespVO.setDiscountType( bean.getDiscountType() );
        couponTemplateRespVO.setDiscountPercent( bean.getDiscountPercent() );
        couponTemplateRespVO.setDiscountPrice( bean.getDiscountPrice() );
        couponTemplateRespVO.setDiscountLimitPrice( bean.getDiscountLimitPrice() );
        couponTemplateRespVO.setId( bean.getId() );
        couponTemplateRespVO.setStatus( bean.getStatus() );
        couponTemplateRespVO.setTakeCount( bean.getTakeCount() );
        couponTemplateRespVO.setUseCount( bean.getUseCount() );
        couponTemplateRespVO.setCreateTime( bean.getCreateTime() );

        return couponTemplateRespVO;
    }

    @Override
    public PageResult<CouponTemplateRespVO> convertPage(PageResult<CouponTemplateDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<CouponTemplateRespVO> pageResult = new PageResult<CouponTemplateRespVO>();

        pageResult.setList( couponTemplateDOListToCouponTemplateRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected List<CouponTemplateRespVO> couponTemplateDOListToCouponTemplateRespVOList(List<CouponTemplateDO> list) {
        if ( list == null ) {
            return null;
        }

        List<CouponTemplateRespVO> list1 = new ArrayList<CouponTemplateRespVO>( list.size() );
        for ( CouponTemplateDO couponTemplateDO : list ) {
            list1.add( convert( couponTemplateDO ) );
        }

        return list1;
    }
}
