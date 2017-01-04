<template>
    <div>
        <mt-header title="xxx网">
            <!-- <router-link to="/" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link> -->
            <!-- <a href="/" slot="left">&lt;返回</a> -->
        </mt-header>
        <mt-search class="searchBar" v-model="searchValue" placeholder="搜索公司或者岗位">
            <mt-cell v-for="item in result" :title="item.title" :value="item.value"></mt-cell>
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
                title: '呵呵',
                value: '12312312'
            }, {
                title: '呵呵',
                value: '12312312'
            }, {
                title: '呵呵',
                value: '12312312'
            }]
        }
    },
    methods: {}
}
</script>
