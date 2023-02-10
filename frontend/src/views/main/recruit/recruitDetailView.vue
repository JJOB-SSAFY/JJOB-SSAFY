<template>
	<div>
		<div class="jobDetailBox">
			<div class="jobDetailCon">
				<div class="jobDetailRel">
					<div class="jobContent">
						<div class="contentBoxTitle">
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
						<hr />
						<div class="contentBox">
							<section class="imgBox">
								{{ detailList.imgUrl }}
								<img src="../../../assets/images/lion.jpg" alt="..." />
								<img src="../../../assets/images/lion.jpg" alt="..." />
								<img src="../../../assets/images/lion.jpg" alt="..." />
							</section>
							<aside class="sideBar">
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
									<button type="button" class="btn btn-primary">
										지원하기
									</button>
								</div>
							</aside>
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
		});

		axios({
			method: 'GET',
			url: url + '/recruit/detail/' + recruitId,
		})
			.then(response => {
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

				console.log(toRaw(detailList));
			})
			.catch(err => {
				console.log(err);
			});
		return { detailList };
	},
};
</script>

<style scoped>
.jobDetailCon {
	/* width: 90%; */
	/* border: 1px solid black; */
	display: flex;
	justify-content: center;
	align-items: center;
	padding-right: 5%;
}
.jobDetailRel {
	margin-left: 5%;
	width: 80%;
	background-color: whitesmoke;
	border-radius: 10px;
	padding: 40px 10px 10px 10px;
	box-sizing: border-box;
}
.jobContent {
	padding-left: 3%;
	padding-right: 5%;
}
.contentBoxTitle {
	display: flex;
	justify-content: space-between;
}
.contentBoxData {
	display: flex;
}
.jobcontentDescription_left {
	margin-right: 45%;
}
.contentBox {
	display: flex;
}
.imgBox {
	width: 65%;
	margin-right: 5%;
}
.sideBar {
	width: 300px;
	height: 250px;
	position: sticky;
	top: 5%;
}
.sideBox {
	/* position: sticky;
	top: 5%; */
	/* width: 300px;
	height: 200px; */
	margin-top: 10px;
	padding: 10%;
	background-color: #ccc;
	text-align: center;
	border-radius: 15px;
	box-shadow: 3px 3px 3px 3px #999;
}
/* .sideBoxContent {
	display: flex;
	justify-content: flex-start;
} */
.sideBoxContentItem {
	margin-right: 5px;
}
</style>
