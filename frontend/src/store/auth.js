import http from '@/api/http';
import jwt from '@/common/jwt';
import vueRouter from '../router/vue-router';
import Swal from 'sweetalert2';

export const auth = {
	namespaced: true,
	state: () => ({
		user: null,
		role: null,
		name: null,
		companyId: null,
		resumeList: null,
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
		getResumeList: function (state) {
			return state.resumeList;
		},
		getError: function (state) {
			return state.error;
		},
		getName: function (state) {
			return state.name;
		},
		getCompanyId: function (state) {
			return state.companyId;
		},
	},
	actions: {
		login({ commit, dispatch }, payload = {}) {
			http
				.post('/member/login', payload)
				.then(function (response) {
					const token = 'Bearer ' + response.data.accessToken;
					commit('SET_TOKEN', token);
					commit('SET_USER', response.data);
					const config = {
						headers: {
							'Content-Type': 'application/json;charset=utf-8',
							Authorization: token,
						},
					};
					dispatch('getInfo', config);
					dispatch('getResumeList', config);
				})
				.then(() => vueRouter.push({ name: 'home' }))
				.catch(err => {
					Swal.fire({
						title: 'OOPS!',
						text: '이메일 비밀번호를 확인해주세요',
						icon: 'warning',
					});
					commit('ERROR_HANDLE', err);
				});
		},
		socialLogin({ commit, dispatch }, loginInfo) {
			const token = 'Bearer ' + loginInfo.accessToken;
			commit('SET_TOKEN', token);
			commit('SET_USER', loginInfo);
			const config = {
				headers: {
					'Content-Type': 'application/json;charset=utf-8',
					Authorization: token,
				},
			};
			dispatch('getInfo', config);
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
		getResumeList({ commit }, payload) {
			http
				.get('/resume', payload)
				.then(({ data }) => {
					commit('SET_RESUME_LIST', data);
				})
				.catch(err => {
					commit('ERROR_HANDEL', err);
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
			state.name = null;
			state.resumeList = null;
			state.companyId = null;
			jwt.destroyToken();
		},
		SET_USER_INFO(state, user) {
			state.user = user;
		},
		SET_USER(state, data) {
			state.role = data.role;
			state.name = data.name;
			state.companyId = data.companyId;
		},
		SET_RESUME_LIST(state, list) {
			state.resumeList = list;
		},
		TOGGLE_REMEMBER(state) {
			state.remember = !state.remember;
		},
		ERROR_HANDLE(state, error) {
			state.error = error.response.data;
		},
	},
};
