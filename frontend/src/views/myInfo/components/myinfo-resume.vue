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
		<button @click="addResume" class="resume-create-btn">+</button>
	</div>
</template>

<script>
import { useStore } from 'vuex';
import { reactive, toRaw, computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { url } from '../../../api/http';
import axios from 'axios';

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

		axios({
			method: 'GET',
			url: url + '/resume',
			headers: {
				Authorization: localStorage.getItem('jjob.s.token'),
			},
			data: {
				companyName: '',
			},
		}).then(res => {
			getResumeList.state = toRaw(res.data);
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
