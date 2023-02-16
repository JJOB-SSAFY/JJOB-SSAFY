<template>
	<div class="div-myinfo-update">
		<div class="myinfo-update-container">
			<div class="myinfo-section">
				<div class="div-myinfo-update-top font-LINE-Rg">
					<div class="div-myinfo-update-left font-LINE-Rg">
						<div class="div-item-left info-phone">
							<p class="info-title font-LINE-Bd">휴대폰</p>
							<input v-model="myInfo.state.phone" class="info-content" />
						</div>
						<div class="div-item-left info-email">
							<p class="info-title font-LINE-Bd">이메일</p>
							<input
								disabled
								v-model="myInfo.state.email"
								class="info-content"
							/>
						</div>
						<div class="div-item-left info-github">
							<p class="info-title font-LINE-Bd">Github</p>
							<input v-model="myInfo.state.github" class="info-content" />
						</div>
						<div class="div-item-left info-blog">
							<p class="info-title font-LINE-Bd">Blog</p>
							<input v-model="myInfo.state.blog" class="info-content" />
						</div>
					</div>

					<div class="div-myinfo-update-right font-LINE-Rg">
						<div class="div-item-right info-skill">
							<p class="info-title font-LINE-Bd">Skills</p>
							<input v-model="myInfo.state.skills" class="info-content" />
						</div>

						<div class="div-item-right info-preferredJob">
							<p class="info-title font-LINE-Bd">선호 직무</p>
							<input v-model="myInfo.state.preferredJob" class="info-content" />
						</div>

						<div class="div-item-right info-introduce">
							<p class="info-title font-LINE-Bd">한줄 자기소개</p>
							<textarea
								v-model="myInfo.state.introduce"
								class="line-clamp-introduce"
							/>
						</div>
						<div class="div-item-right">
							<p class="info-title font-LINE-Bd">이미지 선택</p>
							<input
								type="file"
								ref="file"
								placeholder="사진"
								@change="imgUpload"
								class="info-content-img"
							/>
						</div>
					</div>
				</div>
				<div class="div-myinfo-update-bottom font-LINE-Rg">
					<div class="info-visible">
						<span for="checkBox">
							기업에 내 정보를 보여주실건가요?
							<input
								class="input-checkbox"
								type="checkbox"
								v-model="myInfo.state.visible"
								id="checkBox"
							/>
						</span>
					</div>

					<button
						id="update-myinfo"
						class="font-LINE-Rg btnFade btnBlueGreen btnLightBlue"
						@click="updateCard"
					>
						정보변경
					</button>
				</div>
			</div>
			<div class="password-section">
				<div class="div-password-top font-LINE-Rg">
					<div class="div-password-update font-LINE-Rg">
						<div>
							<div class="p-div-item">
								<p class="p-info-title font-LINE-Bd font-LINE-Bd">
									현재 비밀번호
								</p>
								<input
									type="password"
									v-model="password.current"
									class="p-info-content"
								/>
							</div>
							<div class="p-div-item">
								<p class="p-info-title font-LINE-Bd font-LINE-Bd">
									변경할 비밀번호
								</p>
								<input
									type="password"
									v-model="password.change"
									class="p-info-content"
								/>
							</div>
							<div class="p-div-item">
								<p class="p-info-title font-LINE-Bd font-LINE-Bd">
									변경할 비밀번호 확인
								</p>
								<input
									type="password"
									v-model="password.changeCk"
									class="p-info-content"
								/>
							</div>
						</div>
					</div>
				</div>
				<div class="div-password-bottom">
					<button
						id="update-myinfo-password"
						class="font-LINE-Rg btnFade btnBlueGreen btnLightBlue"
						@click="changePwd"
					>
						비밀번호변경
					</button>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { ref, reactive, toRaw } from 'vue';
import { useStore } from 'vuex';
import MyinfoService from '../../../api/myinfoService';
import { ref as fref, uploadBytes, getDownloadURL } from 'firebase/storage';
import { storage } from '../../../api/firebase';
import Swal from 'sweetalert2';

export default {
	setup() {
		const test = ref(true);
		const myinfoService = new MyinfoService();
		const store = useStore();
		const visible = ref(true);
		const image = ref(null);
		const imgUpload = async e => {
			console.log(e.target.files);
			const uploaded_file = await uploadBytes(
				fref(storage, `images/${e.target.files[0].name}`),
				e.target.files[0],
			);
			console.log(uploaded_file);
			const file_url = await getDownloadURL(uploaded_file.ref);
			console.log(file_url);
			image.value = file_url;
			myInfo.state.imgUrl = file_url;
		};
		const password = reactive({
			current: '',
			change: '',
			changeCk: '',
		});
		const myInfo = reactive({
			state: {},
		});
		const getMyInfo = store.getters['auth/getUserInfo'];
		myInfo.state = toRaw(getMyInfo);

		const updateCard = () => {
			const param = {
				blog: myInfo.state.blog,
				skills: myInfo.state.skills,
				phone: myInfo.state.phone,
				github: myInfo.state.github,
				preferredJob: myInfo.state.preferredJob,
				introduce: myInfo.state.introduce,
				imageUrl: myInfo.state.imgUrl,
				visible: myInfo.state.visible,
			};
			myinfoService
				.updateCard(param)
				.then(() => {
					Swal.fire({
						title: 'WOW!',
						text: '정보변경 성공!',
						icon: 'success',
					});
					store.commit('auth/SET_USER_INFO', myInfo.state);
				})
				.catch(err => console.log(err));
		};

		const changePwd = () => {
			if (
				password.current == '' ||
				password.current == null ||
				password.changeCk == null ||
				password.changeCk == '' ||
				password.change == '' ||
				password.change == null
			) {
				Swal.fire({
					title: 'OOPS!',
					text: '모든 정보를 입력해주세요.',
					icon: 'warning',
				});
				return;
			}
			if (password.change != password.changeCk) {
				Swal.fire({
					title: 'OOPS!',
					text: '비밀번호를 다시 확인해주세요.',
					icon: 'warning',
				});
				return;
			}
			const resPwd = {
				current: password.current,
				change: password.change,
			};

			myinfoService
				.changePwd(resPwd)
				.then(data => {
					if (data.data.message == 'Fail') {
						Swal.fire({
							title: 'OOPS!',
							text: '비밀번호를 다시 확인해주세요.',
							icon: 'warning',
						});
					} else if (data.data.message == 'Success') {
						Swal.fire({
							title: 'WOW!',
							text: '비밀번호 변경 성공',
							icon: 'success',
						});
						password.current = '';
						password.change = '';
						password.changeCk = '';
					}
				})
				.catch(console.log('err'));
		};

		return {
			myInfo,
			password,
			visible,
			updateCard,
			imgUpload,
			changePwd,
			test,
		};
	},
};
</script>
z
