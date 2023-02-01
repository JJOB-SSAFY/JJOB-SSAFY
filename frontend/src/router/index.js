import { createRouter, createWebHistory } from 'vue-router';
import loginView from '../views/login/loginView.vue';
import registerView from '../views/register/registerView.vue';
import mainView from '@/views/main/mainView.vue';

import homepageView from '@/views/main/homepage/homepageView.vue';
import interviewView from '@/views/main/interview/interviewView.vue';
import infoCardsView from '@/views/main/infoCards/infoCardsView.vue';
import presentationView from '@/views/main/presentation/presentationView.vue';
import recruitView from '@/views/main/recruit/recruitView.vue';
import reviewView from '@/views/main/review/reviewView.vue';
import myInfoView from '@/views/main/myInfo/myInfoView.vue';

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
					path: '/home',
					component: homepageView,
				},
				{
					path: '/interview',
					component: interviewView,
				},
				{
					path: '/infoCards',
					component: infoCardsView,
				},
				{
					path: '/present',
					component: presentationView,
				},
				{
					path: '/recruit',
					component: recruitView,
				},
				{
					path: '/review',
					component: reviewView,
				},
				{
					path: '/myInfo',
					component: myInfoView,
				},
			],
		},
		{
			path: '/register',
			component: registerView,
		},
	],
});
