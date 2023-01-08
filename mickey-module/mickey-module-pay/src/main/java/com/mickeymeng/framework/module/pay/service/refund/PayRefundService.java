package com.mickeymeng.framework.module.pay.service.refund;

import com.mickeymeng.framework.common.pojo.PageResult;
import com.mickeymeng.framework.module.pay.core.client.dto.PayNotifyDataDTO;
import com.mickeymeng.framework.module.pay.controller.admin.refund.vo.PayRefundExportReqVO;
import com.mickeymeng.framework.module.pay.controller.admin.refund.vo.PayRefundPageReqVO;
import com.mickeymeng.framework.module.pay.dal.dataobject.refund.PayRefundDO;
import com.mickeymeng.framework.module.pay.service.order.dto.PayRefundReqDTO;
import com.mickeymeng.framework.module.pay.service.order.dto.PayRefundRespDTO;

import java.util.List;

/**
 * 退款订单 Service 接口
 *
 * @author aquan
 */
public interface PayRefundService {

    /**
     * 获得退款订单
     *
     * @param id 编号
     * @return 退款订单
     */
    PayRefundDO getRefund(Long id);

    /**
     * 获得退款订单分页
     *
     * @param pageReqVO 分页查询
     * @return 退款订单分页
     */
    PageResult<PayRefundDO> getRefundPage(PayRefundPageReqVO pageReqVO);

    /**
     * 获得退款订单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 退款订单列表
     */
    List<PayRefundDO> getRefundList(PayRefundExportReqVO exportReqVO);

    /**
     * 提交退款申请
     *
     * @param reqDTO 退款申请信息
     * @return 退款申请返回信息
     */
    PayRefundRespDTO submitRefundOrder(PayRefundReqDTO reqDTO);

    /**
     * 渠道的退款通知
     *
     * @param channelId  渠道编号
     * @param notifyData  通知数据
     * @throws Exception 退款通知异常
     */
    void notifyPayRefund(Long channelId, PayNotifyDataDTO notifyData) throws Exception;

}