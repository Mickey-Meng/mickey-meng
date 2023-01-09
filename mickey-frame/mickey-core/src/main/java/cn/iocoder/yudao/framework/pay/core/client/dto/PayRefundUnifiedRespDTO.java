package cn.iocoder.yudao.framework.pay.core.client.dto;

import cn.iocoder.yudao.framework.pay.core.enums.PayChannelRefundRespEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
 * 统一退款 Response DTO
 *
 * @author jason
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class PayRefundUnifiedRespDTO {

    /**
     * 渠道退款单编号
     */
    private String channelRefundId;
}
