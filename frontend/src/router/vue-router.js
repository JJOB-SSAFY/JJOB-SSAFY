import { createRouter, createWebHistory } from 'vue-router';
import loginView from '../views/login/loginView.vue';
import registerView from '../views/register/registerView.vue';
import mainView from '@/views/main/mainView.vue';

import homepageView from '@/views/main/homepage/homepageView.vue';
import infoCardsView from '@/views/main/infoCards/infoCardsView.vue';
import presentationView from '@/views/main/presentation/presentationView.vue';
import recruitView from '@/views/main/recruit/recruitView.vue';
import recruitDetailView from '@/views/main/recruit/recruitDetailView.vue';
import reviewView from '@/views/main/review/reviewView.vue';
import reviewWriteView from '@/views/main/review/reviewWriteView.vue';
import myInfoView from '@/views/myInfo/myInfoView.vue';
import openviduView from '@/views/main/openvidu/conferenceView.vue';
import interviewView from '@/views/main/interview/interviewView.vue';
import resumeCreateView from '@/views/main/resume/resumeCreateView.vue';
import resumeDetailView from '@/views/main/resume/resumeDetailView.vue';
import test from '@/views/test.vue';
import jwt from '@/common/jwt';

const router = createRouter({
	history: createWebHistory(),
	routes: [
		{
			path: '/',
			redirect: '/login',
			meta: { authRequired: true },
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
					name: 'register',
					path: '/register',
					component: registerView,
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
					name: 'recruitDetail',
					path: '/recruit/detail/:recruitId',
					component: recruitDetailView,
				},
				{
					name: 'review',
					path: '/review',
					component: reviewView,
				},
				{
					name: 'reviewWrite',
					path: '/reviewWrite/:companyId/:companyName',
					component: reviewWriteView,
				},

				{
					name: 'interview',
					path: '/interview',
					component: interviewView,
				},
				{
					name: 'openVidu',
					path: '/openvidu/:participant/:session/:companyId/:companyName',
					component: openviduView,
				},
				{
					name: 'resumeCreate',
					path: '/resume/create',
					component: resumeCreateView,
				},
				{
					name: 'resumeDetail',
					path: '/resume/detail/:resumeId',
					component: resumeDetailView,
				},
				{
					name: 'myInfo',
					path: '/myInfo',
					component: myInfoView,
				},
			],
		},

		{
			name: 'test',
			path: '/test',
			component: test,
		},
	],
});

router.beforeEach((to, from, next) => {
	if (to.path != '/login') {
		if (jwt.getToken()) {
			next();
		} else {
			next('/login');
		}
	} else {
		next();
	}
});
export default router;
