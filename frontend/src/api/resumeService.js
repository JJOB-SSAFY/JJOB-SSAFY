import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
  headers: {
    Authorization: token,
  },
};
export default class resumeService {
  async register(params) {
    return await http.post(`resume`, params, config).then(data => data.data);
  }
}
