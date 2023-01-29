import Vue from 'vue'
import Vuex from 'vuex'
import user from './mudules/user'
import cart from './mudules/cart'
import community from './mudules/community'
import getters from './getters'

Vue.use(Vuex) // vue的插件机制

/*
// 搜索目录 获取目录文件对象 类似于Java File modulesFiles = new File("/modules");
const modulesFiles = require.context('./modules', true, /\.js$/)
 
// 无需导入 使用此方法自动加载
const modules = modulesFiles.keys().reduce((modules, modulePath) => {
  // set './app.js' => 'app'
  const moduleName = modulePath.replace(/^\.\/(.*)\.\w+$/, '$1')
  console.log(moduleName);
  const value = modulesFiles(modulePath)
  modules[moduleName] = value.default
  return modules
}, {})*/

// Vuex.Store 构造器选项
const store = new Vuex.Store({
  modules: {
    user,
    cart,
    community,
  },
  getters
})
export default store
