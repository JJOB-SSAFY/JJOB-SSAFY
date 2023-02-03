<template>
	<ul class="infinite-list" v-infinite-scroll="load" style="overflow: auto">
		<li class="infinite-list-item" v-for="i in state.count" :key="i">
			<interview />
		</li>
	</ul>
</template>
<script>
import Interview from './components/interview.vue';
import { reactive } from 'vue';
import axios from 'axios';

export default {
	name: 'interviewView',

	components: {
		Interview,
	},

	setup() {
		const state = reactive({
			count: 12,
		});

		const load = function () {
			state.count += 4;
		};

		axios({
			method: 'get',
			url: 'http://localhost:8080/conference/list/INTERVIEW',
			headers: {
				Authorization:
					'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiaXNzIjoic3NhZnkuY29tIiwiZXhwIjoxNjc2NzA3NDU0LCJpYXQiOjE2NzU0MTE0NTR9.URHNiJaHd85kTneItnT9JfrQSOj7NryfzNRgeAfW26rD6Ok7VKYFfM4rq849CsXNwGOJaiw1n14wQeZccuv7ew',
			},
		}).then(res => {
			console.log(res);
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
