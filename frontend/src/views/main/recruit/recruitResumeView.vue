<template>
	<div class="">
		<div class="banner-container">
		<span class="banner-letter1">지원자 이력서</span>
	</div>


		<div class="container-recruit">
			<ul class="responsive-table">
				<li class="table-header">
					<div class="col col-1">지원자</div>
					<div class="col col-1">지원 공고</div>
					<div class="col col-1">보유기술</div>
					<div class="col col-1">자기소개서</div>
					<div class="col col-1"></div>
				</li>
				<li
					v-for="apply in getApplyResumeList.state"
					:key="apply.applyStatusId"
					class="table-row"
				>
					<div class="col col-2" data-label="name">{{ apply.memberName }}</div>
					<div class="col col-2" data-label="recruitTitle">
						{{ apply.recruitTitle }}
					</div>
					<div class="col col-2" data-label="skills">{{ apply.skills }}</div>
					<div class="col col-2" data-label="resumeTitle">
						{{ apply.resumeTitle }}
					</div>
					<div class="col col-2" data-label="resumeTitle">
						<v-btn
							variant="outlined"
							color="primary"
							@click="showDetailResume(apply.resumeId, apply.applyId)"
						>
							열람하기
						</v-btn>
					</div>
				</li>
			</ul>
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
		const showDetailResume = (e,k) => {
			router.push({
				name: 'recruitResumeDetail',
				params: {
					resumeId: e,
					applyId:k,
				},
			});
		};
		return { store, getApplyResumeList, showDetailResume };
	},
};
</script>


<style scoped>
</style>

