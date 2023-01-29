<template>
  <view class="container">
    <u-sticky style="top: 0" offset-top="0">
      <uni-nav-bar leftIcon="location-filled" :title=" hasCommunity ? communityName : '请选择社区' " color="#f29100" :border="false" :fixed="true"
        :status-bar="true" @clickLeft="selectCommunity"></uni-nav-bar>
      <!--  弹出选择社区信息  :default-props="communityProps"  -->
      <w-picker :visible.sync="showCommunityProps" mode="selector" :default-type="value"
        :options="communityOptions" @confirm="confirmCommunity($event)"></w-picker>
      <!-- 吸顶搜索栏-->
      <view class="search-wrap">
        <u-search placeholder="日照香炉生紫烟" :showAction="true" actionText="搜索" :animation="true" @click="handleSearchClick"></u-search>
        <text>{{ userInfo.accessToken }}</text>
      </view>
    </u-sticky>

    <!--轮播图-->
    <mickey-banner :banner-list="bannerList"></mickey-banner>
    <u-gap height="15px"></u-gap>
    <!--通知公告：消息滚动栏-->
    <u-notice-bar style="padding: 13px 12px;margin: 0px 15px 0px 15px;" :text="noticeList" mode="link" direction="column" @click="click" type="success"></u-notice-bar>
    
    <!-- 间隔槽 -->
    <!-- <u-gap bg-color="#F3F4F6" height="15"></u-gap> -->
    <u-gap height="15px"></u-gap>

    <!--服务列表:宫格菜单按钮-->
    <u-grid :border="false" col="4" style = "margin: 0px 15px 0px 15px;" >
      <u-grid-item v-for="(menuItem, index) in menuList" :key="index" @click="menuHandle(menuItem.menuEnName, menuItem.routePath)">
        <u-icon :name="menuItem.menuIcon" :color="menuItem.iconStyle" :size="40"></u-icon>
        <text class="grid-title">{{ menuItem.menuZhName }}</text>
      </u-grid-item>
    </u-grid>

    <u-gap bg-color="#F3F3F6" height="10px"></u-gap>

    <!-- 社区活动展示 
    <view class="indexCommunity">
      <u-card :border="false" :show-foot="false" margin="0rpx" title="社区活动" sub-title="更多" @head-click="moreCommunityActivity">
        <view slot="body" class="communtiyContent">
          <u-swiper :list="communityActivityList" :effect3d="true" :title="true" mode="dot" @click="handleActivity"></u-swiper>
        </view>
      </u-card>
    </view>
    <u-gap height="15px"></u-gap>
    -->

    <!-- 多彩生活 -->
    <view class="beautifulLife">
      <mickey-card :border="false" :show-foot="false" margin="-30rpx 0rpx 0rpx 0rpx" title="多彩生活" sub-title="更多" @head-click="moreColorfulLife" :full="true">
        <view slot="body" class="lifeContent">
          <view v-for="(lifeItem,index) in colorfulLifeList" :key="index" class="lifeItem" @click="handleColorfulLife(lifeItem)">
            <view class="lifeTitle">{{lifeItem.title}}</view>
            <view class="lifeImg">
              <u-image width="100%" height="150rpx" :src="lifeItem.img" border-radius="20"></u-image>
            </view>
          </view>
        </view>
      </mickey-card>
    </view>

    <!-- 提示框 -->
    <u-toast ref="menuToast"></u-toast>

     <!--商品展示栏-->
    <yd-product-box :product-list="productList" :title="'每日上新'" show-type="normal"></yd-product-box>
    <yd-product-box :product-list="productList" :title="'热卖商品'" show-type="half"></yd-product-box>
    <yd-product-more :product-list="productList" :more-status="moreStatus"></yd-product-more>
    <u-gap height="15px"></u-gap>
  </view>
</template>

<script scoped>
  import { getBannerData, getNoticeData, checkExistsBind } from '../../api/index'
  import { getCommunityList } from '../../api/community'
  import { getCommunityMenuList } from '../../api/communityMenu'

  import { mapState, mapGetters, mapMutations } from 'vuex'

