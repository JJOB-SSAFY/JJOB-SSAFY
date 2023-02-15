import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};

export default class resumeService {
	async getMyResumeList() {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');
		return await http.get(`resume/isapplied`, config).then(data => data.data);
	}

	async getResume(id, params) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');
		return await http
			.get(`resume/${id}`, params, config)
			.then(data => data.data);
	}
	async register(params) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');
		return await http.post(`resume`, params, config).then(data => data.data);
	}

	async modify(id, params) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');
		return await http
			.patch(`resume/${id}`, params, config)
			.then(data => data.data);
	}

	async deleteResume(id) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');
		return await http.delete(`resume/${id}`, config).then(data => data.data);
	}
}
