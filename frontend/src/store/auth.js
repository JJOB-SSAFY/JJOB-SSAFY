import http from '@/api/http';
import jwt from '@/common/jwt';

const auth = {
	namespaced: true,
	state: {
		user: null,
		token: {
			accessToken: jwt.getToken(),
		},
		isAuthenticated: !!jwt.getToken(),
		remember: false,
		error: null,
	},
	getters: {
		getAccessToken: function (state) {
			return state.token.accessToken;
		},
		isAuthenticated: function (state) {
			return state.isAuthenticated;
		},
		getError: function (state) {
			return state.error;
		},
	},
	actions: {
		login({ commit, dispatch }, payload = {}) {
			http
				.post('/member/login', payload)
				.then(({ data }) => {
					const token = data.accessToken;
					commit('SET_TOKEN', 'Bearer ' + token);
					dispatch('getInfo');
				})
				.catch(err => {
					commit('ERROR_HANDLE', err);
				});
		},
		logout({ commit }) {
			return new Promise(res => {
				setTimeout(() => {
					commit('DESTROY_TOKEN');
					res();
				}, 1000);
			});
		},
		getInfo({ commit }) {
			http.get('/member/info').then(({ data }) => {
				commit('SET_USER_INFO', data);
				commit('ERROR_HANDLE', null);
			});
		},
	},
	mutations: {
		SET_TOKEN(state, token) {
			state.token.accessToken = token;
			state.isAuthenticated = true;
			jwt.saveToken(token);
		},
		DESTROY_TOKEN(state) {
			state.token.accessToken = '';
			state.isAuthenticated = false;
			state.user = null;
			jwt.destroyToken();
		},
		SET_USER_INFO(state, user) {
			state.user = user;
		},
		TOGGLE_REMEMBER(state) {
			state.remember = !state.remember;
		},
		ERROR_HANDLE(state, error) {
			state.error = error.response.data;
		},
	},
};

export default auth;
