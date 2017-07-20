<template>
	<div id="dialog_gouwuche">
			<el-dialog
			  title="购物车"
			  :visible.sync="dialogVisible"
			  size="tiny"
			  :modal="false"
			  :before-close="handleClose"
			 >
			  <div class="content">
			  	<ul>
    
			  		<li v-for="type in foodData">
				  		<div class="list" v-for="good in type[0].list" v-show="good.maiCount!=0">
				  			 <span class="name">{{good.foodName}}</span>
				  		    <caozuo :good="good"></caozuo>
				  		</div>
			  		</li>
			  	</ul>
			  </div>
			 
            </el-dialog>
		</div>
</template>
<script>
import caozuo from '../caozuo/caozuo.vue'
	export default{
		data(){
			return{
				//dialogVisible: true,
				isShowChe:false
			}
		},
		computed:{
			foodData(){
				return this.$store.state.foodData;
			},
			dialogVisible(){
				return this.$store.state.dialogVisible;
			}
		},
		methods:{
		 handleClose(done) {
	        this.$store.state.dialogVisible=false;
	      }
		},
		
		components:{
			caozuo
			
		}
	}

</script>

<style lang="less" >
	#dialog_gouwuche{
		
		.content{
			height: 8rem;
			overflow: scroll;
			&::-webkit-scrollbar{
		    	display: none;
		    }
			ul{
				clear: both;
			}
			li{
				
				clear: both;
				// height: 1rem;
				// line-height: 1rem;
				
				.list{
					clear: both;
					border-bottom: 1px solid gray;
					.name{
						font-size: 0.4rem;
						text-align: left;
						display: inline-block;
						width: 60%;
						padding-left: 0.1rem;
						overflow: hidden;
					    white-space: nowrap;
					    text-overflow: ellipsis;
					}
					.caozuo{
						margin-right: 0.15rem;
					}
				}

				
			}
			
		}
	}




#dialog_gouwuche .el-dialog__body{
    font-size: 0.5rem;
    padding: 0px;
    margin: 0px;
  

}
#dialog_gouwuche .el-dialog--small {
    width: 94%;
}
#dialog_gouwuche .el-dialog__header {
    margin: 0;
    border-bottom: 1px solid gray;
    height: 1.1rem;
    text-align: left;
    

}
#dialog_gouwuche .el-dialog__title {
    line-height: 1;
    font-size: 0.55rem;
    font-weight: 100;
    color: #1f2d3d;
}
.el-dialog--tiny {
    width: 90%;
}

</style>