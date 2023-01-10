package cn.iocoder.yudao.module.product.convert.property;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.property.ProductPropertyAndValueRespVO;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.property.ProductPropertyCreateReqVO;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.property.ProductPropertyRespVO;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.property.ProductPropertyUpdateReqVO;
import cn.iocoder.yudao.module.product.dal.dataobject.property.ProductPropertyDO;
import cn.iocoder.yudao.module.product.dal.dataobject.property.ProductPropertyValueDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:12+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProductPropertyConvertImpl implements ProductPropertyConvert {

    @Override
    public ProductPropertyDO convert(ProductPropertyCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductPropertyDO.ProductPropertyDOBuilder productPropertyDO = ProductPropertyDO.builder();

        productPropertyDO.name( bean.getName() );
        productPropertyDO.remark( bean.getRemark() );

        return productPropertyDO.build();
    }

    @Override
    public ProductPropertyDO convert(ProductPropertyUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductPropertyDO.ProductPropertyDOBuilder productPropertyDO = ProductPropertyDO.builder();

        productPropertyDO.id( bean.getId() );
        productPropertyDO.name( bean.getName() );
        productPropertyDO.remark( bean.getRemark() );

        return productPropertyDO.build();
    }

    @Override
    public ProductPropertyRespVO convert(ProductPropertyDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductPropertyRespVO productPropertyRespVO = new ProductPropertyRespVO();

        productPropertyRespVO.setName( bean.getName() );
        productPropertyRespVO.setRemark( bean.getRemark() );
        productPropertyRespVO.setId( bean.getId() );
        productPropertyRespVO.setCreateTime( bean.getCreateTime() );

        return productPropertyRespVO;
    }

    @Override
    public List<ProductPropertyRespVO> convertList(List<ProductPropertyDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductPropertyRespVO> list1 = new ArrayList<ProductPropertyRespVO>( list.size() );
        for ( ProductPropertyDO productPropertyDO : list ) {
            list1.add( convert( productPropertyDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<ProductPropertyRespVO> convertPage(PageResult<ProductPropertyDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<ProductPropertyRespVO> pageResult = new PageResult<ProductPropertyRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public ProductPropertyAndValueRespVO convert02(ProductPropertyDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductPropertyAndValueRespVO productPropertyAndValueRespVO = new ProductPropertyAndValueRespVO();

        productPropertyAndValueRespVO.setId( bean.getId() );
        productPropertyAndValueRespVO.setName( bean.getName() );

        return productPropertyAndValueRespVO;
    }

    @Override
    public List<ProductPropertyAndValueRespVO.Value> convertList02(List<ProductPropertyValueDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductPropertyAndValueRespVO.Value> list1 = new ArrayList<ProductPropertyAndValueRespVO.Value>( list.size() );
        for ( ProductPropertyValueDO productPropertyValueDO : list ) {
            list1.add( productPropertyValueDOToValue( productPropertyValueDO ) );
        }

        return list1;
    }

    protected ProductPropertyAndValueRespVO.Value productPropertyValueDOToValue(ProductPropertyValueDO productPropertyValueDO) {
        if ( productPropertyValueDO == null ) {
            return null;
        }

        ProductPropertyAndValueRespVO.Value value = new ProductPropertyAndValueRespVO.Value();

        value.setId( productPropertyValueDO.getId() );
        value.setName( productPropertyValueDO.getName() );

        return value;
    }
}
