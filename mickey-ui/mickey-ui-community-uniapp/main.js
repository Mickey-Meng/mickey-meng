import Vue from 'vue'
import App from './App'
import store from './store' // store
import plugins from './plugins' // plugins
import './permission' // permission
Vue.use(plugins)

Vue.config.productionTip = false
Vue.prototype.$store = store

App.mpType = 'app'

// 引入全局 uView 框架
import uView from 'uview-ui';
Vue.use(uView);
//uni.$u.config.unit = 'rpx'

// 全局存储 vuex 的封装
//import store from '@/store';

// 引入 uView 提供的对 vuex 的简写法文件
//let vuexStore = require('@/store/$u.mixin.js');
//Vue.mixin(vuexStore);

// 引入 uView 对小程序分享的 mixin 封装
//let mpShare = require('uview-ui/libs/mixin/mpShare.js');
//Vue.mixin(mpShare);

// Vue i18n 国际化
import VueI18n from '@/common/vue-i18n.min.js';
Vue.use(VueI18n);

// i18n 部分的配置，引入语言包，注意路径
import lang_zh_CN from '@/common/locales/zh_CN.js';
import lang_en from '@/common/locales/en.js';

const i18n = new VueI18n({
	// 默认语言
	locale: 'zh_CN',
	// 引入语言文件
	messages: {
		'zh_CN': lang_zh_CN,
		'en': lang_en,
	}
});

// 由于微信小程序的运行机制问题，需声明如下一行，H5和APP非必填
Vue.prototype._i18n = i18n;
const app = new Vue({
	i18n,
	store,
	...App
});

app.$mount()
