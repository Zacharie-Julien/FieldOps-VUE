<template>
    <form>
        <input type="text" class="login" v-model="login" placeholder="Identifiant">
        <input type="password" class="password" v-model="password" placeholder="Mot de passe">
        <button type="button" v-on:click="loginUser(login, password)">Login</button>
    </form>
</template>

<script setup>

    import { ref } from 'vue';
    import { loginUser } from '../services/loginServices';

    const login = ref('');
    const password = ref('');

</script>

<style scoped> 

</style>