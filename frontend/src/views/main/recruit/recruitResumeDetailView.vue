<template>
	<div>
		<div class="resume-container">
			<div class="left-container">
				<div class="left-fix">
					<img
						src="../../../assets/images/blackbackground.jpg"
						class="resume-profile-image"
						alt="..."
					/>
					<div class="mb-3">
						<label for="phoneInput" class="form-label">휴대폰</label>
						<input
							class="form-control"
							id="phoneInput"
							placeholder="010-0000-0000"
							v-model="resume.resumeInfo.phone"
							readonly
						/>
					</div>
					<div class="mb-3">
						<label for="emailInput" class="form-label">이메일</label>
						<input
							class="form-control"
							id="emailInput"
							placeholder="email@example.com"
							v-model="resume.resumeInfo.email"
							readonly
						/>
					</div>
					<div class="mb-3">
						<label for="portfolioInput" class="form-label">포트폴리오</label>
						<input
							class="form-control"
							id="portfolioInput"
							v-model="resume.resumeInfo.portfolio"
							readonly
						/>
					</div>
					<div class="mb-3">
						<label for="githubInput" class="form-label">Github</label>
						<input
							class="form-control"
							id="githubInput"
							v-model="resume.resumeInfo.github"
							readonly
						/>
					</div>
					<div class="mb-3">
						<label for="blogInput" class="form-label">블로그</label>
						<input
							class="form-control"
							id="blogInput"
							v-model="resume.resumeInfo.blog"
							readonly
						/>
					</div>
				</div>
			</div>
			<div class="right-container">
				<div class="title-input-box">
					<input
						class="form-control title-input"
						placeholder="이력서 제목(필수)"
						style="font-size: 48px; font-weight: bold; border: none"
						v-model.trim="resume.resumeInfo.resumeTitle"
						readonly
					/>
					<input
						class="form-control"
						placeholder="이 름(필수)"
						style="
							font-size: 24px;
							font-weight: bold;
							border: none;
							margin-top: 25px;
							margin-left: 5px;
						"
						v-model.trim="resume.resumeInfo.name"
						readonly
					/>
				</div>
				<hr style="margin-bottom: 50px" />
				<div class="resume-box">
					<h4>학력사항</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">기 간</th>
								<th scope="cols">학 교 명</th>
								<th scope="cols">학 과</th>
							</tr>
						</thead>
						<tbody
							id="universityInfo"
							v-for="(item, i) in resume.resumeInfo.universityDtoList"
							:key="i"
						>
							<tr>
								<td>
									<input
										class="form-control"
										v-model="item.universityPeriod"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.universityName"
										readonly
									/>
								</td>
								<td>
									<input class="form-control" v-model="item.major" readonly />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4>교육이수</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">교 육 명</th>
								<th scope="cols">교육 기간</th>
								<th scope="cols">교육 내용</th>
								<th scope="cols">교육 기관</th>
							</tr>
						</thead>
						<tbody
							id="educationInfo"
							v-for="(item, i) in resume.resumeInfo.educationDtoList"
							:key="i"
						>
							<tr>
								<td>
									<input
										class="form-control"
										v-model="item.educationName"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.educationPeriod"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.educationContent"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.educationInstitution"
										readonly
									/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4>대내외활동</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">활 동 명</th>
								<th scope="cols">활동 기간</th>
								<th scope="cols">활동 내용</th>
								<th scope="cols">주관 기관</th>
							</tr>
						</thead>
						<tbody
							id="activityInfo"
							v-for="(item, i) in resume.resumeInfo.activityDtoList"
							:key="i"
						>
							<tr>
								<td>
									<input
										class="form-control"
										v-model="item.activityName"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.activityPeriod"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.activityContent"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.activityInstitution"
										readonly
									/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4>경력사항</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">기 업 명</th>
								<th scope="cols">재직 기간</th>
								<th scope="cols">직무 및 업무내용</th>
							</tr>
						</thead>
						<tbody
							id="careerInfo"
							v-for="(item, i) in resume.resumeInfo.careerDtoList"
							:key="i"
						>
							<tr>
								<td>
									<input
										class="form-control"
										v-model="item.companyName"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.careerPeriod"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.careerContent"
										readonly
									/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4>수상내역</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">수 상 명</th>
								<th scope="cols">수상 일자</th>
								<th scope="cols">수여 기관</th>
							</tr>
						</thead>
						<tbody
							id="awardInfo"
							v-for="(item, i) in resume.resumeInfo.awardDtoList"
							:key="i"
						>
							<tr>
								<td>
									<input
										class="form-control"
										v-model="item.awardName"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.awardDate"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.awardInstitution"
										readonly
									/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4>자격증</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">자 격 명</th>
								<th scope="cols">취득 일자</th>
								<th scope="cols">주관 기관</th>
							</tr>
						</thead>
						<tbody
							id="certificateInfo"
							v-for="(item, i) in resume.resumeInfo.certificateDtoList"
							:key="i"
						>
							<tr>
								<td>
									<input
										class="form-control"
										v-model="item.certificateName"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.certificateDate"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.certificateInstitution"
										readonly
									/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4>어학능력</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">언 어</th>
								<th scope="cols">시 험 명</th>
								<th scope="cols">점 수 (등 급)</th>
								<th scope="cols">취 득 일</th>
							</tr>
						</thead>
						<tbody
							id="languageInfo"
							v-for="(item, i) in resume.resumeInfo.languageAbilityDtoList"
							:key="i"
						>
							<tr>
								<td>
									<input
										class="form-control"
										v-model="item.language"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.testName"
										readonly
									/>
								</td>
								<td>
									<input class="form-control" v-model="item.grade" readonly />
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.testDate"
										readonly
									/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<div style="display: flex; align-items: center">
						<h4>SW역량</h4>
						<span>&nbsp;(보유기술 및 프로그래밍 언어)</span>
					</div>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">보유기술 및 능력</th>
								<th scope="cols">수 준</th>
								<th scope="cols">상세 내용</th>
							</tr>
						</thead>
						<tbody
							id="skillInfo"
							v-for="(item, i) in resume.resumeInfo.skillDtoList"
							:key="i"
						>
							<tr>
								<td>
									<input
										class="form-control"
										v-model="item.skillName"
										readonly
									/>
								</td>
								<td>
									<input
										class="form-control"
										v-model="item.skillLevel"
										readonly
									/>
								</td>
								<td>
									<input class="form-control" v-model="item.detail" readonly />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4>프로젝트 경험</h4>
					<div
						id="projectInfo"
						v-for="(item, i) in resume.resumeInfo.projectExpDtoList"
						:key="i"
					>
						<table class="type09">
							<thead>
								<tr>
									<th scope="cols">타이틀</th>
									<th scope="cols">내용</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">프로젝트 명</th>
									<td>
										<input
											class="form-control"
											v-model="item.projectName"
											readonly
										/>
									</td>
								</tr>
								<tr>
									<th scope="row">기 간</th>
									<td>
										<input
											class="form-control"
											v-model="item.projectPeriod"
											readonly
										/>
									</td>
								</tr>
								<tr>
									<th scope="row">참여 인원</th>
									<td>
										<input
											class="form-control"
											v-model="item.memberCnt"
											readonly
										/>
									</td>
								</tr>
								<tr>
									<th scope="row">개 요</th>
									<td>
										<input
											class="form-control"
											v-model="item.summary"
											readonly
										/>
									</td>
								</tr>
								<tr>
									<th scope="row">기술 환경</th>
									<td>
										<input
											class="form-control"
											v-model="item.techEnv"
											readonly
										/>
									</td>
								</tr>
								<tr>
									<th scope="row">담당 역할</th>
									<td>
										<input
											class="form-control"
											v-model="item.position"
											readonly
										/>
									</td>
								</tr>
								<tr>
									<th scope="row">주요 기능 및 구현 과정</th>
									<td>
										<input
											class="form-control"
											v-model="item.function"
											readonly
										/>
									</td>
								</tr>
								<tr>
									<th scope="row">성과 및 배운 점</th>
									<td>
										<input
											class="form-control"
											v-model="item.result"
											readonly
										/>
									</td>
								</tr>
								<tr>
									<th scope="row">참고 링크</th>
									<td>
										<input class="form-control" v-model="item.link" readonly />
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="resume-box">
					<h4>자기소개서</h4>
					<div
						id="coverLetterInfo"
						v-for="(item, i) in resume.resumeInfo.coverLetterDtoList"
						:key="i"
					>
						<table class="type09">
							<thead>
								<tr>
									<th scope="cols">
										<input
											class="form-control"
											placeholder="제 목"
											v-model="item.title"
											readonly
										/>
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<textarea
											class="form-control"
											rows="10"
											v-model="item.content"
											readonly
										/>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="recruit-resume-detail-footer">
			<div class="btn-box-left">
				<button class="back-btn" @click="goToRecruitResume">나가기</button>
			</div>
			<div class="btn-box-right">
				<button class="pass-btn" @click="pass">합격</button>
				<button class="nonpass-btn" @click="nonpass">불합격</button>
			</div>
		</div>
	</div>
