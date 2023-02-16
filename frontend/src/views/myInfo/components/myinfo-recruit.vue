<template>
	<div
		v-for="info in recruitList.recruit"
		:key="info.recruit"
		class="myapply-container font-LINE-Bd"
	>
		<div class="myapply-companyname line-clamp-default-1 font-LINE-Bd">
			{{ info.companyName }}
		</div>
		<div class="myapply-title line-clamp-default-1 font-LINE-Bd">
			{{ info.recruitTitle }}
		</div>
		<div class="myapply-step line-clamp-default-1 font-LINE-Bd">
			{{ info.step }}
		</div>
		<button
			v-if="info.status === '결과보기'"
			@click="modalInfo.dialog = true"
			class="myapply-view-bt"
		>
			{{ info.status }}
		</button>
		<button v-else class="myapply-view-bt">
			{{ info.status }}
		</button>
		<div v-if="info.result === '불합격'">
			<v-row justify="center">
				<v-dialog v-model="modalInfo.dialog" persistent width="auto">
					<v-card class="font-LINE-Rg">
						<v-card-title class="font-LINE-Bd f28" style="color: #ff7e7e">
							불합격
						</v-card-title>
						<p class="font-LINE-Bd f21" style="margin-left: 25px">
							불합격 사유
						</p>
						<v-card-text style="padding: 5px 0px 0px 10px; margin-left: 25px">
							{{ info.title }}</v-card-text
						>
						<hr style="margin: 10px 15px 0px 15px" />
						<div v-if="info.content !== ''">
							<p class="font-LINE-Bd f21 mt-5" style="margin-left: 25px">
								피드백
							</p>
							<v-card-text
								style="
									padding: 5px 0px 0px 10px;
									margin-left: 25px;
									font-size: 15px;
								"
								>{{ info.content }}</v-card-text
							>
						</div>
						<v-card-actions>
							<button id="out-bt" @click="modalInfo.dialog = false">
								나가기
							</button>
						</v-card-actions>
					</v-card>
				</v-dialog>
			</v-row>
		</div>
		<div v-else-if="info.result === '합격'">
			<v-row justify="center">
				<v-dialog v-model="modalInfo.dialog" persistent width="auto">
					<v-card class="font-LINE-Rg">
						<v-card-title class="font-LINE-Bd f28" style="color: green">
							축하드립니다
						</v-card-title>
						<v-card-text style="font-size: 18px">
							{{ myName }}님은 {{ info.companyName }}
							{{ info.recruitTitle }} 서류 전형에 합격하셨습니다. <br />
							면접 일정은 추후에 따로 연락드리겠습니다.
						</v-card-text>
						<br />
						<v-card-actions>
							<button id="out-bt" @click="modalInfo.dialog = false">
								나가기
							</button>
						</v-card-actions>
					</v-card>
				</v-dialog>
			</v-row>
		</div>
	</div>
</template>

<script>
import { reactive } from 'vue';
import MyinfoService from '../../../api/myinfoService';
import { useStore } from 'vuex';

export default {
	setup() {
		const myinfoService = new MyinfoService();

		const store = useStore();

		const myName = store.getters['auth/getName'];

		const modalInfo = reactive({
			dialog: false,
		});

		const recruitList = reactive({
			recruit: '',
		});
		myinfoService.getMyRecruit().then(data => (recruitList.recruit = data));
		return { myName, modalInfo, recruitList };
	},
};
</script>

<style scoped>
.v-card {
	padding: 6px 2px;
}
.v-card-title {
	font-size: 24px;
}
.v-card-actions > button {
	width: 100px;
	border-radius: 12px;
	background: #ff7e7e;
	padding: 5px 0px;
}
</style>
