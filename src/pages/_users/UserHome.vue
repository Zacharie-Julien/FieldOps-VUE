<template>
    <Card class="fieldList" title="Liste des traitements">
        <template v-slot:main>
             <div class="fieldRow">
                <div>
                    <p class="editButton">Nom du champ</p>
                </div>
                <div>
                    <p class="editButton">Nom du produit</p>
                </div>
                <div>
                    <p class="editButton">Date de réalisation</p>   
                </div>
                <div>
                    <p class="editButton">Nom ouvrier</p>                                        
                </div>
                <div>
                    <p class="editButton">Prénom ouvrier</p>
                </div>
                <div>
                </div>
            </div>
            <div class="fieldRow" v-for="operation in allOperation" :key="operation.id" :class="{completed : operation.status === false}">
                <div>
                    <p>{{ operation.champ.label }}</p>
                </div>
                <div>                    
                    <p>{{ operation.traitement.produit.label }}</p>
                </div>
                <div>
                    <p>{{ lisibleDate(operation.subitPk.dateNow) }}</p>
                </div>
                <div>
                    <p>{{ operation.ouvrier.nom }}</p>
                </div>
                <div>
                    <p>{{ operation.ouvrier.prenom }}</p>
                </div>
                <div>
                    <a href="#" v-if="operation.status === true" class="editButton" @click="valideOperation(operation.subitPk)">Valider</a>
                    <p v-else class="editButton">Réaliser</p>
                </div>
            </div>
        </template>        
    </Card>
</template>

<script setup>

    import { ref } from 'vue'
    import Card from '../../components/Card.vue'
    import { getAllOperationByWorkerId, valideOperation } from '@/services/operationServices'

    const allOperation = ref();

    getAllOperationByWorkerId(JSON.parse(atob(document.cookie.split('.')[1])).id).then(
        (response) => {
            allOperation.value = response.sort((a, b) => b.status + a.status);  
        }
    );

    function lisibleDate(date){
        const time = new Date(date.replace(/\[.*\]/, ""));

        return time.toLocaleString('fr-FR', {
            dateStyle: 'short'
        });
    }
</script>

<style scoped>

    .fieldList
    {
        grid-row: 2 / 48;
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

    .completed
    {
        opacity: .6;
        text-decoration: line-through;
        text-decoration-color: var(--main-title-gray);

    }

</style>