<template>
	<div>
		<div
			v-for="info in recruitList.recruit"
			:key="info.recruit"
			class="myapply-container"
		>
			<div class="myapply-companyname font-LINE-Bd">{{ info.companyName }}</div>

			<div class="myapply-title font-LINE-Rg">{{ info.recruitTitle }}</div>
			<div class="myapply-step font-LINE-Rg">{{ info.step }}</div>
			<button @click="modalInfo.dialog = true" class="myapply-view-bt">
				{{ info.status }}
			</button>
			<div v-if="info.result === '불합격'">
				<v-row justify="center">
					<v-dialog v-model="modalInfo.dialog" persistent width="auto">
						<v-card>
							<v-card-title class="text-h4 modal-title" style="color: red">
								{{ info.result }}
							</v-card-title>
							<!-- <v-card-text>
								안녕하세요 {{ myName }}님, {{ info.companyName }} 인사팀입니다.
								<br />
								{{ info.companyName }}에 보내주신 {{ myName }}님의 관심과 애정에
								감사드립니다. 보내주신 이력서를 채용 위원들과 함께 면밀하게
								검토하였으나 아쉽게도 기대하셨을 합격 소식을 전해드리지 못하게
								되었습니다. 이는 {{ myName }}님의 역량이 부족해서가 아닌, 다른
								경험과 역량을 갖춘 분을 찾기 위한 결정임을 너른 마음으로
								이해해주시면 좋겠습니다. 앞으로 더욱 좋은 기회를 만들어
								{{ myName }}님과 같이 우수한 분을 모실 수 있게끔 성장하겠습니다.
								추후 재지원하실 때에 불이익이 없도록 지원 서류의 모든 개인정보는
								파기할 예정입니다. 소중한 시간 내어주시어 감사드리며 이후 더
								좋은 인연으로 만나 뵙기를 진심으로 바라겠습니다. 감사합니다.
								{{ info.companyName }} 인사팀 드림.
							</v-card-text> -->
							<br />
							<h4 style="margin-left: 25px">불합격 사유</h4>
							<v-card-text>{{ info.title }}</v-card-text>
							<div v-if="info.content !== ''"></div>
							<br />
							<h4 style="margin-left: 25px">피드백</h4>
							<v-card-text>{{ info.content }}</v-card-text>
							<v-card-actions>
								<v-spacer></v-spacer>
								<v-btn
									color="green-darken-1"
									variant="text"
									@click="modalInfo.dialog = false"
									class="text-h6"
								>
									나가기
								</v-btn>
							</v-card-actions>
						</v-card>
					</v-dialog>
				</v-row>
			</div>
			<div v-else>
				<v-row justify="center">
					<v-dialog v-model="modalInfo.dialog" persistent width="auto">
						<v-card>
							<v-card-title class="text-h4 modal-title" style="color: green">
								{{ info.result }}
							</v-card-title>
							<v-card-text class="text-h6"
								>축하드립니다. {{ myName }} 님은 {{ info.companyName }}
								{{ info.recruitTitle }} 서류 전형에 합격하셨습니다. <br />
							</v-card-text>
							<v-card-actions>
								<v-spacer></v-spacer>
								<v-btn
									color="green-darken-1"
									variant="text"
									@click="modalInfo.dialog = false"
								>
									Disagree
								</v-btn>
								<v-btn
									color="green-darken-1"
									variant="text"
									@click="modalInfo.dialog = false"
								>
									Agree
								</v-btn>
							</v-card-actions>
						</v-card>
					</v-dialog>
				</v-row>
			</div>
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
