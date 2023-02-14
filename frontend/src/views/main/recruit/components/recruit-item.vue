<template>
	<router-link
		:to="{
			name: 'recruitDetail',
			params: {
				recruitId: info.recruitId,
			},
		}"
		class="to-recruit-detail"
	>
		<div>
			<div>{{ info.recruitId }}</div>
			<div class="rec-item-img">
				<img :src="info.recruitImage" />
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
import { ref } from 'vue';
export default {
	name: 'recruitItemView',
	props: {
		info: Object,
	},
};
</script>

<style></style>
