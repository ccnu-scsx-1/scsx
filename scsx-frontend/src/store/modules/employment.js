import user from '../../api/user'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'

const state = {
    jobList: []
}

const getters = {
    jobList: state => state.jobList
}

const actions = {
    loadJobList({ commit }, data) {
        Indicator.open()
        user.loadPublishJobList(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('LOAD_JOB_LIST_SUCCESS', { list: res.data })
            } else {
                commit('LOAD_JOB_LIST_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_JOB_LIST_FAIL', { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.LOAD_JOB_LIST_SUCCESS](state, { list }) {
        state.jobList = list
    },
    [types.LOAD_JOB_LIST_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    getters,
    actions,
    mutations
}
