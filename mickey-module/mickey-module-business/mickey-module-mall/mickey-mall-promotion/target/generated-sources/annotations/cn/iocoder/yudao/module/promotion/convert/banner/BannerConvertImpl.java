package cn.iocoder.yudao.module.promotion.convert.banner;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.banner.vo.BannerCreateReqVO;
import cn.iocoder.yudao.module.promotion.controller.admin.banner.vo.BannerRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.banner.vo.BannerUpdateReqVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.banner.BannerDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:07+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BannerConvertImpl implements BannerConvert {

    @Override
    public List<BannerRespVO> convertList(List<BannerDO> list) {
        if ( list == null ) {
            return null;
        }

        List<BannerRespVO> list1 = new ArrayList<BannerRespVO>( list.size() );
        for ( BannerDO bannerDO : list ) {
            list1.add( convert( bannerDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<BannerRespVO> convertPage(PageResult<BannerDO> pageResult) {
        if ( pageResult == null ) {
            return null;
        }

        PageResult<BannerRespVO> pageResult1 = new PageResult<BannerRespVO>();

        pageResult1.setList( convertList( pageResult.getList() ) );
        pageResult1.setTotal( pageResult.getTotal() );

        return pageResult1;
    }

    @Override
    public BannerRespVO convert(BannerDO banner) {
        if ( banner == null ) {
            return null;
        }

        BannerRespVO bannerRespVO = new BannerRespVO();

        bannerRespVO.setTitle( banner.getTitle() );
        bannerRespVO.setUrl( banner.getUrl() );
        bannerRespVO.setPicUrl( banner.getPicUrl() );
        bannerRespVO.setSort( banner.getSort() );
        bannerRespVO.setStatus( banner.getStatus() );
        bannerRespVO.setMemo( banner.getMemo() );
        bannerRespVO.setId( banner.getId() );
        bannerRespVO.setCreateTime( banner.getCreateTime() );

        return bannerRespVO;
    }

    @Override
    public BannerDO convert(BannerCreateReqVO createReqVO) {
        if ( createReqVO == null ) {
            return null;
        }

        BannerDO.BannerDOBuilder bannerDO = BannerDO.builder();

        bannerDO.title( createReqVO.getTitle() );
        bannerDO.url( createReqVO.getUrl() );
        bannerDO.picUrl( createReqVO.getPicUrl() );
        bannerDO.sort( createReqVO.getSort() );
        bannerDO.status( createReqVO.getStatus() );
        bannerDO.memo( createReqVO.getMemo() );

        return bannerDO.build();
    }

    @Override
    public BannerDO convert(BannerUpdateReqVO updateReqVO) {
        if ( updateReqVO == null ) {
            return null;
        }

        BannerDO.BannerDOBuilder bannerDO = BannerDO.builder();

        bannerDO.id( updateReqVO.getId() );
        bannerDO.title( updateReqVO.getTitle() );
        bannerDO.url( updateReqVO.getUrl() );
        bannerDO.picUrl( updateReqVO.getPicUrl() );
        bannerDO.sort( updateReqVO.getSort() );
        bannerDO.status( updateReqVO.getStatus() );
        bannerDO.memo( updateReqVO.getMemo() );

        return bannerDO.build();
    }
}
