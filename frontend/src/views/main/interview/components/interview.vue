<template>
	<div class="card shadow" style="width: 18rem; margin: auto">
		<img
			src="../../../../assets/images/blackbackground.jpg"
			class="card-img-top"
			alt="..."
		/>
		<div class="card-body">
			<h5 class="card-title">{{ info.title }}</h5>
			<p class="card-text">
				시작시간 : {{ startTime }} <br />
				종료시간 : {{ endTime }}
			</p>
			<button
				@click="
					clickConference(info.conferenceId, info.companyId, info.companyName)
				"
				style="
					margin: 10px 0 auto;
					padding: 5px;
					width: 100%;
					background-color: white;
					border: 2px solid black;
					border-radius: 5px;
				"
			>
				입장하기
			</button>
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

		const clickConference = function (id, companyId, companyName) {
			// const loadingInstance1 = ElLoading.service({ fullscreen: true })
			const name = store.getters['auth/getName'];

			router.push({
				name: 'openVidu',
				params: {
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
