<template>
	<a href="#">
		<div class="card">
			<h5 class="card-header">이름 {{ info.name }}</h5>
			<div class="card-body">
				<img :src="info.imageUrl" />
				<h5 class="card-title">휴대폰</h5>
				<p class="card-text">{{ info.phone }}</p>
				<h5 class="card-title">이메일</h5>
				<p class="card-text">{{ info.email }}</p>
				<h5 class="card-title">Github</h5>
				<p class="card-text">{{ info.github }}</p>
				<h5 class="card-title">블로그</h5>
				<p class="card-text">{{ info.blog }}</p>
				<h5 class="card-title">기술 스택</h5>
				<p class="card-text">{{ info.skills }}</p>
				<h5 class="card-title">선호 직무</h5>
				<p class="card-text">{{ info.preferredJob }}</p>
				<h5 class="card-title">한줄 자기소개</h5>
				<p class="card-text">{{ info.introduce }}</p>
			</div>
		</div>
	</a>
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
.card-text {
	color: black;
}
</style>
