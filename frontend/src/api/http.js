import axios from 'axios';

// axios 객체 생성
const http = axios.create({
	baseURL: 'http://localhost:8080',
	headers: {
		'Content-Type': 'application/json;charset=utf-8',
	},
});

export default http;
