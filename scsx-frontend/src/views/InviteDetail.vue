<template>
    <div class="v-container">
        <mt-header title="邀约信息详情">
        </mt-header>
        <div class="info-part">
            <mt-cell title="标题" v-model="feedbackTitle"></mt-cell>
            <mt-field label="反馈信息" type="textarea" rows="4" readonly v-model="feedbackContent"></mt-field>
        </div>
        <div class="info-part">
            <mt-button plain @click="clickGoBack" size="large">返&nbsp;回</mt-button>
        </div>
    </div>
</template>
<script>
import { mapGetters } from 'vuex'
export default {
    name: 'InviteDetail',
    computed: mapGetters([
        'feedbackTitle',
        'feedbackContent'
    ]),
    methods: {
        clickGoBack() {
            this.$router.go(-1)
        }
    },
    mounted(){
        let query = this.$router.history.current.query

        this.$store.dispatch('loadInviteDetail', { feedbackId: query.feedBackId })
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
