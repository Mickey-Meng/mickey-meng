<template>
	<view class="waitHandlePage">
		<view v-if="waitHandleList.length==0" class="u-margin-top-300">
			<u-empty text="暂无审批数据" mode="data"></u-empty>
		</view>
		<!-- 审批卡 -->
		<view v-if="waitHandleList.length>0">
			<u-card v-for="(handleItem,index) in waitHandleList" :key="index" title="审批卡" sub-title="一次审批,终身使用">
				<view slot="body">
					<u-field label="申请房屋" :value="handleItem.buildingName+'/'+handleItem.unitName+'/'+handleItem.roomName" :disabled="true"></u-field>
					<u-field label="申请住户" :value="handleItem.ownerRealName" :disabled="true"></u-field>
					<u-field label="住户手机" :value="handleItem.phoneNum" :disabled="true"></u-field>
					<u-field label="申请类型" :value="handleItem.ownerType" :disabled="true"></u-field>
					<u-field label="申请时间" :value="handleItem.applyDate" :disabled="true"></u-field>
				</view>
				<view slot="foot" class="u-flex u-flex-nowrap u-row-around">
					<u-button type="success" shape="circle" @click="auditPass(handleItem)">审批通过</u-button>
					<u-button type="warning" shape="circle" @click="auditReject(handleItem)">审批驳回</u-button>
				</view>
			</u-card>
		</view>
		<!-- 信息提示 -->
		<view>
			<u-toast ref="uMsg"></u-toast>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				waitHandleList: [], //代办集合
			}
		},
		onLoad() {
			this.getWaitHandleList();
		},
		methods: {
			/* 获取代办集合数据 */
			getWaitHandleList() {
				const currentCommunity = uni.getStorageSync('current_community');
				if (currentCommunity) {
					this.$u.get('/handle/info/' + currentCommunity.communityId).then(res => {
						console.log('获取的待审批数据', res)
						if (res.code == 200) {
							this.waitHandleList = res.data.map(item => {
								switch (item.ownerType) {
									case 'yz':
										item.ownerType = '业主';
										break;
									case 'zh':
										item.ownerType = '租户';
										break;
									case 'qs':
										item.ownerType = '亲属';
										break;
									default:
										item.ownerType = '其他';
								}
								return item;
							});
						} else {
							this.$refs.uMsg.show({
								type: 'warning',
								title: res.msg
							})
						}
					})
				}
			},

			/* 审批通过 */
			auditPass(item) {
				let param = {};
				param.ownerRoomId = item.ownerRoomId
				param.pass = true;
				param.opinion = '同意';
				this.$u.post('/handle/audit', param).then(res => {
					if (res.code == 200) {
						let index = this.waitHandleList.indexOf(item);
						this.waitHandleList.splice(index, 1)
						this.$refs.uMsg.show({
							type: 'success',
							title: '审批通过'
						})
					} else {
						this.$refs.uMsg.show({
							type: 'warning',
							title: res.msg
						})
					}
				})
			},

			/* 审批驳回 */
			auditReject(item) {
				let param = {};
				param.ownerRoomId = item.ownerRoomId
				param.pass = false;
				param.opinion = '业主拒绝';
				this.$u.post('/handle/audit', param).then(res => {
					if (res.code == 200) {
						let index = this.waitHandleList.indexOf(item);
						this.waitHandleList.splice(index, 1)
						this.$refs.uMsg.show({
							type: 'success',
							title: '拒绝完成'
						})
					} else {
						this.$refs.uMsg.show({
							type: 'warning',
							title: res.msg
						})
					}
				})
			},
		}
	}
</script>

<style>

</style>
