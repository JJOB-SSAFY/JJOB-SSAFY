<template>
	<div id="items">
		<div class="card">
			<div>
				<h4 class="card-header" @click="clickDetail(info.recruitId)">
					<b>SAMSUNG {{ info.recruitTitle }}</b>
					&nbsp;
					<h6>(경력여부 : {{ info.work }})</h6>
				</h4>
			</div>

			<div class="boxContainer">
				<div class="leftbox">
					<div class="card-body">
						<h5>
							<b>풀스택 웹 엔지니어 {{ info.workType }}</b>
						</h5>
					</div>
					<div class="card-body">
						<h5 class="card-title">
							풀스택 웹서비스 개발자 {{ info.department }}
						</h5>
						<p class="card-text">
							AngularJS, Spring 사용에 능숙하신분 {{ info.requirement }}
						</p>
					</div>
				</div>
				<div class="rightbox">
					<div class="card-body">
						<p>지원마감일 &nbsp;&nbsp;~ {{ info.recruitEndDate }}</p>
						<br /><br />
						<button
							class="btn btn-primary"
							@click="clickDetail(info.recruitId)"
						>
							상세
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';

export default {
	name: 'recruitItemView',
	props: {
		info: Object,
	},
	setup() {
		const router = useRouter();
		const store = useStore();

		const clickDetail = function (id) {
			localStorage.setItem('page', id);

			router.push({
				name: 'recruitDetail',
				params: {
					recruitId: id,
				},
			});
		};

		return { clickDetail };
	},
};
</script>

<style>
#items {
	margin: 15px;
}
.boxContainer {
	display: flex;
}
.card-header {
	display: flex;
	text-align: center;
	align-items: center;
	cursor: pointer;
}
.leftbox {
	width: 100%;
}
.rightbox {
	width: 100%;
	text-align: right;
}
</style>
