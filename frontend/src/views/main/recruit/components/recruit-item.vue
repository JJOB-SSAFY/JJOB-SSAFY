<template>
	<div id="items">
		<div class="card">
			<h5 class="card-header">회사이름 {{ info.recruitTitle }}</h5>
			<div class="leftbox">
				<div class="card-body">
					<h6>경력여부 {{ info.workType }}</h6>
				</div>
				<div class="card-body">
					<h5 class="card-title">담당업무 {{ info.department }}</h5>
					<p class="card-text">요구역량 {{ info.requirement }}</p>
				</div>
			</div>
			<div class="rightbox">
				<div class="card-body">
					<p>지원마감일 {{ info.recruitEndDate }}</p>
					<p>{{ info.recruitId }}</p>
					<button class="btn btn-primary" @click="clickDetail(info.recruitId)">
						상세
					</button>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

export default {
	name: 'recruitItemView',
	props: {
		info: Object,
	},
	setup() {
		const store = useStore();
		const router = useRouter();

		const clickDetail = function (recruitId) {
			const detail_id = store.getters['recruit/getRecruitList'];
			console.log(detail_id);

			router.push({
				name: 'recruitDetail',
				params: {
					recruitId: recruitId,
				},
			});
		};

		return { clickDetail };
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
