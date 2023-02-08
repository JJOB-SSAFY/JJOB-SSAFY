<template>
	<myinfo-card />
	<hr class="hr-div" />
	<div class="div-three-tab">
		<div class="tabs">
			<input type="radio" id="tab1" name="tab-control" checked />
			<input type="radio" id="tab2" name="tab-control" />
			<input type="radio" id="tab3" name="tab-control" />

			<ul class="ul-tabs">
				<li title="지원현황">
					<label for="tab1" role="button" />
					<fa-icon icon="fas fa-solid fa-user" />
					<br />
					<span> 지원현황 </span>
				</li>
				<li title="이력서 관리">
					<label for="tab2" role="button" />
					<fa-icon icon="fas fa-solid fa-user" />
					<br />
					<span> 이력서 관리 </span>
				</li>
				<li title="내 정보 관리">
					<label for="tab3" role="button" />
					<fa-icon icon="fas fa-solid fa-user" />
					<br />
					<span> 내 정보 관리 </span>
				</li>
				<div class="slider">
					<div class="indicator"></div>
				</div>

				<div class="content">
					<section></section>

					<section></section>

					<section></section>
				</div>
			</ul>
		</div>
	</div>
</template>

<script>
import { reactive, toRaw } from 'vue';
import { useStore } from 'vuex';
import MyinfoCard from './components/myInfo-card.vue';
export default {
	components: {
		MyinfoCard,
	},
	setup() {},
};
</script>

<style lang="scss" scoped></style>
