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
  async register(parma) {
    return await http.post(`/member/join`, config);
  }
}
