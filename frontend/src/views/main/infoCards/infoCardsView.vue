<template>
	<div class="banner-container font-LINE-Rg">
		<span class="banner-letter1">Applicant Information</span>
		<p class="banner-letter2">지원자 정보를 볼 수 있는 곳입니다.</p>
	</div>
	<hr class="hr-main" />
	<div class="div-infoCards-view">
		<div
			v-for="info in cardList.card"
			:key="info.card"
			class="div-infocard-item"
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
			card: '',
		});

		infoCardService.getCardList().then(data => {
			cardList.card = data;
			console.log(data);
		});

		// const search = () => {
		// 	searchCardList.card = cardList
		// }
		return {
			cardList,
		};
	},
};
</script>

<style scoped>
.card-list {
	display: flex;
	border: 1px solid black;
	width: auto;
}

.card-list-items {
	display: block;
	width: auto;
	/* border: 1px solid black; */
}
.card-list-container {
	display: auto;
}
</style>
