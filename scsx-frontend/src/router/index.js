import VueRouter from 'vue-router'
//views
import Login from '../views/Login'
import Home from '../views/Home'
import Register from '../views/Register'
import Market from '../views/Market'

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
        path: '/register',
        component: Register,
        title: '注册'
    },{
        path: '/market',
        component: Market,
        title: '求职市场'
    },{
       path: '*',
       redirect: '/home'
    }
    ]
})

router.beforeEach((route, redirect, next) => {
  document.title = route.meta.title || document.title;
  next();
});

export default router
