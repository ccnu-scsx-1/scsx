<template>
    <div>
        <mt-header title="PT网">
        </mt-header>
        <mt-search class="searchBar" v-model="searchValue" placeholder="搜索公司或者岗位">
            <mt-cell to="/jobdetail" v-for="item in result" :title="item.title" :value="item.value" :label="item.label" is-link></mt-cell>
        </mt-search>
    </div>
</template>
<script>
export default {
    name: 'Market',
    data() {
        return {
            searchValue: '',
            result: [{
                title: 'web前端',
                label: '旺旺集团',
                value: '10k-20k'
            }, {
                title: 'Java后台',
                label: '旺旺集团',
                value: '10k-20k'
            }, {
                title: 'PHP',
                label: '旺旺集团',
                value: '10k-20k'
            }]
        }
    },
    methods: {


    },
    mounted() {
        this.searchValue = this.$router.history.current.query.searchValue
    }
}
</script>
<style>
.mint-search-list {
    padding-top: 84px;
}
</style>
