<template>
	<div>
		<div>
			<div class="jobDetailCon">
				<div class="jobDetailRel">
					<div class="jobContent">
						<!-- <div class="contentBoxTitle">
							<div>
								<h4>
									<b>{{ detailList.companyName }}</b>
								</h4>
							</div>
							<div>
								<router-link to="/recruit">
									<button type="button" class="btn btn-primary">
										목록으로
									</button>
								</router-link>
							</div>
						</div>
						<hr />
						<div class="contentBoxData">
							<div class="jobcontentDescription_left">
								<h5><b>학력</b></h5>
								<h6>
									{{ detailList.eduRequirement }}
								</h6>
								<br />
								<h5><b>근무형태</b></h5>
								<h6>
									{{ detailList.workType }}
								</h6>
								<br />
								<h5><b>경력</b></h5>
								<h6>
									{{ detailList.career }}
								</h6>
								<br />
							</div>
							<div class="jobcontentDescription_right">
								<h5><b>급여</b></h5>
								<h6>
									{{ detailList.salary }}
								</h6>
								<br />
								<h5><b>근무지역</b></h5>
								<h6>
									{{ detailList.department }}
								</h6>
								<br />
								<h5><b>모집분야</b></h5>
								<h6>
									{{ detailList.work }}
								</h6>
								<br />
							</div>
						</div>
						<hr /> -->
						<div class="contentBox">
							<section class="contentLeft">
								<div class="imgBox"></div>
								<hr />
								{{ detailList.imgUrl }}
								<!-- <div id="carouselExampleIndicators" class="carousel slide">
									<div>{{ detailList.imgUrl }}</div>
									<div class="carousel-indicators">
										<button
											type="button"
											data-bs-target="#carouselExampleIndicators"
											data-bs-slide-to="0"
											class="active"
											aria-current="true"
											aria-label="Slide 1"
										></button>
										<button
											type="button"
											data-bs-target="#carouselExampleIndicators"
											data-bs-slide-to="1"
											aria-label="Slide 2"
										></button>
										<button
											type="button"
											data-bs-target="#carouselExampleIndicators"
											data-bs-slide-to="2"
											aria-label="Slide 3"
										></button>
									</div>
									<div class="carousel-inner">
										<div class="carousel-item active">
											<img
												src="../../../assets/images/가로.jpg"
												class="d-block w-100"
												alt="..."
											/>
										</div>
										<div class="carousel-item">
											<img
												src="../../../assets/images/가로.jpg"
												class="d-block w-100"
												alt="..."
											/>
										</div>
										<div class="carousel-item">
											<img
												src="../../../assets/images/가로.jpg"
												alt="..."
												class="d-block w-100"
											/>
										</div>
									</div>
									<button
										class="carousel-control-prev"
										type="button"
										data-bs-target="#carouselExampleIndicators"
										data-bs-slide="prev"
									>
										<span
											class="carousel-control-prev-icon"
											aria-hidden="true"
										></span>
										<span class="visually-hidden">Previous</span>
									</button>
									<button
										class="carousel-control-next"
										type="button"
										data-bs-target="#carouselExampleIndicators"
										data-bs-slide="next"
									>
										<span
											class="carousel-control-next-icon"
											aria-hidden="true"
										></span>
										<span class="visually-hidden">Next</span>
									</button>
								</div> -->
								<br />
								<div>
									<span
										><h5>
											<b>회사이름 : {{ detailList.companyName }}</b>
										</h5></span
									><br />
									<span
										><h6>공고 타이틀 : {{ detailList.recruitTitle }}</h6></span
									>
									<hr />
									<span
										><h6>Location : {{ detailList.location }}</h6></span
									><br />
								</div>
								<div class="detailComent">
									<span>#{{ detailList.eduRequirement }}</span>
									<span>#{{ detailList.workType }}</span>
									<span>#{{ detailList.career }}</span>
									<span>#{{ detailList.work }}</span>
								</div>
								<hr />
								<div class="contentArea" style="white-space: pre-wrap">
									{{ detailList.recruitContent }}
								</div>
							</section>
							<aside class="contentRight">
								<div class="sideBox">
									<div class="sideBoxContent">
										<div class="sideBoxContentItem">
											<h5>
												<b>{{ detailList.companyName }}</b>
											</h5>
										</div>
										<br />
										<div><b>모집분야</b> : {{ detailList.department }}</div>
									</div>
									<hr />
									<div class="sideButton">
										<router-link to="/myinfo">
											<button type="button" class="btnLightBlue btnFade">
												지원하기
											</button>
										</router-link>
										<router-link to="/recruit">
											<button type="button" class="btnLightBlue btnFade">
												목록으로
											</button>
										</router-link>
									</div>
								</div>
							</aside>
						</div>

						<div class="sideBox-two">
							<div class="sideButton-two">
								<button type="button" class="btnLightBlue-two btnFade">
									지원하기
								</button>
								<button type="button" class="btnLightBlue-two btnFade">
									목록으로
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { reactive, ref, computed, toRaw } from 'vue';
import axios from 'axios';
import { url } from '../../../api/http';
import { useStore } from 'vuex';

