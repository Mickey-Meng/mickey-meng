<template>
	<view class="basicInfoPage">
		<u-form :model="basicInfo" ref="userForm" label-position="top" class="userForm">
			<u-form-item label="头像" prop="avator" left-icon="heart" :left-icon-style="{color:'#2b85e4'}">
				<u-avatar :src="basicInfo.avatar" @click="chooseAvatar"></u-avatar>
			</u-form-item>
			<u-form-item label="昵称" prop="nickName" left-icon="account" :left-icon-style="{color:'#2b85e4'}">
				<u-input v-model="basicInfo.nickName" placeholder="请输入昵称" />
			</u-form-item>
			<u-form-item label="性别" prop="gender" left-icon="woman" :left-icon-style="{color:'#2b85e4'}">
				<u-radio-group v-model="basicInfo.gender">
					<u-radio :name="1">男</u-radio>
					<u-radio :name="2">女</u-radio>
				</u-radio-group>
			</u-form-item>
			<u-form-item label="生日" prop="birthday" left-icon="bell" :left-icon-style="{color:'#2b85e4'}">
				<u-input type="select" v-model="basicInfo.birthday" @click="showBirthday= true" placeholder="请选择生日"></u-input>
				<u-picker mode="time" v-model="showBirthday" @confirm="selectBirthday"></u-picker>
			</u-form-item>
		</u-form>
		<view class="submitInfo">
			<u-button @click="submitInfo" type="success" shape="circle">保存</u-button>
		</view>
		<view>
			<u-toast ref="saveToast"></u-toast>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				//出生日期展示
				showBirthday: false,
				basicInfo: {
					avatar: '', //回显头像地址
					nickName: '', //昵称
					birthday: '', //生日
					gender: '', //性别
					openId: '', //openId
				},
				//校验规则
				rules: {
					nickName: [{
						required: true,
						message: '请输入昵称',
						trigger: 'blur'
					}],
					
					birthday: [{
						required: true,
						message: '请选择生日',
						trigger: 'change'
					}]
				},
			}
		},
		onLoad() {
			const ownerInfo = uni.getStorageSync('ownerInfo');
			this.basicInfo = ownerInfo;
		},
		methods: {
			//选择头像
			chooseAvatar() {
				let that = this;
				uni.chooseImage({
					count: 1,
					success(res) {
						console.log('获取的图片', res.tempFilePaths[0])
						let path = res.tempFilePaths[0]
						//上传头像,将头像地址进行赋值给   userImg
						let upLoadUrl = that.$u.http.config.baseUrl + '/common/upload';
						uni.uploadFile({
							url: upLoadUrl,
							filePath: path,
							name: 'file',
							timeout: 5000,
							success(res) {
								that.basicInfo.avatar = JSON.parse(res.data).data
							},
							fail(err) {
								console.log('上传失败', err)
								that.$u.toast('网络异常,头像上传失败')
							}
						})

					},
				})
			},
			//选中生日
			selectBirthday(event) {
				this.basicInfo.birthday = event.year + "-" + event.month + "-" + event.day
			},
			//保存信息
			submitInfo() {
				let that = this;
				this.$refs.userForm.validate(valid => {
					console.log('提交的数据',this.basicInfo)
					if (valid) {
						console.log('校验通过', this.basicInfo)
						//异步保存
						this.$u.post('/basic/edit', this.basicInfo).then(res => {
							if (res.code == 200) {
								uni.setStorageSync('ownerInfo', res.data)
								that.$refs.saveToast.show({
									title: '保存成功',
									isTab: true,
									url: 'pages/my/my'
								})
							} else {
								that.$refs.saveToast.show({
									type:'error',
									title: res.msg
								})
							}
						}).catch(err => {
							that.$u.toast('网络异常,请稍后重试');
						})

					}
				})
			}
		},
		onReady() {
			this.$refs.userForm.setRules(this.rules)
		},
	}
</script>

<style lang="scss">
	.basicInfoPage {
		padding: 30rpx;
		text-align: center;

		.userForm {}

		.submitInfo {
			margin-top: 35rpx;
		}
	}
</style>
