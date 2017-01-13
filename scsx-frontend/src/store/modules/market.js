import recruit from '../../api/recruit'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'
import { formatSalary } from '../../util/format'


const state = {
    searchValue: '',
    searchResult: []
}

const getters = {
    searchResult: state => {
        let result = state.searchResult

        if (result && result[0]) {
            result.forEach(obj => {
                obj.salary = formatSalary(obj.salary_low, obj.salary_high)
            })
        }

        return result
    }
}

const actions = {
    getInfoList({ commit }, data) {
        Indicator.open()
        recruit.infoList(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit(types.MARKET_JOB_LIST_SUCCESS, { infos: res.data.infos })
            } else {
                commit(types.MARKET_JOB_LIST_FAIL, { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit(types.MARKET_JOB_LIST_FAIL, { errorMsg: 'error' })
        })
    },
    searchBytitle({ commit }, data) {
        Indicator.open()
        recruit.searchBytitle(data).then(response => {
            Indicator.close()
            let res = response.data
            if (res.status === '0') {
                commit(types.MARKET_JOB_SEARCH_SUCCESS, { searchValue: data.title, infos: res.data.infos })
            } else {
                commit(types.MARKET_JOB_SEARCH_FAIL, { errorMsg: res.msg })
            }
        }).catch(error => {
            Indicator.close()
            commit(types.MARKET_JOB_SEARCH_FAIL, { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.MARKET_JOB_LIST_SUCCESS](state, { infos }) {
        state.searchResult = infos
    },
    [types.MARKET_JOB_LIST_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    },
    [types.MARKET_JOB_SEARCH_SUCCESS](state, { searchValue, infos }) {
        state.searchValue = searchValue
        state.searchResult = infos
    },
    [types.MARKET_JOB_SEARCH_FAIL](state, { errorMsg }) {
        MessageBox.alert(errorMsg)
    }

}

export default {
    state,
    getters,
    actions,
    mutations
}
