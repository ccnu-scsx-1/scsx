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
    }
}


