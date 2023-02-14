<template>
	<div class="">
		<div class="banner-container">
			<span class="banner-letter1">지원자 이력서</span>
		</div>

		<div class="container-recruit">
			<ul class="responsive-table">
				<li class="table-header">
					<div class="col col-1">지원자</div>
					<div class="col col-1">지원 공고</div>
					<div class="col col-1">보유기술</div>
					<div class="col col-1">자기소개서</div>
					<div class="col col-1"></div>
				</li>
				<li
					v-for="apply in getApplyResumeList.state"
					:key="apply.applyStatusId"
					class="table-row"
				>
					<div class="col col-2" data-label="name">{{ apply.memberName }}</div>
					<div class="col col-2" data-label="recruitTitle">
						{{ apply.recruitTitle }}
					</div>
					<div class="col col-2" data-label="skills">{{ apply.skills }}</div>
					<div class="col col-2" data-label="resumeTitle">
						{{ apply.resumeTitle
						}}<fa-icon
							icon="far fa-solid fa-file"
							style="margin-left: 5px"
							@click="showDetailResume(apply.resumeId, apply.applyId)"
						/>
					</div>
					<div class="col col-2" data-label="resumeTitle">
						<v-row justify="center">
							<v-dialog v-model="modalInfo.dialog" persistent width="auto">
								<template v-slot:activator="{ props }">
									<v-btn
										variant="outlined"
										color="primary"
										@click="modalInfo.dialog === true"
										v-bind="props"
										style="margin-top: 7px; margin-right: 80px"
									>
										면접방 생성하기
									</v-btn>
									<!-- <v-btn class="pass-btn" color="green" v-bind="props">
										합격
									</v-btn> -->
								</template>
								<v-card style="padding: 20px">
									<v-card-title class="text-h5" style="width: 600px">
										면접방 생성
									</v-card-title>
									<br />
									<!-- <v-card-text
									>Let Google help apps determine location. This means sending
									anonymous location data to Google, even when no apps are
									running.11111111</v-card-text
								> -->
									<form @submit.prevent="submit">
										<v-text-field
											:counter="20"
											label="방 이름"
											v-model="interviewInfo.title"
										></v-text-field>
										<v-text-field
											label="면접 참여자 이메일"
											v-model="interviewInfo.participants"
										></v-text-field>
										<div class="interview-date-box">
											<div class="interview-date me-4">
												<label for="interview-date"> 면접 날짜 :&nbsp; </label>
												<input
													id="interview-date"
													type="date"
													v-model="interviewInfo.date"
												/>
											</div>
											<div class="start-time me-4">
												<label for="start-time"> 시작 시간 :&nbsp; </label>
												<input
													id="start-time"
													type="time"
													v-model="interviewInfo.starttime"
												/>
											</div>
											<div class="end-time">
												<label for="end-time"> 종료 시간 :&nbsp; </label
												><input
													id="end-time"
													type="time"
													v-model="interviewInfo.endtime"
												/>
											</div>
										</div>
									</form>
									<br />
									<v-card-actions>
										<v-spacer></v-spacer>
										<v-btn
											color="green-darken-1"
											variant="text"
											@click="createRoom"
										>
											생성하기
										</v-btn>
										<v-btn
											color="green-darken-1"
											variant="text"
											@click="modalInfo.dialog = false"
										>
											돌아가기
										</v-btn>
									</v-card-actions>
								</v-card>
							</v-dialog>
						</v-row>
					</div>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
import { useStore } from 'vuex';
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import applyService from '../../../api/applyService';
import axios from 'axios';
import { url } from '../../../api/http';

export default {
	name: 'RecruitResume',
	setup() {
		const store = useStore();

		const router = useRouter();

		const companyId = store.getters['auth/getCompanyId'];

		const modalInfo = reactive({
			dialog: false,
		});

		const interviewInfo = reactive({
			title: '',
			participants: '',
			date: '',
			starttime: '',
			endtime: '',
		});

		const getApplyResumeList = reactive({
			state: {},
		});

		const appService = new applyService();
		appService.getApplyResumeList(companyId).then(data => {
			getApplyResumeList.state = data;
		});

		const showDetailResume = (e, k) => {
			router.push({
				name: 'recruitResumeDetail',
				params: {
					resumeId: e,
					applyId: k,
				},
			});
		};

		const createRoom = () => {
			const companyId = store.getters['auth/getCompanyId'];

			const title = interviewInfo.title;
			const participants = interviewInfo.participants;
			const date = interviewInfo.date;
			const starttime = interviewInfo.starttime;
			const endtime = interviewInfo.endtime;

			let participantList = participants.split(',').map(item => item.trim());

			const config = {
				conferenceTitle: title,
				callEndTime: date + 'T' + endtime + ':00',
				callStartTime: date + 'T' + starttime + ':00',
				conferenceCategory: 'INTERVIEW',
				memberEmail: participantList,
			};

			axios({
				method: 'POST',
				url: url + '/conference/' + companyId,
				headers: {
					Authorization: localStorage.getItem('jjob.s.token'),
				},
				data: config,
			}).then(res => {
				console.log(res);
				modalInfo.dialog = false;
				router.push({
					name: 'recruitResume',
				});
			});
		};

		return {
			store,
			modalInfo,
			interviewInfo,
			getApplyResumeList,
			showDetailResume,
			createRoom,
		};
	},
};
</script>

<style scoped>
.interview-date-box {
	display: flex;
}
</style>
