<template>
	<view class="lifePage">
		<view class="headerBody"></view>
		<u-card title="物业服务" sub-title="物业帮您解决" margin="-150rpx 0rpx 0rpx 0rpx">
			<view class="wyService" slot="body">
				<view class="wyServiceGroup">
					<u-button :custom-style="hourseBindStyle" @click="handleService('bindHourse')">房屋绑定</u-button>
					<u-button :custom-style="carApplyStyle" @click="handleService('carApply')">车位申请</u-button>
					<u-button :custom-style="wyPayStyle" @click="handleService('wyPay')">物业缴费</u-button>
					<u-button :custom-style="carPayStyle" @click="handleService('carPay')">车位缴费</u-button>
				</view>
			</view>
		</u-card>
		<!-- 间隔槽 -->
		<u-gap bg-color="#F3F4F6" height="15"></u-gap>
		<u-card title="生活服务" sub-title="方便您的生活,快乐社区" :showFoot="false" margin="0rpx 0rpx 0rpx 0rpx">
			<view class="wyService" slot="body">
				<view class="wyServiceGroup">
					<u-button :custom-style="idleStyle" @click="handleService('idlePost')">闲置发布</u-button>
					<u-button :custom-style="postStyle" @click="handleService('post')">物品邮寄</u-button>
					<u-button :custom-style="postQuery" @click="handleService('postQuery')">快递查询</u-button>
				</view>
			</view>
		</u-card>
		<!-- 间隔槽 -->
		<u-gap bg-color="#F3F4F6" height="15"></u-gap>
		<u-card title="中介服务" sub-title="稳定可靠值得信赖" :showFoot="false" margin="0rpx">
			<view class="wyService" slot="body">
				<view class="wyServiceGroup">
					<u-button :custom-style="hourseLeaseStyle" @click="handleService('leaseHourse')">房屋出租</u-button>
					<u-button :custom-style="hourseSellStyle" @click="handleService('sellHourse')">房屋售卖</u-button>
				</view>
			</view>
		</u-card>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				currentCommunity: {
					communityId: '0',
					communityName: ''
				},
				ownerInfo: {},
				/**各种按钮效果*/
				//房屋绑定效果
				hourseBindStyle: {
					backgroundColor: '#fcbd71'
				},
				//车位申请效果
				carApplyStyle: {
					marginLeft: '25rpx',
					backgroundColor: '#a0cfff'
				},
				//物业缴费效果
				wyPayStyle: {
					marginLeft: '25rpx',
					backgroundColor: '#fab6b6'
				},
				//车位缴费效果
				carPayStyle: {
					marginTop: '25rpx',
					backgroundColor: '#71d5a1'
				},
				//闲置发布
				idleStyle: {
					backgroundColor: '#fcbd71'
				},
				//物品邮寄
				postStyle: {
					marginLeft: '25rpx',
					backgroundColor: '#DCA51C'
				},
				//快递查询:
				postQuery: {
					marginLeft: '25rpx',
					backgroundColor: '#71d5a1'
				},
				//房屋出租
				hourseLeaseStyle: {
					backgroundColor: '#fab6b6'
				},
				//房屋售卖
				hourseSellStyle: {
					marginLeft: '25rpx',
					backgroundColor: '#a0cfff'
				},
			}
		},
		onShow() {
			const community = uni.getStorageSync('current_community');
			if (community) {
				this.currentCommunity = community;
			}
			const ownerInfo = uni.getStorageSync('ownerInfo');
			if (ownerInfo) {
				this.ownerInfo = ownerInfo;
			}
		},
		onLoad() {


		},
		methods: {
			//所有服务的入口
			handleService(serviceType) {
				if (this.currentCommunity.communityId == 0) {
					this.$u.toast('请先在首页选择社区');
					return;
				}
				if (!this.ownerInfo.authenticated) {
					this.$u.toast('请先实名认证,再进行操作')
					return;
				}
				switch (serviceType) {
					case 'bindHourse':
						console.log('房屋绑定');
						this.$u.route('pages/life/bindHourse/bindHourse');
						break;
					case 'carApply':
						this.$u.route('pages/life/applyFor/applyForArea');
						break;
					case 'wyPay':
						console.log('物业缴费');
						this.$u.route('pages/life/cost/cost');
						break;
					case 'carPay':
						console.log('车位缴费');
						break;
					case 'idlePost':
						console.log('闲置发布');
						break;
					case 'post':
						console.log('物品邮寄');
						break;
					case 'postQuery':
						console.log('快递查询')
						this.$u.route('pages/life/queryPost/queryPost')
						break;
					case 'leaseHourse':
						console.log('房屋出租');
						break;
					case 'sellHourse':
						console.log('房屋售卖');
						break;
				}
			},

		}
	}
</script>

<style lang="scss">
	.lifePage {
		width: 100%;

		.headerBody {
			height: 300rpx;
			background-image: linear-gradient(to right, #E17889, #8C4AB5);
		}

		.wyService {
			display: flex;
			flex-direction: column;
			align-items: center;
			width: 100%;

			.wyServiceGroup {
				display: flex;
				flex-direction: row;
				flex-wrap: wrap;
				justify-content: flex-start;
				width: 100%;
				padding: 15rpx 15rpx;
			}
		}
	}
</style>
