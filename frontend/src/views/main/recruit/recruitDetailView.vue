<template>
	<div>
		<div class="bottom-btn-div font-LINE-Rg">
			<button
				id="bot-bt-apply"
				type="button"
				class="btnLightBlue btnFade"
				@click="doApply"
			>
				지원하기
			</button>
			<button
				id="bot-bt-list"
				type="button"
				class="btnLightBlue btnFade"
				@click="clickToList"
			>
				목록으로
			</button>
		</div>
		<div class="job-detail-con font-LINE-Rg">
			<div class="job-detail-rel">
				<div class="job-content">
					<div class="content-box">
						<section class="content-left">
							<div class="img-box">
								<img :src="detailList.imgUrl" />
							</div>
							<hr class="detail-hr" />
							<div class="recruit-detail-top">
								<p class="detail-top-title f32 font-LINE-Bd">
									{{ detailList.recruitTitle }}
								</p>

								<p class="f18">{{ detailList.companyName }}</p>
								<div class="detail-top-set font-LINE-Bd f18 mt-6">
									<div class="detail-coment">
										<div>#{{ detailList.eduRequirement }}</div>
										<div>#{{ detailList.workType }}</div>
										<div>#{{ detailList.career }}</div>
										<div>#{{ detailList.work }}</div>
									</div>
									<p>#{{ detailList.location }}</p>
								</div>
							</div>

							<hr class="detail-hr" />
							<div class="content-area mt-20" style="white-space: pre-wrap">
								{{ detailList.recruitContent }}
							</div>
						</section>
						<aside class="content-right">
							<div class="side-box">
								<div class="side-box-content">
									<div class="side-box-content-title f24 font-LINE-Bd">
										<p>{{ detailList.recruitTitle }}</p>
									</div>

									<div class="side-box-content-item-one">
										<p>{{ detailList.companyName }}</p>
										<p>( {{ detailList.location }} )</p>
									</div>
									<div class="side-box-content-item-two">
										<div></div>
										<div>
											<p>모집분야 {{ detailList.work }}</p>
										</div>
									</div>
								</div>

								<hr class="detail-hr" />
								<div class="resume-box" style="padding: 20px">
									<h6
										style="
											font-weight: bold;
											margin-bottom: 20px;
											text-align: center;
										"
									>
										이력서 선택
									</h6>
									<div class="dropdown">
										<button
											class="dropdown-toggle resume-dropdown-btn"
											type="button"
											id="dropdownMenuButton1"
											data-bs-toggle="dropdown"
											aria-expanded="false"
											style="
												position: relative;
												display: flex;
												justify-content: center;
												width: 100%;
												align-items: center;
												bottom: 5px;
											"
										>
											{{ selectResume.selectedResumeTitle }}
										</button>
										<ul
											class="dropdown-menu w-100"
											aria-labelledby="dropdownMenuButton1"
										>
											<li
												v-for="resume in resumeList.resume"
												:key="resume.resumeId"
											>
												<a
													class="dropdown-item non-hover"
													@click="select(resume.resumeId, resume.resumeTitle)"
													>{{ resume.resumeTitle }}</a
												>
											</li>
										</ul>
									</div>
								</div>
								<div class="side-button mt-10">
									<button
										id="apply-bt"
										type="button"
										class="btnLightBlue btnFade"
										@click="doApply"
									>
										지원하기
									</button>
									<button
										id="list-bt"
										type="button"
										class="btnLightBlue btnFade"
										@click="clickToList"
									>
										목록으로
									</button>
								</div>
							</div>
						</aside>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { reactive, toRaw } from 'vue';
import axios from 'axios';
import { url } from '../../../api/http';
import { useRoute, useRouter } from 'vue-router';
import Swal from 'sweetalert2';
export default {
	name: 'recruitDetailView',

	setup() {
		const route = useRoute();
		const router = useRouter();
		const recruitId = route.params.recruitId;

		const detailList = reactive({
			career: null,
			companyName: null,
			department: null,
			eduRequirement: null,
			imgUrl: null,
			location: null,
			recruitTitle: null,
			salary: null,
			work: null,
			workType: null,
			recruitContent: null,
			requirement: null,
		});

		const selectResume = reactive({
			selectedResumeId: '',
			selectedResumeTitle: '',
		});

		const resumeList = reactive({
			resume: '',
		});

		const oneUrl = reactive({
			onUrl: detailList.imgUrl,
		});

		axios({
			method: 'GET',
			url: url + '/recruit/detail/' + recruitId,
			headers: {
				Authorization: localStorage.getItem('jjob.s.token'),
			},
		})
			.then(response => {
				detailList.career = response.data.career;
				detailList.companyName = response.data.companyName;
				detailList.department = response.data.department;
				detailList.eduRequirement = response.data.eduRequirement;
				detailList.imgUrl = response.data.imgUrl;
				detailList.location = response.data.location;
				detailList.recruitTitle = response.data.recruitTitle;
				detailList.salary = response.data.salary;
				detailList.work = response.data.work;
				detailList.workType = response.data.workType;
				detailList.recruitContent = response.data.recruitContent;
				detailList.requirement = response.data.requirement;
			})
			.catch(() => {
				Swal.fire({
					title: 'OOPS!',
					text: '존재하지 않는 채용공고입니다.',
					icon: 'warning',
				});
			});

		axios({
			method: 'GET',
			url: url + '/resume/isapplied',
			headers: {
				Authorization: localStorage.getItem('jjob.s.token'),
			},
		}).then(res => {
			resumeList.resume = res.data;
		});

		const clickToList = () => {
			router.push({ name: 'recruit' });
		};

		const select = (id, title) => {
			selectResume.selectedResumeId = id;
			selectResume.selectedResumeTitle = title;
		};

		const doApply = () => {
			if (!selectResume.selectedResumeId) {
				Swal.fire({
					title: 'OOPS!',
					text: '선택된 이력서가 없습니다.',
					icon: 'warning',
				});
				return;
			}
			const resumeId = selectResume.selectedResumeId;

			const config = {
				status: '지원완료',
				step: '서류전형',
				title: '',
				content: '',
				result: '',
			};

			axios({
				method: 'POST',
				url: url + '/apply/' + recruitId + '/' + resumeId,
				headers: {
					Authorization: localStorage.getItem('jjob.s.token'),
				},
				data: config,
			}).then(() => {
				Swal.fire({
					title: 'Success!',
					text:
						detailList.companyName +
						' ' +
						detailList.recruitTitle +
						' 지원완료',
					icon: 'success',
				});
			});
		};

		return {
			oneUrl,
			detailList,
			selectResume,
			resumeList,
			clickToList,
			select,
			doApply,
			recruitId,
		};
	},
};
</script>

