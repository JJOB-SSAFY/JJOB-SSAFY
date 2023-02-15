import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class memberService {
	async emailCheck(param) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');

		return await http.get(`/member/${param}`, config);
	}
	async registerUser(param) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');

		return await http.post(`/member/join`, param, config);
	}
}
