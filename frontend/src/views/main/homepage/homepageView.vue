<template>
	<home-banner />
	<!-- <router-view /> -->
</template>

<script>
import homeBanner from '../homepage/components/home-Banner.vue';
export default {
	name: 'homepageView',

	components: {
		homeBanner,
	},
	data() {
		return {};
	},
};
</script>
