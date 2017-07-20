<template>
	<div class="goods">
		<goodsLeft :goods="goods"></goodsLeft>
		<goodsRight :goods="goods"></goodsRight>
	</div>
</template>
<script>
	import goods_left from './goods_left/goods_left.vue'
	import goods_right from './goods_right/goods_right.vue'
	export default{
		
		data(){
			return{
				goods:{}
			}
		},
		
		mounted() {
			var _this=this;
		    this.$nextTick(function () {
		    	_this.showData();

		    	
			})
		},

		methods:{
			showData(){
				this.$http.get('https://guojianwu02.github.io/waimai/data/diancan.json').then((res)=>{
						this.goods=res.body.result;
						this.$store.state.foodData=res.body.result;

						this.$emit('dianChe',this.goods);
						 this.$store.state.clickRouter=true;
						//console.log(this.goods);
				})
			}
		},
		components:{
			'goodsLeft':goods_left,
			'goodsRight':goods_right
		}
	}

</script>
<style lang="less" scoped>
	.goods{
		margin-bottom: 1rem;
		
	}
</style>