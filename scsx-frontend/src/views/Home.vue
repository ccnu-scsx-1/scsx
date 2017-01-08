<template>
    <div class="v-container">
        <mt-header title="PT网"></mt-header>
        <mt-search class="searchBar" v-model="searchValue" placeholder="搜索公司或者岗位" @search.native="searchResult"></mt-search>
        <div class="btn-group">
            <div class="btn-line">
                <mt-button type="primary" class="inline-btn" @click="clickGoMarket">我要求职</mt-button>
                <mt-button class="inline-btn" type="primary" @click="clickGoReg">我要招人</mt-button>
            </div>
            <router-link to="/login">
                <mt-button type="primary" size="large">登&nbsp;录</mt-button>
            </router-link>
            <router-link to="/register">
                <mt-button size="large" plain>注&nbsp;册</mt-button>
            </router-link>
        </div>
    </div>
</template>
<script>
export default {
    name: 'Home',
    data() {
        return {
            searchValue: ''
        }
    },
    methods: {
        clickGoMarket(){
            this.$router.push('/market')
        },
        clickGoReg(){
            this.$router.push({path: '/registercom'})
        },
        searchResult(){
            this.$router.push({path:'/market', query: { searchValue: this.searchValue }})
        }
    }
}
</script>
<style lang="less" scoped>
.searchBar {
    height: auto;
    overflow: visible;
}

.v-container{
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
}

.btn-group {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
    padding: 10px;
    .btn-line {
        display: flex;
        justify-content: space-between;
        .inline-btn {
            width: 48%;
        }
    }
    & > * {
        margin-bottom: 10px;
    }
}
</style>
