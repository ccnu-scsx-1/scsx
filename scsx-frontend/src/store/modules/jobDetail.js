import recuit from '../../api/recruit'
import user from '../../api/user'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'
import { formatSalary } from '../../util/format'

const state = {
    infoId: '',
    companyId: '',
    title: '',
    salaryHigh: '',
    salaryLow: '',
    region: '',
    yearWork: '',
    education: '',
    name: '',
    address: '',
    tel: '',
    email: '',
    description: ''
}

const getters = {
    title: state => state.title,
    region: state => state.region,
    yearWork: state => state.yearWork,
    education: state => {
        let edu = ''
        switch (state.education) {
            case 0:
                edu = '专科';
                break;
            case 1:
                edu = '本科';
                break;
            case 2:
                edu = '硕士';
                break;
            case 3:
                edu = '博士';
                break;
            default:
                break;
        }
        return edu
    },
    name: state => state.name,
    address: state => state.address,
    tel: state => state.tel,
    email: state => state.email,
    description: state => state.description,
    salary: state => {
        return formatSalary(state.salaryLow, state.salaryHigh)
    }
}

const actions = {
    loadJobDetail({ commit }, data) {
        Indicator.open()
        recuit.jobDetail(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('LOAD_JOB_DETAIL_SUCCESS', res.data)
            } else {
                commit('LOAD_JOB_DETAIL_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_JOB_DETAIL_FAIL', { errorMsg: 'error' })
        })
    },
    voteResume({ commit, state }, data) {
        if (!data.loginStatus) {
            commit('NOT_LOGIN')
        } else {
            delete data.loginStatus
            user.voteResume(data).then(response => {
                let res = response.data
                if (res.status === '0') {
                    commit('VOTE_RESUME_SUCCESS')
                } else {
                    commit('VOTE_RESUME_FAIL', { errorMsg: res.msg })
                }
            }).catch(error => {
                Indicator.close()
                commit('VOTE_RESUME_FAIL', { errorMsg: 'error' })
            })
        }
    }
}

const mutations = {
    [types.LOAD_JOB_DETAIL_SUCCESS](state, data) {
        state.title = data.infoDetail.title
        state.salaryHigh = data.infoDetail.salaryHigh
        state.salaryLow = data.infoDetail.salaryLow
        state.region = data.infoDetail.region
        state.yearWork = data.infoDetail.yearWork
        state.description = data.infoDetail.description
        state.education = data.infoDetail.education
        state.name = data.company.name
        state.address = data.company.address
        state.tel = data.company.tel
        state.email = data.company.email
    },
    [types.LOAD_JOB_DETAIL_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    },
    [types.NOT_LOGIN](state) {
        MessageBox.alert('您尚未登录，请先登录！').then(action => {
            router.push('/login')
        })
    },
    [types.VOTE_RESUME_SUCCESS](state) {
        Toast('投递成功！')
        router.push('/market')
    },
    [types.VOTE_RESUME_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}
