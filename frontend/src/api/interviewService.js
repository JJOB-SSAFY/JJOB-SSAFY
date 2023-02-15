import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class interviewService {
	async getInterviewList() {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');

		return await http
			.get(`/conference/list/INTERVIEW`, config)
			.then(data => data.data);
	}
}
