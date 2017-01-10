import resume from '../../api/resume'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'

const state = {
    username: '',
    email: '',
    tel: '',
    age: '',
    gender: '',
    role: 0
}


const actions = {
    loadRegisterInfo({ commit }, data) {
        Indicator.open()
        resume.fetchResume(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('LOAD_RESUME_SUCCESS', res.data)
            } else {
                commit('LOAD_RESUME_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_RESUME_FAIL', { errorMsg: 'error' })
        })
    },
    updateReigsterInfo({ commit }, ) {
        MessageBox.alert('保存成功！')
    }
}

const mutations = {
    [types.LOAD_RESUME_SUCCESSC](state, data) {

    },
    [types.LOAD_RESUME_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    actions,
    mutations
}
