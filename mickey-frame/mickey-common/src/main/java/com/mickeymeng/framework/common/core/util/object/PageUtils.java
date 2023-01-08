package com.mickeymeng.framework.common.core.util.object;

import com.mickeymeng.framework.common.pojo.PageParam;

/**
 * {@link com.mickeymeng.framework.common.pojo.PageParam} 工具类
 *
 * @author 芋道源码
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
