import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};

export default class reviewService {
	async getList(param) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');

		return await http
			.post(`/review/list`, param, config)
			.then(data => data.data);
	}
}
