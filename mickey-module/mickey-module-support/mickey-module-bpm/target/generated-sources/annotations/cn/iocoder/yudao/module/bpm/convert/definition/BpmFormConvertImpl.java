package cn.iocoder.yudao.module.bpm.convert.definition;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form.BpmFormCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form.BpmFormRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form.BpmFormSimpleRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form.BpmFormUpdateReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.definition.BpmFormDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:21+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BpmFormConvertImpl implements BpmFormConvert {

    @Override
    public BpmFormDO convert(BpmFormCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        BpmFormDO.BpmFormDOBuilder bpmFormDO = BpmFormDO.builder();

        bpmFormDO.name( bean.getName() );
        bpmFormDO.status( bean.getStatus() );
        bpmFormDO.conf( bean.getConf() );
        List<String> list = bean.getFields();
        if ( list != null ) {
            bpmFormDO.fields( new ArrayList<String>( list ) );
        }
        bpmFormDO.remark( bean.getRemark() );

        return bpmFormDO.build();
    }

    @Override
    public BpmFormDO convert(BpmFormUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        BpmFormDO.BpmFormDOBuilder bpmFormDO = BpmFormDO.builder();

        bpmFormDO.id( bean.getId() );
        bpmFormDO.name( bean.getName() );
        bpmFormDO.status( bean.getStatus() );
        bpmFormDO.conf( bean.getConf() );
        List<String> list = bean.getFields();
        if ( list != null ) {
            bpmFormDO.fields( new ArrayList<String>( list ) );
        }
        bpmFormDO.remark( bean.getRemark() );

        return bpmFormDO.build();
    }

    @Override
    public BpmFormRespVO convert(BpmFormDO bean) {
        if ( bean == null ) {
            return null;
        }

        BpmFormRespVO bpmFormRespVO = new BpmFormRespVO();

        bpmFormRespVO.setName( bean.getName() );
        bpmFormRespVO.setStatus( bean.getStatus() );
        bpmFormRespVO.setRemark( bean.getRemark() );
        bpmFormRespVO.setId( bean.getId() );
        bpmFormRespVO.setConf( bean.getConf() );
        List<String> list = bean.getFields();
        if ( list != null ) {
            bpmFormRespVO.setFields( new ArrayList<String>( list ) );
        }
        bpmFormRespVO.setCreateTime( bean.getCreateTime() );

        return bpmFormRespVO;
    }

    @Override
    public List<BpmFormSimpleRespVO> convertList2(List<BpmFormDO> list) {
        if ( list == null ) {
            return null;
        }

        List<BpmFormSimpleRespVO> list1 = new ArrayList<BpmFormSimpleRespVO>( list.size() );
        for ( BpmFormDO bpmFormDO : list ) {
            list1.add( bpmFormDOToBpmFormSimpleRespVO( bpmFormDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<BpmFormRespVO> convertPage(PageResult<BpmFormDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<BpmFormRespVO> pageResult = new PageResult<BpmFormRespVO>();

        pageResult.setList( bpmFormDOListToBpmFormRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected BpmFormSimpleRespVO bpmFormDOToBpmFormSimpleRespVO(BpmFormDO bpmFormDO) {
        if ( bpmFormDO == null ) {
            return null;
        }

        BpmFormSimpleRespVO bpmFormSimpleRespVO = new BpmFormSimpleRespVO();

        bpmFormSimpleRespVO.setId( bpmFormDO.getId() );
        bpmFormSimpleRespVO.setName( bpmFormDO.getName() );

        return bpmFormSimpleRespVO;
    }

    protected List<BpmFormRespVO> bpmFormDOListToBpmFormRespVOList(List<BpmFormDO> list) {
        if ( list == null ) {
            return null;
        }

        List<BpmFormRespVO> list1 = new ArrayList<BpmFormRespVO>( list.size() );
        for ( BpmFormDO bpmFormDO : list ) {
            list1.add( convert( bpmFormDO ) );
        }

        return list1;
    }
}
