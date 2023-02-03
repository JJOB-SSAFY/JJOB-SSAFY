<template>
	<div>
  <b-card title="Card title" sub-title="Card subtitle">
    <b-card-text>
      Some quick example text to build on the <em>card title</em> and make up the bulk of the card's
      content.
    </b-card-text>

    <b-card-text>A second paragraph of text in the card.</b-card-text>

    <a href="#" class="card-link">Card link</a>
    <b-link href="#" class="card-link">Another link</b-link>
  </b-card>
</div>
</template>

<script>
import {reactive, onMounted} from 'vue';
import axios from 'axios';
export default {
	setup() {
		axios({
			method: 'get',
			url: 'http://localhost:8080/recruit/list',
		})
		.then((res)=>{
			
		})
		return {};
	},
};
</script>

<style lang="scss" scoped></style>
