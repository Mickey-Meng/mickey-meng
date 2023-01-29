<template>
	<view>
		<u-card title="小区停车场" :sub-title="applyItem.name" :showFoot="false"  v-for="(applyItem,index) in parkingAreaList" :key="index" @click="checkParkingSpace(applyItem)">
			<view slot="body">
				<u-field label="编号" :value="applyItem.num" :disabled="true"></u-field>
				<u-field label="名称" :value="applyItem.name" :disabled="true"></u-field>
				<u-field label="类型" :value="applyItem.typeCd==1001?'地上停车场':'地下停车场'" :disabled="true"></u-field>
			</view>
		</u-card>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				parkingAreaList: [],
				subTitle: '',
				basicInfo: '',
			}
		},
		onLoad() {
			this.getBindResult();
			this.basicInfo = uni.getStorageSync('ownerInfo')
		},
		methods: {
			/* 获取数据集合 */
			getBindResult(){
				const currentCommunity = uni.getStorageSync('current_community');
				this.$u.get('/parkingArea/list/'+currentCommunity.communityId).then(res=>{
					console.log('结果',res.data)
					this.parkingAreaList = res.data
				}).catch(err=>{
					this.$u.toast('网络异常')
				})
			},
			checkParkingSpace(applyItem) {
				console.log('点击查看',applyItem)
				if(this.basicInfo){
					this.$u.route('pages/life/applyFor/applyForSpace?paId='+applyItem.paId)
				}else{
					this.$refs.uMsg.show({
						title:'即将跳转到登录页面',
						type:'success',
						url:'pages/login/login'
					})
				}
			},
		}
	}
</script>

<style>

</style>
