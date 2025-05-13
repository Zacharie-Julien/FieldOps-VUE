<template>
    <Card class="fieldList" title="Liste des champs">
        <template v-slot:main>
            <div class="fieldRow" v-for="(field, index) in allField" :key="field.id">
                <div>
                    <p>{{ index }}</p>
                </div>
                <div>
                    <p>{{ field.label }}</p>
                </div>
                <div>
                    <p>{{ field.surface }}</p>
                </div>
                <div>
                    <p>{{ field.typeSol.label }}</p>
                </div>
                <div>
                    <p>{{ field.typeSol.pH }}</p>
                </div>
                <div>
                    <a href="#" class="deleteButton" v-on:click.prevent="handleClick(field.id)">Supprimer</a>
                    <a href="#" class="editButton">Modifier</a>
                </div>
            </div>
        </template>
        
    </Card>
</template>

<script setup>

    import { ref, onMounted } from 'vue';
    import { getAllField, deleteFieldById } from '../services/fieldServices';
    import Card from '../components/Card.vue'

    onMounted(() => {
        loadData();
    });
    const allField = ref([]);

    function loadData(){
        getAllField(JSON.parse(atob(document.cookie.split('.')[1])).id).then(
            (response) => {
                allField.value = response;
            }
        );

    }

    function handleClick(id){
        deleteFieldById(id).then(()=>{
            setTimeout(() => {
                loadData();
            }, 50);
        });
    }

    


</script>

<style scoped>

    .fieldList 
    {
        grid-row: 2 / 49;
        grid-column: 2 / 48;
    }

    .fieldRow 
    {
        width: 95%;
        height: 40px;

        display: grid;
        grid-template-columns: repeat(6, 1fr);
        grid-template-rows: 1;

    }

    .fieldRow > div 
    {

        display: flex;
        align-items: center;
        justify-content: flex-start;

        border-bottom: solid 1px var(--main-border-gray);
    }

    .fieldRow > div > a, p
    {
        color: var(--main-title-gray);
        text-decoration: none;
        list-style: none;
        font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
        font-optical-sizing: auto;
        font-weight: 100;
        font-style: normal;
        font-size: 20px;
        word-spacing: 1px;
        transition-duration: .125s;

        margin-left: 20px;

    }

    .editButton 
    {
        color: var(--main-green) !important;
    }

    .deleteButton 
    {
        color: red !important;
    }

</style>