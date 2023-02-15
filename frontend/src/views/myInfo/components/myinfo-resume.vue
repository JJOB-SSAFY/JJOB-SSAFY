<template>
	<div class="div-resume">
		<div
			v-for="(resume, index) in getResumeList.state"
			:key="resume.resumeId"
			class="resume resume-container"
		>
			<div class="resume-id font-LINE-Bd">{{ index + 1 }}</div>

			<div class="resume-title font-LINE-Rg">{{ resume.resumeTitle }}</div>
			<button @click="showDetailResume(resume.resumeId)" class="resume-view-bt">
				보기
			</button>
			<button @click="deleteResume" class="resume-delete-bt">
				<fa-icon icon="fas fa-solid fa-x"></fa-icon>
			</button>
		</div>
		<button @click="addResume" class="resume-create-btn">
			<fa-icon icon="fas fa-solid fa-plus"></fa-icon>
		</button>
	</div>
</template>

<script>
import { useStore } from 'vuex';
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import resumeService from '../../../api/resumeService';
import Swal from 'sweetalert2';

export default {
	name: 'MyinfoResume',
	setup() {
		const store = useStore();

		const router = useRouter();

		const getResumeList = reactive({
			state: {},
		});
		const resService = new resumeService();
		resService.getResumeList().then(data => {
			getResumeList.state = data;
		});
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
				Swal.fire({
					title: 'OOPS!',
					text: '이력서는 10개까지만 입력할 수 있습니다.',
					icon: 'warning',
				});
				return;
			}
			router.push({
				name: 'resumeCreate',
			});
		};

		const deleteResume = () => {};
		return { store, getResumeList, showDetailResume, addResume, deleteResume };
	},
};
</script>

<style scoped></style>
