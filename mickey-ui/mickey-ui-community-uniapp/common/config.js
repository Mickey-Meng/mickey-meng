module.exports = {
  //后端接口地址
  baseUrl: 'http://39.101.133.155:80/app-api',
  // 超时
  timeout: 30000,
  // 禁用 Cookie 等信息
  withCredentials: false,
  header: {
    //租户ID
    'tenant-id': 1
  }
}
