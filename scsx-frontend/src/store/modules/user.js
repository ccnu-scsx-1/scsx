import user from '../../api/user'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import Validator from '../../util/validator'
import router from '../../router'

const state = {
    loginStatus: false,
    username: '',
    userid: '',
    menuClass: 'user',
    role: 0
}

const getters = {
    loginStatus: state => state.loginStatus,
    menuClass: state => state.menuClass,
    username: state => state.username
}

const actions = {
    login({ commit, state}, data) {
        if (Validator.isEmpty(data.name) || Validator.isEmpty(data.password)) {
            MessageBox.alert('用户名或密码不能为空！')
            return
        }
        Indicator.open()
        user.login(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit(types.LOGIN_SUCCESS, {
                    id: res.data.id,
                    name: res.data.name,
                    role: data.role
                })
            } else {
                commit(types.LOGIN_FAIL, { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit(types.LOGIN_FAIL, { errorMsg: 'error' })
        })
    },
    logout({ commit }){
        user.logout().then( response => {
            let res = response.data
            if(res.status === '0'){
                commit('LOGOUT_SUCCESS')
            }else{
                commit('LOGOUT_FAIL', { errorMsg: res.msg })
            }
        })
    },
    logStatus({ commit }){
        user.status().then(response => {
            let res = response.data
            if(res.status === '0'){
                commit('HAS_LOGIN', res.data)
            }else{
                commit('NOT_LOGIN')
            }
        })
    },
    register({ commit }, data) {
        if (Validator.isEmpty(data.name)) {
            MessageBox.alert('用户名不能为空！')
            return
        }

        if (!Validator.isEmail(data.email)) {
            MessageBox.alert('请填写正确的邮箱！')
            return
        }

        if (!Validator.isTel(data.number)) {
            MessageBox.alert('请填写正确的手机号码！')
            return
        }

        if (!Validator.isNumeric(data.age)) {
            MessageBox.alert('请填写正确的年龄！')
            return
        }

        if (Validator.isEmpty(data.password) || Validator.isEmpty(data.rpassword)) {
            MessageBox.alert('请填写密码！')
            return
        }

        if (!Validator.isEqual(data.password, data.rpassword)) {
            MessageBox.alert('两次输入的密码不一致！请重新输入。')
            return
        }
        Indicator.open()
        delete data.rpassword
        delete data.motto
        user.register({ "user": data }).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit(types.REGISTER_SUCCESS)
            } else {
                commit(types.REGISTER_FAIL, { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit(types.REGISTER_FAIL, { errorMsg: 'error' })
        })
    },
    registerCom({ commit }, data) {
        if (Validator.isEmpty(data.username)) {
            MessageBox.alert('用户名不能为空！')
            return
        }

        if (Validator.isEmpty(data.name)) {
            MessageBox.alert('公司名不能为空！')
            return
        }

        if (!Validator.isEmail(data.email)) {
            MessageBox.alert('请填写正确的邮箱！')
            return
        }

        if (Validator.isEmpty(data.tel)) {
            MessageBox.alert('联系方式不能为空！')
            return
        }

        if (Validator.isEmpty(data.address)) {
            MessageBox.alert('公司地址不能为空！')
            return
        }

        if (Validator.isEmpty(data.introduction)) {
            MessageBox.alert('公司介绍不能为空！')
            return
        }

        if (Validator.isEmpty(data.password) || Validator.isEmpty(data.rpassword)) {
            MessageBox.alert('请填写密码！')
            return
        }

        if (!Validator.isEqual(data.password, data.rpassword)) {
            MessageBox.alert('两次输入的密码不一致！请重新输入。')
            return
        }

        let userObj = {
            "name": data.username,
            "role": data.role,
            "password": data.password
        }

        delete data.username
        delete data.role
        delete data.password
        delete data.rpassword

        Indicator.open()

        user.register({ "user": userObj, "company": data }).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit(types.REGISTER_COM_SUCCESS)
            } else {
                commit(types.REGISTER_COM_FAIL, { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit(types.REGISTER_COM_FAIL, { errorMsg: 'error' })
        })
    },
    changeMenu({ commit, state}, { className }){
        state.menuClass = className
    },
    updatePassword({ commit },){

    }
}

const mutations = {
    [types.LOGIN_SUCCESS](state, { id, name, role}) {
        state.userid = id
        state.username = name
        state.loginStatus = true
        state.role = role
        router.push('/market')
    },
    [types.LOGIN_FAIL](state, { errorMsg }) {
        state.loginStatus = false
        MessageBox.alert(errorMsg)
    },
    [types.REGISTER_SUCCESS](state) {
        Toast('注册成功！')
        router.push('/login')
    },
    [types.REGISTER_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    },
    [types.REGISTER_COM_SUCCESS](state) {
        Toast('注册成功！')
        router.push('/login')
    },
    [types.REGISTER_COM_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    },
    [types.LOGOUT_SUCCESS](state){
        state.userid = ''
        state.username = ''
        state.loginStatus = false
        state.menuClass = 'user'
        router.push('/')
    },
    [types.LOGOUT_FAIL](state, { errorMsg }){
        MessageBox.alert(errorMsg)
    },
    [types.NOT_LOGIN](state){
        MessageBox.alert('您尚未登录，请先登录！').then(action =>{
            router.push('/login')
        })
    },
    [types.HAS_LOGIN](state, data){
        state.userid = data.userId,
        state.username = data.userName,
        state.role = data.role
        state.loginStatus = true
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}
