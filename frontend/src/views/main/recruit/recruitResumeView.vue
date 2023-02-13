<template>
	<div class="">
		<div class="container">
			<h2>지원자 이력서</h2>
			<ul class="responsive-table">
				<li class="table-header">
					<div class="col col-1">지원자</div>
					<div class="col col-1">지원 공고</div>
					<div class="col col-1">스킬셋</div>
					<div class="col col-1">자기소개서</div>
					<div class="col col-1"></div>
				</li>
				<li
					v-for="apply in getApplyResumeList.state"
					:key="apply.applyStatusId"
					class="table-row"
				>
					<div class="col col-1" data-label="name">{{ apply.memberName }}</div>
					<div class="col col-1" data-label="recruitTitle">
						{{ apply.recruitTitle }}
					</div>
					<div class="col col-1" data-label="skills">{{ apply.skills }}</div>
					<div class="col col-1" data-label="resumeTitle">
						{{ apply.resumeTitle }}
					</div>
					<div class="col col-1" data-label="resumeTitle">
						<button  @click="showDetailResume(apply.resumeId)">
							보기
						</button>
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
		const showDetailResume = e => {
			router.push({
				name: 'recruitResumeDetail',
				params: {
					resumeId: e,
				},
			});
		};

		return { store, getApplyResumeList, showDetailResume };
	},
};
</script>

<style scoped>
.container {
	max-width: 1000px;
	margin-left: auto;
	margin-right: auto;
	padding-left: 10px;
	padding-right: 10px;
}

.responsive-table li {
	border-radius: 3px;
	padding: 25px 30px;
	display: flex;
	justify-content: space-between;
	margin-bottom: 25px;
}
.responsive-table .table-header {
	background-color: #95a5a6;
	font-size: 14px;
	text-transform: uppercase;
	letter-spacing: 0.03em;
}
.responsive-table .table-row {
	background-color: #fff;
	box-shadow: 0px 0px 9px 0px rgba(0, 0, 0, 0.1);
}
.responsive-table .col-1 {
	flex-basis: 20%;
}
.responsive-table .col-2 {
	flex-basis: 40%;
}
.responsive-table .col-3 {
	flex-basis: 25%;
}
.responsive-table .col-4 {
	flex-basis: 25%;
}
@media all and (max-width: 1024px) {
	.responsive-table .table-header {
		display: none;
	}
	.responsive-table li {
		display: block;
	}
	.responsive-table .col {
		flex-basis: 100%;
	}
	.responsive-table .col {
		display: flex;
		padding: 10px 0;
	}
	.responsive-table .col:before {
		color: #6c7a89;
		padding-right: 10px;
		content: attr(data-label);
		flex-basis: 50%;
		text-align: right;
	}
}
</style>
