<template>
	<div class="card shadow" style="width: 18rem; margin: auto">
		<img
			src="../../../../assets/images/blackbackground.jpg"
			class="card-img-top"
			alt="..."
		/>
		<div class="card-body">
			<h4 class="card-title font-LINE-Bd">{{ info.title }}</h4>
			<p class="card-text font-LINE-Rg">
				시작시간 : {{ startTime }} <br />
				종료시간 : {{ endTime }}
			</p>
			<div class="div-button" style="margin-top: 0">
				<b-button
					type="button"
					variant="outline-primary"
					class="div-button font-LINE-Bd w-100"
					@click="
						clickConference(
							info.title,
							info.conferenceId,
							info.companyId,
							info.companyName,
						)
					"
				>
					입장하기
				</b-button>
			</div>
		</div>
	</div>
</template>
<style></style>
<script>
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';

export default {
	name: 'interviewBox',

	props: {
		info: {
			type: Object,
		},
	},

	data() {
		return {
			startTime: new Date(+new Date(this.info.callStartTime) + 3240 * 10000)
				.toISOString()
				.replace('T', ' ')
				.replace(/\..*/, ''),
			endTime: new Date(+new Date(this.info.callEndTime) + 3240 * 10000)
				.toISOString()
				.replace('T', ' ')
				.replace(/\..*/, ''),
		};
	},

	setup() {
		const router = useRouter();

		const store = useStore();

		const clickConference = function (title, id, companyId, companyName) {
			// const loadingInstance1 = ElLoading.service({ fullscreen: true })
			const name = store.getters['auth/getName'];

			router.push({
				name: 'openVidu',
				params: {
					title: title,
					participant: name,
					session: id,
					companyId: companyId,
					companyName: companyName,
				},
			});
			// loadingInstance1.close()
		};

		return { clickConference };
	},
};
</script>
