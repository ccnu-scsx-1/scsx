<template>
    <div class="v-container">
        <mt-header title="密码修改"></mt-header>
        <div class="info-part">
            <mt-field label="旧密码" placeholder="请输入旧密码" type="password" v-model="oldpassword"></mt-field>
            <mt-field label="新密码" placeholder="请输入新密码" type="password" v-model="newpassword"></mt-field>
            <mt-field label="确认密码" placeholder="请再次输入新密码" type="password" v-model="rnewpassword"></mt-field>
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
    name: 'UpdatePassword',
    data() {
        return {
            oldpassword: '',
            newpassword: '',
            rnewpassword: '',     
        }
    },
    methods: {
        clickCancel(){
            let role = this.$store.state.user.role
            MessageBox.confirm('当前修改未保存，是否直接返回？').then(action => {
                this.$router.push('/userinfo?role=' + role)
            }, action => {})
        },
        clickSave(){
            this.$store.dispatch('updatePassword', { oldPassword: this.oldpassword, newPassword: this.newpassword, rPassword: this.rnewpassword, id: this.$store.state.user.userid })
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
