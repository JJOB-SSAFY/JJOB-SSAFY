<template>
	<div id="items">
		<div class="card">
			<h5 class="card-header">회사이름 {{ info.recruitTitle }}</h5>
			<div class="leftbox">
				<div class="card-body">
					<h6>경력여부 {{ info.work }}</h6>
				</div>
				<div class="card-body">
					<h5 class="card-title">담당업무 {{ info.department }}</h5>
					<p class="card-text">요구역량 {{ info.requirement }}</p>
				</div>
			</div>
			<div class="rightbox">
				<div class="card-body">
					<p>지원마감일 {{ info.recruitEndDate }}</p>
					<a href="#" class="btn btn-primary">상세보기</a>
				</div>
			</div>
		</div>
	</div>
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

<style>
#items {
	margin: 15px;
}
/* .recruit-item-container {
	background-color: white;
	margin: 10px;
	border-radius: 10px;
	height: 100px;
	padding: 10px;
}

.item-right {
	display: flex;
	align-items: right;
} */
</style>
