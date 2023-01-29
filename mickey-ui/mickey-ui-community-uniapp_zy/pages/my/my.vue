<template>
	<view>
		<view class="u-flex user-box u-p-l-30 u-p-r-20 u-p-b-30" @click="toEditUserPage">
			<view class="u-m-r-10">
				<u-avatar :src="basicInfo.avatar" size="100"></u-avatar>
			</view>
			<view class="u-flex-1">
				<view class="u-font-18 u-p-b-20">{{basicInfo.nickName||'点击登录'}}</view>
				<view class="u-font-14 u-tips-color">手机号:
				{{basicInfo.phoneNum ? basicInfo.phoneNum.replace(basicInfo.phoneNum.substr(3,4),'****') :'暂未绑定'}}
				</view>
			</view>
			<view class="u-m-l-10 u-p-10">
				<u-icon name="edit-pen" color="#969799" size="28"></u-icon>
			</view>
			<view class="u-m-l-10 u-p-10">
				<u-icon name="arrow-right" color="#969799" size="28"></u-icon>
			</view>
		</view>

		<view class="u-m-t-20">
			<u-cell-group>
				<u-cell-item icon="phone" title="手机绑定" 
				:value="basicInfo.phoneNum ? basicInfo.phoneNum.replace(basicInfo.phoneNum.substr(3,4),'****') :'暂未绑定'"
				 :icon-style="{color:'#f29100'}"
				 @click="bindPhone"></u-cell-item>
				<u-cell-item icon="account" title="实名认证" :value="basicInfo.authenticated?'已实名':'未实名'" :icon-style="{color:'#18b566'}"
				 @click="authPage"></u-cell-item>
			</u-cell-group>
		</view>

		<view class="u-m-t-20">
			<u-cell-group>
				<u-cell-item icon="search" title="空余车位查询" :icon-style="{color:'#2b85e4'}" @click="checkParkingArea"></u-cell-item>
				<u-cell-item icon="car" title="车位申请查询" :icon-style="{color:'#dd6161'}" @click="checkAFParkingArea"></u-cell-item>
				<u-cell-item icon="clock" title="维修进度查询" :icon-style="{color:'#f29100'}"></u-cell-item>
				<u-cell-item icon="zhuanfa" title="我的发布查询" :icon-style="{color:'#18b566'}"></u-cell-item>
				<u-cell-item icon="heart" title="参与活动查询" :icon-style="{color:'#f29100'}"></u-cell-item>
				<u-cell-item icon="chat" title="我的代办" :icon-style="{color:'#18b566'}" :arrow="false" @click="viewWaitHandleInfo">
					<u-badge slot="right-icon" type="error" :absolute="false" :count="waitCount"></u-badge>
				</u-cell-item>
			</u-cell-group>
		</view>

		<view class="u-m-t-20">
			<u-cell-group>
				<u-cell-item icon="tags" title="问题反馈" :icon-style="{color:'#dd6161'}" @click="handleSuggestion"></u-cell-item>
				<u-cell-item icon="moments" title="关于我们" :icon-style="{color:'#f29100'}" @click="handleAbout"></u-cell-item>
			</u-cell-group>
		</view>

		<!-- 	<view class="u-m-t-20 logoutBtn">
			
		</view> -->
		<view class="logoutBtn">
			<u-button type="error" shape="circle" :custom-style="customStyle" :ripple="true">注销登录</u-button>
		</view>

		<view>
			<u-toast ref="uMsg"></u-toast>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				basicInfo: {},
				avatar: '',
				nickName: '',
				phoneNum: '',
				customStyle: {
					width: '80%',
				},
				waitCount: 0, //代办数量

			}
		},
		filters: {
			desPhoneNum(val) {
				console.log('手机号',val)
				return String(val).replace(String(val).substr(3, 4), "****")
			}
		},
		onShow() {
			console.log('触发onShow')
			this.basicInfo = uni.getStorageSync('ownerInfo')
			this.getWaitHandleCount();
			
			
			
		},
		methods: {
			//选择社区
			selectCommunity() {
				let that = this;
				this.$u.get('/community/all').then(res => {
					console.log(res)
					that.communities = res.data;
					that.showCommunity = true;
				})
			
			},
			//车位申请查询
			checkAFParkingArea() {
				let currentCommunity = uni.getStorageSync('current_community');
				console.log(currentCommunity)
				let that = this;
				if (!currentCommunity) {
					this.$refs.uMsg.show({
						title: '请先选择社区',
						type: 'warning',
						callback: function() {
							that.selectCommunity();
						}
					});
					return;
				}
				if(this.basicInfo){
					this.$u.route('pages/my/parkingArea/applyFor/cAFPS')
				}else{
					this.$refs.uMsg.show({
						title:'即将跳转到登录页面',
						type:'success',
						url:'pages/login/login'
					})
				}
			},
			//空余车位查询
			checkParkingArea() {
				let currentCommunity = uni.getStorageSync('current_community');
				console.log(currentCommunity)
				let that = this;
				if (!currentCommunity) {
					this.$refs.uMsg.show({
						title: '请先选择社区',
						type: 'warning',
						callback: function() {
							that.selectCommunity();
						}
					});
					return;
				}
				if(this.basicInfo){
					this.$u.route('pages/my/parkingArea/index/index')
				}else{
					this.$refs.uMsg.show({
						title:'即将跳转到登录页面',
						type:'success',
						url:'pages/login/login'
					})
				}
			},
			//跳转到用户修改页
			toEditUserPage() {
				if(this.basicInfo){
					this.$u.route('pages/my/basicInfo/basicInfo')
				}else{
					this.$refs.uMsg.show({
						title:'即将跳转到登录页面',
						type:'success',
						url:'pages/login/login'
					})
				}
				
			},
			//跳转到绑定手机号页面
			bindPhone() {
				if(this.basicInfo){
					this.$u.route('pages/my/bindPhone/bindPhone')
				}else{
					this.$refs.uMsg.show({
						title:'即将跳转到登录页面',
						type:'success',
						url:'pages/login/login'
					})
				}
			},
			//跳转到实名认证页
			authPage() {
				if(this.basicInfo){
					this.$u.route('pages/my/authentication/authentication')
				}else{
					this.$refs.uMsg.show({
						title:'即将跳转到登录页面',
						type:'success',
						url:'pages/login/login'
					})
				}
				
			},
			//跳转到关于页
			handleAbout() {
				this.$u.route('pages/my/about/about');
			},
			//跳转到建议页
			handleSuggestion() {
				if(this.basicInfo){
					this.$u.route('pages/my/suggestion/suggestion');
				}else{
					this.$refs.uMsg.show({
						title:'即将跳转到登录页面',
						type:'success',
						url:'pages/login/login'
					})
				}
				
			},
			//查询代办数量
			getWaitHandleCount() {
				const currentCommunity = uni.getStorageSync('current_community');
				if (currentCommunity) {
					this.$u.get('/handle/count/' + currentCommunity.communityId).then(res => {
						console.log('代办结果', res)
						if (res.code == 200) {
							this.waitCount = res.data;
						}
					})
				}
			},
			/* 跳转到代办信息页 */
			viewWaitHandleInfo() {
				if (this.waitCount == 0) {
					this.$refs.uMsg.show({
						type: 'success',
						title: '暂无代办信息'
					})
					return;
				}
				this.$u.route('pages/my/waitHandle/waitHandle');
			},
		}
	}
</script>

<style lang="scss">
	page {
		background-color: #ededed;
	}



	.user-box {
		background-color: #fff;
		height: 200rpx;

	}

	.logoutBtn {
		margin-top: 100rpx;
		margin-bottom: 15rpx;
	}
</style>
