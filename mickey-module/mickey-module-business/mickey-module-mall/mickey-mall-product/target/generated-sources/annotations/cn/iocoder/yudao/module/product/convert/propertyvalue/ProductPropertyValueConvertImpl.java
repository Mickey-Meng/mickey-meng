package cn.iocoder.yudao.module.product.convert.propertyvalue;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.value.ProductPropertyValueCreateReqVO;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.value.ProductPropertyValueRespVO;
import cn.iocoder.yudao.module.product.controller.admin.property.vo.value.ProductPropertyValueUpdateReqVO;
import cn.iocoder.yudao.module.product.dal.dataobject.property.ProductPropertyValueDO;
import cn.iocoder.yudao.module.product.service.property.bo.ProductPropertyValueDetailRespBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:12+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProductPropertyValueConvertImpl implements ProductPropertyValueConvert {

    @Override
    public ProductPropertyValueDO convert(ProductPropertyValueCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductPropertyValueDO.ProductPropertyValueDOBuilder productPropertyValueDO = ProductPropertyValueDO.builder();

        productPropertyValueDO.propertyId( bean.getPropertyId() );
        productPropertyValueDO.name( bean.getName() );
        productPropertyValueDO.remark( bean.getRemark() );

        return productPropertyValueDO.build();
    }

    @Override
    public ProductPropertyValueDO convert(ProductPropertyValueUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductPropertyValueDO.ProductPropertyValueDOBuilder productPropertyValueDO = ProductPropertyValueDO.builder();

        productPropertyValueDO.id( bean.getId() );
        productPropertyValueDO.propertyId( bean.getPropertyId() );
        productPropertyValueDO.name( bean.getName() );
        productPropertyValueDO.remark( bean.getRemark() );

        return productPropertyValueDO.build();
    }

    @Override
    public ProductPropertyValueRespVO convert(ProductPropertyValueDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductPropertyValueRespVO productPropertyValueRespVO = new ProductPropertyValueRespVO();

        productPropertyValueRespVO.setPropertyId( bean.getPropertyId() );
        productPropertyValueRespVO.setName( bean.getName() );
        productPropertyValueRespVO.setRemark( bean.getRemark() );
        productPropertyValueRespVO.setId( bean.getId() );
        productPropertyValueRespVO.setCreateTime( bean.getCreateTime() );

        return productPropertyValueRespVO;
    }

    @Override
    public List<ProductPropertyValueRespVO> convertList(List<ProductPropertyValueDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductPropertyValueRespVO> list1 = new ArrayList<ProductPropertyValueRespVO>( list.size() );
        for ( ProductPropertyValueDO productPropertyValueDO : list ) {
            list1.add( convert( productPropertyValueDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<ProductPropertyValueRespVO> convertPage(PageResult<ProductPropertyValueDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<ProductPropertyValueRespVO> pageResult = new PageResult<ProductPropertyValueRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<ProductPropertyValueDetailRespDTO> convertList02(List<ProductPropertyValueDetailRespBO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductPropertyValueDetailRespDTO> list1 = new ArrayList<ProductPropertyValueDetailRespDTO>( list.size() );
        for ( ProductPropertyValueDetailRespBO productPropertyValueDetailRespBO : list ) {
            list1.add( productPropertyValueDetailRespBOToProductPropertyValueDetailRespDTO( productPropertyValueDetailRespBO ) );
        }

        return list1;
    }

    protected ProductPropertyValueDetailRespDTO productPropertyValueDetailRespBOToProductPropertyValueDetailRespDTO(ProductPropertyValueDetailRespBO productPropertyValueDetailRespBO) {
        if ( productPropertyValueDetailRespBO == null ) {
            return null;
        }

        ProductPropertyValueDetailRespDTO productPropertyValueDetailRespDTO = new ProductPropertyValueDetailRespDTO();

        productPropertyValueDetailRespDTO.setPropertyId( productPropertyValueDetailRespBO.getPropertyId() );
        productPropertyValueDetailRespDTO.setPropertyName( productPropertyValueDetailRespBO.getPropertyName() );
        productPropertyValueDetailRespDTO.setValueId( productPropertyValueDetailRespBO.getValueId() );
        productPropertyValueDetailRespDTO.setValueName( productPropertyValueDetailRespBO.getValueName() );

        return productPropertyValueDetailRespDTO;
    }
}
