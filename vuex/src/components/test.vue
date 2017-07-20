<template>
	<div class="test">
		<input type="button" name="" value="test" @click="addTest">
		{{count}},test:{{test}}
	</div>	

</template>
<script>

	import {mapGetters,mapActions} from 'vuex'
	export default{
		computed:mapGetters([
			'count',
			'test'
		]),
		methods:mapActions([
			'addTest'
		])
	}
</script>