<template>
	<div>
		<b-card :title="info.title" sub-title="Card subtitle">
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
	},

	setup() {},
};
</script>
