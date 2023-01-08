package com.mickeymeng.admin.system.api.permission;

import com.mickeymeng.admin.system.service.permission.RoleService;
import com.mickeymeng.framework.common.service.api.RoleApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 角色 API 实现类
 *
 * @author 芋道源码
 */
@Service
public class RoleApiImpl implements RoleApi {

    @Resource
    private RoleService roleService;

    @Override
    public void validRoles(Collection<Long> ids) {
        roleService.validRoles(ids);
    }
}
