<template>
	<div class="review-container">
		<h1>{{ companyName }} 면접 리뷰</h1>
		<form @submit.prevent="saveReview(companyId)">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">제목</label>
				<input
					class="form-control"
					aria-describedby="emailHelp"
					v-model.lazy.trim="interviewState.form.title"
					ref="interviewTitle"
				/>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">면접 리뷰</label>
				<textarea
					class="form-control"
					v-model.lazy.trim="interviewState.form.review"
					ref="interviewReview"
					rows="3"
				/>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">면접 질문</label>
				<textarea
					class="form-control"
					v-model.lazy.trim="interviewState.form.question"
					ref="interviewQuestion"
					rows="5"
				/>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">면접 답변</label>
				<textarea
					class="form-control"
					v-model.lazy.trim="interviewState.form.answer"
					ref="interviewAnswer"
					rows="5"
				/>
			</div>
			<button
				type="button"
				@click="saveReview(companyId)"
				@keyup.enter="saveReview(companyId)"
				style="
					margin-top: 40px;
					padding: 5px;
					width: 100%;
					background-color: white;
					border: 2px solid black;
					border-radius: 5px;
					height: 50px;
				"
			>
				작성하기
			</button>
		</form>
	</div>
</template>

<script>
import { ref, reactive } from 'vue';
import axios from 'axios';
import { url } from '../../../api/http';
import { useRouter } from 'vue-router';

export default {
	name: 'reviewWriteView',

	data() {
		return {
			companyId: this.$route.params.companyId,
			companyName: this.$route.params.companyName,
		};
	},

	setup() {
		const router = useRouter();

		const interviewTitle = ref();
		const interviewReview = ref();
		const interviewQuestion = ref();
		const interviewAnswer = ref();

		const interviewState = reactive({
			form: {
				title: '',
				review: '',
				question: '',
				answer: '',
			},
		});

		const saveReview = function (companyId) {
			if (!interviewState.form.title) {
				alert('제목을 입력해주세요');
				interviewTitle.value.focus();
				return;
			} else if (!interviewState.form.review) {
				alert('면접 리뷰를 입력해주세요');
				interviewReview.value.focus();
				return;
			} else if (!interviewState.form.question) {
				alert('질문을 입력해주세요');
				interviewQuestion.value.focus();
				return;
			} else if (!interviewState.form.answer) {
				alert('답변을 입력해주세요');
				interviewAnswer.value.focus();
				return;
			}

			const interviewInfo = {
				title: interviewState.form.title,
				content: interviewState.form.review,
				question: interviewState.form.question,
				answer: interviewState.form.answer,
			};

			axios({
				method: 'POST',
				url: url + '/review/' + companyId,
				headers: {
					Authorization: localStorage.getItem('jjob.s.token'),
				},
				data: interviewInfo,
			}).then(res => {
				router.push({
					name: 'review',
				});
			});
		};

		return {
			interviewState,
			interviewTitle,
			interviewReview,
			interviewQuestion,
			interviewAnswer,
			saveReview,
		};
	},
};
</script>

<style>
.review-container {
	width: 40%;
	margin: 100px auto;
	border: 1px black solid;
	border-radius: 10px;
	padding: 50px;
}

.review-container h1 {
	margin-bottom: 50px;
}
</style>
