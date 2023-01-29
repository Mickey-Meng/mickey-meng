<template>
	<view class="phoneLoginPage">
		<view class="phoneBody">
			<u-field v-model="phoneNum" label="手机号" placeholder="请输入手机号"></u-field>
			
			<u-field v-model="code" label="验证码" placeholder="请输入验证码">
				
				<u-button size="mini" slot="right" type="success" @click="getCode">{{codeText}}</u-button>
			</u-field>
			<u-verification-code ref="uCode" @change="codeChange"></u-verification-code>
		</view>
		<view class="loginBtn">
			<u-button type="success" shape="circle" :ripple="true" @click="phoneLogin" :disabled="loginState" size="medium">登录</u-button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				phoneNum:'',
				code:'',
				codeText:''
			}
		},
		computed:{
			loginState(){
				return !(this.phoneNum!='' && this.code!='');
			}
		},
		methods: {
			//获取验证码
			getCode(){
				if(!this.$u.test.mobile(this.phoneNum)){
					this.$u.toast('请正确填写手机号');
					return
				}
				if(this.$refs.uCode.canGetCode) {
					//调取后台接口
					this.$u.toast('发送验证码成功')
					this.$refs.uCode.start();
				}
			},
			codeChange(text) {
				this.codeText = text;
			},
			
			//手机登录
			phoneLogin(){
				let param = {};
				param.phoneNum = this.phoneNum;
				param.code = this.code;
				console.log('手机号登录信息:',param)
				this.$u.route({
					type:'switchTab',
					url:'pages/index/index'
				})
			}
		}
	}
</script>

<style lang="scss">
.phoneLoginPage{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-top: 150rpx;
	.phoneBody{
		
	}
	.loginBtn{
		margin-top: 50rpx;
	}
}
</style>
