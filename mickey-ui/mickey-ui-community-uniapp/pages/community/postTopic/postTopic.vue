<template>
	<view class="postTopicPage">
		<view>
			<u--textarea v-model="topicText" placeholder="快和您的邻居分享生活中的新鲜事和精彩瞬间" count ></u--textarea>
		</view>
		 <view>
			 <u-upload :action="upLoadUrl" max-count="9" name="file" @on-success="upLoadSuccess" @on-remove="removeFile"></u-upload>
		 </view>
		 
		 <view class="subBtn">
			 <view class="btnDetail">
				<u-button type="success" @click="subMit" shape="circle" :disabled="binDis" class="myBtn">发布</u-button> 
			 </view>
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
				//社区信息
				currentCommunity: {},
				//业主信息
				ownerInfo: {},
				//内容
				topicText:'',
				upLoadUrl: '', //上传地址
				imageUrls: [], //图片地址
			}
		},
		computed:{
			binDis(){
				return this.topicText.trim()=='';
			},
		},
		onLoad() {
			this.currentCommunity = uni.getStorageSync('current_community');
			this.ownerInfo = uni.getStorageSync('ownerInfo');
			
			this.upLoadUrl = this.$u.http.config.baseUrl + '/common/upload';
		},
		methods: {
			/* 上传成功 */
			upLoadSuccess(data, index, list) {
				this.imageUrls = list;
			},
			removeFile(index, list, name) {
				this.imageUrls = list;
			},
			
			//发布
			subMit(){
				let param = {};
				param.communityId = this.currentCommunity.communityId;
				param.content = this.topicText;
				if(this.imageUrls.length>0){
					param.imageUrls = this.imageUrls.map(item=>item.response.data);
				}
				this.$u.post('/interaction/save',param).then(res=>{
					if(res.code==200){
						this.$refs.uMsg.show({
							title:'发布成功',
							isTab:true,
							url:'pages/community/community',
							type:'success'
						})
					}else{
						this.$u.toast('网络异常,请稍后再试');
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	.postTopicPage {
		padding-left: 30rpx;
		padding-right: 30rpx;
		padding-top: 30rpx;
		width: 100%;
		display: flex;
		flex-direction: column;
		
		.subBtn{
			display: flex;
			flex-direction: row;
			flex-wrap: nowrap;
			justify-content: center;
			width: 100%;
			.btnDetail{
				width: 100%;
				display: flex;
				flex-direction: row;
				justify-content: center;
				.myBtn{
					position: fixed;
					bottom: 20rpx;
					text-align: center;
					width: 80%;
				}
			}
			
		}
	}
</style>
