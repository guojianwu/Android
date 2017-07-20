const actions={
	
}


export default{
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