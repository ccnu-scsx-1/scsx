<template>
    <div class="v-container">
        <mt-header title="邀约信息详情">
            <router-link to="/userinfo?role=0" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="info-part">
            <mt-cell title="标题" value=""></mt-cell>
            <mt-field label="反馈信息" type="textarea" rows="4" readonly v-model="backInfo"></mt-field>
        </div>
        <div class="info-part">
            <mt-button plain @click="clickGoBack" size="large">返&nbsp;回</mt-button>
        </div>
    </div>
</template>
<script>
export default {
    name: 'InviteDetail',
    data() {
        return {
            title: '已通过',
            backInfo: '很高兴邀请你参加.....面试'
        }
    },
    methods: {
        clickGoBack() {
            this.$router.push('/userinfo?role=0')
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
