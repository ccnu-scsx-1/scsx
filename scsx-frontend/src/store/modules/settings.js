import user from '../../api/user'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import Validator from '../../util/validator'
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
        user.fetchUserInfo(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('LOAD_REGISTER_INFO_SUCCESS', res.data.info)
            } else {
                commit('LOAD_REGISTER_INFO_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('LOAD_REGISTER_INFO_FAIL', { errorMsg: 'error' })
        })
    },
    updateReigsterInfo({ commit, state}, { id }) {
        if (Validator.isEmpty(state.username)) {
            MessageBox.alert('用户名不能为空！')
            return
        }

        if (!Validator.isEmail(state.email)) {
            MessageBox.alert('请填写正确的邮箱！')
            return
        }

        if (!Validator.isTel(state.tel)) {
            MessageBox.alert('请填写正确的手机号码！')
            return
        }

        if (!Validator.isNumeric(state.age)) {
            MessageBox.alert('请填写正确的年龄！')
            return
        }

        Indicator.open()
        user.updateUserInfo({
            id,
            name: state.name,
            email: state.email,
            gender: state.gender,
            age: state.age,
            number: state.tel
        }).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit('UPDATE_REGISTER_INFO_SUCCESS')
            } else {
                commit('UPDATE_REGISTER_INFO_FAIL', { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit('UPDATE_REGISTER_INFO_FAIL', { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.LOAD_REGISTER_INFO_SUCCESS](state, data) {
        state.username = data.name
        state.age = data.age
        state.email = data.email
        state.tel = data.number
        state.gender = data.gender === '男' ? 0 : 1
    },
    [types.LOAD_REGISTER_INFO_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    },
    [types.UPDATE_REGISTER_INFO_SUCCESS](state){
        MessageBox.alert('保存成功！').then(action => {
            router.go(-1)
        })
    },
    [types.UPDATE_REGISTER_INFO_FAIL](state, { errorMsg }){
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    actions,
    mutations
}
