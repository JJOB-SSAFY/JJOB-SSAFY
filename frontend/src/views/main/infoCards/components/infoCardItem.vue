<!-- eslint-disable vue/no-parsing-error -->
<template>
	<div class="infoCards">
		<div class="infoCards-container">
			<div class="info-front font-LINE-Rg">
				<div class="div-info-profile font-LINE-Bd">
					<div class="img-container">
						<img class="profile-img" :src="info.imageUrl" />
					</div>
					<p class="profile-name">{{ info.name }}</p>
				</div>
				<div class="div-front font-LINE-Rg">
					<div class="front-item info-skill">
						<img src="@/assets/images/icon/skill.png" width="19" height="19" />
						<p>&nbsp {{ info.skills }}</p>
					</div>

					<div class="front-item info-preferredJob">
						<img src="@/assets/images/icon/job.png" width="19" height="19" />
						<p>&nbsp {{ info.preferredJob }}</p>
					</div>
					<div class="front-item info-introduce">
						<fa-icon icon="fas fa-solid fa-star" />
						<p>&nbsp&nbsp {{ info.introduce }}</p>
					</div>
				</div>
			</div>
			<div class="info-back font-LINE-Rg">
				<div class="div-back">
					<div class="back-item info-phone">
						<fa-icon icon="fas fa-solid fa-phone" />
						&nbsp
						<p v-if="role === 'USER'">미공개정보입니다</p>
						<p v-else>{{ info.phone }}</p>
					</div>
					<div class="back-item info-email">
						<fa-icon icon="fas fa-solid fa-envelope" />
						&nbsp
						<p v-if="role === 'USER'">미공개정보입니다</p>
						<p v-else>{{ info.email }}</p>
					</div>
					<div class="back-item info-github">
						<img
							src="@/assets/images/logo/github/github-mark.png"
							width="19"
							height="19"
						/>
						<p>&nbsp {{ info.github }}</p>
					</div>
					<div class="back-item info-blog">
						<img src="@/assets/images/icon/blog.png" width="19" height="19" />
						<p>&nbsp {{ info.blog }}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { useStore } from 'vuex';
export default {
	props: {
		info: String,
	},
	setup() {
		const store = useStore();

		const role = store.getters['auth/getUserRole'];

		return { role };
	},
};
</script>

<style scoped></style>
