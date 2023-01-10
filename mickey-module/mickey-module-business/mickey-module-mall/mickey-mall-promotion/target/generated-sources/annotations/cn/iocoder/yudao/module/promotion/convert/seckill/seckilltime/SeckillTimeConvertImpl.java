package cn.iocoder.yudao.module.promotion.convert.seckill.seckilltime;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.time.SeckillTimeCreateReqVO;
import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.time.SeckillTimeRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.time.SeckillTimeUpdateReqVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.seckill.seckilltime.SeckillTimeDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:07+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class SeckillTimeConvertImpl implements SeckillTimeConvert {

    @Override
    public SeckillTimeDO convert(SeckillTimeCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        SeckillTimeDO seckillTimeDO = new SeckillTimeDO();

        seckillTimeDO.setName( bean.getName() );
        seckillTimeDO.setStartTime( bean.getStartTime() );
        seckillTimeDO.setEndTime( bean.getEndTime() );

        return seckillTimeDO;
    }

    @Override
    public SeckillTimeDO convert(SeckillTimeUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        SeckillTimeDO seckillTimeDO = new SeckillTimeDO();

        seckillTimeDO.setId( bean.getId() );
        seckillTimeDO.setName( bean.getName() );
        seckillTimeDO.setStartTime( bean.getStartTime() );
        seckillTimeDO.setEndTime( bean.getEndTime() );

        return seckillTimeDO;
    }

    @Override
    public SeckillTimeRespVO convert(SeckillTimeDO bean) {
        if ( bean == null ) {
            return null;
        }

        SeckillTimeRespVO seckillTimeRespVO = new SeckillTimeRespVO();

        seckillTimeRespVO.setName( bean.getName() );
        seckillTimeRespVO.setStartTime( bean.getStartTime() );
        seckillTimeRespVO.setEndTime( bean.getEndTime() );
        seckillTimeRespVO.setId( bean.getId() );
        seckillTimeRespVO.setSeckillActivityCount( bean.getSeckillActivityCount() );
        seckillTimeRespVO.setCreateTime( bean.getCreateTime() );

        return seckillTimeRespVO;
    }

    @Override
    public List<SeckillTimeRespVO> convertList(List<SeckillTimeDO> list) {
        if ( list == null ) {
            return null;
        }

        List<SeckillTimeRespVO> list1 = new ArrayList<SeckillTimeRespVO>( list.size() );
        for ( SeckillTimeDO seckillTimeDO : list ) {
            list1.add( convert( seckillTimeDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<SeckillTimeRespVO> convertPage(PageResult<SeckillTimeDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<SeckillTimeRespVO> pageResult = new PageResult<SeckillTimeRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }
}