export default {
	name: 'recruitDetailView',

	setup() {
		const recruitId = localStorage.getItem('page');
		// console.log(recruitId);
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
		const oneUrl = reactive({
			onUrl: detailList.imgUrl,
		});

		axios({
			method: 'GET',
			url: url + '/recruit/detail/' + recruitId,
		})
			.then(response => {
				// console.log(onUrl);
				console.log(response.data);
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
			.catch(err => {
				console.log(err);
			});
		return { oneUrl, detailList };
	},
};
</script>

<style scoped>
hr {
	border: 2px dashed pink;
}
.jobDetailCon {
	display: flex;
	justify-content: center;
	align-items: center;
	/* padding-right: 3%; */
}
.jobDetailRel {
	margin: 0 10%;
	/* margin-left: 10%;
	margin-right: 10%; */
	width: 90%;
	padding: 10px 10px 10px 10px;
	box-sizing: border-box;
}
/* .jobContent {
	padding-left: 3%;
	padding-right: 5%;
} */
/* .contentBoxTitle {
	display: flex;
	justify-content: space-between;
}
.contentBoxData {
	display: flex;
}
.jobcontentDescription_left {
	margin-right: 45%;
} */
.contentBox {
	display: flex;
	margin: auto;
	padding: auto;
	justify-content: center;
	/* text-align: center; */
}
.contentLeft {
	width: 65%;
	/* margin-right: 10%; */
}
@media screen and (max-width: 1000px) {
	.contentLeft {
		width: 100%;
		/* margin-left: 7%;
		margin-right: 5%; */
	}
}
.imgBox {
	/* border-bottom: 1px dashed pink; */
	background-image: url(onUrl);
	background-repeat: no-repeat;
	background-size: cover;
	width: 100%;
	height: 350px;
}
.detailComent span {
	margin-right: 2%;
	padding: 5px;
	border-radius: 15px;
	background-color: #f3f5f8;
	text-align: center;
	align-items: center;
}
.contentArea {
	/* border: 1px solid; */
	background-color: #f3f5f8;
	border-radius: 15px;
	padding: 3%;
}
.contentRight {
	width: 300px;
	height: 250px;
	position: sticky;
	top: 5%;
	margin-left: 10%;
}
@media screen and (max-width: 1000px) {
	.contentRight {
		display: none;
	}
}
.sideBox {
	margin-top: 10px;
	padding: 10%;
	background-color: #f3f5f8;
	text-align: center;
	border-radius: 1px;
	box-shadow: 1px 1px 1px 1px rgb(190, 188, 188);
}
.sideBoxContentItem {
	margin-right: 5px;
}
.sideButton {
	display: flex;
	justify-content: space-around;
}
.btnLightBlue {
	width: 100px;
	height: 30px;
	border-radius: 30px;
}
.sideBox-two {
	position: fixed;
	bottom: 0%;
	left: 10%;
	height: 50px;
	width: 80%;
	background-color: rgba(255, 255, 255, 0.7);
}
@media screen and (min-width: 1000px) {
	.sideBox-two {
		display: none;
	}
}
.sideButton-two {
	display: flex;
	justify-content: space-evenly;
	margin-top: 5px;
	margin-bottom: 3%;
}
.btnLightBlue-two {
	background-color: #13aaff;
	width: 45%;
	height: 30px;
	border-radius: 15px;
}
.btnFade.btnLightBlue-two:hover {
	background: #1487c9;
}
</style>
