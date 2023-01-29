<template>
	<view class="communityPage">
		<mickey-card title="热门话题" sub-title="查看更多" :border="false" margin="0" :show-foot="false" :head-border-bottom="false"
		 @head-click="moreHotTopic" :full="true">
		 <view class="hotTopic" slot="body">
			<u-swiper :list="hotTopicList" mode="rect" :title="true" :effect3d="true" @click="handleTopic"></u-swiper>
			</view>
		</mickey-card>

		<u-gap bg-color="#F3F4F6" height="15"></u-gap>
		
		<mickey-card title="友邻市集" sub-title="查看更多" margin="0" :full="true" @head-click="moreActive">
			<view slot="body" class="activeContent">
				<view v-if="activies.length<=0">
					<u-empty mode="data" text="暂无发布数据"></u-empty>
				</view>
				<view class="activeItem" v-for="(activeItem,index) in activies" :key="index" v-if="activies.length>0" @click="viewTopicDetail(activeItem)">
					<view class="activeImg">
						<u-avatar :src="activeItem.avatar" size="mini" mode="circle"></u-avatar>
					</view>
					<view class="activeContent">
						<view class="activeBasic">
							<view class="username">{{activeItem.nickName}}</view>
							<view class="postDate">{{activeItem.createTime}}</view>
						</view>
						<view class="content">
							{{activeItem.content}}
						</view>
					</view>
				</view>
			</view>
			<view slot="foot">
				<view class="pubTopic">
					<u-icon name="order" label="我要发布" color="#f29100" label-color="#f29100" @click="doPublish"></u-icon>
				</view>
			</view>
		</mickey-card>

		<!-- 分隔漕 -->
		<u-gap bg-color="#F3F4F6" height="10"></u-gap>

		<mickey-card title="社区互动" sub-title="查看更多" margin="0" :full="true" @head-click="moreActive">
			<view slot="body" class="activeContent">
				<view v-if="activies.length<=0">
					<u-empty mode="data" text="暂无帖子数据"></u-empty>
				</view>
				<view class="activeItem" v-for="(activeItem,index) in activies" :key="index" v-if="activies.length>0" @click="viewTopicDetail(activeItem)">
					<view class="activeImg">
						<u-avatar :src="activeItem.avatar" size="mini" mode="circle"></u-avatar>
					</view>
					<view class="activeContent">
						<view class="activeBasic">
							<view class="username">{{activeItem.nickName}}</view>
							<view class="postDate">{{activeItem.createTime}}</view>
						</view>
						<view class="content">
							{{activeItem.content}}
						</view>
					</view>
				</view>
			</view>
			<view slot="foot">
				<view class="pubTopic">
					<u-icon name="order" label="我要发贴" color="#f29100" label-color="#f29100" @click="publishTopic"></u-icon>
				</view>
			</view>
		</mickey-card>

		<!-- 分隔漕 -->
		<u-gap bg-color="#F3F4F6" height="10"></u-gap>

		<!-- 闲置交易 -->
		<mickey-card title="闲置交易" sub-title="更多闲置" :showFoot="true" :full="true" margin="0rpx" @head-click="moreActive">
			<view class="idleContent" slot="body">
				<scroll-view scroll-x="true" class="idleScroll" :enable-flex="true">
					<view class="scrollItem" v-for="(idleItem,index) in idleList" @click="handleIdle(idleItem)" :key="index">
						<image :src="idleItem.coverUrl" class="idleItemImage"/>
						<text class="idleItemTitle">{{idleItem.title}}</text>
					</view>
				</scroll-view>
			</view>
			<view slot="foot">
				<view class="pubTopic">
					<u-icon name="order" label="发布商品" color="#f29100" label-color="#f29100" @click="publishGoods"></u-icon>
				</view>
			</view>
		</mickey-card>

		<!-- 提示框 -->
		<u-toast ref="communityToast"></u-toast>
	</view>
</template>

