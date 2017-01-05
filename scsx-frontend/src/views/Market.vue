<template>
    <div>
        <mt-header title="PT网">
            <!-- <router-link to="/" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link> -->
            <!-- <a href="/" slot="left">&lt;返回</a> -->
        </mt-header>
        <mt-search class="searchBar" v-model="searchValue" placeholder="搜索公司或者岗位" @click.native="clickInfoCell">
            <mt-cell data-infoid="infoid" v-for="item in result" :title="item.title" :value="item.value" :label="item.label" is-link></mt-cell>
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
        clickInfoCell(event){
            let infoid = event.target.dataset.infoid || event.target.parentNode.dataset.infoid
            
            if(infoid){
                this.$router.push({path:'/jobdetail', query: {"infoid": infoid}})
            }
            
        }
    }
}
</script>
<style>
.mint-search-list {
    padding-top: 84px;
}
</style>
