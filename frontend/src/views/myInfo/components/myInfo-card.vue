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
			<div class="div-info-first font-LINE-Rg">
				<div class="first-detail info-phone">
					<p class="info-title">휴대폰</p>
					<div class="info-content">{{ myInfo.state.phone }}</div>
				</div>
				<div class="first-detail info-email">
					<p class="info-title">이메일</p>
					<div class="info-content line-clamp">{{ myInfo.state.email }}</div>
				</div>
				<div class="first-detail info-github">
					<p class="info-title">Github</p>
					<div class="info-content line-clamp">{{ myInfo.state.github }}</div>
				</div>
				<div class="first-detail info-blog">
					<p class="info-title">Blog</p>
					<div class="info-content line-clamp">{{ myInfo.state.blog }}</div>
				</div>
			</div>

			<div class="div-info-second font-LINE-Rg">
				<div class="second-detail info-skill">
					<p class="info-title">Skills</p>
					<div class="info-content line-clamp">{{ myInfo.state.skills }}</div>
				</div>

				<div class="second-detail info-preferredJob">
					<p class="info-title">선호 직무</p>
					<div class="info-content line-clamp">
						{{ myInfo.state.preferredJob }}
					</div>
				</div>

				<div class="second-detail info-introduce">
					<p class="info-title">한줄 자기소개</p>
					<div class="line-clamp-introduce">
						{{ myInfo.state.introduce }}
					</div>
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
