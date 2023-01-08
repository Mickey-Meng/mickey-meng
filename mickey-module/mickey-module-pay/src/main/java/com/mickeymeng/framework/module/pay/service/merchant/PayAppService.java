package com.mickeymeng.framework.module.pay.service.merchant;

import com.mickeymeng.framework.common.core.util.collection.CollectionUtils;
import com.mickeymeng.framework.common.exception.ServiceException;
import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.module.pay.controller.admin.merchant.vo.app.PayAppCreateReqVO;
import com.mickeymeng.framework.module.pay.controller.admin.merchant.vo.app.PayAppPageReqVO;
import com.mickeymeng.framework.module.pay.controller.admin.merchant.vo.app.PayAppUpdateReqVO;
import com.mickeymeng.framework.module.pay.controller.admin.merchant.vo.app.PayAppExportReqVO;
import com.mickeymeng.framework.module.pay.dal.dataobject.merchant.PayAppDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 支付应用信息 Service 接口
 *
 * @author 芋艿
 */
public interface PayAppService {

    /**
     * 创建支付应用信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createApp(@Valid PayAppCreateReqVO createReqVO);

    /**
     * 更新支付应用信息
     *
     * @param updateReqVO 更新信息
     */
    void updateApp(@Valid PayAppUpdateReqVO updateReqVO);

    /**
     * 删除支付应用信息
     *
     * @param id 编号
     */
    void deleteApp(Long id);

    /**
     * 获得支付应用信息
     *
     * @param id 编号
     * @return 支付应用信息
     */
    PayAppDO getApp(Long id);

    /**
     * 获得支付应用信息列表
     *
     * @param ids 编号
     * @return 支付应用信息列表
     */
    List<PayAppDO> getAppList(Collection<Long> ids);

    /**
     * 获得支付应用信息分页
     *
     * @param pageReqVO 分页查询
     * @return 支付应用信息分页
     */
    PageResult<PayAppDO> getAppPage(PayAppPageReqVO pageReqVO);

    /**
     * 获得支付应用信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 支付应用信息列表
     */
    List<PayAppDO> getAppList(PayAppExportReqVO exportReqVO);

    /**
     * 修改应用信息状态
     *
     * @param id     应用编号
     * @param status 状态{@link com.mickeymeng.framework.common.enums.CommonStatusEnum}
     */
    void updateAppStatus(Long id, Integer status);

    /**
     * 根据商户 ID 获得支付应用信息列表,
     *
     * @param merchantId 商户 ID
     * @return 支付应用信息列表
     */
    List<PayAppDO> getListByMerchantId(Long merchantId);

    /**
     * 获得指定编号的商户 Map
     *
     * @param appIdList 应用编号集合
     * @return 商户 Map
     */
    default Map<Long, PayAppDO> getAppMap(Collection<Long> appIdList) {
        List<PayAppDO> list =  this.getAppList(appIdList);
        return CollectionUtils.convertMap(list, PayAppDO::getId);
    }


    /**
     * 支付应用的合法性
     *
     * 如果不合法，抛出 {@link ServiceException} 业务异常
     *
     * @param id 应用编号
     * @return 应用信息
     */
    PayAppDO validPayApp(Long id);

}