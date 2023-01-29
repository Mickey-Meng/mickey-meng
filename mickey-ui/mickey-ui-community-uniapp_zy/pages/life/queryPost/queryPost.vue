<template>
	<view class="queryPostPage">
		<u-search placeholder="请输入订单号" :clearabled="true" @search="findOrderInfo" :show-action="false"></u-search>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				orderNum:'',
			}
		},
		methods: {
			findOrderInfo(val){
				console.log('输入框的值',val)
			},
		}
	}
</script>

<style lang="scss">
.queryPostPage{
	padding: 30rpx;
}
</style>
