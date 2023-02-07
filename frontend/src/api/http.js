import axios from 'axios';

const url = "http://locahost:8080'";
// axios 객체 생성
const http = axios.create({
	baseURL: url,
	headers: {
		'Content-Type': 'application/json;charset=utf-8',
	},
});

export default { http, url };
