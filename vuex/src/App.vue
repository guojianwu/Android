<template>
  <div id="app">
    <input type="button" name="" value="add" @click="add">
    <input type="button" name="" value="dec" @click="dec">
     <!-- <input type="button" name="" value="showOdd" @click="showOdd"> -->
   <div>
     当前数据:{{$store.state.count}}
   </div>


  <div>
     当前数据:{{count}},{{odd}} {{boo}},test:{{test}}
   </div>


   <div>
     <test></test>
   </div>



  </div>

  
</template>

<script>

import {mapGetters,mapActions,mapMutations} from 'vuex'
import test from './components/test.vue'

export default {
  data(){
    return{
      boo:0
    }
  },
  computed:{
      count(){
        return this.$store.state.count;
      },
       odd(){
        return this.$store.state.odd;
      },
       test(){
        return this.$store.state.test;
      }

  },
  methods:{
    add(){
      this.$store.state.count++;
     // alert(1)
    },
    dec(){
       this.$store.state.count++;
    }
  },
  // computed:mapGetters([
  //     'count',
  //     'odd',
  //     'test'
  // ]),
  // methods:mapActions([
  //     'add',
  //     'dec'
  //   ]),
  components:{
     test
  }

}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
