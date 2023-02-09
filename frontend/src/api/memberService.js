import http from './http.js';

const token = localStorage.getItem('jjob.s.token');
const config = {
  headers: {
    Authorization: token,
  },
};
export default class memberService {
  async emailCheck(param) {
    return await http.get(`/member/${param}`, config);
  }
  async registerUser(param) {
    return await http.post(`/member/join`, param, config);
  }
  async registerCompany(param) {
    await http.post(`/company`, param, config).then(data => data.data);
  }
  async getCompany() {
    return await http.get(`/company`, config).then(data => console.log(data));
  }
}
