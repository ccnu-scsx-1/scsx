import axios from 'axios'

const baseURL = ''

//通用类http-service
export const commonService = axios.create({
    baseURL
})

//文件服务类file-service, 
export const fileService = axios.create({
    baseURL,
    headers: {
        post: {
            'Content-Type': 'multipart/form-data'
        } 
    }
})
