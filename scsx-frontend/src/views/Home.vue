<template>
    <div class="v-container">
        <mt-header title="SELECT"></mt-header>
        <mt-search class="searchBar" v-model="searchValue" placeholder="搜索岗位名" @search.native="searchResult"></mt-search>
        <mt-swipe :auto="4000" class="swipe-contanier">
            <mt-swipe-item class="swipe-item-pic"></mt-swipe-item>
            <mt-swipe-item class="swipe-item-pic"></mt-swipe-item>
        </mt-swipe>
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
        clickGoMarket() {
            this.$router.push('/market')
        },
        clickGoReg() {
            this.$router.push({
                path: '/registercom'
            })
        },
        searchResult() {
            this.$router.push({
                path: '/market',
                query: {
                    searchValue: this.searchValue
                }
            })
        }
    }
}
</script>
<style lang="less" scoped>
.searchBar {
    height: auto;
    overflow: visible;
}

.mint-header {
    height: 100px;
}

.v-container {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
}

.swipe-contanier {
    margin-top: 30px;
    .swipe-item-pic {
        &:first-child {
            background: url('../assets/pic1.png') no-repeat center;
            background-size: 100%;
        }
        &:last-child {
            background: url('../assets/pic2.png') no-repeat center;
            background-size: 100%;
        }
    }
    .mint-swipe-indicators {
        & > * {
            border: 1px solid #000;
        }
    }
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
