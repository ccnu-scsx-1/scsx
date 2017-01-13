<template>
    <div class="v-container">
        <mt-header title="投递信息">
        </mt-header>
        <div class="info-part">
            <v-cell v-for="item in voteInfoResult" :title="item.title" :company="item.companyName" :region="item.region" :salary="item.salary" :link="{path: '/jobdetail', query: { infoId: item.infoId, companyId: item.companyId, noVoteBtn: 1 }}" ></v-cell>
        </div>
        <div class="info-part">
            <mt-button type="primary" @click="clickToVote" size="large">继续投递</mt-button>
            <mt-button plain @click="clickGoBack" size="large">返&nbsp;回</mt-button>
        </div>
    </div>
</template>
<script>
import { mapGetters } from 'vuex'
import VCell from '../components/cell'

export default {
    name: 'VoteInfo',
    components: {
        VCell
    },
    computed: mapGetters([
        'voteInfoResult'
    ]),
    methods: {
        clickToVote() {
            this.$router.push('/market')
            this.$store.state.user.menuClass = 'user'
        },
        clickGoBack() {
            this.$router.go(-1)
        }
    },
    mounted(){
        this.$store.dispatch('fetchVoteInfoList', {userId: this.$store.state.user.userid})
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
