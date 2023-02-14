<template>
	<div class="login-section">
		<div class="div-register">
			<div class="register-container">
				<div class="register-title">
					<h1 class="font-LINE-Bd mt-100 margin-auto">
						회원등록 <br />JJOB SSAFY입니다
					</h1>
				</div>
				<div class="register-form mt-80">
					<div class="register-user">
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								v-model="info.email"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">이메일</label>
						</div>
						<br />
						<div v-if="!invalidEmail" style="color: red">
							&nbsp 이미 등록된 이메일 입니다.
						</div>
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="password"
								v-model="info.password"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">비밀번호</label>
						</div>
						<br />
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="password"
								v-model="info.passwordCk"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">비밀번호 확인</label>
						</div>
						<br />
						<div v-if="!invalidPassowrd" style="color: red">
							비밀번호를 다시 확인해 주세요.
							<br />
						</div>

						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								v-model="info.name"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">이름</label>
						</div>
						<br />
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								v-model="info.companyName"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">기업 이름</label>
						</div>
						<br />
						<div class="div-button">
							<b-button
								type="button"
								variant="outline-primary"
								class="div-button font-LINE-Bd"
								@click="registerU"
							>
								회원등록
							</b-button>
						</div>
					</div>

					<div class="register-company">
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								v-model="companyInfo.companyName"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">기업 이름</label>
						</div>
						<br />
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								v-model="companyInfo.companyAddress"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">기업 주소</label>
						</div>
						<br />
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								v-model="companyInfo.companyDesc"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">기업 설명</label>
						</div>
						<br />
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								v-model="companyInfo.employeeCnt"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">사원 수</label>
						</div>
						<br />
						<div class="group">
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								v-model="companyInfo.companyUrl"
								required
							/>
							<span class="bar"></span>
							<label class="label-title">기업 홈페이지</label>
						</div>

						<label class="label-title mt-5">기업 로고(필수입력 X)</label>
						<div class="filebox">
							<input
								type="text"
								class="upload-name shadow"
								v-model="fileName"
							/>
							<div class="file-btn">
								<label for="file">로고 찾기</label>
								<input type="file" id="file" @change="imgUpload" />
							</div>
						</div>
						<br />
						<div class="div-button">
							<b-button
								type="button"
								variant="outline-primary"
								class="div-button font-LINE-Bd"
								@click="registerC"
							>
								회사등록
							</b-button>
						</div>
					</div>
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
			console.log(uploaded_file);
			const file_url = await getDownloadURL(uploaded_file.ref);
			console.log(file_url);

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
			console.log('register');
			if (
				info.email == null ||
				info.email == '' ||
				info.password == null ||
				info.password == '' ||
				info.name == null ||
				info.name == ''
			) {
				alert('모든 정보를 입력해주세요');
				return;
			}
			if (!invalidPassowrd.value) {
				alert('비밀번호가 일치하지 않습니다.');
				return;
			}

			userInfo.email = info.email;
			userInfo.password = info.password;
			userInfo.name = info.name;
			userInfo.companyName = info.companyName;

			emailValid(userInfo.email);

			if (!emailValidCk.value) {
				alert('올바른 이메일 형식을 작성해주세요!');
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
				alert('모든 정보를 입력해주세요');
				return;
			}

			await registerCompany(companyInfo);
			initData();
		};

		const registerCompany = async function (param) {
			console.log(param);
			await companyService
				.registerCompany(param)
				.then(data => {
					alert(param.companyName + ' 기업 등록 성공');
				})
				.catch(err => {
					console.log(err);
					alert('기업 등록 실패');
					return;
				});
		};

		const registerUser = param => {
			memberService
				.registerUser(param)
				.then(data => {
					console.log(data);
					alert(info.email + '등록 성공');
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

		const emailValid = param => {
			var expert = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if (expert.test(param)) {
				emailValidCk.value = true;
				console.log('유효성 통과');
			} else {
				emailValidCk.value = false;
				console.log('유효성 실패');
			}
		};

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
<style scoped>
/* .register-form .register-form-input {
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
}*/
.div-button {
	width: 100px;
	padding-left: 10px;

	margin-top: 10px;
}
.input-checkbox {
}
.register-company {
	padding-left: 220px;
}
/*input ========================================*/
.group {
	position: relative;
}
input {
	font-size: 18px;
	padding: 10px 10px 10px 5px;
	display: block;
	width: 350px;
	border: none;
	border-bottom: 1px solid #757575;
}
input:focus {
	outline: none;
}

/* LABEL ======================================= */
label.label-title {
	color: #999;
	font-size: 18px;
	font-weight: normal;
	pointer-events: none;
	left: 5px;
	top: 10px;
	transition: 0.2s ease all;
	-moz-transition: 0.2s ease all;
	-webkit-transition: 0.2s ease all;
}

/* active state */
input:focus ~ label.label-title,
input:valid ~ label.label-title {
	top: -20px;
	font-size: 14px;
	color: #5264ae;
}

/* BOTTOM BARS ================================= */
.bar {
	position: relative;
	display: block;
	width: 300px;
}
.bar:before,
.bar:after {
	content: '';
	height: 2px;
	width: 0;
	bottom: 1px;
	position: absolute;
	background: #5264ae;
	transition: 0.2s ease all;
	-moz-transition: 0.2s ease all;
	-webkit-transition: 0.2s ease all;
}
.bar:before {
	left: 50%;
}
.bar:after {
	right: 50%;
}

/* active state */
input:focus ~ .bar:before,
input:focus ~ .bar:after {
	width: 50%;
}
.filebox {
	margin-top: 20px;
	color: #999;
	font-size: 18px;
	font-weight: normal;
	display: flex;
}

.filebox .upload-name {
	/* display: inline-block; */
	height: 40px;
	vertical-align: middle;
	border: 1px solid #dddddd;
	width: 85%;
	color: #999999;
}

.filebox label {
	display: inline-block;
	padding: 7px 22px;
	color: #fff;
	vertical-align: middle;
	background-color: #999999;
	cursor: pointer;
	height: 40px;
	width: max-content;
}

.filebox input[type='file'] {
	width: 0;
	height: 0;
	padding: 0;
	overflow: hidden;
	border: 0;
}

.file-btn {
	margin-right: 80px;
	text-align: right;
}
</style>
