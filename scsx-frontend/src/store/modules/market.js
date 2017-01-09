import market from '../../api/market'
import * as types from '../mutations-types'
import { Indicator, MessageBox, Toast } from 'mint-ui'

const state = {
    
}

const getters = {

}

const actions = {
    getInfoList({ commit }, data){
        Indicator.open()
        market.infoList(data).then( response => {
            Indicator.close()
            let res = response.data
            if(res.status === '0'){
                commit(types.MARKET_JOB_LIST_SUCCESS)
            }else{
                commit(types.MARKET_JOB_LIST_FAIL, {errorMsg: res.msg})
            }
        }).catch( error => {
            Indicator.close()
            commit(types.MARKET_JOB_LIST_FAIL, { errorMsg: 'error' })
        })
    }
}

const mutations = {
    [types.MARKET_JOB_LIST_SUCCESS](state){

    },
    [types.MARKET_JOB_LIST_FAIL](state, { errorMsg }){
        MessageBox.alert(errorMsg)
    }



}
