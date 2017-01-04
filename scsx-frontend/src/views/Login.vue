<template>
    <div class="v-container">
        <mt-header title="欢迎登录"></mt-header>
        <div class="v-field-group">
            <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
            <mt-field label="密码" placeholder="请输入密码" type="password" v-model="password"></mt-field>
        </div>
        <div class="v-btn-group">
            <mt-button @click.native="clickLogin" type="primary" size="large">登录</mt-button>
            <mt-button size="large" plain>注册</mt-button>
        </div>
    </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'
import { Indicator, MessageBox } from 'mint-ui'

export default {
    name: 'Login',  
    data() {
        return {
            username: '',
            password: '',
            role: 2
        }
    },
    computed: mapGetters([
        'showIndicator',
        'errorMsg'
    ]),
    methods: {
        clickLogin(){
            this.$store.dispatch('login', {
                name: this.username,
                password: this.password,
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
