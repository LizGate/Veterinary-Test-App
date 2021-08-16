import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Product from "@/views/Product";
import ProductDetail from "@/views/ProductDetail";

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/customers',
        name: 'Customers',
        component: Customers
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
