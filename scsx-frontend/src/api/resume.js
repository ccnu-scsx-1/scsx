import { commonService } from '../util/axios'

export default {
    //获取简历信息
    fetchResume: function(data){
        return commonService.post('/api/resume/detail', data || {}) 
    },
    //保存简历
    saveResume: function(data) {
        return commonService.post('/api/resume/insert', data || {})
    },
    //hr简历池
    fetchResumePool: function(data){
        return commonService.post('/api/resume/resumeList', data || {})
    },
    //hr反馈信息
    feedbackResume: function(data){
        return commonService.post('/api/resume/feedbackResume', data || {})
    },
    //用户查看邀约信息列表
    feedbackList: function(data){
        return commonService.post('/api/resume/feedbackList', data || {})
    }
}


