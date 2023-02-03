import { createRouter, createWebHistory } from 'vue-router';
import loginView from '../views/login/loginView.vue';
import registerView from '../views/register/registerView.vue';
import mainView from '@/views/main/mainView.vue';

import homepageView from '@/views/main/homepage/homepageView.vue';
import infoCardsView from '@/views/main/infoCards/infoCardsView.vue';
import presentationView from '@/views/main/presentation/presentationView.vue';
import recruitView from '@/views/main/recruit/recruitView.vue';
import reviewView from '@/views/main/review/reviewView.vue';
import myInfoView from '@/views/main/myInfo/myInfoView.vue';
import openviduView from '@/views/main/openvidu/conferenceView.vue';

export default createRouter({
	history: createWebHistory(),
	routes: [
		{
			path: '/',
			redirect: '/main',
		},
		{
			path: '/login',
			component: loginView,
		},
		{
			path: '/main',
			component: mainView,
			redirect: '/home',
			children: [
				{
					name: 'home',
					path: '/home',
					component: homepageView,
				},
				{
					name: 'infoCards',
					path: '/infoCards',
					component: infoCardsView,
				},
				{
					name: 'present',
					path: '/present',
					component: presentationView,
				},
				{
					name: 'recruit',
					path: '/recruit',
					component: recruitView,
				},
				{
					name: 'review',
					path: '/review',
					component: reviewView,
				},
				{
					name: 'myInfo',
					path: '/myInfo',
					component: myInfoView,
				},
				{
					name: 'openVidu',
					path: '/openvidu/:participant/:session',
					component: openviduView,
				},
			],
		},
		{
			name: 'register',
			path: '/register',
			component: registerView,
		},
	],
});
