package cn.iocoder.yudao.module.community.service.owner;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.community.controller.admin.owner.vo.*;
import cn.iocoder.yudao.module.community.dal.dataobject.owner.OwnerDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 业主信息 Service 接口
 *
 * @author Mickey
 */
public interface OwnerService {

    /**
     * 创建业主信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOwner(@Valid OwnerCreateReqVO createReqVO);

    /**
     * 更新业主信息
     *
     * @param updateReqVO 更新信息
     */
    void updateOwner(@Valid OwnerUpdateReqVO updateReqVO);

    /**
     * 删除业主信息
     *
     * @param id 编号
     */
    void deleteOwner(Long id);

    /**
     * 获得业主信息
     *
     * @param id 编号
     * @return 业主信息
     */
    OwnerDO getOwner(Long id);

    /**
     * 获得业主信息列表
     *
     * @param ids 编号
     * @return 业主信息列表
     */
    List<OwnerDO> getOwnerList(Collection<Long> ids);

    /**
     * 获得业主信息分页
     *
     * @param pageReqVO 分页查询
     * @return 业主信息分页
     */
    PageResult<OwnerDO> getOwnerPage(OwnerPageReqVO pageReqVO);

    /**
     * 获得业主信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 业主信息列表
     */
    List<OwnerDO> getOwnerList(OwnerExportReqVO exportReqVO);

}
