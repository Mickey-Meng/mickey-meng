package com.mickeymeng.admin.system.api.dept;

import com.mickeymeng.admin.system.service.dept.PostService;
import com.mickeymeng.framework.common.service.api.PostApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 岗位 API 实现类
 *
 * @author
 */
@Service
public class PostApiImpl implements PostApi {

    @Resource
    private PostService postService;

    @Override
    public void validPosts(Collection<Long> ids) {
        postService.validPosts(ids);
    }
}
