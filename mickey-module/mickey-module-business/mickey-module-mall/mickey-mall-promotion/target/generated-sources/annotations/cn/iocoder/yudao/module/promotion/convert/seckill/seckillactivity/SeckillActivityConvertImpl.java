package cn.iocoder.yudao.module.promotion.convert.seckill.seckillactivity;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity.SeckillActivityBaseVO;
import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity.SeckillActivityCreateReqVO;
import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity.SeckillActivityDetailRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity.SeckillActivityRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity.SeckillActivityUpdateReqVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.seckill.seckillactivity.SeckillActivityDO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.seckill.seckillactivity.SeckillProductDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:07+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class SeckillActivityConvertImpl implements SeckillActivityConvert {

    @Override
    public SeckillProductDO convert(SeckillActivityBaseVO.Product product) {
        if ( product == null ) {
            return null;
        }

        SeckillProductDO seckillProductDO = new SeckillProductDO();

        seckillProductDO.setSpuId( product.getSpuId() );
        seckillProductDO.setSkuId( product.getSkuId() );
        seckillProductDO.setSeckillPrice( product.getSeckillPrice() );
        seckillProductDO.setStock( product.getStock() );
        seckillProductDO.setLimitBuyCount( product.getLimitBuyCount() );

        return seckillProductDO;
    }

    @Override
    public SeckillActivityDO convert(SeckillActivityCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        SeckillActivityDO seckillActivityDO = new SeckillActivityDO();

        seckillActivityDO.setName( bean.getName() );
        seckillActivityDO.setRemark( bean.getRemark() );
        seckillActivityDO.setStartTime( bean.getStartTime() );
        seckillActivityDO.setEndTime( bean.getEndTime() );
        seckillActivityDO.setSort( bean.getSort() );
        List<Long> list = bean.getTimeIds();
        if ( list != null ) {
            seckillActivityDO.setTimeIds( new ArrayList<Long>( list ) );
        }

        return seckillActivityDO;
    }

    @Override
    public SeckillActivityDO convert(SeckillActivityUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        SeckillActivityDO seckillActivityDO = new SeckillActivityDO();

        seckillActivityDO.setId( bean.getId() );
        seckillActivityDO.setName( bean.getName() );
        seckillActivityDO.setRemark( bean.getRemark() );
        seckillActivityDO.setStartTime( bean.getStartTime() );
        seckillActivityDO.setEndTime( bean.getEndTime() );
        seckillActivityDO.setSort( bean.getSort() );
        List<Long> list = bean.getTimeIds();
        if ( list != null ) {
            seckillActivityDO.setTimeIds( new ArrayList<Long>( list ) );
        }

        return seckillActivityDO;
    }

    @Override
    public SeckillActivityRespVO convert(SeckillActivityDO bean) {
        if ( bean == null ) {
            return null;
        }

        SeckillActivityRespVO seckillActivityRespVO = new SeckillActivityRespVO();

        seckillActivityRespVO.setName( bean.getName() );
        seckillActivityRespVO.setStartTime( bean.getStartTime() );
        seckillActivityRespVO.setEndTime( bean.getEndTime() );
        seckillActivityRespVO.setId( bean.getId() );
        seckillActivityRespVO.setOrderCount( bean.getOrderCount() );
        seckillActivityRespVO.setUserCount( bean.getUserCount() );
        seckillActivityRespVO.setCreateTime( bean.getCreateTime() );
        List<Long> list = bean.getTimeIds();
        if ( list != null ) {
            seckillActivityRespVO.setTimeIds( new ArrayList<Long>( list ) );
        }
        seckillActivityRespVO.setSort( bean.getSort() );
        seckillActivityRespVO.setRemark( bean.getRemark() );
        seckillActivityRespVO.setStatus( bean.getStatus() );

        return seckillActivityRespVO;
    }

    @Override
    public List<SeckillActivityRespVO> convertList(List<SeckillActivityDO> list) {
        if ( list == null ) {
            return null;
        }

        List<SeckillActivityRespVO> list1 = new ArrayList<SeckillActivityRespVO>( list.size() );
        for ( SeckillActivityDO seckillActivityDO : list ) {
            list1.add( convert( seckillActivityDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<SeckillActivityRespVO> convertPage(PageResult<SeckillActivityDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<SeckillActivityRespVO> pageResult = new PageResult<SeckillActivityRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public SeckillActivityDetailRespVO convert(SeckillActivityDO seckillActivity, List<SeckillProductDO> seckillProducts) {
        if ( seckillActivity == null && seckillProducts == null ) {
            return null;
        }

        SeckillActivityDetailRespVO seckillActivityDetailRespVO = new SeckillActivityDetailRespVO();

        if ( seckillActivity != null ) {
            seckillActivityDetailRespVO.setName( seckillActivity.getName() );
            seckillActivityDetailRespVO.setStartTime( seckillActivity.getStartTime() );
            seckillActivityDetailRespVO.setEndTime( seckillActivity.getEndTime() );
            seckillActivityDetailRespVO.setId( seckillActivity.getId() );
            seckillActivityDetailRespVO.setOrderCount( seckillActivity.getOrderCount() );
            seckillActivityDetailRespVO.setUserCount( seckillActivity.getUserCount() );
            seckillActivityDetailRespVO.setCreateTime( seckillActivity.getCreateTime() );
            List<Long> list1 = seckillActivity.getTimeIds();
            if ( list1 != null ) {
                seckillActivityDetailRespVO.setTimeIds( new ArrayList<Long>( list1 ) );
            }
            seckillActivityDetailRespVO.setSort( seckillActivity.getSort() );
            seckillActivityDetailRespVO.setRemark( seckillActivity.getRemark() );
            seckillActivityDetailRespVO.setStatus( seckillActivity.getStatus() );
        }
        seckillActivityDetailRespVO.setProducts( seckillProductDOListToProductList( seckillProducts ) );

        return seckillActivityDetailRespVO;
    }

    protected SeckillActivityBaseVO.Product seckillProductDOToProduct(SeckillProductDO seckillProductDO) {
        if ( seckillProductDO == null ) {
            return null;
        }

        SeckillActivityBaseVO.Product product = new SeckillActivityBaseVO.Product();

        product.setSpuId( seckillProductDO.getSpuId() );
        product.setSkuId( seckillProductDO.getSkuId() );
        product.setSeckillPrice( seckillProductDO.getSeckillPrice() );
        product.setStock( seckillProductDO.getStock() );
        product.setLimitBuyCount( seckillProductDO.getLimitBuyCount() );

        return product;
    }

    protected List<SeckillActivityBaseVO.Product> seckillProductDOListToProductList(List<SeckillProductDO> list) {
        if ( list == null ) {
            return null;
        }

        List<SeckillActivityBaseVO.Product> list1 = new ArrayList<SeckillActivityBaseVO.Product>( list.size() );
        for ( SeckillProductDO seckillProductDO : list ) {
            list1.add( seckillProductDOToProduct( seckillProductDO ) );
        }

        return list1;
    }
}
