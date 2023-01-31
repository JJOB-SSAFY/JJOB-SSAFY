<template>
	<div
		:class="`theme-main-menu sticky-menu theme-menu-five ${
			isSticky ? 'fixed' : ''
		}`"
	>
		<div class="d-flex align-items-center justify-content-center">
			<div class="logo">
				<router-link to="/">
					<img src="@/assets/images/logo.png" alt="" height="70" width="100" />
				</router-link>
			</div>

			<nav id="mega-menu-holder" class="navbar navbar-expand-lg">
				<div class="nav-container">
					<button
						class="navbar-toggler"
						data-bs-toggle="collapse"
						data-bs-target="#collapsibleNavbar"
						:class="menuActive ? 'navbar-toggler open' : 'navbar-toggler'"
						@click="menuActive = !menuActive"
					>
						<span></span>
					</button>
					<div
						:class="
							menuActive
								? 'navbar-collapse collapse ss'
								: 'navbar-collapse collapse'
						"
						id="collapsibleNavbar"
					>
						<div class="d-lg-flex justify-content-between align-items-center">
							<ul
								class="navbar-nav main-side-nav font-gordita"
								id="one-page-nav"
							>
								<li v-for="nav in navigations" :key="nav.name" class="nav-item">
									<router-link :to="nav.href" class="nav-link">
										{{ nav.name }}
									</router-link>
								</li>
								<!-- 			
								<li class="nav-item">
									<a class="nav-link" href="/main">Home</a>
								</li>
								<li class="nav-item">
									<a href="#feature" class="nav-link">Features</a>
								</li>
								<li class="nav-item">
									<a href="#feature" class="nav-link">Features</a>
								</li>
								<li class="nav-item">
									<a href="#feature" class="nav-link">Features</a>
								</li>
								<li class="nav-item">
									<a href="#feature" class="nav-link">Features</a>
								</li> -->
							</ul>
						</div>
					</div>
				</div>
			</nav>
			<div class="right-widget">
				<v-if></v-if>
				<ul class="d-flex align-items-center">
					<li>
						<router-link
							to="/login"
							class="signIn-action d-flex align-items-center"
						>
							<img src="@/assets/images/icon/lock.svg" alt="" />
							<span>로그인</span>
						</router-link>
					</li>
					<li>
						<router-link to="/register" class="signup-btn"
							><span>회원가입</span></router-link
						>
					</li>
				</ul>
				<v-else></v-else>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	setup() {
		const isSticky = false;
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
		const handleSticky = () => {
			if (window.scrollY > 80) {
				this.isSticky = true;
			} else {
				this.isSticky = false;
			}
		};

		return { navigations, isSticky, handleSticky };
	},
};
</script>
