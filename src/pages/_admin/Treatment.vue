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
            <div class="fieldRow" v-for="operation in allOperation" :key="operation.id" :class="{completed : operation.status == 0}">
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
                    <a href="#" v-if="operation.status == 1" class="deleteButton" @click="deleteHandleClick(operation.subitPk)">Supprimer</a>
                    <p v-else class="realised">Traitement réaliser</p>
                </div>
            </div>
        </template>        
    </Card>
    <Card class="fielAddList" title="Ajouter un traitements">         
           <template v-slot:main>  
            <div class="typeAdd">
                <form class="formAdd" @submit.prevent="handleAdd(inputTreatment, inputField, inputWorker, inputDate)">
                    <div>
                        <select v-model="inputWorker" required>
                            <option selected disabled hidden :value="inputWorker">Choisissez l'ouvrier</option>
                            <option :value="`${worker.id}`" v-for="worker in allWoker.listeOuvriers">{{ worker.nom }}</option>                            
                        </select>
                    </div>
                    <div>
                        <select v-model="inputField" required>
                            <option :value="inputField" selected disabled hidden>Choisissez le champ</option>
                            <option :value="`${field.id}`" v-for="field in allField">{{ field.label }}</option>
                        </select>
                    </div>
                    <div>
                        <select v-model="inputTreatment" required>
                            <option :value="inputTreatment" selected disabled hidden>Choisissez le produit</option>
                            <option :value="`${product.id}`" v-for="product in allProducts">{{ product.label }}</option>
                        </select>
                    </div>
                    <div class="addButton">
                        <button class="editButton" type="submit">Ajouter</button>
                    </div>
                    <div>
                        <input type="date" v-model="inputDate" required>
                    </div>                    
                </form>
            </div>            
        </template>
    </Card>
    <Card class="countOperation" title="Nombre de traitement en cours">
        <template v-slot:main>
            <div>
                <p class="countText">
                    {{ operationCount.length }}
                </p>            
            </div>            
        </template>
    </Card>
</template>

<script setup>

    import { ref, onMounted } from 'vue'
    import Card from '../../components/Card.vue'
    import { getAllOperationById, addOperation, deleteOperation } from '@/services/operationServices'
    import { getAllWorkers } from '@/services/userServices'
    import { getAllField } from '@/services/fieldServices'
    import { getAllProducts } from '@/services/productServices'
    import { useRouter } from 'vue-router'

    const allOperation = ref();
    const operationCount = ref([]);
    const allWoker = ref([]);
    const allField = ref([]);
    const allProducts = ref([]);
    const router = useRouter('');


onMounted(() => {
    loadOperations();
})

async function loadOperations() {
    try {
        const userId = JSON.parse(atob(document.cookie.split('.')[1])).id;
        const fields = await getAllField(userId);
        const fieldIds = fields.map(f => f.id);
        const operationsList = await getAllOperationById(fieldIds);
        const allOperationsFlat = (await Promise.all(operationsList)).flat();
        allOperation.value = allOperationsFlat.sort((a, b) => b.status - a.status);
        operationCount.value = allOperation.value.filter(op => op.status == 1);        

    } catch (error) {
        console.error("Erreur lors du chargement des opérations :", error);
    }
}

    getAllWorkers(JSON.parse(atob(document.cookie.split('.')[1])).idDomain).then(
        (response) => {            
            allWoker.value = response;
    });

    getAllField(JSON.parse(atob(document.cookie.split('.')[1])).id).then(
        (response) => {            
            allField.value = response;
    });

    getAllProducts().then(
        (response) => {            
            allProducts.value = response;
    });

    function handleAdd(inputTreatment, inputField, inputWorker, inputDate){
        addOperation(inputTreatment, inputField, inputWorker, inputDate).then(() => {
            router.go(0);
        });
    }

    function lisibleDate(date){
        const time = new Date(date.replace(/\[.*\]/, ""));

        return time.toLocaleString('fr-FR', {
            dateStyle: 'short'
        });
    }

    function deleteHandleClick(pk){
        deleteOperation(pk).then(() => {
            router.go(0);
        });
    }
            
</script>

<style scoped>

    .fieldList 
    {
        grid-row: 2 / 24;
        grid-column: 2 / 48;
    }

    .fielAddList 
    {
        grid-row: 25 / 49;
        grid-column: 2 / 29;
    }

    .countOperation
    {
        grid-row: 25 / 49;
        grid-column: 30 / 48;
    }

    .fieldRow
    {
        width: 95%;
        min-height: 40px;
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

    .fieldRow > div > p, select, button
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
        background-color: transparent;
        border: none;
    }
    .editButton:hover 
    {
        cursor: pointer;
    }

    .deleteButton 
    {
        color: red !important;
        text-decoration: none;
        font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
        font-optical-sizing: auto;
        font-weight: 100;
        font-style: normal;
        font-size: 20px;
        word-spacing: 1px;
        transition-duration: .125s;
    }

    .countOperation div 
    {
        display: flex;
        align-items: center;
        justify-content: center;

        width: 100%;
        height: 100%;
    }

    .countText 
    {
        color: var(--main-green);
        font-size: 15em;
        font-weight: 900;
    }

    .completed
    {
        opacity: .6;
        text-decoration: line-through;
        text-decoration-color: var(--main-title-gray);

    }

    .realised
    {
        color: var(--main-green) !important;
    }

    .formAdd 
    {
        width: 75%;
        height: 65%;

        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-template-rows: repeat(2, 1fr);
    }

    select 
    {
        grid-row: 2;
        grid-column: 1;
        margin: 0 !important;

        width: 100%;
        background-color: transparent;
        border: none;
        border-bottom: solid 1px var(--main-title-gray);
        color: var(--main-green);
    }

    .addButton
    {
        display: flex;
        align-items: flex-start;
        justify-content: center;
    }

     .typeAdd 
    {
        width: 100%;
        height: 100%;

        display: flex;
        align-items: center;
        justify-content: center;

    }
</style>