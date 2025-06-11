<template>
    <Card class="fieldList" title="Liste des champs">
        <template v-slot:main>
            <div class="fieldRow">
                <div></div>
                <div>
                    <p class="editButton">Nom du champ</p>
                </div>
                <div>
                    <p class="editButton">Surface</p>
                </div>
                <div>
                    <p class="editButton">Type de sol</p>                                        
                </div>
                <div>
                    <p class="editButton">PH moyen du sol</p>
                </div>
                <div>
                </div>
            </div>
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
                    <a href="#" class="deleteButton" @click.prevent="deleteHandleClick(field.id)" @click="show()">Supprimer</a>
                    <button class="editButton" type="submit" @click="changeDisplay(field.id, field.label, field.surface, field.typeSol.label)">Modifier</button>
                </div>
            </div>
        </template>
    </Card>
    <Card class="fieldAddList" title="Ajouter des champs">
        <template v-slot:main>  
            <div class="typeAdd">
                <form class="formAdd" @submit.prevent="addHandleClick(fieldLabel, fieldSurface, idOwner, idTypeSol, idDomain)">
                    <div>
                        <input type="text" placeholder="Label" v-model="fieldLabel">
                    </div>
                    <div>
                        <input type="number" placeholder="Surface" v-model="fieldSurface">
                    </div>
                    <div>
                        <select v-model="idTypeSol">
                            <option :value="idTypeSol" selected disabled hidden>Choisissez le type de sol</option>
                            <option :value="`${type.id}`" v-for="type in allGroundType">
                                {{ type.label }}
                            </option>
                        </select>
                    </div>
                    <div class="addButton">
                        <button class="editButton" type="submit">Ajouter</button>
                    </div>
                </form>
            </div>            
        </template>
    </Card>
    <Card class="countList" title="Nombre de champs">
        <template v-slot:main>
            <div>
                <p class="countText">
                    {{ countField }}      
                </p>                 
            </div> 
        </template>
    </Card>
    <div class="board" v-if="displayBoolean">
        <Card title="Modification champ" class="test">
            <template v-slot:main>
                <form class="formAdd" @submit.prevent="updateHandleClick(currentIdField, fieldLabel, fieldSurface, idTypeSol)">
                    <div>
                        <input type="text" :placeholder="`${currentField}`" v-model="fieldLabel">
                    </div>
                    <div>
                        <input type="number" :placeholder="`${currentSurface}`" v-model="fieldSurface">
                    </div>
                    <div>
                        <select v-model="idTypeSol">
                            <option :value="idTypeSol" selected disabled hidden>{{ currentGroundType }}</option>
                            <option :value="`${type.id}`" v-for="type in allGroundType">
                                {{ type.label }}
                            </option>
                        </select>
                    </div>
                    <div class="addButton">
                        <button class="editButton" type="submit">Modifier</button>
                    </div>
                </form>
            </template>            
        </Card>
    </div>
</template>

<script setup>

    import { ref, onMounted } from 'vue'
    import { useRouter } from 'vue-router'
    import { getAllField, deleteFieldById, getAllGroundType, updateField, addField } from '../../services/fieldServices'
    import Card from '../../components/Card.vue'

    const allField = ref([]);   
    const allGroundType = ref([]);
    const router = useRouter('');
    const countField = ref('');
    const idOwner = ref(JSON.parse(atob(document.cookie.split('.')[1])).id);
    const idDomain = ref(JSON.parse(atob(document.cookie.split('.')[1])).idDomain);
    const displayBoolean = ref(false);
    const currentField = ref('');
    const currentSurface = ref('');
    const currentGroundType = ref('');
    const currentIdField = ref('');
    


    onMounted(() => {
        getAllGroundType().then((response) => {
            allGroundType.value = response;  
        });            
        getAllField(JSON.parse(atob(document.cookie.split('.')[1])).id).then(
            (response) => {
                allField.value = response;
                countField.value =  allField.value.length;            
            }
        );
    });

    function deleteHandleClick(id){
        deleteFieldById(id).then(() => {
            router.go(0);
        });
    }

    function changeDisplay(id, fieldLabel, fieldSurface, fieldGroundType){
        displayBoolean.value = true;
        currentIdField.value = id;
        currentField.value = fieldLabel;
        currentSurface.value = fieldSurface;
        currentGroundType.value = fieldGroundType;
    }

    function updateHandleClick(id, label, surface, type){
        updateField(id, label, surface, type).then(() => {
            router.go(0);
        });
    }

    function addHandleClick(label, surface, idOwner, typeSol, idDomaine){
        addField(label, surface, idOwner, typeSol, idDomaine).then(() => {
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

    .fieldAddList
    {
        grid-row: 25 / 49;
        grid-column: 2 / 29;
    }

    .countList 
    {
        grid-row: 25 / 49;
        grid-column: 30 / 48;
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

    .editButton:hover
    {
        cursor: pointer;
    }

    .deleteButton
    {
        color: red !important;
    }

    .fieldRow input, button, select
    {
        background-color: transparent;
        border: none;

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

    .fieldRow input:focus 
    {
        outline: none;
        border: none;
    }

    .fieldRow button, select:hover 
    {
        cursor: pointer;
    }

    .countList div 
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

    .typeAdd 
    {
        width: 100%;
        height: 100%;

        display: flex;
        align-items: center;
        justify-content: center;

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

    .board
    {
        display: grid;
        grid-template-columns: repeat(9, 1fr);
        grid-template-rows: repeat(9, 1fr);

        position: absolute;
        top: 0;
        left: 0;
        width: 100vw;
        height: 100vh;

        background-color: rgba(0, 0, 0, .6);
    }

    .board > .test
    {
        grid-row: 2 / 8;
        grid-column: 4 / 7;
        
    }

    .board > .test .formAdd 
    {
        width: 50%;
        height: 100%;

        gap: 60px;
        display: flex;
        flex-direction: column;
        align-content: center;
        justify-content: center;
    }

    .board > .test .formAdd input 
    {
        width: 100%;
    }
</style>
