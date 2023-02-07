import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class interviewService {
	async getPresentList() {
		return await http
			.get(`/conference/list/PRESENTATION`, config)
			.then(data => data.data);
	}
}
