const JJOB_AUTH_TOKEN = 'jjob.s.token';

export const getToken = () => {
	return window.sessionStorage.getItem(JJOB_AUTH_TOKEN);
};

export const saveToken = token => {
	window.sessionStorage.setItem(JJOB_AUTH_TOKEN, token);
};

export const destroyToken = () => {
	window.sessionStorage.removeItem(JJOB_AUTH_TOKEN);
};

export default {
	getToken,
	saveToken,
	destroyToken,
};
