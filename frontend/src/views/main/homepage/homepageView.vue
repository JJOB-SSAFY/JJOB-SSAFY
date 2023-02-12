<template class="homepage">
	<home-banner />
	<!-- <router-view /> -->
	<div class="container">
		<h2 style="font-weight: bold; text-align: center; margin: 60px 0 20px">
			최근 올라온 공고
		</h2>
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
		<div class="latest-reqruit-container">
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
						src="../../../assets/images/blackbackground.jpg"
						class="card-img-top"
						alt="..."
						style="border-radius: 5px"
					/>
					<div class="card-body">
						<h3 class="card-title mb-2">{{ recruit.recruitTitle }}</h3>
						<h6 class="mb-1" style="font-weight: bold">
							{{ recruit.companyName }}
						</h6>
						<p class="card-text mb-2" style="color: gray">
							{{ recruit.location }}
						</p>
					</div>
				</div>
			</div>
		</div>
		<h2 style="font-weight: bold; text-align: center; margin: 60px 0 20px">
			마감 임박 공고
		</h2>
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
		<div class="end-reqruit-container">
			<div
				v-for="recruit in recruitList.recruitDeadlineList"
				:key="recruit.recruitId"
			>
				<div class="card card-container" style="border: none">
					<img
						src="../../../assets/images/blackbackground.jpg"
						class="card-img-top"
						alt="..."
						style="border-radius: 5px"
					/>
					<div class="card-body">
						<h3 class="card-title mb-2">{{ recruit.recruitTitle }}</h3>
						<h6 class="mb-1" style="font-weight: bold">
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
import { useStore } from 'vuex';
import VueCookies from 'vue-cookies';
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
		const store = useStore();

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

		const type = VueCookies.get('type');

		if (type === 'social') {
			const accessToken = VueCookies.get('accessToken');
			const name = VueCookies.get('name');
			const role = VueCookies.get('role');

			const loginInfo = {
				accessToken: accessToken,
				name: name,
				role: role,
			};

			store.dispatch('auth/socialLogin', loginInfo);

			VueCookies.remove('type');
			VueCookies.remove('accessToken');
			VueCookies.remove('name');
			VueCookies.remove('role');
		}

		return { recruitList, goToRecruitView, goToRecruitDetailView };
	},
};
</script>

<style>
.latest-reqruit-container {
	display: flex;
	overflow: scroll;
	-ms-overflow-style: none; /* 인터넷 익스플로러 */
	scrollbar-width: none; /* 파이어폭스 */
}

.latest-reqruit-container::-webkit-scrollbar {
	display: none;
}

.end-reqruit-container {
	display: flex;
	overflow: scroll;
	-ms-overflow-style: none; /* 인터넷 익스플로러 */
	scrollbar-width: none; /* 파이어폭스 */
}

.end-reqruit-container::-webkit-scrollbar {
	display: none;
}

.card-container {
	width: 18rem;
	margin: 20px;
	cursor: pointer;
}
</style>
