<template>
	<div>
		<div class="review-view-item-container" @click="dialog = true">
			<p style="color: dodgerblue">면접 리뷰</p>
			<h4>
				{{ info.title }}
			</h4>
			<p style="color: gray">
				{{ info.name }}
			</p>
		</div>
		<v-dialog v-model="dialog" width="auto">
			<v-card>
				<v-card-title>면접 리뷰</v-card-title>
				<hr />
				<v-card-title>{{ info.title }}</v-card-title>
				<v-card-subtitle>{{ info.name }}</v-card-subtitle>
				<hr />
				<v-card-title>면접 리뷰</v-card-title>
				<v-card-text>{{ info.content }}</v-card-text>
				<v-card-title>면접 질문</v-card-title>
				<v-card-text>{{ info.question }}</v-card-text>
				<v-card-title>면접 답변</v-card-title>
				<v-card-text>{{ info.answer }}</v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn color="green-darken-1" variant="text" @click="dialog = false">
						나가기
					</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>
		<!-- Modal -->
		<!-- <div
			class="modal fade"
			id="exampleModal"
			tabindex="-1"
			aria-labelledby="exampleModalLabel"
			aria-hidden="true"
			style="padding: 40px"
		>
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">면접 리뷰</h5>
						<button
							type="button"
							class="btn-close"
							data-bs-dismiss="modal"
							aria-label="Close"
						></button>
					</div>
					<h2 class="mt-3 ms-3">{{ info.title }}</h2>
					<div class="modal-body">{{ info.name }}</div>
					<h5 class="ms-3">면접 리뷰</h5>
					<div class="modal-body">{{ info.content }}</div>
					<h5 class="ms-3">면접 질문</h5>
					<div class="modal-body">{{ info.question }}</div>
					<h5 class="ms-3">면접 답변</h5>
					<div class="modal-body">{{ info.answer }}</div>
					<div class="modal-footer">
						<button
							type="button"
							data-bs-dismiss="modal"
							style="
								padding: 5px;
								width: 100%;
								background-color: dodgerblue;
								/* border: 2px solid black; */
								border-radius: 5px;
								height: 50px;
								color: white;
								font-size: 18px;
								font-weight: bold;
							"
						>
							나가기
						</button>
					</div>
				</div>
			</div>
		</div> -->
	</div>
</template>

<script>
export default {
	name: 'reviewBox',

	props: {
		info: {
			type: Object,
		},
	},
	data() {
		return {
			dialog: false,
		};
	},
	setup() {},
};
</script>

<style>
.card-name {
	margin-left: 23px;
}
.review-view-item-container {
	background-color: white;
	margin: 10px;
	border-radius: 10px;
	height: 100px;
	padding: 10px;
}
.v-card {
	width: 900px;
}
</style>
