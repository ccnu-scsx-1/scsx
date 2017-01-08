<template>
    <div class="v-container">
        <mt-header title="简历池">
            <router-link to="/userinfo?role=1" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="info-part" >
            <mt-cell to="/resumeinfo" v-for="item in result" :title="item.title" :value="item.value" :label="item.label" is-link></mt-cell>
        </div>
        <div class="info-part">
            <mt-button plain @click="clickGoBack" size="large">返&nbsp;回</mt-button>
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
                value: '已投递'
            }, {
                title: 'Java后台',
                label: '旺旺集团',
                value: '已投递'
            }, {
                title: 'PHP',
                label: '旺旺集团',
                value: '已投递'
            }]
        }
    },
    methods: {
        clickToVote() {
            this.$router.push('/market')
        },
        clickGoBack() {
            this.$router.push('/userinfo?role=1')
        }
    }
}
</script>
<style lang="less" scoped>
.info-part {
    margin-top: 30px;
    padding: 0 10px;
    button {
        margin-top: 10px;
    }
}
</style>
