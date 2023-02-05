const REST_API_KEY = '9d1f2abed3ce46931ff7abf4b7f8a31a';
const REDIRECT_URL = 'http://localhost:8080/oauth2/authorization/kakao';
export const KAKAO_AUTH_URL = `https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URL}&response_type=code`;
