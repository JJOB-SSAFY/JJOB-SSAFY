<template>
	<div style="width: 80%; margin: auto">
		<div class="div-search">
			<form class="recruit-search-form" @submit.prevent="searchInfo">
				<div>
					<input
						class="form-control review-search-input"
						type="text"
						v-model.lazy="condition.form.location"
						placeholder="지역"
					/>
				</div>
				<div class="div-search-department">
					<input
						class="form-control review-search-input"
						type="text"
						v-model.lazy="condition.form.department"
						placeholder="직무"
					/>
				</div>
				<div>
					<button type="button" class="btn btn-primary">검색</button>
				</div>
			</form>
		</div>

		<div class="div-itemList">
			<div>
				<ul class="recruit-list">
					<li
						class="recruit-list-item"
						v-for="info in searchList"
						:key="info.list"
					>
						<recruitItemView :info="info" />
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div style="position: fixed; bottom: 5px; right: 5px">
		<a href=".div-search">TOP</a>
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
		const all = onMounted(() => store.getters['recruit/getRecruitList']);

		console.log(store.getters['recruit/getRecruitList']);

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
			return store.getters['recruit/getRecruitList'];
		});

		return { all, condition, searchList, searchInfo };
	},
};
</script>

<style scoped>
.div-search {
	/* display: flex;
	justify-content: space-around;
	align-items: center; */
	position: relative;
	top: 20px;
}

.div-itemList {
	background-color: whitesmoke;
	border-radius: 10px;
	padding: 40px 10px 10px 10px;
	box-sizing: border-box;
}

.recruit-search-form {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 45px;
}

.recruit-search-input {
	padding: 5px;
	box-sizing: border-box;
	margin: auto;
	height: 100%;
}

.recruit-list {
	display: block;
}
.div-search-department {
	margin-left: 10px;
	margin-right: 10px;
}
</style>
