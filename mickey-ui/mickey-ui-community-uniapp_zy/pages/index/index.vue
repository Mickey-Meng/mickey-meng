<template>
	<view class="indexPage">
		<uni-nav-bar leftIcon="location-filled" :title="communityName" color="#f29100" :border="false" :fixed="true"
		 :status-bar="true" @clickLeft="selectCommunity"></uni-nav-bar>
		<!-- 弹出选择社区信息 -->
		<view class="communities">
			<u-select v-model="showCommunity" :list="communities" value-name="communityId" label-name="communityName" @confirm="confirmCommunity"></u-select>
		</view>

		<!-- 首页整个body开始-->
		<view class="indexBody">
			<!-- 服务列表 -->
			<view class="indexService">
				<u-card :full="true" :border="false" :show-head="false" :show-foot="false" margin="0rpx">
					<view class="cardContent" slot="body">
						<u-grid :col="4" :border="false" @click="handleService">
							<u-grid-item index="cardType">
								<image class="serviceIcon" src="../../static/indexIcon/IdCard.png"/>
								<view class="grid-text">身份卡</view>
							</u-grid-item>
							<u-grid-item index="familyType">
								<image class="serviceIcon" src="../../static/indexIcon/family.png"/>
								<view class="grid-text">住户成员</view>
							</u-grid-item>
							<u-grid-item index="vistorType">
								<image class="serviceIcon" src="../../static/indexIcon/vistor.png"/>
								<view class="grid-text">访客邀请</view>
							</u-grid-item>
							<u-grid-item index="hourseType">
								<image class="serviceIcon" src="../../static/indexIcon/hourse.png"/>
								<view class="grid-text">我的房屋</view>
							</u-grid-item>
							<!-- 分割线 -->
							<u-grid-item index="fixType">
								<image class="serviceIcon" src="../../static/indexIcon/fix.png"/>
								<view class="grid-text">报事报修</view>
							</u-grid-item>
							<u-grid-item index="complaintType">
								<image class="serviceIcon" src="../../static/indexIcon/complaint.png"/>
								<view class="grid-text">投诉意见</view>
							</u-grid-item>
							<u-grid-item index="servicePhoneType">
								<image class="serviceIcon" src="../../static/indexIcon/servicePhone.png"/>
								<view class="grid-text">服务电话</view>
							</u-grid-item>
							<u-grid-item index="callPhoneType">
								<image class="serviceIcon" src="../../static/indexIcon/cPhone.png"/>
								<view class="grid-text">投诉热线</view>
							</u-grid-item>
						</u-grid>
					</view>
				</u-card>
			</view>
			<!-- 间隔槽 -->
			<!-- <u-gap bg-color="#F3F4F6" height="15"></u-gap> -->
			<!-- 通知公告 -->
			<u-notice-bar :list="noticeList" type="success"></u-notice-bar>
			
			<!-- 疫情信息 
			<u-card title="全国疫情实时数据" sub-title="数据早知道">
				<view class="epiBody" slot="body">
					<u-grid :col="4">
						<u-grid-item>
							<view>{{epidemicSituation.country.totalConfirmed}}</view>
							<view>确诊</view>
						</u-grid-item>
						<u-grid-item>
							<view>{{epidemicSituation.country.totalDoubtful}}</view>
							<view>疑似</view>
						</u-grid-item>
						<u-grid-item>
							<view>{{epidemicSituation.country.totalDeath}}</view>
							<view>死亡</view>
						</u-grid-item>
						<u-grid-item>
							<view>{{epidemicSituation.country.totalCured}}</view>
							<view>治愈</view>
						</u-grid-item>
					</u-grid>
				</view>
				<view slot="foot" class="epiFoot">
					截至{{epidemicSituation.country.time}}
				</view>
			</u-card>
			-->
			<u-gap bg-color="#F3F4F6" height="15"></u-gap>
			<!-- 社区活动展示 -->
			<view class="indexCommunity">
				<u-card :border="false" :show-foot="false" margin="0rpx" title="社区活动" sub-title="更多" @head-click="moreActivity">
					<view slot="body" class="communtiyContent">
						<u-swiper :list="communityImgs" :effect3d="true" :title="true" mode="dot" @click="handleActivity"></u-swiper>
					</view>
				</u-card>
			</view>
			<!-- 间隔槽 -->
			<u-gap bg-color="#F3F4F6" height="15"></u-gap>
			<!-- 多彩生活 -->
			<view class="beautifulLife">
				<u-card :border="false" :show-foot="false" margin="0rpx" title="多彩生活" sub-title="更多" @head-click="moreLife" :full="true">
					<view slot="body" class="lifeContent">
						<view v-for="(lifeItem,index) in lifeList" :key="index" class="lifeItem" @click="handleLife(lifeItem)">
							<view class="lifeTitle">{{lifeItem.title}}</view>
							<view class="lifeImg">
								<u-image width="100%" height="150rpx" :src="lifeItem.img" border-radius="20"></u-image>
							</view>
						</view>
					</view>
				</u-card>
			</view>
			<!-- 提示框 -->
			<view>
				<u-toast ref="serviceToast"></u-toast>
			</view>
		</view>
		<!-- 首页整个body结束-->

	</view>


