import resume from '../../api/resume'
import user from '../../api/user'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'

const state = {
    title: '',
    content: ''
}

const getters = {
    feedbackTitle: state => state.title,
    feedbackContent: state => state.content
}

const actions = {
    loadInviteDetail({ commit }, data) {
        Indicator.open()
        resume.feedbackDetail(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('LOAD_INVITE_DETAIL_SUCCESS', res.data.detail)
            } else {
                commit('LOAD_INVITE_DETAIL_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_INVITE_DETAIL_FAIL', { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.LOAD_INVITE_DETAIL_SUCCESS](state, data) {
        state.title = data.title
        state.content = data.content
    },
    [types.LOAD_INVITE_DETAIL_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}
