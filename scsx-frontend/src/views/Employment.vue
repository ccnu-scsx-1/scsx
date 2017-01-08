<template>
    <div class="v-container">
        <mt-header title="招聘岗位">
            <router-link to="/userinfo?role=1" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="info-part">
            <mt-cell to="/editjob" v-for="item in result" :title="item.title" :value="item.value" :label="item.label" is-link></mt-cell>
        </div>

        <div class="info-part">
            <mt-button type="primary" @click="clickAdd" size="large">新增岗位</mt-button>
            <mt-button plain @click="clickCancel" size="large">返&nbsp;回</mt-button>
        </div>
    </div>
</template>
<script>
export default {
    name: 'ComSettings',
    data() {
        return {
            result: [{
                title: 'web前端',
                label: '旺旺集团',
                value: '10k-20k'
            }, {
                title: 'Java后台',
                label: '旺旺集团',
                value: '10k-20k'
            }, {
                title: 'PHP',
                label: '旺旺集团',
                value: '10k-20k'
            }]
        }
    },
    methods: {
        clickCancel(){
            this.$router.push('/userinfo')
        },
        clickAdd(){
            this.$router.push('/publishjob')
        }
    }
}
</script>
<style lang="less" scoped>
.info-part {
    margin-top: 30px;
    padding: 0 10px;
    button{
        margin-top: 10px;
    }
}
</style>
