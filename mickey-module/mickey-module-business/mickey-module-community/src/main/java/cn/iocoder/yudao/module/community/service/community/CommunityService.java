package cn.iocoder.yudao.module.community.service.community;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.community.controller.admin.community.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.community.CommunityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 小区信息 Service 接口
 *
 * @author Mickey
 */
public interface CommunityService {

    /**
     * 创建小区信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer create(@Valid CommunityCreateReqVO createReqVO);

    /**
     * 更新小区信息
     *
     * @param updateReqVO 更新信息
     */
    void update(@Valid CommunityUpdateReqVO updateReqVO);

    /**
     * 删除小区信息
     *
     * @param id 编号
     */
    void delete(Integer id);

    /**
     * 获得小区信息
     *
     * @param id 编号
     * @return 小区信息
     */
    CommunityDO get(Integer id);

    /**
     * 获得小区信息列表
     *
     * @param ids 编号
     * @return 小区信息列表
     */
    List<CommunityDO> getList(Collection<Integer> ids);

    /**
     * 获得小区信息分页
     *
     * @param pageReqVO 分页查询
     * @return 小区信息分页
     */
    PageResult<CommunityDO> getPage(CommunityPageReqVO pageReqVO);

    /**
     * 获得小区信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 小区信息列表
     */
    List<CommunityDO> getList(CommunityExportReqVO exportReqVO);

    List<CommunityDO> getAllList();
}
