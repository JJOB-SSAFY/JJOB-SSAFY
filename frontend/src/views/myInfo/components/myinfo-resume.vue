<template>
	<div class="div-resume">
		<div
			v-for="(resume, index) in getResumeList.state"
			:key="resume.resumeId"
			class="resume-container"
		>
			<div class="resume-id font-LINE-Bd">{{ index + 1 }}</div>

			<div class="resume-title font-LINE-Rg">{{ resume.resumeTitle }}</div>
			<button @click="showDetailResume(resume.resumeId)" class="resume-view-bt">
				보기
			</button>
		</div>
	</div>
</template>

<script>
import { useStore } from 'vuex';
import { reactive, toRaw, computed } from 'vue';

export default {
	name: 'MyinfoResume',
	setup() {
		const store = useStore();

		const getResumeList = reactive({
			state: {},
		});
		const resumeList = store.getters['auth/getResumeList'];
		getResumeList.state = toRaw(resumeList);
		// const getResumeList = computed(() => {
		// 	return store.getters['auth/getResumeList'];
		// });
		// resumeList.state = toRaw(getResumeList);

		// console.log('12341242314');

		// const getList = store.getters['resume/getList'];

		// resumeList.state = toRaw(getList);
		// console.log(getResumeList);
		const showDetailResume = e => {
			console.log(e);
		};
		return { store, getResumeList, showDetailResume };
	},
};
</script>

<style lang="scss" scoped></style>
