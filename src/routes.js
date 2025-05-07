import Domains from './pages/Domains.vue';
import Field from './pages/FIeld.vue';
import Home from './pages/Home.vue'
import Treatment from './pages/Treatment.vue';
import Workers from './pages/Workers.vue';

const route = [
    { path : '/', component : Home },
    { path : '/field', component : Field },
    { path : '/workers', component : Workers },
    { path : '/domains', component : Domains },
    { path : '/treatment', component : Treatment }
];

export default route;