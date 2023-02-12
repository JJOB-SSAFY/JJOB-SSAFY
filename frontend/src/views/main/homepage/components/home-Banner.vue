<template>
	<div class="banner-container">
		<div
			id="carouselExampleControls"
			class="carousel slide"
			data-bs-ride="carousel"
		>
			<div class="carousel-inner">
				<div class="carousel-item active image-container1"></div>
				<div class="carousel-item image-container2"></div>
				<div class="carousel-item image-container3"></div>
			</div>
			<button
				class="carousel-control-prev"
				type="button"
				data-bs-target="#carouselExampleControls"
				data-bs-slide="prev"
			>
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button
				class="carousel-control-next"
				type="button"
				data-bs-target="#carouselExampleControls"
				data-bs-slide="next"
			>
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
</template>

<script>
export default {
	setup() {
		return {};
	},
};
</script>

<style>
/* .banner-container {
	widows: 100%;
	aspect-ratio: 3/1;
	background-size: cover;
} */

.image-container1 {
	aspect-ratio: 3/1;
	background-image: url('../../../../assets/images/ssafybanner1.jpg');
	background-size: cover;
	background-position: center center;
}

.image-container2 {
	aspect-ratio: 3/1;
	background-image: url('../../../../assets/images/ssafybanner2.jpg');
	background-size: cover;
	background-position: center center;
}

.image-container3 {
	aspect-ratio: 3/1;
	background-image: url('../../../../assets/images/ssafybanner3.png');
	background-size: cover;
	background-position: center center;
}
</style>
