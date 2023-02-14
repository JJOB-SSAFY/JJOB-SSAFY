<template>
	<div>
		<div>
			<div class="company-logo">
				<img :src="info.companyLogo" />
			</div>
			<div class="review-item-title font-LINE-Bd">
				<p>{{ info.title }}</p>
			</div>

			<div class="review-item-mid">
				<div class="review-company-name font-LINE-Rg">
					<p>{{ info.companyName }}</p>
				</div>
				<div class="review-name font-LINE-Bd">
					<p>작성자 | {{ info.name }}</p>
				</div>
			</div>
			<div class="div-review-bt btnLightBlue btnPush font-LINE-Bd">
				<button @click="dialog = true">상세보기</button>
			</div>
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
