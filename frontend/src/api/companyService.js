import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class companyService {
	async registerCompany(param) {
		await http.post(`/company`, param, config).then(data => data.data);
	}
	async getCompany() {
		return await http.get(`/company`, config).then(data => console.log(data));
	}
}
