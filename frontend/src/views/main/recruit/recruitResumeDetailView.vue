<template>
	<div>
		<div class="resume-container font-LINE-Rg">
			<div class="left-container">
				<div class="left-fix">
					<img
						src="../../../assets/images/blackbackground.jpg"
						class="resume-profile-image"
						alt="..."
					/>
					<div class="mb-3">
						<label for="phoneInput" class="form-label font-LINIE-Bd"
							>휴대폰</label
						>
						<input
							class="form-control"
							id="phoneInput"
							v-model="resume.resumeInfo.phone"
							readonly
						/>
					</div>
					<div class="mb-3">
						<label for="emailInput" class="form-label font-LINIE-Bd"
							>이메일</label
						>
						<input
							class="form-control"
							id="emailInput"
							v-model="resume.resumeInfo.email"
							readonly
						/>
					</div>

					<div class="mb-3">
						<label for="githubInput" class="form-label font-LINIE-Bd"
							>Github</label
						>
						<input
							class="form-control"
							id="githubInput"
							v-model="resume.resumeInfo.github"
							readonly
						/>
					</div>
					<div class="mb-3">
						<label for="blogInput" class="form-label font-LINIE-Bd"
							>블로그</label
						>
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
						style="font-size: 48px; font-weight: bold; border: none"
						v-model.trim="resume.resumeInfo.resumeTitle"
						readonly
					/>
					<input
						class="form-control"
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
					<p style="font-size: 24px" class="font-LINE-Bd">학력사항</p>
					<table class="type09">
						<thead class="type09 font-LINE-Bd">
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
					<p style="font-size: 24px" class="font-LINE-Bd">교육이수</p>
					<table class="type09">
						<thead class="type09 font-LINE-Bd">
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
					<p style="font-size: 24px" class="font-LINE-Bd">대내외활동</p>
					<table class="type09">
						<thead class="type09 font-LINE-Bd">
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
					<p style="font-size: 24px" class="font-LINE-Bd">경력사항</p>
					<table class="type09">
						<thead class="type09 font-LINE-Bd">
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
					<p style="font-size: 24px" class="font-LINE-Bd">수상내역</p>
					<table class="type09">
						<thead class="type09 font-LINE-Bd">
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
					<p style="font-size: 24px" class="font-LINE-Bd">자격증</p>
					<table class="type09">
						<thead class="type09 font-LINE-Bd">
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
					<p style="font-size: 24px" class="font-LINE-Bd">어학능력</p>
					<table class="type09">
						<thead class="type09 font-LINE-Bd">
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
						<p style="font-size: 24px" class="font-LINE-Bd">SW역량</p>
						<span>&nbsp;(보유기술 및 프로그래밍 언어)</span>
					</div>
					<table class="type09">
						<thead class="type09 font-LINE-Bd">
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
					<p style="font-size: 24px" class="font-LINE-Bd">프로젝트 경험</p>
					<div
						id="projectInfo"
						v-for="(item, i) in resume.resumeInfo.projectExpDtoList"
						:key="i"
					>
						<table class="type09">
							<thead class="type09 font-LINE-Bd">
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
					<p style="font-size: 24px" class="font-LINE-Bd">자기소개서</p>
					<div
						id="coverLetterInfo"
						v-for="(item, i) in resume.resumeInfo.coverLetterDtoList"
						:key="i"
					>
						<table class="type09">
							<thead class="type09 font-LINE-Bd">
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
		<div class="recruit-resume-footer">
			<button class="resume-return font-LINE-Bd" @click="goToRecruitResume">
				나가기
			</button>
			<div class="recruit-resume-btns font-LINE-Bd">
				<div class="footer-btns">
					<v-dialog v-model="modalInfo.dialog1" persistent width="auto">
						<template v-slot:activator="{ props }">
							<button class="pass-btn" @click="dialog2 = true" v-bind="props">
								합격
							</button>
						</template>
						<v-card style="padding: 20px">
							<v-card-title
								class="font-LINE-Bd"
								style="
									width: 100%;
									font-size: 28px;
									border-bottom: 2px solid black;
								"
							>
								최종 확인
							</v-card-title>
							<h5 class="font-LINE-Rg mt-2" style="margin-left: 10px">
								정말로 합격시키겠습니까?
							</h5>
							<br />
							<v-card-actions>
								<div style="display: flex">
									<button @click="resumepass" class="pass-btns-y font-LINE-Rg">
										합격
									</button>
									<button
										@click="modalInfo.dialog1 = false"
										class="pass-btns-n font-LINE-Rg"
									>
										돌아가기
									</button>
								</div>
							</v-card-actions>
						</v-card>
					</v-dialog>
					<v-dialog v-model="modalInfo.dialog2" persistent width="auto">
						<template v-slot:activator="{ props }">
							<button
								class="update nonpass-btn"
								v-bind="props"
								@click="dialog1 = true"
							>
								불합격
							</button>
						</template>
						<v-card style="padding: 20px">
							<v-card-title
								class="font-LINE-Bd"
								style="
									width: 100%;
									font-size: 28px;
									border-bottom: 2px solid black;
								"
							>
								불합격 사유
							</v-card-title>
							<br />
							<v-select
								class="font-LINE-Bd"
								v-model="selectReason.reason"
								:items="reasons"
								label="사유"
							></v-select>
							<v-textarea
								class="font-LINE-Bd"
								label="피드백"
								v-model="selectReason.feedback"
							></v-textarea>
							<v-card-actions>
								<div style="display: flex">
									<button
										@click="saveFailReason"
										class="pass-btns-y font-LINE-Rg"
									>
										저장하기
									</button>
									<button
										@click="modalInfo.dialog2 = false"
										class="pass-btns-n font-LINE-Rg"
									>
										돌아가기
									</button>
								</div>
							</v-card-actions>
						</v-card>
					</v-dialog>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { onMounted, reactive, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';
import { url } from '../../../api/http';
import { useStore } from 'vuex';

export default {
	name: 'recruitResumeDetail',

	setup() {
		const route = useRoute();

		const router = useRouter();

		const store = useStore();

		const modalInfo = reactive({
			dialog1: false,
			dialog2: false,
		});

		const reasons = ref(['내용 부족', '기술 스택 부적합']);

		const selectReason = reactive({
			reason: '',
			feedback: '',
		});

		const resume = reactive({
			resumeInfo: '',
		});

		const goToRecruitResume = () => {
			router.push({
				name: 'recruitResume',
			});
		};

		const saveFailReason = () => {
			updateApplyStatus(selectReason.reason, selectReason.feedback, '불합격');

			router.push({
				name: 'recruitResume',
			});
		};

		const resumepass = () => {
			updateApplyStatus('', '', '합격');
			modalInfo.dialog1 = false;

			router.push({
				name: 'recruitResume',
			});
		};

		const updateApplyStatus = (title, content, result) => {
			const applyId = route.params.applyId;

			const config = {
				status: '결과보기',
				step: '서류전형',
				title: title,
				content: content,
				result: result,
			};

			axios({
				method: 'PATCH',
				url: url + '/apply/' + applyId,
				headers: {
					Authorization: localStorage.getItem('jjob.s.token'),
				},
				data: config,
			}).then(res => {
				console.log(res);
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

				if (res.data.isOpened === false) {
					axios({
						method: 'PATCH',
						url: url + '/resume/change/status/' + resumeId,
						headers: {
							Authorization: localStorage.getItem('jjob.s.token'),
						},
					}).then(res => {
						console.log(res);
					});
				}
			});
		});

		return {
			resume,
			modalInfo,
			reasons,
			selectReason,
			goToRecruitResume,
			saveFailReason,
			resumepass,
			updateApplyStatus,
		};
	},
};
</script>

