<template>
	<div id="items">
		<div class="card">
			<div>
				<h5 class="card-header">회사이름 {{ info.recruitTitle }}</h5>
			</div>

			<div class="boxContainer">
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
						<br />
						<button
							class="btn btn-primary"
							@click="clickDetail(info.recruitId)"
						>
							상세
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
// import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';
import { Store, storeKey } from 'vuex';

export default {
	name: 'recruitItemView',
	props: {
		info: Object,
	},
	setup() {
		// const store = useStore();
		const router = useRouter();
		const store = useStore();

		const clickDetail = function (id) {
			// const detail_id = store.getters['recruit/getRecruitList'];
			// console.log(detail_id);
			// store.dispatch('recruit/getId');
			localStorage.setItem('page', id);

			router.push({
				name: 'recruitDetail',
				params: {
					recruitId: id,
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
.boxContainer {
	display: flex;
	/* flex-wrap: wrap; */
}
.leftbox {
	width: 100%;
	margin-right: 60%;
}
.rightbox {
	width: 100%;
	text-align: right;
}
</style>
