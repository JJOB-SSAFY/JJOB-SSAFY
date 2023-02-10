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
		<button @click="addResume" class="resume-create-btn">
			<fa-icon icon="fas fa-solid fa-plus"></fa-icon>
		</button>
	</div>
</template>

<script>
import { useStore } from 'vuex';
import { reactive, toRaw, computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import resumeService from '../../../api/resumeService';

export default {
	name: 'MyinfoResume',
	setup() {
		const store = useStore();

		const router = useRouter();

		const getResumeList = reactive({
			state: {},
		});
		// const resumeList = store.getters['auth/getResumeList'];
		// getResumeList.state = toRaw(resumeList);
		const resService = new resumeService();
		resService.getResumeList().then(data => {
			getResumeList.state = data;
		});

		// const getResumeList = computed(() => {
		// 	return store.getters['auth/getResumeList'];
		// });
		// resumeList.state = toRaw(getResumeList);

		// console.log('12341242314');

		// const getList = store.getters['resume/getList'];

		// resumeList.state = toRaw(getList);
		// console.log(getResumeList);
		const showDetailResume = e => {
			router.push({
				name: 'resumeDetail',
				params: {
					resumeId: e,
				},
			});
		};

		const addResume = function () {
			if (getResumeList.state.length >= 10) {
				alert('이력서는 10개 까지만 생성할 수 있습니다.');
				return;
			}
			router.push({
				name: 'resumeCreate',
			});
		};
		return { store, getResumeList, showDetailResume, addResume };
	},
};
</script>

<style scoped>
.resume-create-btn {
	width: 55px;
	height: 55px;
	background-color: #ff8585;
	margin: auto;
	color: white;
	border-radius: 50%;
	font-size: 24px;
}
</style>
