<template>
	<div class="register-section">
		<div class="div-illustration">
			<img src="../../assets/images/logo/logo-removebg.png" alt="logo" />
		</div>
		<div class="div-register">
			<div class="register-container">
				<h1 class="font-LINE-Bd mt-100">안녕하세요 <br />JJOB SSAFY입니다</h1>
				<div class="register-form mt-110">
					<form @submit.prevent="register">
						<input
							class="font-LINE-Rg"
							type="email"
							placeholder="이메일을 입력해주세요"
							ref="inputEmail"
						/>
						<div v-if="invalidEmail">이미 등록된 이메일 입니다.</div>
						<input
							class="font-LINE-Rg"
							type="password"
							placeholder="비밀번호를 입력해주세요"
						/>
						<input
							class="font-LINE-Rg"
							type="password"
							placeholder="비밀번호를 입력해주세요"
						/>
						<input
							class="font-LINE-Rg"
							type="text"
							placeholder="이름을 입력해주세요"
						/>
						<div class="div-button">
							<button class="font-LINE-Bd"></button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { reactive, ref } from 'vue';
export default {
	name: 'registerView',
	setup() {
		const invalidEmail = ref(false);
		const register = () => {
			console.log('register');
		};
		return {
			register,
			invalidEmail,
		};
	},
};
</script>
