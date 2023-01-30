<template>
	<main-header></main-header>
	<router-view></router-view>
</template>

<script>
import MainHeader from '@/views/main/components/main-Header.vue';
export default {
	name: 'mainView',
	components: {
		MainHeader,
	},
	data() {
		return {};
	},
};
</script>
