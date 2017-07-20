<template>
	<div class="shanjia">
		  <div id="xuanqing">
                    <div class="xuanqing_list">
                        <img src="https://guojianwu02.github.io/waimai/images/dianhua.png" alt="">
                        <span>{{xuanqing.tell}}</span>
                        <!-- <span class="dayuhao"> &gt; </span> -->
                    </div>
                    <div class="xuanqing_list">
                        <img src="https://guojianwu02.github.io/waimai/images/dingwei.png" alt=""  style="width: 0.6rem">
                        <span>{{xuanqing.local}}</span>
                        <!-- <span class="dayuhao"> &gt; </span> -->
                    </div>
                    <div class="xuanqing_list">
                        <img src="https://guojianwu02.github.io/waimai/images/jishi.png" alt="" style="width: 0.5rem">
                        <span>配送时间:
                            <span>{{xuanqing.time}}</span>
                        </span>
                    </div>
                    <div class="xuanqing_list">
                        <img src="https://guojianwu02.github.io/waimai/images/peisong.png" alt="" style="width: 0.5rem">
                        <span>配送方式:
                            <span>{{xuanqing.method}}</span>
                        </span>
                    </div>
                </div>
	</div>
</template>
<script>
	export default{
		data(){
			return{
				xuanqing:{}
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
				this.$http.get('https://guojianwu02.github.io/waimai/data/xuanqing.json').then((res)=>{
						this.xuanqing=res.body.result;
                         this.$store.state.clickRouter=false;
					
				})
			}
		}
	}
</script>
<style>
	
#xuanqing .xuanqing_list{
    background: rgba(234, 234, 234, 0.52);
    margin-top: 0.2rem;
    vertical-align:middle;
    color: gray;
}

#xuanqing .xuanqing_list img{
    width: 0.8rem;
    vertical-align:middle;
    margin-left: 0.3rem;
}
#xuanqing .xuanqing_list span{
    font-size: 0.4rem;
    vertical-align:middle;
    margin-left: 0.3rem;
}
#xuanqing .xuanqing_list .dayuhao{
    display: inline-block;
    font-size: 0.6rem;
    color: gray;
    float: right;
    vertical-align:middle;

    margin: 3% 0.3rem;

}
</style>