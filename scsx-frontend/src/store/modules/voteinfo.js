import recruit from '../../api/recruit'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'
import { formatSalary } from '../../util/format'

const state = {
    voteInfoResult: []
}

const getters = {
    voteInfoResult: state => {
        let result = state.voteInfoResult

        if (result && result[0]) {
            result.forEach(obj => {
                obj.salary = formatSalary(obj.salary_low, obj.salary_high)
            })
        }
        return result 
    }
}

const actions = {
    fetchVoteInfoList({ commit }, data) {
        Indicator.open()
        recruit.fetchVoteInfoList(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('LOAD_VOTE_INFO_LIST_SUCCESS', { infos: res.data.infos })
            } else {
                commit('LOAD_VOTE_INFO_LIST_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_VOTE_INFO_LIST_FAIL', { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.LOAD_VOTE_INFO_LIST_SUCCESS](state, { infos }) {
        state.voteInfoResult = infos
    },
    [types.LOAD_VOTE_INFO_LIST_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}


export default {
    state,
    getters,
    actions,
    mutations
}