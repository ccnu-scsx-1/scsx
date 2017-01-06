<template>
    <div class="v-container">
        <mt-header title="新增岗位"></mt-header>
        <div class="info-part">
            <mt-cell title="岗位基本信息"></mt-cell>
            <mt-field label="岗位名" placeholder="请输入岗位名" ></mt-field>
            <mt-field label="薪资" placeholder="请输入薪资" ></mt-field>
            <mt-field label="工作地点" placeholder="请输入工作地点" ></mt-field>
            <mt-field label="学历要求" placeholder="请输入学历要求" ></mt-field>
        </div>
        <div class="info-part">
            <mt-cell title="技能要求"></mt-cell>
            <mt-field label="技能要求" placeholder="请输入技能要求" type="textarea" ></mt-field>
        </div>
       
        <div class="info-part">
            <mt-button plain @click="clickCancel">返回</mt-button>
            <mt-button type="primary" @click="clickSave">保存</mt-button>
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
