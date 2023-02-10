<template>
	<div>
		<div>
			<div>
				<div>
					<img :src="info.imageUrl" />
				</div>
				<p>{{ info.name }}</p>
			</div>
			<div>
				<div>
					<p>휴대폰</p>
					<p>{{ info.phone }}</p>
				</div>
				<div>
					<p>이메일</p>
					<p>{{ info.email }}</p>
				</div>
				<div>
					<p>Github</p>
					<p>{{ info.github }}</p>
				</div>
				<div>
					<p>Blog</p>
					<p>{{ info.blog }}</p>
				</div>
			</div>

			<div>
				<div>
					<p>Skills</p>
					<p>{{ info.skills }}</p>
				</div>

				<div>
					<p>선호 직무</p>
					<p>{{ info.preferredJob }}</p>
				</div>

				<div>
					<p>한줄 자기소개</p>
					<div>
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
