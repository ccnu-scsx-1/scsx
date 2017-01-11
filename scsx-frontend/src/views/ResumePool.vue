<template>
    <div class="v-container">
        <mt-header title="简历池">
            <router-link to="/userinfo?role=1" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="info-part" >
            <v-cell v-for="item in resumePool" :title="item.title" :salary="item.username" :link="{path:'/resumeinfo',query:{userId: item.userId, infoId: item.infoId}}"></v-cell>
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
    name: 'ComSettings',
    components: {
        VCell
    },
    computed: mapGetters([
        'resumePool'
    ]),
    methods: {
        clickGoBack() {
            this.$router.push('/userinfo?role='+ this.$store.state.user.role)
        }
    },
    mounted(){
        this.$store.dispatch('loadResumePool', { userId: this.$store.state.user.userid })
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
