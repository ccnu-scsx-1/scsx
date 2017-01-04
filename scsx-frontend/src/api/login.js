import { commonService } from '../util/axios'

export default function login(data) {
    return commonService.post('/api/user/login', data || {})
}