</template>

<script>
	export default {
		data() {
			return {
				//社区名称
				communityName: '',
				//是否显示社区
				showCommunity: false,
				//所有社区信息
				communities: [],
				//社区活动信息
				communityImgs: [],
				//多彩生活信息
				lifeList: [],
				//通知公告的内容
				noticeList: [
					
				],
				socketTask:null,
				//疫情数据
				epidemicSituation:null,

			}
		},
		onShow() {
			//this.getEpidemicInfo();
		},
		onLoad() {
			//初始化社区信息
			this.initCommunityInfo();
			//初始化活动信息
			this.initCommunityActivity();
			//初始化多彩生活信息
			this.initLifeInfo();
			//通知公告信息
			const currentCommunity = uni.getStorageSync('current_community');
			if(currentCommunity){
				this.initNoticeInfo(currentCommunity.communityId);
			}
			
		},
		methods: {
			//获取疫情信息
			getEpidemicInfo(){
				this.$u.get('/epidemic/info').then(res=>{
					if(res.code==200){
						this.epidemicSituation = res.data;
						console.log('疫情数据',this.epidemicSituation)
					}else{
						console.log('获取疫情接口异常');
					}
				})
			},
			
			//初始化通知消息
			initNoticeInfo(communityId) {
				let baseWsUrl = this.$u.http.config.wsUrl;
				this.socketTask = uni.connectSocket({
					url: baseWsUrl + "/notice",
					header: {
						miniToken: uni.getStorageSync('miniToken'),
						communityId: communityId
					},
					success: (res) => {
						console.log('成功链接websocket,socketId=',res.socketTaskId)
					}
				});
				this.noticeList = ['暂无公告'];
				let that = this;
				this.socketTask.onMessage(function(res) {
					if(res.data){
						let msg = JSON.parse(res.data).noticeContent;
						that.noticeList.pop();
						that.noticeList.push(msg)
					}
					
				})

			},
			//初始化社区信息
			initCommunityInfo() {
				let currentCommunity = uni.getStorageSync('current_community');
				if (currentCommunity) {
					this.communityName = currentCommunity.communityName;
				} else {
					this.communityName = '选择社区'
				}

			},
			//选择社区
			selectCommunity() {
				let that = this;
				this.$u.get('/community/all').then(res => {
					console.log(res)
					that.communities = res.data;
					that.showCommunity = true;
				})

			},

			//确认选择社区
			confirmCommunity(selectItem) {
				let currentCommunity = {};
				currentCommunity.communityId = selectItem[0].value;
				currentCommunity.communityName = selectItem[0].label;
				uni.setStorageSync('current_community', currentCommunity)
				this.communityName = selectItem[0].label
				if(this.socketTask){
					this.socketTask.close()
					this.socketTask = null;
				}
				this.initNoticeInfo(currentCommunity.communityId);
			},


			//处理服务调用
			handleService(serviceItem) {
				console.log('点击服务', serviceItem)
				let currentCommunity = uni.getStorageSync('current_community');
				let that = this;
				if (!currentCommunity) {
					this.$refs.serviceToast.show({
						title: '请先选择社区',
						type: 'warning',
						callback: function() {
							that.selectCommunity();
						}
					});
					return;
				}
				let ownerInfo = uni.getStorageSync('ownerInfo')
				if (!ownerInfo.authenticated) {
					this.$u.toast('请先实名认证,再进行操作')
					return;
				}
				let communityId = uni.getStorageSync('current_community').communityId;
				switch (serviceItem) {
					case 'cardType':
						//身份卡
						this.$u.route('pages/index/showCard/showCard')
						break;
					case 'familyType':
						//家庭成员
						this.$u.route('pages/index/family/family')
						break;
					case 'vistorType':
						//访客邀请
						this.$u.get('/common/existsBind/' + communityId).then(res => {
							if (res.data) {
								this.$u.route('pages/index/visitor/visitor')
							} else {
								this.$u.toast('请先绑定房屋');
							}
						})

						break;
					case 'hourseType':
						//我的房屋
						this.$u.route('pages/index/rooms/rooms')
						break;
					case 'fixType':
						//报事报修
						//访客邀请
						this.$u.get('/common/existsBind/' + communityId).then(res => {
							if (res.data) {
								this.$u.route('pages/index/fix/fix')
							} else {
								this.$u.toast('请先绑定房屋');
							}
						})
						break;
					case 'complaintType':
						//投诉意见
						this.$u.route('pages/index/suggestion/suggestion')
						break;
					case 'servicePhoneType':
						//服务电话
						this.$u.route('pages/index/servicePhone/servicePhone')
						break;
					case 'callPhoneType':
						//投诉热线
						this.$u.route('pages/index/complaint/complaint')
						break;

				}

			},


			//初始化社区活动信息
			initCommunityActivity() {
				this.communityImgs = [{
						id: '1',
						image: 'http://172.26.112.1:9000/jnsjwy/title/1.jpg',
						title: '美丽的景色总能让人陶醉'
					},
					{
						id: '2',
						image: 'http://172.26.112.1:9000/jnsjwy/title/2.jpg',
						title: '美丽的景色总能让人陶醉'
					},
					{
						id: '3',
						image: 'http://172.26.112.1:9000/jnsjwy/title/3.jpg',
						title: '美丽的景色总能让人陶醉'
					}
				];
			},
			//处理活动点击事件
			handleActivity(activityItem) {
				console.log('活动信息', activityItem)
				this.$u.toast('图片ID' + activityItem.id)
			},
			//获取更多活动信息
			moreActivity() {
				this.$u.toast('获取更多活动信息')
				this.$u.route('pages/index/moreActivity/moreActivity');
			},
			//获取更多生活信息
			moreLife() {
				this.$u.toast('获取更多生活信息')
			},
			//初始化首页展示的多彩生活信息
			initLifeInfo() {
				this.lifeList = [{
						id: "1",
						title: '最适合冬天游玩的5个地方,你都去过吗?',
						img: 'http://172.26.112.1:9000/jnsjwy/title/1.jpg'
					},
					{
						id: "2",
						title: '再留几天行么?日本舍不得大熊猫回中国',
						img: 'http://172.26.112.1:9000/jnsjwy/title/2.jpg'
					},
					{
						id: "3",
						title: '家暴不是家务事！转发让更多人看到',
						img: 'http://172.26.112.1:9000/jnsjwy/title/3.jpg'
					}
				];
			},
			//点击多彩生活具体信息
			handleLife(lifeItem) {
				console.log('生活项目', lifeItem)
				this.$u.toast(lifeItem.title)
			}
		}
	}
</script>

<style lang="scss" scoped>
	.indexPage {
		.communities {}

		.indexBody {
			.indexService {
				.serviceIcon {
					width: 80rpx;
					height: 80rpx;
				}

				.grid-text {
					margin-top: 15rpx;
				}

			}

			.indexCommunity {}

			.beautifulLife {
				.lifeContent {
					display: flex;
					flex-direction: column;
					align-items: center;
					width: 100%;

					.lifeItem {
						display: flex;
						flex-direction: row;
						margin-bottom: 35rpx;
						width: 100%;
						justify-content: space-between;
						flex-wrap: nowrap;

						.lifeTitle {
							width: 60%;
						}

						.lifeImg {
							width: 40%;
						}
					}
				}
			}
		}
	}
</style>
