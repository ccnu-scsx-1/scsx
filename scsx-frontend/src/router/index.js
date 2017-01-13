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
import ComSettings from '../views/ComSettings'
import UpdatePassword from '../views/UpdatePassword'
import Employment from '../views/Employment'
import PublishJob from '../views/PublishJob'
import EditJob from '../views/EditJob'
import VoteInfo from '../views/VoteInfo'
import InviteInfo from '../views/InviteInfo'
import InviteDetail from '../views/InviteDetail'
import ResumePool from '../views/ResumePool'
import ResumeInfo from '../views/ResumeInfo'
import ResumeFeedback from '../views/ResumeFeedback'

const router = new VueRouter({
    mode: 'history',
    base: '/scsx/page',
    routes: [{
        path: '/home',
        component: Home,
        title: '主页'
    }, {
        path: '/login',
        component: Login,
        title: '登录'
    }, {
        path: '/register',
        component: Register,
        title: '求职注册'
    }, {
        path: '/registercom',
        component: RegisterCom,
        title: '企业注册'
    }, {
        path: '/market',
        component: Market,
        title: '求职市场'
    }, {
        path: '/jobdetail',
        component: JobDetail,
        title: '职位详情'
    }, {
        path: '/userinfo',
        component: UserInfo,
        title: '个人信息'
    }, {
        path: '/resume',
        component: Resume,
        title: '个人简历'
    }, {
        path: '/settings',
        component: Settings,
        title: '注册信息'
    }, {
        path: '/comsettings',
        component: ComSettings,
        title: '公司信息'
    }, {
        path: '/updatepassword',
        component: UpdatePassword,
        title: '密码修改'
    }, {
        path: '/employment',
        component: Employment,
        title: '招聘岗位'
    }, {
        path: '/publishjob',
        component: PublishJob,
        title: '发布岗位'
    }, {
        path: '/editjob',
        component: EditJob,
        title: '编辑岗位'
    }, {
        path: '/voteinfo',
        component: VoteInfo,
        title: '投递信息'
    }, {
        path: '/inviteinfo',
        component: InviteInfo,
        title: '邀约信息'
    },{
        path: '/invitedetail',
        component: InviteDetail,
        title: '邀约信息详情'
    },{
        path: '/resumepool',
        component: ResumePool,
        title: '简历池'
    },{
        path: '/resumeinfo',
        component: ResumeInfo,
        title: '简历信息'
    },{
        path: '/resumefeedback',
        component: ResumeFeedback,
        title: '回复简历'
    },{
        path: '*',
        redirect: '/home'
    }]
})

router.beforeEach((route, redirect, next) => {
    document.title = route.meta.title || document.title;
    next();
});

export default router
