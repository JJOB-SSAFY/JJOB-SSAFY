<template>
	<!-- <ul class="infinite-list" v-infinite-scroll="load" style="overflow: auto"> -->
	<ul class="infinite-list" style="overflow: auto">
		<li
			class="infinite-list-item"
			v-for="info in state.interviewList"
			:key="info.conferenceId"
			@click="clickConference(info.conferenceId)"
		>
			<interview-item :info="info" />
		</li>
	</ul>
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
		const router = useRouter();

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

		// const
		// axios({
		// 	method: 'get',
		// 	url: 'http://localhost:8080/conference/list/INTERVIEW',
		// 	headers: {
		// 		Authorization: localStorage.getItem('jjob.s.token'),
		// 	},
		// })
		// .then(res => {
		// 	state.interviewList = res.data;
		// 	console.log(state.interviewList);
		// });

		const clickConference = function (id) {
			// const loadingInstance1 = ElLoading.service({ fullscreen: true })
			// const username = localStorage.getItem('name');

			router.push({
				name: 'openVidu',
				params: {
					participant: 'username',
					session: id,
				},
			});
			// loadingInstance1.close()
		};

		return { state, load, clickConference };
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
