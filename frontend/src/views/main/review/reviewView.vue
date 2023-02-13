<template>
	<div class="banner-container">
		<span class="banner-letter1">Review</span>
		<p class="banner-letter2">면접 후기 정보를 작성하는 곳입니다.</p>
	</div>

	<hr class="hr-main" />
	<div class="review-section">
		<div class="review-container-header">
			<!-- <h2>기업 면접 리뷰</h2> -->
			<form class="review-search-form" @submit.prevent>
				<input
					id="review-search-id"
					class="form-control review-search-input"
					type="text"
					placeholder="회사명"
					v-model.lazy.trim="reviewSearchCond.form.companyName"
					v-on:focusout="searchReview"
					ref="inputCompanyName"
					@keyup.enter="searchReview"
				/>
				<button
					type="button"
					@click="searchReview"
					style="font-size: 20px; position: absolute; right: 20px"
				>
					<fa-icon icon="fas fa-solid fa-magnifying-glass" />
				</button>
			</form>
		</div>
		<!-- 이 위는 검색창 -->
		<div class="review-container">
			<div>
				<ul class="row">
					<li
						v-for="info in state.interviewReviewList"
						:key="info.reviewId"
						class="col-6"
					>
						<review-view-item :info="info" />
					</li>
				</ul>
			</div>
		</div>
	</div>
</template>

<script>
import { ref, reactive } from 'vue';
import ReviewViewItem from './components/reviewViewItem.vue';
import reviewAPI from '../../../api/reviewService';

export default {
	name: 'reviewView',

	components: {
		ReviewViewItem,
	},

	setup() {
		const state = reactive({
			interviewReviewList: null,
		});

		const inputCompanyName = ref('');

		const reviewSearchCond = reactive({
			form: {
				companyName: '',
			},
		});

		const reviewService = new reviewAPI();

		reviewService.getList(inputCompanyName.value).then(res => {
			state.interviewReviewList = res;
		});

		const searchReview = function () {
			reviewService.getList(reviewSearchCond.form).then(res => {
				console.log(res);
				state.interviewReviewList = res;
			});
		};

		return { state, inputCompanyName, reviewSearchCond, searchReview };
	},
};
</script>

<style></style>
