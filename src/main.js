
import { createMemoryHistory, createRouter } from 'vue-router'
import VueApexCharts from "vue3-apexcharts";
import { createApp } from 'vue'
import routes from './routes'
import App from './App.vue'

const router = createRouter({
    history: createMemoryHistory(),
    routes,
})

const app = createApp(App);
app.use(router);
app.use(VueApexCharts);
app.mount('#app');



