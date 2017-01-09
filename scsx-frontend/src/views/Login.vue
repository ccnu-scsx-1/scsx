<template>
    <div class="v-container">
        <mt-header title="欢迎登录--PT网">
            <router-link to="/" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="v-field-group">
            <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
            <mt-field label="密码" placeholder="请输入密码" type="password" v-model="password"></mt-field>
            <mt-cell title="登录类型">
                <select v-model="role" style="width: 250px;">
                    <option value="0">个人</option>
                    <option value="1">企业</option>
                </select>
            </mt-cell>
        </div>
        <div class="v-btn-group">
            <mt-button @click.native="clickLogin" type="primary" size="large">登&nbsp;录</mt-button>
            <p style="font-size:12px;">还没账号?</p>
            <router-link to="/register">
                <mt-button size="large" plain>注&nbsp;册</mt-button>
            </router-link>
        </div>
    </div>
</template>
<script>
import {
    mapGetters,
    mapActions
} from 'vuex'

export default {
    name: 'Login',
    data() {
        return {
            username: '',
            password: '',
            role: 0
        }
    },
    computed: mapGetters([
        'showIndicator',
        'errorMsg'
    ]),
    methods: {
        clickLogin() {
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
