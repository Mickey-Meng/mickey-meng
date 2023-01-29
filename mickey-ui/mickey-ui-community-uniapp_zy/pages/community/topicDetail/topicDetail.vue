<template>
	<view class="wrap">
		<view class="comment">
			<view class="top">
				<view class="left">
					<view class="heart-photo">
						<image :src="interaction.avatar" mode=""></image>
					</view>
					<view class="user-info">
						<view class="name">{{ interaction.nickname }}</view>
						<view class="date">{{interaction.createTime}}</view>
					</view>
				</view>
				<!-- <view class="right" :class="{ highlight: comment.isLike }">
					{{ comment.likeNum }}
					<u-icon v-if="!comment.isLike" name="thumb-up" class="like" color="#9a9a9a" :size="30" @click="getLike"></u-icon>
					<u-icon v-if="comment.isLike" name="thumb-up-fill" class="like" :size="30" @click="getLike"></u-icon>
				</view> -->
			</view>
			<view class="content">{{ interaction.content }}</view>
			<view class="contentImg">
				<view v-for="imgItem in interaction.imageUrls" :key="imgItem.fileId" class="imgDetail">
					<u-image :src="imgItem.fileUrl" width="80rpx" height="80rpx" @click="showPicDetail(imgItem.fileUrl)"></u-image>
				</view>
				<view class="mask">
					<u-mask :show="showMask" @click="showMask=false">
						<u-image :src="maskUrl" width="100%" height="100%" mode="aspectFit"></u-image>
					</u-mask>
				</view>
			</view>
			<view class="hf" @click="hfInteraction('-1','',interaction.nickname)">
				<u-icon name="chat"></u-icon>
				<text class="hfText">回复</text>
			</view>
		</view>
		<view class="all-reply">
			<view class="all-reply-top">全部回复</view>
			<view class="item" v-for="(item, index) in commentList" :key="index">
				<view class="comment">
					<view class="top">
						<view class="left">
							<view class="heart-photo">
								<image :src="item.createAvatar" mode=""></image>
							</view>
							<view class="user-info">
								<view class="name">{{ item.createNickname }}</view>
								<view class="date">{{ item.createTime }}</view>
							</view>
						</view>
					</view>
					<view class="content" @click="hfInteraction(item.commentId,item.commentId,item.createNickname)">{{ item.comment }}</view>
					<view class="reply" v-if="item.children.length>0">
						<view class="replayItem" v-for="replayItem in item.children" :key="replayItem.commentId">
							<view class="username">{{ replayItem.createNickname }} 回复 {{replayItem.parentUserNickname}}
							                 ({{replayItem.createTime}})</view>
							
							<view class="text" @click="hfInteraction(replayItem.commentId,item.commentId,replayItem.createNickname)">{{ replayItem.comment }}</view>
						</view>
					</view>

				</view>
			</view>
		</view>
		<view class="replayText">
			<u-field v-model="replayText" type="text" :fixed="true" :placeholder="placeholderText" icon="zhuanfa" label-width="0" :focus="focusInput"
			 :confirm-type="confirmType" @confirm="postComment"></u-field>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				showMask:false,
				maskUrl:'',
				confirmType:'发送',
				placeholderText: '在这里说点什么吧',
				commentByNickname: '',
				replayText: '', //回复内容
				focusInput: false,
				parentId: '-1', //父级Id
				rootId: '',
				commentList: [],
				interaction: {},
				interactionId: '', //互动Id
				ownerInfo: {},
			};
		},
		onLoad(source) {
			console.log('接收的参数', source)
			this.interactionId = source.id;
			this.ownerInfo = uni.getStorageSync('ownerInfo');
			this.getReply();
			this.getInteractionInfo();
			
		},
		methods: {
			showPicDetail(url){
				this.maskUrl = url;
				this.showMask = true;
			},
			getInteractionInfo() {
				this.$u.get('/interaction/detail/' + this.interactionId).then(res => {
					if (res.code == 200) {
						this.interaction = res.data;
					} else {
						this.$u.toast('网络异常,请稍后再试')
					}
				})
			},

			//回复交互内容
			hfInteraction(parentId, rootId, nickname) {
				this.parentId = parentId;
				this.rootId = rootId;
				this.commentByNickname = nickname;
				if(this.parentId=='-1'){
					this.placeholderText = '在这里说点什么吧'
				}else{
					this.placeholderText = '回复 ' + nickname;
				}
				
				this.focusInput = true;

			},
			/* 发布评论 */
			postComment() {
				let param = {};
				param.interactionId = this.interactionId;
				param.parentId = this.parentId == '' ? '-1' : this.parentId;
				param.content = this.replayText;
				param.rootId = this.rootId;
				this.$u.post('/interaction/comment', param).then(res => {
					if (res.code == 200) {
						this.$u.toast('评论成功')
						if (param.parentId == '-1') {
							this.commentList.push({
								commentId: res.data.commentId,
								parentId: res.data.parentId,
								rootId: res.data.rootId,
								createTime: res.data.createTime,
								comment: res.data.content,
								createNickname: this.ownerInfo.nickName,
								createAvatar: this.ownerInfo.avatar
							})
						} else {
							let children = this.commentList.find(item => item.commentId == param.rootId).children;
							if (!children) {
								this.$set(this.commentList.find(item => item.commentId == param.rootId), 'children', [])
							}
							this.commentList.find(item => item.commentId == param.rootId).children.push({
								createNickname: this.ownerInfo.nickName,
								parentUserNickname: this.commentByNickname,
								commentId: res.data.commentId,
								comment: res.data.content,
								createTime:res.data.createTime
							})

						}
						this.replayText = '';
						this.placeholderText = '在这里说点什么吧'
					} else {
						this.$u.toast(res.msg)
					}
				})

			},
			// 回复列表
			getReply() {
				this.$u.get('/interaction/allComments/' + this.interactionId).then(res => {
					this.commentList = res.data;
				})

			}
		}
	};
