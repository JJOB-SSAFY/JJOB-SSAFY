<template>
	<section class="login-section">
		<div class="login-logo"></div>
		<div class="login-div">
			<div class="row">
				<div class="col-12">
					<div class="input-group mb-80 sm-mb-70">
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
					<div class="input-group mb-15">
						<label>비밀번호</label>
						<input
							v-model.lazy.trim="loginState.form.password"
							required
							:type="hidePassword ? 'text' : 'password'"
							placeholder="비밀번호를 입력하세요"
							ref="password"
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
					<div class="agreement-checkbox">
						<div>
							<input type="checkbox" id="remember" />
							<label for="remember">로그인 기억하기</label>
						</div>
						<a href="#">비밀번호를 잊어버리셨나요? </a>
					</div>
				</div>
				<div class="col-12">
					<button
						class="login-btn mt-50 mb-50 font-LINE-Bd"
						@click="Login"
						@keyup.enter="Login"
					>
						로그인
					</button>
				</div>
			</div>
		</div>
	</section>
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

			console.log('asbasd' + store.getters['auth/isAuthenticated']);
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
