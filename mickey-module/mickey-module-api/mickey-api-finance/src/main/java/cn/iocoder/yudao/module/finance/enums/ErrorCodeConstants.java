package cn.iocoder.yudao.module.finance.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Member 错误码枚举类
 *
 * member 系统，使用 1-004-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode RECEIVABLES_NOT_EXISTS = new ErrorCode(100600000, "应收款信息不存在");
    ErrorCode RECEIVABLES_DETAILED_NOT_EXISTS = new ErrorCode(100600001, "应收款明细不存在");
    ErrorCode REFUND_DETAILED_NOT_EXISTS = new ErrorCode(100600002, "退款明细不存在");
}
