const JJOB_AUTH_TOKEN = 'jjob.s.token';

export const getToken = () => {
	return window.localStorage.getItem(JJOB_AUTH_TOKEN);
};

export const saveToken = token => {
	window.localStorage.setItem(JJOB_AUTH_TOKEN, token);
};

export const destroyToken = () => {
	window.localStorage.removeItem(JJOB_AUTH_TOKEN);
};

export default {
	getToken,
	saveToken,
	destroyToken,
};
