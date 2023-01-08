package com.mickeymeng.framework.module.bpm.dal.mysql.task;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.middleware.mybatis.mybatis.core.mapper.BaseMapperX;
import com.mickeymeng.framework.middleware.mybatis.mybatis.core.query.LambdaQueryWrapperX;
import com.mickeymeng.framework.module.bpm.controller.admin.task.vo.instance.BpmProcessInstanceMyPageReqVO;
import com.mickeymeng.framework.module.bpm.dal.dataobject.task.BpmProcessInstanceExtDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BpmProcessInstanceExtMapper extends BaseMapperX<BpmProcessInstanceExtDO> {

    default PageResult<BpmProcessInstanceExtDO> selectPage(Long userId, BpmProcessInstanceMyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmProcessInstanceExtDO>()
                .eqIfPresent(BpmProcessInstanceExtDO::getStartUserId, userId)
                .likeIfPresent(BpmProcessInstanceExtDO::getName, reqVO.getName())
                .eqIfPresent(BpmProcessInstanceExtDO::getProcessDefinitionId, reqVO.getProcessDefinitionId())
                .eqIfPresent(BpmProcessInstanceExtDO::getCategory, reqVO.getCategory())
                .eqIfPresent(BpmProcessInstanceExtDO::getStatus, reqVO.getStatus())
                .eqIfPresent(BpmProcessInstanceExtDO::getResult, reqVO.getResult())
                .betweenIfPresent(BpmProcessInstanceExtDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmProcessInstanceExtDO::getId));
    }

    default BpmProcessInstanceExtDO selectByProcessInstanceId(String processInstanceId) {
        return selectOne(BpmProcessInstanceExtDO::getProcessInstanceId, processInstanceId);
    }

    default void updateByProcessInstanceId(BpmProcessInstanceExtDO updateObj) {
        update(updateObj, new LambdaQueryWrapperX<BpmProcessInstanceExtDO>()
                .eq(BpmProcessInstanceExtDO::getProcessInstanceId, updateObj.getProcessInstanceId()));
    }

}
