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
        </div>
        <div class="info-part">
            <mt-button plain @click="clickCancel">返&nbsp;回</mt-button>
            <mt-button type="primary" @click="clickSave">保&nbsp;存</mt-button>
        </div>
    </div>
</template>
<script>
import {
    MessageBox
} from 'mint-ui'

export default {
    name: 'Settings',
    computed: {
        username: {
            get() {
                return this.$store.state.settings.username
            },
            set(value) {
                this.$store.state.settings.username = value
            }
        },
        email: {
            get() {
                return this.$store.state.settings.email
            },
            set(value) {
                this.$store.state.settings.email = value
            }
        },
        tel: {
            get() {
                return this.$store.state.settings.tel
            },
            set(value) {
                this.$store.state.settings.tel = value
            }
        },
        age: {
            get() {
                return this.$store.state.settings.age
            },
            set(value) {
                this.$store.state.settings.age = value
            }
        },
        gender: {
            get() {
                return this.$store.state.settings.gender
            },
            set(value) {
                this.$store.state.settings.gender = value
            }
        },
        role: {
            get() {
                return this.$store.state.settings.role
            },
            set(value) {
                this.$store.state.settings.role = value
            }
        }
    },
    methods: {
        clickCancel() {
            MessageBox.confirm('当前修改未保存，是否直接返回？').then(action => {
                this.$router.push('/userinfo')
            }, action => {})
        },
        clickSave() {
            this.$store.dispatch('updateReigsterInfo')
        }
    },
    mounted() {
        this.$store.dispatch('loadRegisterInfo', {
            id: this.$store.state.user.userid,
            role: 0
        })
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
