<template>
	<div>
		<div div-search>
			<form @submit.prevent="searchInfo">
				<input
					type="text"
					v-model.lazy="condition.form.location"
					placeholder="Location"
				/>
				<input
					type="text"
					v-model.lazy="condition.form.department"
					placeholder="Department"
				/>
				<button>검색</button>
			</form>
		</div>
		<div div-itemList>
			<ul class="recruit-list">
				<li
					class="recruit-list-item"
					v-for="info in searchList"
					:key="info.list"
				>
					<recruitItemView :info="info" />
				</li>
			</ul>
			<!-- <p>{{ searchList }}</p> -->
		</div>
		<!-- <div
			class="recruit-list-items"
			v-for="info in state.recruitList"
			:key="info.recruit"
		>
			<div>{{ info }}</div>
		</div> -->
	</div>
</template>

<script>
import recruitItemView from './components/recruit-item.vue';
import { ref, reactive, onMounted, computed } from 'vue';
import { useStore } from 'vuex';
import axios from 'axios';

export default {
	name: 'recruitView',

	components: {
		recruitItemView,
	},
	setup() {
		const store = useStore();

		// const item = reactive({
		// 	itemList: '',
		// });

		// onMounted(() => {
		// 	store.dispatch('recruit/getList').then(({ res }) => {
		// 		item.itemList = res.data;
		// 		console.log(item.itemList);
		// 	});
		// });

		const condition = reactive({
			form: {
				location: '',
				department: '',
			},
		});

		const searchInfo = function () {
			store.dispatch('recruit/getList', {
				location: condition.form.location,
				department: condition.form.department,
			});
		};

		const searchList = computed(() => {
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

		return { condition, searchList, searchInfo };
	},
};
</script>

<style scoped>
.recruit-list {
	display: flex;
	border: 1px solid black;
	width: auto;
}

.recruit-list-item {
	display: block;
	width: auto;
	/* border: 1px solid black; */
}
</style>
