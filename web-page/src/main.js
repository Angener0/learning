import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Router from 'router'

Vue.config.productionTip = false
Vue.use(
    VueAxios,
    axios,
    Router,
)
new Vue({
    render: h => h(App),
}).$mount('#app')
