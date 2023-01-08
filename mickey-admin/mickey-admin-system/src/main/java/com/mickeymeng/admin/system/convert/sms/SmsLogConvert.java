package com.mickeymeng.admin.system.convert.sms;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.admin.system.controller.admin.sms.vo.log.SmsLogExcelVO;
import com.mickeymeng.admin.system.controller.admin.sms.vo.log.SmsLogRespVO;
import com.mickeymeng.admin.system.dal.dataobject.sms.SmsLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 短信日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SmsLogConvert {

    SmsLogConvert INSTANCE = Mappers.getMapper(SmsLogConvert.class);

    SmsLogRespVO convert(SmsLogDO bean);

    List<SmsLogRespVO> convertList(List<SmsLogDO> list);

    PageResult<SmsLogRespVO> convertPage(PageResult<SmsLogDO> page);

    List<SmsLogExcelVO> convertList02(List<SmsLogDO> list);

}
