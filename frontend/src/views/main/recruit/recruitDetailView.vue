<template>
	<div>채용공고</div>
	<div>{{ recruitDetail }}</div>
</template>

<script>
import { reactive, ref } from 'vue';
import { useStore } from 'vuex';

export default {
	setup() {
		const store = useStore();
		const recruitDetail = ref(store.getters['recruit/getRecruitList']);

		return { recruitDetail };
	},
};
</script>

<style lang="scss" scoped></style>
