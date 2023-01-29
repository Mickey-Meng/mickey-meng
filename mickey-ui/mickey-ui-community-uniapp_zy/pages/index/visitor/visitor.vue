<template>
	<view class="vistorPage">
		<u-card title="访客邀约" sub-title="有朋自远方来,不亦乐乎">
			<view slot="body">
				<u-field label="访客姓名" placeholder="请输入访客姓名" v-model="visitorName"></u-field>
				<u-field label="访客手机" placeholder="请输入访客手机号" v-model="visitorPhone"></u-field>
				<u-field label="到访日期" placeholder="请选择到访日期" :disabled="true" v-model="visitorDate" @click="showDataPicker"
				 right-icon="arrow-down-fill"></u-field>
				<u-picker v-model="showDate" mode="time" @confirm="selectDate"></u-picker>
			</view>

			<view slot="foot">
				<u-button type="success" shape="circle" @click="signVisitor" :disabled="signDisabled">登记</u-button>
			</view>
		</u-card>
		<view>
			<u-toast ref="uMsg"></u-toast>
		</view>

		<!-- 访客列表 -->
		<view class="visitorList">
			<u-section title="访客列表" sub-title="查看更多" class="visitorList" :bold="false" @click="moreVisitors"></u-section>
			<u-cell-group>
				<u-cell-item v-for="(visitorItem,index) in visitorList" :key="index" :title="visitorItem.visitorName+'/'+visitorItem.visitorPhone"
				 value="生成邀请码" :label="visitorItem.visitorDate" :arrow="false" :index="visitorItem.visitorId" @click="generatorCode">
				</u-cell-item>
			</u-cell-group>
		</view>



		<!-- 弹出二维码 -->
		<!-- <view>
			<u-modal v-model="showModal" title="邀请码" 
			:title-style="{padding:'30rpx'}" :content-style="{'text-align':'center'}"
			 @confirm="handleBarCode">
				<tki-qrcode cid="qrCode" :val="qrVal" ref="qrCode" :onval="true" @result="qrResult"></tki-qrcode>
			
			</u-modal>
		</view> -->
		<view>
			<u-modal v-model="showModal" title="邀请码" :title-style="{padding:'30rpx'}" :content-style="{'text-align':'center'}"
			 :show-confirm-button="false">
				<tki-qrcode cid="qrCode" :val="qrVal" ref="qrCode" :onval="true" @result="qrResult"></tki-qrcode>
				<view class="u-flex u-flex-nowrap u-row-around custom">
					<u-button :plain="true" size="mini" @click="handleBarCode" shape="circle">确定</u-button>
					<u-button :plain="true" size="mini" shape="circle" @click="saveBarCode">保存</u-button>
				</view>
			</u-modal>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				communityId: '', //小区Id
				visitorName: '', //访客姓名
				visitorPhone: '',
				visitorDate: '',
				showDate: false,
				visitorList: [],
				showModal: false,
				qrVal: '', //二维码内容
				barcodeUrl: '', //二维码地址
			}
		},

		computed: {
			signDisabled() {
				return !(this.visitorName != '' && this.visitorPhone != '' && this.visitorDate != '')
			}
		},
		onLoad() {
			const current_community = uni.getStorageSync('current_community');
			this.communityId = current_community.communityId;
			this.initVisitorList();
		},
		methods: {
			showDataPicker() {
				this.showDate = true;
			},
			selectDate(event) {
				this.visitorDate = event.year + '-' + event.month + '-' + event.day;
			},
			//新增访客
			signVisitor() {
				if (!this.$u.test.mobile(this.visitorPhone)) {
					this.$refs.uMsg.show({
						title: '手机号格式不正确',
						type: 'warning'
					});
					return
				}
				let param = {};
				const currentCommunity = uni.getStorageSync('current_community');
				param.visitorName = this.visitorName;
				param.visitorPhone = this.visitorPhone;
				param.visitorDate = this.visitorDate;
				param.communityId = this.communityId;
				this.$u.post('/visitor/save', param).then(res => {
					if (res.code == 200) {
						this.$refs.uMsg.show({
							title: '新增访客成功',
							type: 'success'
						});
						param.visitorId = res.data;
						this.visitorList.unshift(param)
						if (this.visitorList.length > 3) {
							this.visitorList.pop()
						}
						this.visitorName = ''
						this.visitorPhone = ''
						this.visitorDate = ''
					} else {
						this.$u.toast(res.msg)
					}
				})

			},
			//初始化数据
			initVisitorList() {
				this.$u.get('/visitor/top3/' + this.communityId).then(res => {
					if (res.code == 200) {
						this.visitorList = res.data
					} else {
						this.$u.toast(res.msg)
					}
				})

			},
			/* 生成二维码 */
			generatorCode(visitorId) {
				this.qrVal = visitorId;
				this.showModal = true;
				this.$refs.qrCode._makeCode()
			},
			handleBarCode() {
				console.log('清空二维码')
				this.$refs.qrCode._clearCode()
				this.showModal = false
			},
			qrResult(res) {
				console.log('二维码信息', res)
				this.barcodeUrl = res
			},
			/* 保存二维码 */
			saveBarCode() {
				this.$refs.qrCode._saveCode();
				this.$u.toast('已保存到图库')
				this.showModal = false
			},
			/* 查看更多访客 */
			moreVisitors(){
				this.$u.route('pages/index/visitor/moreVisitors/moreVisitors')
			},
		}
	}
</script>

<style lang="scss">
	.visitorList {
		margin-left: 30rpx;
		margin-right: 20rpx;
	}

	.custom {
		margin-top: 30rpx;
		margin-bottom: 20rpx;
	}
</style>
