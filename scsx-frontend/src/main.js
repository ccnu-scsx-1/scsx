import Vue from 'vue'
import VueRouter from 'vue-router'
import MintUI from 'mint-ui'
import 'mint-ui/lib/style.css'
import App from './App'
import store from './store'
import router from './router'

import VueResource  from 'vue-resource'

Vue.use(VueResource)

//router
Vue.use(VueRouter)

//mint-ui
Vue.use(MintUI)

const app = new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
