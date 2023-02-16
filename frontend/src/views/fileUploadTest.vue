<!-- npm install firebase 해주세요-->
<template>
	<div>
		<input type="file" ref="file" placeholder="사진" @change="imgUpload" />
		<img :src="image" />
	</div>
</template>

<script>
import { ref as fref, uploadBytes, getDownloadURL } from 'firebase/storage';
import { storage } from '../api/firebase';
import { ref } from 'vue';

export default {
	setup() {
		const image = ref(null);
		const imgUpload = async e => {
			const uploaded_file = await uploadBytes(
				fref(storage, `images/${e.target.files[0].name}`),
				e.target.files[0],
			);
			const file_url = await getDownloadURL(uploaded_file.ref);
			image.value = file_url;
		};
		return {
			imgUpload,
			image,
		};
	},
};
</script>
