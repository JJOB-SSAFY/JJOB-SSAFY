<template>
	<div>
		<div class="resume-container font-LINE-Rg">
			<div class="left-container">
				<div class="left-fix">
					<img :src="profileImg" class="resume-profile-image" alt="..." />
					<div class="mb-3">
						<label for="phoneInput" class="form-label">휴대폰</label>
						<input
							class="form-control"
							id="phoneInput"
							placeholder="010-0000-0000"
							v-model="phone"
						/>
					</div>
					<div class="mb-3">
						<label for="emailInput" class="form-label">이메일</label>
						<input
							class="form-control"
							id="emailInput"
							placeholder="email@example.com"
							v-model="email"
						/>
					</div>

					<div class="mb-3">
						<label for="githubInput" class="form-label">Github</label>
						<input class="form-control" id="githubInput" v-model="github" />
					</div>
					<div class="mb-3">
						<label for="blogInput" class="form-label">블로그</label>
						<input class="form-control" id="blogInput" v-model="blog" />
					</div>
				</div>
			</div>
			<div class="right-container">
				<div class="title-input-box font-LINE-Bd">
					<input
						class="form-control title-input"
						placeholder="이력서 제목(필수)"
						style="font-size: 48px; border: none"
						v-model.trim="resumeTitle"
					/>
					<input
						class="form-control font-LINE-Bd"
						placeholder="이 름(필수)"
						style="
							font-size: 24px;
							border: none;
							margin-top: 25px;
							margin-left: 5px;
						"
						v-model.trim="myName"
					/>
				</div>
				<hr style="margin-bottom: 50px" />
				<div class="resume-box">
					<h4 class="font-LINE-Bd">학력사항</h4>
					<table class="type09">
						<thead class="font-LINE-Bd">
							<tr>
								<th scope="cols">기 간</th>
								<th scope="cols">학 교 명</th>
								<th scope="cols">학 과</th>
							</tr>
						</thead>
						<tbody id="universityInfo" v-for="(item, i) in uniItems" :key="i">
							<tr>
								<td>
									<input class="form-control" :id="item.period" />
								</td>
								<td>
									<input class="form-control" :id="item.name" />
								</td>
								<td>
									<input class="form-control" :id="item.major" />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4 class="font-LINE-Bd">교육이수</h4>
					<table class="type09">
						<thead class="font-LINE-Bd">
							<tr>
								<th scope="cols">교 육 명</th>
								<th scope="cols">교육 기간</th>
								<th scope="cols">교육 내용</th>
								<th scope="cols">교육 기관</th>
							</tr>
						</thead>
						<tbody id="educationInfo" v-for="(item, i) in eduItems" :key="i">
							<tr>
								<td><input class="form-control" :id="item.name" /></td>
								<td>
									<input class="form-control" :id="item.period" />
								</td>
								<td>
									<input class="form-control" :id="item.content" />
								</td>
								<td>
									<input class="form-control" :id="item.agency" />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4 class="font-LINE-Bd">대내외활동</h4>
					<table class="type09">
						<thead class="font-LINE-Bd">
							<tr>
								<th scope="cols">활 동 명</th>
								<th scope="cols">활동 기간</th>
								<th scope="cols">활동 내용</th>
								<th scope="cols">주관 기관</th>
							</tr>
						</thead>
						<tbody
							id="activityInfo"
							v-for="(item, i) in activityItems"
							:key="i"
						>
							<tr>
								<td><input class="form-control" :id="item.name" /></td>
								<td><input class="form-control" :id="item.period" /></td>
								<td><input class="form-control" :id="item.content" /></td>
								<td><input class="form-control" :id="item.agency" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4 class="font-LINE-Bd">경력사항</h4>
					<table class="type09">
						<thead class="font-LINE-Bd">
							<tr>
								<th scope="cols">기 업 명</th>
								<th scope="cols">재직 기간</th>
								<th scope="cols">직무 및 업무내용</th>
							</tr>
						</thead>
						<tbody id="careerInfo" v-for="(item, i) in careerItems" :key="i">
							<tr>
								<td><input class="form-control" :id="item.name" /></td>
								<td><input class="form-control" :id="item.period" /></td>
								<td><input class="form-control" :id="item.work" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4 class="font-LINE-Bd">수상내역</h4>
					<table class="type09">
						<thead class="font-LINE-Bd">
							<tr>
								<th scope="cols">수 상 명</th>
								<th scope="cols">수상 일자</th>
								<th scope="cols">수여 기관</th>
							</tr>
						</thead>
						<tbody id="awardInfo" v-for="(item, i) in awardItems" :key="i">
							<tr>
								<td><input class="form-control" :id="item.name" /></td>
								<td><input class="form-control" :id="item.date" /></td>
								<td><input class="form-control" :id="item.agency" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4 class="font-LINE-Bd">자격증</h4>
					<table class="type09">
						<thead class="font-LINE-Bd">
							<tr>
								<th scope="cols">자 격 명</th>
								<th scope="cols">취득 일자</th>
								<th scope="cols">주관 기관</th>
							</tr>
						</thead>
						<tbody
							id="certificateInfo"
							v-for="(item, i) in certificateItems"
							:key="i"
						>
							<tr>
								<td><input class="form-control" :id="item.name" /></td>
								<td><input class="form-control" :id="item.date" /></td>
								<td><input class="form-control" :id="item.agency" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4 class="font-LINE-Bd">어학능력</h4>
					<table class="type09">
						<thead class="font-LINE-Bd">
							<tr>
								<th scope="cols">언 어</th>
								<th scope="cols">시 험 명</th>
								<th scope="cols">점 수 (등 급)</th>
								<th scope="cols">취 득 일</th>
							</tr>
						</thead>
						<tbody
							id="languageInfo"
							v-for="(item, i) in languageItems"
							:key="i"
						>
							<tr>
								<td><input class="form-control" :id="item.language" /></td>
								<td><input class="form-control" :id="item.name" /></td>
								<td><input class="form-control" :id="item.grade" /></td>
								<td><input class="form-control" :id="item.date" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<div style="display: flex; align-items: center">
						<h4 class="font-LINE-Bd">SW역량</h4>
						<span>&nbsp;(보유기술 및 프로그래밍 언어)</span>
					</div>
					<table class="type09">
						<thead class="font-LINE-Bd">
							<tr>
								<th scope="cols">보유기술 및 능력</th>
								<th scope="cols">수 준</th>
								<th scope="cols">상세 내용</th>
							</tr>
						</thead>
						<tbody id="skillInfo" v-for="(item, i) in skillItems" :key="i">
							<tr>
								<td><input class="form-control" :id="item.name" /></td>
								<td><input class="form-control" :id="item.level" /></td>
								<td><input class="form-control" :id="item.detail" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="resume-box">
					<h4 class="font-LINE-Bd">프로젝트 경험</h4>
					<div id="projectInfo" v-for="(item, i) in projectItems" :key="i">
						<table class="type09">
							<thead class="font-LINE-Bd">
								<tr>
									<th scope="cols">타이틀</th>
									<th scope="cols">내용</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">프로젝트 명</th>
									<td><input class="form-control" :id="item.name" /></td>
								</tr>
								<tr>
									<th scope="row">기 간</th>
									<td><input class="form-control" :id="item.period" /></td>
								</tr>
								<tr>
									<th scope="row">참여 인원</th>
									<td><input class="form-control" :id="item.userCount" /></td>
								</tr>
								<tr>
									<th scope="row">개 요</th>
									<td><input class="form-control" :id="item.outline" /></td>
								</tr>
								<tr>
									<th scope="row">기술 환경</th>
									<td><input class="form-control" :id="item.devEnv" /></td>
								</tr>
								<tr>
									<th scope="row">담당 역할</th>
									<td><input class="form-control" :id="item.role" /></td>
								</tr>
								<tr>
									<th scope="row">주요 기능 및 구현 과정</th>
									<td><input class="form-control" :id="item.function" /></td>
								</tr>
								<tr>
									<th scope="row">성과 및 배운 점</th>
									<td><input class="form-control" :id="item.result" /></td>
								</tr>
								<tr>
									<th scope="row">참고 링크</th>
									<td><input class="form-control" :id="item.link" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="resume-box">
					<h4 class="font-LINE-Bd">자기소개서</h4>
					<div
						id="coverLetterInfo"
						v-for="(item, i) in coverLetterItems"
						:key="i"
					>
						<table class="type09">
							<thead>
								<tr>
									<th scope="cols">
										<input
											class="form-control"
											placeholder="제 목"
											:id="item.title"
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
											:id="item.content"
										/>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="resume-write-footer font-LINE-Bd">
			<button class="resume-return" @click="backward">나가기</button>
			<div class="save-btns">
				<button class="resume-save-impl-btn" @click="saveImpl">임시저장</button>
				<button class="resume-save-btn" @click="save">저장하기</button>
			</div>
		</div>
	</div>
