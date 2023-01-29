<template>
	<view>
		<u-card title="车位" :showFoot="false"  v-for="(applyItem,index) in parkingSpaceList" :key="index">
			<view slot="body">
				<u-field label="编号" :value="applyItem.num" :disabled="true"></u-field>
				<u-field label="车位状态" :value="applyItem.state=='F'?'空闲':'状态错误'" :disabled="true"></u-field>
				<u-field label="面积" :value="applyItem.area" :disabled="true"></u-field>
			</view>
		</u-card>
	</view>
</template>

<script>
	export default {
		onLoad: function (option) {
			const currentCommunity = uni.getStorageSync('current_community');
			this.$u.get('/parkingArea/checkParkingSpace/'+option.paId).then(res=>{
				this.parkingSpaceList = res.data;
			}).catch(err=>{
				this.$u.toast('网络异常')
			})
		},
		data() {
			return {
				parkingSpaceList: '',
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
