import resume from '../../api/resume'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import Validator from '../../util/validator'
import router from '../../router'

const state = {

}

const getters = {

}


const actions = {
    saveResumeFeedback({ commit, state }, data) {
        if(Validator.isEmpty(data.title)){
            MessageBox.alert('请输入标题！')
            return
        }

        if(Validator.isEmpty(data.content)){
            MessageBox.alert('请输入内容！')
            return
        }

        Indicator.open()
        resume.feedbackResume(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('SAVE_RESUME_FEEDBACK_SUCCESS', res.data)
            } else {
                commit('SAVE_RESUME_FEEDBACK_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('SAVE_RESUME_FEEDBACK_FAIL', { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.SAVE_RESUME_FEEDBACK_SUCCESS](state) {
        Toast('保存成功！')
        router.push('/resumepool')
    },
    [types.SAVE_RESUME_FEEDBACK_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    getters,
    actions,
    mutations
}
