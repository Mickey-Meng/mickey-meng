<template>
	<view class="fixPage">
		<view class="fixForm">
			<u-form :model="fixForm" ref="fixForm" label-position="top">
				<u-form-item label="报修房屋" prop="address">
					<u-input v-model="fixForm.address" @click="showHouse=true" :disabled="true" placeholder="点击选择"></u-input>
					<u-select v-model="showHouse" :list="bindHouseList" value-name="detailDesc" label-name="detailDesc" @confirm="chooseHouse"></u-select>
				</u-form-item>

				<u-form-item label="报修内容" prop="repairContent">
					<u-input type="textarea" autoHeight="true" height="120" v-model="fixForm.repairContent" placeholder="请输入报事报修的内容"></u-input>
				</u-form-item>

				<u-form-item label="联系人姓名" prop="connectName">
					<u-input v-model="fixForm.connectName" placeholder="请输入联系人姓名"></u-input>
				</u-form-item>

				<u-form-item label="联系人手机" prop="connectPhone">
					<u-input v-model="fixForm.connectPhone" type="number" placeholder="请输入联系人手机"></u-input>
				</u-form-item>

				<u-form-item label="预约时间" prop="doorTime">
					<u-input :disabled="true" v-model="fixForm.doorTime" placeholder="请选择上门时间" @click="showTime=true"></u-input>
					<u-picker mode="time" v-model="showTime" :params="params" :safeAreaInsetBottom="true" @confirm="chooseDoorTime"></u-picker>
				</u-form-item>

				<u-form-item label="图片说明">
					<u-upload :action="uploadAction" name="file" @on-success="upLoadSuccess" @on-remove="removeFile"></u-upload>
				</u-form-item>

				<u-form-item>
					<u-button @click="submitFix">提报</u-button>
				</u-form-item>
			</u-form>
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
				fixForm: {
					connectPhone: '',
					connectName: '',
					repairContent: '',
					communityId: '',
					address: '',
					doorTime: '',
					imagesUrl: [],
				},
				showHouse: false,
				showTime: false,
				params: {
					year: true,
					month: true,
					day: true,
					hour: true,
					minute: true,
				},
				uploadAction: '',
				bindHouseList: [],
				currentCommunity: {},
				rules: {
					address: [{
						required: true,
						message: '地址必选',
						trigger: ['change']
					}],
					connectName: [{
						required: true,
						message: '联系人必填',
						trigger: ['change', 'blur']
					}],
					connectPhone: [{
							required: true,
							message: '联系人手机必填',
							trigger: ['change', 'blur']
						},
						{
							validator: (rule, value, callback) => {
							 return this.$u.test.mobile(value)
							},
							message: '手机号码不正确',
							trigger: ['change', 'blur']
						}
					],
					repairContent: [{
						required: true,
						message: '维修内容必填',
						trigger: ['change', 'blur']
					}],
					doorTime: [{
						required: true,
						message: '预约时间必选',
						trigger: ['change', 'blur']
					}],
				},
			}
		},
		onReady() {
			this.$refs.fixForm.setRules(this.rules);
		},
		onLoad() {
			const community = uni.getStorageSync('current_community');
			if (community) {
				this.currentCommunity = community;
				this.fixForm.communityId = community.communityId;
			}
			const ownerInfo = uni.getStorageSync('ownerInfo');
			if (ownerInfo) {
				this.fixForm.connectPhone = ownerInfo.phoneNum;
				this.fixForm.connectName = ownerInfo.nickName;
			}
			this.uploadAction = this.$u.http.config.baseUrl + '/common/upload';
			this.getHouseBindInfo();
		},
		methods: {
			getHouseBindInfo() {
				if (this.currentCommunity.communityId) {
					this.$u.get('/repair/house/' + this.currentCommunity.communityId).then(res => {
						if (res.code == 200) {
							this.bindHouseList = res.data;
							console.log('获得数据', this.bindHouseList)
						} else {
							this.$refs.uMsg.show({
								type: 'warning',
								title: res.msg
							})
						}
					})
				} else {
					this.$refs.uMsg.show({
						type: 'warning',
						title: '请先选择社区',
						isTab: true,
						url: 'pages/index/index'
					})
				}
			},
			//选择绑定的房屋
			chooseHouse(e) {
				console.log('e', e[0])
				this.fixForm.address = e[0].label;
			},
			//选择上门时间
			chooseDoorTime(val) {
				//console.log('val', val)
				this.fixForm.doorTime = val.year + '-' + val.month + '-' + val.day + " " + val.hour + ":" + val.minute
			},

			/* 上传成功 */
			upLoadSuccess(data, index, list) {
				console.log('上传', list)
				this.fixForm.imagesUrl = list.map(item => {
					return item.response.data;
				});
			},
			removeFile(index, list, name) {
				this.fixForm.imagesUrl = list.map(item => {
					return item.response.data;
				});
			},

			//提报
			submitFix() {
				console.log('提报数据', this.fixForm)
				this.$refs.fixForm.validate(vaild=>{
					if(vaild){
						this.$u.post('/repair/post',this.fixForm).then(res=>{
							if(res.code==200){
								this.$refs.uMsg.show({
									type:'success',
									url:'pages/index/index',
									title:'上报成功',
									isTab:true
								});
							}else{
								this.$refs.uMsg.show({
									type:'warning',
									title:res.msg
								})
							}
						})
					}
				})
			},
		}
	}
</script>

<style lang="scss">
	.fixPage {
		padding: 30rpx;
	}
</style>