<style scoped>
.resume-container {
	width: 100%;
	padding-bottom: 50px;
	display: flex;
	border: 2px black solid;
}

.left-container {
	width: 30%;
	background-color: var(--primary-color-1);
	padding: 0 50px;
	border-right: 2px solid black;
}

.left-fix {
	position: sticky;
	top: 20px;
	margin-bottom: 150px;
	box-sizing: border-box;
}

.left-container label {
	font-size: 15px;
}

.resume-profile-image {
	width: 75%;
	aspect-ratio: 1/1;
	margin: 50px auto 25px;
	border: 10px white solid;
	/* border-radius: 40%; */
}

.right-container {
	width: 70%;
	background-color: white;
	padding: 60px 20px 20px 20px;
	/* border-top-right-radius: 10px; */
	/* border-bottom-right-radius: 10px; */
}

.right-container h4 {
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
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table.type09 tbody th {
	width: 150px;
	padding: 10px;
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

.recruit-resume-footer {
	position: fixed;
	width: 100%;
	height: 80px;
	background: white;
	bottom: 0;
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-top: 1px lightgray solid;
	padding: 0px 40px;
}
.footer-btns {
	display: flex;
}
.nonpass-btn {
	width: 200px;
	height: 40px;
	border-radius: 20px;
	background: rgb(255 126 126);
	color: white;
}
.pass-btn {
	width: 200px;
	height: 40px;
	border: 1px solid var(--primary-color-1);
	border-radius: 20px;
	background: var(--primary-color-1);
	color: white;
	margin-right: 20px;
}
.pass-btns-y {
	color: white;
	padding: 4px 0px;
	margin: 0px 2px;
	width: 100px;
	border-radius: 12px;
	background: var(--primary-color-1);
	box-shadow: 0px 5px 0px 0px #1487c9;
}
.pass-btns-y:hover {
	box-shadow: 0px 2px 0px 0px #1487c9;
	margin-top: 8px;
	margin-bottom: -5px;
}

.pass-btns-n {
	color: white;
	padding: 4px 0px;
	margin: 0px 2px;
	width: 100px;
	border-radius: 12px;
	background: #ff6d5a;
	box-shadow: 0px 5px 0px 0px #7b3329;
}
.pass-btns-n:hover {
	box-shadow: 0px 2px 0px 0px #7b3329;
	margin-top: 8px;
	margin-bottom: -5px;
}
.save-btns {
	display: flex;
}
.resume-return {
	width: 200px;
	height: 40px;
	border-radius: 20px;
	background: rgb(49, 56, 52);
	color: white;
}
</style>
