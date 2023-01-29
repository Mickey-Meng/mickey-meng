<template>
	<view class="servicePhone">
		<u-index-list :scroll-top="scrollTop" :index-list="indexList">
			<view v-for="(headItem,index) in typeDataList" :key="index">
				<u-index-anchor :use-slot="true">
					<text class="anchor-text">{{headItem.letter}}</text>
				</u-index-anchor>
				<view v-for="(phoneItem,idx) in headItem.data" class="list-cell" @click="callPhone(phoneItem)" :key="idx">
					{{phoneItem.name}}
				</view>
			</view>
		</u-index-list>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				scrollTop: 0,
				typeDataList: [],
				indexList:[]
			}
		},
		onLoad() {
			this.initTypeDataList();
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop;
		},
		methods: {
			initTypeDataList() {
				this.typeDataList = [{
						letter: '求助服务',
						data: [{
								name: '匪警',
								tel: '110'
							}, {
								name: '火警',
								tel: '119'
							}, {
								name: '急救中心',
								tel: '120'
							},
							{
								name: '道路交通事故',
								tel: '122'
							},
							{
								name: '水上求助',
								tel: '12395'
							},
							{
								name: '天气预报',
								tel: '12121'
							},
							{
								name: '报时服务',
								tel: '12117'
							},
							{
								name: '森林火警',
								tel: '12119'
							},
							{
								name: '红十字会急救台',
								tel: '999'
							},
							{
								name: '通用紧急求救',
								tel: '112'
							}
						]
					},
					{
						letter: '通讯服务',
						data: [{
							name: '电信综合服务',
							tel: '10000'
						}, {
							name: '电信手机服务',
							tel: '10001'
						}, {
							name: '联通客服热线',
							tel: '10010'
						}, {
							name: '移动客户热线',
							tel: '10086'
						}, {
							name: '中国铁通服务热线',
							tel: '10050'
						}, {
							name: '电话号码查询',
							tel: '114'
						}]
					},
					{
						letter: '铁路航空服务',
						data: [{
							name: '铁路',
							tel: '12306'
						}, {
							name: '国航',
							tel: '95583'
						}, {
							name: '海航',
							tel: '950718'
						}, {
							name: '南航',
							tel: '4006695539'
						}, {
							name: '东航',
							tel: '95530'
						}, {
							name: '深航',
							tel: '95080'
						}, {
							name: '厦航',
							tel: '95557'
						}, {
							name: '山航',
							tel: '4006096777'
						}, {
							name: '川航',
							tel: '4008300999'
						}]
					},
					{
						letter: '银行机构服务',
						data: [{
							name: '中国银行',
							tel: '95566'
						}, {
							name: '交通银行',
							tel: '95559'
						}, {
							name: '中国银联',
							tel: '95516'
						}, {
							name: '招商银行',
							tel: '95555'
						}, {
							name: '农业银行',
							tel: '95599'
						}, {
							name: '民生银行',
							tel: '95568'
						}, {
							name: '建设银行',
							tel: '95533'
						}, {
							name: '邮政储蓄',
							tel: '95580'
						}]
					}
				];
			},
			
			//拨打电话
			callPhone(item){
				uni.makePhoneCall({
					phoneNumber:item.tel
				})
			},
		}
	}
</script>

<style lang="scss" scoped>
	.list-cell {
		display: flex;
		box-sizing: border-box;
		width: 100%;
		padding: 10px 24rpx;
		overflow: hidden;
		color: $u-content-color;
		font-size: 14px;
		line-height: 24px;
		background-color: #fff;
	}

	.anchor-text {}
</style>
