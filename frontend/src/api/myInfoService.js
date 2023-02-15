import http from './http.js';
const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class myInfoService {
	async updateCard(param) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');

		return await http.patch(`myinfo`, param, config);
	}
	async changePwd(param) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');

		return await http.patch(`myinfo/pwd`, param, config);
	}
	async getMyRecruit() {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');

		return await http.get(`myinfo/apply`, config).then(data => data.data);
	}
}
