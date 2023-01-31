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
								<li class="nav-item">
									<a class="nav-link" href="/main">Home</a>
								</li>
								<li class="nav-item">
									<a href="#feature" class="nav-link"
										><span @click.self="menuActive = !menuActive"
											>Features</span
										></a
									>
								</li>
								<li class="nav-item">
									<a href="#effect" class="nav-link"
										><span @click.self="menuActive = !menuActive"
											>Effects</span
										></a
									>
								</li>
								<li class="nav-item">
									<a href="#template" class="nav-link"
										><span @click.self="menuActive = !menuActive"
											>Template</span
										></a
									>
								</li>
								<li class="nav-item">
									<a href="/interview" class="nav-link"
										><span @click.self="menuActive = !menuActive"
											>interview</span
										></a
									>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</nav>
			<div class="right-widget">
				<ul class="d-flex align-items-center">
					<li>
						<router-link
							to="/login"
							class="signIn-action d-flex align-items-center"
						>
							<img src="@/assets/images/icon/lock.svg" alt="" />
							<span>login</span>
						</router-link>
					</li>
					<li>
						<router-link to="/register" class="signup-btn"
							><span>Sign up</span></router-link
						>
					</li>
				</ul>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: 'HeaderEight',

	data() {
		return {
			isSticky: false,
			menuActive: false,
		};
	},
	methods: {
		handleSticky() {
			if (window.scrollY > 80) {
				this.isSticky = true;
			} else {
				this.isSticky = false;
			}
		},
	},
	mounted() {
		window.addEventListener('scroll', this.handleSticky);
	},
};
</script>
