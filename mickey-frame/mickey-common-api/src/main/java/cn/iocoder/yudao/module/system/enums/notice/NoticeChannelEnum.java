package cn.iocoder.yudao.module.system.enums.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通知类型
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum NoticeChannelEnum {

    SYSTEM_NOTICE("system_notice",0),
    APP_COMMUNITY_NOTICE("app_community_notice",1);

    private final String scopeName;
    private final Integer scopeCode;

}