<script>
	import { mapState } from 'vuex'
	export default {
		data() {
			return {
				//热门话题-轮播图
				hotTopicList: [],
				//社区互动话题
				activies: [],
				//闲置物品初始化
				idleList: [],
				ownerInfo:{},//业主信息
			}
		},
		onLoad() {
			//初始化获取热门话题
			this.getTopThreeTopics();
			
			//初始化交易信息
			this.getIdleList();
			
		},
		onShow() {
			//初始化互动
			this.getTop4Activies();
			//this.ownerInfo = uni.getStorageSync('ownerInfo');
			//this.currentCommunity = uni.getStorageSync('current_community');
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
			}
		},
		methods: {
			//获取热门话题
			getTopThreeTopics() {
				this.hotTopicList = [
					{
						id: 1,
						title: '山不在高，有仙则名',
						url: 'https://cdn.uviewui.com/uview/swiper/swiper1.png'
					},
					{
						id: 2,
						title: '水不在深，有龙则灵',
						url: 'https://cdn.uviewui.com/uview/swiper/swiper2.png'
					},
					{
						id: 3,
						title: '斯是陋室，惟吾德馨',
						url: 'https://cdn.uviewui.com/uview/swiper/swiper3.png'
					}
				];
			},

			//获取更多热门话题
			moreHotTopic() {
				this.$u.toast('获取更多热门话题')
			},
			//点击具体的热门话题
			handleTopic(topicItem) {
				console.log('点击热门话题', topicItem)
				this.$u.toast(topicItem.title)
			},
			//获取互动信息
			getTop4Activies() {
				if(this.communityId) {
					/*this.$u.get('/interaction/'+ (this.communityId).then(res=>{
						if(res.code == 200) {
							this.activies = res.data;
						}
					}))*/
				}
			},
			//更多互动信息
			moreActive(){
				this.$u.route('/pages/community/moreActivity/moreActivity')
			},
			doPublish(){
				// 校验当前社区信息
				if(this.utils.checkCommunity(this.$refs.communityToast, false, this.hasCommunity, this.currentOwner)) {
					uni.$u.route('/pages/community/friendshipMarket/deliveryPickup');
				}
			},
			//发布帖子
			publishTopic() {
				console.log('社区信息',this.communityId)
				// 校验当前社区信息
				if(this.utils.checkCommunity(this.$refs.communityToast, false, this.hasCommunity, this.currentOwner)) {
					console.log('跳转到发布帖子界面');
					uni.$u.route('/pages/community/postTopic/postTopic');
				}
			},
			//查看帖子明细
			viewTopicDetail(item){
				console.log('点击的item',item)
				this.$u.route({
					url:'/pages/community/topicDetail/topicDetail',
					params:{
						id:item.interactionId
					}
				})
			},
			//发布商品
			publishGoods() {
				// 校验当前社区信息
				if(this.utils.checkCommunity(this.$refs.communityToast, false, this.hasCommunity, this.currentOwner)) {
					console.log('跳转到发布商品界面');
					uni.$u.route('/pages/community/friendshipMarket/publish');
				}
			},
			//获取闲置物品列表
			getIdleList() {
				this.idleList = [{
						id: '1',
						coverUrl: 'http://172.26.112.1:9000/jnsjwy/title/1.jpg',
						title: '闲置交易说明'
					},
					{
						id: '2',
						coverUrl: 'http://172.26.112.1:9000/jnsjwy/title/2.jpg',
						title: '交易品交易事项'
					},
					{
						id: '3',
						coverUrl: 'http://172.26.112.1:9000/jnsjwy/title/3.jpg',
						title: '物品买卖更方便'
					}

				];
			},
			//点击闲置物品信息
			handleIdle(idleItem) {
				console.log('闲置物品', idleItem)
				this.$u.toast(idleItem.title)
			},
		}
	}
</script>

<style lang="scss" scoped>
	.communityPage {

		.activeContent {
			display: flex;
			flex-direction: column;
			align-items: center;
			width: 100%;

			.activeItem {
				width: 100%;
				margin-bottom: 20rpx;
				display: flex;
				flex-direction: row;
				flex-wrap: nowrap;
				justify-content: space-between;
				align-items: center;

				.activeImg {}

				.activeContent {
					display: flex;
					flex-direction: column;
					width: 100%;
					margin-left: 15rpx;

					.activeBasic {
						display: flex;
						flex-direction: row;
						justify-content: space-between;
						width: 100%;
						color: #c0c4cc;

						.username {}

						.postDate {}
					}

					.content {
						width: 100%;
						margin-top: 20rpx;
						overflow: hidden;
						text-overflow: ellipsis;
						display: -webkit-box;
						-webkit-line-clamp: 2;
						-webkit-box-orient: vertical;
					}
				}


			}
		}

		.pubTopic {
			text-align: center;
		}

		.idleContent {
			display: flex;
			flex-direction: row;
			flex-wrap: nowrap;

			.idleScroll {
				white-space: nowrap;
				width: 100%;

				.scrollItem {
					display: inline-flex;
					margin: 30rpx 20rpx;
					flex-direction: column;
					justify-content: center;
					align-items: center;

					.idleItemImage {
						width: 340rpx;
						height: 180rpx;
						border-radius: 10rpx;
						box-shadow: 2rpx 0rpx #C0C0C0;
					}

					.idleItemTitle {
						text-align: center;
						text-overflow: ellipsis;
						overflow: hidden;
						white-space: nowrap;
						//font-size: 30rpx;
						width: 140rpx;
					}
				}
			}
		}
	}
</style>
