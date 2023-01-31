<template>
	<div class="user-data-page clearfix d-lg-flex">
		<div
			class="illustration-wrapper d-flex align-items-center justify-content-between flex-column"
		>
			<h3 class="font-LINE-Rg">
				회원가입하세요 <br />SSAFY
				<router-link to="/register">sign up</router-link>
			</h3>
			<div class="illustration-holder">
				<img
					src="../../assets/images/assets/ils_08.svg"
					alt=""
					class="illustration"
				/>
				<img
					src="../../assets/images/assets/ils_08.1.svg"
					alt=""
					class="shapes shape-one"
				/>
				<img
					src="../../assets/images/assets/ils_08.2.svg"
					alt=""
					class="shapes shape-two"
				/>
			</div>
		</div>
		<!-- /.illustration-wrapper -->

		<div class="form-wrapper">
			<div class="d-flex justify-content-between">
				<div class="logo">
					<router-link to="/">
						<img src="../../assets/images/logo/deski_01.svg" alt="" />
					</router-link>
				</div>
				<router-link to="/" class="font-LINE-Rg go-back-button"></router-link>
			</div>
			<form @submit.prevent="onSubmit" class="user-data-form mt-80 md-mt-40">
				<h2>
					로그인을 진행하세요 <br />
					로그인
				</h2>
				<p class="header-info pt-30 pb-50">
					아직 회원이 아니신가요??
					<router-link to="/register">Sign up</router-link>
				</p>

				<div class="row">
					<div class="col-12">
						<div class="input-group-meta mb-80 sm-mb-70">
							<label>Email</label>
							<input required type="email" placeholder="이메일을 입력하세요." />
						</div>
					</div>
					<div class="col-12">
						<div class="input-group-meta mb-15">
							<label>Password</label>
							<input
								required
								:type="hidePassword ? 'text' : 'password'"
								placeholder="비밀번호를 입력하세요"
								class="pass_log_id"
							/>
							<span class="placeholder_icon">
								<span
									:class="`passVicon ${hidePassword ? 'hide-pass' : ''}`"
									@click="handleHidePassword"
								>
									<img src="../../assets/images/icon/view.svg" alt="" />
								</span>
							</span>
						</div>
					</div>
					<div class="col-12">
						<div
							class="agreement-checkbox d-flex justify-content-between align-items-center"
						>
							<div>
								<input required type="checkbox" id="remember" />
								<label for="remember">로그인 유지하기</label>
							</div>
							<a href="#">비밀번호 까먹</a>
						</div>
						<!-- /.agreement-checkbox -->
					</div>
					<div class="col-12">
						<button class="theme-btn-one mt-50 mb-50">Login</button>
					</div>
					<div class="col-12"></div>
				</div>
			</form>
		</div>
		<!-- /.form-wrapper -->
	</div>
</template>

<script>
export default {
	name: 'LoginArea',
	data() {
		return {
			hidePassword: false,
		};
	},
	methods: {
		onSubmit() {
			console.log('Submitted');
		},
		handleHidePassword() {
			this.hidePassword = !this.hidePassword;
		},
	},
};
</script>
