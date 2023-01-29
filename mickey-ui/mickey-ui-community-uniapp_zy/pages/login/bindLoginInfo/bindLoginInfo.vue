<template>
	<view class="bindPhonePage">
		<u-form ref="uForm" :model="formModel">
			<view class="imageView">
				<u-avatar :src="formModel.avatar" @click="changeAvatar"></u-avatar>
			</view>
			<u-form-item label="昵称" prop="nickName">
				<u-input v-model="formModel.nickName" placeholder="请输入昵称" />
			</u-form-item>
			<u-form-item label="性别" prop="gender">
				<u-radio-group v-model="formModel.gender">
					<u-radio name="1">男</u-radio>
					<u-radio name="2">女</u-radio>
				</u-radio-group>
			</u-form-item>
			<u-form-item label="手机号" label-width="100" prop="phoneNum">
				<u-input type="number" placeholder="请输入手机号" v-model="formModel.phoneNum"></u-input>
			</u-form-item>
			<u-form-item label="验证码" label-width="100" prop="code">
				<u-input placeholder="请输入验证码" v-model="formModel.code" type="text"></u-input>
				<u-button slot="right" type="success" size="mini" @click="getCode">{{codeTips}}</u-button>
				<u-verification-code seconds="60" ref="uCode" @change="codeChange"></u-verification-code>
			</u-form-item>

			<u-form-item label="生日" right-icon="arrow-down-fill" prop="birthday">
				<u-input v-model="formModel.birthday" :disabled="true" placeholder="请选择日期" @click="showDate=true" />
				<u-picker mode="time" v-model="showDate" @confirm="selectedBirthday"></u-picker>
			</u-form-item>


			<u-form-item>
				<u-button type="success" @click="registerUser" :disabled="btnDisable" shape="circle">注册</u-button>
			</u-form-item>
		</u-form>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				formModel: {
					avatar: '', //头像
					gender: '', //性别 0 未知,1男，2 女
					nickName: '', //昵称
					birthday: '', //生日
					phoneNum: '', //手机号
					openId: '', //openId
					code: '', //验证码

				},
				showDate: false,
				codeTips: '',
				rules: {
					phoneNum: [{
						validator: (rule, value, callback) => {
							return this.$u.test.mobile(value);
						},
						message: '手机号码不正确',
						// 触发器可以同时用blur和change
						trigger: ['change', 'blur'],
					}],
					nickName: [{
						required: true,
						message: '昵称未填写',
						trigger: 'blur'
					}],
					code: [{
						required: true,
						message: '验证码未填写',
						trigger: 'blur'
					}],
					birthday: [{
						required: true,
						message: '生日未选择',
						trigger: 'blur'
					}],
				},
			}
		},
		onLoad(res) {
			this.formModel.avatar = res.avatar;
			this.formModel.gender = res.gender;
			this.formModel.nickName = res.nickname;
			this.formModel.openId = res.openId;
		},
		onReady() {
			this.$refs.uForm.setRules(this.rules);
		},
		computed: {
			btnDisable() {
				return !(this.$u.test.mobile(this.formModel.phoneNum) && this.formModel.avatar != '' &&
					this.formModel.nickName != '' && this.formModel.birthday != '' && this.formModel.code != '');
			},
		},
		methods: {
			//生日选择
			selectedBirthday(event) {
				this.formModel.birthday = event.year + "-" + event.month + "-" + event.day;
			},
			codeChange(text) {
				this.codeTips = text;
			},
			// 获取验证码
			getCode() {
				if (this.$refs.uCode.canGetCode) {
					if(!this.$u.test.mobile(this.formModel.phoneNum)){
						this.$u.toast('手机号格式不正确');
						return;
					}
					// 模拟向后端请求验证码
					uni.showLoading({
						title: '正在获取验证码',
						mask: true
					})
					this.$u.get('/sendCode/' + this.formModel.phoneNum).then(res => {
						uni.hideLoading();
						console.log('手机验证码',res)
						if(res.code==200){
							this.$u.toast('验证码已发送');
							this.$refs.uCode.start();
						}else{
							this.$u.toast(res.msg);
						}
					}).catch(err => {
						uni.hideLoading();
						this.$u.toast('网络异常,请稍后重试');
					});
				} else {
					this.$u.toast('倒计时结束后再发送');
				}
			},
			//注册用户
			registerUser() {
				this.$refs.uForm.validate(valid => {
					if (valid) {
						let param = {};
						param = this.formModel;
						console.log('提交的数据', param);
						let that = this;
						this.$u.post('/register', param).then(res => {
							if (res.code != 200) {
								that.$u.toast(res.msg);
							} else {
								//设置存储信息
								uni.setStorageSync('ownerInfo', res.data)
								uni.setStorageSync('miniToken', res.data.miniToken)
								that.$u.route({
									type: 'switchTab',
									url: 'pages/index/index'
								})
							}
						}).catch(err => {
							that.$u.toast('网络异常，请稍后再试');
						})
					}
				})

			},
			
			//切换头像
			changeAvatar(){
				let that = this;
				uni.chooseImage({
					count:1,
					success(res){
						let path = res.tempFilePaths[0];
						let file = res.tempFiles[0]
						let upLoadUrl = that.$u.http.config.baseUrl+'/common/upload';
						uni.uploadFile({
							url:upLoadUrl,
							filePath:path,
							name:'file',
							timeout:5000,
							success(res) {
								that.formModel.avatar = JSON.parse(res.data).data
							},
							fail(err) {
								console.log('上传失败',err)
								that.$u.toast('网络异常,头像上传失败')
							}
						})
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	.bindPhonePage {
		padding: 30rpx;

		.imageView {
			display: flex;
			flex-direction: row;
			justify-content: center;
		}
	}
</style>
