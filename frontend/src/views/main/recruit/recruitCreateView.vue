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
						<!-- <input
							class="register-form-input font-LINE-Rg"
							type="text"
							placeholder="이미지"
							v-model="info.imgUrl"
						/> -->
						<!-- <input
							type="file"
							ref="file"
							placeholder="사진"
							@change="imgUpload"
						/> -->
						<div class="filebox">
							<input
								class="upload-name"
								value="첨부파일"
								placeholder="첨부파일"
							/>
							<label for="file">파일찾기</label>
							<input type="file" id="file" />
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
import { watch } from 'vue';
import { reactive, ref } from 'vue';

export default {
	name: 'recruitCreateView',

	setup() {
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

		const register = function () {};

		return { info, register };
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
.filebox .upload-name {
	display: inline-block;
	height: 40px;
	padding: 0 10px;
	vertical-align: middle;
	border: 1px solid #dddddd;
	width: 78%;
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
</style>
