<template>
    <Card class="fieldList" title="Liste des traitements">
        <template v-slot:main>
            <div class="fieldRow" v-for="field in allField" :key="field.id">
                <div>
                    <p>{{ field.label }}</p>
                </div>
                <div>                    
                    <p>{{ field.traitement.produit.label }}</p>
                </div>
                <div>
                    <p>{{ field.traitement.produit.dre }}</p>
                </div>
                <div>
                    <p>{{ field.id_proprietaire }}</p>
                </div>
                <div>
                    <p>{{ field.id_domaine }}</p>
                </div>
                <div>
                    <p class="deleteButton">Supprimer</p>
                    <p class="editButton">Modifier</p>
                </div>
            </div>
        </template>
        
    </Card>
</template>

<script setup>

    import { ref } from 'vue'
    import Card from '../components/Card.vue'
    import { getAllField } from '@/services/fieldServices'
    import Pellet from '../components/Pellet.vue'

    const allField = ref([]);

    getAllField(JSON.parse(atob(document.cookie.split('.')[1])).id).then(
        (response) => {
            allField.value = response.filter(field => typeof field.traitement !== 'undefined');  
        }
    );
            
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

    .fieldRow > div > p 
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