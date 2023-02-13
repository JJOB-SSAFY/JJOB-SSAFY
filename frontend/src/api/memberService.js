import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class memberService {
	async emailCheck(param) {
		return await http.get(`/member/${param}`, config);
	}
	async registerUser(param) {
		return await http.post(`/member/join`, param, config);
	}
}
