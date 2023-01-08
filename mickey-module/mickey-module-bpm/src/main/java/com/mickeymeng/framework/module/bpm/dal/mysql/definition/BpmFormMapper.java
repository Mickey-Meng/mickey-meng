package com.mickeymeng.framework.module.bpm.dal.mysql.definition;


import com.mickeymeng.framework.middleware.mybatis.mybatis.core.mapper.BaseMapperX;
import com.mickeymeng.framework.middleware.mybatis.mybatis.core.query.QueryWrapperX;
import com.mickeymeng.framework.module.bpm.controller.admin.definition.vo.form.BpmFormPageReqVO;
import com.mickeymeng.framework.module.bpm.dal.dataobject.definition.BpmFormDO;
import com.mickeymeng.framework.common.pojo.PageResult;

import org.apache.ibatis.annotations.Mapper;

/**
 * 动态表单 Mapper
 *
 * @author 风里雾里
 */
@Mapper
public interface BpmFormMapper extends BaseMapperX<BpmFormDO> {

    default PageResult<BpmFormDO> selectPage(BpmFormPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<BpmFormDO>()
                .likeIfPresent("name", reqVO.getName())
                .orderByDesc("id"));
    }

}
