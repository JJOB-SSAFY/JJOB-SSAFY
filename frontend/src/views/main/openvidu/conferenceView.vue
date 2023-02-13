<template>
	<div id="main-container" class="container" style="overflow: hidden">
		<div id="join" v-if="!session" class="openvidu-join-form">
			<div class="mb-60 openvidu-join-header">
				<div class="d-flex align-items-center" style="margin-left: 7%">
					<router-link to="/main">
						<img
							src="@/assets/images/logo/logo-removebg.png"
							alt=""
							height="91"
							width="132"
							class="mt-50"
						/>
					</router-link>
					<h1 class="font-LINE-Bd mt-100 mb-40">정보 확인</h1>
				</div>
				<hr />
			</div>
			<div id="join-dialog" class="jumbotron vertical-center mt-250">
				<div class="form-group">
					<p>
						<label style="font-size: 32px; margin: 20px 0">방 이름</label>
						<input
							v-model="title"
							class="form-control"
							type="text"
							required
							style="font-size: 18px; margin-bottom: 20px"
						/>
					</p>
					<p>
						<label style="font-size: 32px; margin: 20px 0">이름</label>
						<input
							v-model="myUserName"
							class="form-control"
							type="text"
							required
							style="font-size: 18px"
						/>
					</p>
					<p hidden>
						<label>방 번호</label>
						<input
							v-model="mySessionId"
							class="form-control"
							type="text"
							required
						/>
					</p>
				</div>
			</div>
			<div class="openvidu-join-footer">
				<p class="text-center mt-40 d-flex justify-content-end">
					<button class="btn btn-lg btn-primary me-3" @click="joinSession()">
						입장하기
					</button>
					<button
						class="btn btn-lg btn-secondary"
						@click="backToInterviewView()"
					>
						돌아가기
					</button>
				</p>
			</div>
		</div>

		<div class="mt-50">
			<div id="session" v-if="session">
				<div class="openvidu-room-container">
					<div id="session-header" class="mb-30">
						<div class="openvidu-room-header">
							<img
								src="@/assets/images/logo/logo-removebg.png"
								alt=""
								height="91"
								width="132"
							/>
							<h1 id="session-title">{{ title }}</h1>
						</div>
					</div>
					<div id="flex-container" class="mt-170" style="display: flex">
						<div id="main-video" class="col-md-6" style="margin-right: 12px">
							<user-video :stream-manager="mainStreamManager" />
						</div>
						<div id="video-container" class="row">
							<user-video
								v-for="sub in subscribers"
								:key="sub.stream.connection.connectionId"
								:stream-manager="sub"
								@click="updateMainVideoStreamManager(sub)"
								class="col-6"
							/>
						</div>
					</div>
				</div>
				<div class="openvidu-room-footer">
					<button
						type="button"
						class="leave-session-btn"
						@click="dialog = true"
					>
						나가기
					</button>
				</div>
			</div>
		</div>

		<v-dialog v-model="dialog" width="auto"
			><v-card style="border-radius: 10px">
				<v-card-title
					class="text-h5"
					style="background-color: red; padding-left: 50px"
				>
					리뷰작성해주세요
				</v-card-title>
				<v-card-text>
					싸피 후배들을 위해 후기를 써주세요. <br />지금 리뷰를 작성하면 500
					마일리지를 받습니다.</v-card-text
				>
				>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn
						color="green-darken-1"
						variant="text"
						@click="goToInterviewView"
					>
						싫어
					</v-btn>
					<v-btn color="green-darken-1" variant="text" @click="goToReviewView">
						좋아
					</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>
		<!-- Modal -->
		<!-- <div
			class="modal fade"
			id="exampleModal"
			tabindex="-1"
			aria-labelledby="exampleModalLabel"
			aria-hidden="true"
		>
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">리뷰쓰기</h5>
						<button
							type="button"
							class="btn-close"
							data-bs-dismiss="modal"
							aria-label="Close"
						></button>
					</div>
					<div class="modal-body">
						싸피 후배들을 위해 후기를 써주세요. 지금 리뷰를 작성하면 500
						마일리지를 받습니다.
					</div>
					<div class="modal-footer">
						<button
							type="button"
							class="btn btn-primary"
							data-bs-dismiss="modal"
							@click="goToReviewView"
						>
							리뷰쓰기
						</button>
						<button
							type="button"
							class="btn btn-secondary"
							data-bs-dismiss="modal"
							@click="goToInterviewView"
						>
							나가기
						</button>
					</div>
				</div>
			</div>
		</div> -->
	</div>
</template>

<script>
import { OpenVidu } from 'openvidu-browser';
import axios from 'axios';
import UserVideo from './components/UserVideo.vue';
import { useRouter } from 'vue-router';
import { url } from '../../../api/http';
import { ref } from 'vue';
axios.defaults.headers.post['Content-Type'] = 'application/json';

const APPLICATION_SERVER_URL = url;

const router = useRouter();

