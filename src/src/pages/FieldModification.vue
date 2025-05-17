<template>
    <Card  class="main" :title="`Modification - ${ $route.params.name }`">
        <template v-slot:main>
            <input type="text" :placeholder="`${$route.params.name}`" required>
            <input type="number" :placeholder="`${$route.params.area}`" required>
            <select>
                <option v-for="groundType in allGroundType" value="">{{ groundType.label }}</option>
            </select>
        </template>        
    </Card>
</template>

<script setup>
    import { ref, onMounted } from 'vue';
    import { getAllGroundType } from '../services/fieldServices';
    import Card from '@/components/Card.vue';

    const allGroundType = ref();

    onMounted(() => {
        getAllGroundType().then((response)=> {
            allGroundType.value = response;
        });
        
    });


</script>

<style scoped>

    .main
    {
        grid-row: 2 / 49;
        grid-column: 2 / 48;
    }

</style>