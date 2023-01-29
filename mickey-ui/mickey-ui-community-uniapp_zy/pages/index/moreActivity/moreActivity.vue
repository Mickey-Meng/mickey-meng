<template>
	<view>
		<view class="wrap">
			<view class="u-tabs-box">
				<u-tabs-swiper activeColor="#f29100" ref="tabs" :list="list" :current="current" @change="change" :is-scroll="false"
				 swiperWidth="750">
				</u-tabs-swiper>
			</view>
			<swiper class="swiper-box" :current="swiperCurrent" @transition="transition" @animationfinish="animationfinish">
				<!-- 报名中的数据 -->
				<swiper-item class="swiper-item">
					<scroll-view scroll-y style="height: 100%;width: 100%;" @scrolltolower="reachBottom">
						<view class="page-box">
							<view class="order" v-for="(res, index) in orderList[0]" :key="res.id">
								<view class="top">
									<view class="left">
										<u-icon name="bell" :size="30" color="rgb(94,94,94)"></u-icon>
										<view class="store">{{ res.activityTitle }}</view>
									</view>
									<view class="right">发布日期:{{ res.postDate }}</view>
								</view>
								<view class="item">
									<view class="left">
										<image :src="res.activityImg" mode="aspectFill"></image>
									</view>
									<view class="content">
										<view class="title u-line-2">{{ res.outline }}</view>
										<view class="delivery-time">活动期限 {{ res.keepDate }}</view>
									</view>
								</view>
								<view class="total">
									<text class="total-price">
										当前共有
										<text class="decimal">{{ res.signNum }}</text>
										人报名
									</text>
								</view>
								<view class="bottom">
									<view class="exchange btn">查看详情</view>
									<view class="evaluate btn" :disabled="res.currentIsSign">{{res.currentIsSign?'已报名':'报名'}}</view>
								</view>
							</view>
							<u-loadmore :status="loadStatus[0]" bgColor="#f2f2f2"></u-loadmore>
						</view>
					</scroll-view>
				</swiper-item>
				<!-- 已结束的数据 -->
				<swiper-item class="swiper-item">
					<scroll-view scroll-y style="height: 100%;width: 100%;" @scrolltolower="reachBottom">
						<view class="page-box">
							<view class="order" v-for="(res, index) in  orderList[1]" :key="res.id">
								<view class="top">
									<view class="left">
										<u-icon name="bell" :size="30" color="rgb(94,94,94)"></u-icon>
										<view class="store">{{ res.activityTitle }}</view>
									</view>
									<view class="right">发布日期:{{ res.postDate }}</view>
								</view>
								<view class="item">
									<view class="left">
										<image :src="res.activityImg" mode="aspectFill"></image>
									</view>
									<view class="content">
										<view class="title u-line-2">{{ res.outline }}</view>
										<view class="delivery-time">活动期限 {{ res.keepDate }}</view>
									</view>
								</view>
								<view class="total">
									<text class="total-price">
										当前共有
										<text class="decimal">{{ res.signNum }}</text>
										人报名
									</text>
								</view>
								<view class="bottom">
									<view class="exchange btn">查看详情</view>
								</view>
							</view>
							<u-loadmore :status="loadStatus[1]" bgColor="#f2f2f2"></u-loadmore>
						</view>
					</scroll-view>
				</swiper-item>
			</swiper>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				orderList: [
					[],
					[]
				],
				dataList: [{
						id: 1, //活动Id
						activityTitle: '跳广场舞活动', //活动标题
						postDate: '2020-10-10', //发布日期
						keepDate: '2020-10-10 至 2020-11-11', //活动日期范围
						outline: '为了促进社区人交友活动', //活动概要
						signNum: 23, //活动的报名人数
						activityImg: '//img14.360buyimg.com/n7/jfs/t6007/205/4099529191/294869/ae4e6d4f/595dcf19Ndce3227d.jpg!q90.jpg',
						currentIsSign: true, //当前人是否已经报名
					},
					{
						id: 2, //活动Id
						activityTitle: '包饺子活动', //活动标题
						postDate: '2020-10-15', //发布日期
						keepDate: '2020-10-10 至 2020-11-11', //活动日期范围
						outline: '为了促进社区团建，共建美好家园做出一份好的努力！', //活动概要
						signNum: 33, //活动的报名人数
						activityImg: '//img14.360buyimg.com/n7/jfs/t6007/205/4099529191/294869/ae4e6d4f/595dcf19Ndce3227d.jpg!q90.jpg',
						currentIsSign: false, //当前人是否已经报名
					},
					{
						id: 3, //活动Id
						activityTitle: '唱歌活动', //活动标题
						postDate: '2020-10-10', //发布日期
						keepDate: '2020-10-10 至 2020-11-11', //活动日期范围
						outline: '为了促进社区团建，共建美好家园做出一份好的努力！', //活动概要
						signNum: 33, //活动的报名人数
						activityImg: '//img14.360buyimg.com/n7/jfs/t6007/205/4099529191/294869/ae4e6d4f/595dcf19Ndce3227d.jpg!q90.jpg',
						currentIsSign: false, //当前人是否已经报名
					},
					{
						id: 4, //活动Id
						activityTitle: '唱歌活动', //活动标题
						postDate: '2020-10-10', //发布日期
						keepDate: '2020-10-10 至 2020-11-11', //活动日期范围
						outline: '为了促进社区团建，共建美好家园做出一份好的努力！', //活动概要
						signNum: 33, //活动的报名人数
						activityImg: '//img14.360buyimg.com/n7/jfs/t6007/205/4099529191/294869/ae4e6d4f/595dcf19Ndce3227d.jpg!q90.jpg',
						currentIsSign: false, //当前人是否已经报名
					},
					{
						id: 5, //活动Id
						activityTitle: '唱歌活动', //活动标题
						postDate: '2020-10-10', //发布日期
						keepDate: '2020-10-10 至 2020-11-11', //活动日期范围
						outline: '为了促进社区团建，共建美好家园做出一份好的努力！', //活动概要
						signNum: 33, //活动的报名人数
						activityImg: '//img14.360buyimg.com/n7/jfs/t6007/205/4099529191/294869/ae4e6d4f/595dcf19Ndce3227d.jpg!q90.jpg',
						currentIsSign: false, //当前人是否已经报名
					}
				],
				list: [{
						name: '进行中'
					},
					{
						name: '已结束'
					}
				],
				current: 0,
				swiperCurrent: 0,
				tabsHeight: 0,
				dx: 0,
				loadStatus: ['loadmore', 'loading', 'nomore'],
				pageOneNum: 0, //进行中的第几页
				pageTwoNum: 0, //已结束的第几页
			};
		},
		onLoad() {
			this.getOrderList(0);
			this.getOrderList(1);
		},
		computed: {

		},
		methods: {
			reachBottom() {
				// 此tab为空数据
				if (this.current != 2) {
					this.loadStatus.splice(this.current, 1, "loading")
					setTimeout(() => {
						this.getOrderList(this.current);
					}, 1200);
				}
			},
			// 页面数据
			getOrderList(idx) {
				for (let i = 0; i < 5; i++) {
					let index = this.$u.random(0, this.dataList.length - 1);
					let data = JSON.parse(JSON.stringify(this.dataList[index]));
					data.id = this.$u.guid();
					this.orderList[idx].push(data);
				}
				if (idx === 0) {
					//获取进行中的数据
					console.log('当前是 %d 个tab页的第 %d 页数据',idx,this.pageOneNum)
					this.pageOneNum++;
				} else {
					
					console.log('当前是 %d 个tab页的第 %d 页数据',idx,this.pageTwoNum)
					this.pageTwoNum++;
				}
				
				this.loadStatus.splice(this.current, 1, "loadmore")
			},

			// tab栏切换
			change(index) {
				console.log('当前tab索引', index)
				this.swiperCurrent = index;
				this.getOrderList(index);
			},
			transition({
				detail: {
					dx
				}
			}) {
				this.$refs.tabs.setDx(dx);
			},
			animationfinish({
				detail: {
					current
				}
			}) {
				this.$refs.tabs.setFinishCurrent(current);
				this.swiperCurrent = current;
				this.current = current;
			}
		}
	};
