<template>
	<div>
		<div>{{ test1 }}</div>
		<b-card :title="test1" sub-title="Card subtitle">
			<b-card-text>{{ test1 }} </b-card-text>

			<b-card-text>A s</b-card-text>

			<a href="#" class="card-link">link</a>
			<b-link href="#" class="card-link">link</b-link>
		</b-card>
	</div>
</template>

<script>
export default {
	props: {
		test1: String,
	},
	setup() {
		return {};
	},
};
</script>

<style lang="scss" scoped></style>
