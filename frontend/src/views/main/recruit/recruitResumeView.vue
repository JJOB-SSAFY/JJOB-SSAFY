<template>
	<div class="div-resume">
		<div
			v-for="(apply) in getApplyResumeList.state"
			:key="apply.applyStatusId"
			class="resume-container"
		>
			<div class="resume-id font-LINE-Bd">{{ apply.companyName }}</div>
			<div class="">{{ apply.recruitTitle }}</div>
			<div class="resume-title font-LINE-Rg">{{ apply.memberName   }},{{ apply.resumeTitle }}</div>
			<button @click="showDetailResume(apply.resumeId)" class="resume-view-bt">
				보기
			</button>
		</div>
		
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
		const showDetailResume = e => {
			router.push({
				name: 'recruitResumeDetailView',
				params: {
					resumeId: e,
				},
			});
		};

		// const addResume = function () {
		// 	if (getResumeList.state.length >= 10) {
		// 		alert('이력서는 10개 까지만 생성할 수 있습니다.');
		// 		return;
		// 	}
		// 	router.push({
		// 		name: 'resumeCreate',
		// 	});
		// };
		return { store, getApplyResumeList, showDetailResume };
	},
};
</script>

<style scoped></style>
