import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class recruitService {
	async getRecruitDetail(id) {
		return await http.get(`recruit/list/` + id, config).then(data => data.data);
	}
	async getRecruitList(param) {
		return await http
			.post(`recruit/list`, param, config)
			.then(data => data.data);
	}
}
