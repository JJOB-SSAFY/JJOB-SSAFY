<template>
	<!-- <ul class="infinite-list" v-infinite-scroll="load" style="overflow: auto"> -->
	<div class="container">
		<ul class="infinite-list justify-content-evenly row" style="overflow: auto">
			<li
				class="infinite-list-item col-4"
				v-for="info in state.interviewList"
				:key="info.conferenceId"
				style="margin-bottom: 50px"
			>
				<interview-item :info="info" />
			</li>
		</ul>
	</div>
</template>
<script>
import InterviewItem from './components/interview.vue';
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import interviewSevice from '@/api/interviewService';

export default {
	name: 'interviewView',

	components: {
		InterviewItem,
	},

	setup() {
		const state = reactive({
			// count: 12,
			interviewList: null,
		});

		const load = function () {
			// state.count += 4;
		};
		const interviewAPI = new interviewSevice();
		interviewAPI.getInterviewList().then(data => {
			state.interviewList = data;
		});

		return { state, load };
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
