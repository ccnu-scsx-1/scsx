import resume from '../../api/resume'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'

const state = {
    resumeName: '',
    resumeEmail: '',
    resumeTel: '',
    resumeAge: '',
    resumeGender: 0,
    resumeEdu: '',
    resumeCom: '',
    resumeProject: '',
    resumeSkill: ''
}


const actions = {
    loadResume({ commit }, data) {
        Indicator.open()
        resume.fetchResume(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                if(res.data.resume){
                    commit('LOAD_RESUME_SUCCESS', res.data.resume)
                }
            } else {
                commit('LOAD_RESUME_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_RESUME_FAIL', { errorMsg: 'error' })
        })
    },
    saveResume({ commit, state }, { userId }) {
        Indicator.open()
        resume.saveResume({
            userId,
            name: state.resumeName,
            email: state.resumeEmail,
            number: state.resumeTel,
            age: state.resumeAge,
            gender: state.resumeGender,
            school: state.resumeEdu,
            company: state.resumeCom,
            companyContent: state.resumeProject,
            skillLabel: state.resumeSkill
        }).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('SAVE_RESUME_SUCCESS', res.data)
            } else {
                commit('SAVE_RESUME_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('SAVE_RESUME_FAIL', { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.LOAD_RESUME_SUCCESS](state, data) {
        state.resumeName = data.name
        state.resumeEmail = data.email
        state.resumeTel = data.number
        state.resumeAge = data.age
        state.gender = data.gender
        state.resumeEdu = data.school
        state.resumeCom = data.company
        state.resumeProject = data.companyContent
        state.resumeSkill = data.skillLabel
    },
    [types.LOAD_RESUME_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    },
    [types.SAVE_RESUME_SUCCESS](state) {
        Toast('保存成功！')
        router.go(-1)
    },
    [types.SAVE_RESUME_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    actions,
    mutations
}
