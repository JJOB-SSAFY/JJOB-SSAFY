<template>
	<div style="position: fixed; bottom: 35px; right: 35px; font-size: 35px">
		<a href="javascript:window.scrollTo(0,0);"
			><fa-icon icon="fas fa-solid fa-chevron-up"
		/></a>
	</div>
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
				<li class="li-empty mt-50"></li>

				<li>
					<router-link to="/myInfo" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-user" />
						<span> &nbsp마이페이지 </span>
					</router-link>
				</li>

				<li v-if="role === 'COMPANY'">
					<router-link to="/recruit/create" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-building" />
						<span> &nbsp공고등록 </span>
					</router-link>
				</li>
				<li v-if="role === 'ADMIN'">
					<router-link to="/register" class="navbar-icon">
						<fa-icon icon="fas fa-solid fa-user-plus" />
						<span> &nbsp회원등록 </span>
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
				<input id="menu-toggle" type="checkbox" />
				<label class="menu-btn" for="menu-toggle">
					<span></span>
				</label>
				<ul
					:class="`navbar-icons menu-box ${role === 'USER' ? '' : 'five'}`"
					ref="icons"
				>
					<li class="li-empty mt-50"></li>
					<li>
						<router-link to="/myInfo" class="navbar-icon menu-item">
							<fa-icon icon="fas fa-solid fa-user" />
							<span> &nbsp마이페이지 </span>
						</router-link>
					</li>

					<li v-if="role === 'COMPANY'">
						<router-link to="/recruit/create" class="navbar-icon menu-item">
							<fa-icon icon="fas fa-solid fa-building" />
							<span> &nbsp공고등록 </span>
						</router-link>
					</li>
					<li v-if="role === 'ADMIN'">
						<router-link to="/register" class="navbar-icon menu-item">
							<fa-icon icon="fas fa-solid fa-user-plus" />
							<span> &nbsp회원등록 </span>
						</router-link>
					</li>
					<li>
						<router-link to="/login" class="navbar-icon menu-item">
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
			// {
			// 	name: '설명회',
			// 	href: '/present',
			// },
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

<style scoped></style>
