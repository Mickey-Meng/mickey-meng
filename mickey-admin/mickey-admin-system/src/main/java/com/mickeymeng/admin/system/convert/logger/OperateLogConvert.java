package com.mickeymeng.admin.system.convert.logger;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.common.core.util.collection.MapUtils;
import com.mickeymeng.framework.common.service.dto.OperateLogCreateReqDTO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.operatelog.OperateLogExcelVO;
import com.mickeymeng.admin.system.controller.admin.logger.vo.operatelog.OperateLogRespVO;
import com.mickeymeng.admin.system.dal.dataobject.logger.OperateLogDO;
import com.mickeymeng.admin.system.dal.dataobject.user.AdminUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mickeymeng.framework.common.exception.enums.GlobalErrorCodeConstants.SUCCESS;

@Mapper
public interface OperateLogConvert {

    OperateLogConvert INSTANCE = Mappers.getMapper(OperateLogConvert.class);

    OperateLogDO convert(OperateLogCreateReqDTO bean);

    PageResult<OperateLogRespVO> convertPage(PageResult<OperateLogDO> page);

    OperateLogRespVO convert(OperateLogDO bean);

    default List<OperateLogExcelVO> convertList(List<OperateLogDO> list, Map<Long, AdminUserDO> userMap) {
        return list.stream().map(operateLog -> {
            OperateLogExcelVO excelVO = convert02(operateLog);
            MapUtils.findAndThen(userMap, operateLog.getUserId(), user -> excelVO.setUserNickname(user.getNickname()));
            excelVO.setSuccessStr(SUCCESS.getCode().equals(operateLog.getResultCode()) ? "成功" : "失败");
            return excelVO;
        }).collect(Collectors.toList());
    }

    OperateLogExcelVO convert02(OperateLogDO bean);

}
