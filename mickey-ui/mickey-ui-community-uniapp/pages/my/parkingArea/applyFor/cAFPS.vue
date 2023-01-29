<template>
	<view>
		<u-card title="申请" :showFoot="false"  v-for="(applyItem,index) in parkingSpaceList" :key="index">
			<view slot="body">
				<u-field label="申请编号" :value="applyItem.applyNumber" :disabled="true"></u-field>
				<u-field label="申请状态" :value="getStatus(applyItem.status)" :disabled="true"></u-field>
				<u-field label="车位" :value="applyItem.parkingLot" :disabled="true"></u-field>
				<u-field label="审核原因" :value="applyItem.auditReasons" :disabled="true"></u-field>
			</view>
		</u-card>
	</view>
</template>

<script>
	export default {
		onLoad: function (option) {
			const currentCommunity = uni.getStorageSync('current_community');
			this.$u.get('/parkingArea/selectApplyForBu').then(res=>{
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
			getStatus(status) {
				switch (status) {
					case 'bind_pass' :
						return '审批通过';
					case 'bind_reject' :
						return '审批驳回';
					case 'bind_auding' :
						return '审批中';
				}
			}
		}
	}
</script>

<style>

</style>
