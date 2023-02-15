<template>
	<div style="padding-bottom: 100px">
		<div class="review-write-container shadow">
			<h1>{{ companyName }} 면접 리뷰</h1>
			<form>
				<div class="mb-3">
					<label for="interview-title" class="form-label">제목</label>
					<input
						id="interview-title"
						class="form-control"
						v-model.lazy.trim="interviewState.form.title"
						ref="interviewTitle"
					/>
				</div>
				<div class="mb-3">
					<label for="interview-review" class="form-label">면접 리뷰</label>
					<textarea
						id="interview-review"
						class="form-control resize-ban"
						v-model.lazy.trim="interviewState.form.review"
						ref="interviewReview"
						rows="3"
					/>
				</div>
				<div class="mb-3">
					<label for="interview-question" class="form-label">면접 질문</label>
					<textarea
						id="interview-question"
						class="form-control resize-ban"
						v-model.lazy.trim="interviewState.form.question"
						ref="interviewQuestion"
						rows="5"
					/>
				</div>
				<div class="mb-3">
					<label for="interview-answer" class="form-label">면접 답변</label>
					<textarea
						id="interview-answer"
						class="form-control resize-ban"
						v-model.lazy.trim="interviewState.form.answer"
						ref="interviewAnswer"
						rows="5"
					/>
				</div>
				<!-- <button
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
				</button> -->
			</form>
			<div class="review-create-footer">
				<p class="text-center mt-40 d-flex justify-content-end">
					<button
						class="btn btn-lg btn-primary me-3"
						type="button"
						@click="saveReview(companyId)"
						@keyup.enter="saveReview(companyId)"
					>
						작성하기
					</button>
					<button
						type="button"
						class="btn btn-lg btn-secondary"
						@click="backToReviewView()"
					>
						나가기
					</button>
				</p>
			</div>
		</div>
	</div>
</template>

<script>
import { ref, reactive } from 'vue';
import axios from 'axios';
import { url } from '../../../api/http';
import { useRouter } from 'vue-router';
import Swal from 'sweetalert2';

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
				Swal.fire({
					title: 'OOPS!',
					text: '제목을 입력해주세요',
					icon: 'warning',
				});
				interviewTitle.value.focus();
				return;
			} else if (!interviewState.form.review) {
				Swal.fire({
					title: 'OOPS!',
					text: '면접리뷰를 입력해주세요',
					icon: 'warning',
				});
				interviewReview.value.focus();
				return;
			} else if (!interviewState.form.question) {
				Swal.fire({
					title: 'OOPS!',
					text: '질문을 입력해주세요',
					icon: 'warning',
				});
				interviewQuestion.value.focus();
				return;
			} else if (!interviewState.form.answer) {
				Swal.fire({
					title: 'OOPS!',
					text: '답변을 입력해주세요',
					icon: 'warning',
				});
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

		const backToReviewView = () => {
			router.push({
				name: 'review',
			});
		};

		return {
			interviewState,
			interviewTitle,
			interviewReview,
			interviewQuestion,
			interviewAnswer,
			saveReview,
			backToReviewView,
		};
	},
};
</script>

<style>
.review-write-container {
	width: 40%;
	margin: 100px auto;
	border: 1px black solid;
	border-radius: 10px;
	padding: 50px;
}

.review-write-container h1 {
	margin-bottom: 50px;
}

.review-create-footer {
	position: fixed;
	width: 100%;
	height: 100px;
	background: white;
	bottom: 0;
	right: 0;
	display: flex;
	justify-content: right;
	align-items: center;
	border-top: 1px lightgray solid;
	padding-right: 130px;
	padding-bottom: 40px;
}

.resize-ban {
	resize: none;
}
</style>
