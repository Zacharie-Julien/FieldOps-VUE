
<template>
  <Layout>
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
  
</template>

<script setup>
  import Layout from './layouts/Layout.vue'
  import Header from './components/Header.vue'
  import Footer from './components/Footer.vue'
</script>

<style scoped>
  
</style>
