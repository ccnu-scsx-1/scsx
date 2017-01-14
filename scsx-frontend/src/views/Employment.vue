<template>
    <div class="v-container">
        <mt-header title="招聘岗位">
            <router-link to="/userinfo?role=1" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="info-part">
            <v-cell v-for="item in jobList" :title="item.title" :company="item.companyName" :region="item.region" :salary="item.salary" :link="{path: '/jobdetail', query: { infoId: item.id, companyId: item.company_id, noVoteBtn:1}}" ></v-cell>
        </div>

        <div class="info-part">
            <mt-button type="primary" @click="clickAdd" size="large">新增岗位</mt-button>
            <mt-button plain @click="clickCancel" size="large">返&nbsp;回</mt-button>
        </div>
    </div>
</template>
<script>
import { mapGetters } from 'vuex'
import VCell from '../components/cell'

export default {
    name: 'Employment',
    components:{
        VCell
    },
    computed: mapGetters([
        'jobList'
    ]),
    methods: {
        clickCancel(){
            this.$router.push('/userinfo?role=' + this.$store.state.user.role)
        },
        clickAdd(){
            this.$router.push('/publishjob')
        }
    },
    mounted(){
        this.$store.dispatch('loadJobList', { id : this.$store.state.user.userid})
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
