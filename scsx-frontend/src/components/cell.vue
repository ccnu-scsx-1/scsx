<template>
    <div class="v-cell" @click="handleClick">
        <div class="v-left">
            <div class="v-title">{{ title }}</div>
            <div class="v-detail">
                <div class="v-company">{{ company }}</div>
                <div class="v-region">{{ region }}</div>
            </div>
        </div>
        <div class="v-right">
            <div class="v-salary">{{ salary }}</div>
        </div>
    </div>
</template>
<script>
export default {
    name: 'v-cell',
    props: {
        link: Object,
        title: String,
        company: String,
        region: String,
        salary: String
    },
    methods: {
        handleClick(){
            this.$router.push(this.link)
        }
    }
}
</script>
<style lang="less" scoped>
.v-cell {
    display: flex;
    height: 70px;
    width: 100%;
    justify-content: space-between;
    border-bottom: 1px solid #d9d9d9;
    padding: 10px;
    .v-left {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        .v-title {
            font-size: 18px;
            font-weight: bold;
        }
        .v-detail {
            display: flex;
            .v-company {
                margin-right: 10px;
            }
        }
    }
    .v-right {
        position: relative;
        display: flex;
        align-items: center;
        .v-salary {
            font-size: 18px;
            margin-right: 25px;
        }
        &:after {
            border: solid 2px #c8c8cd;
            border-bottom-width: 0;
            border-left-width: 0;
            content: " ";
            top: 50%;
            right: 10px;
            position: absolute;
            width: 5px;
            height: 5px;
            transform: translateY(-50%) rotate(45deg);
        }
    }
}
</style>
