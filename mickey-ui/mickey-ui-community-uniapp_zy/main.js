import Vue from 'vue'
import App from './App'
import uView from 'uview-ui';
Vue.use(uView);
Vue.config.productionTip = false

App.mpType = 'app'
console.log(uni.$u.config.v);
const app = new Vue({
    ...App
})
//引入全局配置
import httpInterceptor from '@/common/http.interceptor.js'
//使用挂载
Vue.use(httpInterceptor,app)
app.$mount()
