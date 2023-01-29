<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
			/* const ownerInfo = uni.getStorageSync('ownerInfo');
			if(ownerInfo){
				this.$u.route({
					type:'tab',
					url:'pages/index/index'
				})
			}else{
				this.$u.route({
					type:'redirect',
					url:'pages/login/login'
				})
			} */
			this.$u.route({
				type:'tab',
				url:'pages/index/index'
			})
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style lang="scss">
	/*每个页面公共css */
	@import "uview-ui/index.scss";
</style>
