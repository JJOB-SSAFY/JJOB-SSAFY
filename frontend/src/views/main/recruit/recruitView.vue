<template>
	<div>
		<div div-search>
			<form @submit.prevent="serchInfo">
				<input
					type="text"
					v-model.lazy="state.form.location"
					placeholder="Location"
				/>
				<input
					type="text"
					v-model.lazy="state.form.department"
					placeholder="Department"
				/>
				<button>검색</button>
			</form>
			<p>{{ searchClick }}</p>
		</div>
		<!-- <div
			class="recruit-list-items"
			v-for="info in state.recruitList"
			:key="info.recruit"
		>
			<recruit-Recommend :info="info" />
		</div> -->
	</div>
</template>

<script>
import recruitItme from './components/recruit-item.vue';
import { ref, reactive, onMounted, computed } from 'vue';
import { useStore } from 'vuex';
import axios from 'axios';

export default {
	name: 'recruitView',

	components: {
		recruitItme,
	},
	setup() {
		const store = useStore();

		const state = reactive({
			form: {
				location: '',
				department: '',
			},
		});

		const serchInfo = function () {
			store.dispatch('recruit/getList', {
				location: state.form.location,
				department: state.form.department,
			});
		};

		const searchClick = computed(() => {
			// 조건에 맞는것들만 보이게 해야됌
			return store.getters['recruit/getRecruitList'];
		});

		// axios({
		// 	method: 'POST',
		// 	url: 'http://localhost:8080/recruit/list',
		// 	headers: {
		// 		Authorization: localStorage.getItem('jjob.s.token'),
		// 	},
		// 	data: searchCondition,
		// }).then(res => {
		// 	state.recruitList = res.data;
		// 	console.log(searchCondition.department);
		// });

		return { state, searchClick, serchInfo };
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
