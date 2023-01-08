package com.mickeymeng.admin.infra.dal.mysql.file;

import com.mickeymeng.admin.infra.controller.admin.file.vo.file.FilePageReqVO;
import com.mickeymeng.admin.infra.dal.dataobject.file.FileDO;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.middleware.mybatis.mybatis.core.mapper.BaseMapperX;
import com.mickeymeng.framework.middleware.mybatis.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件操作 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface FileMapper extends BaseMapperX<FileDO> {

    default PageResult<FileDO> selectPage(FilePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FileDO>()
                .likeIfPresent(FileDO::getPath, reqVO.getPath())
                .likeIfPresent(FileDO::getType, reqVO.getType())
                .betweenIfPresent(FileDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FileDO::getId));
    }

}
