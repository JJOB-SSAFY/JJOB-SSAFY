<template>
	<div class="div-recruit-list">
		<div div-search>
			<input type="text" v-model.lazy="searchCondition.location" />
			<input type="text" v-model.lazy="searchCondition.department" />
			<button>검색</button>
		</div>
		<div
			class="recruit-list-items"
			v-for="info in state.recruitList"
			:key="info.recruit"
		>
			<recruit-Recommend :info="info" />
		</div>
	</div>
</template>

<script>
import recruitRecommend from './components/recruit-item.vue';
import axios from 'axios';
import { ref, reactive } from 'vue';

export default {
	name: 'recruitView',

	components: {
		recruitRecommend,
	},
	setup() {
		const state = reactive({
			recruitList: '',
		});

		const searchCondition = reactive({
			location: '',
			department: '',
		});

		const searchClick = () => {
			const searchInfo = {
				location: searchCondition.location,
				department: searchCondition.locationlocation,
			};
		};
		axios({
			method: 'POST',
			url: 'http://localhost:8080/recruit/list',
			headers: {
				Authorization: localStorage.getItem('jjob.s.token'),
			},
			data: searchCondition,
		}).then(res => {
			state.recruitList = res.data;
			console.log(searchCondition.department);
		});
		// onMounted(() => {
		// 	store.dispatch('recruit/getList');
		// });

		return { state, searchCondition, searchClick };
	},
};
</script>

<style scoped>
.div-recruit-list {
	display: flex;
	border: 1px solid black;
	width: auto;
}

.recruit-list-items {
	display: block;
	width: auto;
	/* border: 1px solid black; */
}
</style>
