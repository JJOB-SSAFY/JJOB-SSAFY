<template>
	<div class="banner-container">
		<span class="banner-letter1">Interview</span>
		<p class="banner-letter2">예정된 면접을 볼 수 있는 곳입니다.</p>
	</div>
	<hr class="hr-main2" />
	<div class="interview-container">
		<ul class="infinite-list justify-content-left row gx-5">
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
<style scoped>
.interview-container {
	display: flex;
	justify-content: center;
}
.infinite-list {
	padding-left: 0;
	max-height: calc(100% - 35px);
}

.infinite-list .infinite-list-item {
	width: 30%;
	display: inline-block;
	cursor: pointer;
}
.row {
	justify-content: center;
}
</style>
