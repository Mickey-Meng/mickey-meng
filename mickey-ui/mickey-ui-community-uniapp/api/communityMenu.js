const { http } = uni.$u

//获得菜单列表
export const getCommunityMenuList = params => http.get('/community/menu/list', params)