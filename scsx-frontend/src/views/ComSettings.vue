<template>
    <div class="v-container">
        <mt-header title="注册信息修改"></mt-header>
        <div class="info-part">
            <mt-cell title="账号信息"></mt-cell>
            <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
        </div>

        <div class="info-part">
            <mt-cell title="公司介绍"></mt-cell>
            <mt-field label="公司名" placeholder="请输入公司名" v-model="comName"></mt-field>
            <mt-field label="招聘邮箱" placeholder="请输入招聘邮箱" type="email" v-model="email"></mt-field>
            <mt-field label="联系方式" placeholder="请输入联系方式" type="tel" v-model="tel"></mt-field>
            <mt-field label="公司地址" placeholder="请输入公司地址" v-model="place"></mt-field>
            <mt-field label="详细信息" placeholder="请输入公司详细信息" type="textarea" rows="4" v-model="comDetail"></mt-field>
        </div>

        <div class="info-part">
            <mt-button plain @click="clickCancel">返&nbsp;回</mt-button>
            <mt-button type="primary" @click="clickSave">保&nbsp;存</mt-button>
        </div>
    </div>
</template>
<script>

import { MessageBox } from 'mint-ui'

export default {
    name: 'ComSettings',
    data() {
        return {
            comName: '',
            comDetail: '',
            username: '',
            email: '',
            tel: '',   
            place: '',
            result: [{
                title: 'web前端',
                label: '旺旺集团',
                value: '10k-20k'
            }, {
                title: 'Java后台',
                label: '旺旺集团',
                value: '10k-20k'
            }, {
                title: 'PHP',
                label: '旺旺集团',
                value: '10k-20k'
            }]
        }
    },
    methods: {
        clickCancel(){
            MessageBox.confirm('当前修改未保存，是否直接返回？').then(action => {
                this.$router.push('/userinfo')
            }, action => {})
        },
        clickSave(){
            MessageBox.alert('保存成功！')
        }
    }
}
</script>
<style lang="less" scoped>
.info-part {
    margin-top: 10px;
    &:last-child{
        display: flex;
        button{
            flex: 1;
            margin: 10px;
        }
    }
}
</style>
