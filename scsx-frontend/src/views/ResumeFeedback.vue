<template>
    <div class="v-container">
        <mt-header title="回复简历"></mt-header>
        <div class="info-part">
            <mt-field label="标题" placeholder="请输入标题" v-model="title"></mt-field>
            <mt-field label="反馈信息" placeholder="请输入反馈信息" type="textarea" rows="4" v-model="content"></mt-field>
            <mt-cell title="是否通过">
                <mt-switch :value="result"></mt-switch>
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
    name: 'ResumeFeedback',
    data() {
        return {
            title: '',
            content: '',
            result: true
        }
    },
    methods: {
        clickCancel() {
            MessageBox.confirm('当前修改未保存，是否直接返回？').then(action => {
                this.$router.go(-1)
            }, action => {})
        },
        clickSave() {
            let query = this.$router.history.current.query

            this.$store.dispatch('saveResumeFeedback', {
                title: this.title,
                content: this.content,
                result: this.result,
                hrId: this.$store.state.user.userid,
                userId: query.userId,
                infoId: query.infoId
            })
        }
    }
}
</script>
<style lang="less">
.info-part {
    margin-top: 30px;
    &:last-child {
        display: flex;
        button {
            flex: 1;
            margin: 10px;
        }
    }
    .mint-cell-value {
       flex: 3;
    }
}
</style>
