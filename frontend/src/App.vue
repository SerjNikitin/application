<template>
  <div>
    <Navbar />
    <router-view />
  </div>
</template>
<script>
import Navbar from "./components/Navbar.vue";
export default {
  components: { Navbar },
  data() {
    return {};
  },
};
</script>

<style>
body {
  background-color: black;
}
</style>
