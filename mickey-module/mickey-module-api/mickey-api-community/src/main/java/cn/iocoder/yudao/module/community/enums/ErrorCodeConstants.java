package cn.iocoder.yudao.module.community.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Member 错误码枚举类
 *
 * member 系统，使用 1-004-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode COMMUNITY_NOT_EXISTS = new ErrorCode(100500000, "用户收件地址不存在");
    ErrorCode OWNER_NOT_EXISTS = new ErrorCode(100500001, "业主信息不存在");
    ErrorCode MENU_NOT_EXISTS = new ErrorCode(100500002, "服务菜单不存在");
}
