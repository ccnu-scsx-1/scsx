import user from '../../api/user'
import * as types  from  '../mutations-types'
import { Indicator, MessageBox } from 'mint-ui'

const state = {
   loginStatus: false, 
   username: '',
   userid: '',
   showIndicator: false,
   errorMsg: ''
}

const getters = {
    showIndicator: state => state.showIndicator,
    errorMsg: state => state.errorMsg
}

const actions = {
    login({ commit, state}, data){
        Indicator.open()
        user.login(data).then( response => {
            Indicator.close()
            if(res.status === '0'){
                commit(types.LOGIN_SUCCESS, { 
                    id: res.data.id, 
                    name: res.data.name 
                })
            }else{
                commit(types.LOGIN_FAIL, { errorMsg: response.data.errorMsg })
            }
        }).catch( error => {
            Indicator.close()
            commit(types.LOGIN_FAIL, { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.LOGIN_SUCCESS](state, { id, name}){
        state.userid = id
        state.username = name
        state.loginStatus = true
    },
    [types.LOGIN_FAIL](state, { errorMsg }){
        state.loginStatus = false
        state.errorMsg = errorMsg
        MessageBox.alert(errorMsg)
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}