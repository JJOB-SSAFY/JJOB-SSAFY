<template>
	<div>
		채용공고
		{{ detailList.department }}
	</div>
</template>

<script>
import { reactive, ref, computed, toRaw } from 'vue';
import axios from 'axios';
import { url } from '../../../api/http';
import { useStore } from 'vuex';
// import { useRouter } from 'vue-router';

export default {
	name: 'recruitDetailView',

	// data() {
	// 	return {
	// 		recruitId: this.$route.params.recruitId,
	// 	};
	// },

	setup() {
		const store = useStore();
		// const detail_id = store.getters['recruit/getRecruitList'];
		// const toDetail = toRaw(detail_id);
		// console.log(detail_id);
		// console.log(toDetail);

		const recruitId = localStorage.getItem('page');
		// console.log(recruitId);
		const detailList = reactive({
			career: null,
			companyName: null,
			department: null,
			eduRequirement: null,
			imgUrl: null,
			location: null,
			recruitTitle: null,
			salary: null,
			work: null,
			workType: null,
		});

		axios({
			method: 'GET',
			url: url + '/recruit/detail/' + recruitId,
		})
			.then(response => {
				console.log(response.data);
				detailList.career = response.data.career;
				detailList.companyName = response.data.companyName;
				detailList.department = response.data.department;
				detailList.eduRequirement = response.data.eduRequirement;
				detailList.imgUrl = response.data.imgUrl;
				detailList.location = response.data.location;
				detailList.recruitTitle = response.data.recruitTitle;
				detailList.salary = response.data.salary;
				detailList.work = response.data.work;
				detailList.workType = response.data.workType;

				console.log(toRaw(detailList));
			})
			.catch(err => {
				console.log(err);
			});
		return { detailList };
	},
};
</script>

<style scoped></style>
