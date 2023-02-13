<template>
	<div class="banner-container font-LINE-Rg">
		<span class="banner-letter1">Applicant Information</span>
		<p class="banner-letter2">지원자 정보를 볼 수 있는 곳입니다.</p>
	</div>
	<hr class="hr-main" />
	<form class="card-search-form mt-50" @submit.prevent>
		<div class="div-search-skill">
			<img src="@/assets/images/icon/skills.png" width="19" height="19" />
			<input
				id="card-search-skill"
				class="form-control card-search-input"
				type="text"
				placeholder="보유 기술"
				v-model.lazy.trim="searchForm.form.skills"
				ref="inputSkill"
				@keyup.enter="searchCard"
			/>
			<button type="button" @click="searchCard">
				<fa-icon icon="fas fa-solid fa-magnifying-glass" />
			</button>
		</div>
		<div class="div-search-job">
			<img src="@/assets/images/icon/job.png" width="19" height="19" />
			<input
				id="card-search-job"
				class="form-control card-search-input font-LINE-Rg"
				type="text"
				placeholder="선호 직무"
				v-model.lazy.trim="searchForm.form.preferredJob"
				ref="inputJob"
				@keyup.enter="searchCard"
			/>
			<button type="button" @click="searchCard">
				<fa-icon icon="fas fa-solid fa-magnifying-glass" />
			</button>
		</div>
	</form>
	<div class="div-infoCards-view">
		<div
			v-for="info in cardList.card"
			:key="info.card"
			class="div-infocard-item font-LINE-Rg"
		>
			<div class="infoCards-cover-background"></div>
			<infoCardItem :info="info" />
		</div>
	</div>
</template>

<script>
import InfoCardService from '../../../api/infoCardService';
import infoCardItem from './components/infoCardItem.vue';
import { ref, reactive } from 'vue';
export default {
	namd: 'infoCardView',
	components: {
		infoCardItem,
	},
	setup() {
		const infoCardService = new InfoCardService();
		const cardList = reactive({
			card: '',
		});
		const searchCardList = reactive({
			searchList: null,
		});

		infoCardService.getCardList().then(data => {
			cardList.card = data;
			console.log(data);
		});

		const searchForm = reactive({
			form: {
				skills: '',
				preferredJob: '',
			},
		});

		// const search = () => {
		// 	searchCardList.card = cardList
		// }
		return {
			cardList,
			searchForm,
			searchCardList,
		};
	},
};
</script>

<style scoped>
.card-search-form {
	display: flex;
	justify-content: center;
}
.div-search-skill,
.div-search-job {
	display: flex;
}
</style>
