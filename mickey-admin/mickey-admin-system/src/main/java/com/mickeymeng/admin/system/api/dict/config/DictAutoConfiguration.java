package com.mickeymeng.admin.system.api.dict.config;

import com.mickeymeng.framework.common.service.api.DictDataApi;
import com.mickeymeng.framework.dict.core.util.DictFrameworkUtils;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class DictAutoConfiguration {

    @Bean
    @SuppressWarnings("InstantiationOfUtilityClass")
    public DictFrameworkUtils dictUtils(DictDataApi dictDataApi) {
        DictFrameworkUtils.init(dictDataApi);
        return new DictFrameworkUtils();
    }

}
