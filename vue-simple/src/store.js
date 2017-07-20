import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

const state={
	zongJia:0,
	foodData:{},
	dialogVisible:false,
	dialogVisible1:false,
	zongMoeny:0,
	tijiao:false,
	jiesuan:'去结算',
	num:0,
	disform:1,
	clickRouter:true
}


const getters={
	// zongjia(state){
	// 	return state.zongjia;
	// },
	// foodData(state){
	// 	return state.foodData;
	// },
	// zongMoeny(state){
	// 	return state.zongMoeny;
	// },
	// peiSong(state){
	// 	return state.peiSong;
	// },
	// jiesuan(state){
	// 	return state.jiesuan;
	// },
	// num(state){
	// 	return state.num;
	// }
	// // dialogVisible(){
	// // 	return state.dialogVisible;
	// // }
}


export default new Vuex.Store({
		getters,
		state
})

