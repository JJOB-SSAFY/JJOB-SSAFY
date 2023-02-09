<template>
	<div>state</div>
</template>

<script>
import { useStore } from 'vuex';
import { reactive, toRaw } from 'vue';

export default {
	name: 'MyinfoResume',
	setup() {
		const store = useStore();

		const state = reactive({
			resumeList: {},
		});
		const getResumeList = store.getters['auth/getResumeList'];
		state.resumeList = toRaw(getResumeList);

		// console.log(temp);

		// const getList = store.getters['resume/getList'];

		// resumeList.state = toRaw(getList);
		console.log('asdfasfsadfadsfasd');
		console.log(state.resumeList);
		return { store, state };
	},
};
</script>

<style lang="scss" scoped></style>
