package com.mickeymeng.framework.tenant.core.util;

import com.mickeymeng.framework.common.core.util.web.WebFrameworkUtils;
import com.mickeymeng.framework.tenant.core.context.TenantContextHolder;

import java.util.Map;

/**
 * 多租户 Util
 *
 * @author 芋道源码
 */
public class TenantUtils {

    /**
     * 使用指定租户，执行对应的逻辑
     *
     * 注意，如果当前是忽略租户的情况下，会被强制设置成不忽略租户
     * 当然，执行完成后，还是会恢复回去
     *
     * @param tenantId 租户编号
     * @param runnable 逻辑
     */
    public static void execute(Long tenantId, Runnable runnable) {
        Long oldTenantId = TenantContextHolder.getTenantId();
        Boolean oldIgnore = TenantContextHolder.isIgnore();
        try {
            TenantContextHolder.setTenantId(tenantId);
            TenantContextHolder.setIgnore(false);
            // 执行逻辑
            runnable.run();
        } finally {
            TenantContextHolder.setTenantId(oldTenantId);
            TenantContextHolder.setIgnore(oldIgnore);
        }
    }

    /**
     * 忽略租户，执行对应的逻辑
     *
     * @param runnable 逻辑
     */
    public static void executeIgnore(Runnable runnable) {
        Boolean oldIgnore = TenantContextHolder.isIgnore();
        try {
            TenantContextHolder.setIgnore(true);
            // 执行逻辑
            runnable.run();
        } finally {
            TenantContextHolder.setIgnore(oldIgnore);
        }
    }

    /**
     * 将多租户编号，添加到 header 中
     *
     * @param headers HTTP 请求 headers
     */
    public static void addTenantHeader(Map<String, String> headers) {
        Long tenantId = TenantContextHolder.getTenantId();
        if (tenantId != null) {
            headers.put(WebFrameworkUtils.HEADER_TENANT_ID, tenantId.toString());
        }
    }

}