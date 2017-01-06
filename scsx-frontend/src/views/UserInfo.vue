<template>
    <div class="v-container">
        <mt-header title="个人信息"></mt-header>
        <mt-cell title="用户名" value="doge"></mt-cell>
        <mt-cell title="个人简历" to="/resume" is-link v-show="userShow"></mt-cell>
       <!--  <mt-cell title="职位意向" to="/intention" is-link v-show="userShow"></mt-cell> -->
        <mt-cell title="投递信息" to="/sendinfo" is-link v-show="userShow"></mt-cell>
        <mt-cell title="邀约信息" to="/inviteinfo" is-link v-show="userShow"></mt-cell>
        <mt-cell title="招聘岗位" to="/employment" is-link v-show="hrShow"></mt-cell>
        <mt-cell title="简历池" to="/resumepool" is-link v-show="hrShow"></mt-cell>
        <mt-cell title="注册信息" @click.native="clickGoSettings" is-link></mt-cell>
        <mt-cell title="密码修改" to="/updatesettings" is-link></mt-cell>
        <div class="logout-btn">
            <mt-button type="danger" size="large" @click="clickLogout">退出登录</mt-button>
        </div>
        
</mt-cell>
    </div>
</template>
<script>
import { MessageBox } from 'mint-ui'

export default {
    name: 'UserInfo',
    data() {
        return {
            userShow: false,
            hrShow: false
        }
    },
    methods: {
        clickLogout(){
            MessageBox.confirm('确认退出登录？').then(action => {
                this.$router.push('/')
            }, action => {})
        },
        clickGoSettings(){
            if(this.userShow) this.$router.push('/settings')
            if(this.hrShow) this.$router.push('/comsettings') 
        }   
    },
    mounted(){
        if(+this.$router.history.current.query.role){
            this.hrShow = true
        }else{
            this.userShow = true
        }
    }
}
</script>
<style lang="less" scoped>
    .logout-btn{
        padding: 20px 10px;
    }
</style>
