package com.mickeymeng.admin.system.api.permission;

import com.mickeymeng.framework.common.service.dto.DeptDataPermissionRespDTO;
import com.mickeymeng.admin.system.service.permission.PermissionService;
import com.mickeymeng.framework.common.service.api.PermissionApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * 权限 API 实现类
 *
 * @author 芋道源码
 */
@Service
public class PermissionApiImpl implements PermissionApi {

    @Resource
    private PermissionService permissionService;

    @Override
    public Set<Long> getUserRoleIdListByRoleIds(Collection<Long> roleIds) {
        return permissionService.getUserRoleIdListByRoleIds(roleIds);
    }

    @Override
    public boolean hasAnyPermissions(Long userId, String... permissions) {
        return permissionService.hasAnyPermissions(userId, permissions);
    }

    @Override
    public boolean hasAnyRoles(Long userId, String... roles) {
        return permissionService.hasAnyRoles(userId, roles);
    }

    @Override
    public DeptDataPermissionRespDTO getDeptDataPermission(Long userId) {
        return permissionService.getDeptDataPermission(userId);
    }

}
