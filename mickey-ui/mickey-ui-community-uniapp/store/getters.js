const getters = {
  accessToken: state => state.user.accessToken,
  userInfo: state => state.user.userInfo,
  hasLogin: state => !!state.user.accessToken,
  hasCommunity: state => !!state.community.communityId
}
export default getters
