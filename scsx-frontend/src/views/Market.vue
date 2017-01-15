<template>
    <div>
        <mt-header title="SELECT">
        </mt-header>
        <mt-search class="searchBar" v-model="searchValue" placeholder="搜索岗位名" @search.native="searchBytitle" :show="true">
            <v-cell v-for="item in searchResult" :title="item.title" :company="item.companyName" :region="item.region" :salary="item.salary" :link="{path: '/jobdetail', query: { infoId: item.infoId, companyId: item.companyId }}" ></v-cell>
        </mt-search>
    </div>
</template>
<script>
import {
    mapGetters
} from 'vuex'
import VCell from '../components/cell'

export default {
    name: 'Market',
    components:{
        VCell
    },
    data(){
        return {
            searchValue: ''
        }
    },
    computed: {
        ...mapGetters([
            'searchResult'
        ])
    },
    methods: {
        searchBytitle() {
            this.$store.dispatch('searchBytitle', {
                title: this.searchValue,
                pageNum: 1
            })
        }
    },
    mounted() {
        this.searchValue = this.$router.history.current.query.searchValue
        if (this.searchValue) {
            this.$store.dispatch('searchBytitle', {
                title: this.searchValue,
                pageNum: 1
            })
        } else {
            this.$store.dispatch('getInfoList', { pageNum: 1 })
        }
    }
}
</script>
<style>
.mint-header{
    z-index: 1000;
}
.mint-search-list {
    padding-top: 84px;
}
</style>
