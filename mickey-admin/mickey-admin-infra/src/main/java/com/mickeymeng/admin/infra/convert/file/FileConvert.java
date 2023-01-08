package com.mickeymeng.admin.infra.convert.file;

import com.mickeymeng.admin.infra.controller.admin.file.vo.file.FileRespVO;
import com.mickeymeng.admin.infra.dal.dataobject.file.FileDO;
import com.mickeymeng.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}
