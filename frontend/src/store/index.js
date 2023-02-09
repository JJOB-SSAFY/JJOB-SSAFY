import { createStore } from 'vuex';

import createPersistedState from 'vuex-persistedstate';

import { auth } from '@/store/auth';
import { recruit } from '@/store/recruit';
export default createStore({
	modules: { auth, recruit },
	plugins: [
		createPersistedState({
			paths: ['auth', 'recruit'],
		}),
	],
});