</template>

<script>
import { onMounted, reactive } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';
import { url } from '../../../api/http';

export default {
	name: 'recruitResumeDetailView',

	setup() {
		const route = useRoute();

		const router = useRouter();

		const resume = reactive({
			resumeInfo: '',
		});

		const goToRecruitResume = () => {
			router.push({
				name: 'recruitResume',
			});
		};

		onMounted(() => {
			const resumeId = route.params.resumeId;
			axios({
				method: 'GET',
				url: url + '/resume/' + resumeId,
				headers: {
					Authorization: localStorage.getItem('jjob.s.token'),
				},
			}).then(res => {
				resume.resumeInfo = res.data;
			});
		});

		return { resume, goToRecruitResume };
	},
};
</script>

<style scoped>
.resume-container {
	width: 90%;
	margin: 50px auto 150px;
	display: flex;
	border: 2px black solid;
	border-radius: 10px;
}

.left-container {
	width: 30%;
	background-color: #aad6ff;
	padding: 0 50px;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
}

.left-fix {
	position: sticky;
	top: 20px;
	margin-bottom: 150px;
	box-sizing: border-box;
}

.left-container label {
	font-size: 15px;
	font-weight: bold;
}

.resume-profile-image {
	width: 75%;
	aspect-ratio: 1/1;
	margin: 50px auto 25px;
	border: 10px white solid;
	border-radius: 40%;
}

