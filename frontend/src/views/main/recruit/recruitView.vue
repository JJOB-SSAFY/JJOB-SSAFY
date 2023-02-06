<template>
	<!-- <div>채용공고</div> -->
	<recruit-Recommend :test1="test1" />
</template>

<script>
import recruitRecommend from './components/recruit-item.vue';
import axios from 'axios';

export default {
	name: 'recruitView',

	components: {
		recruitRecommend,
	},
	setup() {
		const test1 = 'testtesttesttesttesttesttest';

		const info = {
			companyName: '',
			recruitTitle: '',
			recruitDate: '',
			work: '',
			requirement: '',
		};
		const condition = { location: '', department: '' };
		axios({
			method: 'POST',
			url: 'http://localhost:8080/recruit/list',
			headers: {
				Authorization:
					'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QG5hdmVyLmNvbSIsImlzcyI6InNzYWZ5LmNvbSIsImV4cCI6MTY3Njk0MzE1MiwiaWF0IjoxNjc1NjQ3MTUyfQ.dg_kavwNggw9jvrdn661cFYJ4D2MMsEiSznxOpfpk7AtyDsNfUnXacBQXVANQLMFuLRZR6ytec1bQTNYlOqbAg',
			},
			data: condition,
		}).then(res => {
			console.log(res);
		});

		return { info, test1 };
	},
};
</script>

<style lang="scss" scoped></style>
