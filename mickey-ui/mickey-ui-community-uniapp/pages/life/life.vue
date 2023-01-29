<template>
	<view class="lifeContainer">
		<view class="headerBody"></view>
		<mickey-card v-for="(card, cardIndex) in cardDataList" :title="card.cardTitle" :sub-title="card.subTitle" :style="card.style" :key="cardIndex">
			<view class="serviceCard" slot="body">
				<view class="serviceButtonGroup">
					<u-button v-for="(button, buttonIndex) in card.subButtonList" v-bind:key="buttonIndex" :custom-style="button.customStyle" @click="serviceHandle(button.serviceType)">{{button.buttonText}}</u-button>
				</view>
			</view>
			<!-- 间隔槽 -->
			<u-gap bg-color="#F3F4F6" height="15"></u-gap>
		</mickey-card>
		<!-- 提示框 -->
		<u-toast ref="buttonToast"></u-toast>
	</view>
</template>

<script scoped>
	import { mapState } from 'vuex'

	export default {
		data() {
			return {
				/**各种按钮效果*/
				cardDataList: []
			}
		},
		onShow() {
		},
		onLoad() {
			this.initCardDataList();
		},
		computed: {
			// 从状态存储里获取当前社区信息
			...mapState('community', {
			// 当前存储是否存在社区信息
				hasCommunity: state => state.hasCommunity,
				communityId: state => state.communityId,
				communityName: state => state.communityName
			}),
			currentOwner() {
				return this.$store.getters.userInfo
			},
			hasLogin() {
      			return this.$store.getters.hasLogin
    		}
  		},
		methods: {
			//所有服务的入口
			serviceHandle(serviceType) {
				console.log(serviceType)
				// 校验当前社区信息
				this.utils.checkCommunity(this.$refs.buttonToast, false, this.hasCommunity, this.currentOwner);
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

			initCardDataList() {
				this.cardDataList = [
					{ cardTitle:'物业服务', subTitle:'物业帮您解决', style:'margin="-150rpx 0rpx 0rpx 0rpx"', 
						subButtonList:[
							{buttonText:'车位申请', customStyle:{marginLeft: '25rpx',backgroundColor: '#a0cfff'}, serviceType:'carApply' },
							{buttonText:'物业缴费', customStyle:{marginLeft: '25rpx',backgroundColor: '#fab6b6'}, serviceType:'wyPay' },
							{buttonText:'车位缴费', customStyle:{marginLeft: '25rpx',backgroundColor: '#71d5a1'}, serviceType:'carPay' }
					  	]
					},
		 			{ cardTitle:'生活服务', subTitle:'方便您的生活,快乐社区', style:'margin="0rpx"', 
						subButtonList:[
							{buttonText:'闲置发布', customStyle:{marginLeft: '25rpx',backgroundColor: '#fcbd71'}, serviceType:'idlePost' },
							{buttonText:'物品邮寄', customStyle:{marginLeft: '25rpx',backgroundColor: '#DCA51C'}, serviceType:'post' },
							{buttonText:'快递查询', customStyle:{marginLeft: '25rpx',backgroundColor: '#71d5a1'}, serviceType:'postQuery' }
						] 
					},
		 			{ cardTitle:'中介服务', subTitle:'稳定可靠值得信赖', style:'margin="0rpx"', 
						subButtonList:[
							{buttonText:'房屋出租', customStyle:{marginLeft: '25rpx',backgroundColor: '#fab6b6'}, serviceType:'leaseHourse' },
							{buttonText:'房屋售卖', customStyle:{marginLeft: '25rpx',backgroundColor: '#a0cfff'}, serviceType:'sellHourse' }
						] 
					}
				];
			}

		}
	}
</script>

<style lang="scss" scoped>
	.lifeContainer {
		width: 100%;
		.headerBody {
			height: 300rpx;
			background-image: linear-gradient(to right, #E17889, #8C4AB5);
		}
		.serviceCard {
			display: flex;
			flex-direction: column;
			align-items: center;
			width: 100%;
			.serviceButtonGroup {
				
				@include flex;
				//display: flex;
				flex-direction: row;
				// flex-wrap: wrap; // 自动换行，此处不生效，暂时注释 edit by mickey 2023-1-13
				align-items: 'flex-start';
				justify-content: space-around;
				width: 100%;
				padding: 15rpx 15rpx;

				/*display: grid;
				grid-template-columns: repeat(3, 25fr);
				grid-gap: 25px;
				grid-template-rows: masonry;
				width: 100%;*/
			}
		}
	}
</style>
