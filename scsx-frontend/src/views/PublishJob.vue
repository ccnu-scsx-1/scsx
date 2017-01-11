<template>
    <div class="v-container">
        <mt-header title="新增岗位"></mt-header>
        <div class="info-part">
            <mt-field label="岗位名" placeholder="请输入岗位名" v-model="title"></mt-field>
            <mt-field label="最低薪资" placeholder="请输入最低薪资（元）" type="number" v-model="salaryLow"></mt-field>
            <mt-field label="最高薪资" placeholder="请输入最高薪资（元）" type="number" v-model="salaryHigh"></mt-field>
            <mt-field label="工作地点" placeholder="请输入工作地点" v-model="region"></mt-field>
            <mt-cell title="学历要求">
                <select v-model="education" style="width: 250px;">
                    <option value="0">专科</option>
                    <option value="1">本科</option>
                    <option value="2">硕士</option>
                    <option value="3">博士</option>
                </select>
            </mt-cell>
            <mt-field label="工作年限" placeholder="请输入工作年限" v-model="yearWork"></mt-field>
            <mt-field label="职位描述" placeholder="请输入职位描述" type="textarea" v-model="description" rows="4"></mt-field>
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
    name: 'Resume',
    data() {
        return {
            title: '',
            salaryLow: '',
            salaryHigh: '',
            region: '',
            education: 1,
            description: '',
            yearWork: ''
        }
    },
    methods: {
        clickCancel() {
            MessageBox.confirm('当前修改未保存，是否直接返回？').then(action => {
                this.$router.go(-1)
            }, action => {})
        },
        clickSave() {
            let userId = this.$store.state.user.userid
            this.$store.dispatch('publishJob', {
                userId,
                title: this.title,
                salaryLow: this.salaryLow,
                salaryHigh: this.salaryHigh,
                region: this.region,
                education: this.education,
                description: this.description,
                yearWork: this.yearWork
            })
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
