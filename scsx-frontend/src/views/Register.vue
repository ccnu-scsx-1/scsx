<template>
    <div class="v-container">
        <mt-header title="欢迎注册--求职者">
             <router-link to="/" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="v-field-group">
            <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
            <mt-field label="邮箱" placeholder="请输入邮箱 " v-model="email" type="email"></mt-field>
            <mt-field label="手机号" placeholder="请输入手机号" v-model="tel" type="tel"></mt-field>
            <mt-field label="年龄" placeholder="请输入年龄" type="number" v-model="age"></mt-field>
            <mt-cell title="性别">
                <select v-model="gender" style="width: 250px;margin-left:12px;">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </mt-cell>
            <mt-field label="密码" placeholder="请输入密码" type="password" v-model="password"></mt-field>
            <mt-field label="确认密码" placeholder="请再次输入密码" type="password" v-model="rpassword"></mt-field>
        </div>
        <div class="v-btn-group">
            <mt-button @click.native="clickReg" type="primary" size="large">注&nbsp;册</mt-button>
            <p style="font-size:12px;">已有账号？or 您是企业HR，请前往<router-link to="/registercom" style="color:#26a2ff;">企业HR注册</router-link></p>
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
            email: '',
            tel: '',
            age: '',
            gender: 0,
            role: 0,
            motto: '',
            password: '',
            rpassword: ''
        }
    },
    methods: {
        clickReg(){
            this.$store.dispatch('register', {
                name: this.username,
                number: this.tel,
                email: this.email,
                gender: this.gender,
                motto: this.motto,
                password: this.password,
                rpassword: this.rpassword,
                role: this.role,
                age: this.age
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