<style scoped>
.detail-hr {
	border: 1px solid black;
}
.job-detail-con {
	display: flex;
	justify-content: center;
	align-items: center;
}
.job-detail-rel {
	margin: 0 10%;
	width: 90%;
	padding: 10px 10px 10px 10px;
	box-sizing: border-box;
}
.content-box {
	display: flex;
	margin: 0px 0px 90px 10px;
	/* margin-bottom: 90px;
	margin-left: 10px; */
	padding: auto;
	justify-content: center;
	/* text-align: center; */
}
.content-left {
	width: 100%;
}
.img-box {
	display: flex;
	justify-content: center;
}
.img-box > img {
	width: 70%;
	object-fit: fill;
}
.detail-top-set {
	display: flex;
	justify-content: space-between;
}
.detail-top-set > p {
	display: flex;

	justify-content: center;
	align-items: center;
	color: var(--primary-color-1);
	background-color: #f3f5f8;

	text-align: center;

	padding: 5px;
	border-radius: 20px;
}

.detail-coment {
	display: flex;
	align-items: center;
}
.detail-coment div {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-right: 2%;
	padding: 5px;
	border-radius: 20px;
	background-color: #f3f5f8;
	text-align: center;
	color: var(--vt-c-divider-light-2);
}
.content-area {
	/* background-color: #f3f5f8; */
	background-color: #e4f4ec;
	border-radius: 15px;
	padding: 3%;
	color: var(--vt-c-divider-light-2);
	line-height: 1.75;
}
.content-right {
	width: 45%;
	height: 50%;
	position: sticky;
	top: 2%;
	margin-left: 2%;
	opacity: 1;
	transition: all 0.3s;
	/* border: 1px solid; */
}
.side-box {
	padding: 30px;
	border: 1px solid var(--primary-color-border-grey);
}
.dropdown > ul {
	text-align: center;
	transform: translate3d(5px, 30px, 0px) !important;
	border: 1px solid #949494;
}
.resume-box {
	height: 100%;
	padding: 20px 0px;
	background-color: #ffffff;
	/* text-align: center; */
	border-radius: 1px;
	box-shadow: 4px 5px 9px;
	margin-bottom: 20px;
}
.resume-box:hover {
	box-shadow: 1px 1px 4px;
}

.side-box-content-item-one {
	display: flex;
	justify-content: space-between;
	/* color: var(--vt-c-divider-light-1); */
}
.side-box-content-item-one > p + p {
	color: #51bffe;
}
.side-box-content-item-two {
	color: var(--vt-c-divider-light-2);
	line-height: 2;
}
.side-button {
	display: flex;
	justify-content: space-around;
}
.side-button > button {
}
#list-bt {
	color: #13aaff;
	background-color: white;
	margin: 3px 0px;
	width: 45%;
	height: 40px;
	border: 1px solid var(--primary-color-1);
}
#apply-bt {
	margin: 3px 0px;
	width: 45%;
	height: 40px;
	color: white;
}

#bot-bt-apply {
	margin: 0px 10px;
	width: 40%;
	height: 40%;
	color: white;
}
#bot-bt-list {
	margin: 0px 10px;
	color: #13aaff;
	background-color: white;
	width: 40%;
	height: 40%;
	border: 1px solid var(--primary-color-1);
}

.btnLightBlue {
	width: 100px;
	height: 30px;
	border-radius: 30px;
}
.bottom-btn-div {
	position: fixed;
	display: flex;
	align-items: center;
	bottom: 0%;
	height: 90px;
	width: 100%;
	background: linear-gradient(white, #949494);

	opacity: 0;
	transition: all 0.5s;
	display: flex;
	justify-content: center;
}

@media screen and (max-width: 1024px) {
	.content-right {
		opacity: 0;
		transition: all 0.2s;
		width: 0px;
	}
	.bottom-btn-div {
		opacity: 1;
	}
}
</style>
