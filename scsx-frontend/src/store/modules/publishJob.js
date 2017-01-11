import recruit from '../../api/recruit'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import router from '../../router'
import Validator from '../../util/validator'

const state = {
}

const getters = {
}

const actions = {
    publishJob({ commit }, data) {
        if(Validator.isEmpty(data.userId)){
            commit('NOT_LOGIN')
            return
        }
        if(Validator.isEmpty(data.title)){
            MessageBox.alert('岗位名不能为空')
            return
        }
        if(!Validator.isNumeric(data.salaryLow)){
            MessageBox.alert('请输入正确的最低薪资!')
            return
        }
        if(!Validator.isNumeric(data.salaryHigh)){
            MessageBox.alert('请输入正确的最高薪资!')
            return
        }

        if(Number(data.salaryLow) > Number(data.salaryHigh)){
            MessageBox.alert('最低薪资不能高于最高薪资')
            return
        }

        if(Validator.isEmpty(data.region)){
            MessageBox.alert('请输入正确的工作地点！')
            return
        }
        if(Validator.isEmpty(data.education)){
            MessageBox.alert('请输入正确的学历要求！')
            return
        }
        if(Validator.isEmpty(data.yearWork)){
            MessageBox.alert('请输入正确的工作年限！')
            return
        }

        if(Validator.isEmpty(data.description)){
            MessageBox.alert('请输入正确的职位描述！')
            return
        }

        Indicator.open()
        recruit.publishJob(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('PUBLISH_JOB_SUCCESS', { list: res.data })
            } else {
                commit('PUBLISH_JOB_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('PUBLISH_JOB_FAIL', { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.PUBLISH_JOB_SUCCESS](state, { list }) {
        MessageBox.alert('发布岗位成功！').then(action => {
            router.go(-1)
        })
    },
    [types.PUBLISH_JOB_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    getters,
    actions,
    mutations
}
