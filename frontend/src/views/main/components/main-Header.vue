<template>
	<header>
		<div id="nav">
			<div v-for="nav in navigations" :key="nav.name" class="nav-itme">
				<RouterLink :to="nav.href" active-class="active" class="nav-link">
					{{ nav.name }}
				</RouterLink>
			</div>
		</div>
	</header>
</template>

<script>
export default {
	setup() {
		const navigations = [
			{
				name: 'Main',
				href: '/main',
			},
			{
				name: 'interview',
				href: '/interview',
			},
		];
		return { navigations };
	},
};
</script>

<style lang="scss" scoped></style>
