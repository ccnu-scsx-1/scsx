import VueRouter from 'vue-router'
//views
import Login from '../views/Login'
import Home from '../views/Home'

const router = new VueRouter({
    mode: 'history',
    routes: [{
        path: '/home',
        component: Home,
        title: '主页'
    },{
        path: '/login',
        component: Login,
        title: '登录'
    },{
       path: '*',
       redirect: '/login'
    }
    ]
})

// router.beforeEach((route, redirect, next) => {
//   document.title = route.meta.title || document.title;
//   next();
// });

export default router