</template>

<script>
import resumeService from '../../../api/resumeService';
import Swal from 'sweetalert2';
import axios from 'axios';
import { url } from '../../../api/http';

export default {
	name: 'resumeCreateView',

	data() {
		return {
			resumeService: null,
			uniItems: [
				{ period: 'uniperiod1', name: 'uniname1', major: 'unimajor1' },
				{ period: 'uniperiod2', name: 'uniname2', major: 'unimajor2' },
				{ period: 'uniperiod3', name: 'uniname3', major: 'unimajor3' },
			],

			eduItems: [
				{
					name: 'eduname1',
					period: 'eduperiod1',
					content: 'educontent1',
					agency: 'eduagency1',
				},
				{
					name: 'eduname2',
					period: 'eduperiod2',
					content: 'educontent2',
					agency: 'eduagency2',
				},
				{
					name: 'eduname3',
					period: 'eduperiod3',
					content: 'educontent3',
					agency: 'eduagency3',
				},
			],

			activityItems: [
				{
					name: 'actname1',
					period: 'actperiod1',
					content: 'actcontent1',
					agency: 'actagency1',
				},
				{
					name: 'actname2',
					period: 'actperiod2',
					content: 'actcontent2',
					agency: 'actagency2',
				},
				{
					name: 'actname3',
					period: 'actperiod3',
					content: 'actcontent3',
					agency: 'actagency3',
				},
			],

			careerItems: [
				{
					name: 'careername1',
					period: 'careerperiod1',
					work: 'careerwork1',
				},
				{
					name: 'careername2',
					period: 'careerperiod2',
					work: 'careerwork2',
				},
				{
					name: 'careername3',
					period: 'careerperiod3',
					work: 'careerwork3',
				},
			],

			awardItems: [
				{
					name: 'awardname1',
					date: 'awarddate1',
					agency: 'awardagency1',
				},
				{
					name: 'awardname2',
					date: 'awarddate2',
					agency: 'awardagency2',
				},
				{
					name: 'awardname3',
					date: 'awarddate3',
					agency: 'awardagency3',
				},
			],

			certificateItems: [
				{
					name: 'certificatename1',
					date: 'certificatedate1',
					agency: 'certificateagency1',
				},
				{
					name: 'certificatename2',
					date: 'certificatedate2',
					agency: 'certificateagency2',
				},
				{
					name: 'certificatename3',
					date: 'certificatedate3',
					agency: 'certificateagency3',
				},
			],

			languageItems: [
				{
					language: 'language1',
					name: 'languagename1',
					grade: 'languagegrade1',
					date: 'languagedate1',
				},
				{
					language: 'language2',
					name: 'languagename2',
					grade: 'languagegrade2',
					date: 'languagedate2',
				},
				{
					language: 'language3',
					name: 'languagename3',
					grade: 'languagegrade3',
					date: 'languagedate3',
				},
			],

			skillItems: [
				{
					name: 'skillname1',
					level: 'skilllevel1',
					detail: 'skilldetail1',
				},
				{
					name: 'skillname2',
					level: 'skilllevel2',
					detail: 'skilldetail2',
				},
				{
					name: 'skillname3',
					level: 'skilllevel3',
					detail: 'skilldetail3',
				},
			],

			projectItems: [
				{
					name: 'projectname1',
					period: 'projectperiod1',
					userCount: 'projectuserCount1',
					outline: 'projectoutline1',
					devEnv: 'projectdevEnv1',
					role: 'projectrole1',
					function: 'projectfunction1',
					result: 'projectresult1',
					link: 'projectlink1',
				},
				{
					name: 'projectname2',
					period: 'projectperiod2',
					userCount: 'projectuserCount2',
					outline: 'projectoutline2',
					devEnv: 'projectdevEnv2',
					role: 'projectrole2',
					function: 'projectfunction2',
					result: 'projectresult2',
					link: 'projectlink2',
				},
				{
					name: 'projectname3',
					period: 'projectperiod3',
					userCount: 'projectuserCount3',
					outline: 'projectoutline3',
					devEnv: 'projectdevEnv3',
					role: 'projectrole3',
					function: 'projectfunction3',
					result: 'projectresult3',
					link: 'projectlink3',
				},
			],

			coverLetterItems: [
				{
					title: 'coverLetterTitle1',
					content: 'coverLetterContent1',
				},
				{
					title: 'coverLetterTitle2',
					content: 'coverLetterContent2',
				},
				{
					title: 'coverLetterTitle3',
					content: 'coverLetterContent3',
				},
			],

			myName: null,
			resumeTitle: null,
			phone: null,
			email: null,
			portfolio: null,
			github: null,
			blog: null,
			profileImg: '',
		};
	},

	created() {
		this.resumeService = new resumeService();

		axios({
			method: 'GET',
			url: url + '/card/image',
			headers: {
				Authorization: localStorage.getItem('jjob.s.token'),
			},
		}).then(res => {
			this.profileImg = res.data.profileImg;
			// console.log(res.data);
		});
	},
	mounted() {
		window.scrollTo(0, 0);
	},

	methods: {
		backward() {
			// if (confirm('지금 뒤로가면 저장되지 않습니다. 계속하시겠습니까?')) {
			// 	this.$router.push({
			// 		name: 'myInfo',
			// 	});
			// } else {
			// 	return;
			// }
			let flag = false;
			Swal.fire({
				title: '저장하지 않았습니다!',
				text: '지금 뒤로가면 저장되지 않습니다!',
				icon: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: '예',
				cancelButtonText: '아니요',
			})
				.then(result => {
					if (result.isConfirmed) flag = true;
					else flag = false;
				})
				.then(() => {
					if (flag) {
						{
							this.$router.push({
								name: 'myInfo',
							});
						}
					} else {
						return;
					}
				});
		},
		saveImpl() {
			const name = this.myName;
			const resumeTitle = this.resumeTitle;
			const phone = this.phone;
			const email = this.email;
			const portfolio = this.portfolio;
			const github = this.github;
			const blog = this.blog;

			const uniperiod1 = document.getElementById('uniperiod1').value.trim();
			const uniperiod2 = document.getElementById('uniperiod2').value.trim();
			const uniperiod3 = document.getElementById('uniperiod3').value.trim();
			const uniname1 = document.getElementById('uniname1').value.trim();
			const uniname2 = document.getElementById('uniname2').value.trim();
			const uniname3 = document.getElementById('uniname3').value.trim();
			const unimajor1 = document.getElementById('unimajor1').value.trim();
			const unimajor2 = document.getElementById('unimajor2').value.trim();
			const unimajor3 = document.getElementById('unimajor3').value.trim();

			const eduname1 = document.getElementById('eduname1').value.trim();
			const eduname2 = document.getElementById('eduname2').value.trim();
			const eduname3 = document.getElementById('eduname3').value.trim();
			const eduperiod1 = document.getElementById('eduperiod1').value.trim();
			const eduperiod2 = document.getElementById('eduperiod2').value.trim();
			const eduperiod3 = document.getElementById('eduperiod3').value.trim();
			const educontent1 = document.getElementById('educontent1').value.trim();
			const educontent2 = document.getElementById('educontent2').value.trim();
			const educontent3 = document.getElementById('educontent3').value.trim();
			const eduagency1 = document.getElementById('eduagency1').value.trim();
			const eduagency2 = document.getElementById('eduagency2').value.trim();
			const eduagency3 = document.getElementById('eduagency3').value.trim();

			const actname1 = document.getElementById('actname1').value.trim();
			const actname2 = document.getElementById('actname2').value.trim();
			const actname3 = document.getElementById('actname3').value.trim();
			const actperiod1 = document.getElementById('actperiod1').value.trim();
			const actperiod2 = document.getElementById('actperiod2').value.trim();
			const actperiod3 = document.getElementById('actperiod3').value.trim();
			const actcontent1 = document.getElementById('actcontent1').value.trim();
			const actcontent2 = document.getElementById('actcontent2').value.trim();
			const actcontent3 = document.getElementById('actcontent3').value.trim();
			const actagency1 = document.getElementById('actagency1').value.trim();
			const actagency2 = document.getElementById('actagency2').value.trim();
			const actagency3 = document.getElementById('actagency3').value.trim();

			const careername1 = document.getElementById('careername1').value.trim();
			const careername2 = document.getElementById('careername2').value.trim();
			const careername3 = document.getElementById('careername3').value.trim();
			const careerperiod1 = document
				.getElementById('careerperiod1')
				.value.trim();
			const careerperiod2 = document
				.getElementById('careerperiod2')
				.value.trim();
			const careerperiod3 = document
				.getElementById('careerperiod3')
				.value.trim();
			const careerwork1 = document.getElementById('careerwork1').value.trim();
			const careerwork2 = document.getElementById('careerwork2').value.trim();
			const careerwork3 = document.getElementById('careerwork3').value.trim();

			const awardname1 = document.getElementById('awardname1').value.trim();
			const awardname2 = document.getElementById('awardname2').value.trim();
			const awardname3 = document.getElementById('awardname3').value.trim();
			const awarddate1 = document.getElementById('awarddate1').value.trim();
			const awarddate2 = document.getElementById('awarddate2').value.trim();
			const awarddate3 = document.getElementById('awarddate3').value.trim();
			const awardagency1 = document.getElementById('awardagency1').value.trim();
			const awardagency2 = document.getElementById('awardagency2').value.trim();
			const awardagency3 = document.getElementById('awardagency3').value.trim();

			const certificatename1 = document
				.getElementById('certificatename1')
				.value.trim();
			const certificatename2 = document
				.getElementById('certificatename2')
				.value.trim();
			const certificatename3 = document
				.getElementById('certificatename3')
				.value.trim();
			const certificatedate1 = document
				.getElementById('certificatedate1')
				.value.trim();
			const certificatedate2 = document
				.getElementById('certificatedate2')
				.value.trim();
			const certificatedate3 = document
				.getElementById('certificatedate3')
				.value.trim();
			const certificateagency1 = document
				.getElementById('certificateagency1')
				.value.trim();
			const certificateagency2 = document
				.getElementById('certificateagency2')
				.value.trim();
			const certificateagency3 = document
				.getElementById('certificateagency3')
				.value.trim();

			const language1 = document.getElementById('language1').value.trim();
			const language2 = document.getElementById('language2').value.trim();
			const language3 = document.getElementById('language3').value.trim();
			const languagename1 = document
				.getElementById('languagename1')
				.value.trim();
			const languagename2 = document
				.getElementById('languagename2')
				.value.trim();
			const languagename3 = document
				.getElementById('languagename3')
				.value.trim();
			const languagegrade1 = document
				.getElementById('languagegrade1')
				.value.trim();
			const languagegrade2 = document
				.getElementById('languagegrade2')
				.value.trim();
			const languagegrade3 = document
				.getElementById('languagegrade3')
				.value.trim();
			const languagedate1 = document
				.getElementById('languagedate1')
				.value.trim();
			const languagedate2 = document
				.getElementById('languagedate2')
				.value.trim();
			const languagedate3 = document
				.getElementById('languagedate3')
				.value.trim();

			const skillname1 = document.getElementById('skillname1').value.trim();
			const skillname2 = document.getElementById('skillname2').value.trim();
			const skillname3 = document.getElementById('skillname3').value.trim();
			const skilllevel1 = document.getElementById('skilllevel1').value.trim();
			const skilllevel2 = document.getElementById('skilllevel2').value.trim();
			const skilllevel3 = document.getElementById('skilllevel3').value.trim();
			const skilldetail1 = document.getElementById('skilldetail1').value.trim();
			const skilldetail2 = document.getElementById('skilldetail2').value.trim();
			const skilldetail3 = document.getElementById('skilldetail3').value.trim();

			const projectname1 = document.getElementById('projectname1').value.trim();
			const projectname2 = document.getElementById('projectname2').value.trim();
			const projectname3 = document.getElementById('projectname3').value.trim();
			const projectperiod1 = document
				.getElementById('projectperiod1')
				.value.trim();
			const projectperiod2 = document
				.getElementById('projectperiod2')
				.value.trim();
			const projectperiod3 = document
				.getElementById('projectperiod3')
				.value.trim();
			const projectuserCount1 = document
				.getElementById('projectuserCount1')
				.value.trim();
			const projectuserCount2 = document
				.getElementById('projectuserCount2')
				.value.trim();
			const projectuserCount3 = document
				.getElementById('projectuserCount3')
				.value.trim();
			const projectoutline1 = document
				.getElementById('projectoutline1')
				.value.trim();
			const projectoutline2 = document
				.getElementById('projectoutline2')
				.value.trim();
			const projectoutline3 = document
				.getElementById('projectoutline3')
				.value.trim();
			const projectdevEnv1 = document
				.getElementById('projectdevEnv1')
				.value.trim();
			const projectdevEnv2 = document
				.getElementById('projectdevEnv2')
				.value.trim();
			const projectdevEnv3 = document
				.getElementById('projectdevEnv3')
				.value.trim();
			const projectrole1 = document.getElementById('projectrole1').value.trim();
			const projectrole2 = document.getElementById('projectrole2').value.trim();
			const projectrole3 = document.getElementById('projectrole3').value.trim();
			const projectfunction1 = document
				.getElementById('projectfunction1')
				.value.trim();
			const projectfunction2 = document
				.getElementById('projectfunction2')
				.value.trim();
			const projectfunction3 = document
				.getElementById('projectfunction3')
				.value.trim();
			const projectresult1 = document
				.getElementById('projectresult1')
				.value.trim();
			const projectresult2 = document
				.getElementById('projectresult2')
				.value.trim();
			const projectresult3 = document
				.getElementById('projectresult3')
				.value.trim();
			const projectlink1 = document.getElementById('projectlink1').value.trim();
			const projectlink2 = document.getElementById('projectlink2').value.trim();
			const projectlink3 = document.getElementById('projectlink3').value.trim();

			const coverLetterTitle1 = document
				.getElementById('coverLetterTitle1')
				.value.trim();
			const coverLetterTitle2 = document
				.getElementById('coverLetterTitle2')
				.value.trim();
			const coverLetterTitle3 = document
				.getElementById('coverLetterTitle3')
				.value.trim();
			const coverLetterContent1 = document
				.getElementById('coverLetterContent1')
				.value.trim();
			const coverLetterContent2 = document
				.getElementById('coverLetterContent2')
				.value.trim();
			const coverLetterContent3 = document
				.getElementById('coverLetterContent3')
				.value.trim();

			const resumeInfo = {
				resumeTitle: resumeTitle,
				name: name,
				blog: blog,
				phone: phone,
				portfolio: portfolio,
				email: email,
				github: github,
				universityDtoList: [],
				educationDtoList: [],
				activityDtoList: [],
				careerDtoList: [],
				awardDtoList: [],
				certificateDtoList: [],
				languageAbilityDtoList: [],
				skillDtoList: [],
				projectExpDtoList: [],
				coverLetterDtoList: [],
			};

			if (!resumeTitle) {
				Swal.fire({
					title: 'OOPS!',
					text: '이력서 제목을 입력해주세요',
					icon: 'warning',
				});
				return;
			} else if (!name) {
				Swal.fire({
					title: 'OOPS!',
					text: '이름을 입력해주세요',
					icon: 'warning',
				});
				return;
			}

			if (uniperiod1 !== '' || uniname1 !== '' || unimajor1 !== '') {
				resumeInfo.universityDtoList.push({
					universityPeriod: uniperiod1,
					universityName: uniname1,
					major: unimajor1,
				});
			}

			if (uniperiod2 !== '' || uniname2 !== '' || unimajor2 !== '') {
				resumeInfo.universityDtoList.push({
					universityPeriod: uniperiod2,
					universityName: uniname2,
					major: unimajor2,
				});
			}

			if (uniperiod3 !== '' || uniname3 !== '' || unimajor3 !== '') {
				resumeInfo.universityDtoList.push({
					universityPeriod: uniperiod3,
					universityName: uniname3,
					major: unimajor3,
				});
			}

			if (
				eduname1 !== '' ||
				eduperiod1 !== '' ||
				educontent1 !== '' ||
				eduagency1 !== ''
			) {
				resumeInfo.educationDtoList.push({
					educationName: eduname1,
					educationPeriod: eduperiod1,
					educationContent: educontent1,
					educationInstitution: eduagency1,
				});
			}

			if (
				eduname2 !== '' ||
				eduperiod2 !== '' ||
				educontent2 !== '' ||
				eduagency2 !== ''
			) {
				resumeInfo.educationDtoList.push({
					educationName: eduname2,
					educationPeriod: eduperiod2,
					educationContent: educontent2,
					educationInstitution: eduagency2,
				});
			}

			if (
				eduname3 !== '' ||
				eduperiod3 !== '' ||
				educontent3 !== '' ||
				eduagency3 !== ''
			) {
				resumeInfo.educationDtoList.push({
					educationName: eduname3,
					educationPeriod: eduperiod3,
					educationContent: educontent3,
					educationInstitution: eduagency3,
				});
			}

			if (
				actname1 !== '' ||
				actperiod1 !== '' ||
				actcontent1 !== '' ||
				actagency1 !== ''
			) {
				resumeInfo.activityDtoList.push({
					activityName: actname1,
					activityPeriod: actperiod1,
					activityContent: actcontent1,
					activityInstitution: actagency1,
				});
			}

			if (
				actname2 !== '' ||
				actperiod2 !== '' ||
				actcontent2 !== '' ||
				actagency2 !== ''
			) {
				resumeInfo.activityDtoList.push({
					activityName: actname2,
					activityPeriod: actperiod2,
					activityContent: actcontent2,
					activityInstitution: actagency2,
				});
			}

			if (
				actname3 !== '' ||
				actperiod3 !== '' ||
				actcontent3 !== '' ||
				actagency3 !== ''
			) {
				resumeInfo.activityDtoList.push({
					activityName: actname3,
					activityPeriod: actperiod3,
					activityContent: actcontent3,
					activityInstitution: actagency3,
				});
			}

			if (careername1 !== '' || careerperiod1 !== '' || careerwork1 !== '') {
				resumeInfo.careerDtoList.push({
					companyName: careername1,
					careerPeriod: careerperiod1,
					careerContent: careerwork1,
				});
			}

			if (careername2 !== '' || careerperiod2 !== '' || careerwork2 !== '') {
				resumeInfo.careerDtoList.push({
					companyName: careername2,
					careerPeriod: careerperiod2,
					careerContent: careerwork2,
				});
			}

			if (careername3 !== '' || careerperiod3 !== '' || careerwork3 !== '') {
				resumeInfo.careerDtoList.push({
					companyName: careername3,
					careerPeriod: careerperiod3,
					careerContent: careerwork3,
				});
			}

			if (awardname1 !== '' || awarddate1 !== '' || awardagency1 !== '') {
				resumeInfo.awardDtoList.push({
					awardName: awardname1,
					awardDate: awarddate1,
					awardInstitution: awardagency1,
				});
			}

			if (awardname2 !== '' || awarddate2 !== '' || awardagency2 !== '') {
				resumeInfo.awardDtoList.push({
					awardName: awardname2,
					awardDate: awarddate2,
					awardInstitution: awardagency2,
				});
			}

			if (awardname3 !== '' || awarddate3 !== '' || awardagency3 !== '') {
				resumeInfo.awardDtoList.push({
					awardName: awardname3,
					awardDate: awarddate3,
					awardInstitution: awardagency3,
				});
			}

			if (
				certificatename1 !== '' ||
				certificatedate1 !== '' ||
				certificateagency1 !== ''
			) {
				resumeInfo.certificateDtoList.push({
					certificateName: certificatename1,
					certificateDate: certificatedate1,
					certificateInstitution: certificateagency1,
				});
			}

			if (
				certificatename2 !== '' ||
				certificatedate2 !== '' ||
				certificateagency2 !== ''
			) {
				resumeInfo.certificateDtoList.push({
					certificateName: certificatename2,
					certificateDate: certificatedate2,
					certificateInstitution: certificateagency2,
				});
			}

			if (
				certificatename3 !== '' ||
				certificatedate3 !== '' ||
				certificateagency3 !== ''
			) {
				resumeInfo.certificateDtoList.push({
					certificateName: certificatename3,
					certificateDate: certificatedate3,
					certificateInstitution: certificateagency3,
				});
			}

			if (
				language1 !== '' ||
				languagename1 !== '' ||
				languagegrade1 !== '' ||
				languagedate1 !== ''
			) {
				resumeInfo.languageAbilityDtoList.push({
					language: language1,
					testName: languagename1,
					grade: languagegrade1,
					testDate: languagedate1,
				});
			}

			if (
				language2 !== '' ||
				languagename2 !== '' ||
				languagegrade2 !== '' ||
				languagedate2 !== ''
			) {
				resumeInfo.languageAbilityDtoList.push({
					language: language2,
					testName: languagename2,
					grade: languagegrade2,
					testDate: languagedate2,
				});
			}

			if (
				language3 !== '' ||
				languagename3 !== '' ||
				languagegrade3 !== '' ||
				languagedate3 !== ''
			) {
				resumeInfo.languageAbilityDtoList.push({
					language: language3,
					testName: languagename3,
					grade: languagegrade3,
					testDate: languagedate3,
				});
			}

			if (skillname1 !== '' || skilllevel1 !== '' || skilldetail1 !== '') {
				resumeInfo.skillDtoList.push({
					skillName: skillname1,
					skillLevel: skilllevel1,
					detail: skilldetail1,
				});
			}

			if (skillname2 !== '' || skilllevel2 !== '' || skilldetail2 !== '') {
				resumeInfo.skillDtoList.push({
					skillName: skillname2,
					skillLevel: skilllevel2,
					detail: skilldetail2,
				});
			}

			if (skillname3 !== '' || skilllevel3 !== '' || skilldetail3 !== '') {
				resumeInfo.skillDtoList.push({
					skillName: skillname3,
					skillLevel: skilllevel3,
					detail: skilldetail3,
				});
			}

			if (
				projectname1 !== '' ||
				projectperiod1 !== '' ||
				projectuserCount1 !== '' ||
				projectoutline1 !== '' ||
				projectdevEnv1 !== '' ||
				projectrole1 !== '' ||
				projectfunction1 !== '' ||
				projectresult1 !== '' ||
				projectlink1 !== ''
			) {
				resumeInfo.projectExpDtoList.push({
					projectName: projectname1,
					projectPeriod: projectperiod1,
					memberCnt: projectuserCount1,
					summary: projectoutline1,
					techEnv: projectdevEnv1,
					position: projectrole1,
					function: projectfunction1,
					result: projectresult1,
					link: projectlink1,
				});
			}

			if (
				projectname2 !== '' ||
				projectperiod2 !== '' ||
				projectuserCount2 !== '' ||
				projectoutline2 !== '' ||
				projectdevEnv2 !== '' ||
				projectrole2 !== '' ||
				projectfunction2 !== '' ||
				projectresult2 !== '' ||
				projectlink2 !== ''
			) {
				resumeInfo.projectExpDtoList.push({
					projectName: projectname2,
					projectPeriod: projectperiod2,
					memberCnt: projectuserCount2,
					summary: projectoutline2,
					techEnv: projectdevEnv2,
					position: projectrole2,
					function: projectfunction2,
					result: projectresult2,
					link: projectlink2,
				});
			}

			if (
				projectname3 !== '' ||
				projectperiod3 !== '' ||
				projectuserCount3 !== '' ||
				projectoutline3 !== '' ||
				projectdevEnv3 !== '' ||
				projectrole3 !== '' ||
				projectfunction3 !== '' ||
				projectresult3 !== '' ||
				projectlink3 !== ''
			) {
				resumeInfo.projectExpDtoList.push({
					projectName: projectname3,
					projectPeriod: projectperiod3,
					memberCnt: projectuserCount3,
					summary: projectoutline3,
					techEnv: projectdevEnv3,
					position: projectrole3,
					function: projectfunction3,
					result: projectresult3,
					link: projectlink3,
				});
			}

			if (coverLetterTitle1 !== '' || coverLetterContent1 !== '') {
				resumeInfo.coverLetterDtoList.push({
					title: coverLetterTitle1,
					content: coverLetterContent1,
				});
			}

			if (coverLetterTitle2 !== '' || coverLetterContent2 !== '') {
				resumeInfo.coverLetterDtoList.push({
					title: coverLetterTitle2,
					content: coverLetterContent2,
				});
			}

			if (coverLetterTitle3 !== '' || coverLetterContent3 !== '') {
				resumeInfo.coverLetterDtoList.push({
					title: coverLetterTitle3,
					content: coverLetterContent3,
				});
			}
			this.resumeService.register(resumeInfo);
		},

		save() {
			this.saveImpl();
			if (!this.resumeTitle) {
				return;
			} else if (!this.myName) {
				return;
			}
			Swal.fire({
				title: '성공!',
				text: '저장되었습니다.',
				icon: 'success',
			});
			this.$router.push({
				name: 'myInfo',
			});
		},
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

.resume-write-footer {
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

.resume-save-impl-btn {
	width: 200px;
	height: 40px;
	border-radius: 20px;
	background: white;
	border: 1px solid var(--primary-color-1);
	color: var(--primary-color-1);
	margin-right: 20px;
}

.resume-save-btn {
	width: 200px;
	height: 40px;
	border: 1px solid var(--primary-color-1);
	border-radius: 20px;
	background: var(--primary-color-1);
	color: white;
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
