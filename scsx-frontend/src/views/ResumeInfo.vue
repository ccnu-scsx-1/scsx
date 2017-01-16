<template>
    <div class="v-container">
        <mt-header title="个人简历"></mt-header>
        <div class="info-part">
            <mt-field label="姓名" v-model="usernameRI"></mt-field>
            <mt-field label="邮箱" v-model="emailRI"></mt-field>
            <mt-field label="手机号" v-model="telRI"></mt-field>
            <mt-field label="年龄" v-model="age"></mt-field>
            <mt-cell title="性别">
                <select v-model="gender" style="width: 250px;margin-left:12px;">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </mt-cell>
        </div>
        <div class="info-part">
            <mt-field label="教育经历" type="textarea" v-model="school" readonly></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="工作经历" type="textarea" v-model="work" readonly></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="项目经历" type="textarea" v-model="project" readonly></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="我的技能" type="textarea" v-model="skills" readonly></mt-field>
        </div>
        <div class="info-part">
            <mt-button plain @click="clickCancel">返&nbsp;回</mt-button>
            <mt-button type="primary" @click="clickFeedBack">回&nbsp;复</mt-button>
        </div>
    </div>
</template>
<script>
import {
    mapGetters
} from 'vuex'
import {
    MessageBox
} from 'mint-ui'

export default {
    name: 'Resume',
    computed: mapGetters([
        'usernameRI',
        'emailRI',
        'telRI',
        'age',
        'gender',
        'school',
        'project',
        'work',
        'skills'
    ]),
    methods: {
        clickCancel() {
            this.$router.go(-1)
        },
        clickFeedBack() {
            let query = this.$router.history.current.query
            this.$router.push({path: '/resumefeedback', query})
        }
    },
    mounted() {
        this.$store.dispatch('loadResumeInfo', {
            userId: this.$router.history.current.query.userId
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
