package cn.iocoder.yudao.module.product.convert.spu;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.product.api.spu.dto.ProductSpuRespDTO;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.value.ProductPropertyValueDetailRespVO;
import cn.iocoder.yudao.module.product.controller.admin.spu.vo.ProductSpuCreateReqVO;
import cn.iocoder.yudao.module.product.controller.admin.spu.vo.ProductSpuDetailRespVO;
import cn.iocoder.yudao.module.product.controller.admin.spu.vo.ProductSpuPageReqVO;
import cn.iocoder.yudao.module.product.controller.admin.spu.vo.ProductSpuRespVO;
import cn.iocoder.yudao.module.product.controller.admin.spu.vo.ProductSpuSimpleRespVO;
import cn.iocoder.yudao.module.product.controller.admin.spu.vo.ProductSpuUpdateReqVO;
import cn.iocoder.yudao.module.product.controller.app.property.vo.value.AppProductPropertyValueDetailRespVO;
import cn.iocoder.yudao.module.product.controller.app.spu.vo.AppProductSpuDetailRespVO;
import cn.iocoder.yudao.module.product.controller.app.spu.vo.AppProductSpuPageItemRespVO;
import cn.iocoder.yudao.module.product.controller.app.spu.vo.AppProductSpuPageReqVO;
import cn.iocoder.yudao.module.product.dal.dataobject.sku.ProductSkuDO;
import cn.iocoder.yudao.module.product.dal.dataobject.spu.ProductSpuDO;
import cn.iocoder.yudao.module.product.service.property.bo.ProductPropertyValueDetailRespBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:12+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProductSpuConvertImpl implements ProductSpuConvert {

    @Override
    public ProductSpuDO convert(ProductSpuCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductSpuDO.ProductSpuDOBuilder productSpuDO = ProductSpuDO.builder();

        productSpuDO.name( bean.getName() );
        productSpuDO.code( bean.getCode() );
        productSpuDO.sellPoint( bean.getSellPoint() );
        productSpuDO.description( bean.getDescription() );
        productSpuDO.categoryId( bean.getCategoryId() );
        productSpuDO.brandId( bean.getBrandId() );
        List<String> list = bean.getPicUrls();
        if ( list != null ) {
            productSpuDO.picUrls( new ArrayList<String>( list ) );
        }
        productSpuDO.videoUrl( bean.getVideoUrl() );
        productSpuDO.sort( bean.getSort() );
        productSpuDO.status( bean.getStatus() );
        productSpuDO.specType( bean.getSpecType() );
        productSpuDO.marketPrice( bean.getMarketPrice() );
        productSpuDO.showStock( bean.getShowStock() );
        productSpuDO.virtualSalesCount( bean.getVirtualSalesCount() );

        return productSpuDO.build();
    }

    @Override
    public ProductSpuDO convert(ProductSpuUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductSpuDO.ProductSpuDOBuilder productSpuDO = ProductSpuDO.builder();

        productSpuDO.id( bean.getId() );
        productSpuDO.name( bean.getName() );
        productSpuDO.code( bean.getCode() );
        productSpuDO.sellPoint( bean.getSellPoint() );
        productSpuDO.description( bean.getDescription() );
        productSpuDO.categoryId( bean.getCategoryId() );
        productSpuDO.brandId( bean.getBrandId() );
        List<String> list = bean.getPicUrls();
        if ( list != null ) {
            productSpuDO.picUrls( new ArrayList<String>( list ) );
        }
        productSpuDO.videoUrl( bean.getVideoUrl() );
        productSpuDO.sort( bean.getSort() );
        productSpuDO.status( bean.getStatus() );
        productSpuDO.specType( bean.getSpecType() );
        productSpuDO.marketPrice( bean.getMarketPrice() );
        productSpuDO.showStock( bean.getShowStock() );
        productSpuDO.virtualSalesCount( bean.getVirtualSalesCount() );

        return productSpuDO.build();
    }

    @Override
    public List<ProductSpuDO> convertList(List<ProductSpuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSpuDO> list1 = new ArrayList<ProductSpuDO>( list.size() );
        for ( ProductSpuDO productSpuDO : list ) {
            list1.add( productSpuDO );
        }

        return list1;
    }

    @Override
    public PageResult<ProductSpuRespVO> convertPage(PageResult<ProductSpuDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<ProductSpuRespVO> pageResult = new PageResult<ProductSpuRespVO>();

        pageResult.setList( productSpuDOListToProductSpuRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public ProductSpuPageReqVO convert(AppProductSpuPageReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductSpuPageReqVO productSpuPageReqVO = new ProductSpuPageReqVO();

        productSpuPageReqVO.setPageNo( bean.getPageNo() );
        productSpuPageReqVO.setPageSize( bean.getPageSize() );
        productSpuPageReqVO.setCategoryId( bean.getCategoryId() );

        return productSpuPageReqVO;
    }

    @Override
    public List<ProductSpuRespDTO> convertList2(List<ProductSpuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSpuRespDTO> list1 = new ArrayList<ProductSpuRespDTO>( list.size() );
        for ( ProductSpuDO productSpuDO : list ) {
            list1.add( productSpuDOToProductSpuRespDTO( productSpuDO ) );
        }

        return list1;
    }

    @Override
    public List<ProductSpuSimpleRespVO> convertList02(List<ProductSpuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSpuSimpleRespVO> list1 = new ArrayList<ProductSpuSimpleRespVO>( list.size() );
        for ( ProductSpuDO productSpuDO : list ) {
            list1.add( productSpuDOToProductSpuSimpleRespVO( productSpuDO ) );
        }

        return list1;
    }

    @Override
    public AppProductSpuDetailRespVO convert02(ProductSpuDO spu) {
        if ( spu == null ) {
            return null;
        }

        AppProductSpuDetailRespVO appProductSpuDetailRespVO = new AppProductSpuDetailRespVO();

        appProductSpuDetailRespVO.setId( spu.getId() );
        appProductSpuDetailRespVO.setName( spu.getName() );
        appProductSpuDetailRespVO.setSellPoint( spu.getSellPoint() );
        appProductSpuDetailRespVO.setDescription( spu.getDescription() );
        appProductSpuDetailRespVO.setCategoryId( spu.getCategoryId() );
        List<String> list = spu.getPicUrls();
        if ( list != null ) {
            appProductSpuDetailRespVO.setPicUrls( new ArrayList<String>( list ) );
        }
        appProductSpuDetailRespVO.setVideoUrl( spu.getVideoUrl() );
        appProductSpuDetailRespVO.setSpecType( spu.getSpecType() );
        appProductSpuDetailRespVO.setShowStock( spu.getShowStock() );
        appProductSpuDetailRespVO.setMinPrice( spu.getMinPrice() );
        appProductSpuDetailRespVO.setMaxPrice( spu.getMaxPrice() );
        appProductSpuDetailRespVO.setSalesCount( spu.getSalesCount() );

        return appProductSpuDetailRespVO;
    }

    @Override
    public List<AppProductSpuDetailRespVO.Sku> convertList03(List<ProductSkuDO> skus) {
        if ( skus == null ) {
            return null;
        }

        List<AppProductSpuDetailRespVO.Sku> list = new ArrayList<AppProductSpuDetailRespVO.Sku>( skus.size() );
        for ( ProductSkuDO productSkuDO : skus ) {
            list.add( productSkuDOToSku( productSkuDO ) );
        }

        return list;
    }

    @Override
    public AppProductPropertyValueDetailRespVO convert03(ProductPropertyValueDetailRespBO propertyValue) {
        if ( propertyValue == null ) {
            return null;
        }

        AppProductPropertyValueDetailRespVO appProductPropertyValueDetailRespVO = new AppProductPropertyValueDetailRespVO();

        appProductPropertyValueDetailRespVO.setPropertyId( propertyValue.getPropertyId() );
        appProductPropertyValueDetailRespVO.setPropertyName( propertyValue.getPropertyName() );
        appProductPropertyValueDetailRespVO.setValueId( propertyValue.getValueId() );
        appProductPropertyValueDetailRespVO.setValueName( propertyValue.getValueName() );

        return appProductPropertyValueDetailRespVO;
    }

    @Override
    public PageResult<AppProductSpuPageItemRespVO> convertPage02(PageResult<ProductSpuDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<AppProductSpuPageItemRespVO> pageResult = new PageResult<AppProductSpuPageItemRespVO>();

        pageResult.setList( productSpuDOListToAppProductSpuPageItemRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public ProductSpuDetailRespVO convert03(ProductSpuDO spu) {
        if ( spu == null ) {
            return null;
        }

        ProductSpuDetailRespVO productSpuDetailRespVO = new ProductSpuDetailRespVO();

        productSpuDetailRespVO.setName( spu.getName() );
        productSpuDetailRespVO.setCode( spu.getCode() );
        productSpuDetailRespVO.setSellPoint( spu.getSellPoint() );
        productSpuDetailRespVO.setDescription( spu.getDescription() );
        productSpuDetailRespVO.setCategoryId( spu.getCategoryId() );
        productSpuDetailRespVO.setBrandId( spu.getBrandId() );
        List<String> list = spu.getPicUrls();
        if ( list != null ) {
            productSpuDetailRespVO.setPicUrls( new ArrayList<String>( list ) );
        }
        productSpuDetailRespVO.setVideoUrl( spu.getVideoUrl() );
        productSpuDetailRespVO.setSort( spu.getSort() );
        productSpuDetailRespVO.setStatus( spu.getStatus() );
        productSpuDetailRespVO.setSpecType( spu.getSpecType() );
        productSpuDetailRespVO.setShowStock( spu.getShowStock() );
        productSpuDetailRespVO.setMarketPrice( spu.getMarketPrice() );
        productSpuDetailRespVO.setVirtualSalesCount( spu.getVirtualSalesCount() );
        productSpuDetailRespVO.setId( spu.getId() );
        productSpuDetailRespVO.setCreateTime( spu.getCreateTime() );
        productSpuDetailRespVO.setTotalStock( spu.getTotalStock() );
        productSpuDetailRespVO.setMinPrice( spu.getMinPrice() );
        productSpuDetailRespVO.setMaxPrice( spu.getMaxPrice() );
        productSpuDetailRespVO.setSalesCount( spu.getSalesCount() );
        productSpuDetailRespVO.setClickCount( spu.getClickCount() );

        return productSpuDetailRespVO;
    }

    @Override
    public List<ProductSpuDetailRespVO.Sku> convertList04(List<ProductSkuDO> skus) {
        if ( skus == null ) {
            return null;
        }

        List<ProductSpuDetailRespVO.Sku> list = new ArrayList<ProductSpuDetailRespVO.Sku>( skus.size() );
        for ( ProductSkuDO productSkuDO : skus ) {
            list.add( productSkuDOToSku1( productSkuDO ) );
        }

        return list;
    }

    @Override
    public ProductPropertyValueDetailRespVO convert04(ProductPropertyValueDetailRespBO propertyValue) {
        if ( propertyValue == null ) {
            return null;
        }

        ProductPropertyValueDetailRespVO productPropertyValueDetailRespVO = new ProductPropertyValueDetailRespVO();

        productPropertyValueDetailRespVO.setPropertyId( propertyValue.getPropertyId() );
        productPropertyValueDetailRespVO.setPropertyName( propertyValue.getPropertyName() );
        productPropertyValueDetailRespVO.setValueId( propertyValue.getValueId() );
        productPropertyValueDetailRespVO.setValueName( propertyValue.getValueName() );

        return productPropertyValueDetailRespVO;
    }

    protected List<ProductSpuRespVO> productSpuDOListToProductSpuRespVOList(List<ProductSpuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductSpuRespVO> list1 = new ArrayList<ProductSpuRespVO>( list.size() );
        for ( ProductSpuDO productSpuDO : list ) {
            list1.add( convert03( productSpuDO ) );
        }

        return list1;
    }

    protected ProductSpuRespDTO productSpuDOToProductSpuRespDTO(ProductSpuDO productSpuDO) {
        if ( productSpuDO == null ) {
            return null;
        }

        ProductSpuRespDTO productSpuRespDTO = new ProductSpuRespDTO();

        productSpuRespDTO.setId( productSpuDO.getId() );
        productSpuRespDTO.setName( productSpuDO.getName() );
        productSpuRespDTO.setCode( productSpuDO.getCode() );
        productSpuRespDTO.setSellPoint( productSpuDO.getSellPoint() );
        productSpuRespDTO.setDescription( productSpuDO.getDescription() );
        productSpuRespDTO.setCategoryId( productSpuDO.getCategoryId() );
        productSpuRespDTO.setBrandId( productSpuDO.getBrandId() );
        List<String> list = productSpuDO.getPicUrls();
        if ( list != null ) {
            productSpuRespDTO.setPicUrls( new ArrayList<String>( list ) );
        }
        productSpuRespDTO.setVideoUrl( productSpuDO.getVideoUrl() );
        productSpuRespDTO.setSort( productSpuDO.getSort() );
        productSpuRespDTO.setStatus( productSpuDO.getStatus() );
        productSpuRespDTO.setSpecType( productSpuDO.getSpecType() );
        productSpuRespDTO.setMinPrice( productSpuDO.getMinPrice() );
        productSpuRespDTO.setMaxPrice( productSpuDO.getMaxPrice() );
        productSpuRespDTO.setMarketPrice( productSpuDO.getMarketPrice() );
        productSpuRespDTO.setTotalStock( productSpuDO.getTotalStock() );
        productSpuRespDTO.setShowStock( productSpuDO.getShowStock() );
        productSpuRespDTO.setSalesCount( productSpuDO.getSalesCount() );
        productSpuRespDTO.setVirtualSalesCount( productSpuDO.getVirtualSalesCount() );
        productSpuRespDTO.setClickCount( productSpuDO.getClickCount() );

        return productSpuRespDTO;
    }

    protected ProductSpuSimpleRespVO productSpuDOToProductSpuSimpleRespVO(ProductSpuDO productSpuDO) {
        if ( productSpuDO == null ) {
            return null;
        }

        ProductSpuSimpleRespVO productSpuSimpleRespVO = new ProductSpuSimpleRespVO();

        productSpuSimpleRespVO.setCode( productSpuDO.getCode() );
        productSpuSimpleRespVO.setSellPoint( productSpuDO.getSellPoint() );
        productSpuSimpleRespVO.setDescription( productSpuDO.getDescription() );
        productSpuSimpleRespVO.setCategoryId( productSpuDO.getCategoryId() );
        productSpuSimpleRespVO.setBrandId( productSpuDO.getBrandId() );
        List<String> list = productSpuDO.getPicUrls();
        if ( list != null ) {
            productSpuSimpleRespVO.setPicUrls( new ArrayList<String>( list ) );
        }
        productSpuSimpleRespVO.setVideoUrl( productSpuDO.getVideoUrl() );
        productSpuSimpleRespVO.setSort( productSpuDO.getSort() );
        productSpuSimpleRespVO.setStatus( productSpuDO.getStatus() );
        productSpuSimpleRespVO.setSpecType( productSpuDO.getSpecType() );
        productSpuSimpleRespVO.setShowStock( productSpuDO.getShowStock() );
        productSpuSimpleRespVO.setMarketPrice( productSpuDO.getMarketPrice() );
        productSpuSimpleRespVO.setVirtualSalesCount( productSpuDO.getVirtualSalesCount() );
        productSpuSimpleRespVO.setId( productSpuDO.getId() );
        productSpuSimpleRespVO.setName( productSpuDO.getName() );
        productSpuSimpleRespVO.setMinPrice( productSpuDO.getMinPrice() );
        productSpuSimpleRespVO.setMaxPrice( productSpuDO.getMaxPrice() );

        return productSpuSimpleRespVO;
    }

    protected AppProductPropertyValueDetailRespVO propertyToAppProductPropertyValueDetailRespVO(ProductSkuDO.Property property) {
        if ( property == null ) {
            return null;
        }

        AppProductPropertyValueDetailRespVO appProductPropertyValueDetailRespVO = new AppProductPropertyValueDetailRespVO();

        appProductPropertyValueDetailRespVO.setPropertyId( property.getPropertyId() );
        appProductPropertyValueDetailRespVO.setValueId( property.getValueId() );

        return appProductPropertyValueDetailRespVO;
    }

    protected List<AppProductPropertyValueDetailRespVO> propertyListToAppProductPropertyValueDetailRespVOList(List<ProductSkuDO.Property> list) {
        if ( list == null ) {
            return null;
        }

        List<AppProductPropertyValueDetailRespVO> list1 = new ArrayList<AppProductPropertyValueDetailRespVO>( list.size() );
        for ( ProductSkuDO.Property property : list ) {
            list1.add( propertyToAppProductPropertyValueDetailRespVO( property ) );
        }

        return list1;
    }

    protected AppProductSpuDetailRespVO.Sku productSkuDOToSku(ProductSkuDO productSkuDO) {
        if ( productSkuDO == null ) {
            return null;
        }

        AppProductSpuDetailRespVO.Sku sku = new AppProductSpuDetailRespVO.Sku();

        sku.setId( productSkuDO.getId() );
        sku.setProperties( propertyListToAppProductPropertyValueDetailRespVOList( productSkuDO.getProperties() ) );
        sku.setPrice( productSkuDO.getPrice() );
        sku.setMarketPrice( productSkuDO.getMarketPrice() );
        sku.setPicUrl( productSkuDO.getPicUrl() );
        sku.setStock( productSkuDO.getStock() );
        sku.setWeight( productSkuDO.getWeight() );
        sku.setVolume( productSkuDO.getVolume() );

        return sku;
    }

    protected AppProductSpuPageItemRespVO productSpuDOToAppProductSpuPageItemRespVO(ProductSpuDO productSpuDO) {
        if ( productSpuDO == null ) {
            return null;
        }

        AppProductSpuPageItemRespVO appProductSpuPageItemRespVO = new AppProductSpuPageItemRespVO();

        appProductSpuPageItemRespVO.setId( productSpuDO.getId() );
        appProductSpuPageItemRespVO.setName( productSpuDO.getName() );
        appProductSpuPageItemRespVO.setCategoryId( productSpuDO.getCategoryId() );
        List<String> list = productSpuDO.getPicUrls();
        if ( list != null ) {
            appProductSpuPageItemRespVO.setPicUrls( new ArrayList<String>( list ) );
        }
        appProductSpuPageItemRespVO.setMinPrice( productSpuDO.getMinPrice() );
        appProductSpuPageItemRespVO.setMaxPrice( productSpuDO.getMaxPrice() );
        appProductSpuPageItemRespVO.setSalesCount( productSpuDO.getSalesCount() );

        return appProductSpuPageItemRespVO;
    }

    protected List<AppProductSpuPageItemRespVO> productSpuDOListToAppProductSpuPageItemRespVOList(List<ProductSpuDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppProductSpuPageItemRespVO> list1 = new ArrayList<AppProductSpuPageItemRespVO>( list.size() );
        for ( ProductSpuDO productSpuDO : list ) {
            list1.add( productSpuDOToAppProductSpuPageItemRespVO( productSpuDO ) );
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

    protected ProductSpuDetailRespVO.Sku productSkuDOToSku1(ProductSkuDO productSkuDO) {
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
}
