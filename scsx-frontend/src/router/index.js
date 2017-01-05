import VueRouter from 'vue-router'
//views
import Login from '../views/Login'
import Home from '../views/Home'
import Register from '../views/Register'
import RegisterCom from '../views/RegisterCom'
import Market from '../views/Market'
import JobDetail from '../views/JobDetail'
import UserInfo from '../views/UserInfo'
import Resume from '../views/Resume'
import Settings from '../views/Settings'

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
        title: '求职注册'
    },{
        path: '/registercom',
        component: RegisterCom,
        title: '企业注册'
    },{
        path: '/market',
        component: Market,
        title: '求职市场'
    },{
        path: '/jobdetail',
        component: JobDetail,
        title: '职位详情'
    },{
        path: '/userinfo',
        component: UserInfo,
        title: '个人信息'
    },{
        path: '/resume',
        component: Resume,
        title: '个人简历'
    },{
        path: '/settings',
        component: Settings,
        title: '注册信息'
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
