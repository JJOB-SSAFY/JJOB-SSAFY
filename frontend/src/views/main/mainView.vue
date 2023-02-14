<template>
	<header>
		<main-header />
	</header>
	<hr class="hr-main" />
	<section>
		<transition name="slide-fade" mode="out-in"> <router-view /> </transition>
	</section>
	<footer></footer>
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
