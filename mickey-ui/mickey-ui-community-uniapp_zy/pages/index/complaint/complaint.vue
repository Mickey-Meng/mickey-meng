<template>
	<view class="complaintPage">
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
				indexList: []
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
					letter: '投诉热线',
					data: [{
						name: '消费者申诉举报',
						tel: '12315'
					}, {
						name: '价格监督',
						tel: '12358'
					}, {
						name: '质量监督',
						tel: '12365'
					}, {
						name: '环保监督',
						tel: '12369'
					}, {
						name: '税务',
						tel: '12366'
					}, {
						name: '市长热线',
						tel: '12345'
					}, {
						name: '公共卫生',
						tel: '12320'
					}, {
						name: '电信投诉',
						tel: '12300'
					}, {
						name: '妇女维权',
						tel: '12338'
					}, {
						name: '法律援助',
						tel: '12351'
					}, {
						name: '劳动保障',
						tel: '12333'
					}]
				}];
			},

			//拨打电话
			callPhone(item) {
				uni.makePhoneCall({
					phoneNumber: item.tel
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
</style>
