<template>
	<u-popup mode="bottom" v-model="show" :mask="true" :closeable="true" :safe-area-inset-bottom="true" 
	 :mask-close-able="true" close-icon-color="#ffffff" @close="close">
		<u-tabs v-if="show" :list="getTabsList" :is-scroll="true" :current="tabsIndex" @change="tabsChange" ref="tabs"></u-tabs>
		<view class="multi-select-box">
			<view class="u-flex" :class="{'change':isChange}">
				<!-- 第一级 -->
				<view class="select-item">
					<view class="u-padding-10 u-bg-gray" style="height: 100%;">
						<scroll-view :scroll-y="true" style="100%">
							<u-cell-group>
								<u-cell-item v-for="item in firstList" :title="item.label" :arrow="false" :index="item.value" :key="item.value"
								 @click="firstChange">
									<u-icon v-if="isChooseFirst && firstValue === item.value" slot="right-icon" size="34" name="checkbox-mark"></u-icon>
								</u-cell-item>
							</u-cell-group>
						</scroll-view>
					</view>
				</view>
				<!-- 第二级 -->
				<view class="select-item">
					<view class="u-padding-10 u-bg-gray" style="height: 100%;">
						<scroll-view :scroll-y="true" style="100%">
							<u-cell-group v-if="isChooseFirst">
								<u-cell-item v-for="item in secondList" :title="item.label" :arrow="false" :index="item.value" :key="item.value"
								 @click="secondChange">
									<u-icon v-if="isChooseSecond && secondValue === item.value" slot="right-icon" size="34" name="checkbox-mark"></u-icon>
								</u-cell-item>
							</u-cell-group>
						</scroll-view>
					</view>
				</view>
				<!-- 第三级 -->
				<view class="select-item">
					<view class="u-padding-10 u-bg-gray" style="height: 100%;">
						<scroll-view :scroll-y="true" style="100%">
							<u-cell-group v-if="isChooseSecond">
								<u-cell-item v-for="item in thirdList" :title="item.label" :arrow="false" :index="item.value" :key="item.value"
								 @click="thirdChange">
									<u-icon v-if="isChooseThird && thirdValue === item.value" slot="right-icon" size="34" name="checkbox-mark"></u-icon>
								</u-cell-item>
							</u-cell-group>
						</scroll-view>
					</view>
				</view>
			</view>
		</view>
	</u-popup>
</template>

<script>
	export default {
		name: 'wyglMultiSelect',
		props: {
			showPopup:{
				type:Boolean,
				default:false
			},
			/* 第一列数据 */
			firstList: {
				type: Array,
				default: []
			},
			/* 第二列数据 */
			secondList: {
				type: Array,
				default: []
			},
			/* 第三列数据 */
			thirdList: {
				type: Array,
				default: []
			}

		},
		data() {
			return {
				tabsIndex: 0, //选项卡的索引
				isChooseFirst: false, //第一列是否选中
				isChooseSecond: false, //第二列是否选中
				isChooseThird: false, //第三列是否选中
				//firstList: [], //第一列的集合
				firstValue: '', //第一列选择的值
				//secondList: [], //第二列集合
				secondValue: '', //第二列选择的值
				//thirdList: [], //第三列集合
				thirdValue: '', //第三列选择的值
			}
		},
		computed: {
			show:{
				get:function(){
					return this.showPopup;
				},
				set:function(newValue){
					console.log('show的set',newValue)
				}
			},
			isChange() {
				return this.tabsIndex > 1;
			},
			getTabsList() {
				let tabsList = [{
					name: '请选择'
				}];
				if (this.isChooseFirst) {
					tabsList[0]['name'] = this.firstList.find(item => item.value === this.firstValue)['label']
					tabsList[1] = {
						name: '请选择'
					}
				}
				if (this.isChooseSecond) {
					tabsList[1]['name'] = this.secondList.find(item => item.value === this.secondValue)['label']
					tabsList[2] = {
						name: '请选择'
					}
				}
				if (this.isChooseThird) {
					tabsList[2]['name'] = this.thirdList.find(item => item.value === this.thirdValue)['label']
				}
				return tabsList;
			},
		},
		methods: {
			/* tab选项卡切换 */
			tabsChange(index) {
				this.tabsIndex = index;
			},
			/* 首列点击(其中value值为listItem中的value) */
			firstChange(value) {
				this.isChooseFirst = true;
				this.isChooseSecond = false;
				this.isChooseThird = false;
				this.firstValue = value;
				this.$emit('firstChange', this.firstValue); //暴露对外接口
				this.tabsIndex = 1;
			},
			/* 第二列点击 */
			secondChange(value) {
				this.isChooseSecond = true;
				this.isChooseThird = false;
				this.secondValue = value;
				this.$emit('secondChange', this.secondValue)
				this.tabsIndex = 2;
			},
			close(){
				console.log('关闭多选组件')
				this.$emit('close',false)
			},
			/* 第三次点击 */
			thirdChange(value) {
				this.isChooseThird = true;
				this.thirdValue = value;
				let result = {};
				result.first = this.firstList.find(item => item.value === this.firstValue);
				result.second = this.secondList.find(item => item.value === this.secondValue);
				result.third = this.thirdList.find(item => item.value === this.thirdValue);
				this.$emit('thirdChange', result);
				this.close()
			}
		},
	}
</script>

<style lang="scss">
	.multi-select-box {
		width: 100%;
		overflow: hidden;
		height: 800rpx;

		>view {
			width: 150%;
			transition: transform 0.3s ease-in-out 0s;
			transform: translateX(0);

			&.change {
				transform: translateX(-33.3333333%);
			}
		}

		.select-item {
			width: 33.3333333%;
			height: 800rpx;
		}
	}
</style>
