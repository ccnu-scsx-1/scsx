<template>
    <div class="v-container">
        <mt-header title="注册信息修改"></mt-header>
        <div class="info-part">
            <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
            <mt-field label="邮箱" placeholder="请输入邮箱 " v-model="email" type="email"></mt-field>
            <mt-field label="手机号" placeholder="请输入手机号" v-model="tel" type="tel"></mt-field>
            <mt-field label="年龄" placeholder="请输入年龄" v-model="age" type="number"></mt-field>
            <mt-cell title="性别">
                <select v-model="gender" style="width: 250px;">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </mt-cell>
            <mt-field label="个性签名" placeholder="请输入个性签名（选填）" type="textarea" rows="4" v-model="motto">
        </div>
        <div class="info-part">
            <mt-button plain @click="clickCancel">返回</mt-button>
            <mt-button type="primary" @click="clickSave">保存</mt-button>
        </div>
    </div>
</template>
<script>
import {
    MessageBox
} from 'mint-ui'

export default {
    name: 'Settings',
    data() {
        return {
            username: '',
            email: '',
            tel: '',
            age: '',
            gender: 0,
            role: 0,
            motto: ''
        }
    },
    methods: {
        clickCancel() {
            MessageBox.confirm('当前修改未保存，是否直接返回？').then(action => {
                this.$router.push('/userinfo')
            }, action => {})
        },
        clickSave() {
            MessageBox.alert('保存成功！')
        }
    }
}
</script>
<style lang="less" scoped>
.info-part {
    margin-top: 10px;
    &:last-child {
        display: flex;
        button {
            flex: 1;
            margin: 10px;
        }
    }
}
</style>
