<template>
    <div class="v-container">
        <mt-header title="邀约信息">
        </mt-header>
        <div class="info-part">
            <v-cell v-for="item in inviteInfoResult" :title="item.title" :salary="item.result" :link="{path: '/invitedetail', query: { infoId: item.infoId, feedBackId: item.feedBackId}}" ></v-cell>
        </div>
        <div class="info-part">
            <mt-button plain @click="clickGoBack" size="large">返&nbsp;回</mt-button>
        </div>
    </div>
</template>
<script>
import { mapGetters } from 'vuex'
import VCell from '../components/cell'

export default {
    name: 'InviteInfo',
    components: {
        VCell
    },
    computed: mapGetters([
        'inviteInfoResult'
    ]),
    methods: {
        clickToVote() {
            this.$router.push('/market')
        },
        clickGoBack(){
            this.$router.go(-1)
        }
    },
    mounted(){
        this.$store.dispatch('feedbackList', { userId: this.$store.state.user.userid , role: 0 })
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
