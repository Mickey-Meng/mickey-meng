package com.mickeymeng.admin.infra.service.logger;

import com.mickeymeng.admin.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import com.mickeymeng.admin.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import com.mickeymeng.admin.infra.convert.logger.ApiAccessLogConvert;
import com.mickeymeng.admin.infra.dal.dataobject.logger.ApiAccessLogDO;
import com.mickeymeng.admin.infra.dal.mysql.logger.ApiAccessLogMapper;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.common.service.dto.ApiAccessLogCreateReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * API 访问日志 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApiAccessLogServiceImpl implements ApiAccessLogService {

    @Resource
    private ApiAccessLogMapper apiAccessLogMapper;

    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {
        ApiAccessLogDO apiAccessLog = ApiAccessLogConvert.INSTANCE.convert(createDTO);
        apiAccessLogMapper.insert(apiAccessLog);
    }

    @Override
    public PageResult<ApiAccessLogDO> getApiAccessLogPage(ApiAccessLogPageReqVO pageReqVO) {
        return apiAccessLogMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ApiAccessLogDO> getApiAccessLogList(ApiAccessLogExportReqVO exportReqVO) {
        return apiAccessLogMapper.selectList(exportReqVO);
    }

}
