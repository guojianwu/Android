<template>
  <div id="app">
    <div class="header" v-show="!clicktijiao" id="head">
        <v-header></v-header>
    </div>
    <div class="tab"  v-show="!clicktijiao" id="tab" :class="seClass">
        <div class="tab-item">
           <router-link to="/goods">商品</router-link>
         </div> 

        <div class="tab-item">
             <router-link to="/pingjia">评论</router-link>
         </div> 

        <div class="tab-item">
           <router-link to="/shanjia">商家</router-link>
         </div> 
    </div>
    <div class="content"  v-show="!clicktijiao">
         <router-view></router-view>
    </div>
    <div class="bottom" v-show="clickRouter">
        <v-bottom></v-bottom>
    </div>
    <tijiao  v-show="clicktijiao"></tijiao>
  
  </div>
</template>


<script>
import hearder from './components/header/header.vue';
import bottom from './components/bottom/bottom.vue';
import tijiao from './components/tijiao/tijiao.vue'

export default {
  name: 'app',
  data () {
    return {
        dataChe:{},
        seClass:''
    }
  },
  computed:{
      clicktijiao(){
        return this.$store.state.tijiao;
      },
      clickRouter(){
        return this.$store.state.clickRouter;
      }
  },
  mounted: function () {
        var _this=this;
        this.$nextTick(function () {
        window.onscroll=function(ev){
            if(ev.path[1].pageYOffset>=document.getElementById('head').offsetHeight){
                _this.seClass='fixed';
            }else {
                _this.seClass='';

            }
        }
      })
  },

  components:{
      'v-header':hearder,
      'v-bottom':bottom,
      tijiao
  }
}
</script>

<style lang="less" scpoed>
*{
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
body{
  width: 100%;
  height: 100%;
}
#app {
  
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  &::-webkit-scrollbar{
      display: none;
    }
}
  #app .fixed{
    position: fixed;
    left: 0;
    top: 0;
  }

.tab{
  display: flex;
  width: 100%;
  height: 1rem;
  line-height: 1rem;
  position: relative;
  border-top:1px solid gray;
  border-bottom:1px solid gray;
  background: white;
  .tab-item{
    flex:1;
    text-align: center;
    a{
      display: block;
      font-size: 0.4rem;
      text-decoration: none;
      color: gray;
    }
    .router-link-active{
      color: #00CC33;
    }
  }

}




</style>
