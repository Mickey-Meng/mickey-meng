import request from '@/config/axios'

export interface ReceivablesVO {
  receivablesId: string
  customerCode: string
  customerName: string
  telephoneNo: string
  address: string
  salesChannel: string
  shoppingGuide: string
  salesAmount: number
  preferentialAmount: number
  refundGoodsAmount: number
  refundAmount: number
  collectedAmount: number
  receivableBalance: number
  receivableAmount: number
  isSettle: string
  remarks: string
  approvalState: string
  goodsType: string
  creator?: number
  updater?: number
}

export interface ReceivablesPageReqVO extends PageParam {
  customerCode?: string
  customerName?: string
  telephoneNo?: string
  address?: string
  salesChannel?: string
  shoppingGuide?: string
  salesAmount?: number
  preferentialAmount?: number
  refundGoodsAmount?: number
  refundAmount?: number
  collectedAmount?: number
  receivableBalance?: number
  receivableAmount?: number
  isSettle?: string
  remarks?: string
  approvalState?: string
  createTime?: Date[]
  goodsType?: string
  creator?: number
  updater?: number
}

export interface ReceivablesExcelReqVO {
  customerCode?: string
  customerName?: string
  telephoneNo?: string
  address?: string
  salesChannel?: string
  shoppingGuide?: string
  salesAmount?: number
  preferentialAmount?: number
  refundGoodsAmount?: number
  refundAmount?: number
  collectedAmount?: number
  receivableBalance?: number
  receivableAmount?: number
  isSettle?: string
  remarks?: string
  approvalState?: string
  createTime?: Date[]
  goodsType?: string
  creator?: number
  updater?: number
}

// 查询应收款列表
export const getReceivablesPageApi = async (params: ReceivablesPageReqVO) => {
  return await request.get({ url: '/finance/receivables/page', params })
}

// 查询应收款详情
export const getReceivablesApi = async (id: number) => {
  return await request.get({ url: '/finance/receivables/get?id=' + id })
}

// 新增应收款
export const createReceivablesApi = async (data: ReceivablesVO) => {
  return await request.post({ url: '/finance/receivables/create', data })
}

// 修改应收款
export const updateReceivablesApi = async (data: ReceivablesVO) => {
  return await request.put({ url: '/finance/receivables/update', data })
}

// 删除应收款
export const deleteReceivablesApi = async (id: number) => {
  return await request.delete({ url: '/finance/receivables/delete?id=' + id })
}

// 导出应收款 Excel
export const exportReceivablesApi = async (params: ReceivablesExcelReqVO) => {
  return await request.download({ url: '/finance/receivables/export-excel', params })
}
