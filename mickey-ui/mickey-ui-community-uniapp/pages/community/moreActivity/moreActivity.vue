<template>
	<view class="moreActivityPage">
		<scroll-view :scroll-y="true" :enable-back-to-top="true" @scrolltolower="moreActivities" class="scorllView">
			<view class="comment" v-for="res in interactionList" :key="res.interactionId" @click="viewDetail(res.interactionId)">
				<view class="left">
					<image :src="res.avatar" mode="aspectFill"></image>
				</view>
				<view class="right">
					<view class="top">
						<view class="name">{{ res.nickname }}</view>
						<view class="time">{{res.createTime}}</view>
					</view>
					<view class="content">{{ res.content }}</view>
					<view class="contentImg" v-if="res.imageUrls.length>0">
						<u-image class="detailImg" :src="imgItem.fileUrl" width="80rpx" height="80rpx" v-for="(imgItem,index) in res.imageUrls" :key="index"></u-image>
					</view>
				</view>
			</view>
			<view>
				<u-loadmore :status="loadStatus"></u-loadmore>
			</view>
		</scroll-view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				loadStatus:'loading',
				interactionList: [],
				page: 1,
				size: 8,
				hasNextPage: false,
				communityId: '',
			}
		},
		onLoad() {

			this.communityId = uni.getStorageSync('current_community').communityId;
			this.getComment();
		},
		methods: {
			// 评论列表
			getComment() {
				this.$u.get('/interaction/page/' + this.page + '/' + this.size + '/' + this.communityId).then(res => {
					this.hasNextPage = res.data.hasNextPage;
					this.page = res.data.nextPage;
					this.interactionList = res.data.list;
					console.log('数据',this.interactionList)
				})
			},
			moreActivities(){
				if(this.hasNextPage){
					this.$u.get('/interaction/page/' + this.page + '/' + this.size + '/' + this.communityId).then(res => {
						this.hasNextPage = res.data.hasNextPage;
						this.page = res.data.nextPage;
						res.data.list.forEach(item => {
							this.interactionList.push(item)
						})
					})
				}else{
					this.loadStatus = 'nomore'
				}
			},
			viewDetail(id){
				this.$u.route({
					url:'pages/community/topicDetail/topicDetail',
					params:{
						id:id
					}
				})
			},
		}
	};
</script>

<style lang="scss" scoped>
	.moreActivityPage{
		height: 100%;
		.scorllView{
			position: absolute;
			height: 100%;
			width: 100%;
		}
	}
	.comment {
		display: flex;
		padding: 30rpx;

		.left {
			image {
				width: 64rpx;
				height: 64rpx;
				border-radius: 50%;
				background-color: #f2f2f2;
			}
		}

		.right {
			flex: 1;
			padding-left: 20rpx;
			font-size: 30rpx;

			.top {
				display: flex;
				justify-content: space-between;
				align-items: center;
				margin-bottom: 10rpx;

				.name {
					color: #606266;
				}

				.like {
					display: flex;
					align-items: center;
					color: #9a9a9a;
					font-size: 26rpx;

					.num {
						margin-right: 4rpx;
						color: #9a9a9a;
					}
				}

				.highlight {
					color: #5677fc;

					.num {
						color: #5677fc;
					}
				}
			}

			.content {
				margin-bottom: 10rpx;
			}
			.contentImg{
				display: flex;
				flex-direction: row;
				flex-wrap: wrap;
				.detailImg{
					margin-left: 10rpx;
					margin-top: 10rpx;
				}
			}

			.reply-box {
				background-color: rgb(242, 242, 242);
				border-radius: 12rpx;

				.item {
					padding: 20rpx;
					border-bottom: solid 2rpx $u-border-color;

					.username {
						font-size: 24rpx;
						color: #999999;
					}
				}

				.all-reply {
					padding: 20rpx;
					display: flex;
					color: #5677fc;
					align-items: center;

					.more {
						margin-left: 6rpx;
					}
				}
			}

			.bottom {
				margin-top: 20rpx;
				display: flex;
				font-size: 24rpx;
				color: #9a9a9a;

				.reply {
					color: #5677fc;
					margin-left: 10rpx;
				}
			}
		}
	}
</style>
