package cn.iocoder.yudao.module.promotion.convert.discount;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityBaseVO;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityCreateReqVO;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityDetailRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityUpdateReqVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.discount.DiscountActivityDO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.discount.DiscountProductDO;
import cn.iocoder.yudao.module.promotion.service.discount.bo.DiscountProductDetailBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:07+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class DiscountActivityConvertImpl implements DiscountActivityConvert {

    @Override
    public DiscountActivityDO convert(DiscountActivityCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        DiscountActivityDO discountActivityDO = new DiscountActivityDO();

        discountActivityDO.setName( bean.getName() );
        discountActivityDO.setStartTime( bean.getStartTime() );
        discountActivityDO.setEndTime( bean.getEndTime() );
        discountActivityDO.setRemark( bean.getRemark() );

        return discountActivityDO;
    }

    @Override
    public DiscountActivityDO convert(DiscountActivityUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        DiscountActivityDO discountActivityDO = new DiscountActivityDO();

        discountActivityDO.setId( bean.getId() );
        discountActivityDO.setName( bean.getName() );
        discountActivityDO.setStartTime( bean.getStartTime() );
        discountActivityDO.setEndTime( bean.getEndTime() );
        discountActivityDO.setRemark( bean.getRemark() );

        return discountActivityDO;
    }

    @Override
    public DiscountActivityRespVO convert(DiscountActivityDO bean) {
        if ( bean == null ) {
            return null;
        }

        DiscountActivityRespVO discountActivityRespVO = new DiscountActivityRespVO();

        discountActivityRespVO.setName( bean.getName() );
        discountActivityRespVO.setStartTime( bean.getStartTime() );
        discountActivityRespVO.setEndTime( bean.getEndTime() );
        discountActivityRespVO.setRemark( bean.getRemark() );
        discountActivityRespVO.setId( bean.getId() );
        discountActivityRespVO.setStatus( bean.getStatus() );
        discountActivityRespVO.setCreateTime( bean.getCreateTime() );

        return discountActivityRespVO;
    }

    @Override
    public List<DiscountActivityRespVO> convertList(List<DiscountActivityDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DiscountActivityRespVO> list1 = new ArrayList<DiscountActivityRespVO>( list.size() );
        for ( DiscountActivityDO discountActivityDO : list ) {
            list1.add( convert( discountActivityDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<DiscountActivityRespVO> convertPage(PageResult<DiscountActivityDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<DiscountActivityRespVO> pageResult = new PageResult<DiscountActivityRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public DiscountProductDetailBO convert(DiscountProductDO product) {
        if ( product == null ) {
            return null;
        }

        DiscountProductDetailBO discountProductDetailBO = new DiscountProductDetailBO();

        discountProductDetailBO.setId( product.getId() );
        discountProductDetailBO.setActivityId( product.getActivityId() );
        discountProductDetailBO.setSpuId( product.getSpuId() );
        discountProductDetailBO.setSkuId( product.getSkuId() );
        discountProductDetailBO.setDiscountType( product.getDiscountType() );
        discountProductDetailBO.setDiscountPercent( product.getDiscountPercent() );
        discountProductDetailBO.setDiscountPrice( product.getDiscountPrice() );

        return discountProductDetailBO;
    }

    @Override
    public DiscountProductDO convert(DiscountActivityBaseVO.Product bean) {
        if ( bean == null ) {
            return null;
        }

        DiscountProductDO discountProductDO = new DiscountProductDO();

        discountProductDO.setSpuId( bean.getSpuId() );
        discountProductDO.setSkuId( bean.getSkuId() );
        discountProductDO.setDiscountType( bean.getDiscountType() );
        discountProductDO.setDiscountPercent( bean.getDiscountPercent() );
        discountProductDO.setDiscountPrice( bean.getDiscountPrice() );

        return discountProductDO;
    }

    @Override
    public DiscountActivityDetailRespVO convert(DiscountActivityDO activity, List<DiscountProductDO> products) {
        if ( activity == null && products == null ) {
            return null;
        }

        DiscountActivityDetailRespVO discountActivityDetailRespVO = new DiscountActivityDetailRespVO();

        if ( activity != null ) {
            discountActivityDetailRespVO.setName( activity.getName() );
            discountActivityDetailRespVO.setStartTime( activity.getStartTime() );
            discountActivityDetailRespVO.setEndTime( activity.getEndTime() );
            discountActivityDetailRespVO.setRemark( activity.getRemark() );
            discountActivityDetailRespVO.setId( activity.getId() );
            discountActivityDetailRespVO.setStatus( activity.getStatus() );
            discountActivityDetailRespVO.setCreateTime( activity.getCreateTime() );
        }
        discountActivityDetailRespVO.setProducts( discountProductDOListToProductList( products ) );

        return discountActivityDetailRespVO;
    }

    protected DiscountActivityBaseVO.Product discountProductDOToProduct(DiscountProductDO discountProductDO) {
        if ( discountProductDO == null ) {
            return null;
        }

        DiscountActivityBaseVO.Product product = new DiscountActivityBaseVO.Product();

        product.setSpuId( discountProductDO.getSpuId() );
        product.setSkuId( discountProductDO.getSkuId() );
        product.setDiscountType( discountProductDO.getDiscountType() );
        product.setDiscountPercent( discountProductDO.getDiscountPercent() );
        product.setDiscountPrice( discountProductDO.getDiscountPrice() );

        return product;
    }

    protected List<DiscountActivityBaseVO.Product> discountProductDOListToProductList(List<DiscountProductDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DiscountActivityBaseVO.Product> list1 = new ArrayList<DiscountActivityBaseVO.Product>( list.size() );
        for ( DiscountProductDO discountProductDO : list ) {
            list1.add( discountProductDOToProduct( discountProductDO ) );
        }

        return list1;
    }
}
