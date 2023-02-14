<template>
	<div class="banner-container">
		<span class="banner-letter1">공고 작성</span>
		<p class="banner-letter2">채용 공고를 작성해 주세요.</p>
	</div>
	<hr class="hr-main2" />
	<div class="register-container-box">
		<div class="register-user">
			<h3>채용공고</h3>
			<br />
			<div class="register-user-detail">
				<div class="register-user-detail">
					<div class="row">
						<div class="col-8">
							<h6>*공고 이름</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								placeholder="공고이름"
								v-model="info.recruitTitle"
							/>
						</div>
						<div class="col">
							<h6>*경력여부</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								placeholder="경력여부"
								v-model="info.career"
							/>
						</div>
					</div>
				</div>

				<div class="register-user-detail">
					<div class="row">
						<div class="col">
							<h6>*근무지역</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								placeholder="근무지역"
								v-model="info.location"
							/>
						</div>
						<div class="col">
							<h6>*근무 형태</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								placeholder="근무 형태"
								v-model="info.workType"
							/>
						</div>

						<div class="col">
							<h6>*근무 형태</h6>
							<form name="fr">
								<select name="fruits" onchange="func(this.value)">
									<option value="">선택하세요</option>
									<option value="ragular">정규직</option>
									<option value="contract">계약직</option>
								</select>
								<input
									class="register-form-input font-LINE-Rg"
									type="text"
									name="selectFruit"
								/>
							</form>
						</div>
					</div>
				</div>

				<div class="register-user-detail">
					<div class="row">
						<!-- <div class="col">
								<h6>*채용 기간</h6>
								<input
									class="register-form-input font-LINE-Rg"
									type="date"
									placeholder="시작 날짜"
									v-model="info.recruitStartDate"
								/>
							</div> -->
						<div class="col">
							<h6>*시작 날짜</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="date"
								v-model="info.recruitStartDate"
							/>
						</div>
						<div class="col">
							<h6>*종료 날짜</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="date"
								v-model="info.recruitEndDate"
							/>
						</div>
					</div>
				</div>

				<div class="register-user-detail">
					<div class="row">
						<div class="col">
							<h6>*담당 업무</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								placeholder="담당 업무"
								v-model="info.work"
							/>
						</div>
						<div class="col">
							<h6>*요구역량</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								placeholder="요구역량"
								v-model="info.requirement"
							/>
						</div>
						<div class="col">
							<h6>*부서</h6>
							<input
								class="register-form-input font-LINE-Rg"
								type="text"
								placeholder="부서"
								v-model="info.department"
							/>
						</div>
					</div>
				</div>

				<p>*공고 이미지</p>
				<div class="filebox">
					<input
						class="register-form-input font-LINE-Rg"
						disabled
						v-model="fileName"
					/>
					<div class="file-btn">
						<!-- <label for="file">파일찾기</label> -->
						<input type="file" id="file" @change="imgUpload" />
					</div>
				</div>
				<br />

				<div class="div-content-box">
					<p>*공고내용</p>
					<p>
						<textarea
							name="content-area"
							id="content-area"
							class="register-form-input font-LINE-Rg"
							placeholder="자유형식으로 기재해주세요."
							rows="20"
							v-model="info.recruitContent"
						></textarea>
					</p>
				</div>
			</div>
		</div>
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
</template>

<script>
import { reactive, ref } from 'vue';
import axios from 'axios';
import { url } from '../../../api/http';
import { useStore } from 'vuex';
import { ref as fref, uploadBytes, getDownloadURL } from 'firebase/storage';
import { storage } from '../../../api/firebase';
export default {
	name: 'recruitCreateView',
	setup() {
		const fileName = ref('첨부파일');
		const store = useStore();
		const imgUpload = async e => {
			fileName.value = e.target.files[0].name;
			const uploaded_file = await uploadBytes(
				fref(storage, `images/${e.target.files[0].name}`),
				e.target.files[0],
			);
			console.log(uploaded_file);
			const file_url = await getDownloadURL(uploaded_file.ref);
			console.log(file_url);
			info.imgUrl = file_url;
			console.log(info.imgUrl);
		};
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
			recruitStartTime: '',
			recruitEndDate: '',
			recruitEndTime: '',
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
			})
				.then(res => {
					console.log(res);
				})
				.then(() => {
					alert('채용공고 등록 성공');
					initData();
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

		return { info, recruitInfo, register, imgUpload, fileName };
	},
};
</script>

<style scoped>
.register-container-box {
	border: 1px solid black;
	width: 80%;
	display: block;
	margin: auto;
	padding-bottom: 25px;
	justify-content: center;
	border-radius: 5px;
}
.register-user {
	width: 100%;
	padding: 25px;
}
.register-user-detail {
	margin: 3% 0;
}
.register-form-input {
	width: 100%;
	font-size: 15px;
	background-color: aliceblue;
	border: 1px solid #ccc;
	border-radius: 5px;
	display: block;
	padding: 5px;
	margin-top: 10px;
	/* margin: 1%; */
	/* outline: none; */
	/* box-shadow: 10px 5px 5px #f2f0eb; */
}
.file-btn {
	margin-top: 3px;
}
#content-area {
	width: 100%;
	border: 1px lightgray solid;
	border-radius: 5px;
	resize: none;
}
.div-button {
	margin: auto;
	width: 97%;
}
/* .register-form .register-form-input:hover {
	box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
}
.div-button {
	width: 500px;
	padding-left: 10px;
	height: 50px;
}
.filebox {
	margin-top: 40px;
} */

/* .filebox .upload-name {
	display: inline-block;
	height: 40px;
	padding: 0 10px;
	vertical-align: middle;
	border: 1px solid #dddddd;
	width: 85%;
	margin-left: 9px;
	color: #999999;
} */
/* 
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
.register-form p {
	margin-left: 10px;
	margin-bottom: -32px;
	margin-top: 8px;
} */
</style>
