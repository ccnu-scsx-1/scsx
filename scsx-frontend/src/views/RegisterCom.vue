<template>
    <div class="v-container">
        <mt-header title="欢迎注册--企业HR">
             <router-link to="/" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="v-field-group">
            <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
            <mt-field label="公司名" placeholder="请输入公司名" v-model="comname"></mt-field>
            <mt-field label="公司官网" placeholder="请输入公司官网" type="url" v-model="comurl"></mt-field>
            <mt-field label="招聘邮箱" placeholder="请输入招聘邮箱 " v-model="email" type="email"></mt-field>
            <mt-field label="联系方式" placeholder="请输入联系方式" v-model="tel" type="tel"></mt-field>
            <mt-field label="公司地点" placeholder="请输入公司地点" v-model="address"></mt-field>
            <mt-field label="公司介绍" placeholder="请输入公司介绍" type="textarea" rows="4" v-model="introduction"></mt-field>
            <mt-field label="密码" placeholder="请输入密码" type="password" v-model="password"></mt-field>
            <mt-field label="确认密码" placeholder="请再次输入密码" type="password" v-model="rpassword"></mt-field>
        </div>
        <div class="v-btn-group">
            <mt-button @click.native="clickRegCom" type="primary" size="large">注&nbsp;册</mt-button>
            <p style="font-size:12px;">已有账号？or 您是求职者，请前往<router-link to="/register" style="color:#26a2ff;">求职者注册</router-link></p>
            <router-link to="/login">
            <mt-button size="large" plain>登&nbsp;录</mt-button>
            </router-link>
        </div>
    </div>
</template>
<script>
export default {
    name: 'Login',  
    data() {
        return {
            username: '',
            comname: '',
            comurl:'',
            email: '',
            tel: '',
            address: '',
            role: 1,
            introduction: '',
            password: '',
            rpassword: ''
        }
    },
    methods: {
        clickRegCom(){
            this.$store.dispatch('registerCom', {
                username: this.username,
                name: this.comname,
                tel: this.tel,
                url: this.comurl,
                email: this.email,
                address: this.address,
                introduction: this.introduction,
                password: this.password,
                rpassword: this.rpassword,
                role: this.role
            })
        }
    }
}
</script>
<style lang="less" scoped>
.v-field-group {
    margin-top: 10px;
}

.v-btn-group {
    padding: 20px 10px 10px 10px;
    & > * {
        margin-bottom: 10px;
    }
}
</style>
