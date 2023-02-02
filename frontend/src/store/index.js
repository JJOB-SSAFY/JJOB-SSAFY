import { createStore } from 'vuex';

import createPersistedState from 'vuex-persistedstate';

import { auth } from '@/store/auth';

export default createStore({
	modules: { auth },
	plugins: [
		createPersistedState({
			paths: ['auth'],
		}),
	],
});
