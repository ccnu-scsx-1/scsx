<template>
    <div class="v-container">
        <mt-header title="回复简历"></mt-header>
        <div class="info-part">
            <mt-field label="标题" placeholder="请输入标题"></mt-field>
            <mt-field label="反馈信息" placeholder="请输入反馈信息" type="textarea" :rows="4"></mt-field>
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
    name: 'Resume',
    data() {
        return {

        }
    },
    methods: {
        clickCancel(){
            MessageBox.confirm('当前修改未保存，是否直接返回？').then(action => {
                this.$router.push('/employment')
            }, action => {})
        },
        clickSave(){
            MessageBox.alert('保存成功！')
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
