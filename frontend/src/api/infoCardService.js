import http from './http.js';
const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class infoCardService {
	async getCardList() {
		return await http.get(`card`, config).then(data => data.data);
	}
	async getCardList(param) {
		return await http
			.post(`card`, param, config)
			.then(data => data.data);
	}
}
