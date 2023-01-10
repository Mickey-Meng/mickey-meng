package cn.iocoder.yudao.module.product.convert.brand;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.product.controller.admin.brand.vo.ProductBrandCreateReqVO;
import cn.iocoder.yudao.module.product.controller.admin.brand.vo.ProductBrandRespVO;
import cn.iocoder.yudao.module.product.controller.admin.brand.vo.ProductBrandUpdateReqVO;
import cn.iocoder.yudao.module.product.dal.dataobject.brand.ProductBrandDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:11+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProductBrandConvertImpl implements ProductBrandConvert {

    @Override
    public ProductBrandDO convert(ProductBrandCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductBrandDO.ProductBrandDOBuilder productBrandDO = ProductBrandDO.builder();

        productBrandDO.name( bean.getName() );
        productBrandDO.picUrl( bean.getPicUrl() );
        productBrandDO.sort( bean.getSort() );
        productBrandDO.description( bean.getDescription() );
        productBrandDO.status( bean.getStatus() );

        return productBrandDO.build();
    }

    @Override
    public ProductBrandDO convert(ProductBrandUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductBrandDO.ProductBrandDOBuilder productBrandDO = ProductBrandDO.builder();

        productBrandDO.id( bean.getId() );
        productBrandDO.name( bean.getName() );
        productBrandDO.picUrl( bean.getPicUrl() );
        productBrandDO.sort( bean.getSort() );
        productBrandDO.description( bean.getDescription() );
        productBrandDO.status( bean.getStatus() );

        return productBrandDO.build();
    }

    @Override
    public ProductBrandRespVO convert(ProductBrandDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductBrandRespVO productBrandRespVO = new ProductBrandRespVO();

        productBrandRespVO.setName( bean.getName() );
        productBrandRespVO.setPicUrl( bean.getPicUrl() );
        productBrandRespVO.setSort( bean.getSort() );
        productBrandRespVO.setDescription( bean.getDescription() );
        productBrandRespVO.setStatus( bean.getStatus() );
        productBrandRespVO.setId( bean.getId() );
        productBrandRespVO.setCreateTime( bean.getCreateTime() );

        return productBrandRespVO;
    }

    @Override
    public List<ProductBrandRespVO> convertList(List<ProductBrandDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductBrandRespVO> list1 = new ArrayList<ProductBrandRespVO>( list.size() );
        for ( ProductBrandDO productBrandDO : list ) {
            list1.add( convert( productBrandDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<ProductBrandRespVO> convertPage(PageResult<ProductBrandDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<ProductBrandRespVO> pageResult = new PageResult<ProductBrandRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }
}
