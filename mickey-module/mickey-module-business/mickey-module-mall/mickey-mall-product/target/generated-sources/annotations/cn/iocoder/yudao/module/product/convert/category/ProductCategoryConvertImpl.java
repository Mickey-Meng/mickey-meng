package cn.iocoder.yudao.module.product.convert.category;

import cn.iocoder.yudao.module.product.controller.admin.category.vo.ProductCategoryCreateReqVO;
import cn.iocoder.yudao.module.product.controller.admin.category.vo.ProductCategoryRespVO;
import cn.iocoder.yudao.module.product.controller.admin.category.vo.ProductCategoryUpdateReqVO;
import cn.iocoder.yudao.module.product.controller.app.category.vo.AppCategoryRespVO;
import cn.iocoder.yudao.module.product.dal.dataobject.category.ProductCategoryDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:12+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProductCategoryConvertImpl implements ProductCategoryConvert {

    @Override
    public ProductCategoryDO convert(ProductCategoryCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductCategoryDO.ProductCategoryDOBuilder productCategoryDO = ProductCategoryDO.builder();

        productCategoryDO.parentId( bean.getParentId() );
        productCategoryDO.name( bean.getName() );
        productCategoryDO.picUrl( bean.getPicUrl() );
        productCategoryDO.sort( bean.getSort() );
        productCategoryDO.description( bean.getDescription() );
        productCategoryDO.status( bean.getStatus() );

        return productCategoryDO.build();
    }

    @Override
    public ProductCategoryDO convert(ProductCategoryUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductCategoryDO.ProductCategoryDOBuilder productCategoryDO = ProductCategoryDO.builder();

        productCategoryDO.id( bean.getId() );
        productCategoryDO.parentId( bean.getParentId() );
        productCategoryDO.name( bean.getName() );
        productCategoryDO.picUrl( bean.getPicUrl() );
        productCategoryDO.sort( bean.getSort() );
        productCategoryDO.description( bean.getDescription() );
        productCategoryDO.status( bean.getStatus() );

        return productCategoryDO.build();
    }

    @Override
    public ProductCategoryRespVO convert(ProductCategoryDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductCategoryRespVO productCategoryRespVO = new ProductCategoryRespVO();

        productCategoryRespVO.setParentId( bean.getParentId() );
        productCategoryRespVO.setName( bean.getName() );
        productCategoryRespVO.setPicUrl( bean.getPicUrl() );
        productCategoryRespVO.setSort( bean.getSort() );
        productCategoryRespVO.setDescription( bean.getDescription() );
        productCategoryRespVO.setStatus( bean.getStatus() );
        productCategoryRespVO.setId( bean.getId() );
        productCategoryRespVO.setCreateTime( bean.getCreateTime() );

        return productCategoryRespVO;
    }

    @Override
    public List<ProductCategoryRespVO> convertList(List<ProductCategoryDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductCategoryRespVO> list1 = new ArrayList<ProductCategoryRespVO>( list.size() );
        for ( ProductCategoryDO productCategoryDO : list ) {
            list1.add( convert( productCategoryDO ) );
        }

        return list1;
    }

    @Override
    public List<AppCategoryRespVO> convertList03(List<ProductCategoryDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppCategoryRespVO> list1 = new ArrayList<AppCategoryRespVO>( list.size() );
        for ( ProductCategoryDO productCategoryDO : list ) {
            list1.add( productCategoryDOToAppCategoryRespVO( productCategoryDO ) );
        }

        return list1;
    }

    protected AppCategoryRespVO productCategoryDOToAppCategoryRespVO(ProductCategoryDO productCategoryDO) {
        if ( productCategoryDO == null ) {
            return null;
        }

        AppCategoryRespVO appCategoryRespVO = new AppCategoryRespVO();

        appCategoryRespVO.setId( productCategoryDO.getId() );
        appCategoryRespVO.setParentId( productCategoryDO.getParentId() );
        appCategoryRespVO.setName( productCategoryDO.getName() );
        appCategoryRespVO.setPicUrl( productCategoryDO.getPicUrl() );

        return appCategoryRespVO;
    }
}
