import request from '@/config/axios'

export interface ReceivablesDetailedVO {
  receivablesDetailedId: string
  receivablesId: string
  receiptNumber: string
  collectionAccount: string
  itemCollectedAmount: number
  collectionUser: string
  cashierCode: string
  collectionDate: Date
  approvalState: string
  remarks: string
  creator?: number
  updater?: number
}

export interface ReceivablesDetailedPageReqVO extends PageParam {
  receivablesId?: string
  receiptNumber?: string
  collectionAccount?: string
  itemCollectedAmount?: number
  collectionUser?: string
  cashierCode?: string
  collectionDate?: Date[]
  approvalState?: string
  remarks?: string
  createTime?: Date[]
  creator?: number
  updater?: number
}

export interface ReceivablesDetailedExcelReqVO {
  receivablesId?: string
  receiptNumber?: string
  collectionAccount?: string
  itemCollectedAmount?: number
  collectionUser?: string
  cashierCode?: string
  collectionDate?: Date[]
  approvalState?: string
  remarks?: string
  createTime?: Date[]
  creator?: number
  updater?: number
}

// 查询应收明细列表
export const getReceivablesDetailedPageApi = async (params: ReceivablesDetailedPageReqVO) => {
  return await request.get({ url: '/finance/receivablesDetailed/page', params })
}

// 查询应收明细详情
export const getReceivablesDetailedApi = async (id: number) => {
  return await request.get({ url: '/finance/receivablesDetailed/get?id=' + id })
}

// 新增应收明细
export const createReceivablesDetailedApi = async (data: ReceivablesDetailedVO) => {
  return await request.post({ url: '/finance/receivablesDetailed/create', data })
}

// 修改应收明细
export const updateReceivablesDetailedApi = async (data: ReceivablesDetailedVO) => {
  return await request.put({ url: '/finance/receivablesDetailed/update', data })
}

// 删除应收明细
export const deleteReceivablesDetailedApi = async (id: number) => {
  return await request.delete({ url: '/finance/receivablesDetailed/delete?id=' + id })
}

// 导出应收明细 Excel
export const exportReceivablesDetailedApi = async (params: ReceivablesDetailedExcelReqVO) => {
  return await request.download({ url: '/finance/receivablesDetailed/export-excel', params })
}
