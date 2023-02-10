<template>
	<div class="div-myinfo-update">
		<div class="myinfo-update-container">
			<div class="div-block">
				<div class="div-myinfo-update-first font-LINE-Rg">
					<div class="div-myinfo-update-left font-LINE-Rg">
						<div class="first-detail info-phone">
							<p class="info-title">휴대폰</p>
							<input v-model="myInfo.state.phone" class="info-content" />
						</div>
						<div class="first-detail info-email">
							<p class="info-title">이메일</p>
							<p class="info-content">{{ myInfo.state.email }}</p>
						</div>
						<div class="first-detail info-github">
							<p class="info-title">Github</p>
							<input v-model="myInfo.state.github" class="info-content" />
						</div>
						<div class="first-detail info-blog">
							<p class="info-title">Blog</p>
							<input v-model="myInfo.state.blog" class="info-content" />
						</div>
					</div>

					<div class="div-myinfo-update-right font-LINE-Rg">
						<div class="second-detail info-skill">
							<p class="info-title">Skills</p>
							<input v-model="myInfo.state.skills" class="info-content" />
						</div>

						<div class="second-detail info-preferredJob">
							<p class="info-title">선호 직무</p>
							<input v-model="myInfo.state.preferredJob" class="info-content" />
						</div>

						<div class="second-detail info-introduce">
							<p class="info-title">한줄 자기소개</p>
							<input
								v-model="myInfo.state.introduce"
								class="line-clamp-introduce"
							/>
						</div>
						<div class="info-image">
							<p class="info-title">이미지 선택</p>
							<input
								type="file"
								ref="file"
								placeholder="사진"
								@change="imgUpload"
							/>
						</div>
					</div>
				</div>
				<div class="div-info-modify">
					<div class="info-visible">
						<span for="checkBox">
							지원자 정보에 카드를 보여주실건가요?
							<input
								class="input-checkbox"
								type="checkbox"
								v-model="visible"
								true-value="1"
								false-value="0"
								id="checkBox"
							/>
						</span>
					</div>

					<b-button @Click="updateCard">정보변경</b-button>
				</div>
			</div>
			<div class="temp1">
				<div class="div-myinfo-update-second font-LINE-Rg">
					<div class="temp-1">
						<div class="div-myinfo-update-password font-LINE-Rg">
							<div>
								<div class="first-detail">
									<p class="info-title">현재 비밀번호</p>
									<input
										type="password"
										v-model="password.current"
										class="info-content"
									/>
								</div>
								<div class="first-detail">
									<p class="info-title">변경할 비밀번호</p>
									<input
										type="password"
										v-model="password.change"
										class="info-content"
									/>
								</div>
								<div class="first-detail">
									<p class="info-title">변경할 비밀번호 확인</p>
									<input
										type="password"
										v-model="password.changeCk"
										class="info-content"
									/>
								</div>
							</div>
						</div>
					</div>
					<div>
						<button @Click="changePwd">비밀번호변경</button>
					</div>
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
export default {
	setup() {
		const myinfoService = new MyinfoService();
		const store = useStore();
		const visible = ref(0);
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
				visible: parseInt(visible.value),
			};
			myinfoService
				.updateCard(param)
				.then(alert('정보 변경 성공'))
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
				alert('모든 정보를 입력해 주세요!!');
				return;
			}
			if (password.change != password.changeCk) {
				alert('비밀번호를 다시 확인해 주세요');
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
						alert('비밀번호를 다시 확인해주세요');
					} else if (data.data.message == 'Success') {
						alert('비밀번호 변경 성공');
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
		};
	},
};
</script>
