import recruit from '../../api/recruit'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'

const state = {
    voteInfoResult: []
}

const getters = {
    voteInfoResult: state => state.voteInfoResult
}

const actions = {
    fetchVoteInfoList({ commit }, data) {
        Indicator.open()
        recruit.fetchVoteInfoList(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('LOAD_RESUME_POOL_SUCCESS', { list: res.data.list })
            } else {
                commit('LOAD_RESUME_POOL_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_RESUME_FAIL', { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.LOAD_RESUME_POOL_SUCCESS](state, { list }) {
        
    },
    [types.LOAD_RESUME_POOL_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    getters,
    actions,
    mutations
}
