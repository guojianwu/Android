<template>
	<span class="caozuo">
		<span class="dec" v-show="good.maiCount!=0" @click="change(good,0);">－</span>
		<input type="text" value="1"  v-show="good.maiCount!=0"  class="count" disabled v-model="good.maiCount">
		<span class="add" @click="change(good,1);">＋</span>
	</span>
</template>
<script>
	export default{

			data(){
				return{
					zongCount:0
				}
			},
			// beforeCreate(){
 		// 		if(document.getElementById('zongshu').innerHTML==0){
			// 		document.getElementById('display').style.display='none'
			// 	}
			// },
			// mounted: function () {
			//  	 this.$nextTick(function () {
			//   		  if(document.getElementById('zongshu').innerHTML==0){
			// 			document.getElementById('display').style.display='none'
			// 		}
			// 	 })
			// },
			props:{
				good:{
					type:Object
				}
			},
			methods:{

				change(good,way){


					if(way===1){
						good.maiCount++;
						this.zongCount++;
						this.$store.state.zongJia++;
						this.$store.state.zongMoeny+=good.foodPrice;
						
						
						
					}else{
						good.maiCount--;
						this.zongCount--;
						this.$store.state.zongJia--;
						this.$store.state.zongMoeny-=good.foodPrice;
						

						if(this.$store.state.zongJia==0){
							this.$store.state.dialogVisible=false;
						}

						
					}
					if(this.$store.state.zongMoeny>=15 && this.$store.state.num==0){
						this.$store.state.jiesuan='去结算';
					}
				}
			}
	}
</script>
<style lang="less">
	.caozuo{
		float: right;
		text-align: center;
		.count{
			border: none;
			width: 0.55rem;
			color: gray;
			background: white;
			text-align: center;
			font-size: 0.50rem;
			
		}
		.dec{
			display: inline-block;
			width: 0.65rem;
			height: 0.65rem;
			line-height: 0.65rem;
			font-size: 0.5rem;
			border: 1px solid rgba(128, 128, 128, 0.73);
			border-radius: 50%;
		}
		.add{
			display: inline-block;
			width: 0.65rem;
			height: 0.65rem;
			line-height: 0.65rem;
			font-size: 0.5rem;
			border: 1px solid rgba(128, 128, 128, 0.73);
			border-radius: 50%;

			background: #00d0ff;
			color: white;

		}
	}
	

	

</style>