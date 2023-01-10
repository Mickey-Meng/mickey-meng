package cn.iocoder.yudao.module.trade.convert.cart;

import cn.iocoder.yudao.module.promotion.api.price.dto.PriceCalculateRespDTO;
import cn.iocoder.yudao.module.trade.controller.app.cart.vo.AppTradeCartDetailRespVO;
import cn.iocoder.yudao.module.trade.dal.dataobject.cart.TradeCartItemDO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:03+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TradeCartConvertImpl implements TradeCartConvert {

    @Override
    public AppTradeCartDetailRespVO.Promotion convert(PriceCalculateRespDTO.Promotion bean) {
        if ( bean == null ) {
            return null;
        }

        AppTradeCartDetailRespVO.Promotion promotion = new AppTradeCartDetailRespVO.Promotion();

        promotion.setId( bean.getId() );
        promotion.setName( bean.getName() );
        promotion.setType( bean.getType() );
        promotion.setMeet( bean.getMeet() );
        promotion.setMeetTip( bean.getMeetTip() );

        return promotion;
    }

    @Override
    public AppTradeCartDetailRespVO.Sku convert(PriceCalculateRespDTO.OrderItem orderItem, TradeCartItemDO cartItem) {
        if ( orderItem == null && cartItem == null ) {
            return null;
        }

        AppTradeCartDetailRespVO.Sku sku = new AppTradeCartDetailRespVO.Sku();

        if ( orderItem != null ) {
            sku.setOriginalPrice( orderItem.getOriginalPrice() );
        }
        if ( cartItem != null ) {
            sku.setCount( cartItem.getCount() );
            sku.setId( cartItem.getId() );
            sku.setSelected( cartItem.getSelected() );
        }

        return sku;
    }

    @Override
    public AppTradeCartDetailRespVO.Order convert(PriceCalculateRespDTO.Order bean) {
        if ( bean == null ) {
            return null;
        }

        AppTradeCartDetailRespVO.Order order = new AppTradeCartDetailRespVO.Order();

        order.setDeliveryPrice( bean.getDeliveryPrice() );
        order.setPayPrice( bean.getPayPrice() );

        return order;
    }
}
