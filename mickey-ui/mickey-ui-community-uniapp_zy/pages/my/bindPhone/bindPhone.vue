<template>
	<view class="bindPhonePage">
		<view class="hasPhone" v-if="havePhone">
			<view class="hasPhoneTitle"><text>修改绑定手机</text></view>
			<view class="verifyOldPhone">
				<view class="detail"><text>说明:请首先填写改绑前手机号的中间四位数字</text></view>
				<view class="middlePhone">
					<u-field v-model="middlePhone" label="补全号" placeholder="请补全改绑前手机号的中间四位"
					:error-message="wrongPhone" @blur="verifyMiddlePhone" icon="bell" icon-color="#f29100"></u-field>
				</view>
			</view>
			<!-- 解绑新的手机号 -->
			<view class="editPhone">
				<u-field v-model="newMobile" label="手机号" placeholder="请填写新手机号" :error-message="errorMessage" icon="phone" icon-color="#f29100"
				 @blur="testNewPhone">
				</u-field>
				<u-field v-model="newCode" label="验证码" placeholder="请填写验证码" icon="server-fill" icon-color="#f29100">
					<u-button size="mini" slot="right" type="success" @click="getNewCode">{{codeText}}</u-button>
				</u-field>
				<u-verification-code ref="newCode" @change="codeChange" :uniqueKey="1"></u-verification-code>
				<view class="bindPhone">
					<u-button type="success" shape="circle" :disabled="editBindBtn" @click="editBindPhone">确认修改</u-button>
				</view>
				<view>
					<u-toast ref="bindNewTitle"></u-toast>
				</view>
			</view>
		</view>
		<view class="hasNone" v-else="havePhone" :current="bindCurrent">
			<view class="nonePhoneTitle"><text>绑定手机</text></view>
			<u-field v-model="mobile" label="手机号" placeholder="请填写手机号" :error-message="errorMessage" icon="phone" icon-color="#f29100"
			 @blur="testPhone">
			</u-field>
			<u-field v-model="code" label="验证码" placeholder="请填写验证码" icon="server-fill" icon-color="#f29100">
				<u-button size="mini" slot="right" type="success" @click="getCode">{{codeText}}</u-button>
			</u-field>
			<u-verification-code ref="uCode" @change="codeChange" :uniqueKey="2"></u-verification-code>
			<view class="bindPhone">
				<u-button type="success" shape="circle" :disabled="bindNewBtn" @click="bindNewPhone">绑定</u-button>
			</view>
			<view>
				<u-toast ref="bindNewTitle"></u-toast>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				//是否已经绑定过手机号
				havePhone: true,
				//绑定手机号
				mobile: '',
				//手机号验证错误信息
				errorMessage: '',
				//验证码
				code: '',
				//提醒文本
				codeText: '',
				//新手机号
				newMobile:'',
				//验证码
				newCode:'',
				//手机号中间四位
				middlePhone:'',
				wrongPhone:'',
				ownerInfo:{}
			}
		},
		onLoad() {
			this.ownerInfo = uni.getStorageSync('ownerInfo')
		},
		computed: {
			//按钮是否可用
			bindNewBtn() {
				return !(this.mobile.trim() != '' && this.code.trim() != '');
			},
			//确认修改按钮是否可用
			editBindBtn(){
				return !(this.newMobile.trim()!='' && this.newCode.trim()!='' && this.middlePhone.trim()!='');
			},
		},
		methods: {
			codeChange(text) {
				this.codeText = text;
			},

			getCode() {
				if (this.$u.test.mobile(this.mobile)) {
					if (this.$refs.uCode.canGetCode) {
						// 模拟向后端请求验证码
						uni.showLoading({
							title: '正在获取验证码'
						})
						
						setTimeout(() => {
							uni.hideLoading();
							// 通知验证码组件内部开始倒计时
							this.$refs.uCode.start();
						}, 1000);
					} else {
						this.$u.toast('倒计时结束后再发送');
					}
				}else{
					this.$u.toast('手机号格式不正确')
				}
			},
			getNewCode(){
				if (this.$u.test.mobile(this.newMobile)) {
					if (this.$refs.newCode.canGetCode) {
						// 模拟向后端请求验证码
						uni.showLoading({
							title: '正在获取验证码'
						})
						let that = this;
						this.$u.get('/auth/getEditPhoneCode/'+this.newMobile).then(res=>{
							uni.hideLoading();
							if(res.code==200){
								that.$u.toast('验证码已发送');
								// 通知验证码组件内部开始倒计时
								that.$refs.newCode.start();
							}else{
								that.$refs.bindNewTitle.show({
									type:"warning",
									title:res.msg
								});
							}
						})
						
					} else {
						this.$u.toast('倒计时结束后再发送');
					}
				}else{
					this.$u.toast('手机号格式不正确')
				}
			},

			testPhone() {
				if (this.mobile.trim() === '') {
					this.errorMessage = '手机号未填写'
					return;
				}
				if (!this.$u.test.mobile(this.mobile)) {
					this.errorMessage = '手机号格式错误'
					return;
				}
				this.errorMessage = ''

			},
			testNewPhone(){
				if (this.newMobile.trim() === '') {
					this.errorMessage = '手机号未填写'
					return;
				}
				if (!this.$u.test.mobile(this.newMobile)) {
					this.errorMessage = '手机号格式错误'
					return;
				}
				this.errorMessage = ''
			},
			//首次绑定手机号
			bindNewPhone() {
				let param = {};
				param.phoneNum = this.mobile.trim();
				param.verifyCode = this.code.trim();
				console.log('传递的绑定信息', param)
				this.$refs.bindNewTitle.show({
					title: '绑定手机号成功',
					type: 'success',
					url: 'pages/my/my',
					isTab: true
				});

			},
			//校验以前绑定的手机号
			verifyMiddlePhone(){
				if(this.middlePhone.trim()===''){
					this.wrongPhone='请先补全手机号信息'
					return false;
				}
				
				let middleNum = this.ownerInfo.phoneNum.substr(3,4);
				if(middleNum!=this.middlePhone){
					this.wrongPhone = '手机号验证有误';
					return false;
				}
				this.wrongPhone = '';
				return true;
			},
			//修改绑定
			editBindPhone(){
				if(!this.verifyMiddlePhone()){
					this.$refs.bindNewTitle.show({
						title: '原始手机号验证有误',
						type: 'error',
					});
					return;
				}
				
				let newPhone = this.newMobile.trim();
				let verifyCode = this.newCode.trim();
				let that = this;
				console.log('提交的修改信息',newPhone,verifyCode)
				this.$u.put('/auth/bindNewPhone/'+newPhone+"/"+verifyCode).then(res=>{
					console.log("修改手机号返回信息",res)
					if(res.code==200){
						let owner = uni.getStorageSync('ownerInfo');
						owner.phoneNum = newPhone;
						uni.setStorageSync('ownerInfo',owner);
						that.$refs.bindNewTitle.show({
							title: '修改手机号成功',
							type: 'success',
							url: 'pages/my/my',
							isTab: true
						});
						
					}else{
						that.$refs.bindNewTitle.show({
							title: res.msg,
							type: 'warning'
							
						});
					}
				})
				
			},
		}
	}
</script>

<style lang="scss">
	.bindPhonePage {
		padding: 30rpx;

		.hasPhone {
			.hasPhoneTitle {
				margin-top: 150rpx;
				margin-bottom: 50rpx;
				text-align: center;
				color: #303133;
				font-size: 35rpx;
				font-weight: bolder;
			}
			.verifyOldPhone{
				.detail{
					display: flex;
					flex-direction: row;
					justify-content: center;
					color: #18B566;
				}
				.middlePhone{
					margin-top: 25rpx;
				}
			}
			.bindPhone{
				margin-top: 100rpx;
			}
		}

		.hasNone {

			.nonePhoneTitle {
				margin-top: 150rpx;
				margin-bottom: 50rpx;
				text-align: center;
				color: #303133;
				font-size: 35rpx;
				font-weight: bolder;
			}

			.bindPhone {
				margin-top: 100rpx;
			}
		}
	}
</style>
