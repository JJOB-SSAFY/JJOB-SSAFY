<template>
	<div>
		<nav class="navbar">
			<div class="navbar-logo">
				<router-link to="/main">
					<img
						src="@/assets/images/logo/logo-removebg.png"
						alt=""
						height="77"
						width="110"
					/>
				</router-link>
			</div>
			<ul :class="`navbar-menu ${role === 'USER' ? '' : 'five'}`" ref="menu">
				<li v-for="nav in filterNav" :key="nav.name" class="nav-item">
					<router-link :to="nav.href" class="nav-link font-LINE-Bd">
						{{ nav.name }}
					</router-link>
				</li>
			</ul>

			<ul
				:class="`navbar-icons screen_big ${role === 'USER' ? '' : 'five'}`"
				ref="icons"
			>
				<li v-if="role === 'ADMIN'">
					<router-link to="/register" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-user-plus" />
						<span> &nbsp회원등록 </span>
					</router-link>
				</li>
				<li>
					<router-link to="/myInfo" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-user" />
						<span> &nbsp마이페이지 </span>
					</router-link>
				</li>
				<li>
					<router-link to="/login" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-right-from-bracket" />
						<span v-on:click="logout">&nbsp로그아웃</span>
					</router-link>
				</li>
				<register-view />
			</ul>
			<div class="hamburger-menu">
				<input id="menu__toggle" type="checkbox" />
				<label class="menu__btn" for="menu__toggle">
					<span></span>
				</label>
				<ul
					:class="`navbar-icons menu__box ${role === 'USER' ? '' : 'five'}`"
					ref="icons"
				>
					<li v-if="role === 'ADMIN'">
						<router-link to="/register" class="navbar-icon menu__item">
							<fa-icon icon="fas fa-solid fa-user-plus" />
							<span> &nbsp회원등록 </span>
						</router-link>
					</li>
					<li>
						<router-link to="/myInfo" class="navbar-icon menu__item">
							<fa-icon icon="fas fa-solid fa-user" />
							<span> &nbsp마이페이지 </span>
						</router-link>
					</li>
					<li>
						<router-link to="/login" class="navbar-icon menu__item">
							<fa-icon icon="fas fa-solid fa-right-from-bracket" />
							<span v-on:click="logout">&nbsp로그아웃</span>
						</router-link>
					</li>
				</ul>
			</div>
			<a @click="menuClick" class="navbar-toggleBtn">
				<fa-icon icon="fa-solid fa-bars" />
			</a>
		</nav>
	</div>
</template>

<script>
import { ref, computed } from 'vue';
import { useStore } from 'vuex';

export default {
	setup() {
		const menuActive = ref(null);
		const store = useStore();

		const role = ref(store.getters['auth/getUserRole']);
		const filterNav = computed(() => {
			return role.value === 'USER'
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

			const nav = document.querySelector('.navbar-menu');
			const ni = document.querySelector('.navbar-icons');

			nav.classList.toggle('active');
			ni.classList.toggle('active');
		};

		const logout = () => {
			console.log(store.getters['auth/getUserInfo']);
			console.log(store.getters['auth/getUserRole']);
			console.log(localStorage.getItem('jjob.s.token'));

			// console.log(localToken);
			if (localStorage.getItem('jjob.s.token')) {
				store.dispatch('auth/logout');
			}
		};
		return {
			role,
			navigations,
			filterNav,
			menuActive,
			menuClick,
			logout,
		};
	},
};
</script>

<style scoped>
#menu__toggle {
	opacity: 0;
}
#menu__toggle:checked + .menu__btn > span {
	transform: rotate(45deg);
}
#menu__toggle:checked + .menu__btn > span::before {
	top: 0;
	transform: rotate(0deg);
}
#menu__toggle:checked + .menu__btn > span::after {
	top: 0;
	transform: rotate(90deg);
}
#menu__toggle:checked ~ .menu__box {
	right: 0 !important;
}
.menu__btn {
	position: fixed;
	top: 20px;
	right: 20px;
	width: 26px;
	height: 26px;
	cursor: pointer;
	z-index: 1;
}
.menu__btn > span,
.menu__btn > span::before,
.menu__btn > span::after {
	display: block;
	position: absolute;
	width: 100%;
	height: 2px;
	background-color: #616161;
	transition-duration: 0.25s;
}
.menu__btn > span::before {
	content: '';
	top: -8px;
}
.menu__btn > span::after {
	content: '';
	top: 8px;
}
.menu__box {
	display: block;
	position: fixed;
	top: 0;
	right: -100%;
	width: 300px;
	height: 100%;
	margin: 0;
	padding: 80px 0;
	list-style: none;
	background-color: #eceff1;
	box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.4);
	transition-duration: 0.25s;
}
.menu__item {
	display: block;
	padding: 12px 24px;
	color: #333;
	font-family: 'Roboto', sans-serif;
	font-size: 20px;
	font-weight: 600;
	text-decoration: none;
	transition-duration: 0.25s;
}
.menu__item:hover {
	background-color: #cfd8dc;
}
</style>
