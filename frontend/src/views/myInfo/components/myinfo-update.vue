<template>
	<div class="div-myinfo-update">
		<div class="myinfo-update-container">
			<div class="div-myinfo-update-first div-myinfo-update-card font-LINE-Rg">
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

				<div class="div-myinfo-update-right pt-20 font-LINE-Rg">
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
						<input v-model="myInfo.state.introduce" class="info-content" />
					</div>
					<div class="second-detail info-visible">
						<p class="info-title">한줄 자기소개</p>
						<input v-model="myInfo.state.introduce" class="info-content" />
					</div>
					<label for="checkBox"
						><input
							class="input-checkbox"
							type="checkbox"
							v-model="visible"
							true-value="1"
							false-value="0"
							id="checkBox"
						/>카드 보여줄건지?</label
					>
					<b-button @Clic="updateCard">정보변경</b-button>
				</div>
			</div>
			<div class="div-myinfo-update-second div-myinfo-update-card font-LINE-Rg">
				<div class="div-myinfo-update-password font-LINE-Rg">
					<div class="first-detail info-phone">
						<p class="info-title">현재 비밀번호</p>
						<input
							type="password"
							v-model="password.current"
							class="info-content"
						/>
					</div>
					<div class="first-detail info-phone">
						<p class="info-title">변경할 비밀번호</p>
						<input v-model="myInfo.state.phone" class="info-content" />
					</div>
					<div class="first-detail info-phone">
						<p class="info-title">변경할 비밀번호 확인</p>
						<input v-model="myInfo.state.phone" class="info-content" />
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { ref, reactive, toRaw } from 'vue';
import { useStore } from 'vuex';

export default {
	setup() {
		const store = useStore();
		const visible = ref(false);
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
				imageUrl: myInfo.state.imageUrl,
				visible: visible,
			};
		};
		return { myInfo, password, visible };
	},
};
</script>
