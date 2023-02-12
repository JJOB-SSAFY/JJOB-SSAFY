<template>
	<div class="banner-container">
		<span class="banner-letter1">Recruit</span>
		<p class="banner-letter2">채용공고를 볼 수 있는 곳입니다.</p>
	</div>

	<hr class="hr-main" />
	<div style="width: 80%; margin: auto">
		<div class="div-search">
			<form class="recruit-search-form" @submit.prevent="searchList">
				<div class="div-search-department">
					<input
						class="form-control review-search-input"
						type="text"
						v-model.lazy="condition.form.location"
						@keyup.enter="searchInfo"
						placeholder="지역"
					/>
				</div>
				<div class="div-search-department">
					<input
						class="form-control review-search-input"
						type="text"
						v-model.lazy="condition.form.department"
						@keyup.enter="searchInfo"
						placeholder="직무"
					/>
					<button
						type="button"
						@click="searchInfo"
						style="font-size: 20px; position: absolute; top: 6px; right: 10px"
					>
						<fa-icon icon="fas fa-solid fa-magnifying-glass" />
					</button>
				</div>
				<!-- <div>
					<button type="button" style="font-size: 20px">
						<fa-icon icon="fas fa-solid fa-magnifying-glass" />
					</button>
				</div> -->
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
</template>

<script>
import recruitItemView from './components/recruit-item.vue';
import { reactive, onMounted, computed } from 'vue';
import { useStore } from 'vuex';

export default {
	name: 'recruitView',

	components: {
		recruitItemView,
	},
	setup() {
		const store = useStore();
		// const all = onMounted(() => store.getters['recruit/getRecruitList']);

		const getRecruitList = reactive({
			state: '',
		});
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

		return { condition, searchInfo };
	},
	computed: {
		searchList() {
			return this.$store.getters['recruit/getRecruitList'];
		},
	},
};
</script>

<style scoped>
.div-search {
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
}

.recruit-search-input {
	padding: 5px;
	box-sizing: border-box;
	margin: auto;
	height: 100%;
	border: 10px solid black;
}

.recruit-list {
	display: block;
}
.div-search-department {
	position: relative;
	display: flex;
	width: 30%;
	height: 45px;
	margin-left: 10px;
	margin-right: 10px;
}

.bg-image {
	height: 100%;
	/* opacity: .1; */
	background-position: 0 100%;
	background-position-x: 0px;
	background-position-y: 100%;
	background-image: url(../../../assets/images/bg2.png);
}
</style>