</script>

<style lang="scss" scoped>
	page {
		background-color: #f2f2f2;
	}

	.comment {
		padding: 30rpx;
		font-size: 32rpx;
		background-color: #ffffff;

		.contentImg {
			display: flex;
			flex-direction: row;
			flex-wrap: wrap;

			.imgDetail {
				margin-top: 15rpx;
				margin-left: 15rpx;
			}
		}

		.hf {
			display: flex;
			flex-direction: row;
			justify-content: flex-end;
			margin-top: 20rpx;

			.hfText {
				color: #606266;
				font-size: 28rpx;
			}
		}

		.top {
			display: flex;
			justify-content: space-between;
		}

		.left {
			display: flex;

			.heart-photo {
				image {
					width: 64rpx;
					height: 64rpx;
					border-radius: 50%;
					background-color: #f2f2f2;
				}
			}

			.user-info {
				margin-left: 10rpx;

				.name {
					color: #606266;
					font-size: 28rpx;
					margin-bottom: 4rpx;
				}

				.date {
					font-size: 20rpx;
					color: $u-light-color;
				}
			}
		}

		.right {
			display: flex;
			font-size: 20rpx;
			align-items: center;
			color: #9a9a9a;

			.like {
				margin-left: 6rpx;
			}

			.num {
				font-size: 26rpx;
				color: #9a9a9a;
			}
		}

		.highlight {
			color: #5677fc;

			.num {
				color: #5677fc;
			}
		}
	}

	.all-reply {
		margin-top: 10rpx;
		padding-top: 20rpx;
		background-color: #ffffff;

		.all-reply-top {
			margin-left: 20rpx;
			padding-left: 20rpx;
			border-left: solid 4rpx #5677fc;
			font-size: 30rpx;
			font-weight: bold;
		}

		.item {
			border-bottom: solid 2rpx $u-border-color;
		}

		.reply {
			padding: 20rpx;
			background-color: rgb(242, 242, 242);
			border-radius: 12rpx;
			margin: 10rpx 0;

			.username {
				font-size: 24rpx;
				color: #7a7a7a;
			}
		}
	}
	.replayText {
		position: fixed;
		bottom: 5rpx;
		z-index: 999;
		width: 100%;
		box-shadow: 0rpx 0rpx 2px rgb(210, 200, 242);
	}
</style>
