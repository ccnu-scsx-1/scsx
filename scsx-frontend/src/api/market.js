import { commonService } from '../util/axios'

export default {
    //职位列表
    infoList: function(data) {
        return commonService.post('/api/recruit/infoList', data || {})
    }
}

