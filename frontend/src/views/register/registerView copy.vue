<template>
	<div class="register-section">
		<div class="div-illustration-register">
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
							v-model="info.email"
						/>
						<div v-if="!invalidEmail">이미 등록된 이메일 입니다.</div>
						<input
							class="font-LINE-Rg"
							type="password"
							placeholder="비밀번호를 입력해주세요"
							v-model="info.password"
						/>
						<input
							class="font-LINE-Rg"
							type="password"
							placeholder="비밀번호를 입력해주세요"
							v-model="info.passwordCk"
						/>
						<div v-if="!invalidPassowrd">비밀번호를 다시 확인해 주세요.</div>
						<input
							class="font-LINE-Rg"
							type="text"
							placeholder="이름을 입력해주세요"
							v-model="info.name"
						/>
						<!-- <p>역활?</p>z
						<label
							><input type="radio" name="role" value="member" /> 일반회원</label
						><br />
						<label
							><input type="radio" name="role" value="company" /> 회사</label
						><br />
						<label
							><input type="radio" name="role" value="admin" /> 관리자</label
						>
						<div>회사 정보 기입</div> -->
						<div class="div-button">
							<button type="button" class="font-LINE-Bd" @click="register">
								등록
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { watch } from 'vue';
import { reactive, ref } from 'vue';
import MemberService from '../../api/memberService';
export default {
	name: 'registerView',
	setup() {
		const memberService = new MemberService();
		const info = reactive({
			email: '',
			password: '',
			passwordCk: '',
			name: '',
		});
		const requestInfo = reactive({
			email: info.email,
			password: info.password,
			name: info.name,
		});
		const invalidEmail = ref(true);
		const invalidPassowrd = ref(true);
		const register = () => {
			console.log('register');
		};
		const emailCk = param => {
			memberService
				.emailCheck(param)
				.then(data => {
					invalidEmail.value = true;
					console.log('success');
				})
				.catch(err => {
					invalidEmail.value = false;
					console.log('error');
				});
		};
		//이메일 중복 확인 수정필
		watch(
			() => info.email,
			function () {
				console.log(info.email);
				emailCk(info.email);
			},
		);
		//비밀번호 확인
		watch(
			() => info.passwordCk,
			function () {
				if (info.password != '' && info.password != info.passwordCk) {
					invalidPassowrd.value = false;
				} else {
					invalidPassowrd.value = true;
				}
			},
		);
		return {
			register,
			invalidEmail,
			info,
			emailCk,
			invalidPassowrd,
			requestInfo,
		};
	},
};
</script>
