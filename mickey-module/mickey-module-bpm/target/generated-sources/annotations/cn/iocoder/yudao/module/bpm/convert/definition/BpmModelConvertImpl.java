package cn.iocoder.yudao.module.bpm.convert.definition;

import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.BpmModeImportReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.BpmModelBaseVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.BpmModelCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.BpmModelPageItemRespVO;
import cn.iocoder.yudao.module.bpm.service.definition.dto.BpmModelMetaInfoRespDTO;
import cn.iocoder.yudao.module.bpm.service.definition.dto.BpmProcessDefinitionCreateReqDTO;
import javax.annotation.processing.Generated;
import org.flowable.engine.repository.ProcessDefinition;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-09T13:47:12+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BpmModelConvertImpl implements BpmModelConvert {

    @Override
    public BpmModelCreateReqVO convert(BpmModeImportReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        BpmModelCreateReqVO bpmModelCreateReqVO = new BpmModelCreateReqVO();

        bpmModelCreateReqVO.setKey( bean.getKey() );
        bpmModelCreateReqVO.setName( bean.getName() );
        bpmModelCreateReqVO.setDescription( bean.getDescription() );

        return bpmModelCreateReqVO;
    }

    @Override
    public void copyTo(BpmModelMetaInfoRespDTO from, BpmProcessDefinitionCreateReqDTO to) {
        if ( from == null ) {
            return;
        }

        to.setDescription( from.getDescription() );
        to.setFormType( from.getFormType() );
        to.setFormId( from.getFormId() );
        to.setFormCustomCreatePath( from.getFormCustomCreatePath() );
        to.setFormCustomViewPath( from.getFormCustomViewPath() );
    }

    @Override
    public void copyTo(BpmModelMetaInfoRespDTO from, BpmModelBaseVO to) {
        if ( from == null ) {
            return;
        }

        to.setDescription( from.getDescription() );
        to.setFormType( from.getFormType() );
        to.setFormId( from.getFormId() );
        to.setFormCustomCreatePath( from.getFormCustomCreatePath() );
        to.setFormCustomViewPath( from.getFormCustomViewPath() );
    }

    @Override
    public BpmModelPageItemRespVO.ProcessDefinition convert(ProcessDefinition bean) {
        if ( bean == null ) {
            return null;
        }

        BpmModelPageItemRespVO.ProcessDefinition processDefinition = new BpmModelPageItemRespVO.ProcessDefinition();

        processDefinition.setId( bean.getId() );
        processDefinition.setVersion( bean.getVersion() );

        return processDefinition;
    }
}
