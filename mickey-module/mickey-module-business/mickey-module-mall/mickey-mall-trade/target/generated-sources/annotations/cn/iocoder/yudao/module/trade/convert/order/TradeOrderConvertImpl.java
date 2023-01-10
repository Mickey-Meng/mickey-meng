package cn.iocoder.yudao.module.trade.convert.order;

import cn.iocoder.yudao.module.member.api.address.dto.AddressRespDTO;
import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import cn.iocoder.yudao.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import cn.iocoder.yudao.module.product.api.sku.dto.ProductSkuRespDTO;
import cn.iocoder.yudao.module.product.api.sku.dto.ProductSkuUpdateStockReqDTO;
import cn.iocoder.yudao.module.promotion.api.price.dto.PriceCalculateReqDTO;
import cn.iocoder.yudao.module.promotion.api.price.dto.PriceCalculateRespDTO;
import cn.iocoder.yudao.module.trade.controller.admin.base.member.user.MemberUserRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.base.product.property.ProductPropertyValueDetailRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.order.vo.TradeOrderDetailRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.order.vo.TradeOrderPageItemRespVO;
import cn.iocoder.yudao.module.trade.controller.app.base.property.AppProductPropertyValueDetailRespVO;
import cn.iocoder.yudao.module.trade.controller.app.order.vo.AppTradeOrderCreateReqVO;
import cn.iocoder.yudao.module.trade.controller.app.order.vo.AppTradeOrderDetailRespVO;
import cn.iocoder.yudao.module.trade.controller.app.order.vo.AppTradeOrderPageItemRespVO;
import cn.iocoder.yudao.module.trade.dal.dataobject.order.TradeOrderDO;
import cn.iocoder.yudao.module.trade.dal.dataobject.order.TradeOrderItemDO;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:03+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TradeOrderConvertImpl implements TradeOrderConvert {

    @Override
    public TradeOrderDO convert(Long userId, String userIp, AppTradeOrderCreateReqVO createReqVO, PriceCalculateRespDTO.Order order, AddressRespDTO address) {
        if ( userId == null && userIp == null && createReqVO == null && order == null && address == null ) {
            return null;
        }

        TradeOrderDO.TradeOrderDOBuilder tradeOrderDO = TradeOrderDO.builder();

        if ( createReqVO != null ) {
            tradeOrderDO.couponId( createReqVO.getCouponId() );
            tradeOrderDO.userRemark( createReqVO.getRemark() );
        }
        if ( order != null ) {
            tradeOrderDO.originalPrice( order.getOriginalPrice() );
            tradeOrderDO.orderPrice( order.getOrderPrice() );
            tradeOrderDO.discountPrice( order.getDiscountPrice() );
            tradeOrderDO.deliveryPrice( order.getDeliveryPrice() );
            tradeOrderDO.payPrice( order.getPayPrice() );
            tradeOrderDO.couponPrice( order.getCouponPrice() );
            tradeOrderDO.pointPrice( order.getPointPrice() );
        }
        if ( address != null ) {
            tradeOrderDO.receiverName( address.getName() );
            tradeOrderDO.receiverMobile( address.getMobile() );
            if ( address.getAreaId() != null ) {
                tradeOrderDO.receiverAreaId( address.getAreaId().intValue() );
            }
            if ( address.getPostCode() != null ) {
                tradeOrderDO.receiverPostCode( Integer.parseInt( address.getPostCode() ) );
            }
            tradeOrderDO.receiverDetailAddress( address.getDetailAddress() );
            tradeOrderDO.userId( address.getUserId() );
        }
        tradeOrderDO.userIp( userIp );

        return tradeOrderDO.build();
    }

    @Override
    public TradeOrderItemDO convert(PriceCalculateRespDTO.OrderItem orderItem, ProductSkuRespDTO sku) {
        if ( orderItem == null && sku == null ) {
            return null;
        }

        TradeOrderItemDO tradeOrderItemDO = new TradeOrderItemDO();

        if ( orderItem != null ) {
            tradeOrderItemDO.setSkuId( orderItem.getSkuId() );
            tradeOrderItemDO.setCount( orderItem.getCount() );
            tradeOrderItemDO.setOriginalPrice( orderItem.getOriginalPrice() );
            tradeOrderItemDO.setOriginalUnitPrice( orderItem.getOriginalUnitPrice() );
            tradeOrderItemDO.setDiscountPrice( orderItem.getDiscountPrice() );
            tradeOrderItemDO.setPayPrice( orderItem.getPayPrice() );
            tradeOrderItemDO.setOrderPartPrice( orderItem.getOrderPartPrice() );
            tradeOrderItemDO.setOrderDividePrice( orderItem.getOrderDividePrice() );
        }
        if ( sku != null ) {
            tradeOrderItemDO.setSpuId( sku.getSpuId() );
            tradeOrderItemDO.setSpuName( sku.getSpuName() );
            tradeOrderItemDO.setProperties( propertyListToPropertyList( sku.getProperties() ) );
            tradeOrderItemDO.setPicUrl( sku.getPicUrl() );
        }

        return tradeOrderItemDO;
    }

    @Override
    public PriceCalculateReqDTO convert(AppTradeOrderCreateReqVO createReqVO, Long userId) {
        if ( createReqVO == null && userId == null ) {
            return null;
        }

        PriceCalculateReqDTO priceCalculateReqDTO = new PriceCalculateReqDTO();

        if ( createReqVO != null ) {
            priceCalculateReqDTO.setCouponId( createReqVO.getCouponId() );
            priceCalculateReqDTO.setItems( itemListToItemList( createReqVO.getItems() ) );
        }
        priceCalculateReqDTO.setUserId( userId );

        return priceCalculateReqDTO;
    }

    @Override
    public ProductSkuUpdateStockReqDTO.Item convert(TradeOrderItemDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductSkuUpdateStockReqDTO.Item item = new ProductSkuUpdateStockReqDTO.Item();

        item.setId( bean.getSkuId() );
        item.setIncrCount( bean.getCount() );

        return item;
    }

    @Override
    public List<ProductSkuUpdateStockReqDTO.Item> convertList(List<TradeOrderItemDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSkuUpdateStockReqDTO.Item> list1 = new ArrayList<ProductSkuUpdateStockReqDTO.Item>( list.size() );
        for ( TradeOrderItemDO tradeOrderItemDO : list ) {
            list1.add( convert( tradeOrderItemDO ) );
        }

        return list1;
    }

    @Override
    public TradeOrderPageItemRespVO convert(TradeOrderDO order, List<TradeOrderItemDO> items) {
        if ( order == null && items == null ) {
            return null;
        }

        TradeOrderPageItemRespVO tradeOrderPageItemRespVO = new TradeOrderPageItemRespVO();

        if ( order != null ) {
            tradeOrderPageItemRespVO.setId( order.getId() );
            tradeOrderPageItemRespVO.setNo( order.getNo() );
            if ( order.getCreateTime() != null ) {
                tradeOrderPageItemRespVO.setCreateTime( Date.from( order.getCreateTime().toInstant( ZoneOffset.UTC ) ) );
            }
            tradeOrderPageItemRespVO.setType( order.getType() );
            tradeOrderPageItemRespVO.setTerminal( order.getTerminal() );
            tradeOrderPageItemRespVO.setUserId( order.getUserId() );
            tradeOrderPageItemRespVO.setUserIp( order.getUserIp() );
            tradeOrderPageItemRespVO.setUserRemark( order.getUserRemark() );
            tradeOrderPageItemRespVO.setStatus( order.getStatus() );
            tradeOrderPageItemRespVO.setProductCount( order.getProductCount() );
            tradeOrderPageItemRespVO.setFinishTime( order.getFinishTime() );
            tradeOrderPageItemRespVO.setCancelTime( order.getCancelTime() );
            tradeOrderPageItemRespVO.setCancelType( order.getCancelType() );
            tradeOrderPageItemRespVO.setRemark( order.getRemark() );
            tradeOrderPageItemRespVO.setPayOrderId( order.getPayOrderId() );
            tradeOrderPageItemRespVO.setPayed( order.getPayed() );
            tradeOrderPageItemRespVO.setPayTime( order.getPayTime() );
            tradeOrderPageItemRespVO.setPayChannelCode( order.getPayChannelCode() );
            tradeOrderPageItemRespVO.setOriginalPrice( order.getOriginalPrice() );
            tradeOrderPageItemRespVO.setOrderPrice( order.getOrderPrice() );
            tradeOrderPageItemRespVO.setDiscountPrice( order.getDiscountPrice() );
            tradeOrderPageItemRespVO.setDeliveryPrice( order.getDeliveryPrice() );
            tradeOrderPageItemRespVO.setAdjustPrice( order.getAdjustPrice() );
            tradeOrderPageItemRespVO.setPayPrice( order.getPayPrice() );
            tradeOrderPageItemRespVO.setDeliveryTemplateId( order.getDeliveryTemplateId() );
            tradeOrderPageItemRespVO.setLogisticsId( order.getLogisticsId() );
            tradeOrderPageItemRespVO.setLogisticsNo( order.getLogisticsNo() );
            tradeOrderPageItemRespVO.setDeliveryStatus( order.getDeliveryStatus() );
            tradeOrderPageItemRespVO.setDeliveryTime( order.getDeliveryTime() );
            tradeOrderPageItemRespVO.setReceiveTime( order.getReceiveTime() );
            tradeOrderPageItemRespVO.setReceiverName( order.getReceiverName() );
            tradeOrderPageItemRespVO.setReceiverMobile( order.getReceiverMobile() );
            tradeOrderPageItemRespVO.setReceiverAreaId( order.getReceiverAreaId() );
            tradeOrderPageItemRespVO.setReceiverPostCode( order.getReceiverPostCode() );
            tradeOrderPageItemRespVO.setReceiverDetailAddress( order.getReceiverDetailAddress() );
            tradeOrderPageItemRespVO.setAfterSaleStatus( order.getAfterSaleStatus() );
            tradeOrderPageItemRespVO.setRefundPrice( order.getRefundPrice() );
            tradeOrderPageItemRespVO.setCouponId( order.getCouponId() );
            tradeOrderPageItemRespVO.setCouponPrice( order.getCouponPrice() );
            tradeOrderPageItemRespVO.setPointPrice( order.getPointPrice() );
        }
        tradeOrderPageItemRespVO.setItems( tradeOrderItemDOListToItemList( items ) );

        return tradeOrderPageItemRespVO;
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

    @Override
    public TradeOrderDetailRespVO convert2(TradeOrderDO order, List<TradeOrderItemDO> items) {
        if ( order == null && items == null ) {
            return null;
        }

        TradeOrderDetailRespVO tradeOrderDetailRespVO = new TradeOrderDetailRespVO();

        if ( order != null ) {
            tradeOrderDetailRespVO.setId( order.getId() );
            tradeOrderDetailRespVO.setNo( order.getNo() );
            if ( order.getCreateTime() != null ) {
                tradeOrderDetailRespVO.setCreateTime( Date.from( order.getCreateTime().toInstant( ZoneOffset.UTC ) ) );
            }
            tradeOrderDetailRespVO.setType( order.getType() );
            tradeOrderDetailRespVO.setTerminal( order.getTerminal() );
            tradeOrderDetailRespVO.setUserId( order.getUserId() );
            tradeOrderDetailRespVO.setUserIp( order.getUserIp() );
            tradeOrderDetailRespVO.setUserRemark( order.getUserRemark() );
            tradeOrderDetailRespVO.setStatus( order.getStatus() );
            tradeOrderDetailRespVO.setProductCount( order.getProductCount() );
            tradeOrderDetailRespVO.setFinishTime( order.getFinishTime() );
            tradeOrderDetailRespVO.setCancelTime( order.getCancelTime() );
            tradeOrderDetailRespVO.setCancelType( order.getCancelType() );
            tradeOrderDetailRespVO.setRemark( order.getRemark() );
            tradeOrderDetailRespVO.setPayOrderId( order.getPayOrderId() );
            tradeOrderDetailRespVO.setPayed( order.getPayed() );
            tradeOrderDetailRespVO.setPayTime( order.getPayTime() );
            tradeOrderDetailRespVO.setPayChannelCode( order.getPayChannelCode() );
            tradeOrderDetailRespVO.setOriginalPrice( order.getOriginalPrice() );
            tradeOrderDetailRespVO.setOrderPrice( order.getOrderPrice() );
            tradeOrderDetailRespVO.setDiscountPrice( order.getDiscountPrice() );
            tradeOrderDetailRespVO.setDeliveryPrice( order.getDeliveryPrice() );
            tradeOrderDetailRespVO.setAdjustPrice( order.getAdjustPrice() );
            tradeOrderDetailRespVO.setPayPrice( order.getPayPrice() );
            tradeOrderDetailRespVO.setDeliveryTemplateId( order.getDeliveryTemplateId() );
            tradeOrderDetailRespVO.setLogisticsId( order.getLogisticsId() );
            tradeOrderDetailRespVO.setLogisticsNo( order.getLogisticsNo() );
            tradeOrderDetailRespVO.setDeliveryStatus( order.getDeliveryStatus() );
            tradeOrderDetailRespVO.setDeliveryTime( order.getDeliveryTime() );
            tradeOrderDetailRespVO.setReceiveTime( order.getReceiveTime() );
            tradeOrderDetailRespVO.setReceiverName( order.getReceiverName() );
            tradeOrderDetailRespVO.setReceiverMobile( order.getReceiverMobile() );
            tradeOrderDetailRespVO.setReceiverAreaId( order.getReceiverAreaId() );
            tradeOrderDetailRespVO.setReceiverPostCode( order.getReceiverPostCode() );
            tradeOrderDetailRespVO.setReceiverDetailAddress( order.getReceiverDetailAddress() );
            tradeOrderDetailRespVO.setAfterSaleStatus( order.getAfterSaleStatus() );
            tradeOrderDetailRespVO.setRefundPrice( order.getRefundPrice() );
            tradeOrderDetailRespVO.setCouponId( order.getCouponId() );
            tradeOrderDetailRespVO.setCouponPrice( order.getCouponPrice() );
            tradeOrderDetailRespVO.setPointPrice( order.getPointPrice() );
        }
        tradeOrderDetailRespVO.setItems( tradeOrderItemDOListToItemList1( items ) );

        return tradeOrderDetailRespVO;
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
    public AppTradeOrderPageItemRespVO convert02(TradeOrderDO order, List<TradeOrderItemDO> items) {
        if ( order == null && items == null ) {
            return null;
        }

        AppTradeOrderPageItemRespVO appTradeOrderPageItemRespVO = new AppTradeOrderPageItemRespVO();

        if ( order != null ) {
            appTradeOrderPageItemRespVO.setId( order.getId() );
            appTradeOrderPageItemRespVO.setNo( order.getNo() );
            appTradeOrderPageItemRespVO.setStatus( order.getStatus() );
            appTradeOrderPageItemRespVO.setProductCount( order.getProductCount() );
        }
        appTradeOrderPageItemRespVO.setItems( tradeOrderItemDOListToItemList2( items ) );

        return appTradeOrderPageItemRespVO;
    }

    @Override
    public AppProductPropertyValueDetailRespVO convert02(ProductPropertyValueDetailRespDTO bean) {
        if ( bean == null ) {
            return null;
        }

        AppProductPropertyValueDetailRespVO appProductPropertyValueDetailRespVO = new AppProductPropertyValueDetailRespVO();

        appProductPropertyValueDetailRespVO.setPropertyId( bean.getPropertyId() );
        appProductPropertyValueDetailRespVO.setPropertyName( bean.getPropertyName() );
        appProductPropertyValueDetailRespVO.setValueId( bean.getValueId() );
        appProductPropertyValueDetailRespVO.setValueName( bean.getValueName() );

        return appProductPropertyValueDetailRespVO;
    }

    @Override
    public AppTradeOrderDetailRespVO convert3(TradeOrderDO order, List<TradeOrderItemDO> items) {
        if ( order == null && items == null ) {
            return null;
        }

        AppTradeOrderDetailRespVO appTradeOrderDetailRespVO = new AppTradeOrderDetailRespVO();

        if ( order != null ) {
            appTradeOrderDetailRespVO.setId( order.getId() );
            appTradeOrderDetailRespVO.setNo( order.getNo() );
            if ( order.getCreateTime() != null ) {
                appTradeOrderDetailRespVO.setCreateTime( Date.from( order.getCreateTime().toInstant( ZoneOffset.UTC ) ) );
            }
            appTradeOrderDetailRespVO.setUserRemark( order.getUserRemark() );
            appTradeOrderDetailRespVO.setStatus( order.getStatus() );
            appTradeOrderDetailRespVO.setProductCount( order.getProductCount() );
            appTradeOrderDetailRespVO.setFinishTime( order.getFinishTime() );
            appTradeOrderDetailRespVO.setCancelTime( order.getCancelTime() );
            appTradeOrderDetailRespVO.setPayOrderId( order.getPayOrderId() );
            appTradeOrderDetailRespVO.setPayTime( order.getPayTime() );
            appTradeOrderDetailRespVO.setOriginalPrice( order.getOriginalPrice() );
            appTradeOrderDetailRespVO.setOrderPrice( order.getOrderPrice() );
            appTradeOrderDetailRespVO.setDiscountPrice( order.getDiscountPrice() );
            appTradeOrderDetailRespVO.setDeliveryPrice( order.getDeliveryPrice() );
            appTradeOrderDetailRespVO.setAdjustPrice( order.getAdjustPrice() );
            appTradeOrderDetailRespVO.setPayPrice( order.getPayPrice() );
            appTradeOrderDetailRespVO.setLogisticsNo( order.getLogisticsNo() );
            appTradeOrderDetailRespVO.setDeliveryTime( order.getDeliveryTime() );
            appTradeOrderDetailRespVO.setReceiveTime( order.getReceiveTime() );
            appTradeOrderDetailRespVO.setReceiverName( order.getReceiverName() );
            appTradeOrderDetailRespVO.setReceiverMobile( order.getReceiverMobile() );
            appTradeOrderDetailRespVO.setReceiverAreaId( order.getReceiverAreaId() );
            appTradeOrderDetailRespVO.setReceiverPostCode( order.getReceiverPostCode() );
            appTradeOrderDetailRespVO.setReceiverDetailAddress( order.getReceiverDetailAddress() );
            appTradeOrderDetailRespVO.setCouponId( order.getCouponId() );
            appTradeOrderDetailRespVO.setCouponPrice( order.getCouponPrice() );
            appTradeOrderDetailRespVO.setPointPrice( order.getPointPrice() );
        }
        appTradeOrderDetailRespVO.setItems( tradeOrderItemDOListToItemList3( items ) );

        return appTradeOrderDetailRespVO;
    }

    protected TradeOrderItemDO.Property propertyToProperty(ProductSkuRespDTO.Property property) {
        if ( property == null ) {
            return null;
        }

        TradeOrderItemDO.Property property1 = new TradeOrderItemDO.Property();

        property1.setPropertyId( property.getPropertyId() );
        property1.setValueId( property.getValueId() );

        return property1;
    }

    protected List<TradeOrderItemDO.Property> propertyListToPropertyList(List<ProductSkuRespDTO.Property> list) {
        if ( list == null ) {
            return null;
        }

        List<TradeOrderItemDO.Property> list1 = new ArrayList<TradeOrderItemDO.Property>( list.size() );
        for ( ProductSkuRespDTO.Property property : list ) {
            list1.add( propertyToProperty( property ) );
        }

        return list1;
    }

    protected PriceCalculateReqDTO.Item itemToItem(AppTradeOrderCreateReqVO.Item item) {
        if ( item == null ) {
            return null;
        }

        PriceCalculateReqDTO.Item item1 = new PriceCalculateReqDTO.Item();

        item1.setSkuId( item.getSkuId() );
        item1.setCount( item.getCount() );

        return item1;
    }

    protected List<PriceCalculateReqDTO.Item> itemListToItemList(List<AppTradeOrderCreateReqVO.Item> list) {
        if ( list == null ) {
            return null;
        }

        List<PriceCalculateReqDTO.Item> list1 = new ArrayList<PriceCalculateReqDTO.Item>( list.size() );
        for ( AppTradeOrderCreateReqVO.Item item : list ) {
            list1.add( itemToItem( item ) );
        }

        return list1;
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

    protected TradeOrderPageItemRespVO.Item tradeOrderItemDOToItem(TradeOrderItemDO tradeOrderItemDO) {
        if ( tradeOrderItemDO == null ) {
            return null;
        }

        TradeOrderPageItemRespVO.Item item = new TradeOrderPageItemRespVO.Item();

        item.setId( tradeOrderItemDO.getId() );
        item.setUserId( tradeOrderItemDO.getUserId() );
        item.setOrderId( tradeOrderItemDO.getOrderId() );
        item.setSpuId( tradeOrderItemDO.getSpuId() );
        item.setSpuName( tradeOrderItemDO.getSpuName() );
        item.setSkuId( tradeOrderItemDO.getSkuId() );
        item.setPicUrl( tradeOrderItemDO.getPicUrl() );
        item.setCount( tradeOrderItemDO.getCount() );
        item.setOriginalPrice( tradeOrderItemDO.getOriginalPrice() );
        item.setOriginalUnitPrice( tradeOrderItemDO.getOriginalUnitPrice() );
        item.setDiscountPrice( tradeOrderItemDO.getDiscountPrice() );
        item.setPayPrice( tradeOrderItemDO.getPayPrice() );
        item.setOrderPartPrice( tradeOrderItemDO.getOrderPartPrice() );
        item.setOrderDividePrice( tradeOrderItemDO.getOrderDividePrice() );
        item.setAfterSaleStatus( tradeOrderItemDO.getAfterSaleStatus() );
        item.setProperties( propertyListToProductPropertyValueDetailRespVOList( tradeOrderItemDO.getProperties() ) );

        return item;
    }

    protected List<TradeOrderPageItemRespVO.Item> tradeOrderItemDOListToItemList(List<TradeOrderItemDO> list) {
        if ( list == null ) {
            return null;
        }

        List<TradeOrderPageItemRespVO.Item> list1 = new ArrayList<TradeOrderPageItemRespVO.Item>( list.size() );
        for ( TradeOrderItemDO tradeOrderItemDO : list ) {
            list1.add( tradeOrderItemDOToItem( tradeOrderItemDO ) );
        }

        return list1;
    }

    protected TradeOrderDetailRespVO.Item tradeOrderItemDOToItem1(TradeOrderItemDO tradeOrderItemDO) {
        if ( tradeOrderItemDO == null ) {
            return null;
        }

        TradeOrderDetailRespVO.Item item = new TradeOrderDetailRespVO.Item();

        item.setId( tradeOrderItemDO.getId() );
        item.setUserId( tradeOrderItemDO.getUserId() );
        item.setOrderId( tradeOrderItemDO.getOrderId() );
        item.setSpuId( tradeOrderItemDO.getSpuId() );
        item.setSpuName( tradeOrderItemDO.getSpuName() );
        item.setSkuId( tradeOrderItemDO.getSkuId() );
        item.setPicUrl( tradeOrderItemDO.getPicUrl() );
        item.setCount( tradeOrderItemDO.getCount() );
        item.setOriginalPrice( tradeOrderItemDO.getOriginalPrice() );
        item.setOriginalUnitPrice( tradeOrderItemDO.getOriginalUnitPrice() );
        item.setDiscountPrice( tradeOrderItemDO.getDiscountPrice() );
        item.setPayPrice( tradeOrderItemDO.getPayPrice() );
        item.setOrderPartPrice( tradeOrderItemDO.getOrderPartPrice() );
        item.setOrderDividePrice( tradeOrderItemDO.getOrderDividePrice() );
        item.setAfterSaleStatus( tradeOrderItemDO.getAfterSaleStatus() );
        item.setProperties( propertyListToProductPropertyValueDetailRespVOList( tradeOrderItemDO.getProperties() ) );

        return item;
    }

    protected List<TradeOrderDetailRespVO.Item> tradeOrderItemDOListToItemList1(List<TradeOrderItemDO> list) {
        if ( list == null ) {
            return null;
        }

        List<TradeOrderDetailRespVO.Item> list1 = new ArrayList<TradeOrderDetailRespVO.Item>( list.size() );
        for ( TradeOrderItemDO tradeOrderItemDO : list ) {
            list1.add( tradeOrderItemDOToItem1( tradeOrderItemDO ) );
        }

        return list1;
    }

    protected AppProductPropertyValueDetailRespVO propertyToAppProductPropertyValueDetailRespVO(TradeOrderItemDO.Property property) {
        if ( property == null ) {
            return null;
        }

        AppProductPropertyValueDetailRespVO appProductPropertyValueDetailRespVO = new AppProductPropertyValueDetailRespVO();

        appProductPropertyValueDetailRespVO.setPropertyId( property.getPropertyId() );
        appProductPropertyValueDetailRespVO.setValueId( property.getValueId() );

        return appProductPropertyValueDetailRespVO;
    }

    protected List<AppProductPropertyValueDetailRespVO> propertyListToAppProductPropertyValueDetailRespVOList(List<TradeOrderItemDO.Property> list) {
        if ( list == null ) {
            return null;
        }

        List<AppProductPropertyValueDetailRespVO> list1 = new ArrayList<AppProductPropertyValueDetailRespVO>( list.size() );
        for ( TradeOrderItemDO.Property property : list ) {
            list1.add( propertyToAppProductPropertyValueDetailRespVO( property ) );
        }

        return list1;
    }

    protected AppTradeOrderPageItemRespVO.Item tradeOrderItemDOToItem2(TradeOrderItemDO tradeOrderItemDO) {
        if ( tradeOrderItemDO == null ) {
            return null;
        }

        AppTradeOrderPageItemRespVO.Item item = new AppTradeOrderPageItemRespVO.Item();

        item.setId( tradeOrderItemDO.getId() );
        item.setSpuId( tradeOrderItemDO.getSpuId() );
        item.setSpuName( tradeOrderItemDO.getSpuName() );
        item.setSkuId( tradeOrderItemDO.getSkuId() );
        item.setPicUrl( tradeOrderItemDO.getPicUrl() );
        item.setCount( tradeOrderItemDO.getCount() );
        item.setOriginalPrice( tradeOrderItemDO.getOriginalPrice() );
        item.setOriginalUnitPrice( tradeOrderItemDO.getOriginalUnitPrice() );
        item.setProperties( propertyListToAppProductPropertyValueDetailRespVOList( tradeOrderItemDO.getProperties() ) );

        return item;
    }

    protected List<AppTradeOrderPageItemRespVO.Item> tradeOrderItemDOListToItemList2(List<TradeOrderItemDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppTradeOrderPageItemRespVO.Item> list1 = new ArrayList<AppTradeOrderPageItemRespVO.Item>( list.size() );
        for ( TradeOrderItemDO tradeOrderItemDO : list ) {
            list1.add( tradeOrderItemDOToItem2( tradeOrderItemDO ) );
        }

        return list1;
    }

    protected AppTradeOrderDetailRespVO.Item tradeOrderItemDOToItem3(TradeOrderItemDO tradeOrderItemDO) {
        if ( tradeOrderItemDO == null ) {
            return null;
        }

        AppTradeOrderDetailRespVO.Item item = new AppTradeOrderDetailRespVO.Item();

        item.setId( tradeOrderItemDO.getId() );
        item.setSpuId( tradeOrderItemDO.getSpuId() );
        item.setSpuName( tradeOrderItemDO.getSpuName() );
        item.setSkuId( tradeOrderItemDO.getSkuId() );
        item.setPicUrl( tradeOrderItemDO.getPicUrl() );
        item.setCount( tradeOrderItemDO.getCount() );
        item.setOriginalPrice( tradeOrderItemDO.getOriginalPrice() );
        item.setOriginalUnitPrice( tradeOrderItemDO.getOriginalUnitPrice() );
        item.setProperties( propertyListToAppProductPropertyValueDetailRespVOList( tradeOrderItemDO.getProperties() ) );

        return item;
    }

    protected List<AppTradeOrderDetailRespVO.Item> tradeOrderItemDOListToItemList3(List<TradeOrderItemDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppTradeOrderDetailRespVO.Item> list1 = new ArrayList<AppTradeOrderDetailRespVO.Item>( list.size() );
        for ( TradeOrderItemDO tradeOrderItemDO : list ) {
            list1.add( tradeOrderItemDOToItem3( tradeOrderItemDO ) );
        }

        return list1;
    }
}
