<template>
    <div class="v-container">
        <mt-header title="邀约信息">
            <router-link to="/userinfo?role=0" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="info-part" @click="clickInfoCell">
            <mt-cell data-infoid="infoid" v-for="item in result" :title="item.title" :value="item.value" :label="item.label" is-link></mt-cell>
        </div>
        <div class="info-part">
            <mt-button type="primary" @click="clickToVote" size="large">继续投递</mt-button>
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
                title: '邀请您web前端面试',
                label: '旺旺集团',
                value: '已通过'
            }, {
                title: '很抱歉...',
                label: '旺旺集团',
                value: '未通过'
            }, {
                title: '邀请您PHP后台面试PHP',
                label: '旺旺集团',
                value: '已通过'
            }]
        }
    },
    methods: {
        clickToVote() {
            this.$router.push('/market')
        },
        clickGoBack() {
            this.$router.push('/userinfo?role=0')
        },
        clickInfoCell(event) {
            let infoid = event.target.dataset.infoid || event.target.parentNode.dataset.infoid

            if (infoid) {
                this.$router.push({
                    path: '/invitedetail',
                    query: {
                        "infoid": infoid
                    }
                })
            }
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
