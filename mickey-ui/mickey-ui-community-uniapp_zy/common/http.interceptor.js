const install = (Vue, vm) => {
	// 此为自定义配置参数

	Vue.prototype.$u.http.setConfig({
		baseUrl: 'http://127.0.0.1:6969/app-api/community/mini/auth',
		wsUrl:'wss://127.0.0.1:8888/mini/community',
		dataType: 'json',
		showLoading: false, // 是否显示请求中的loading
		loadingText: '努力加载中~',
		loadingTime: 800,
		originalData: false, // 是否在拦截器中返回服务端的原始数据
		loadingMask: true, // 展示loading的时候，是否给一个透明的蒙层，防止触摸穿透
		// 设置自定义头部content-type
		 header: {
		 	'content-type': 'application/json;charset=UTF-8'
		 }
		// ......
	});
	//设置请求拦截
	Vue.prototype.$u.http.interceptor.request = (config) => {
		console.log(config);
		if (!(config.url === '/weixin-mini-app-login' || config.url === '/register' ||
				config.url.startsWith('/sendCode/') || config.url == '/common/upload')) {
			//如果不是登录等需要token的那么不需要进行组装header
			const token = uni.getStorageSync('miniToken');
			if (token) {
				config.header.miniToken = token
			} else {
				//跳转到登录页进行登录
				uni.showToast({
					title: '检测到您未登录,2s后跳到登录页',
					icon: 'none',
					duration: 3000,
					success() {
						setTimeout(() => {
							uni.redirectTo({
								url: '/pages/login/login'
							})
						}, 2000)
					}
				})
				return false;
			}

		}

		return config;
	}
}

export default {
	install
}
