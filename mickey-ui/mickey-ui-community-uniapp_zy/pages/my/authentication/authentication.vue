<template>
	<view class="authenticationPage">
		<u-card title="实名认证" sub-title="授权实名认证">
			<view slot="body" class="authenticationBody">
				<view class="name">
					<u-field v-model="name" label="姓名" placeholder="请输入姓名" :disabled="authenticated"></u-field>
				</view>
				<view class="cardNum">
					<u-field v-model="cardNum" :disabled="true" label="身份证号" placeholder="请输入身份证号" right-icon="arrow-down-fill" @click="showKeyboard"></u-field>
					
					<u-keyboard mode="card" v-model="showCardKey" @change="valChange" @backspace="backspace"></u-keyboard>
				</view>
			</view>
			<view slot="foot">
				<u-button type="success" shape="circle" @click="handleAuth" :disabled="authBtn">认证</u-button>
			</view>
		</u-card>
		<view>
			<u-toast ref="uToast" />
		</view>
		<view>
			<u-modal v-model="showModel" content="实名一旦确定,不可更改" @confirm="sureConfirm" :show-cancel-button="true"></u-modal>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				name: '', //用户真实姓名
				cardNum: '', //身份证号
				showCardKey: false,
				authenticated: false, //是否已经实名认证
				showModel:false,
			}
		},
		onLoad() {
			const ownerInfo = uni.getStorageSync('ownerInfo');
			this.authenticated = ownerInfo.authenticated;
			if(this.authenticated){
				//获取用户的实名信息
				this.getOwnerAuthInfo();
			}
		},
		computed: {
			authBtn() {
				//1.如果已经认证过直接返回 true
				if (this.authenticated) {
					return true;
				} else {
					//2.如果已经填写则返回 false
					return !(this.name != '' && this.cardNum != '')
				}

			},
		},
		methods: {
			// 按键被点击(点击退格键不会触发此事件)
			valChange(val) {
				// 将每次按键的值拼接到cardNum变量中
				this.cardNum += val;
			},
			// 退格键被点击
			backspace() {
				// 删除cardNum的最后一个字符
				if (this.cardNum.length) {
					this.cardNum = this.cardNum.substr(0, this.cardNum.length - 1);
				}
			},
			showKeyboard() {
				if(!this.authenticated){
					this.showCardKey = true;
				}
				
			},
			//获取实名信息
			getOwnerAuthInfo(){
				let that = this;
				this.$u.get('/auth/owner').then(res=>{
					console.log('实名信息',res)
					if(res.data.realName!=null && res.data.realName.trim()!=''){
						that.name = res.data.realName
					}
					if(res.data.idCardNum!=null && res.data.idCardNum.trim()!=''){
						that.cardNum = res.data.idCardNum
					}
					
				})
			},
			//实名认证
			sureConfirm(){
				let that = this;
				if (this.name.trim() === '') {
					this.$refs.uToast.show({
						type: 'warning',
						title: '姓名必填'
					});
					return;
				}
				if (!this.$u.test.idCard(this.cardNum)) {
					this.$refs.uToast.show({
						type: 'warning',
						title: '身份证号有误'
					});
					return;
				}
				let param = {};
				param.realName = this.name;
				param.idCardNum = this.cardNum;
				console.log('提交的数据', param)
				//保存成功后进行跳转页面
				this.$u.post('/auth/authenticated',param).then(res=>{
					if(res.code==200){
						//成功
						let ownerInfo = uni.getStorageSync('ownerInfo')
						ownerInfo.authenticated = true;
						uni.setStorageSync('ownerInfo',ownerInfo)
						that.$refs.uToast.show({
							type: 'success',
							title: '认证成功',
							isTab:true,
							url:'pages/my/my'
						});
					}else{
						that.$refs.uToast.show({
							type: 'error',
							title: res.msg
						});
					}
				})
			},
			handleAuth() {
				this.showModel = true;
			},

		}
	}
</script>

<style lang="scss">
	.authenticationPage {
		padding: 30rpx;

		.authenticationBody {}
	}
</style>
