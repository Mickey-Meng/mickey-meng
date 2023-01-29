import request from '@/config/axios'

export interface CommunityVO {
  id: number
  communityName: string
  communityCode: string
  provincesCode: string
  cityCode: string
  districtCode: string
  townCode: string
  detailedAddress: string
  longitude: string
  latitude: string
  propertyId: number
  sort: number
  remark: string
}

export interface CommunityPageReqVO extends PageParam {
  communityName?: string
  communityCode?: string
  provincesCode?: string
  cityCode?: string
  districtCode?: string
  townCode?: string
  detailedAddress?: string
  longitude?: string
  latitude?: string
  propertyId?: number
  sort?: number
  remark?: string
  createTime?: Date[]
}

export interface CommunityExcelReqVO {
  communityName?: string
  communityCode?: string
  provincesCode?: string
  cityCode?: string
  districtCode?: string
  townCode?: string
  detailedAddress?: string
  longitude?: string
  latitude?: string
  propertyId?: number
  sort?: number
  remark?: string
  createTime?: Date[]
}

// 查询小区信息列表
export const getCommunityPageApi = async (params: CommunityPageReqVO) => {
  return await request.get({ url: '/community/community/page', params })
}

// 查询小区信息详情
export const getCommunityApi = async (id: number) => {
  return await request.get({ url: '/community/community/get?id=' + id })
}

// 新增小区信息
export const createCommunityApi = async (data: CommunityVO) => {
  return await request.post({ url: '/community/community/create', data })
}

// 修改小区信息
export const updateCommunityApi = async (data: CommunityVO) => {
  return await request.put({ url: '/community/community/update', data })
}

// 删除小区信息
export const deleteCommunityApi = async (id: number) => {
  return await request.delete({ url: '/community/community/delete?id=' + id })
}

// 导出小区信息 Excel
export const exportCommunityApi = async (params: CommunityExcelReqVO) => {
  return await request.download({ url: '/community/community/export-excel', params })
}
