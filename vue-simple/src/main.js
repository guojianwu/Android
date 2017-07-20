import Vue from 'vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import App from './App.vue'
import vueRouterConfig from './vuerouter.config.js'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import store from './store.js'

Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.use(VueResource);
const router=new VueRouter(vueRouterConfig);

var vm = new Vue({
	store,
	router,
  el: '#app',
  render: h => h(App)
})
