<template>
	<div class="banner-container">
		<span class="banner-letter1">Review</span>
		<p class="banner-letter2">면접 후기 정보를 작성하는 곳입니다.</p>
	</div>

	<hr class="hr-main2" />
	<form class="recruit-search-form mt-50" @submit.prevent>
		<div class="div-search-location">
			<img src="@/assets/images/icon/office.png" width="19" height="19" />
			<input
				class="form-control card-search-input font-LINE-Rg"
				type="text"
				placeholder="회사명"
				v-model.lazy.trim="reviewSearchCond.form.companyName"
				v-on:focusout="searchReview"
				ref="inputCompanyName"
				@keyup.enter="searchReview"
			/>
			<button type="button" @click="searchReview">
				<fa-icon icon="fas fa-solid fa-magnifying-glass" />
			</button>
		</div>
	</form>
	<div class="review-section">
		<!-- 이 위는 검색창 -->
		<div
			v-for="info in state.interviewReviewList"
			:key="info.reviewId"
			class="review-item"
		>
			<review-view-item :info="info" />
		</div>
	</div>
</template>

<script>
// v-model.lazy.trim="condition.form.location"
// ref="inputLocation"
// @keyup.enter="searchRecruit"
// v-on:focusout="searchRecruit"
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
