<template>
	<div class="banner-container">
		<span class="banner-letter1">Recruit</span>
		<p class="banner-letter2">채용공고 리스트를 확인하는 곳입니다.</p>
	</div>

	<hr class="hr-main2" />
	<form class="recruit-search-form mt-50" @submit.prevent>
		<div class="div-search-career">
			<img src="@/assets/images/icon/newold.png" width="19" height="19" />
			<input
				id="recruit-search-career"
				class="form-control card-search-input font-LINE-Rg"
				type="text"
				placeholder="신입/경력"
				v-model.lazy.trim="condition.form.career"
				readonly
			/>
			<div class="dropdown" style="position: absolute; right: 5px">
				<button
					type="button"
					id="dropdownMenuButton1"
					data-bs-toggle="dropdown"
					aria-expanded="false"
				>
					<fa-icon icon="fas fa-solid fa-chevron-down" />
				</button>
				<ul class="dropdown-menu w-100" aria-labelledby="dropdownMenuButton1">
					<li>
						<a class="dropdown-item non-hover" @click="searchByCareer('')"
							>전체</a
						>
					</li>
					<li>
						<a class="dropdown-item non-hover" @click="searchByCareer('신입')"
							>신입</a
						>
					</li>
					<li>
						<a class="dropdown-item non-hover" @click="searchByCareer('경력')"
							>경력</a
						>
					</li>
				</ul>
			</div>
		</div>
		<div class="div-search-location">
			<img src="@/assets/images/icon/location.png" width="19" height="19" />
			<input
				id="recruit-search-location"
				class="form-control card-search-input font-LINE-Rg"
				type="text"
				placeholder="지역"
				v-model.lazy.trim="condition.form.location"
				ref="inputLocation"
				@keyup.enter="searchRecruit"
				v-on:focusout="searchRecruit"
			/>
			<button type="button" @click="searchRecruit">
				<fa-icon icon="fas fa-solid fa-magnifying-glass" />
			</button>
		</div>
		<div class="div-search-department">
			<img src="@/assets/images/icon/department.png" width="19" height="19" />
			<input
				id="recruit-search-department"
				class="form-control card-search-input font-LINE-Rg"
				type="text"
				placeholder="직무"
				v-model.lazy.trim="condition.form.department"
				ref="inputDepartment"
				@keyup.enter="searchRecruit"
				v-on:focusout="searchRecruit"
			/>
			<button type="button" @click="searchRecruit">
				<fa-icon icon="fas fa-solid fa-magnifying-glass" />
			</button>
		</div>
	</form>
	<div>
		<div>
			<div class="rec-list">
				<div
					class="rec-list-item"
					v-for="info in searchList.recruit"
					:key="info.list"
				>
					<recruit-item-view :info="info" />
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import recruitItemView from './components/recruit-item.vue';
import { reactive, onMounted, computed, toRaw, watch } from 'vue';
import { useStore } from 'vuex';
import RecruitService from '../../../api/recruitService';
export default {
	name: 'recruitView',
	components: {
		recruitItemView,
	},
	setup() {
		const recruitService = new RecruitService();
		const searchList = reactive({
			recruit: '',
		});

		const condition = reactive({
			form: {
				career: '',
				location: '',
				department: '',
			},
		});

		const searchByCareer = career => {
			condition.form.career = career;
			searchRecruit();
		};

		const searchRecruit = async function () {
			recruitService
				.getRecruitList(toRaw(condition.form))
				.then(data => {
					searchList.recruit = data.sort(function(a, b){
						return b.recruitId - a.recruitId;
					})
				});
		};
		searchRecruit();

		return { condition, searchRecruit, searchList, searchByCareer };
	},
};
</script>

<style></style>
