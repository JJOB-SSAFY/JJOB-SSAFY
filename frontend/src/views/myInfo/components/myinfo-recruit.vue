<template>
	<div>
		<div v-for="info in recruitList.recruit" :key="info.recruit">
			<div>{{ info.companyName }}</div>
			<div>{{ info.recruitTitle }}</div>
			<div>{{ info.step }}</div>
			<div>{{ info.status }}</div>
		</div>
	</div>
</template>

<script>
import { ref, reactive, toRaw } from 'vue';
import { useStore } from 'vuex';
import MyinfoService from '../../../api/myinfoService';
export default {
	setup() {
		const myinfoService = new MyinfoService();
		const store = useStore();
		const recruitList = reactive({
			recruit: '',
		});
		myinfoService.getMyRecruit().then(data => (recruitList.recruit = data));
		return { recruitList };
	},
};
</script>
