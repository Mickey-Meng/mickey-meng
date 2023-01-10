package cn.iocoder.yudao.module.trade.convert.aftersale;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import cn.iocoder.yudao.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import cn.iocoder.yudao.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import cn.iocoder.yudao.module.trade.controller.admin.aftersale.vo.TradeAfterSaleRespPageItemVO;
import cn.iocoder.yudao.module.trade.controller.admin.base.member.user.MemberUserRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.base.product.property.ProductPropertyValueDetailRespVO;
import cn.iocoder.yudao.module.trade.controller.app.aftersale.vo.AppTradeAfterSaleCreateReqVO;
import cn.iocoder.yudao.module.trade.dal.dataobject.aftersale.TradeAfterSaleDO;
import cn.iocoder.yudao.module.trade.dal.dataobject.order.TradeOrderItemDO;
import cn.iocoder.yudao.module.trade.framework.order.config.TradeOrderProperties;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:03+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TradeAfterSaleConvertImpl implements TradeAfterSaleConvert {

    @Override
    public TradeAfterSaleDO convert(AppTradeAfterSaleCreateReqVO createReqVO, TradeOrderItemDO tradeOrderItem) {
        if ( createReqVO == null && tradeOrderItem == null ) {
            return null;
        }

        TradeAfterSaleDO tradeAfterSaleDO = new TradeAfterSaleDO();

        if ( createReqVO != null ) {
            tradeAfterSaleDO.setWay( createReqVO.getWay() );
            tradeAfterSaleDO.setApplyReason( createReqVO.getApplyReason() );
            tradeAfterSaleDO.setApplyDescription( createReqVO.getApplyDescription() );
            List<String> list = createReqVO.getApplyPicUrls();
            if ( list != null ) {
                tradeAfterSaleDO.setApplyPicUrls( new ArrayList<String>( list ) );
            }
            tradeAfterSaleDO.setOrderItemId( createReqVO.getOrderItemId() );
            tradeAfterSaleDO.setRefundPrice( createReqVO.getRefundPrice() );
        }
        if ( tradeOrderItem != null ) {
            tradeAfterSaleDO.setDeleted( tradeOrderItem.getDeleted() );
            tradeAfterSaleDO.setUserId( tradeOrderItem.getUserId() );
            tradeAfterSaleDO.setOrderId( tradeOrderItem.getOrderId() );
            tradeAfterSaleDO.setSpuId( tradeOrderItem.getSpuId() );
            tradeAfterSaleDO.setSpuName( tradeOrderItem.getSpuName() );
            tradeAfterSaleDO.setSkuId( tradeOrderItem.getSkuId() );
            List<TradeOrderItemDO.Property> list1 = tradeOrderItem.getProperties();
            if ( list1 != null ) {
                tradeAfterSaleDO.setProperties( new ArrayList<TradeOrderItemDO.Property>( list1 ) );
            }
            tradeAfterSaleDO.setPicUrl( tradeOrderItem.getPicUrl() );
            tradeAfterSaleDO.setCount( tradeOrderItem.getCount() );
        }

        return tradeAfterSaleDO;
    }

    @Override
    public PayRefundCreateReqDTO convert(String userIp, TradeAfterSaleDO afterSale, TradeOrderProperties orderProperties) {
        if ( userIp == null && afterSale == null && orderProperties == null ) {
            return null;
        }

        PayRefundCreateReqDTO payRefundCreateReqDTO = new PayRefundCreateReqDTO();

        if ( afterSale != null ) {
            if ( afterSale.getOrderId() != null ) {
                payRefundCreateReqDTO.setMerchantOrderId( String.valueOf( afterSale.getOrderId() ) );
            }
            payRefundCreateReqDTO.setReason( afterSale.getApplyReason() );
            payRefundCreateReqDTO.setAmount( afterSale.getRefundPrice() );
        }
        if ( orderProperties != null ) {
            payRefundCreateReqDTO.setAppId( orderProperties.getAppId() );
        }
        payRefundCreateReqDTO.setUserIp( userIp );

        return payRefundCreateReqDTO;
    }

    @Override
    public MemberUserRespVO convert(MemberUserRespDTO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberUserRespVO memberUserRespVO = new MemberUserRespVO();

        memberUserRespVO.setId( bean.getId() );
        memberUserRespVO.setNickname( bean.getNickname() );

        return memberUserRespVO;
    }

    @Override
    public PageResult<TradeAfterSaleRespPageItemVO> convertPage(PageResult<TradeAfterSaleDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<TradeAfterSaleRespPageItemVO> pageResult = new PageResult<TradeAfterSaleRespPageItemVO>();

        pageResult.setList( tradeAfterSaleDOListToTradeAfterSaleRespPageItemVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public ProductPropertyValueDetailRespVO convert(ProductPropertyValueDetailRespDTO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductPropertyValueDetailRespVO productPropertyValueDetailRespVO = new ProductPropertyValueDetailRespVO();

        productPropertyValueDetailRespVO.setPropertyId( bean.getPropertyId() );
        productPropertyValueDetailRespVO.setPropertyName( bean.getPropertyName() );
        productPropertyValueDetailRespVO.setValueId( bean.getValueId() );
        productPropertyValueDetailRespVO.setValueName( bean.getValueName() );

        return productPropertyValueDetailRespVO;
    }

    protected ProductPropertyValueDetailRespVO propertyToProductPropertyValueDetailRespVO(TradeOrderItemDO.Property property) {
        if ( property == null ) {
            return null;
        }

        ProductPropertyValueDetailRespVO productPropertyValueDetailRespVO = new ProductPropertyValueDetailRespVO();

        productPropertyValueDetailRespVO.setPropertyId( property.getPropertyId() );
        productPropertyValueDetailRespVO.setValueId( property.getValueId() );

        return productPropertyValueDetailRespVO;
    }

    protected List<ProductPropertyValueDetailRespVO> propertyListToProductPropertyValueDetailRespVOList(List<TradeOrderItemDO.Property> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductPropertyValueDetailRespVO> list1 = new ArrayList<ProductPropertyValueDetailRespVO>( list.size() );
        for ( TradeOrderItemDO.Property property : list ) {
            list1.add( propertyToProductPropertyValueDetailRespVO( property ) );
        }

        return list1;
    }

    protected TradeAfterSaleRespPageItemVO tradeAfterSaleDOToTradeAfterSaleRespPageItemVO(TradeAfterSaleDO tradeAfterSaleDO) {
        if ( tradeAfterSaleDO == null ) {
            return null;
        }

        TradeAfterSaleRespPageItemVO tradeAfterSaleRespPageItemVO = new TradeAfterSaleRespPageItemVO();

        tradeAfterSaleRespPageItemVO.setNo( tradeAfterSaleDO.getNo() );
        tradeAfterSaleRespPageItemVO.setStatus( tradeAfterSaleDO.getStatus() );
        tradeAfterSaleRespPageItemVO.setType( tradeAfterSaleDO.getType() );
        tradeAfterSaleRespPageItemVO.setWay( tradeAfterSaleDO.getWay() );
        tradeAfterSaleRespPageItemVO.setUserId( tradeAfterSaleDO.getUserId() );
        tradeAfterSaleRespPageItemVO.setApplyReason( tradeAfterSaleDO.getApplyReason() );
        tradeAfterSaleRespPageItemVO.setApplyDescription( tradeAfterSaleDO.getApplyDescription() );
        List<String> list = tradeAfterSaleDO.getApplyPicUrls();
        if ( list != null ) {
            tradeAfterSaleRespPageItemVO.setApplyPicUrls( new ArrayList<String>( list ) );
        }
        tradeAfterSaleRespPageItemVO.setOrderId( tradeAfterSaleDO.getOrderId() );
        if ( tradeAfterSaleDO.getOrderNo() != null ) {
            tradeAfterSaleRespPageItemVO.setOrderNo( Long.parseLong( tradeAfterSaleDO.getOrderNo() ) );
        }
        tradeAfterSaleRespPageItemVO.setOrderItemId( tradeAfterSaleDO.getOrderItemId() );
        tradeAfterSaleRespPageItemVO.setSpuId( tradeAfterSaleDO.getSpuId() );
        tradeAfterSaleRespPageItemVO.setSpuName( tradeAfterSaleDO.getSpuName() );
        tradeAfterSaleRespPageItemVO.setSkuId( tradeAfterSaleDO.getSkuId() );
        tradeAfterSaleRespPageItemVO.setPicUrl( tradeAfterSaleDO.getPicUrl() );
        tradeAfterSaleRespPageItemVO.setCount( tradeAfterSaleDO.getCount() );
        tradeAfterSaleRespPageItemVO.setAuditTime( tradeAfterSaleDO.getAuditTime() );
        tradeAfterSaleRespPageItemVO.setAuditUserId( tradeAfterSaleDO.getAuditUserId() );
        tradeAfterSaleRespPageItemVO.setAuditReason( tradeAfterSaleDO.getAuditReason() );
        tradeAfterSaleRespPageItemVO.setRefundPrice( tradeAfterSaleDO.getRefundPrice() );
        tradeAfterSaleRespPageItemVO.setPayRefundId( tradeAfterSaleDO.getPayRefundId() );
        tradeAfterSaleRespPageItemVO.setRefundTime( tradeAfterSaleDO.getRefundTime() );
        tradeAfterSaleRespPageItemVO.setLogisticsId( tradeAfterSaleDO.getLogisticsId() );
        tradeAfterSaleRespPageItemVO.setLogisticsNo( tradeAfterSaleDO.getLogisticsNo() );
        tradeAfterSaleRespPageItemVO.setDeliveryTime( tradeAfterSaleDO.getDeliveryTime() );
        tradeAfterSaleRespPageItemVO.setReceiveTime( tradeAfterSaleDO.getReceiveTime() );
        tradeAfterSaleRespPageItemVO.setReceiveReason( tradeAfterSaleDO.getReceiveReason() );
        tradeAfterSaleRespPageItemVO.setId( tradeAfterSaleDO.getId() );
        tradeAfterSaleRespPageItemVO.setCreateTime( tradeAfterSaleDO.getCreateTime() );
        tradeAfterSaleRespPageItemVO.setProperties( propertyListToProductPropertyValueDetailRespVOList( tradeAfterSaleDO.getProperties() ) );

        return tradeAfterSaleRespPageItemVO;
    }

    protected List<TradeAfterSaleRespPageItemVO> tradeAfterSaleDOListToTradeAfterSaleRespPageItemVOList(List<TradeAfterSaleDO> list) {
        if ( list == null ) {
            return null;
        }

        List<TradeAfterSaleRespPageItemVO> list1 = new ArrayList<TradeAfterSaleRespPageItemVO>( list.size() );
        for ( TradeAfterSaleDO tradeAfterSaleDO : list ) {
            list1.add( tradeAfterSaleDOToTradeAfterSaleRespPageItemVO( tradeAfterSaleDO ) );
        }

        return list1;
    }
}
