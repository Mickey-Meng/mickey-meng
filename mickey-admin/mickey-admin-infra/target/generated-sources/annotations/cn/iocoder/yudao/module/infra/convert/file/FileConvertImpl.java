package cn.iocoder.yudao.module.infra.convert.file;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.FileRespVO;
import cn.iocoder.yudao.module.infra.dal.dataobject.file.FileDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-05T17:10:20+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class FileConvertImpl implements FileConvert {

    @Override
    public FileRespVO convert(FileDO bean) {
        if ( bean == null ) {
            return null;
        }

        FileRespVO fileRespVO = new FileRespVO();

        fileRespVO.setId( bean.getId() );
        fileRespVO.setConfigId( bean.getConfigId() );
        fileRespVO.setPath( bean.getPath() );
        fileRespVO.setName( bean.getName() );
        fileRespVO.setUrl( bean.getUrl() );
        fileRespVO.setType( bean.getType() );
        fileRespVO.setSize( bean.getSize() );
        fileRespVO.setCreateTime( bean.getCreateTime() );

        return fileRespVO;
    }

    @Override
    public PageResult<FileRespVO> convertPage(PageResult<FileDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<FileRespVO> pageResult = new PageResult<FileRespVO>();

        pageResult.setList( fileDOListToFileRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected List<FileRespVO> fileDOListToFileRespVOList(List<FileDO> list) {
        if ( list == null ) {
            return null;
        }

        List<FileRespVO> list1 = new ArrayList<FileRespVO>( list.size() );
        for ( FileDO fileDO : list ) {
            list1.add( convert( fileDO ) );
        }

        return list1;
    }
}
