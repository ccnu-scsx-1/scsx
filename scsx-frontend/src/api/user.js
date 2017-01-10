import { commonService } from '../util/axios'

export default {
    login: function(data) {
        return commonService.post('/api/user/login', data || {})
    },
    logout: function(data){
        return commonService.post('/api/user/logout', data || {})
    },
    register: function(data){
        return commonService.post('/api/user/register', data|| {})
    },
    status: function(data){
        return commonService.post('/api/user/status', data || {})
    },
    submitInfo: function(data){
        return commonService.post('/api/user/submitInfo', data || {})
    },
    updatePassword: function(data){
        return commonService.post('/api/user/updateUserInfo', data || {})
    },
    updateUserInfo: function(data){
        return commonService.post('/api/user/updateUserInfo', data || {})
    },
    publishJobList:  function(data){
        return commonService.post('/api/user/intention', data || {})
    }
}

