import http from './http.js';
const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class infoCardService {
	async getCardList() {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');

		return await http.get(`card`, config).then(data => data.data);
	}
	async getSearchCardList(param) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');
		return await http.post(`card`, param, config).then(data => data.data);
	}
}