export default {
	name: 'conferenceView',

	components: {
		UserVideo,
	},

	data() {
		return {
			//Modal
			dialog: false,
			// OpenVidu objects
			OV: undefined,
			session: undefined,
			mainStreamManager: undefined,
			publisher: undefined,
			subscribers: [],

			// Join form
			title: this.$route.params.title,
			mySessionId: this.$route.params.session,
			myUserName: this.$route.params.participant,
			companyId: this.$route.params.companyId,
			companyName: this.$route.params.companyName,
		};
	},

	methods: {
		joinSession() {
			if (this.subscribers.length >= 5) {
				alert('입장 가능한 인원이 초과되었습니다.');
				return;
			}

			// --- 1) Get an OpenVidu object ---
			this.OV = new OpenVidu();

			// --- 2) Init a session ---
			this.session = this.OV.initSession();

			// --- 3) Specify the actions when events take place in the session ---

			// On every new Stream received...
			this.session.on('streamCreated', ({ stream }) => {
				const subscriber = this.session.subscribe(stream);
				this.subscribers.push(subscriber);
			});

			// On every Stream destroyed...
			this.session.on('streamDestroyed', ({ stream }) => {
				const index = this.subscribers.indexOf(stream.streamManager, 0);
				if (index >= 0) {
					this.subscribers.splice(index, 1);
				}
			});

			// On every asynchronous exception...
			this.session.on('exception', ({ exception }) => {
				console.warn(exception);
			});

			// --- 4) Connect to the session with a valid user token ---

			// Get a token from the OpenVidu deployment
			this.getToken(this.mySessionId).then(token => {
				// First param is the token. Second param can be retrieved by every user on event
				// 'streamCreated' (property Stream.connection.data), and will be appended to DOM as the user's nickname
				this.session
					.connect(token, { clientData: this.myUserName })
					.then(() => {
						// --- 5) Get your own camera stream with the desired properties ---

						// Init a publisher passing undefined as targetElement (we don't want OpenVidu to insert a video
						// element: we will manage it on our own) and with the desired properties
						let publisher = this.OV.initPublisher(undefined, {
							audioSource: undefined, // The source of audio. If undefined default microphone
							videoSource: undefined, // The source of video. If undefined default webcam
							publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
							publishVideo: true, // Whether you want to start publishing with your video enabled or not
							resolution: '640x480', // The resolution of your video
							frameRate: 30, // The frame rate of your video
							insertMode: 'APPEND', // How the video is inserted in the target element 'video-container'
							mirror: false, // Whether to mirror your local video or not
						});

						// Set the main video in the page to display our webcam and store our Publisher
						this.mainStreamManager = publisher;
						this.publisher = publisher;

						// --- 6) Publish your stream ---

						this.session.publish(this.publisher);
					})
					.catch(error => {
						console.log(
							'There was an error connecting to the session:',
							error.code,
							error.message,
						);
					});
			});

			window.addEventListener('beforeunload', this.leaveSession);
		},

		leaveSession() {
			// --- 7) Leave the session by calling 'disconnect' method over the Session object ---
			if (this.session) this.session.disconnect();

			// Empty all properties...
			this.session = undefined;
			this.mainStreamManager = undefined;
			this.publisher = undefined;
			this.subscribers = [];
			this.OV = undefined;

			// Remove beforeunload listener
			window.removeEventListener('beforeunload', this.leaveSession);
		},

		updateMainVideoStreamManager(stream) {
			if (this.mainStreamManager === stream) return;
			this.mainStreamManager = stream;
		},

		goToReviewView() {
			this.leaveSession();
			this.$router.push({
				name: 'reviewWrite',
				params: {
					companyId: this.companyId,
					companyName: this.companyName,
				},
			});
		},

		goToInterviewView() {
			this.leaveSession();
			this.$router.push({
				name: 'interview',
			});
		},

		backToInterviewView() {
			this.$router.push({
				name: 'interview',
			});
		},

		/**
		 * --------------------------------------------
		 * GETTING A TOKEN FROM YOUR APPLICATION SERVER
		 * --------------------------------------------
		 * The methods below request the creation of a Session and a Token to
		 * your application server. This keeps your OpenVidu deployment secure.
		 *
		 * In this sample code, there is no user control at all. Anybody could
		 * access your application server endpoints! In a real production
		 * environment, your application server must identify the user to allow
		 * access to the endpoints.
		 *
		 * Visit https://docs.openvidu.io/en/stable/application-server to learn
		 * more about the integration of OpenVidu in your application server.
		 */
		async getToken(mySessionId) {
			const sessionId = await this.createSession(mySessionId);
			return await this.createToken(sessionId);
		},

		async createSession(sessionId) {
			const response = await axios.post(
				APPLICATION_SERVER_URL + '/api/sessions',
				{ customSessionId: sessionId },
				{
					headers: { 'Content-Type': 'application/json' },
				},
			);
			return response.data; // The sessionId
		},

		async createToken(sessionId) {
			const response = await axios.post(
				APPLICATION_SERVER_URL + '/api/sessions/' + sessionId + '/connections',
				{},
				{
					headers: { 'Content-Type': 'application/json' },
				},
			);
			return response.data; // The token
		},
	},
};
</script>

<style>
.openvidu-join-form {
	width: 80%;
	margin: auto;
}

.openvidu-join-header {
	position: fixed;
	width: 100%;
	top: 0;
	right: 0;
	align-items: center;
	border-top: 1px lightgray solid;
}

.openvidu-join-footer {
	position: fixed;
	width: 100%;
	height: 100px;
	background: white;
	bottom: 0;
	right: 0;
	display: flex;
	justify-content: right;
	align-items: center;
	border-top: 1px lightgray solid;
	padding-right: 130px;
	padding-bottom: 40px;
}

.openvidu-room-header {
	position: fixed;
	width: 100%;
	height: 20%;
	background: white;
	top: 0;
	right: 0;
	display: flex;
	align-items: center;
	border-bottom: 1px lightgray solid;
}

.openvidu-room-footer {
	position: fixed;
	width: 100%;
	height: 80px;
	bottom: 0;
	right: 0;
	display: flex;
	justify-content: right;
	align-items: center;
	border-top: 1px lightgray solid;
	background-color: black;
}

.openvidu-room-container {
	display: flex;
}

.leave-session-btn {
	width: 100px;
	height: 40px;
	background: red;
	color: white;
	font-weight: bold;
	border-radius: 5px;
	margin-right: 130px;
}
</style>
