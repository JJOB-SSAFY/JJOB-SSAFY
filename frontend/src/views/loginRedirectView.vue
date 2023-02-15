<template>
	<div>리다이렉트 중</div>
</template>

<script>
import VueCookies from 'vue-cookies';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import { onMounted } from 'vue';

export default {
	name: 'loginRedirectView',

	setup() {
		onMounted(() => {
			const store = useStore();
			const router = useRouter();
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

			router.push({ name: 'home' });
		});
	},
};
</script>

<style></style>
