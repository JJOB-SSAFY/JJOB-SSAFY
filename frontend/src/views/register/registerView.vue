<template>
	<div class="banner-container font-LINE-Rg">
		<span class="banner-letter1">Register</span>
		<p class="banner-letter2">회원을 등록할 수 있는 곳입니다.</p>
	</div>
	<hr class="hr-main2" />
	<div class="register-form mt-50 font-">
		<div class="file-group font-LINE-Rg">
			<div class="filebox">
				<input
					readonly
					type="text"
					class="upload-name shadow"
					v-model="fileName"
				/>
				<label class="btnLightBlue bthPush" for="file">로고등록</label>
				<input type="file" id="file" @change="imgUpload" />
			</div>
		</div>

		<div class="register-div">
			<div class="register-user">
				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="text"
						v-model="info.email"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">이메일</label>
				</div>

				<div v-if="!invalidEmail" style="color: red">
					&nbsp; 이미 등록된 이메일 입니다.
				</div>
				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="password"
						v-model="info.password"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">비밀번호</label>
				</div>

				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="password"
						v-model="info.passwordCk"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">비밀번호 확인</label>
				</div>

				<div v-if="!invalidPassowrd" style="color: red">
					비밀번호를 다시 확인해 주세요.
				</div>

				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="text"
						v-model="info.name"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">이름</label>
				</div>

				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="text"
						v-model="info.companyName"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">기업 이름</label>
				</div>

				<div class="reg-div-button mt-30">
					<button
						type="button"
						variant="outline-primary"
						class="font-LINE-Bd btnLightBlue btnFade"
						@click="registerU"
					>
						회원등록
					</button>
				</div>
			</div>

			<div class="register-company">
				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="text"
						v-model="companyInfo.companyName"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">기업 이름</label>
				</div>

				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="text"
						v-model="companyInfo.companyAddress"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">기업 주소</label>
				</div>

				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="text"
						v-model="companyInfo.companyDesc"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">기업 설명</label>
				</div>

				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="number"
						v-model="companyInfo.employeeCnt"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">사원 수</label>
				</div>

				<div class="group font-LINE-Rg">
					<input
						class="register-form-input font-LINE-Rg"
						type="text"
						v-model="companyInfo.companyUrl"
						required
					/>
					<span class="bar"></span>
					<label class="label-title">기업 홈페이지</label>
				</div>

				<div class="reg-div-button mt-30">
					<button
						type="button"
						variant="outline-primary"
						class="font-LINE-Bd btnLightBlue btnFade"
						@click="registerC"
					>
						회사등록
					</button>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { watch } from 'vue';
import { reactive, ref } from 'vue';
import MemberService from '../../api/memberService';
import CompanyService from '../../api/companyService';
import { ref as fref, uploadBytes, getDownloadURL } from 'firebase/storage';
import { storage } from '../../api/firebase';
import Swal from 'sweetalert2';

export default {
	name: 'registerView',
	setup() {
		const emailValidCk = ref(false);
		const memberService = new MemberService();
		const companyService = new CompanyService();
		const invalidEmail = ref(true);
		const invalidPassowrd = ref(true);
		const fileName = ref('첨부파일');
		const imgUpload = async e => {
			fileName.value = e.target.files[0].name;
			const uploaded_file = await uploadBytes(
				fref(storage, `images/${e.target.files[0].name}`),
				e.target.files[0],
			);
			const file_url = await getDownloadURL(uploaded_file.ref);

			companyInfo.companyLogo = file_url;
		};
		const info = reactive({
			email: '',
			password: '',
			passwordCk: '',
			name: '',
			companyName: '',
		});

		const companyInfo = reactive({
			companyAddress: '',
			companyDesc: '',
			companyName: '',
			companyUrl: '',
			employeeCnt: '',
			companyLogo: null,
		});

		const userInfo = reactive({
			email: info.email,
			password: info.password,
			name: info.name,
			companyName: info.companyName,
		});

		const registerU = async () => {
			if (
				info.email == null ||
				info.email == '' ||
				info.password == null ||
				info.password == '' ||
				info.name == null ||
				info.name == ''
			) {
				Swal.fire({
					title: 'OOPS!',
					text: '모든 정보를 입력해주세요.',
					icon: 'warning',
				});
				return;
			}
			if (!invalidPassowrd.value) {
				Swal.fire({
					title: 'OOPS!',
					text: '비밀번호가 일치하지 않습니다.',
					icon: 'warning',
				});
				return;
			}

			userInfo.email = info.email;
			userInfo.password = info.password;
			userInfo.name = info.name;
			userInfo.companyName = info.companyName;

			emailValid(userInfo.email);

			if (!emailValidCk.value) {
				Swal.fire({
					title: 'OOPS!',
					text: '올바른 이메일 형식을 입력해주세요.',
					icon: 'warning',
				});
				return;
			}

			registerUser(userInfo);
			initData();
			emailValidCk.value = false;
		};

		const registerC = async () => {
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
				Swal.fire({
					title: 'OOPS!',
					text: '모든 정보를 입력해주세요',
					icon: 'warning',
				});
				return;
			}

			await registerCompany(companyInfo);
			initData();
		};

		const registerCompany = async function (param) {
			await companyService
				.registerCompany(param)
				.then(data => {
					Swal.fire({
						title: 'WOW!',
						text: param.companyName + ' 기업 등록 성공',
						icon: 'success',
					});
				})
				.catch(() => {
					Swal.fire({
						title: 'OOPS!',
						text: '기업 등록 실패',
						icon: 'warning',
					});
					return;
				});
		};

		const registerUser = param => {
			memberService
				.registerUser(param)
				.then(data => {
					Swal.fire({
						title: 'WOW!',
						text: info.email + '등록 성공',
						icon: 'success',
					});
				})
				.catch(() => {
					Swal.fire({
						title: 'OOPS!',
						text: '유저등록실패',
						icon: 'warning',
					});
				});
		};

		const initData = () => {
			info.email =
				info.password =
				info.passwordCk =
				info.name =
				info.companyName =
				userInfo.companyName =
				userInfo.email =
				userInfo.name =
				userInfo.password =
				companyInfo.companyAddress =
				companyInfo.companyDesc =
				companyInfo.companyName =
				companyInfo.companyUrl =
				companyInfo.employeeCnt =
					'';
		};

		const emailCk = param => {
			memberService
				.emailCheck(param)
				.then(() => {
					invalidEmail.value = true;
				})
				.catch(() => {
					if (info.email == '' || info.email == null) {
						Swal.fire({
							title: 'OOPS!',
							text: '실패!',
							icon: 'warning',
							timer: 1500,
						});
					} else {
						invalidEmail.value = false;
					}
				});
		};

		const emailValid = param => {
			var expert = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if (expert.test(param)) {
				emailValidCk.value = true;
			} else {
				emailValidCk.value = false;
			}
		};

		watch(
			() => info.email,
			function () {
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

		return {
			registerU,
			registerC,
			invalidEmail,
			info,
			emailCk,
			invalidPassowrd,
			userInfo,
			companyInfo,
			registerCompany,
			registerUser,
			imgUpload,
			fileName,
		};
	},
};
</script>
<style scoped></style>
