package com.mickeymeng.admin.system.api.dict;

import com.mickeymeng.framework.common.service.dto.DictDataRespDTO;
import com.mickeymeng.admin.system.convert.dict.DictDataConvert;
import com.mickeymeng.admin.system.dal.dataobject.dict.DictDataDO;
import com.mickeymeng.admin.system.service.dict.DictDataService;
import com.mickeymeng.framework.common.service.api.DictDataApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 字典数据 API 实现类
 *
 * @author 芋道源码
 */
@Service
public class DictDataApiImpl implements DictDataApi {

    @Resource
    private DictDataService dictDataService;

    @Override
    public void validDictDatas(String dictType, Collection<String> values) {
        dictDataService.validDictDatas(dictType, values);
    }

    @Override
    public DictDataRespDTO getDictData(String dictType, String value) {
        DictDataDO dictData = dictDataService.getDictData(dictType, value);
        return DictDataConvert.INSTANCE.convert02(dictData);
    }

    @Override
    public DictDataRespDTO parseDictData(String dictType, String label) {
        DictDataDO dictData = dictDataService.parseDictData(dictType, label);
        return DictDataConvert.INSTANCE.convert02(dictData);
    }

}
