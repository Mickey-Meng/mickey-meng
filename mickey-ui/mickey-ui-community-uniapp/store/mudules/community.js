import { getCommunityDetail } from '@/api/community'

const community = {
  namespaced: true,
  state: {
    hasCommunity: false,
    communityId: -1,
    communityName: ''
    
  },
  mutations: {
    // 设置当前社区信息
    SET_COMMUNITY_INFO(state, data) {
      console.log(data);
      state.communityId = data.communityId;
      state.communityName = data.communityName;
      state.hasCommunity = data.communityId > 0;
    }
  },
  actions: {
    // 获取当前社区信息(暂时未启用)
    CommunityDetail({ state, commit }) {
      return getCommunityDetail()
        .then(res => {
          commit('SET_COMMUNITY_INFO', res.data)
          return Promise.resolve(res)
        })
        .catch(err => {
          return Promise.reject(err)
        })
    }
  }
}
export default community
