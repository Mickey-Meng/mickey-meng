package cn.iocoder.yudao.module.finance.service.refunddetailed;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.finance.controller.admin.refunddetailed.vo.*;
import cn.iocoder.yudao.module.finance.dal.dataobject.refunddetailed.RefundDetailedDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 键值参数 Service 接口
 *
 * @author 芋道源码
 */
public interface RefundDetailedService {

    /**
     * 创建键值参数
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createRefundDetailed(@Valid RefundDetailedCreateReqVO createReqVO);

    /**
     * 更新键值参数
     *
     * @param updateReqVO 更新信息
     */
    void updateRefundDetailed(@Valid RefundDetailedUpdateReqVO updateReqVO);

    /**
     * 删除键值参数
     *
     * @param id 编号
     */
    void deleteRefundDetailed(String id);

    /**
     * 获得键值参数
     *
     * @param id 编号
     * @return 键值参数
     */
    RefundDetailedDO getRefundDetailed(String id);

    /**
     * 获得键值参数列表
     *
     * @param ids 编号
     * @return 键值参数列表
     */
    List<RefundDetailedDO> getRefundDetailedList(Collection<String> ids);

    /**
     * 获得键值参数分页
     *
     * @param pageReqVO 分页查询
     * @return 键值参数分页
     */
    PageResult<RefundDetailedDO> getRefundDetailedPage(RefundDetailedPageReqVO pageReqVO);

    /**
     * 获得键值参数列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 键值参数列表
     */
    List<RefundDetailedDO> getRefundDetailedList(RefundDetailedExportReqVO exportReqVO);

}
