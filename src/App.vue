
<template>
  
  <Layout v-if="user.role === 'utilisateur'">
        <template v-slot:header>
          <UserHeader></UserHeader>
        </template>
        <template v-slot:main>
          <RouterView/>
        </template>
        <template v-slot:footer>
            <Footer></Footer>          
        </template>
  </Layout>

  <Layout v-if="user.role === 'admin'">
        <template v-slot:header>
          <Header></Header>
        </template>
        <template v-slot:main>
          <RouterView/>
        </template>
        <template v-slot:footer>
            <Footer></Footer>          
        </template>
  </Layout>

  <div v-if="!isDefined" class="login">
    <RouterView/>
  </div>

</template>

<script setup>

  import { ref, onMounted } from 'vue'
  import Layout from './layouts/Layout.vue'
  import UserHeader from './components/_users/UserHeader.vue'
  import Header from './components/Header.vue'
  import Footer from './components/Footer.vue'

  const user = ref('');
  const isDefined = ref(false);

  onMounted(() => {
    if (document.cookie != '') {
      user.value = JSON.parse(atob(document.cookie.split('.')[1]));
      isDefined.value = true;
    }
  });

</script>

<style scoped>

  .login 
  {
    grid-row: 3 / 8;
    grid-column: 3 / 5;
  }

</style>
