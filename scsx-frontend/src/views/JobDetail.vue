<template>
    <div>
        <mt-header title="职位详情">
            <mt-button icon="back" slot="left" @click="clickGoBack">返回</mt-button>
        </mt-header>
        <div class="job-detail">
            <div class="job-title">{{ title }}</div>
            <div class="job-info">
                <p>薪资：{{ salary }}</p>
                <p>地点：{{ region }}</p>
                <p>工作年限：{{ yearWork }}</p>
                <p>学历：{{ education }}</p>
            </div>
            <div class="company-info">
                <p>{{ name }}</p>
                <p>公司地址：{{ address }}</p>
                <p>联系方式：{{ tel }}</p>
                <p>招聘邮箱：{{ email }}</p>
            </div>
            <div class="job-desc">
                <div class="desc-title">职位描述</div>
                <div class="desc-content">{{ description }}</div>
            </div>
        </div>
        <div class="job-vote" v-if="noVoteBtn">
            <mt-button @click.native="clickVoteResume" type="primary" size="large">投个简历</mt-button>
        </div>
    </div>
</template>
<script>
import {
    mapGetters
} from 'vuex'

export default {
    name: 'JobDetail',
    data() {
        return {
            noVoteBtn: true
        }
    },
    computed: mapGetters([
        'title',
        'salary',
        'yearWork',
        'education',
        'name',
        'address',
        'tel',
        'email',
        'description',
        'region'
    ]),
    methods: {
        clickVoteResume() {
            let user = this.$store.state.user
            let loginStatus = user.loginStatus
            let userId = user.userid
            let infoId = this.$router.history.current.query.infoId
            this.$store.dispatch('voteResume', {
                loginStatus,
                userId,
                infoId
            })
        },
        clickGoBack() {
            this.$router.go(-1)
        }
    },
    mounted() {
        let query = this.$router.history.current.query
        this.$store.dispatch('loadJobDetail', {
            info_id: query.infoId,
            company_id: query.companyId
        })

        if (query.noVoteBtn === 1) {
            this.noVoteBtn = false
        }
    }
}
</script>
<style lang="less" scoped>
.job-detail {
    width: 100%;
}

.job-title {
    width: 100%;
    height: 40px;
    line-height: 40px;
    font-size: 18px;
    font-weight: bold;
    border-bottom: 1px solid #d9d9d9;
    padding: 0 10px;
}

.job-info {
    width: 100%;
    border-bottom: 1px solid #d9d9d9;
    padding: 13px 10px;
    font-size: 14px;
    display: flex;
    flex-wrap: wrap;
    p {
        width: 50%;
        margin: 0;
        line-height: 24px;
        font-weight: 500;
    }
}

.company-info {
    width: 100%;
    border-bottom: 1px solid #d9d9d9;
    padding: 13px 10px;
    font-size: 14px;
    p {
        margin: 0;
        &:first-child {
            font-size: 15px;
            margin-bottom: 5px;
        }
    }
}

.job-desc {
    width: 100%;
    border-bottom: 1px solid #d9d9d9;
    line-height: 20px;
    .desc-title {
        width: 100%;
        background: #26a2ff;
        color: #fff;
        padding: 10px;
        font-size: 13px;
    }
    .desc-content {
        width: 100%;
        padding: 13px 10px;
        font-size: 12px;
        word-break: break-word;
    }
}

.job-vote {
    padding: 20px 10px;
}
</style>
