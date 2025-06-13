import {createRouter, createWebHistory} from "vue-router";
import HelloWorld from "./components/HelloWorld.vue";
import SSEComponent from "@/components/SSEComponent.vue";

const links = [
    {
        path:"/",
        name:"Home",
        component: HelloWorld,
    },
    {
        path:"/sse",
        name:"SSE",
        component: SSEComponent,
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes: links,
})

export default router;