import axios from 'axios';

const url = 'http://localhost:8080';
// axios 객체 생성
const http = axios.create({
	baseURL: 'http://localhost:8080',
	headers: {
		'Content-Type': 'application/json;charset=utf-8',
	},
});

export { url, http };
export default http;
