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
    education: state => state.education,
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
    loadJobDetail({ commit }, data ){
        Indicator.open()
        recuit.jobDetail(data).then( response => {
            Indicator.close()
            let res = response.data
            if(res.status === '0'){
                commit('LOAD_JOB_DETAIL_SUCCESS', res.data)
            }else{
                commit('LOAD_JOB_DETAIL_FAIL', { errorMsg:res.msg })
            }
        }).catch( error=> {
            Indicator.close()
            commit('LOAD_JOB_DETAIL_FAIL', { errorMsg: 'error' })
        })
    },
    voteResume({ commit, state}){
        if(!state.loginStatus){
            commit('NOT_LOGIN')
        }else{

        }

    }
}

const mutations = {
    [types.LOAD_JOB_DETAIL_SUCCESS](state, data){
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
    [types.LOAD_JOB_DETAIL_FAIL](state, { errorMsg }){
        MessageBox.alert(errorMsg)
    },
    [types.NOT_LOGIN](state){
        MessageBox.alert('您尚未登录，请先登录！').then(action =>{
            router.push('/login')
        })
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}