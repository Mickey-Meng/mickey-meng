package cn.iocoder.yudao.module.product.convert.sku;

import cn.iocoder.yudao.module.product.api.sku.dto.ProductSkuRespDTO;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.value.ProductPropertyValueDetailRespVO;
import cn.iocoder.yudao.module.product.controller.admin.sku.vo.ProductSkuBaseVO;
import cn.iocoder.yudao.module.product.controller.admin.sku.vo.ProductSkuCreateOrUpdateReqVO;
import cn.iocoder.yudao.module.product.controller.admin.sku.vo.ProductSkuOptionRespVO;
import cn.iocoder.yudao.module.product.controller.admin.sku.vo.ProductSkuRespVO;
import cn.iocoder.yudao.module.product.controller.admin.spu.vo.ProductSpuDetailRespVO;
import cn.iocoder.yudao.module.product.dal.dataobject.sku.ProductSkuDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:12+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProductSkuConvertImpl implements ProductSkuConvert {

    @Override
    public ProductSkuDO convert(ProductSkuCreateOrUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductSkuDO.ProductSkuDOBuilder productSkuDO = ProductSkuDO.builder();

        productSkuDO.properties( propertyListToPropertyList( bean.getProperties() ) );
        productSkuDO.price( bean.getPrice() );
        productSkuDO.marketPrice( bean.getMarketPrice() );
        productSkuDO.costPrice( bean.getCostPrice() );
        productSkuDO.barCode( bean.getBarCode() );
        productSkuDO.picUrl( bean.getPicUrl() );
        productSkuDO.status( bean.getStatus() );
        productSkuDO.stock( bean.getStock() );
        productSkuDO.warnStock( bean.getWarnStock() );
        productSkuDO.weight( bean.getWeight() );
        productSkuDO.volume( bean.getVolume() );

        return productSkuDO.build();
    }

    @Override
    public ProductSkuRespVO convert(ProductSkuDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductSkuRespVO productSkuRespVO = new ProductSkuRespVO();

        productSkuRespVO.setPrice( bean.getPrice() );
        productSkuRespVO.setMarketPrice( bean.getMarketPrice() );
        productSkuRespVO.setCostPrice( bean.getCostPrice() );
        productSkuRespVO.setBarCode( bean.getBarCode() );
        productSkuRespVO.setPicUrl( bean.getPicUrl() );
        productSkuRespVO.setStatus( bean.getStatus() );
        productSkuRespVO.setStock( bean.getStock() );
        productSkuRespVO.setWarnStock( bean.getWarnStock() );
        productSkuRespVO.setWeight( bean.getWeight() );
        productSkuRespVO.setVolume( bean.getVolume() );
        productSkuRespVO.setId( bean.getId() );
        productSkuRespVO.setCreateTime( bean.getCreateTime() );
        productSkuRespVO.setProperties( propertyListToPropertyList1( bean.getProperties() ) );

        return productSkuRespVO;
    }

    @Override
    public List<ProductSkuRespVO> convertList(List<ProductSkuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSkuRespVO> list1 = new ArrayList<ProductSkuRespVO>( list.size() );
        for ( ProductSkuDO productSkuDO : list ) {
            list1.add( convert( productSkuDO ) );
        }

        return list1;
    }

    @Override
    public List<ProductSkuDO> convertList06(List<ProductSkuCreateOrUpdateReqVO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSkuDO> list1 = new ArrayList<ProductSkuDO>( list.size() );
        for ( ProductSkuCreateOrUpdateReqVO productSkuCreateOrUpdateReqVO : list ) {
            list1.add( convert( productSkuCreateOrUpdateReqVO ) );
        }

        return list1;
    }

    @Override
    public ProductSkuRespDTO convert02(ProductSkuDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductSkuRespDTO productSkuRespDTO = new ProductSkuRespDTO();

        productSkuRespDTO.setId( bean.getId() );
        productSkuRespDTO.setSpuId( bean.getSpuId() );
        productSkuRespDTO.setSpuName( bean.getSpuName() );
        productSkuRespDTO.setProperties( propertyListToPropertyList2( bean.getProperties() ) );
        productSkuRespDTO.setPrice( bean.getPrice() );
        productSkuRespDTO.setMarketPrice( bean.getMarketPrice() );
        productSkuRespDTO.setCostPrice( bean.getCostPrice() );
        productSkuRespDTO.setBarCode( bean.getBarCode() );
        productSkuRespDTO.setPicUrl( bean.getPicUrl() );
        productSkuRespDTO.setStatus( bean.getStatus() );
        productSkuRespDTO.setStock( bean.getStock() );
        productSkuRespDTO.setWarnStock( bean.getWarnStock() );
        productSkuRespDTO.setWeight( bean.getWeight() );
        productSkuRespDTO.setVolume( bean.getVolume() );

        return productSkuRespDTO;
    }

    @Override
    public List<ProductSpuDetailRespVO.Sku> convertList03(List<ProductSkuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSpuDetailRespVO.Sku> list1 = new ArrayList<ProductSpuDetailRespVO.Sku>( list.size() );
        for ( ProductSkuDO productSkuDO : list ) {
            list1.add( productSkuDOToSku( productSkuDO ) );
        }

        return list1;
    }

    @Override
    public List<ProductSkuRespDTO> convertList04(List<ProductSkuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSkuRespDTO> list1 = new ArrayList<ProductSkuRespDTO>( list.size() );
        for ( ProductSkuDO productSkuDO : list ) {
            list1.add( convert02( productSkuDO ) );
        }

        return list1;
    }

    @Override
    public List<ProductSkuOptionRespVO> convertList05(List<ProductSkuDO> skus) {
        if ( skus == null ) {
            return null;
        }

        List<ProductSkuOptionRespVO> list = new ArrayList<ProductSkuOptionRespVO>( skus.size() );
        for ( ProductSkuDO productSkuDO : skus ) {
            list.add( productSkuDOToProductSkuOptionRespVO( productSkuDO ) );
        }

        return list;
    }

    protected ProductSkuDO.Property propertyToProperty(ProductSkuBaseVO.Property property) {
        if ( property == null ) {
            return null;
        }

        ProductSkuDO.Property property1 = new ProductSkuDO.Property();

        property1.setPropertyId( property.getPropertyId() );
        property1.setValueId( property.getValueId() );

        return property1;
    }

    protected List<ProductSkuDO.Property> propertyListToPropertyList(List<ProductSkuBaseVO.Property> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSkuDO.Property> list1 = new ArrayList<ProductSkuDO.Property>( list.size() );
        for ( ProductSkuBaseVO.Property property : list ) {
            list1.add( propertyToProperty( property ) );
        }

        return list1;
    }

    protected ProductSkuBaseVO.Property propertyToProperty1(ProductSkuDO.Property property) {
        if ( property == null ) {
            return null;
        }

        ProductSkuBaseVO.Property property1 = new ProductSkuBaseVO.Property();

        property1.setPropertyId( property.getPropertyId() );
        property1.setValueId( property.getValueId() );

        return property1;
    }

    protected List<ProductSkuBaseVO.Property> propertyListToPropertyList1(List<ProductSkuDO.Property> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSkuBaseVO.Property> list1 = new ArrayList<ProductSkuBaseVO.Property>( list.size() );
        for ( ProductSkuDO.Property property : list ) {
            list1.add( propertyToProperty1( property ) );
        }

        return list1;
    }

    protected ProductSkuRespDTO.Property propertyToProperty2(ProductSkuDO.Property property) {
        if ( property == null ) {
            return null;
        }

        ProductSkuRespDTO.Property property1 = new ProductSkuRespDTO.Property();

        property1.setPropertyId( property.getPropertyId() );
        property1.setValueId( property.getValueId() );

        return property1;
    }

    protected List<ProductSkuRespDTO.Property> propertyListToPropertyList2(List<ProductSkuDO.Property> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSkuRespDTO.Property> list1 = new ArrayList<ProductSkuRespDTO.Property>( list.size() );
        for ( ProductSkuDO.Property property : list ) {
            list1.add( propertyToProperty2( property ) );
        }

        return list1;
    }

    protected ProductPropertyValueDetailRespVO propertyToProductPropertyValueDetailRespVO(ProductSkuDO.Property property) {
        if ( property == null ) {
            return null;
        }

        ProductPropertyValueDetailRespVO productPropertyValueDetailRespVO = new ProductPropertyValueDetailRespVO();

        productPropertyValueDetailRespVO.setPropertyId( property.getPropertyId() );
        productPropertyValueDetailRespVO.setValueId( property.getValueId() );

        return productPropertyValueDetailRespVO;
    }

    protected List<ProductPropertyValueDetailRespVO> propertyListToProductPropertyValueDetailRespVOList(List<ProductSkuDO.Property> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductPropertyValueDetailRespVO> list1 = new ArrayList<ProductPropertyValueDetailRespVO>( list.size() );
        for ( ProductSkuDO.Property property : list ) {
            list1.add( propertyToProductPropertyValueDetailRespVO( property ) );
        }

        return list1;
    }

    protected ProductSpuDetailRespVO.Sku productSkuDOToSku(ProductSkuDO productSkuDO) {
        if ( productSkuDO == null ) {
            return null;
        }

        ProductSpuDetailRespVO.Sku sku = new ProductSpuDetailRespVO.Sku();

        sku.setPrice( productSkuDO.getPrice() );
        sku.setMarketPrice( productSkuDO.getMarketPrice() );
        sku.setCostPrice( productSkuDO.getCostPrice() );
        sku.setBarCode( productSkuDO.getBarCode() );
        sku.setPicUrl( productSkuDO.getPicUrl() );
        sku.setStatus( productSkuDO.getStatus() );
        sku.setStock( productSkuDO.getStock() );
        sku.setWarnStock( productSkuDO.getWarnStock() );
        sku.setWeight( productSkuDO.getWeight() );
        sku.setVolume( productSkuDO.getVolume() );
        sku.setProperties( propertyListToProductPropertyValueDetailRespVOList( productSkuDO.getProperties() ) );

        return sku;
    }

    protected ProductSkuOptionRespVO productSkuDOToProductSkuOptionRespVO(ProductSkuDO productSkuDO) {
        if ( productSkuDO == null ) {
            return null;
        }

        ProductSkuOptionRespVO productSkuOptionRespVO = new ProductSkuOptionRespVO();

        productSkuOptionRespVO.setId( productSkuDO.getId() );
        if ( productSkuDO.getPrice() != null ) {
            productSkuOptionRespVO.setPrice( String.valueOf( productSkuDO.getPrice() ) );
        }
        productSkuOptionRespVO.setStock( productSkuDO.getStock() );
        productSkuOptionRespVO.setSpuId( productSkuDO.getSpuId() );
        productSkuOptionRespVO.setSpuName( productSkuDO.getSpuName() );

        return productSkuOptionRespVO;
    }
}
