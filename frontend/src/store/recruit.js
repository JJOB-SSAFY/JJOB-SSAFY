import http from '@/api/http';

export const recruit = {
	namespaced: true,

	state: () => ({
		recruitList: null,
	}),
	getters: {
		getRecruitList: function (state) {
			return state.recruitList;
		},
	},
	actions: {
		getList: async ({ commit }, payload) => {
			try {
				const response = await http.post('/recruit/list', payload);

				commit('GET_LIST', response.data);
			} catch (error) {}
		},
	},
	mutations: {
		GET_LIST(state, list) {
			state.recruitList = list;
		},
	},
};
export default recruit;
