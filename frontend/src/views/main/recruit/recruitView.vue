<template>
  <!-- <div>채용공고</div> -->
  <recruit-Recommend :test1="test1" />
</template>

<script>
import recruitRecommend from "./components/recruit-recommend.vue";
import axios from "axios";

export default {
  name: "recruitView",

  components: {
    recruitRecommend,
  },
  setup() {
    const test1 = "testtesttesttesttest";

    const info = {
      companyName: "",
      recruitTitle: "",
      recruitDate: "",
      work: "",
      requirement: "",
    };

    const getInfo = function () {
      axios({
        method: "get",
        url: "http://localhost:8080/recruit/list",
      })
        .then((res) => {
          console.log(res);
          info.companyName = res.data.recruits.companyName;
          info.recruitTitle = res.data.recruits.recruitTitle;
          info.recruitDate = res.data.recruits.recruitDate;
          info.work = res.data.recruits.work;
          info.requirement = res.data.recruits.requirement;
        })
        .catch((err) => {
          console.log(err);
        });
    };

    return { getInfo, info, test1 };
  },
};
</script>

<style lang="scss" scoped></style>
