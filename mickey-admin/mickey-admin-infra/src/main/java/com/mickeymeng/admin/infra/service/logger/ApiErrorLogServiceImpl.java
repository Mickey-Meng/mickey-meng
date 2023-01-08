package com.mickeymeng.admin.infra.service.logger;

import com.mickeymeng.framework.common.constants.ErrorCodeConstants;
import com.mickeymeng.framework.common.exception.util.ServiceExceptionUtil;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.admin.infra.dal.mysql.logger.ApiErrorLogMapper;
import com.mickeymeng.framework.common.service.dto.ApiErrorLogCreateReqDTO;
import com.mickeymeng.admin.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExportReqVO;
import com.mickeymeng.admin.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogPageReqVO;
import com.mickeymeng.admin.infra.convert.logger.ApiErrorLogConvert;
import com.mickeymeng.admin.infra.dal.dataobject.logger.ApiErrorLogDO;
import com.mickeymeng.admin.infra.enums.logger.ApiErrorLogProcessStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * API 错误日志 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApiErrorLogServiceImpl implements ApiErrorLogService {

    @Resource
    private ApiErrorLogMapper apiErrorLogMapper;

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {
        ApiErrorLogDO apiErrorLog = ApiErrorLogConvert.INSTANCE.convert(createDTO);
        apiErrorLog.setProcessStatus(ApiErrorLogProcessStatusEnum.INIT.getStatus());
        apiErrorLogMapper.insert(apiErrorLog);
    }

    @Override
    public PageResult<ApiErrorLogDO> getApiErrorLogPage(ApiErrorLogPageReqVO pageReqVO) {
        return apiErrorLogMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ApiErrorLogDO> getApiErrorLogList(ApiErrorLogExportReqVO exportReqVO) {
        return apiErrorLogMapper.selectList(exportReqVO);
    }

    @Override
    public void updateApiErrorLogProcess(Long id, Integer processStatus, Long processUserId) {
        ApiErrorLogDO errorLog = apiErrorLogMapper.selectById(id);
        if (errorLog == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.API_ERROR_LOG_NOT_FOUND);
        }
        if (!ApiErrorLogProcessStatusEnum.INIT.getStatus().equals(errorLog.getProcessStatus())) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.API_ERROR_LOG_PROCESSED);
        }
        // 标记处理
        apiErrorLogMapper.updateById(ApiErrorLogDO.builder().id(id).processStatus(processStatus)
                .processUserId(processUserId).processTime(LocalDateTime.now()).build());
    }

}
