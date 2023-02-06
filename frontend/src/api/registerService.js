import http from './http.js';

const headers = localStorage.getItem('jjob.s.token');

export default class registerService {
	async signUpMember(params) {
		return await http
			.post(`member/signup`, params, headers)
			.then(data => data.data);
	}
}
