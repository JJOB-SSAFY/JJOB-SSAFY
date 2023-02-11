<template>
	<div class="login-section">
		<div class="div-illustration">
			<img src="../../assets/images/logo/logo-removebg.png" alt="logo" />
		</div>
		<div class="div-login">
			<div class="login-container">
				<h1 class="login-title font-LINE-Bd mt-100">
					안녕하세요 <br />JJOB SSAFY입니다
				</h1>
				<div class="login-form mt-110">
					<form @submit.prevent>
						<input
							class="font-LINE-Rg"
							v-model.lazy.trim="loginState.form.email"
							type="email"
							ref="inputEmail"
							placeholder="이메일을 입력해주세요"
						/>

						<input
							class="font-LINE-Rg"
							v-model.lazy.trim="loginState.form.password"
							type="password"
							ref="inputPassword"
							placeholder="비밀번호를 입력해주세요"
						/>
						<div class="div-sub-option">
							<div class="remember-form font-LINE-Rg">
								<input type="checkbox" />
								<span class="font-LINE-Rg">기억하기</span>
							</div>
							<div class="forget-password font-LINE-Rg">
								<a href="#">비밀번호를 잊어버리셨나요? </a>
							</div>
						</div>
						<div class="div-button">
							<button
								id="login-bt"
								@click="Login"
								@keyup.enter="Login"
								class="btnLightBlue btnFade font-LINE-Bd"
							>
								로그인
							</button>
							<p
								class="mt-80 font-LINE-Rg"
								style="border-width: 1px 0; border-style: solid"
							>
								소셜계정으로 로그인하기
							</p>
							<div class="div-social font-LINE-Rg mt-10">
								<button
									type="button"
									id="login-kakao-bt"
									@click="kakaoLogin"
								></button>
								<button
									type="button"
									id="login-google-bt"
									@click="googleLogin"
								></button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { ref, reactive } from 'vue';
import { useStore } from 'vuex';

export default {
	name: 'loginView',
	setup() {
		const store = useStore();

		const inputEmail = ref();
		const inputPassword = ref();

		const loginState = reactive({
			form: {
				email: '',
				password: '',
			},
		});

		const Login = () => {
			if (!loginState.form.email) {
				alert('아이디를 입력해주세요');
				inputEmail.value.focus();
				return;
			} else if (!loginState.form.password) {
				alert('비밀번호를 입력해주세요');
				inputPassword.value.focus();
				return;
			}

			const loginInfo = {
				email: loginState.form.email,
				password: loginState.form.password,
			};
			store.dispatch('auth/login', loginInfo);
		};
		const kakaoLogin = () => {
			location.href = 'http://localhost:8080/oauth2/authorization/kakao';
			// axios({
			// 	method: 'GET',
			// 	url: REDIRECT_URL,
			// }).then(res => {
			// 	console.log(res);
			// });
		};

		const googleLogin = () => {
			location.href = 'http://localhost:8080/oauth2/authorization/google';
		};
		// watch(
		// 	() => store.getters['auth/getUserInfo'],
		// 	function () {
		// 		console.log(store.getters['auth/getUserInfo']);
		// 	},
		// );
		// const test = computed(() => store.getters['auth/getUserInfo']);

		return {
			loginState,
			Login,
			kakaoLogin,
			googleLogin,
			inputEmail,
			inputPassword,
		};
	},
};
</script>
