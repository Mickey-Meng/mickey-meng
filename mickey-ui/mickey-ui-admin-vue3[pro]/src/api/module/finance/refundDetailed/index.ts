import request from '@/config/axios'

export interface RefundDetailedVO {
  refundDetailedId: string
  receivablesId: string
  refundNumber: string
  refundAccount: string
  itemRefundAmount: number
  refundUser: string
  cashierCode: string
  refundDate: Date
  approvalState: string
  remarks: string
  creator?: number
  updater?: number
}

export interface RefundDetailedPageReqVO extends PageParam {
  receivablesId?: string
  refundNumber?: string
  refundAccount?: string
  itemRefundAmount?: number
  refundUser?: string
  cashierCode?: string
  refundDate?: Date[]
  approvalState?: string
  remarks?: string
  createTime?: Date[]
  creator?: number
  updater?: number
}

export interface RefundDetailedExcelReqVO {
  receivablesId?: string
  refundNumber?: string
  refundAccount?: string
  itemRefundAmount?: number
  refundUser?: string
  cashierCode?: string
  refundDate?: Date[]
  approvalState?: string
  remarks?: string
  createTime?: Date[]
  creator?: number
  updater?: number
}

// 查询退款明细列表
export const getRefundDetailedPageApi = async (params: RefundDetailedPageReqVO) => {
  return await request.get({ url: '/finance/refundDetailed/page', params })
}

// 查询退款明细详情
export const getRefundDetailedApi = async (id: number) => {
  return await request.get({ url: '/finance/refundDetailed/get?id=' + id })
}

// 新增退款明细
export const createRefundDetailedApi = async (data: RefundDetailedVO) => {
  return await request.post({ url: '/finance/refundDetailed/create', data })
}

// 修改退款明细
export const updateRefundDetailedApi = async (data: RefundDetailedVO) => {
  return await request.put({ url: '/finance/refundDetailed/update', data })
}

// 删除退款明细
export const deleteRefundDetailedApi = async (id: number) => {
  return await request.delete({ url: '/finance/refundDetailed/delete?id=' + id })
}

// 导出退款明细 Excel
export const exportRefundDetailedApi = async (params: RefundDetailedExcelReqVO) => {
  return await request.download({ url: '/finance/refundDetailed/export-excel', params })
}
