<template>
	<div id="tijao">
		<div id="back">
            <span class="back" @click="back"> &lt;</span> <span>提交订单</span>
        </div>
        <div style="background: rgba(220, 220, 220, 0.47);height: 0.4rem;margin-top: 1.4rem"></div>
        <div class="list">
            <span>郭建武</span>
            <span>先生</span>
            <span>13588888603</span>
        </div>
        <div class="list">
            <span>中山火炬职业技术学院</span>
            <span>3栋603</span>
        </div>
        <div class="list">
            <span>送达时间</span>
            <span style="color: #00CC33">立即送出(大约{{time}}送达)</span>
        </div>
        <div style="background: rgba(220, 220, 220, 0.47);height: 0.4rem;"></div>
        <div v-for="type in diancan">
            <div class="foodList"  v-for="item in type[0].list" v-show="item.maiCount!=0">
                <span class="name">{{item.foodName}}</span>
                <span class="count">×{{item.maiCount}}</span>
                <span class="money">{{item.maiCount*item.foodPrice}} ￥</span>
            </div>
        </div>

	</div>
</template>
<script>
	export default{
		data(){
			return{
				  
			}
		},
		computed:{
			diancan(){
				return this.$store.state.foodData;
			},
			time(){
				return this.nowTime=new Date().getHours()+':'+(new Date().getMinutes()+15);
			}
		},
		methods:{
			back(){
				this.$store.state.tijiao=false;
                this.$store.state.num=0;
                this.$store.state.jiesuan='去结算';
			}
		}
	}
</script>
<style >
	#back{
    position: fixed;
    font-size: 0.5rem;
    border-bottom: 1px solid darkgray;
    top: 0;
    left: 0;
    width: 100%;
    height: 1.4rem;
    line-height: 1.4rem;
    background: white;
}
#back span{
    vertical-align: middle;
}
#back .back{
    font-size: 0.75rem;
    color: grey;
    padding-right: 0.3rem;
    padding-left: 0.2rem;

}
#tijao .list{
    border-bottom: 1px solid darkgrey;
    height: 1.2rem;
    line-height: 1.2rem;
    padding-left: 0.3rem;
    font-size: 0;
}
#tijao .list span{
    font-size: 0.35rem;
    padding-right: 0.3rem;
}
#tijao .foodList{
    border-bottom: 1px solid darkgrey;
    height: 1.2rem;
    line-height: 1.2rem;
    padding-left: 0.3rem;
    font-size: 0;
}
#tijao .foodList span{
    font-size: 0.35rem;
    padding-right: 0.3rem;
    display: inline-block;
    height: 1.2rem;
    vertical-align: middle;
}
#tijao .foodList .name{
    width: 60%;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}
#tijao .foodList .count{
    margin-left: 3%;
}
#tijao .foodList .money{
    float: right;
    font-size: 0.45rem;
}

</style>

