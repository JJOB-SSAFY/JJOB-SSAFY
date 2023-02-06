<template>
	<div class="login-section">
		<div class="div-illustration">
			<img src="../../assets/images/logo/logo-removebg.png" alt="logo" />
		</div>
		<div class="div-login">
			<div class="login-container">
				<h1 class="font-LINE-Bd mt-100">안녕하세요 <br />JJOB SSAFY입니다</h1>
				<div class="login-form mt-110">
					<form @submit.prevent="onSubmit">
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
								<a href="#">비밀번호를 잊어버리셨나요?</a>
							</div>
						</div>
						<div class="div-button">
							<button id="login-kakao-btn" @click="kakaoLogin">카카오</button>
							<button id="login-google-btn" @click="googleLogin">구글</button>
							<button @click="Login" class="font-LINE-Bd">로그인</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { ref, reactive } from 'vue';
import { watch } from 'vue';
import { useStore } from 'vuex';

import { REDIRECT_URL } from '@/common/OAuth.js';
// import { http } from '@/api/http.js';
export default {
	name: 'loginView',
	setup() {
		const hidePassword = ref(false);

		const handleHidePassword = () => {
			hidePassword.value = !hidePassword.value;
		};
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
			location.href = REDIRECT_URL;
		};
		// const kakaoLogin = () => {
		// 	console.log(window.Kakao);
		// 	window.Kakao.Auth.login({
		// 		scope: 'profile_neickname, acount_email',
		// 		success: this.getKakaoAccount,
		// 	});
		// };
		// const getKakaoAccount = () => {
		// 	window.Kakao.API.request({
		// 		url: '/v2/user/',
		// 	});
		// };

		const googleLogin = () => {
			location.href = 'http://localhost:8080/oauth2/authorization/google';
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
			kakaoLogin,
			googleLogin,
			inputEmail,
			inputPassword,
		};
	},
};
</script>
