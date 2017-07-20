<template>
	    <div id="pingjia">
                  <div class="gray"></div>
                  <div id="pingfen">
                      <div class="pingfen_zh">
                         <div class="fen">{{(value1+value2)/2 |pingfen}}</div>
                         <div class="zhonghe">综合评分</div>
                         <div class="haopinglv">商家好评率{{(value1+value2)*10 |pingfen}}%</div>
                      </div>
                      <div class="pingfen_peisong">
                          <div class="box">
                              <div  class="text">配送评分：</div>
                              <div class="wuxing">
                                  <el-rate v-model="value1" disabled  text-color="#ff9900" text-template="{value}">
                                  </el-rate>
                              </div>
                          </div>
                          <div class="box">
                              <div  class="text">商家评分：</div>
                              <div class="wuxing">
                                  <el-rate v-model="value2" disabled text-color="#ff9900" text-template="{value}">
                                  </el-rate>
                              </div>
                          </div>
                      </div>
                  </div>
                    <div class="gray"></div>
                    <div id="pingjia_list">
                        <ul>
                            <li class="list_li" v-for="pj in pingjia">
                                <div class="left">
                                    <img src="https://guojianwu02.github.io/waimai/images/test.jpg" alt="" class="userImg">
                                </div>
                                <div class="right">
                                    <div class="top">
                                        <span class="username">{{pj.userName}}</span>
                                        <span class="date">{{pj.date}}</span>
                                    </div>
                                    <div class="center">
                                        <div class="wuxing">
                                            <el-rate v-model="pj.score" disabled text-color="#ff9900" text-template="{value}">
                                            </el-rate>
                                        </div>
                                        <span>{{pj.songda}}<span>分钟送达</span></span>
                                        <div class="text">{{pj.text}}</div>
                                        <div class="images">

                                                 <img v-for="image in pj.images[0]" src="https://guojianwu02.github.io/waimai/images/test.jpg" alt="">


                                            <!--<img src="images/test.jpg" alt="">-->
                                        </div>

                                    </div>
                                </div>


                            </li>
                        </ul>
                        
                    </div>
                    

                </div>
</template>
<script>
	export default{
		data(){
			return{
				pingjia:{},
				value1: 0,
                value2: 0,
			}
		},
		 filters:{
            
            pingfen:function(value){
                return value.toFixed(1);
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
				this.$http.get('https://guojianwu02.github.io/waimai/data/pingjia.json').then((res)=>{
						this.pingjia=res.data.result.userInfo;
						this.value1=res.data.result.value1;
            this.value2=res.data.result.value2;
						// console.log(this.pingjia);
            this.$store.state.tijiao=false;
            this.$store.state.num=0;
            //this.$store.state.jiesuan='15元起送';
            this.$store.state.disform=1;
            this.$store.state.zongJia=0;
            this.$store.state.zongJia=0;
            this.$store.state.zongMoeny=0;
            this.$store.state.clickRouter=false;

					
				})
			}
		}
	}
</script>
<style>
	#pingjia .gray{
    height: 0.4rem;
    background: rgba(211, 211, 211, 0.28);
    border-top: 1px solid darkgray;
    border-bottom: 1px solid darkgray;
}
#pingfen{
    font-size: 0;
    background: white;

}
#pingfen .pingfen_zh{
    text-align: center;
    width: 37%;
    border-right: 1px solid gray;
    display: inline-block;

}
#pingfen .pingfen_zh .fen{
    color: orange;
    font-size: 0.9rem;
    margin-top: 0.2rem;
}
#pingfen .pingfen_zh .zhonghe{
    font-size: 0.5rem;
    margin-top: 0.1rem;
}
#pingfen .pingfen_zh .haopinglv{
    font-size: 0.4rem;
    color: darkgrey;
    margin-top: 0.1rem;
    margin-bottom: 0.35rem;
}
#pingfen .pingfen_peisong {
    width: 63%;
    float: right;
    padding-left: 2%;
}
#pingfen .pingfen_peisong .text{
    float: left;
    font-size: 0.4rem
}

#pingfen .pingfen_peisong .box{
    margin-top: 0.65rem;
}
#pingjia_list .list_li{
    font-size: 0.45rem;
    clear: both;
    border-bottom: 1px solid gray;
}
#pingjia_list .list_li .left{
    width: 20%;
    text-align: center;
    float: left;
}
#pingjia_list .list_li .left img{
    width: 1.3rem;
    border-radius: 50%;
    padding: 0.3rem 0;

}
#pingjia_list .list_li .right{
    width: 80%;
    float: right;
    padding: 0.3rem 0;
}
#pingjia_list .list_li .right .top .username{
    font-size: 0.45rem;
    font-weight: bold;
}
#pingjia_list .list_li .right .top .date{
    float: right;
    font-size: 0.4rem;
    padding: 0 0.2rem;
}
#pingjia_list .list_li .right .center .wuxing{

    float: left;
}
#pingjia_list .list_li .right .center .text{

    font-size: 0.45rem;
    padding: 0.2rem 0;
}
#pingjia_list .list_li .right .center .images img{
    width: 3rem;
    margin-left: 0.1rem;
}
</style>