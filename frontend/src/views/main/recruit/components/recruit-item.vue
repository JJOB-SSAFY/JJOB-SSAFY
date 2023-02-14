<template>
	<router-link to="recruit/detail/{{recuritId}}" class="to-recruit-detail">
		<div>
			<div class="rec-item-img">
				<img src="../../../../assets/images/logo-background.jpg" />
			</div>
			<!-- @click="clickDetail(info.recruitId) -->
			<!-- @click="clickDetail(info.recruitId)" -->
			<div class="rec-item-content">
				<div class="rec-item-title font-LINE-Bd">
					{{ info.recruitTitle }} [ {{ info.department }} ]
				</div>
				<div class="rec-item-company font-LINE-Rg">
					{{ info.companyName }}
				</div>
				<div class="rec-item-require font-LINE-Rg">
					{{ info.requirement }}
				</div>
				<div class="rec-item-location font-LINE-Rg">
					{{ info.location }}
				</div>
				<div class="rec-item-end font-LINE-Rg">
					{{ info.recruitStartDate }} ~ {{ info.recruitEndDate }}
				</div>
			</div>
		</div>
	</router-link>
</template>

<script>
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';

export default {
	name: 'recruitItemView',
	props: {
		info: Object,
	},
	setup() {},
};
</script>

<style></style>
