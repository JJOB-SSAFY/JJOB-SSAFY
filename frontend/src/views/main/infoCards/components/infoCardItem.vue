<template>
	<div class="div-mycard">
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
					<p class="info-content">{{ info.phone }}</p>
				</div>
				<div class="first-detail info-email">
					<p class="info-title">이메일</p>
					<p class="info-content">{{ info.email }}</p>
				</div>
				<div class="first-detail info-github">
					<p class="info-title">Github</p>
					<p class="info-content">{{ info.github }}</p>
				</div>
				<div class="first-detail info-blog">
					<p class="info-title">Blog</p>
					<p class="info-content">{{ info.blog }}</p>
				</div>
			</div>

			<div class="div-info-second font-LINE-Rg">
				<div class="second-detail info-skill">
					<p class="info-title">Skills</p>
					<p class="info-content">{{ info.skills }}</p>
				</div>

				<div class="second-detail info-preferredJob">
					<p class="info-title">선호 직무</p>
					<p class="info-content">{{ info.preferredJob }}</p>
				</div>

				<div class="second-detail info-introduce">
					<p class="info-title">한줄 자기소개</p>
					<div class="line-clamp">
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
.div-profile .profile-name {
	text-align: center;
	font-size: 20px;
}
.div-info-first .info-title,
.div-info-second .info-title {
	color: var(--primary-color-1);
	font-size: 10px;
	font-family: LINE-Bd;
}
.div-profile .img-container {
	background-color: white;
	width: 200px;
	height: 200px;
	border-radius: 25% 35% / 35% 40%;
}
</style>
