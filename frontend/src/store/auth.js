import http from '@/api/http';
import jwt from '@/common/jwt';
import vueRouter from '../router/vue-router';

export const auth = {
	namespaced: true,
	state: () => ({
		user: null,
		role: null,
		token: {
			accessToken: jwt.getToken(),
		},
		isAuthenticated: !!jwt.getToken(),
		remember: false,
		error: null,
	}),
	getters: {
		getAccessToken: function (state) {
			return state.token.accessToken;
		},
		isAuthenticated: function (state) {
			return state.isAuthenticated;
		},
		getUserInfo: function (state) {
			return state.user;
		},
		getUserRole: function (state) {
			return state.role;
		},
		getError: function (state) {
			return state.error;
		},
	},
	actions: {
		login({ commit, dispatch }, payload = {}) {
			http
				.post('/member/login', payload)
				.then(function (response) {
					const token = 'Bearer ' + response.data.accessToken;
					commit('SET_TOKEN', 'Bearer ' + token);
					commit('SET_USER_ROLE', response.data.role);
					const config = {
						headers: {
							Authorization: token,
						},
					};
					dispatch('getInfo', config);
				})
				.then(() => vueRouter.push({ name: 'home' }))
				.catch(err => {
					commit('ERROR_HANDLE', err);
				});
		},
		logout({ commit }) {
			return new Promise(resolve => {
				setTimeout(() => {
					commit('DESTROY_TOKEN');
					resolve();
				}, 1000);
			});
		},

		getInfo({ commit }, payload) {
			http
				.get('/myinfo', payload)
				.then(({ data }) => {
					commit('SET_USER_INFO', data);
				})
				.catch(err => {
					commit('ERROR_HANDLE', err);
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
			state.role = null;
			jwt.destroyToken();
		},
		SET_USER_INFO(state, user) {
			state.user = user;
		},
		SET_USER_ROLE(state, role) {
			state.role = role;
		},
		TOGGLE_REMEMBER(state) {
			state.remember = !state.remember;
		},
		ERROR_HANDLE(state, error) {
			state.error = error.response.data;
		},
	},
};
