<template>
	<div class="banner-container">
		<span class="banner-letter1">공고 작성</span>
		<p class="banner-letter2">채용 공고를 작성해 주세요.</p>
	</div>
	<hr class="hr-main2" />
	<div class="register-recruit-box">
		<div class="register-recruit">
			<h3>채용공고</h3>
			<br />
			<div class="register-recruit-detail">
				<div class="register-recruit-detail">
					<div class="row">
						<div class="col-8">
							<h6>*공고 이름</h6>
							<input
								class="register-recruit-form-input font-LINE-Rg"
								type="text"
								placeholder="공고이름"
								v-model="info.recruitTitle"
							/>
						</div>
						<div class="col">
							<h6>*경력여부</h6>
							<input
								class="register-recruit-form-input font-LINE-Rg"
								type="text"
								placeholder="경력여부"
								v-model="info.career"
							/>
						</div>
					</div>
				</div>

				<div class="register-recruit-detail">
					<div class="row">
						<div class="col">
							<h6>*근무지역</h6>
							<input
								class="register-recruit-form-input font-LINE-Rg"
								type="text"
								placeholder="근무지역"
								v-model="info.location"
							/>
						</div>
						<!-- <div class="col">
							<h6>*근무 형태</h6>
							<input
								class="register-recruit-form-input font-LINE-Rg"
								type="text"
								placeholder="근무 형태"
								v-model="info.workType"
							/>
						</div> -->

						<div class="col" style="position: relative">
							<h6>*근무 형태</h6>
							<div
								class="dropdown"
								style="
									position: absolute;
									position: absolute;
									top: 34px;
									right: 22px;
								"
							>
								<button
									type="button"
									id="dropdownMenuButton1"
									data-bs-toggle="dropdown"
									aria-expanded="false"
								>
									<fa-icon icon="fas fa-solid fa-chevron-down" />
								</button>
								<ul
									class="dropdown-menu w-100"
									aria-labelledby="dropdownMenuButton1"
								>
									<li>
										<a
											class="dropdown-item non-hover"
											@click="selectWorkType('정규직')"
											>정규직</a
										>
									</li>
									<li>
										<a
											class="dropdown-item non-hover"
											@click="selectWorkType('계약직')"
											>계약직</a
										>
									</li>
								</ul>
							</div>
							<input
								id="recruit-create-workType"
								class="register-recruit-form-input font-LINE-Rg"
								type="text"
								placeholder="근무 형태"
								v-model.lazy.trim="info.workType"
								readonly
							/>
						</div>
					</div>
				</div>

				<div class="register-recruit-detail">
					<div class="row">
						<!-- <div class="col">
								<h6>*채용 기간</h6>
								<input
									class="register-recruit-form-input font-LINE-Rg"
									type="date"
									placeholder="시작 날짜"
									v-model="info.recruitStartDate"
								/>
							</div> -->
						<div class="col">
							<h6>*시작 날짜</h6>
							<input
								id="currentDate"
								class="register-recruit-form-input font-LINE-Rg"
								type="date"
								v-model="info.recruitStartDate"
							/>
						</div>
						<div class="col">
							<h6>*종료 날짜</h6>
							<input
								class="register-recruit-form-input font-LINE-Rg"
								type="date"
								v-model="info.recruitEndDate"
							/>
						</div>
					</div>
				</div>

				<div class="register-recruit-detail">
					<div class="row">
						<div class="col">
							<h6>*담당 업무</h6>
							<input
								class="register-recruit-form-input font-LINE-Rg"
								type="text"
								placeholder="담당 업무"
								v-model="info.work"
							/>
						</div>
						<div class="col">
							<h6>*요구역량</h6>
							<input
								class="register-recruit-form-input font-LINE-Rg"
								type="text"
								placeholder="요구역량"
								v-model="info.requirement"
							/>
						</div>
						<div class="col">
							<h6>*부서</h6>
							<input
								class="register-recruit-form-input font-LINE-Rg"
								type="text"
								placeholder="부서"
								v-model="info.department"
							/>
						</div>
					</div>
				</div>

				<p>*공고 이미지</p>
				<div class="filebox" style="display: block">
					<input
						class="register-recruit-form-input font-LINE-Rg"
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
							class="register-recruit-form-input font-LINE-Rg"
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
				공고등록
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
import Swal from 'sweetalert2';
import { useRouter } from 'vue-router';

export default {
	name: 'recruitCreateView',

	setup() {
		const router = useRouter();
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
					Swal.fire({
						title: 'Success!',
						text: '채용공고 등록 성공',
						icon: 'success',
					}).then(() => {
						router.push({
							name: 'recruit',
						});
					});
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

		const selectWorkType = workType => {
			info.workType = workType;
		};

		return { info, recruitInfo, register, imgUpload, fileName, selectWorkType };
	},
};
</script>

<style scoped></style>
