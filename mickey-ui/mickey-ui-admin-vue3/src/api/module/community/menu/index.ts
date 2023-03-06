import request from '@/config/axios'

export interface CommunityMenuVO {
  id: number
  menuZhName: string
  menuEnName: string
  menuIcon: string
  iconStyle: string
  status?: number
  routePath: string
  sort: number
}

export interface CommunityMenuPageReqVO extends PageParam {
  menuZhName?: string
  menuEnName?: string
  menuIcon?: string
  iconStyle?: string
  routePath?: string
  sort?: number
  createTime?: Date[]
}

export interface CommunityMenuxcelReqVO {
  menuZhName?: string
  menuEnName?: string
  menuIcon?: string
  iconStyle?: string
  routePath?: string
  sort?: number
  createTime?: Date[]
}

// 查询服务列表菜单列表
export const getCommunityMenuPageApi = async (params: CommunityMenuPageReqVO) => {
  return await request.get({ url: '/community/menu/page', params })
}

// 查询服务列表菜单详情
export const getCommunityMenuApi = async (id: number) => {
  return await request.get({ url: '/community/menu/get?id=' + id })
}

// 新增服务列表菜单
export const createCommunityMenuApi = async (data: CommunityMenuVO) => {
  return await request.post({ url: '/community/menu/create', data })
}

// 修改服务列表菜单
export const updateCommunityMenuApi = async (data: CommunityMenuVO) => {
  return await request.put({ url: '/community/menu/update', data })
}

// 删除服务列表菜单
export const deleteCommunityMenuApi = async (id: number) => {
  return await request.delete({ url: '/community/menu/delete?id=' + id })
}

// 导出服务列表菜单 Excel
export const exportCommunityMenuApi = async (params: CommunityMenuxcelReqVO) => {
  return await request.download({ url: '/community/menu/export-excel', params })
}

// 修改菜单状态
export const updateCommunityMenuStatusApi = (id: number, status: number) => {
  const data = {
    id,
    status
  }
  return request.put({ url: '/community/menu/update-status', data: data })
}
