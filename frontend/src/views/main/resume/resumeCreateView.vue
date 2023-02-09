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
						<label for="portfolioInput" class="form-label">포트폴리오</label>
						<input
							class="form-control"
							id="portfolioInput"
							v-model="portfolio"
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
				<div class="title-input-box">
					<input
						class="form-control title-input"
						placeholder="이력서 제목(필수)"
						style="font-size: 48px; font-weight: bold; border: none"
						v-model.trim="resumeTitle"
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
						v-model.trim="myName"
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
					<h4>경력사항</h4>
					<table class="type09">
						<thead>
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
					<h4>수상내역</h4>
					<table class="type09">
						<thead>
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
					<h4>프로젝트 경험</h4>
					<div id="projectInfo" v-for="(item, i) in projectItems" :key="i">
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
					<h4>자기소개서</h4>
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
		<div class="resume-write-footer">
			<button class="resume-save-impl-btn" @click="saveImpl">임시저장</button>
			<button class="resume-save-btn" @click="save">저장하기</button>
		</div>
	</div>
</template>

<script>
export default {
	name: 'resumeCreateView',

	data() {
		return {
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
					title: 'certificatename1',
					date: 'certificatedate1',
					agency: 'certificateagency1',
				},
				{
					title: 'certificatename2',
					date: 'certificatedate2',
					agency: 'certificateagency2',
				},
				{
					title: 'certificatename3',
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
					result: 'projectreulst1',
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
					result: 'projectreulst2',
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
					result: 'projectreulst3',
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
		};
	},

	setup() {
		return {};
	},

	methods: {
		saveImpl() {
			const name = this.myName;
			const resumeTitle = this.resumeTitle;
			const phone = this.phone;
			const email = this.email;
			const portfolio = this.portfolio;
			const github = this.github;
			const blog = this.blog;

			const uniperiod1 = document.getElementById('uniperiod1');
			const uniperiod2 = document.getElementById('uniperiod2');
			const uniperiod3 = document.getElementById('uniperiod3');
			const uniname1 = document.getElementById('uniname1');
			const uniname2 = document.getElementById('uniname2');
			const uniname3 = document.getElementById('uniname3');
			const unimajor1 = document.getElementById('unimajor1');
			const unimajor2 = document.getElementById('unimajor2');
			const unimajor3 = document.getElementById('unimajor3');

			const eduname1 = document.getElementById('eduname1');
			const eduname2 = document.getElementById('eduname2');
			const eduname3 = document.getElementById('eduname3');
			const eduperiod1 = document.getElementById('eduperiod1');
			const eduperiod2 = document.getElementById('eduperiod2');
			const eduperiod3 = document.getElementById('eduperiod3');
			const educontent1 = document.getElementById('educontent1');
			const educontent2 = document.getElementById('educontent2');
			const educontent3 = document.getElementById('educontent3');
			const eduagency1 = document.getElementById('eduagency1');
			const eduagency2 = document.getElementById('eduagency2');
			const eduagency3 = document.getElementById('eduagency3');

			const actname1 = document.getElementById('actname1');
			const actname2 = document.getElementById('actname2');
			const actname3 = document.getElementById('actname3');
			const actperiod1 = document.getElementById('actperiod1');
			const actperiod2 = document.getElementById('actperiod2');
			const actperiod3 = document.getElementById('actperiod3');
			const actcontent1 = document.getElementById('actcontent1');
			const actcontent2 = document.getElementById('actcontent2');
			const actcontent3 = document.getElementById('actcontent3');
			const actagency1 = document.getElementById('actagency1');
			const actagency2 = document.getElementById('actagency2');
			const actagency3 = document.getElementById('actagency3');

			const careername1 = document.getElementById('careername1');
			const careername2 = document.getElementById('careername2');
			const careername3 = document.getElementById('careername3');
			const careerperiod1 = document.getElementById('careerperiod1');
			const careerperiod2 = document.getElementById('careerperiod2');
			const careerperiod3 = document.getElementById('careerperiod3');
			const careerwork1 = document.getElementById('careerwork1');
			const careerwork2 = document.getElementById('careerwork2');
			const careerwork3 = document.getElementById('careerwork3');

			const awardname1 = document.getElementById('awardname1');
			const awardname2 = document.getElementById('awardname2');
			const awardname3 = document.getElementById('awardname3');
			const awarddate1 = document.getElementById('awarddate1');
			const awarddate2 = document.getElementById('awarddate2');
			const awarddate3 = document.getElementById('awarddate3');
			const awardagency1 = document.getElementById('awardagency1');
			const awardagency2 = document.getElementById('awardagency2');
			const awardagency3 = document.getElementById('awardagency3');

			const certificatename1 = document.getElementById('certificatename1');
			const certificatename2 = document.getElementById('certificatename2');
			const certificatename3 = document.getElementById('certificatename3');
			const certificatedate1 = document.getElementById('certificatedate1');
			const certificatedate2 = document.getElementById('certificatedate2');
			const certificatedate3 = document.getElementById('certificatedate3');
			const certificateagency1 = document.getElementById('certificateagency1');
			const certificateagency2 = document.getElementById('certificateagency2');
			const certificateagency3 = document.getElementById('certificateagency3');

			const language1 = document.getElementById('language1');
			const language2 = document.getElementById('language2');
			const language3 = document.getElementById('language3');
			const languagename1 = document.getElementById('languagename1');
			const languagename2 = document.getElementById('languagename2');
			const languagename3 = document.getElementById('languagename3');
			const languagegrade1 = document.getElementById('languagegrade1');
			const languagegrade2 = document.getElementById('languagegrade2');
			const languagegrade3 = document.getElementById('languagegrade3');
			const languagedate1 = document.getElementById('languagedate1');
			const languagedate2 = document.getElementById('languagedate2');
			const languagedate3 = document.getElementById('languagedate3');

			// const uniperiod1 = document.getElementById('uniperiod1');
			// const uniperiod2 = document.getElementById('uniperiod2');
			// const uniperiod3 = document.getElementById('uniperiod3');
			// const uniname1 = document.getElementById('uniname1');
			// const uniname2 = document.getElementById('uniname2');
			// const uniname3 = document.getElementById('uniname3');
			// const unimajor1 = document.getElementById('unimajor1');
			// const unimajor2 = document.getElementById('unimajor2');
			// const unimajor3 = document.getElementById('unimajor3');
		},

		save() {},
	},
};
</script>

<style>
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
</style>
