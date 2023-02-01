<template>
	<div class="container">
		<div class="item">
			<img src="@/assets/images/logo.png" alt="##" class="item_logo" />
		</div>
	</div>
</template>

<script>
export default {
	setup() {
		return {};
	},
};
</script>

<style>
.item_logo {
	width: 300px;
}

.item {
	height: 350px;
	width: 1200px;
	background-color: rgb(137, 137, 155);
	border-radius: 8px;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
