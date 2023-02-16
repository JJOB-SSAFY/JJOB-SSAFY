<template class="homepage">
	<home-banner />
	<div class="container">
		<div class="scroll-box">
			<fa-icon
				@click="scrollLatestLeft"
				icon="far fa-regular fa-circle-left"
				style="font-size: 32px"
			/>
			<fa-icon
				@click="scrollLatestRight"
				icon="far fa-regular fa-circle-right"
				style="font-size: 32px"
			/>
		</div>
		<h2 class="font-LINE-Bd" style="text-align: center; margin: 60px 0 20px">
			최근 올라온 공고
		</h2>
		<div class="container-subtitle">
			<h6
				class="font-LINE-Rg"
				style="text-align: center; color: grey; cursor: pointer"
				@click="goToRecruitView"
			>
				전체 공고 보기
			</h6>
		</div>

		<div class="latest-recruit-container" id="latest-recruit-container">
			<div
				v-for="recruit in recruitList.recruitLatestList"
				:key="recruit.recruitId"
			>
				<div
					class="card card-container"
					style="border: none"
					@click="goToRecruitDetailView(recruit.recruitId)"
				>
					<img
						:src="recruit.recruitImage"
						class="card-img-top"
						alt="..."
						style="border-radius: 5px"
					/>
					<div class="card-body">
						<h3 class="card-title font-LINE-Bd mb-2">
							{{ recruit.recruitTitle }}
						</h3>
						<h6 class="mb-1 font-LINE-Rg" style="font-weight: bold">
							{{ recruit.companyName }}
						</h6>
						<p class="card-text mb-2" style="color: gray">
							{{ recruit.location }}
						</p>
					</div>
				</div>
			</div>
		</div>
		<hr />
		<div class="scroll-box">
			<fa-icon
				@click="scrollDeadLineLeft"
				icon="far fa-regular fa-circle-left"
				style="font-size: 32px"
			/>

			<fa-icon
				@click="scrollDeadLineRight"
				icon="far fa-regular fa-circle-right"
				style="font-size: 32px"
			/>
		</div>
		<h2 class="font-LINE-Bd" style="text-align: center; margin: 60px 0 20px">
			마감 임박 공고
		</h2>
		<div class="container-subtitle">
			<h6
				style="
					font-weight: bold;
					text-align: center;
					color: grey;
					cursor: pointer;
				"
				@click="goToRecruitView"
			>
				전체 공고 보기
			</h6>
		</div>

		<div class="end-recruit-container" id="deadline-recruit-container">
			<div
				v-for="recruit in recruitList.recruitDeadlineList"
				:key="recruit.recruitId"
			>
				<div
					class="card card-container"
					style="border: none"
					@click="goToRecruitDetailView(recruit.recruitId)"
				>
					<img
						:src="recruit.recruitImage"
						class="card-img-top"
						alt="..."
						style="border-radius: 5px"
					/>
					<div class="card-body">
						<h3 class="card-title font-LINE-Bd mb-2">
							{{ recruit.recruitTitle }}
						</h3>
						<h6 class="font-LINE-Rg mb-1" style="font-weight: bold">
							{{ recruit.companyName }}
						</h6>
						<p class="card-text mb-2" style="color: gray">
							{{ recruit.location }}
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { reactive } from 'vue';
import homeBanner from '../homepage/components/home-Banner.vue';
import { url } from '../../../api/http';
import axios from 'axios';
import { useRouter } from 'vue-router';

export default {
	name: 'homepageView',

	components: {
		homeBanner,
	},

	setup() {
		const router = useRouter();

		const recruitList = reactive({
			recruitLatestList: [],
			recruitDeadlineList: [],
		});

		axios({
			method: 'GET',
			url: url + '/latest',
			headers: {
				Authorization: localStorage.getItem('jjob.s.token'),
			},
		}).then(res => {
			recruitList.recruitLatestList = res.data;
		});

		axios({
			method: 'GET',
			url: url + '/deadline',
			headers: {
				Authorization: localStorage.getItem('jjob.s.token'),
			},
		}).then(res => {
			recruitList.recruitDeadlineList = res.data;
		});

		const goToRecruitView = () => {
			router.push({
				name: 'recruit',
			});
		};

		const goToRecruitDetailView = recruitId => {
			router.push({
				name: 'recruitDetail',
				params: {
					recruitId: recruitId,
				},
			});
		};

		const scrollLatestLeft = () => {
			const width = document.getElementById(
				'latest-recruit-container',
			).clientWidth;
			document.getElementById('latest-recruit-container').scrollLeft -= width;
		};

		const scrollLatestRight = () => {
			const width = document.getElementById(
				'latest-recruit-container',
			).clientWidth;
			document.getElementById('latest-recruit-container').scrollLeft += width;
		};

		const scrollDeadLineLeft = () => {
			const width = document.getElementById(
				'deadline-recruit-container',
			).clientWidth;
			document.getElementById('deadline-recruit-container').scrollLeft -= width;
		};

		const scrollDeadLineRight = () => {
			const width = document.getElementById(
				'deadline-recruit-container',
			).clientWidth;
			document.getElementById('deadline-recruit-container').scrollLeft += width;
		};

		return {
			recruitList,
			goToRecruitView,
			goToRecruitDetailView,
			scrollLatestLeft,
			scrollLatestRight,
			scrollDeadLineLeft,
			scrollDeadLineRight,
		};
	},
};
</script>

<style>
.latest-recruit-container {
	display: flex;
	overflow: scroll;
	-ms-overflow-style: none; /* 인터넷 익스플로러 */
	scrollbar-width: none; /* 파이어폭스 */
	scroll-behavior: smooth;
}

.latest-recruit-container {
	display: flex;
	align-items: flex-end;
}
.latest-recruit-container::-webkit-scrollbar {
	display: none;
}

.latest-recruit-container > div:first-child {
	margin-left: -10px;
}

.latest-recruit-container > div:last-child {
	margin-right: -20px;
}

.end-recruit-container {
	display: flex;
	overflow: scroll;
	-ms-overflow-style: none; /* 인터넷 익스플로러 */
	scrollbar-width: none; /* 파이어폭스 */
	scroll-behavior: smooth;
}

.end-recruit-container::-webkit-scrollbar {
	display: none;
}

.end-recruit-container > div {
	display: flex;
	align-items: flex-end;
}

.end-recruit-container > div:first-child {
	margin-left: -10px;
}

.end-recruit-container > div:last-child {
	margin-right: -10px;
}

.container-subtitle {
	display: flex;
	justify-content: center;
	align-items: center;
}
.scroll-box {
	margin: 0px -35px;
	position: relative;
	top: 356px;
	display: flex;
	z-index: 99;
	justify-content: space-between;
}
.scroll-box > svg:hover {
	transform: scale(1.1);
	transition: 0.3s;
}

.card-container {
	width: 18rem;
	margin: 20px;
	cursor: pointer;
}
.card-container > img:hover {
	transform: scale(1.03);
	transition: 0.3s;
}
.card-container > div:hover {
	transform: scale(1.03);
	transition: 0.3s;
}
</style>
