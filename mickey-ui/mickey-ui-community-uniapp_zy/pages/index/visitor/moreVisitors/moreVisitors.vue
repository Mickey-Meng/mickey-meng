<template>
	<view class="moreVisitors">
		<scroll-view :scroll-y="true" :enable-back-to-top="true" @scrolltolower="moreVisitors" class="scorllView">
			<u-card :show-head="false" v-for="visitor in visitorList" :key="visitor.visitorId">
				<view slot="body">
					<u-field label="访客姓名" :value="visitor.visitorName" :disabled="true"></u-field>
					<u-field label="访客手机" :value="visitor.visitorPhone" :disabled="true"></u-field>
					<u-field label="到访日期" :value="visitor.visitorDate" :disabled="true"></u-field>
				</view>
				<view slot="foot">
					<u-button shape="circle" @click="generatorCode(visitor.visitorId)">获取访客码</u-button>
				</view>
			</u-card>
		</scroll-view>
		
		<!-- 弹出二维码 -->
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
				communityId: '', //社区Id
				current: 1, //页码
				size: 5, //每页数量
				hasNextPage: false, //是否有下一页
				visitorList: [],
				showModal:false,//是否展示二维码
				qrVal:'',//二维码的值
			}
		},
		onLoad() {
			const currentCommunity = uni.getStorageSync('current_community');
			this.communityId = currentCommunity.communityId;
			this.initVisitors();
		},
		methods: {
			initVisitors() {
				let param = {};
				param.communityId = this.communityId;
				param.size = this.size;
				param.current = this.current;
				this.$u.get('/visitor/page', param).then(res => {
					this.current = res.data.nextPage
					this.visitorList = res.data.list
					this.hasNextPage = res.data.hasNextPage
				})
			},
			/* 获取更多的列表 */
			moreVisitors() {
				if (this.hasNextPage) {
					let param = {};
					param.communityId = this.communityId;
					param.size = this.size;
					param.current = this.current;
					this.$u.get('/visitor/page', param).then(res => {
						this.current = res.data.nextPage
						this.hasNextPage = res.data.hasNextPage
						if (res.data.list.length > 0) {
							res.data.list.forEach(item => {
								this.visitorList.push(item)
							})
						}
					})
				}
			},
			/* 生成二维码 */
			generatorCode(visitorId){
				this.showModal = true;
				this.qrVal = visitorId;
				this.$refs.qrCode._makeCode()
			},
			
			qrResult(res) {
				console.log('二维码信息', res)
			},
			//清空二维码
			handleBarCode() {
				console.log('清空二维码')
				this.$refs.qrCode._clearCode()
				this.showModal = false
			},
			saveBarCode(){
				this.$refs.qrCode._saveCode();
				this.$u.toast('已保存到图库')
				this.showModal = false
			}
		}
	}
</script>

<style lang="scss">
	.moreVisitors {
		height: 100%;

		.scorllView {
			position: absolute;
			height: 100%;
			width: 100%;
		}
		.custom {
			margin-top: 30rpx;
			margin-bottom: 20rpx;
		}
	}
</style>
