<template>
	<div class="goods_right">
		<ul>
			<li v-for="type in goods">
			    <span class="type" :id="type[0].setId" >{{type[0].foodType}}</span> 
				<ul class="list">
					<li v-for="good in type[0].list">
						<div class="foodImg">
							<img src="https://guojianwu02.github.io/waimai/images/test.jpg" alt="">
						</div>
						<div class="foodInfo">
							<div foodName>
								{{good.foodName}}
							</div>
							<div class="center">
								<span class="yue">月销  <span>{{good.monthCount}}</span></span>
								<span class="zan"> 赞  <span>{{good.zanCount}}</span></span>
							</div>
							<div class="footer">
								<span class="bottom_moeny">￥{{good.foodPrice}}</span>
								<span class="caozuo"><caozuo :good="good"></caozuo></span>
							</div>
						</div>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</template>
<script>
 import caozuo from '../../caozuo/caozuo.vue'
	export default{
		
		props:{
			goods:{
				type:Object
			}
		},
		methods:{
			
		},
		components:{
			caozuo
		}
	}
</script>
<style lang="less" scoped>

	.goods_right{
		width: 70%;
		height: 18rem;
		display: inline-block;
		// background: green;
		overflow: scroll;
		li{
			display: block;
			clear: both;
		}
		&::-webkit-scrollbar{
			display: none;
		}
		ul{
			font-size: 0;
		}
		.type{
			// border: 1px solid black;
		    background: rgb(234, 234, 234);
		    display: block;
		    font-size: 0.3rem;
	        line-height: 0.7rem;
		    height: 0.7rem;
		
		}

		.foodImg{
			img{
			    width: 30%;
    			float: left;
    			margin: 0.1rem;
			}
		}
		.foodInfo{
			font-size: 0.44rem;
			.center{
				font-size:0.4rem; 
				margin-top: 0.1rem;
				color: grey;
				.yue{
					margin-right: 0.2rem;
				}
			}
		}
		.footer{	
			margin-top: 0.1rem;
			margin-bottom: 0.2rem;
			.bottom_moeny{
			    font-size: 0.5rem;
   				color: #00d0ff;
			}
			.caozuo{
				margin-right: 0.1rem;
			}
		}

	}
</style>