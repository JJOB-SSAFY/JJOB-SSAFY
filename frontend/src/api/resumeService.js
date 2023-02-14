import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class resumeService {
	async getResumeList() {
		return await http.get(`resume/isapplied`, config).then(data => data.data);
	}

	async getResume(id, params) {
		return await http
			.get(`resume/${id}`, params, config)
			.then(data => data.data);
	}
	async register(params) {
		return await http.post(`resume`, params, config).then(data => data.data);
	}

	async modify(id, params) {
		return await http
			.patch(`resume/${id}`, params, config)
			.then(data => data.data);
	}
}
