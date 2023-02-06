<template>
	<div>
		<nav class="navbar">
			<div class="navbar-logo">
				<router-link to="/">
					<img
						src="@/assets/images/logo/logo-removebg.png"
						alt=""
						height="47"
						width="80"
					/>
				</router-link>
			</div>
			<ul class="navbar-menu" ref="menu">
				<li v-for="nav in filterNav" :key="nav.name" class="nav-item">
					<router-link :to="nav.href" class="nav-link font-LINE-Bd">
						{{ nav.name }}
					</router-link>
				</li>
			</ul>

			<ul class="navbar-icons" ref="icons">
				<li v-if="`{{userGrade}} === 'C'`">
					<router-link to="/register" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-user " />
						<span> 회원등록 </span>
					</router-link>
				</li>
				<li>
					<router-link to="/myInfo" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-user " />
						<span> 마이페이지 </span>
					</router-link>
				</li>
				<li>
					<router-link to="/login" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-right-from-bracket" />
						<span v-on:click="logout">로그아웃</span>
					</router-link>
				</li>
				<register-view />
			</ul>
			<a @click="menuClick" class="navbar-toggleBtn">
				<fa-icon icon="fa-solid fa-bars" />
			</a>
		</nav>
	</div>
</template>

<script>
import { ref, reactive, computed } from 'vue';
import { useStore } from 'vuex';

export default {
	setup() {
		const role = ref(localStorage.getItem('role'));
		const menuActive = ref(null);
		const store = useStore();
		const userGrade = 'U';
		const filterNav = computed(() => {
			return userGrade === 'U'
				? navigations.value.filter(nav => !nav.name.includes('지원자정보'))
				: navigations.value;
		});
		const navigations = ref([
			{
				name: '채용공고',
				href: '/recruit',
			},
			{
				name: '리뷰',
				href: '/review',
			},
			{
				name: '설명회',
				href: '/present',
			},
			{
				name: '면접',
				href: '/interview',
			},
			{
				name: '지원자정보',
				href: '/infoCards',
			},
		]);
		const menuClick = () => {
			menuActive.value = !menuActive.value;
			console.log(menuActive.value);

			const nav = document.querySelector('.navbar-menu');
			const ni = document.querySelector('.navbar-icons');

			nav.classList.toggle('active');
			ni.classList.toggle('active');
		};

		const logout = () => {
			console.log('sgi' + store.getters.isAuthenticated);
			console.log(localStorage.getItem('jjob.s.token'));
			// console.log(localToken);
			if (localStorage.getItem('jjob.s.token')) {
				store.dispatch('auth/logout');
			}
		};
		return {
			navigations,
			filterNav,
			menuActive,
			menuClick,
			logout,
		};
	},
	onMounted() {
		this.token = ref(localStorage.getItem('jjob.s.token'));
	},
};
</script>

<style lang="scss" scoped></style>
