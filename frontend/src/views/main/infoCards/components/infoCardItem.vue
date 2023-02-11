<template>
	<div class="infoCards">
		<div class="cover-backgroud"></div>
		<div class="mycard-container">
			<div class="div-profile font-LINE-Bd">
				<div class="img-container">
					<img class="profile-img" :src="info.imageUrl" />
				</div>
				<p class="profile-name">{{ info.name }}</p>
			</div>
			<div class="div-info-first font-LINE-Rg">
				<div class="first-detail info-phone">
					<p class="info-title">휴대폰</p>
					<div class="info-content">{{ info.phone }}</div>
				</div>
				<div class="first-detail info-email">
					<p class="info-title">이메일</p>
					<div class="info-content line-clamp">{{ info.email }}</div>
				</div>
				<div class="first-detail info-github">
					<p class="info-title">Github</p>
					<div class="info-content line-clamp">{{ info.github }}</div>
				</div>
				<div class="first-detail info-blog">
					<p class="info-title">Blog</p>
					<div class="info-content line-clamp">{{ info.blog }}</div>
				</div>
			</div>

			<div class="div-info-second font-LINE-Rg">
				<div class="second-detail info-skill">
					<p class="info-title">Skills</p>
					<div class="info-content line-clamp">{{ info.skills }}</div>
				</div>

				<div class="second-detail info-preferredJob">
					<p class="info-title">선호 직무</p>
					<div class="info-content line-clamp">
						{{ info.preferredJob }}
					</div>
				</div>

				<div class="second-detail info-introduce">
					<p class="info-title">한줄 자기소개</p>
					<div class="line-clamp-introduce">
						{{ info.introduce }}
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	props: {
		info: String,
	},
	setup() {
		return {};
	},
};
</script>

<style scoped>
.card-info-title {
	background-color: red;
}
.card-info-content {
	background-color: blue;
}
</style>
