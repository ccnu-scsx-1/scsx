<template>
    <div class="v-container">
        <mt-header title="个人简历"></mt-header>
        <div class="info-part">
            <mt-field label="姓名" placeholder="请输入姓名" v-model="username" readonly></mt-field>
            <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="email" readonly></mt-field>
            <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="tel" readonly></mt-field>
            <mt-field label="年龄" placeholder="请输入年龄" type="number" v-model="age" readonly></mt-field>
            <mt-field label="性别" placeholder="请输入年龄" v-model="gender" readonly></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="教育经历" placeholder="请输入您的教育经历" type="textarea" readonly></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="工作经历" placeholder="请输入您的工作经历" type="textarea" readonly></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="项目经历" placeholder="请输入您的项目经历" type="textarea" readonly></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="我的技能" placeholder="请输入您的技能，优势或特长" type="textarea" v-model="skills" readonly></mt-field>
        </div>
        
        <div class="info-part">
            <mt-button plain @click="clickCancel">返&nbsp;回</mt-button>
            <mt-button type="primary" @click="clickFeedBack">回&nbsp;复</mt-button>
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
        clickFeedBack(){
             this.$router.push('/resumefeedback')
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
