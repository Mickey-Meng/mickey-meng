<template>
	<view class="showCardPage">
		<view v-if="userCardList.length==0">
			<u-empty text="暂无身份信息" mode="data"></u-empty>
		</view>
		<view v-if="userCardList.length>0">
			<u-card v-for="cardItem in userCardList" :key="cardItem.hourseCode" :title="cardItem.userType" :sub-title="cardItem.ownerName">
				<!-- 卡片体 -->
				<view class="cardBody" slot="body">
					<u-field v-model="cardItem.floor" :disabled="true" label="楼栋"></u-field>
					<u-field v-model="cardItem.unit" :disabled="true" label="单元"></u-field>
					<u-field v-model="cardItem.hourseCode" :disabled="true" label="房号"></u-field>
				</view>
				<!-- 卡片底部 -->
				<view class="cardFoot u-flex u-flex-nowrap u-row-around" slot="foot">
					<u-button @click="handleCode(cardItem)" type="success" shape="circle">身份二维码</u-button>
					<u-button type="error" shape="circle" :disabled="cardItem.userType=='业主'" @click="changeIdentify(cardItem)">变更我身份</u-button>
				</view>
			</u-card>
			<!-- 弹出二维码 -->
			<view>
				<u-modal v-model="showModal" title="身份二维码" :title-style="{padding:'30rpx'}" :content-style="{'text-align':'center'}"
				 @confirm="handleBarCode">
					<tki-qrcode cid="qrCode" :val="qrVal" ref="qrCode" :onval="true" @result="qrResult"></tki-qrcode>
				</u-modal>
			</view>
			<!-- 弹出切换类型 -->
			<view>
				<u-select v-model="showType" :list="typeList" @confirm="confirmType"></u-select>
				<u-modal v-model="showConfirm" title="身份变更确认" content="变更身份是不可逆操作,请确认后操作!" :show-cancel-button="true" @confirm="confirmChange"></u-modal>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				userCardList: [], //用户身份卡
				showModal: false,
				qrVal: '', //二维码的数据
				changeType: '', //切换的身份
				changeItem: {}, //切换对象
				showType: false, //展示身份类型
				typeList: [{
						label: '业主',
						value: 'yz'
					},
					{
						label: '租户',
						value: 'zh'
					},
					{
						label: '亲属',
						value: 'qs'
					},
					{
						label: '其他',
						value: 'qt'
					}
				], //身份类型
				showConfirm: false, //展示确认
			}
		},
		computed: {

		},
		onLoad() {
			this.getUserCardList();
		},
		methods: {
			//获取用户身份卡
			getUserCardList() {
				const currentCommunity = uni.getStorageSync('current_community');
				this.$u.get('/card/info/' + currentCommunity.communityId).then(res => {
					console.log('获取的信息', res.data)
					if (res.code == 200) {
						this.userCardList = res.data.map(item => {
							let card = {};
							card.floor = item.buildingName;
							card.unit = item.unitName;
							card.hourseCode = item.roomName;
							card.ownerRoomId = item.ownerRoomId;
							switch (item.ownerType) {
								case 'yz':
									card.userType = '业主';
									break;
								case 'zh':
									card.userType = '租户';
									break;
								case 'qs':
									card.userType = '亲属';
									break;
								default:
									card.userType = '其他';
							}
							card.ownerName = item.ownerRealName;
							return card;
						})
					} else {
						this.$u.toast(res.msg)
					}
				})

			},

			//展示二维码
			handleCode(cardItem) {
				this.showModal = true;
				this.qrVal = cardItem.ownerName + ":" + cardItem.hourseCode;
				this.$refs.qrCode._makeCode()
			},
			qrResult(res) {
				console.log('二维码信息', res)
			},
			//清空二维码
			handleBarCode() {
				console.log('清空二维码')
				this.$refs.qrCode._clearCode()
			},

			/* 切换身份 */
			changeIdentify(item) {
				console.log('切换的对象', item)
				this.changeItem = item;
				this.showType = true;
			},
			/* 确认选择切换类型 */
			confirmType(e) {
				this.changeType = e[0].value;
				console.log('切换的身份', this.changeType)
				//this.showType = false;
				this.showConfirm = true;
			},
			confirmChange() {
				let param = {};
				param.ownerRoomId = this.changeItem.ownerRoomId
				param.ownerType = this.changeType
				this.$u.post('/card/change', param).then(res => {
					console.log('切换身份返回数据', res)
					if (res.code == 200) {
						this.getUserCardList();
					} else {
						this.$u.toast(res.msg);
					}
				})
			},

		}
	}
</script>

<style lang="scss">
	.showCardPage {
		.cardBody {}

		.cardFoot {}

		.barCodeView {

			text-align: center;
		}
	}
</style>
