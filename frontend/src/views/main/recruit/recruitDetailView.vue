<template>
	<div>
		채용공고
		{{ recruitId }}
	</div>
	<!-- <div>{{ recruitDetail }}</div> -->
</template>

<script>
import { reactive, ref } from 'vue';
import axios from 'axios';
import { url } from '../../../api/http';

export default {
	name: 'recruitDetailView',

	data() {
		return {
			recruitId: this.$route.params.recruitId,
		};
	},

	setup() {
		axios({
			method: 'GET',
			url: url + 'recruit/detail/',
		});
		// const store = useStore();
		// const recruitDetail = ref(store.getters['recruit/getRecruitList']);

		return {};
	},
};
</script>

<style scoped></style>
