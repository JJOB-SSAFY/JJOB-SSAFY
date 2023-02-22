<template>
	<div id="main-container" class="font-LINE-Bd" style="overflow: hidden">
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
				<div class="form-group font-LINE-Bd">
					<p>
						<label style="font-size: 32px; margin: 20px 0">면접 이름</label>
						<input
							x
							v-model="title"
							class="form-control font-LINE-Rg"
							type="text"
							required
							readonly
							style="font-size: 18px; margin-bottom: 20px"
						/>
					</p>
					<p>
						<label style="font-size: 32px; margin: 20px 0">이름</label>
						<input
							v-model="myUserName"
							class="form-control font-LINE-Rg"
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
							readonly
						/>
					</p>
				</div>
			</div>
			<div class="openvidu-join-footer font-LINE-Rg">
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
					<div class="middle-container">
						<div class="left-container">
							<div
								id="flex-container"
								class="mt-170 w-100"
								style="display: flex"
							>
								<div
									id="main-video"
									class="col-md-6"
									style="margin-right: 12px"
								>
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
						<div class="right-container">
							<div class="room">
								<h5>{{ title }}</h5>
								<hr />
								<div v-for="(m, idx) in msg" :key="idx">
									<div v-bind:class="m.style">
										<h5 style="margin: 3px">
											{{ m.senderName }}
										</h5>
										{{ m.content }}
									</div>
								</div>
								<hr />
								<input
									type="text"
									v-model="content"
									placeholder="보낼 메세지"
									size="100"
								/>
								<button @click="sendMessage()">SEND</button>
							</div>
						</div>
					</div>
				</div>
				<div class="openvidu-room-footer">
					<button
						type="button"
						class="leave-session-btn btnLightBlue btnPush font-LINE-Rg"
						@click="dialog = true"
					>
						나가기
					</button>
				</div>
			</div>
		</div>

		<v-dialog v-model="dialog" width="40%"
			><v-card style="border-radius: 10px; padding: 10px">
				<v-card-title
					class="font-LINE-Bd"
					style="
						border-bottom: 1px solid black;
						margin: 0px 15px;
						font-size: 24px;
						text-align: center;
					"
				>
					리뷰를 작성해주세요!
				</v-card-title>
				<v-card-text
					class="font-LINE-Rg"
					style="font-size: 16px; text-align: center"
				>
					싸피 후배들을 위해 후기를 써주세요. <br />지금 리뷰를 작성하면 500
					마일리지를 받습니다.</v-card-text
				>
				<v-card-actions>
					<div class="review-write-btns font-LINE-Rg">
						<button id="goto-review-bt" @click="goToReviewView">
							리뷰쓰기
						</button>
						<button id="interview-out-bt" @click="goToInterviewView">
							나가기
						</button>
					</div>
				</v-card-actions>
			</v-card>
		</v-dialog>
	</div>
</template>

<script>
import { OpenVidu } from 'openvidu-browser';
import axios from 'axios';
import UserVideo from './components/UserVideo.vue';
import { url } from '../../../api/http';
import Swal from 'sweetalert2';
import Stomp from 'webstomp-client';
import SockJS from 'sockjs-client/dist/sockjs';
axios.defaults.headers.post['Content-Type'] = 'application/json';
const APPLICATION_SERVER_URL = url;
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
			// chatting
			content: '',
			idx: 0,
			email: '',
			msg: [],
		};
	},
	created() {
		const userInfo = this.$store.getters['auth/getUserInfo'];
		this.email = userInfo.email;
		// 채팅방 내용 불러오기
		// axios({
		// 	method: 'get',
		// 	url: '/api/chat/room/message/' + this.mySessionId + "?page=" + this.idx,
		// 	baseURL: 'http://localhost:8080/'
		// }).then(res => {
		// 	this.msg = []
		// 	for (let i = res.data.length - 1; i > -1; i--) {
		// 		let m = {
		// 			'senderName': res.data[i].senderName,
		// 			'content': res.data[i].content,
		// 			'style': res.data[i].senderEmail == this.id ? 'myMsg' : 'otherMsg'
		// 		}
		// 		this.msg.push(m)
		// 	}
		// }, err => {
		// 	console.log(err)
		// 	alert("error : 새로고침하세요")
		// })
		// socket 연결
		let socket = new SockJS('http://localhost:8080/ws');
		this.stompClient = Stomp.over(socket);
		this.stompClient.connect(
			{},
			frame => {
				console.log('success', frame);
				this.stompClient.subscribe('/sub/' + this.mySessionId, res => {
					let jsonBody = JSON.parse(res.body);
					let m = {
						senderName: jsonBody.senderName,
						content: jsonBody.content,
						style: jsonBody.senderEmail == this.email ? 'myMsg' : 'otherMsg',
					};
					this.msg.push(m);
				});
			},
			err => {
				console.log('fail', err);
			},
		);
	},
	methods: {
		sendMessage() {
			if (this.content.trim() != '' && this.stompClient != null) {
				let chatMessage = {
					content: this.content,
					senderEmail: this.email,
					senderName: this.myUserName,
					roomNumber: this.mySessionId,
				};
				this.stompClient.send('/pub/message', JSON.stringify(chatMessage), {});
				this.content = '';
			}
		},
		joinSession() {
			if (this.subscribers.length >= 5) {
				Swal.fire({
					title: 'OOPS!',
					text: '입장 가능한 인원이 초과되었습니다.',
					icon: 'warning',
				});
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
.myMsg {
	text-align: right;
	color: gray;
}
.otherMsg {
	text-align: left;
}
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
}
.middle-container {
	display: flex;
	width: 100%;
}
.left-container {
	width: 80%;
}
.right-container {
	width: 20%;
	padding-top: 200px;
}
.openvidu-room-footer {
	position: fixed;
	width: 100%;
	height: 100px;
	bottom: 0;
	right: 0;
	display: flex;
	justify-content: right;
	align-items: center;
	background-color: #c3c3c349;
}
.openvidu-room-container {
	display: flex;
}
.leave-session-btn {
	width: 150px;
	height: 50px;
	font-size: 24px;
	color: white;
	font-weight: bold;
	border-radius: 5px;
	margin-right: 50px;
}
.v-card {
	width: 500px;
}
.v-card-actions {
	display: flex;
	justify-content: center;
}
.review-write-btns {
	display: flex;
}
#goto-review-bt {
	margin-right: 2px;
	padding: 3px 0px;
	width: 100px;
	border-radius: 12px;
	background: var(--primary-color-1);
	box-shadow: 0px 4px 0px 0px #1487c9;
}
#interview-out-bt {
	margin-left: 2px;
	padding: 3px 0px;
	width: 70px;
	border-radius: 12px;
	background: #fc7e7e;
	box-shadow: 0px 4px 0px 0px #a66615;
}
#goto-review-bt:hover {
	margin-top: 6px;
	margin-bottom: -3px;
	box-shadow: 0px 2px 0px 0px #1487c9;
}
#interview-out-bt:hover {
	margin-top: 5px;
	margin-bottom: -3px;
	box-shadow: 0px 2px 0px 0px #a66615;
}
</style>
