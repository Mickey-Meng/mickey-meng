package cn.iocoder.yudao.module.bpm.convert.message;

import cn.iocoder.yudao.module.system.api.sms.dto.send.SmsSendSingleToUserReqDTO;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T13:30:22+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BpmMessageConvertImpl implements BpmMessageConvert {

    @Override
    public SmsSendSingleToUserReqDTO convert(Long userId, String templateCode, Map<String, Object> templateParams) {
        if ( userId == null && templateCode == null && templateParams == null ) {
            return null;
        }

        SmsSendSingleToUserReqDTO smsSendSingleToUserReqDTO = new SmsSendSingleToUserReqDTO();

        smsSendSingleToUserReqDTO.setUserId( userId );
        smsSendSingleToUserReqDTO.setTemplateCode( templateCode );
        Map<String, Object> map = templateParams;
        if ( map != null ) {
            smsSendSingleToUserReqDTO.setTemplateParams( new LinkedHashMap<String, Object>( map ) );
        }

        return smsSendSingleToUserReqDTO;
    }
}
