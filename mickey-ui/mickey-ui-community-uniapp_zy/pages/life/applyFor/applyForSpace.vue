<template>
	<view>
		<u-card title="车位" :showFoot="false"  v-for="(applyItem,index) in parkingSpaceList" :key="index">
			<view slot="body">
				<u-field label="编号" :value="applyItem.num" :disabled="true"></u-field>
				<u-field label="车位状态" :value="applyItem.state=='F'?'空闲':'状态错误'" :disabled="true"></u-field>
				<u-field label="面积" :value="applyItem.area" :disabled="true"></u-field>
				<u-button type="primary" @click="applyForBu(applyItem) ">申请</u-button>
			</view>
		</u-card>
		<view>
			<u-toast ref="uMsg"></u-toast>
		</view>
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
			applyForBu(row){
				console.log(row.psId)
				let param = {
					wyglParkingSpace:{
						psId: ''
					}
				};
				param.wyglParkingSpace.psId = row.psId;
				this.$u.post('/parkingArea/applyForBu',param).then(res=>{
					if(res.code==200){
						this.$refs.uMsg.show({
							title:'绑定信息已提交,请在我的房屋处查看信息进度',
							isTab:true,
							url:'pages/life/life',
							type:'success'
						});
					}else{
						this.$refs.uMsg.show({
							title:res.msg,
							type:'error'
						});
					}
				})
			}
		}
	}
</script>

<style>

</style>
