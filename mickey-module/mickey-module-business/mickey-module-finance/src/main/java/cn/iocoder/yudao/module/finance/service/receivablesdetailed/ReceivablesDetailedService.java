package cn.iocoder.yudao.module.finance.service.receivablesdetailed;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.finance.controller.admin.receivablesdetailed.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.receivablesdetailed.ReceivablesDetailedDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 键值参数 Service 接口
 *
 * @author 芋道源码
 */
public interface ReceivablesDetailedService {

    /**
     * 创建键值参数
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createReceivablesDetailed(@Valid ReceivablesDetailedCreateReqVO createReqVO);

    /**
     * 更新键值参数
     *
     * @param updateReqVO 更新信息
     */
    void updateReceivablesDetailed(@Valid ReceivablesDetailedUpdateReqVO updateReqVO);

    /**
     * 删除键值参数
     *
     * @param id 编号
     */
    void deleteReceivablesDetailed(String id);

    /**
     * 获得键值参数
     *
     * @param id 编号
     * @return 键值参数
     */
    ReceivablesDetailedDO getReceivablesDetailed(String id);

    /**
     * 获得键值参数列表
     *
     * @param ids 编号
     * @return 键值参数列表
     */
    List<ReceivablesDetailedDO> getReceivablesDetailedList(Collection<String> ids);

    /**
     * 获得键值参数分页
     *
     * @param pageReqVO 分页查询
     * @return 键值参数分页
     */
    PageResult<ReceivablesDetailedDO> getReceivablesDetailedPage(ReceivablesDetailedPageReqVO pageReqVO);

    /**
     * 获得键值参数列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 键值参数列表
     */
    List<ReceivablesDetailedDO> getReceivablesDetailedList(ReceivablesDetailedExportReqVO exportReqVO);

}
