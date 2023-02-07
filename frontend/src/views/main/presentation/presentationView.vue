<template>
	<!-- <ul class="infinite-list" v-infinite-scroll="load" style="overflow: auto"> -->
	<ul class="infinite-list" style="overflow: auto">
		<li
			class="infinite-list-item"
			v-for="info in state.presentationList"
			:key="info.conferenceId"
		>
			<presentation :info="info" />
		</li>
	</ul>
</template>
<script>
import Presentation from './components/presentation.vue';
import { reactive } from 'vue';
import presentationService from '@/api/presentationService';
export default {
	name: 'presentationView',

	components: {
		Presentation,
	},

	setup() {
		const state = reactive({
			// count: 12,
			presentationList: null,
		});

		const load = function () {
			// state.count += 4;
		};
		const presentationAPI = new presentationService();
		presentationAPI.getPresentList().then(data => {
			state.presentationList = data;
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
