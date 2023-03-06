import request from '@/config/axios'

export interface OwnerVO {
  id: number
  nickname: string
  realName: string
  age: number
  gender: string
  idCardNumber: string
  phoneNumber: string
  wechatId: string
  qqNumber: string
  email: string
  birthday: localdate
  portrait: string
  signature: string
  status: number
  logonMode: string
  ownerType: string
  password: string
  sort: number
  remark: string
}

export interface OwnerPageReqVO extends PageParam {
  nickname?: string
  realName?: string
  age?: number
  gender?: string
  idCardNumber?: string
  phoneNumber?: string
  wechatId?: string
  qqNumber?: string
  email?: string
  birthday?: localdate
  portrait?: string
  signature?: string
  status?: number
  logonMode?: string
  ownerType?: string
  password?: string
  sort?: number
  remark?: string
  createTime?: Date[]
}

export interface OwnerExcelReqVO {
  nickname?: string
  realName?: string
  age?: number
  gender?: string
  idCardNumber?: string
  phoneNumber?: string
  wechatId?: string
  qqNumber?: string
  email?: string
  birthday?: localdate
  portrait?: string
  signature?: string
  status?: number
  logonMode?: string
  ownerType?: string
  password?: string
  sort?: number
  remark?: string
  createTime?: Date[]
}

// 查询业主信息列表
export const getOwnerPageApi = async (params: OwnerPageReqVO) => {
  return await request.get({ url: '/community/owner/page', params })
}

// 查询业主信息详情
export const getOwnerApi = async (id: number) => {
  return await request.get({ url: '/community/owner/get?id=' + id })
}

// 新增业主信息
export const createOwnerApi = async (data: OwnerVO) => {
  return await request.post({ url: '/community/owner/create', data })
}

// 修改业主信息
export const updateOwnerApi = async (data: OwnerVO) => {
  return await request.put({ url: '/community/owner/update', data })
}

// 删除业主信息
export const deleteOwnerApi = async (id: number) => {
  return await request.delete({ url: '/community/owner/delete?id=' + id })
}

// 导出业主信息 Excel
export const exportOwnerApi = async (params: OwnerExcelReqVO) => {
  return await request.download({ url: '/community/owner/export-excel', params })
}
