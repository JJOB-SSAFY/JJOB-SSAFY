<template>
	<div class="">
		<div class="banner-container">
			<span class="banner-letter1">지원자 이력서</span>
		</div>

		<div class="container-recruit">
			<ul class="responsive-table">
				<li class="table-header">
					<div class="col col-1">지원자</div>
					<div class="col col-2">지원 공고</div>
					<div class="col col-4">보유기술</div>
					<div class="col col-1">이력서</div>
					<div class="col col-2"></div>
				</li>
				<li
					v-for="apply in getApplyResumeList.state"
					:key="apply.applyStatusId"
					class="table-row"
				>
					<div class="col col-1" data-label="name">{{ apply.memberName }}</div>
					<div class="col col-2" data-label="recruitTitle">
						{{ apply.recruitTitle }}
					</div>
					<div class="col col-4" data-label="skills">{{ apply.skills }}</div>
					<div class="col col-1" data-label="resumeTitle">
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
									<button
										class="btnOrange btnPush btnPush:hover"
										@click="modalInfo.dialog === true"
										v-bind="props"
										style="
											margin-right: 50px;
											border-radius: 12px;
											height: 40px;
											width: 70%;
											display: flex;
											align-items: center;
											justify-content: center;
										"
									>
										면접방 생성하기
									</button>
								</template>
								<v-card class="font-LINE-Rg" style="padding: 20px">
									<v-card-title
										class="font-LINE-Bd"
										style="
											display: flex;
											justify-content: flex-start;
											font-size: 28px;
										"
									>
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
										<div class="review-write-btns font-LINE-Rg">
											<button
												id="create-room-bt"
												class="btnLightBlue btnPush"
												@click="createRoom"
											>
												등록하기
											</button>
											<button
												id="exit-room-bt"
												class="btnOrange btnPush"
												@click="modalInfo.dialog = false"
											>
												나가기
											</button>
										</div>
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
				modalInfo.dialog = false;
				console.log(res);
				const conferenceId = res.data.message;
				createChatRoom(conferenceId);
				router.push({
					name: 'recruitResume',
				});
			});
		};
		const createChatRoom = roomNumber => {
			const config = {
				roomNumber: roomNumber,
				title: interviewInfo.title,
			};
			axios({
				method: 'POST',
				url: url + '/api/chat/room',
				headers: {
					Authorization: localStorage.getItem('jjob.s.token'),
				},
				data: config,
			}).then(res => {
				console.log(res.data);
			});
		};
		return {
			store,
			modalInfo,
			interviewInfo,
			getApplyResumeList,
			showDetailResume,
			createRoom,
			createChatRoom,
		};
	},
};
</script>

<style scoped>
.interview-date-box {
	display: flex;
}
.v-card-actions {
	align-items: center;
	display: flex;
	min-height: 60px;
	padding: 0.5rem;
	justify-content: flex-end;
}
.review-write-btns {
	display: flex;
	justify-content: end;
}
.review-write-btns > button,
.review-write-btns > button + button {
	width: 100px;
	margin: 0px 2px;
	padding: 4px 0px;
}
</style>
