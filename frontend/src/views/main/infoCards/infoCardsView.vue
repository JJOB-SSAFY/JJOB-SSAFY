<template>
	<div>
		<div></div>
		<!-- card list 불러오기 -->
		<div>
			<div v-for="info in cardList.card" :key="info.card">
				<infoCardItem :info="info" />
			</div>
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
