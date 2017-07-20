<template>
	<div class="goods_left">
        <ul>
            <li v-for="good in goods">
                <a :href="good[0].setHref">{{good[0].foodType}}</a>
            </li>
        </ul>
	</div>
</template>
<script>
	export default{
			props:{
				goods:{
					type:Object
				}
			}
	}
</script>

<style lang="less" scoped>
	.goods_left{
		width: 30%;
		height: 18rem;
		display: inline-block;
		background: rgb(234, 234, 234);
		float: left;
		overflow: scroll;
		&::-webkit-scrollbar{
			display: none;
		}
		ul{
			font-size: 0.45rem;
			
			li{
				text-align: center;
				height: 1.7rem;
				line-height: 1.7rem;
				border-bottom: #cccccc 1px dashed;
				a{
					text-decoration: none;
					color: gray;
				}
			}
		}
		

	}

	// #left::-webkit-scrollbar , #right::-webkit-scrollbar, .gouwuche::-webkit-scrollbar{
 //   			 display: none;
	// 	}
// }
</style>