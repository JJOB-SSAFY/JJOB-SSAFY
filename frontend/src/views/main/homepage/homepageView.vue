<template class="homepage">
	<home-banner />
	<!-- <router-view /> -->
	wdfe
</template>

<script>
import { onMounted } from 'vue';
import { useStore } from 'vuex';
import VueCookies from 'vue-cookies';
import homeBanner from '../homepage/components/home-Banner.vue';
export default {
	name: 'homepageView',

	components: {
		homeBanner,
	},
	data() {
		return {};
	},
	setup() {
		const store = useStore();

		onMounted(() => {
			const type = VueCookies.get('type');

			if (type === 'social') {
				const accessToken = VueCookies.get('accessToken');
				const name = VueCookies.get('name');
				const role = VueCookies.get('role');

				const loginInfo = {
					accessToken: accessToken,
					name: name,
					role: role,
				};

				store.dispatch('auth/socialLogin', loginInfo);

				VueCookies.remove('type');
				VueCookies.remove('accessToken');
				VueCookies.remove('name');
				VueCookies.remove('role');
			}
		});
	},
};
</script>
