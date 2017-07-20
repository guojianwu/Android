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

export default{
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