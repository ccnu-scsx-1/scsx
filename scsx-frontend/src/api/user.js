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
    //提交简历
    voteResume: function(data){
        return commonService.post('/api/user/submitInfo', data || {})
    },
    updatePassword: function(data){
        return commonService.post('/api/user/updateUserInfo', data || {})
    },
    updateUserInfo: function(data){
        return commonService.post('/api/user/updateUserInfo', data || {})
    },
    //加载发布的岗位信息
    loadPublishJobList:  function(data){
        return commonService.post('/api/user/intention', data || {})
    }
}

