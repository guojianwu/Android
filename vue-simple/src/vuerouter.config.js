import goods from './components/goods/goods.vue'
import pingjia from './components/pingjia/pingjia.vue'
import shanjia from './components/shanjia/shanjia.vue'

export default{
	routes:[
		{path:'/goods',component:goods},
		{path:'/pingjia',component:pingjia},
		{path:'/shanjia',component:shanjia},
		{path:'*',component:goods}
	]
}
