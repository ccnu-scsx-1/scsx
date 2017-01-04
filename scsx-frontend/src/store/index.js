import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'
import mutations from './mutations'
//modules


Vue.use(Vuex)

const state = {
    isLogin: false,
    username: '',
    userid: ''
}

export default new Vuex.Store({
    state,
    mutations,
    actions,
    modules: {

    }
})
