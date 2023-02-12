import http from './http.js';
const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class myInfoService {
	async updateCard(param) {
		return await http.patch(`myinfo`, param, config);
	}
	async changePwd(param) {
		return await http.patch(`myinfo/pwd`, param, config);
	}
	async getMyRecruit() {
		return await http.get(`myinfo/apply`, config).then(data => data.data);
	}
}
