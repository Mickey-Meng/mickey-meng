package cn.iocoder.yudao.module.bpm.convert.oa;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOALeaveCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOALeaveRespVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-09T13:47:11+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BpmOALeaveConvertImpl implements BpmOALeaveConvert {

    @Override
    public BpmOALeaveDO convert(BpmOALeaveCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        BpmOALeaveDO.BpmOALeaveDOBuilder bpmOALeaveDO = BpmOALeaveDO.builder();

        if ( bean.getType() != null ) {
            bpmOALeaveDO.type( String.valueOf( bean.getType() ) );
        }
        bpmOALeaveDO.reason( bean.getReason() );
        bpmOALeaveDO.startTime( bean.getStartTime() );
        bpmOALeaveDO.endTime( bean.getEndTime() );

        return bpmOALeaveDO.build();
    }

    @Override
    public BpmOALeaveRespVO convert(BpmOALeaveDO bean) {
        if ( bean == null ) {
            return null;
        }

        BpmOALeaveRespVO bpmOALeaveRespVO = new BpmOALeaveRespVO();

        bpmOALeaveRespVO.setStartTime( bean.getStartTime() );
        bpmOALeaveRespVO.setEndTime( bean.getEndTime() );
        if ( bean.getType() != null ) {
            bpmOALeaveRespVO.setType( Integer.parseInt( bean.getType() ) );
        }
        bpmOALeaveRespVO.setReason( bean.getReason() );
        bpmOALeaveRespVO.setId( bean.getId() );
        bpmOALeaveRespVO.setResult( bean.getResult() );
        bpmOALeaveRespVO.setCreateTime( bean.getCreateTime() );
        bpmOALeaveRespVO.setProcessInstanceId( bean.getProcessInstanceId() );

        return bpmOALeaveRespVO;
    }

    @Override
    public List<BpmOALeaveRespVO> convertList(List<BpmOALeaveDO> list) {
        if ( list == null ) {
            return null;
        }

        List<BpmOALeaveRespVO> list1 = new ArrayList<BpmOALeaveRespVO>( list.size() );
        for ( BpmOALeaveDO bpmOALeaveDO : list ) {
            list1.add( convert( bpmOALeaveDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<BpmOALeaveRespVO> convertPage(PageResult<BpmOALeaveDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<BpmOALeaveRespVO> pageResult = new PageResult<BpmOALeaveRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }
}
