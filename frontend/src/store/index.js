import { createStore } from 'vuex';

import createPersistedState from 'vuex-persistedstate';

import { auth } from '@/store/auth';
import { recruit } from '@/store/recruit';
import { resume } from '@/store/resume';

export default createStore({
	modules: { auth, recruit, resume },
	plugins: [
		createPersistedState({
			paths: ['auth', 'recruit', 'resume'],
		}),
	],
});
