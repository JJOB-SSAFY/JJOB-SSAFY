<template>
	<div class="user-data-page clearfix d-lg-flex">
		<div
			class="illustration-wrapper d-flex align-items-center justify-content-between flex-column"
		>
			<h3 class="font-LINE-Bd">취업할래? <br />JJOP SSAFY</h3>
			<div class="illustration-holder">
				<img
					src="@/assets/images/logo-removebg.png"
					alt=""
					class="illustration"
				/>
			</div>
		</div>
		<!-- /.illustration-wrapper -->

		<div class="form-wrapper">
			<div class="d-flex justify-content-between">
				<div class="logo">
					<router-link to="/"> </router-link>
				</div>
				<router-link to="/" class="font-rubik go-back-button"
					>홈으로</router-link
				>
			</div>
			<div class="user-data-form mt-80 md-mt-40">
				<p class="header-info pt-30 pb-50"></p>
				<div class="row">
					<div class="col-12">
						<div class="input-group-meta mb-80 sm-mb-70">
							<label>이메일</label>
							<input
								v-model.lazy.trim="loginState.form.email"
								required
								type="email"
								placeholder="email@naver.com"
								ref="email"
							/>
						</div>
					</div>
					<div class="col-12">
						<div class="input-group-meta mb-15">
							<label class="font-LINE-Bd">비밀번호</label>
							<input
								v-model.lazy.trim="loginState.form.password"
								required
								:type="hidePassword ? 'text' : 'password'"
								placeholder="Enter Password"
								class="pass_log_id"
								ref="passowrd"
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
								<input type="checkbox" id="remember" />
								<label for="remember">로그인 기억하기</label>
							</div>
							<a href="#">비밀번호를 잊어버리셨나요? </a>
						</div>
						<!-- /.agreement-checkbox -->
					</div>
					<div class="col-12">
						<button
							class="theme-btn-one mt-50 mb-50 font-LINE-Bd"
							@click="Login"
							@keyup.enter="Login"
						>
							로그인
						</button>
					</div>
					<div class="col-12">
						<p class="text-center font-LINE-Rg copyright-text"></p>
					</div>
				</div>
			</div>
		</div>
		<!-- /.form-wrapper -->
	</div>
</template>

<script>
import { ref, reactive } from 'vue';
import { computed, watch } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
export default {
	name: 'loginView',
	setup() {
		const hidePassword = ref(false);

		const handleHidePassword = () => {
			hidePassword.value = !hidePassword.value;
		};

		const store = useStore();
		const router = useRouter();

		const token = ref('');

		const loginState = reactive({
			form: {
				email: '',
				password: '',
			},
		});
		const email = ref(null);
		const password = ref(null);

		const Login = () => {
			if (!loginState.form.email) {
				alert('아이디를 입력해주세요');
				email.value.focus();
				return;
			} else if (!loginState.form.password) {
				alert('비밀번호를 입력해주세요');
				password.value.focus();
				return;
			}

			const loginInfo = {
				email: loginState.form.email,
				password: loginState.form.password,
			};
			store.dispatch('auth/login', loginInfo);

			console.log(store.getters['auth/isAuthenticated']);
		};
		watch(
			() => store.getters['auth/isAuthenticated'],
			function () {
				console.log('watch ');
			},
		);

		return {
			hidePassword,
			loginState,
			handleHidePassword,
			Login,
		};
	},
};
</script>
