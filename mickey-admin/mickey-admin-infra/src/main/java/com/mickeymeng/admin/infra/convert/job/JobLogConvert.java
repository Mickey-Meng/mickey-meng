package com.mickeymeng.admin.infra.convert.job;

import com.mickeymeng.admin.infra.controller.admin.job.vo.log.JobLogExcelVO;
import com.mickeymeng.admin.infra.controller.admin.job.vo.log.JobLogRespVO;
import com.mickeymeng.admin.infra.dal.dataobject.job.JobLogDO;
import com.mickeymeng.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 定时任务日志 Convert
 *
 * @author 芋艿
 */
@Mapper
public interface JobLogConvert {

    JobLogConvert INSTANCE = Mappers.getMapper(JobLogConvert.class);

    JobLogRespVO convert(JobLogDO bean);

    List<JobLogRespVO> convertList(List<JobLogDO> list);

    PageResult<JobLogRespVO> convertPage(PageResult<JobLogDO> page);

    List<JobLogExcelVO> convertList02(List<JobLogDO> list);

}