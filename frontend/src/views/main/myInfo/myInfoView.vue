<template>
	<div>{{ myInfo }}</div>
</template>

<script>
import { reactive, ref } from 'vue';
import { useStore } from 'vuex';

export default {
	setup() {
		const store = useStore();
		const myInfo = ref(store.getters['auth/getUserInfo']);

		return { myInfo };
	},
};
</script>

<style lang="scss" scoped></style>
