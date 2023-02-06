import http from './http.js';

export default class registerService {
	async signUpMember(params) {
		return await http.post(`member/signup`, params).then(data => data.data);
	}
}
