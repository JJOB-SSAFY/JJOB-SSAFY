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
						/>
					</div>
					<div class="mb-3">
						<label for="emailInput" class="form-label">이메일</label>
						<input
							class="form-control"
							id="emailInput"
							placeholder="email@example.com"
						/>
					</div>
					<div class="mb-3">
						<label for="skillInput" class="form-label">기술 스택</label>
						<input
							class="form-control"
							id="skillInput"
							placeholder="Java, Spring, Python..."
						/>
					</div>
					<div class="mb-3">
						<label for="githubInput" class="form-label">Github</label>
						<input class="form-control" id="githubInput" />
					</div>
					<div class="mb-3">
						<label for="blogInput" class="form-label">블로그</label>
						<input class="form-control" id="blogInput" />
					</div>
				</div>
			</div>
			<div class="right-container">
				<div class="title-input-box">
					<input
						class="form-control title-input"
						placeholder="이력서 제목(필수)"
						style="font-size: 48px; font-weight: bold; border: none"
					/>
				</div>
				<hr style="margin-bottom: 50px" />
				<div class="career-box">
					<h4>학력사항</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">기 간</th>
								<th scope="cols">학 교 명</th>
								<th scope="cols">학 과</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="career-box">
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
						<tbody>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="career-box">
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
						<tbody>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="career-box">
					<h4>경력사항</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">기 업 명</th>
								<th scope="cols">재직 기간</th>
								<th scope="cols">직무 및 업무내용</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="career-box">
					<h4>수상내역</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">수 상 명</th>
								<th scope="cols">수상 일자</th>
								<th scope="cols">수여 기관</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="career-box">
					<h4>자격증</h4>
					<table class="type09">
						<thead>
							<tr>
								<th scope="cols">자 격 명</th>
								<th scope="cols">취득 일자</th>
								<th scope="cols">주관 기관</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="career-box">
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
						<tbody>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="career-box">
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
						<tbody>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="career-box">
					<h4>프로젝트 경험</h4>
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
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">기 간</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">참여 인원</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">개 요</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">기술 환경</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">담당 역할</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">주요 기능 및 구현 과정</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">성과 및 배운 점</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">참고 링크</th>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
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
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">기 간</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">참여 인원</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">개 요</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">기술 환경</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">담당 역할</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">주요 기능 및 구현 과정</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">성과 및 배운 점</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">참고 링크</th>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
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
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">기 간</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">참여 인원</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">개 요</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">기술 환경</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">담당 역할</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">주요 기능 및 구현 과정</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">성과 및 배운 점</th>
								<td><input class="form-control" /></td>
							</tr>
							<tr>
								<th scope="row">참고 링크</th>
								<td><input class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="resume-write-footer">
			<button class="resume-save-impl-btn">임시저장</button>
			<button class="resume-save-btn">저장하기</button>
		</div>
	</div>
</template>

<script>
export default {};
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
	top: 0;
	margin-top: 50px;
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
	margin-bottom: 80px;
}

.career-box {
	padding: 20px;
}

.career-box table {
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
	margin-right: 50px;
}

.resume-save-btn {
	width: 200px;
	height: 40px;
	border: 1px dodgerblue solid;
	border-radius: 20px;
	background: dodgerblue;
	color: white;
	font-weight: bold;
	margin-right: 100px;
}
</style>
