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

				console.log(response.data);
				commit('GET_LIST', response.data);
				// http
				// 	.post('/recruit/list', payload)
				// 	.then(function (response) {
				// 		console.log(response.data);
				// 		commit('GET_LIST', response.data);
				// 	})
				// 	.catch(err => {
				// 		commit('ERROR_HANDLE', err);
				// 	});
			} catch (error) {
				console.log(error);
			}
		},
	},
	mutations: {
		GET_LIST(state, list) {
			state.recruitList = list;
		},
	},
};
export default recruit;
