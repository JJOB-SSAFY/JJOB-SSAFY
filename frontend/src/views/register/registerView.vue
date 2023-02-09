<template>
	<div class="login-section">
		<!-- <div class="div-illustration">
			<img src="../../assets/images/logo/logo-removebg.png" alt="logo" />
		</div> -->
		<div class="div-register">
			<div class="register-container">
				<div class="register-title">
					<h1 class="font-LINE-Bd mt-100">회원등록 <br />JJOB SSAFY입니다</h1>
				</div>
				<div class="register-form mt-110">
					<form @submit.prevent="register" id="register">
						<input
							class="register-form-input font-LINE-Rg"
							type="email"
							placeholder="이메일을 입력해주세요"
							v-model="info.email"
						/>
						<br />
						<div v-if="!invalidEmail" style="color: red">
							&nbsp 이미 등록된 이메일 입니다.
						</div>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="password"
							placeholder="비밀번호를 입력해주세요"
							v-model="info.password"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="password"
							placeholder="비밀번호를 입력해주세요"
							v-model="info.passwordCk"
						/>
						<br />
						<div v-if="!invalidPassowrd" style="color: red">
							비밀번호를 다시 확인해 주세요.
						</div>
						<input
							class="font-LINE-Rg"
							type="text"
							placeholder="이름을 입력해주세요"
							v-model="info.name"
						/>
						<br />
						<input
							class="font-LINE-Rg"
							type="text"
							placeholder="전화번호을 입력해주세요"
							v-model="info.phone"
						/>
						<p>역활?</p>
						<label for="checkBox"
							><input
								type="checkbox"
								v-model="info.role"
								true-value="company"
								false-value="user"
								id="checkBox"
							/>일반회원</label
						>
						기업 정보 기입
						<div>
							<input
								class="font-LINE-Rg"
								type="text"
								placeholder="기업 이름"
								v-model="companyInfo.companyName"
								:disabled="info.role != 'company'"
							/>
							<br />
							<input
								class="font-LINE-Rg"
								type="text"
								placeholder="기업 주소"
								v-model="companyInfo.companyAddress"
								:disabled="info.role != 'company'"
							/>
							<br />
							<input
								class="font-LINE-Rg"
								type="text"
								placeholder="기업 설명"
								v-model="companyInfo.companyDesc"
								:disabled="info.role != 'company'"
							/>
							<br />
							<input
								class="font-LINE-Rg"
								type="text"
								placeholder="사원수"
								v-model="companyInfo.employeeCnt"
								:disabled="info.role != 'company'"
							/>
							<br />
							<input
								class="font-LINE-Rg"
								type="text"
								placeholder="기업 홈페이지"
								v-model="companyInfo.companyUrl"
								:disabled="info.role != 'company'"
							/>
							<br />
						</div>

						<div class="div-button">
							<b-button type="button" class="font-LINE-Bd" @click="register">
								등록
							</b-button>
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
		const companySuccess = ref(false);
		const info = reactive({
			email: '',
			password: '',
			passwordCk: '',
			name: '',
			phone: '',
			role: 'user',
		});
		const companyInfo = reactive({
			companyAddress: '',
			companyDesc: '',
			companyName: '',
			companyUrl: '',
			employeeCnt: '',
		});

		const userInfo = reactive({
			email: info.email,
			password: info.password,
			name: info.name,
			phone: info.phone,
			companyName: '',
		});
		const invalidEmail = ref(true);
		const invalidPassowrd = ref(true);
		const register = async () => {
			console.log('register');
			if (
				info.email == null ||
				info.email == '' ||
				info.password == null ||
				info.password == '' ||
				info.name == null ||
				info.name == '' ||
				info.phone == null ||
				info.phone == ''
			) {
				alert('모든 정보를 입력해주세요');
				return;
			}
			userInfo.email = info.email;
			userInfo.password = info.password;
			userInfo.name = info.name;
			userInfo.phone = info.phone;
			userInfo.companyName = '';
			if (info.role == 'user') {
				registerUser(userInfo);
			} else {
				if (
					companyInfo.companyAddress == '' ||
					companyInfo.companyAddress == null ||
					companyInfo.companyDesc == '' ||
					companyInfo.companyDesc == null ||
					companyInfo.companyName == null ||
					companyInfo.companyName == '' ||
					companyInfo.companyUrl == null ||
					companyInfo.companyUrl == '' ||
					companyInfo.employeeCnt == null ||
					companyInfo.employeeCnt == ''
				) {
					alert('모든 정보를 입력해주세요');
					return;
				}
				await registerCompany(companyInfo);
				if (companySuccess.value) {
					companySuccess.value = false;
					registerUser(userInfo);
				}
			}
			document.getElementById('register').reset();
		};
		const registerCompany = async function (param) {
			await memberService
				.registerCompany(param)
				.then(data => {
					alert(userInfo.companyName + ' 기업 등록 성공');
					console.log(userInfo.companyName);
					companySuccess.value = true;
				})
				.catch(err => {
					console.log(err);
					alert('기업 등록 실패');
					return;
				});
		};
		const registerUser = param => {
			userInfo.companyName = companyInfo.companyName;
			console.log(userInfo.companyName);
			memberService
				.registerUser(param)
				.then(data => {
					console.log(data);
					alert(info.email + '등록 성공');
					initData();
				})
				.catch(err => {
					alert('유저등록실패');
					console.log(err);
				});
		};
		const initData = () => {
			info.email =
				info.password =
				info.passwordCk =
				info.name =
				info.phone =
				userInfo.companyName =
				userInfo.email =
				userInfo.name =
				userInfo.password =
				userInfo.phone =
				companyInfo.companyAddress =
				companyInfo.companyDesc =
				companyInfo.companyName =
				companyInfo.companyUrl =
				companyInfo.employeeCnt =
					'';
			info.role = 'user';
		};
		const emailCk = param => {
			memberService
				.emailCheck(param)
				.then(() => {
					invalidEmail.value = true;
					console.log('success');
				})
				.catch(() => {
					if (info.email == '' || info.email == null) {
						console.log('null');
					} else {
						invalidEmail.value = false;
						console.log('error');
					}
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
				if (info.passwordCk == '' || info.password == null) {
					invalidPassowrd.value = true;
				} else if (
					(info.password != '' || info.password != null) &&
					info.password != info.passwordCk
				) {
					invalidPassowrd.value = false;
				} else {
					invalidPassowrd.value = true;
				}
			},
		);
		watch(
			() => info.password,
			function () {
				if (info.passwordCk == '' || info.passwordCk == null) {
					invalidPassowrd.value = true;
				} else if (info.password == info.passwordCk) {
					invalidPassowrd.value = true;
				} else {
					invalidPassowrd.value = false;
				}
			},
		);
		watch(
			() => info.role,
			function () {
				if (info.role == 'user') {
					companyInfo.companyName = '';
				}
			},
		);
		return {
			register,
			invalidEmail,
			info,
			emailCk,
			invalidPassowrd,
			userInfo,
			companyInfo,
			registerCompany,
			registerUser,
			companySuccess,
		};
	},
};
</script>
<style scoped>
.register-form .register-form-input {
	width: 500px;
	height: 50px;
	font-size: 20px;
	border-left-width: 0;
	border-right-width: 0;
	border-top-width: 0;
	border-bottom-width: 1;
	padding-left: 10px;
	display: block;
	margin: 40px 79px 0 10px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}
.register-title {
}
.register-form .register-form-input:hover {
	box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
}
</style>
