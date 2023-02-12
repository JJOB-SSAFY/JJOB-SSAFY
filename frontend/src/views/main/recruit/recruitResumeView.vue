<template>
	<div class="div-resume">
		<div
			v-for="(apply, index) in getApplyResumeList.state"
			:key="apply.applyStatusId"
			class="resume-container"
		>
			<div class="resume-id font-LINE-Bd">{{ index + 1 }}</div>

			<div class="resume-title font-LINE-Rg">
				{{ apply.memberName }}, {{ apply.recruitTitle }},
				{{ apply.resumeTitle }}
			</div>
			<button
				@click="showDetailResume(apply.recruitTitle)"
				class="resume-view-bt"
			>
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
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import applyService from '../../../api/applyService';

export default {
	name: 'RecruitResume',
	setup() {
		const store = useStore();

		const router = useRouter();

		const companyId = store.getters['auth/getCompanyId'];

		const getApplyResumeList = reactive({
			state: {},
		});
		const appService = new applyService();
		appService.getApplyResumeList(companyId).then(data => {
			getApplyResumeList.state = data;
		});
		// const showDetailResume = e => {
		// 	router.push({
		// 		name: 'resumeDetail',
		// 		params: {
		// 			resumeId: e,
		// 		},
		// 	});
		// };

		// const addResume = function () {
		// 	if (getResumeList.state.length >= 10) {
		// 		alert('이력서는 10개 까지만 생성할 수 있습니다.');
		// 		return;
		// 	}
		// 	router.push({
		// 		name: 'resumeCreate',
		// 	});
		// };
		return { store, getApplyResumeList };
	},
};
</script>

<style scoped></style>
