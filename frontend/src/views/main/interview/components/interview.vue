<template>
	<div>
		<b-card title="Card title" sub-title="Card subtitle">
			<b-card-text>
				{{ info.title }}
			</b-card-text>

			<b-card-text>
				{{ info.callStartTime }}
			</b-card-text>

			<b-card-text>
				{{ info.callEndTime }}
			</b-card-text>
		</b-card>
	</div>
</template>
<style></style>
<script>
export default {
	name: 'interviewBox',

	props: {
		info: {
			type: Object,
		},
		// title: {
		// 	type: String,
		// 	default: '제목',
		// },
		// desc: {
		// 	type: String,
		// 	default:
		// 		"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
		// },
	},

	setup() {},
};
</script>
