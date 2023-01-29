<template>
	<view class="roomsPage">
		<u-subsection :list="subsectionList" @change="changeSelect" :current="currentIndex" :active-color="activeColor"></u-subsection>
		
		
			<view v-if="currentIndex==0">
				<u-card title="房屋卡" :sub-title="subTitle" :showFoot="false"  v-for="(applyItem,index) in applyList" :key="index">
					<view slot="body">
						<u-field label="申请时间" :value="applyItem.applyDate | dateFormat" :disabled="true"></u-field>
						<u-field label="楼栋信息" :value="applyItem.buildingName" :disabled="true"></u-field>
						<u-field label="单元信息" :value="applyItem.unitName" :disabled="true"></u-field>
						<u-field label="房间信息" :value="applyItem.roomName" :disabled="true"></u-field>
					</view>
				</u-card>
			</view>
			
			<view v-if="currentIndex==1">
				<u-card title="房屋卡" :sub-title="subTitle" :showFoot="false"  v-for="(bindItem,index) in bindList" :key="index">
					<view slot="body">
						<u-field label="申请时间" :value="bindItem.applyDate | dateFormat" :disabled="true"></u-field>
						<u-field label="审批时间" :value="bindItem.changeDate | dateFormat" :disabled="true"></u-field>
						<u-field label="楼栋信息" :value="bindItem.buildingName" :disabled="true"></u-field>
						<u-field label="单元信息" :value="bindItem.unitName" :disabled="true"></u-field>
						<u-field label="房间信息" :value="bindItem.roomName" :disabled="true"></u-field>
					</view>
				</u-card>
			</view>
			
			<view v-if="currentIndex==2">
				<u-card title="房屋卡" :sub-title="subTitle" :showFoot="false"  v-for="(rejectItem,index) in rejectList" :key="index">
					<view slot="body">
						<u-field label="申请时间" :value="rejectItem.applyDate | dateFormat" :disabled="true"></u-field>
						<u-field label="审批时间" :value="rejectItem.changeDate | dateFormat" :disabled="true"></u-field>
						<u-field label="楼栋信息" :value="rejectItem.buildingName" :disabled="true"></u-field>
						<u-field label="单元信息" :value="rejectItem.unitName" :disabled="true"></u-field>
						<u-field label="房间信息" :value="rejectItem.roomName" :disabled="true"></u-field>
						<u-field label="拒绝意见" :value="rejectItem.recordAuditOpinion" :disabled="true"></u-field>
					</view>
				</u-card>
			</view>
		
	
	</view>
</template>

<script>
	export default {
		data() {
			return {
				subsectionList:[
					{name:'审批中'},
					{name:'已绑定'},
					{name:'已驳回'}
				],//分段器
				currentIndex:0,
				subTitle:'审批中',
				activeColor:this.$u.color['warning'],
				applyList:[],//申请集合
				bindList:[],//绑定集合
				rejectList:[],//审批失败集合
			}
		},
		onLoad() {
			this.getBindResult();
		},
		filters:{
			dateFormat(value){
				let newTime = new Date(value)
				let year = newTime.getFullYear();
				let month = newTime.getMonth()+1;
				let day = newTime.getDate();
				let hour = newTime.getHours();
				let minute = newTime.getMinutes();
				let second = newTime.getSeconds();
				
				return year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;
			},
		},
		methods: {
			/* 改变选项 */
			changeSelect(index){
				this.currentIndex = index;
				if(index==0){
					this.subTitle = '审批中'
				}else if(index==1){
					this.subTitle = '已绑定'
				}else{
					this.subTitle = '已驳回';
				}
			},
			/* 获取数据集合 */
			getBindResult(){
			const currentCommunity = uni.getStorageSync('current_community');
				this.$u.get('/house/info/'+currentCommunity.communityId).then(res=>{
					console.log('结果',res.data)
					this.applyList = res.data.applyList;
					this.bindList = res.data.bindList;
					this.rejectList = res.data.rejectList;
				}).catch(err=>{
					this.$u.toast('网络异常')
				})
			},
		}
	}
</script>

<style>

</style>
