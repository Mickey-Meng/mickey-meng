<template>
	<view class="suggestionPage">
		<u-card title="问题反馈" sub-title="珍贵意见箱">
			<view slot = "body">
				<u-input type="textarea" placeholder="请在此填写您宝贵的意见" v-model="suggestionText" :auto-height="true"></u-input>
			</view>
			<view slot = "foot">
				<u-button shape="circle" type="success" @click="handleSubmit" :disabled="subBtn">提交</u-button>
			</view>
		</u-card>
		<view>
			<u-toast ref="uMsg"></u-toast>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				suggestionText:'',
			}
		},
		computed:{
			subBtn(){
				return !this.suggestionText.trim()!='';
			},
		},
		methods: {
			//处理意见
			handleSubmit(){
				this.$refs.uMsg.show({
					type:'success',
					title:'感谢您的宝贵意见',
					isTab:true,
					url:'pages/my/my'
				});
			},
		}
	}
</script>

<style lang="scss">
.suggestionPage{
	padding: 30rpx;
}
</style>
