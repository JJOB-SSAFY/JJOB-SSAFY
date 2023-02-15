import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
	headers: {
		Authorization: token,
	},
};
export default class applyService {
	async getApplyResumeList(id) {
		config.headers.Authorization = localStorage.getItem('jjob.s.token');
		return await http.get(`apply/${id}`, config).then(data => data.data);
	}

	// async getResume(id, params) {
	// 	return await http
	// 		.get(`apply/${id}`, params, config)
	// 		.then(data => data.data);
	// }
	// async registerApply(params) {
	// 	return await http.post(`apply`, params, config).then(data => data.data);
	// }

	// async modifyApply(id, params) {
	// 	return await http
	// 		.patch(`apply/${id}`, params, config)
	// 		.then(data => data.data);
	// }
}
