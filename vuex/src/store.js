import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

const state={
	count:10,
	test:2
}

const mutations={
	add(state){
		state.count++;
	},
	dec(state){
		state.count--;
	},
	addTest(state){
		state.test++;
	}
}

const actions={
	add:({commit})=>{
		commit('add');
		//console.log(commit);
	},
	dec:({commit})=>{
		commit('dec');
	},
	addTest:({commit})=>{
		commit('addTest');
	}
}


const getters={
	count(state){
		return state.count;
	},
	odd(state){
		return state.count%2==0?'偶数':'奇数';
	},
	test(state){
		return state.test;
	}
}

export default new Vuex.Store({
	getters,
	state,
	mutations,
	actions
})