<template>
	<div class="div-myinfo mt-50">
		<myinfo-card />
		<!-- <hr class="hr-div" /> -->
		<div class="div-three-tab mt-50 pb-20">
			<b-tabs class="font-LINE-Bd" align="center">
				<b-tab title="지원현황" active>
					<div>
						<myinfo-recruit />
					</div>
				</b-tab>
				<b-tab title="이력서관리">
					<div>
						<myinfo-resume />
					</div>
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
import MyinfoResume from './components/myInfo-resume.vue';
import MyinfoUpdate from './components/myinfo-update.vue';
import MyinfoRecruit from './components/myinfo-recruit.vue';
export default {
	components: {
		MyinfoCard,
		MyinfoResume,
		MyinfoUpdate,
		MyinfoRecruit,
	},
	setup() {},
};
</script>

<style lang="scss" scoped></style>
