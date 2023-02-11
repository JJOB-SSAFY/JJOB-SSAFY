<template>
	<div class="login-section">
		<div class="div-register">
			<div class="register-container">
				<div class="register-title">
					<h1 class="font-LINE-Bd mt-100 margin-auto">공고등록</h1>
				</div>
				<div class="register-form mt-80">
					<div class="register-user">
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="공고 이름"
							v-model="info.recruitTitle"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="학력"
							v-model="info.eduRequirement"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="근무 형태(정규직, 계약직)"
							v-model="info.workType"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="경력"
							v-model="info.career"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="급여"
							v-model="info.salary"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="근무지역"
							v-model="info.location"
						/>
						<br />
						<div class="filebox">
							<input class="upload-name shadow" value="첨부파일" />
							<div class="file-btn">
								<label for="file">파일찾기</label>
								<input type="file" id="file" :onchange="setFileName" />
							</div>
						</div>
						<br />
					</div>

					<div class="register-company">
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="공고내용"
							v-model="info.recruitContent"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="시작 날짜"
							v-model="info.recruitStartDate"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="마감 날짜"
							v-model="info.recruitEndDate"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="부서"
							v-model="info.department"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="담당업무"
							v-model="info.work"
						/>
						<br />
						<input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="요구 역량"
							v-model="info.requirement"
						/>
						<br />
						<div class="div-button">
							<b-button
								type="button"
								variant="outline-primary"
								class="div-button font-LINE-Bd"
								@click="register"
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
import { reactive, ref } from 'vue';
import axios from 'axios';
import { url } from '../../../api/http';
import { useStore } from 'vuex';

export default {
	name: 'recruitCreateView',

	setup() {
		const store = useStore();

		const info = reactive({
			recruitTitle: '',
			eduRequirement: '',
			workType: '',
			career: '',
			salary: '',
			location: '',
			imgUrl: '',
			recruitContent: '',
			recruitStartDate: '',
			recruitEndDate: '',
			department: '',
			work: '',
			requirement: '',
		});

		const recruitInfo = reactive({
			recruitTitle: info.recruitTitle,
			eduRequirement: info.eduRequirement,
			workType: info.workType,
			career: info.career,
			salary: info.salary,
			location: info.location,
			imgUrl: info.imgUrl,
			recruitContent: info.recruitContent,
			recruitStartDate: info.recruitStartDate,
			recruitEndDate: info.recruitEndDate,
			department: info.department,
			work: info.work,
			requirement: info.requirement,
		});

		const register = async () => {
			recruitInfo.recruitTitle = info.recruitTitle;
			recruitInfo.eduRequirement = info.eduRequirement;
			recruitInfo.workType = info.workType;
			recruitInfo.career = info.career;
			recruitInfo.salary = info.salary;
			recruitInfo.location = info.location;
			recruitInfo.imgUrl = info.imgUrl;
			recruitInfo.recruitContent = info.recruitContent;
			recruitInfo.recruitStartDate = info.recruitStartDate;
			recruitInfo.recruitEndDate = info.recruitEndDate;
			recruitInfo.department = info.department;
			recruitInfo.work = info.work;
			recruitInfo.requirement = info.requirement;

			const companyId = ref(store.getters['auth/getCompanyId']);

			axios({
				method: 'POST',
				url: url + '/recruit/' + companyId.value,
				headers: {
					Authorization: localStorage.getItem('jjob.s.token'),
				},
				data: recruitInfo,
			}).then(res => {
				console.log(res);
			});
		};

		const initData = () => {
			info.recruitTitle =
				info.eduRequirement =
				info.workType =
				info.career =
				info.salary =
				info.location =
				info.imgUrl =
				info.recruitContent =
				info.recruitStartDate =
				info.recruitEndDate =
				info.department =
				info.work =
				info.requirement =
				recruitInfo.recruitTitle =
				recruitInfo.eduRequirement =
				recruitInfo.workType =
				recruitInfo.career =
				recruitInfo.salary =
				recruitInfo.location =
				recruitInfo.imgUrl =
				recruitInfo.recruitContent =
				recruitInfo.recruitStartDate =
				recruitInfo.recruitEndDate =
				recruitInfo.department =
				recruitInfo.work =
				recruitInfo.requirement =
					'';
		};

		return { info, recruitInfo, register };
	},
};
</script>

<style>
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
.div-button {
	width: 500px;
	padding-left: 10px;
	height: 50px;
}
.filebox {
	margin-top: 40px;
}

.filebox .upload-name {
	/* display: inline-block; */
	height: 40px;
	padding: 0 10px;
	vertical-align: middle;
	border: 1px solid #dddddd;
	width: 85%;
	margin-left: 9px;
	color: #999999;
}

.filebox label {
	display: inline-block;
	padding: 10px 20px;
	color: #fff;
	vertical-align: middle;
	background-color: #999999;
	cursor: pointer;
	height: 40px;
	margin-left: 10px;
}

.filebox input[type='file'] {
	position: absolute;
	width: 0;
	height: 0;
	padding: 0;
	overflow: hidden;
	border: 0;
}

.file-btn {
	margin-top: 10px;
	margin-right: 80px;
	text-align: right;
}
</style>
