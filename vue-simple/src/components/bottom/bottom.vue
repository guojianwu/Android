<template>
	<div class="bottom">
		<div class="bottom_left">
			<div class="che" @click="showChe"  v-show="!clicktijiao">
				<img src="https://guojianwu02.github.io/waimai/images/gouwuche.png" alt="">
				
			</div>
			<div class="count" id="display"  @click="showChe"  v-show="zongJia!=0 && !clicktijiao">
				<span id="zongshu" >{{zongJia}}</span>
			</div>
			
			{{peiSong}}
		</div>
		<div class="from" @click="form">
			{{tijiao}}
		</div>

		
		<gouwuche></gouwuche>
		<jiesuan></jiesuan>
		

	</div>
</template>

<script>
import gouwuche from '../gouwuche/gouwuche.vue'
import jiesuan from '../jiesuan/jiesuan.vue'
	export default{
		data(){
			return{
				//num:0
			}
		},
		computed:{
			zongJia(){
				return this.$store.state.zongJia;
			},
			peiSong(){
				return this.$store.state.zongMoeny==0?'免费配送' : '总价:'+this.$store.state.zongMoeny+'元';
			},
			tijiao(){
				//this.$store.state.jiesuan='去结算';
				return this.$store.state.zongMoeny>=15?this.$store.state.jiesuan:'15元起送';
			},
			clicktijiao(){
	       		 return this.$store.state.tijiao;
	      	}
		},
		methods:{
			showChe(){

				if(this.$store.state.zongJia==0){
					this.$store.state.dialogVisible=false;
					return;
				}

				this.$store.state.dialogVisible=!this.$store.state.dialogVisible;
			
			},
			form(){
				if(this.$store.state.zongMoeny>=15){
					this.$store.state.tijiao=true;
					this.$store.state.num++;
				}
				if(this.$store.state.num>=1){
					this.$store.state.jiesuan='提交订单'
					
				}
				if(this.$store.state.num>1 && this.$store.state.disform==1){
					this.$store.state.dialogVisible1=true;
				}
				
			}
		},
		components:{
			gouwuche,
			jiesuan
		}
	}
</script>


<style lang="less">
	li{
		list-style: none;
	}
	.bottom{

		position: fixed;
		width: 100%;
		bottom:0;
		left: 0;
		font-size: 0;
		// text-align: center;
	    height: 1.3rem;
	    line-height: 1.3rem;
	    background: white;
		font-family: '微软雅黑';
		border-top: 1px solid gray;
		
		.bottom_left{
			text-align: center;
			display: inline-block;
			font-size: 0.5rem;
			width: 65%;
			img{
				width: 1.3rem;
				position: fixed;
				left: 0.3rem;
				bottom: 0.3rem;
				background: #00d0ff;
				border-radius: 50%;
				padding: 0.2rem ;
			}
			.count{
				position: fixed;
				left: 1.1rem;
				bottom:1.1rem;
				width: 0.55rem;
				border-radius: 50%;
				height: 0.55rem;
				line-height: 0.55rem;
				font-size: 0.3rem;
				color: white;
				background: orange;
				
			}
		}
		.from{
			width: 35%;
			display: inline-block;
			font-size: 0.5rem;
			background: orange;
		    color: white;
		    text-align: center;
   			
		}
	}	




	



</style>