<template>
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
			<li v-for="nav in navigations" :key="nav.name" class="nav-item">
				<router-link :to="nav.href" class="nav-link font-LINE-Bd">
					{{ nav.name }}
				</router-link>
			</li>
		</ul>

		<ul v-if="!token" class="navbar-icons" ref="icons">
			<li>
				<router-link to="/login" class="navbar-icon">
					<fa-icon icon="fa-solid fa-right-to-bracket" />
					<span> 로그인 </span>
				</router-link>
			</li>
			<li>
				<router-link to="/register" class="navbar-icon">
					<fa-icon icon="fa-solid fa-user-plus" /><span>
						회원가입</span
					></router-link
				>
			</li>
		</ul>
		<ul v-else class="navbar-icons" ref="icons">
			<li>
				<router-link to="/myInfo" class="navbar-icon">
					<fa-icon icon="fas fa-solid fa-user " />
					<span> 마이페이지 </span>
				</router-link>
			</li>
			<li>
				<router-link to="/register" class="navbar-icon">
					<fa-icon icon="fas fa-solid fa-right-from-bracket" />
					<span>로그아웃</span>
				</router-link>
			</li>
		</ul>

		<a @click="menuClick" class="navbar-toggleBtn">
			<fa-icon icon="fa-solid fa-bars" />
		</a>
	</nav>
</template>

<script>
import { ref } from 'vue';
import { useStore } from 'vuex';

export default {
	setup() {
		const menuActive = ref(null);
		const store = useStore();

		const token = store.getters['auth/isAuthenticated'];
		const navigations = [
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
		];

		const menuClick = () => {
			menuActive.value = !menuActive.value;
		};

		const logout = () => {};

		return { navigations, menuActive, menuClick, token };
	},
};
</script>

<style lang="scss" scoped></style>
