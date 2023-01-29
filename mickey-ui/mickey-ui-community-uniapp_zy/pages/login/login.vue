<template>
	<view class="wrap">
		<view class="top"></view>
		<view class="content">
			<view class="title">欢迎进入织羽社区</view>
		</view>
		<view class="middle">
			<view class="loginType">
				<view class="weChatBtn">
					<u-button type="success" shape="circle" size="default" :ripple="true" open-type="getUserInfo" @getuserinfo="wechatLogin">
						微信登录
					</u-button>
				</view>

				<view class="line_middle"> </view>

				<view class="phoneBtn">
					<u-button type="info" shape="circle" size="default" :ripple="true" @click="mobilePhoneLogin">
						手机登录
					</u-button>
				</view>
				
				<view class="line_middle"> </view>

				<view class="phoneBtn">
					<u-button type="warning" shape="circle" size="default" :ripple="true" @click="visitorsLogin">
						游客登录
					</u-button>
				</view>
			</view>
			
		</view>
		<view>
			<u-toast ref="uMsg"></u-toast>
		</view>
		<view class="buttom">
			<view class="hint">
				登录代表同意
				<text class="link">织羽社区用户协议、隐私政策，</text>
				并授权使用您的织羽社区账号信息以便您统一管理
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		computed: {

		},
		methods: {
			//获取微信信息
			wechatLogin(weChatInfo) {
				if (weChatInfo.detail.errMsg === 'getUserInfo:ok') {
					let that = this;
					uni.login({
						timeout: 5000,
						success(res) {
							//获取openId,并校验用户是否存在,如果存在,返回用户信息，如果不存在,跳转到用户绑定页面
							that.$u.post('/weixin-mini-app-login', {
								code: res.code
							}).then(response => {
								if (response.code == 500) {
									//后端异常
									that.$u.toast(response.msg)
								} else if (response.code == 404) {
									//用户未注册
									console.log('微信信息', weChatInfo.detail.userInfo)
									let weChat = weChatInfo.detail.userInfo
									that.$u.route({
										url: 'pages/login/bindLoginInfo/bindLoginInfo',
										params: {
											nickname: weChat.nickName,
											gender: weChat.gender,
											avatar: weChat.avatarUrl,
											openId: response.msg,
										}
									});
								} else {
									//设置存储信息
									uni.setStorageSync('ownerInfo', response.data)
									uni.setStorageSync('miniToken', response.data.miniToken)
									that.$u.route({
										type: 'switchTab',
										url: 'pages/index/index'
									})
								}
							}).catch(err => {
								console.log('异常',err)
								that.$u.toast('出现了异常');
							})
						},
						fail(err) {
							that.$u.toast('网络异常,请稍后再试')
						}
					})
				} else {
					this.$u.toast('允许后方可进入小程序');
				}

			},
			//跳转到手机号配置页
			mobilePhoneLogin() {
				this.$u.route('pages/login/phoneLogin/phoneLogin')
			},
			//获取手机号信息
			getPhoneNumber(res) {
				console.log('手机', res)
			},
			
			visitorsLogin(){
				console.log('点击')
				this.$refs.uMsg.show({
					url:'pages/index/index',
					isTab:true,
					type:'warning',
					position:'top',
					title:'游客登录'
				});
				//this.$u.route('pages/index/index')
			},
		}
	};
</script>

<style lang="scss" scoped>
	.wrap {
		font-size: 28rpx;

		.top {
			margin-top: 150rpx;
		}

		.content {
			width: 600rpx;
			margin: 80rpx auto 0;

			.title {
				text-align: center;
				font-size: 50rpx;
				font-weight: 500;
				margin-bottom: 100rpx;
			}

			input {
				text-align: left;
				margin-bottom: 10rpx;
				padding-bottom: 6rpx;
			}
		}

		.middle {
			.loginType {
				display: flex;
				justify-content: center;
				align-items: center;
				flex-direction: column;

				.weChatBtn {
					margin-top: 150rpx;

				}

				.line_middle {
					margin-top: 20rpx;
					margin-bottom: 20rpx;
				}
				.phoneBtn {}
			}
		}

		.buttom {
			position: fixed;
			display: block;
			bottom: 10rpx;

			.hint {
				padding: 20rpx 40rpx;
				font-size: 20rpx;
				color: $u-tips-color;

				.link {
					color: $u-type-warning;
				}
			}
		}
	}
</style>
