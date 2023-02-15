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
			<v-card class="font-LINE-Rg">
				<v-card-title class="font-LINE-Bd">
					<img src="@/assets/images/icon/QnA.png" width="19" height="19" />{{
						info.companyName
					}}
					면접 리뷰</v-card-title
				>
				<p />

				<v-card-title class="font-LINE-Bd">{{ info.title }}</v-card-title>
				<v-card-subtitle style="color: #000000"
					>작성자 : {{ info.name }}</v-card-subtitle
				>
				<hr style="margin: 10px 10px" />
				<v-card-title class="font-LINE-Bd">면접 후기</v-card-title>
				<v-card-text style="padding: 0px 24px 10px 24px">
					<fa-icon icon="fas fa-solid fa-magnifying-" />{{
						info.content
					}}</v-card-text
				>
				<v-card-title class="font-LINE-Bd mt-2">면접 질문</v-card-title>
				<v-card-text style="padding: 0px 24px 10px 24px">{{
					info.question
				}}</v-card-text>
				<v-card-title class="font-LINE-Bd mt-2">면접 답변</v-card-title>
				<v-card-text style="padding: 0px 24px 10px 24px">{{
					info.answer
				}}</v-card-text>

				<hr style="margin: 10px 10px" />

				<v-card-actions style="margin-bottom: 10px">
					<v-spacer></v-spacer>

					<button
						class="btnLightBlue btnPush font-LINE-Bd"
						style="
							width: 100px;
							height: 35px;
							display: flex;
							justify-content: center;
							align-items: center;
						"
						color="green-darken-1"
						variant="text"
						@click="dialog = false"
					>
						나가기
					</button>
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
	width: 700px;
}
</style>
