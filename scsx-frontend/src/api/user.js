import { commonService } from '../util/axios'

export default {
    login: function (data) {
        return commonService.post('/api/user/login', data || {})
    },
    logout: function(data){
        return commonService.post('/api/user/logout', data || {})
    }
}

