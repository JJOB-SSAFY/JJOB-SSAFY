<template>
	<header>
		<main-header />
	</header>
	<hr />
	<section>
		<router-view />
	</section>
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
