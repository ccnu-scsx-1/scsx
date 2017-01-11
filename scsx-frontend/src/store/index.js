import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'
import mutations from './mutations'
//modules
import user from './modules/user'
import market from './modules/market'
import jobDetail from './modules/jobDetail'
import resume from './modules/resume'
import resumePool from './modules/resumePool'
import employment from './modules/employment'
import publishJob from './modules/publishJob'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        user,
        market,
        jobDetail,
        resume,
        resumePool,
        employment,
        publishJob
    }
})
