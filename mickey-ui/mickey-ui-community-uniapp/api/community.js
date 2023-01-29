const { http } = uni.$u

//获得用户收件地址列表
export const getCommunityList = params => http.get('/community/community/list', params)
// 获取社区详细信息
export const getCommunityDetail = params => http.get('/community/community/get-detail', params)