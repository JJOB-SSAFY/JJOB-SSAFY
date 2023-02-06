<template>
	<!-- <ul class="infinite-list" v-infinite-scroll="load" style="overflow: auto"> -->
	<ul class="infinite-list" style="overflow: auto">
		<li
			class="infinite-list-item"
			v-for="info in interviewList"
			:key="info.conferenceId"
		>
			<interview :info="info" />
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
			// count: 12,
			interviewList: null,
		});

		const load = function () {
			// state.count += 4;
		};

		axios({
			method: 'get',
			url: 'http://localhost:8080/conference/list/INTERVIEW',
			headers: {
				Authorization:
					'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiaXNzIjoic3NhZnkuY29tIiwiZXhwIjoxNjc2NzA4NzY4LCJpYXQiOjE2NzU0MTI3Njh9.mobOSKc_lKBNKSKKdkgqjdHQiC8DgpQIOkg0xu3iRjmsDixvrh4Jj32jOFFskcQjuMwKs40XD75ko6hvXm8n1g',
			},
		}).then(res => {
			state.interviewList = res.data;
			console.log(state.interviewList);
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
