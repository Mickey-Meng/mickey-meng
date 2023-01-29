package cn.iocoder.yudao.module.system.convert.notice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.notice.vo.NoticeCreateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.notice.vo.NoticeRespVO;
import cn.iocoder.yudao.module.system.controller.admin.notice.vo.NoticeUpdateReqVO;
import cn.iocoder.yudao.module.system.controller.app.notice.vo.AppNoticeRespVO;
import cn.iocoder.yudao.module.system.dal.dataobject.notice.NoticeDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T19:56:11+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class NoticeConvertImpl implements NoticeConvert {

    @Override
    public PageResult<NoticeRespVO> convertPage(PageResult<NoticeDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<NoticeRespVO> pageResult = new PageResult<NoticeRespVO>();

        pageResult.setList( noticeDOListToNoticeRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public NoticeRespVO convert(NoticeDO bean) {
        if ( bean == null ) {
            return null;
        }

        NoticeRespVO noticeRespVO = new NoticeRespVO();

        noticeRespVO.setTitle( bean.getTitle() );
        noticeRespVO.setType( bean.getType() );
        noticeRespVO.setContent( bean.getContent() );
        noticeRespVO.setStatus( bean.getStatus() );
        noticeRespVO.setChannel( bean.getChannel() );
        noticeRespVO.setId( bean.getId() );
        noticeRespVO.setCreateTime( bean.getCreateTime() );

        return noticeRespVO;
    }

    @Override
    public NoticeDO convert(NoticeUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        NoticeDO noticeDO = new NoticeDO();

        noticeDO.setId( bean.getId() );
        noticeDO.setTitle( bean.getTitle() );
        noticeDO.setType( bean.getType() );
        noticeDO.setContent( bean.getContent() );
        noticeDO.setStatus( bean.getStatus() );
        noticeDO.setChannel( bean.getChannel() );

        return noticeDO;
    }

    @Override
    public NoticeDO convert(NoticeCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        NoticeDO noticeDO = new NoticeDO();

        noticeDO.setTitle( bean.getTitle() );
        noticeDO.setType( bean.getType() );
        noticeDO.setContent( bean.getContent() );
        noticeDO.setStatus( bean.getStatus() );
        noticeDO.setChannel( bean.getChannel() );

        return noticeDO;
    }

    @Override
    public List<AppNoticeRespVO> convertList(List<NoticeDO> appNoticeList) {
        if ( appNoticeList == null ) {
            return null;
        }

        List<AppNoticeRespVO> list = new ArrayList<AppNoticeRespVO>( appNoticeList.size() );
        for ( NoticeDO noticeDO : appNoticeList ) {
            list.add( noticeDOToAppNoticeRespVO( noticeDO ) );
        }

        return list;
    }

    protected List<NoticeRespVO> noticeDOListToNoticeRespVOList(List<NoticeDO> list) {
        if ( list == null ) {
            return null;
        }

        List<NoticeRespVO> list1 = new ArrayList<NoticeRespVO>( list.size() );
        for ( NoticeDO noticeDO : list ) {
            list1.add( convert( noticeDO ) );
        }

        return list1;
    }

    protected AppNoticeRespVO noticeDOToAppNoticeRespVO(NoticeDO noticeDO) {
        if ( noticeDO == null ) {
            return null;
        }

        AppNoticeRespVO appNoticeRespVO = new AppNoticeRespVO();

        appNoticeRespVO.setTitle( noticeDO.getTitle() );
        appNoticeRespVO.setType( noticeDO.getType() );
        appNoticeRespVO.setContent( noticeDO.getContent() );
        appNoticeRespVO.setStatus( noticeDO.getStatus() );
        appNoticeRespVO.setId( noticeDO.getId() );
        appNoticeRespVO.setCreateTime( noticeDO.getCreateTime() );
        appNoticeRespVO.setChannel( noticeDO.getChannel() );

        return appNoticeRespVO;
    }
}
