<template>
    <div class="v-container">
        <mt-header title="个人简历"></mt-header>
        <div class="info-part">
            <mt-cell title="个人介绍"></mt-cell>
            <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
            <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="email"></mt-field>
            <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="tel"></mt-field>
            <mt-field label="年龄" placeholder="请输入年龄" type="number" v-model="age"></mt-field>
            <mt-cell title="性别">
                <select v-model="gender" style="width: 250px;">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </mt-cell>
        </div>
        <div class="info-part">
            <mt-field label="教育经历" placeholder="请输入您的教育经历" type="textarea" ></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="工作经历" placeholder="请输入您的工作经历" type="textarea" ></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="项目经历" placeholder="请输入您的项目经历" type="textarea"></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="我的技能" placeholder="请输入您的技能，优势或特长" type="textarea" v-model="skills"></mt-field>
        </div>
        
        <div class="info-part">
            <mt-button plain @click="clickCancel">返回</mt-button>
            <mt-button type="primary" @click="clickSave">保存</mt-button>
        </div>
    </div>
</template>
<script>

import { MessageBox } from 'mint-ui'

export default {
    name: 'Resume',
    data() {
        return {
            username: '',
            email: '',
            tel: '',
            age: '',
            gender: 0,
            role: 0,
            skills: ''
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
