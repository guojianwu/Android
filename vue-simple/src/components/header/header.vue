<template>
	<div class="header">
		<div class="userImg">
			<img src="https://guojianwu02.github.io/waimai/images/test.jpg" alt="">
		</div>
		<div class="text">
			<span class="name">603外卖</span>
			<span class="gaozhi">告知:只送火炬职院宿舍楼下</span>
		</div>
		
		
	</div>
</template>
<script>
	export default{
		
	}
</script>
<style lang="less">
*{
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}
	.header{

		.userImg{
			display: inline-block;
			vertical-align: top;
			text-align: center;
		
			padding: 0.3rem;
			img{
				width: 1.7rem;
				border-radius: 50%;
				vertical-align:middle;
			}
		}
		.text{
			display: inline-block;
			font-size: 0;
			margin-top: 0.4rem;

			.name{
		    	font-size: 0.55rem;	
		    	// vertical-align: top;
		    	display: block;

		    }	
		    .gaozhi{
		    	font-size: 0.2rem;	
		    	color: #00d0ff;
		    }
		}
	    
	}
</style>