export default {
  components: {},
  data() {
    return {
      // 是否显示社区
      showCommunityProps: false,
      // 所有社区信息，如：[{label: '十年城',value: '1001'},{label: '罗曼尼',value: '1002'},{label: '天逸',value: '1003'}]
      // communityProps: { label: "communityName", value: "id" },
      communityOptions: [],
      // 轮播图
      bannerList: [],
      // socket任务
      socketTask:null,
      //通知公告的内容
      noticeList: [],
      // 服务列表:宫格菜单按钮
      menuList: [],
      //社区活动信息
      communityActivityList: [],
      //多彩生活信息
      colorfulLifeList: [],

      productList: [
        {
          id: 1,
          image: 'https://cdn.uviewui.com/uview/album/1.jpg',
          title: '山不在高，有仙则名。水不在深，有龙则灵。斯是陋室，惟吾德馨。',
          desc: '山不在于高，有了神仙就会有名气。水不在于深，有了龙就会有灵气。这是简陋的房子，只是我品德好就感觉不到简陋了。',
          price: '13.00'
        },
        {
          id: 2,
          image: 'https://cdn.uviewui.com/uview/album/2.jpg',
          title: '商品222',
          desc: '',
          price: '23.00'
        },
        {
          id: 3,
          image: 'https://cdn.uviewui.com/uview/album/3.jpg',
          title: '商品333',
          desc: '商品描述信息2',
          price: '33.00'
        },
        {
          id: 4,
          image: 'https://cdn.uviewui.com/uview/album/4.jpg',
          title: '商品444',
          desc: '商品描述信息4',
          price: '43.00'
        },
        {
          id: 5,
          image: 'https://cdn.uviewui.com/uview/album/5.jpg',
          title: '商品555',
          desc: '商品描述信息5',
          price: '53.00'
        }
      ],
      // 更多类型
      moreStatus: 'nomore'
    }
  },
  onLoad() {
      //初始化轮播图
      this.loadBannerData()
      //初始化通知信息
      this.loadNoticeData()
      //初始化服务菜单信息
      this.loadMenuData();
			//初始化社区活动信息
			this.initCommunityActivity();
			//初始化多彩生活信息
			this.initColorfulLifeData();
			//通知公告信息
			if(this.hasCommunity){
        console.log("loadNotice-hasCommunity:" + this.hasCommunity);
				this.loadNoticeData(this.communityId);
			}
  },
  computed: {
     // 从状态存储里获取当前社区信息
    ...mapState('community', {
      // 当前存储是否存在社区信息
        hasCommunity: state => state.hasCommunity,
        communityId: state => state.communityId,
        communityName: state => state.communityName
    }),
    //...mapGetters('userInfo'),
    userInfo() {
      return this.$store.getters.userInfo
    },
    noticeTextList() {
      console.log("computed, noticeTextList~");
      return this.noticeList.filter(item => {
        return (item.title) 
      })
    }
  },
  /**
  // 查看当前store的数据
  mounted() {
    console.log(this.$store)
  },
  **/
  methods: {
    ...mapMutations('community', {
       setCommunity: 'SET_COMMUNITY_INFO'
    }),
    //选择社区
    selectCommunity() {
      getCommunityList().then(res => {
        this.showCommunityProps = true;
        // console.log(res);
        this.communityOptions = res.data.map((communityItem) => {
          // 服务端返回的社区信息转换成下拉选择的数据格式
          return {
            label: communityItem.communityName,
            value: communityItem.id
          }
        })
      })
    },
    //确认选择社区
    confirmCommunity(selectedRes) {
      // 根据选择的社区ID过滤社区信息
      let selectedCommunity = { 
          communityId: selectedRes.value, 
          communityName: selectedRes.obj.label
      };
      // 选择的社区数据更新到状态管理器里面
      this.setCommunity(selectedCommunity)

      if(this.socketTask){
        this.socketTask.close()
        this.socketTask = null;
      }
      console.log("Sate管理器中的社区信息[communityName:" + this.communityName + ",communityId:" + this.communityId);
      // 根据社区ID查询相关通知信息
      this.loadNoticeData(this.communityId);
    },

      // 搜索
      handleSearchClick(e) {
        console.log("当前业主");
        console.log(JSON.stringify(this.$store.getters.userInfo));
        console.log(ownerInfo);
        uni.$u.route('/pages/search/search')
      },

      //初始化轮播图
      loadBannerData() {
        /*
        getBannerData().then(res => {
          console.log("初始化轮播图,getBannerData");
          console.log(res);
          this.bannerList = res.data
        })*/
        this.bannerList = [
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
          ]
      },

      //初始化通知信息
      loadNoticeData(communityId) {
        getNoticeData({ type : 1, status : 0, channel : 1, tenantId : communityId }).then(res => {
          this.noticeList = res.data.map((notice) => {
					  return notice.title
					})
          console.log(this.noticeList);
        })
				/*let baseWsUrl = this.$u.http.config.wsUrl;
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
				})*/
			},
      //初始化服务菜单信息
      loadMenuData(){
        getCommunityMenuList().then(res => {
          this.menuList = res.data;
        })
      },
			//初始化社区活动信息
			initCommunityActivity(){
        this.communityActivityList = 
          {
            id: 1,
            image: 'https://cdn.uviewui.com/uview/album/1.jpg',
            title: '山不在高，有仙则名。水不在深，有龙则灵。斯是陋室，惟吾德馨。',
            desc: '山不在于高，有了神仙就会有名气。水不在于深，有了龙就会有灵气。这是简陋的房子，只是我品德好就感觉不到简陋了。'
          },
          {
            id: 2,
            image: 'https://cdn.uviewui.com/uview/album/2.jpg',
            title: '美丽的景色总能让人陶醉',
            desc: '',
          },
          {
            id: 3,
            image: 'https://cdn.uviewui.com/uview/album/3.jpg',
            title: '商品333',
            desc: '商品描述信息2',
            price: '33.00'
          }
      },
      //获取更多活动信息
      moreCommunityActivity() {
				this.$u.toast('获取更多活动信息')
				this.$u.route('pages/index/moreActivity/moreActivity');
			},
			//初始化多彩生活信息
			initColorfulLifeData(){
        this.colorfulLifeList = [
          {
                id: 1,
                title: '最适合冬天游玩的5个地方,你都去过吗?',
                url: 'https://cdn.uviewui.com/uview/swiper/swiper1.png',
                img: 'https://cdn.uviewui.com/uview/swiper/swiper1.png'
              },
              {
                id: 2,
                title: '再留几天行么?日本舍不得大熊猫回中国',
                url: 'https://cdn.uviewui.com/uview/swiper/swiper2.png',
                img: 'https://cdn.uviewui.com/uview/swiper/swiper1.png'
              },
              {
                id: 3,
                title: '家暴不是家务事！转发让更多人看到',
                url: 'https://cdn.uviewui.com/uview/swiper/swiper3.png',
                img: 'https://cdn.uviewui.com/uview/swiper/swiper1.png'
              }
				]
      },
			//获取更多生活信息
			moreColorfulLife() {
				this.$u.toast('获取更多生活信息')
			},
			//点击多彩生活具体信息
			handleColorfulLife(lifeItem) {
				console.log('生活项目', lifeItem)
				this.$u.toast(lifeItem.title)
			},
      /**
       * 菜单处理
       */
			menuHandle(menuEnName, routePath) {
				console.log('menuEnName:' + menuEnName + ' | routePath:' + routePath);
        // 校验当前社区信息
        //this.utils.checkCommunity(this.$refs.menuToast, true);
        //处理服务调用
				switch (menuEnName) {
					case 'rentalAndSale':
						// 房屋租售
            checkExistsBind(communityId).then(res => {
              console.log(res);
              if (res.data) {
								this.$u.route(routePath);
							} else {
                this.$refs.menuToast.show({
                  message: '请先绑定房屋',// 显示文本
                  type: 'warning'
                });
							}
            })
						break;
					default :
            this.$u.route(routePath);
				}
			},
      
			//处理活动点击事件
			handleActivity(activityItem) {
				console.log('活动信息', activityItem)
				this.$u.toast('图片ID' + activityItem.id)
			}			
  }
}
</script>

<style lang="scss" scoped>
.search-wrap {
  background: $custom-bg-color;
  padding: 20rpx;
}

.grid-title {
  line-height: 50rpx;
  font-size: 26rpx;
}

.beautifulLife {
  margin: 15px;
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
        font-size: 14px;
        width: 60%;
      }
      .lifeImg {
        width: 40%;
      }
    }
  }
}
</style>
