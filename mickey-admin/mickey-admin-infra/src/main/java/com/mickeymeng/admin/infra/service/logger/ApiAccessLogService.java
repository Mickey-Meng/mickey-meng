package com.mickeymeng.admin.infra.service.logger;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.admin.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import com.mickeymeng.admin.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import com.mickeymeng.admin.infra.dal.dataobject.logger.ApiAccessLogDO;
import com.mickeymeng.framework.common.service.dto.ApiAccessLogCreateReqDTO;

import java.util.List;

/**
 * API 访问日志 Service 接口
 *
 * @author 芋道源码
 */
public interface ApiAccessLogService {

    /**
     * 创建 API 访问日志
     *
     * @param createReqDTO API 访问日志
     */
    void createApiAccessLog(ApiAccessLogCreateReqDTO createReqDTO);

    /**
     * 获得 API 访问日志分页
     *
     * @param pageReqVO 分页查询
     * @return API 访问日志分页
     */
    PageResult<ApiAccessLogDO> getApiAccessLogPage(ApiAccessLogPageReqVO pageReqVO);

    /**
     * 获得 API 访问日志列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return API 访问日志分页
     */
    List<ApiAccessLogDO> getApiAccessLogList(ApiAccessLogExportReqVO exportReqVO);

}
