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
				<div class="login-form mt-55">
					<form @submit.prevent>
						<input
							class="font-LINE-Rg"
							v-model.lazy.trim="loginState.form.email"
							type="text"
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
								<input
									type="checkbox"
									v-model="emailSave"
									true-value="true"
									fasle-value="false"
								/>
								<span class="font-LINE-Rg">기억하기</span>
							</div>
							<!-- <div class="forget-password font-LINE-Rg" >
								<a href="#">비밀번호를 잊어버리셨나요? </a>
							</div> -->
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
import { useCookies } from 'vue3-cookies';
import Swal from 'sweetalert2';

export default {
	name: 'loginView',

	setup() {
		const store = useStore();
		const emailValidCk = ref(false);
		const emailSave = ref('false');
		const inputEmail = ref();
		const inputPassword = ref();
		const { cookies } = useCookies();
		const loginState = reactive({
			form: {
				email: cookies.get('emailCookie'),
				password: '',
			},
		});
		const emailValid = param => {
			var expert = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if (expert.test(param)) {
				emailValidCk.value = true;
			} else {
				emailValidCk.value = false;
			}
		};
		const Login = () => {
			if (!loginState.form.email) {
				Swal.fire({
					title: 'OOPS!',
					text: '이메일을 입력해주세요',
					icon: 'warning',
					showConfirmButton: false,
					timer: 1200,
				});
				return;
			} else if (!loginState.form.password) {
				Swal.fire({
					title: 'OOPS!',
					text: '비밀번호를 입력해주세요',
					icon: 'warning',
					showConfirmButton: false,
					timer: 1200,
				});
				return;
			}
			// tlwkrwrkwkr
			emailValid(loginState.form.email);
			if (!emailValidCk.value) {
				Swal.fire({
					title: 'OOPS!',
					text: '이메일 형식에 맞게 입력해주세요',
					icon: 'warning',
					showConfirmButton: false,
					timer: 1200,
				});
				return;
			}
			const loginInfo = {
				email: loginState.form.email,
				password: loginState.form.password,
			};
			store.dispatch('auth/login', loginInfo).then(() => {
				if (emailSave.value == 'true') {
					cookies.set('emailCookie', loginState.form.email);
				} else {
					cookies.set('emailCookie', '');
				}
			});
		};
		const kakaoLogin = () => {
			location.href = 'http://localhost:8080/oauth2/authorization/kakao';
		};

		const googleLogin = () => {
			location.href = 'http://localhost:8080/oauth2/authorization/google';
		};
		return {
			loginState,
			Login,
			kakaoLogin,
			googleLogin,
			inputEmail,
			inputPassword,
			emailSave,
			cookies,
		};
	},
};
</script>
