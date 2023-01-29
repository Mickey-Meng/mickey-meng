<template>
	<view class="familyPage">
		<view v-if="familyList.length==0">
			<u-empty text="暂无成员信息" mode="data"></u-empty>
		</view>
		<view v-if="familyList.length>0">
			<u-card title="住户卡" :sub-title="familyItem.buildingName+'/'+familyItem.unitName+'/'+familyItem.roomName" v-for="(familyItem,index) in familyList"
			 :key="index" :showFoot="false">
				<view slot="body">
					<view class="memberItem" v-for="(memberItem,idx) in familyItem.members" :key="idx">
						<u-field :label="memberItem.ownerType" :value="memberItem.realName" :disabled="true">
							<u-button size="mini" slot="right" type="warning" v-if="memberItem.canUnBind" @click="unBind(memberItem.ownerId,familyItem.roomId)">解绑</u-button>
						</u-field>
					</view>
				</view>
			</u-card>
			<view>
				<u-modal v-model="showTips" title="解绑确认单" content="解绑确认后不可恢复,请确认后操作!" :show-cancel-button="true" @confirm="confirmUnbind"></u-modal>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				familyList: [], //家庭成员信息
				ownerId: '', //业主Id
				roomId: '', //房间Id
				showTips: false, //展示模态框
			}
		},
		onLoad() {
			this.getFamilyInfo();
		},
		methods: {
			/* 获取家庭成员信息 */
			getFamilyInfo() {
				let currentCommunity = uni.getStorageSync('current_community');
				this.$u.get('/family/info/' + currentCommunity.communityId).then(res => {
					if (res.code == 200) {
						this.familyList = res.data.map(item => {
							item.members = item.members.map(member => {
								switch (member.ownerType) {
									case 'yz':
										member.ownerType = '业主';
										break;
									case 'zh':
										member.ownerType = '租户';
										break;
									case 'qs':
										member.ownerType = '亲属';
										break;
									default:
										member.ownerType = '其他';
								}

								return member;
							})

							return item;
						})
					} else {
						this.familyList = [];
						this.$u.toast(res.msg)
					}
				})
			},
			/* 解绑 */
			unBind(ownerId, roomId) {
				console.log('解绑的用户、房屋', ownerId, roomId)
				this.ownerId = ownerId;
				this.roomId = roomId;
				this.showTips = true;
			},
			confirmUnbind() {
				this.$u.delete('/family/unBind/' + this.roomId + '/' + this.ownerId).then(res => {
					console.log('解绑信息', res)
					if (res.code == 200) {
						this.$u.toast('解绑成功');
						this.getFamilyInfo();
					} else {
						this.$u.toast(res.msg)
					}
				})
			}
		}
	}
</script>

<style lang="scss">

</style>
