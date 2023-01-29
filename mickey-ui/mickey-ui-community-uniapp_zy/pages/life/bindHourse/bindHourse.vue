<template>
	<view class="bindHoursePage">
		<u-card title="房屋绑定卡" sub-title="绑定不丢失">
			<view slot="body">
				<u-field label="房屋选择" placeholder="请点击选择房屋" @click="selectBuildings" v-model="roomInfo" :disabled="true"></u-field>

				<multi-select :showPopup="showCascade" :firstList="buildingList" :secondList="unitList" :thirdList="roomList"
				 @firstChange="getUnitsByBuildingId" @secondChange="getRoomsByUnitId" @thirdChange="selectResult" @close="closeSelect"></multi-select>

				<!-- 业主类型 -->
				<u-field label="业主类型" placeholder="请选择业主类型" @click="selectOwnerType" :disabled="true" v-model="ownerType"></u-field>

				<u-select v-model="showOwnerType" :list="ownerTypeList" @confirm="confirmOwnerType"></u-select>
				
				<!-- 业主信息 -->
				<u-field label="业主姓名" :disabled="true" v-model="authInfo.realName"></u-field>
				<u-field label="身份证号" :disabled="true" v-model="authInfo.idCardNum"></u-field>
			</view>
			<view slot="foot">
				<u-button type="success" shape="circle" @click="bindHourse" :disabled="bindDis">房屋绑定</u-button>
			</view>
		</u-card>
		<view>
			<u-toast ref="uMsg"></u-toast>
		</view>
	</view>
</template>

<script>
	import multiSelect from '@/components/wygl-multi-select/wygl-multi-select.vue'
	export default {
		components: {
			multiSelect
		},
		computed:{
			bindDis(){
				return !(this.roomValue.trim()!='' && this.ownerTypeValue.trim()!='')
			}
		},
		data() {
			return {
				roomInfo: '', //房屋定位信息
				currentCommunity: {}, //当前社区信息
				ownerInfo: {}, //当前用户信息
				buildingList: [], //楼栋集合
				buildingValue:'',//选择的楼栋
				unitList: [], //单元信息
				unitValue:'',//选择的单元
				roomList: [], //房屋信息
				roomValue:'',//选择的房屋Id
				showCascade: false, //展示级联选择组件
				ownerType: '', //业主类型
				ownerTypeValue:'',//业主类型值
				showOwnerType: false, //展示选择业主类型组件
				ownerTypeList: [], //业主类型集合
				authInfo:{},//实名认证信息
			}
		},
		onLoad() {
			this.ownerInfo = uni.getStorageSync('ownerInfo');
			this.currentCommunity = uni.getStorageSync('current_community')
			this.getAuthInfo();//获取实名信息
			/* 获取业主类型 */
			this.getOwnerTypeList();
		},
		methods: {
			/* 查询业主类型 */
			getOwnerTypeList(){
				this.$u.get("/common/dict/zy_owner_state").then(res=>{
					this.ownerTypeList = res.data;
				})
			},
			/* 查询楼栋列表 */
			selectBuildings() {
				console.log('当前小区信息',this.currentCommunity)
				this.$u.get('/life/building/' + this.currentCommunity.communityId).then(res => {
					this.buildingList = res.data
				}).catch(err => {
					console.log('错误', err)
				})
				this.showCascade = true;
			},
			/* 通过楼栋Id查询单元列表 */
			getUnitsByBuildingId(buildingId) {
				console.log('楼栋Id', buildingId);
				this.$u.get('/life/unit/' + buildingId).then(res => {
					this.unitList = res.data
				})
			},
			/* 通过单元Id查询房屋信息 */
			getRoomsByUnitId(unitId) {
				console.log('单元Id', unitId)
				this.$u.get('/life/room/' + unitId).then(res => {
					this.roomList = res.data;
				})
			},
			selectResult(result) {
				console.log('选择的结果', result)
				this.roomInfo = result.first.label + '/' + result.second.label + '/' + result.third.label;
				this.buildingValue = result.first.value;
				this.unitValue = result.second.value;
				this.roomValue = result.third.value;
				this.closeSelect();
			},
			closeSelect() {
				this.showCascade = false;
			},
			/* 展示业主类型列表 */
			selectOwnerType() {
				this.showOwnerType = true;
			},
			/* 选择业主类型 */
			confirmOwnerType(e) {
				this.ownerType = e[0].label;
				this.ownerTypeValue = e[0].value;
			},
			/* 获取实名信息 */
			getAuthInfo(){
				this.$u.get('/auth/owner').then(res=>{
					console.log('实名数据',res)
					if(res.code==200){
						this.authInfo = res.data;
					}
				})
			},
			/* 绑定信息 */
			bindHourse(){
				let param = {};
				param.communityId = this.currentCommunity.communityId;
				param.buildingId = this.buildingValue;
				param.unitId = this.unitValue;
				param.roomId = this.roomValue;
				param.ownerType = this.ownerTypeValue;
				console.log('提交的数据',param);
				this.$u.post('/bind/room',param).then(res=>{
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
				
				
			},
		}
	}
</script>

<style lang="scss">
	.bindHoursePage {
		padding: 30rpx;
	}
</style>
