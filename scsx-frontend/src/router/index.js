import VueRouter from 'vue-router'
//views
import Home from '../views/Home'

const router = new VueRouter({
    mode: 'history',
    routes: [{
        path: '/home',
        component: Home,
        title: '主页'
    },{
       path: '*',
       redirect: '/home'
    }
    ]
})

export default router
