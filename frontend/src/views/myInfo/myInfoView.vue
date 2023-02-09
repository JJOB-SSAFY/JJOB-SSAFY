<template>
	<div class="div-myinfo mt-100">
		<myinfo-card />
		<!-- <hr class="hr-div" /> -->
		<div class="div-three-tab mt-50">
			<b-tabs content-class="mt-3" class="font-LINE-Bd" align="center">
				<b-tab title="지원현황" active>
					<div>지원자 현황~~~</div>
				</b-tab>
				<b-tab title="이력서관리">
					<div>이력서 현황~~~</div>
				</b-tab>
				<b-tab title="내정보변경">
					<div>
						<myinfo-update />
					</div>
				</b-tab>
			</b-tabs>
		</div>
	</div>
</template>

<script>
import MyinfoCard from './components/myInfo-card.vue';
import MyinfoUpdate from './components/myinfo-update.vue';
export default {
	components: {
		MyinfoCard,
		MyinfoUpdate,
	},
	setup() {},
};
</script>

<style lang="scss" scoped></style>
