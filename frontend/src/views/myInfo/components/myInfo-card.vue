<template>
	<div class="div-mycard">
		<div class="cover-backgroud"></div>
		<div class="mycard-container">
			<div class="div-profile font-LINE-Bd">
				<div class="img-container">
					<img class="profile-img" :src="myInfo.state.imgUrl" />
				</div>
				<p class="profile-name">{{ myInfo.state.name }}</p>
			</div>
			<div class="div-info-first pt-20 font-LINE-Rg">
				<div class="first-detail info-phone">
					<p class="info-title">휴대폰</p>
					<p class="info-content">{{ myInfo.state.phone }}</p>
				</div>
				<div class="first-detail info-email">
					<p class="info-title">이메일</p>
					<p class="info-content">{{ myInfo.state.email }}</p>
				</div>
				<div class="first-detail info-github">
					<p class="info-title">Github</p>
					<p class="info-content">{{ myInfo.state.github }}</p>
				</div>
				<div class="first-detail info-blog">
					<p class="info-title">Blog</p>
					<p class="info-content">{{ myInfo.state.blog }}</p>
				</div>
			</div>

			<div class="div-info-second pt-20 font-LINE-Rg">
				<div class="second-detail info-skill">
					<p class="info-title">Skills</p>
					<p class="info-content">{{ myInfo.state.skills }}</p>
				</div>

				<div class="second-detail info-preferredJob">
					<p class="info-title">선호 직무</p>
					<p class="info-content">{{ myInfo.state.preferredJob }}</p>
				</div>

				<div class="second-detail info-introduce">
					<p class="info-title">한줄 자기소개</p>
					<p class="info-content">{{ myInfo.state.introduce }}</p>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { watch } from 'vue';
import { reactive, toRaw } from 'vue';
import { useStore } from 'vuex';
export default {
	name: 'myinfoCard',
	setup() {
		const store = useStore();
		const myInfo = reactive({
			state: {},
		});
		const getMyInfo = store.getters['auth/getUserInfo'];

		myInfo.state = toRaw(getMyInfo);

		watch(
			() => store.getters['auth/getUserInfo'],
			function () {
				// getMyInfo = store.getters[]
			},
		);
		return { myInfo };
	},
};
</script>

<style lang="scss" scoped></style>
