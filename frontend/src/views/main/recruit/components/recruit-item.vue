<template>
	<router-link to="recruit/detail">
		<a href="#">
			<div class="card">
				<h5 class="card-header">회사이름{{ info.recruitTitle }}</h5>
				<div class="card-body">
					<!-- {{ info }} -->
					<h5 class="card-title">채용직무{{ info.department }}</h5>
					<p class="card-text">요구사항{{ info.requirement }}</p>
					<p class="card-text">업무{{ info.workType }}</p>
					<p class="card-text">경력사항{{ info.work }}</p>
					<p class="card-text">지원 마감일{{ info.recruitEndDate }}</p>
					<a href="#" class="btn btn-primary">지원하기 버튼</a>
				</div>
			</div>
		</a>
	</router-link>
</template>

<script>
export default {
	name: 'recruitItemView',
	props: {
		info: Object,
	},
	setup() {
		return {};
	},
};
</script>

<style></style>
