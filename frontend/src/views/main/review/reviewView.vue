<template>
	<div style="width: 80%; margin: auto">
		<h1 style="margin: 50px 20px 25px">면접 리뷰</h1>
		<div class="review-container-header">
			<!-- <h2>기업 면접 리뷰</h2> -->
			<form class="review-search-form" @submit.prevent>
				<input
					id="review-search-id"
					class="form-control review-search-input"
					type="text"
					placeholder="회사명"
					v-model.lazy.trim="reviewSearchCond.form.companyName"
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
import axios from 'axios';
import { url } from '../../../api/http';
import ReviewViewItem from './components/reviewViewItem.vue';

export default {
	name: 'reviewView',

	components: {
		ReviewViewItem,
	},

	setup() {
		const state = reactive({
			interviewReviewList: null,
		});

		const inputCompanyName = ref();

		const reviewSearchCond = reactive({
			form: {
				companyName: '',
			},
		});

		axios({
			method: 'POST',
			url: url + '/review/list',
			headers: {
				Authorization: localStorage.getItem('jjob.s.token'),
			},
			data: {
				companyName: '',
			},
		}).then(res => {
			console.log(res.data);
			state.interviewReviewList = res.data;
		});

		const searchReview = function () {
			const companyName = reviewSearchCond.form.companyName;
			console.log(companyName);

			axios({
				method: 'POST',
				url: url + '/review/list',
				headers: {
					Authorization: localStorage.getItem('jjob.s.token'),
				},
				data: {
					companyName: companyName,
				},
			}).then(res => {
				console.log(res.data);
				state.interviewReviewList = res.data;
			});
		};

		return { state, inputCompanyName, reviewSearchCond, searchReview };
	},
};
</script>

<style>
.review-container {
	background-color: whitesmoke;
	border-radius: 10px;
	padding: 40px 10px 10px 10px;
	box-sizing: border-box;
}

.review-container-header {
	display: flex;
	justify-content: center;
	align-items: center;
	position: relative;
	top: 20px;
}

.review-search-form {
	display: flex;
	align-items: center;
	width: 30%;
	height: 45px;
	position: relative;
}

.review-search-input {
	padding: 5px;
	box-sizing: border-box;
	margin: auto;
	height: 100%;
}
</style>