</script>

<style>
	/* #ifndef H5 */
	page {
		height: 100%;
		background-color: #f2f2f2;
	}

	/* #endif */
</style>

<style lang="scss" scoped>
	.order {
		width: 710rpx;
		background-color: #ffffff;
		margin: 20rpx auto;
		border-radius: 20rpx;
		box-sizing: border-box;
		padding: 20rpx;
		font-size: 28rpx;

		.top {
			display: flex;
			justify-content: space-between;

			.left {
				display: flex;
				align-items: center;

				.store {
					margin: 0 10rpx;
					font-size: 32rpx;
					font-weight: bold;
				}
			}

			.right {
				color: $u-type-warning-dark;
			}
		}

		.item {
			display: flex;
			margin: 20rpx 0 0;

			.left {
				margin-right: 20rpx;

				image {
					width: 200rpx;
					height: 200rpx;
					border-radius: 10rpx;
				}
			}

			.content {
				.title {
					font-size: 28rpx;
					line-height: 50rpx;
				}

				.type {
					margin: 10rpx 0;
					font-size: 24rpx;
					color: $u-tips-color;
				}

				.delivery-time {
					margin-top: 35rpx;
					font-size: 24rpx;
				}
			}

			.right {
				margin-left: 10rpx;
				padding-top: 20rpx;
				text-align: right;

				.decimal {
					font-size: 24rpx;
					margin-top: 4rpx;
				}

				.number {
					color: $u-tips-color;
					font-size: 24rpx;
				}
			}
		}

		.total {
			margin-top: 20rpx;
			text-align: right;
			font-size: 24rpx;

			.total-price {
				font-size: 32rpx;
			}
		}

		.bottom {
			display: flex;
			margin-top: 40rpx;
			padding: 0 10rpx;
			justify-content: space-between;
			align-items: center;

			.btn {
				line-height: 52rpx;
				width: 160rpx;
				border-radius: 26rpx;
				border: 2rpx solid $u-border-color;
				font-size: 26rpx;
				text-align: center;
				color: $u-type-info-dark;
			}

			.evaluate {
				color: $u-type-warning-dark;
				border-color: $u-type-warning-dark;
			}
		}
	}

	.centre {
		text-align: center;
		margin: 200rpx auto;
		font-size: 32rpx;

		image {
			width: 164rpx;
			height: 164rpx;
			border-radius: 50%;
			margin-bottom: 20rpx;
		}

		.tips {
			font-size: 24rpx;
			color: #999999;
			margin-top: 20rpx;
		}

		.btn {
			margin: 80rpx auto;
			width: 200rpx;
			border-radius: 32rpx;
			line-height: 64rpx;
			color: #ffffff;
			font-size: 26rpx;
			background-image: linear-gradient(270deg, rgba(249, 116, 90, 1) 0%, rgba(255, 158, 1, 1) 100%);
		}
	}

	.wrap {
		display: flex;
		flex-direction: column;
		height: calc(100vh - var(--window-top));
		width: 100%;
	}

	.swiper-box {
		flex: 1;
	}

	.swiper-item {
		height: 100%;
	}
</style>
