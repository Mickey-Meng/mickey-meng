<template>
	<view class="suggestionPage">
		<u-card title="投诉意见" sub-title="投诉意见箱">
			<view slot="body">
				<u-radio-group v-model="suggestionType" active-color="#ff9900">
					<u-radio v-for="(radioItem,index) in radioList" :key="index" :name="radioItem.name">
						{{radioItem.label}}
					</u-radio>
				</u-radio-group>

				<u-input type="textarea" placeholder="请在此填写您宝贵的意见" v-model="suggestionText" :auto-height="true" height="150"
				 maxlength="500"></u-input>


				<u-upload :action="upLoadUrl" max-count="9" name="file" @on-success="upLoadSuccess" @on-remove="removeFile"></u-upload>
			</view>

			<view slot="foot">
				<u-button type="success" shape="circle" @click="subSuggestion" :disabled="subDisabled">提交</u-button>
			</view>
		</u-card>
		<u-toast ref="backToast"></u-toast>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				suggestionText: '',
				communityId:'',
				suggestionType: 'Suggest',
				radioList: [{
					name: 'Suggest',
					label: '意见'
				}, {
					name: 'Complaint',
					label: '投诉'
				}],
				upLoadUrl: '', //上传地址
				imageUrls: [], //图片地址
			}
		},
		onLoad() {
			this.upLoadUrl = this.$u.http.config.baseUrl + '/common/upload';
			this.communityId = uni.getStorageSync('current_community').communityId;
		},
		computed: {
			subDisabled() {
				return this.suggestionText == '';
			},
		},
		methods: {
			//提交投诉意见
			subSuggestion() {
				let param = {};
				param.communityId = this.communityId;
				param.complaintSuggestType = this.suggestionType;
				param.complaintSuggestContent = this.suggestionText;
				if(this.imageUrls.length>0){
					param.imageUrls = this.imageUrls.map(item=>item.response.data);
				}
				this.$u.post('/cs/save',param).then(res=>{
					if(res.code==200){
						this.$refs.backToast.show({
							title: '您的意见已经收到，谢谢您的反馈!',
							type: 'success',
							isTab: true,
							url: 'pages/index/index'
						});
					}else{
						this.$refs.backToast.show({
							title: '网络异常,请稍后重试!',
							type: 'warning'
							
						});
					}
				})
				
			},

			/* 上传成功 */
			upLoadSuccess(data, index, list) {
				this.imageUrls = list;
			},
			removeFile(index, list, name) {
				this.imageUrls = list;
			},
		}
	}
</script>

<style>

</style>
