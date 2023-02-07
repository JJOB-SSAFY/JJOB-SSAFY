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
			console.log(e.target.files);
			const uploaded_file = await uploadBytes(
				fref(storage, `images/${e.target.files[0].name}`),
				e.target.files[0],
			);
			console.log(uploaded_file);
			const file_url = await getDownloadURL(uploaded_file.ref);
			console.log(file_url);
			image.value = file_url;
			console.log(image);
		};
		return {
			imgUpload,
			image,
		};
	},
};
</script>
