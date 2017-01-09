import { commonService } from '../util/axios'

export default {
    //职位列表
    infoList: function(data) {
        return commonService.post('/api/recruit/infoList', data || {})
    },
    //根据title搜索招聘列表
    searchBytitle: function(data){
        return commonService.post('/api/recruit/searchBytitle', data || {})
    },
    //职位详情
    jobDetail: function(data){
        return commonService.post('/api/recruit/jobDetail', data || {})
    }
}


