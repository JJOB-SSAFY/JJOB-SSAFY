import { createRouter, createWebHistory } from 'vue-router';
import mainView from '@/views/main/mainView.vue';
import interviewView from '@/views/interview/interviewView.vue';

export default createRouter({
	history: createWebHistory(),
	routes: [
		{
			path: '/main',
			component: mainView,
		},
		{
			path: '/interview',
			component: interviewView,
		},
	],
});
