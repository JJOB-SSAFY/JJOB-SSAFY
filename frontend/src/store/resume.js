import http from '@/api/http';

export const resume = {
	namespaced: true,
	state: () => ({ resumeList: null }),
	getters: {
		getResumeList: function (state) {
			return state.resumeList;
		},
	},
	actions: {
		getList({ commit }) { },
	},
	mutations: {},
};
