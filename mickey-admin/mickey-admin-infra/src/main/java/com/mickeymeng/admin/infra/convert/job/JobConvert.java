package com.mickeymeng.admin.infra.convert.job;

import com.mickeymeng.admin.infra.controller.admin.job.vo.job.JobCreateReqVO;
import com.mickeymeng.admin.infra.controller.admin.job.vo.job.JobExcelVO;
import com.mickeymeng.admin.infra.controller.admin.job.vo.job.JobRespVO;
import com.mickeymeng.admin.infra.controller.admin.job.vo.job.JobUpdateReqVO;
import com.mickeymeng.admin.infra.dal.dataobject.job.JobDO;
import com.mickeymeng.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 定时任务 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface JobConvert {

    JobConvert INSTANCE = Mappers.getMapper(JobConvert.class);

    JobDO convert(JobCreateReqVO bean);

    JobDO convert(JobUpdateReqVO bean);

    JobRespVO convert(JobDO bean);

    List<JobRespVO> convertList(List<JobDO> list);

    PageResult<JobRespVO> convertPage(PageResult<JobDO> page);

    List<JobExcelVO> convertList02(List<JobDO> list);

}
