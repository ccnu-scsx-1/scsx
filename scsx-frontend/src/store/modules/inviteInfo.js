import resume from '../../api/resume'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'
import { formatSalary } from '../../util/format'

const state = {
    inviteInfoResult: []
}

const getters = {
    inviteInfoResult: state => {
        let arr = state.inviteInfoResult

        if (arr && arr[0]) {
            arr.forEach(obj => {
                obj.result = obj.result ? '已通过' : '未通过'
            })
        }

        return arr
    }
}

const actions = {
    feedbackList({ commit }, data) {
        Indicator.open()
        resume.feedbackList(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                if (res.data.feedList[0]) {
                    commit('LOAD_VOTE_INFO_LIST_SUCCESS', { feedList: res.data.feedList })
                }
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
    [types.LOAD_VOTE_INFO_LIST_SUCCESS](state, { feedList }) {
        state.inviteInfoResult = feedList
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
