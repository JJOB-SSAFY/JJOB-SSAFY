<template>
	<div class="banner-container">
		<span class="banner-letter1">Interview</span>
		<p class="banner-letter2">예정된 면접을 볼 수 있는 곳입니다.</p>
	</div>
	<hr class="hr-main" />
	<div class="container">
		<div class="mb-60">
			<h1 class="font-LINE-Bd mt-100 mb-40">나의 면접 리스트</h1>
			<hr />
		</div>
		<ul
			class="infinite-list justify-content-left row gx-5"
			style="overflow: auto"
		>
			<li
				class="infinite-list-item col-4"
				v-for="info in state.interviewList"
				:key="info.conferenceId"
				style="margin-bottom: 100px"
			>
				<interview-item :info="info" />
			</li>
		</ul>
	</div>
</template>
<script>
import InterviewItem from './components/interview.vue';
import { reactive } from 'vue';
import interviewSevice from '@/api/interviewService';

export default {
	name: 'interviewView',

	components: {
		InterviewItem,
	},

	setup() {
		const state = reactive({
			interviewList: null,
		});

		// const load = function () {};
		const interviewAPI = new interviewSevice();
		interviewAPI.getInterviewList().then(data => {
			state.interviewList = data;
		});

		return { state };
	},
};
</script>
<style>
.infinite-list {
	padding-left: 0;
	max-height: calc(100% - 35px);
}

@media (min-width: 701px) and (max-width: 1269px) {
	.infinite-list {
		min-width: 700px;
	}
}

@media (min-width: 1270px) {
	.infinite-list {
		min-width: 1021px;
	}
}

.infinite-list .infinite-list-item {
	min-width: 335px;
	max-width: 25%;
	display: inline-block;
	cursor: pointer;
}
</style>