.right-container {
	width: 70%;
	background-color: white;
	padding: 60px 20px 20px 20px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
}

.right-container h4 {
	font-weight: bold;
	margin: 10px;
}

.title-input-box {
	margin-bottom: 40px;
}

.resume-box {
	padding: 20px;
}

.resume-box table {
	margin-bottom: 40px;
}

table.type09 {
	width: 100%;
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
}

table.type09 thead th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table.type09 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

table.type09 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

table.type09 td input {
	border: none;
}

.resume-write-footer {
	position: fixed;
	width: 100%;
	height: 80px;
	background: white;
	bottom: 0;
	display: flex;
	justify-content: right;
	align-items: center;
	border-top: 1px lightgray solid;
}

.resume-save-impl-btn {
	width: 200px;
	height: 40px;
	border: 1px dodgerblue solid;
	border-radius: 20px;
	background: white;
	font-weight: 900;
	margin-right: 50px;
}

.resume-save-btn {
	width: 200px;
	height: 40px;
	border: 1px dodgerblue solid;
	border-radius: 20px;
	background: dodgerblue;
	color: white;
	font-weight: 900;
	margin-right: 100px;
}

.recruit-resume-detail-footer {
	position: fixed;
	width: 100%;
	height: 80px;
	background: white;
	bottom: 0;
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-top: 1px lightgray solid;
}

.back-btn {
	width: 200px;
	height: 40px;
	border-radius: 20px;
	background: gray;
	color: white;
	font-weight: 900;
	margin-left: 50%;
}

.btn-box-right {
	display: flex;
}

.pass-btn {
	width: 200px;
	height: 40px;
	border-radius: 20px;
	background: lightgreen;
	color: white;
	font-weight: 900;
	margin-right: 25px;
}

.nonpass-btn {
	width: 200px;
	height: 40px;
	border-radius: 20px;
	background: lightcoral;
	color: white;
	font-weight: 900;
	margin-right: 100px;
}
</style>
