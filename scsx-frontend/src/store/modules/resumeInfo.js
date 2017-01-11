import resume from '../../api/resume'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'

const state = {
    username: '',
    email: '',
    tel: '',
    age: '',
    gender: 0,
    skills: '',
    work: '',
    project: '',
    school: ''
}

const getters = {
    usernameRI: state => state.username,
    emailRI: state => state.email,
    telRI: state => state.tel,
    age: state => state.age,
    gender: state => state.gender,
    skills: state => state.skills,
    work: state => state.work,
    project: state => state.project,
    school: state => state.school
}

const actions = {
    loadResumeInfo({ commit }, data) {
        Indicator.open()
        resume.fetchResume(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('LOAD_RESUME_INFO_SUCCESS', res.data.resume)
            } else {
                commit('LOAD_RESUME_INFO_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_RESUME_INFO_FAIL', { errorMsg: 'error' })
        })
    },
    saveResume({ commit }, ) {
        MessageBox.alert('保存成功！')
    }
}

const mutations = {
    [types.LOAD_RESUME_INFO_SUCCESS](state, data) {
        state.username = data.name
        state.email = data.email
        state.tel = data.number
        state.age = data.age
        state.gender = data.gender
        state.skills = data.skillLabel
        state.work = data.company
        state.project = data.companyContent
        state.school = data.school
    },
    [types.LOAD_RESUME_INFO_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    getters,
    actions,
    mutations
}
