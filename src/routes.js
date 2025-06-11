import Unauthorized from './pages/errors/Unauthorized.vue';
import Field from './pages/_admin/Field.vue';
import Home from './pages/_admin/Home.vue'
import Login from './pages/Login.vue';
import Inscription from './pages/Inscription.vue';
import Treatment from './pages/_admin/Treatment.vue';
import Workers from './pages/_admin/Workers.vue';
import UserHome from './pages/_users/UserHome.vue';

const route = [
    { path : '/', name: 'login', component : Login },
    { path : '/inscription', name: 'inscription', component : Inscription },
    { path : '/home', name: 'home', component : Home, meta: {
            requireRole : 'admin'
    } },
    { path : '/field', name: 'field', component : Field, meta: {
            requireRole : 'admin'
    }},
    { path : '/workers', name: 'workers', component : Workers, meta: {
            requireRole : 'admin'
    }},
    { path : '/treatment', name: 'treatment', component : Treatment, meta: {
            requireRole : 'admin'
    }}, 
    { path : '/userHome', name: 'userHome', component : UserHome, meta: {
            requireRole : 'utilisateur'
    } },    
    { path : '/unauthorized', name: 'unauthorized', component : Unauthorized }
];

export default route;