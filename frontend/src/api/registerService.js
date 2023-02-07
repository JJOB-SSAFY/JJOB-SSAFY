import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class registerService {
	async signUpMember(params) {
		return await http
			.post(`member/signup`, params, config)
			.then(data => data.data);
	}
}
