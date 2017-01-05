<template>
    <div class="v-container">
        <mt-header title="个人信息"></mt-header>
        <mt-cell title="用户名" value="doge"></mt-cell>
        <mt-cell title="个人简历" to="/resume" is-link></mt-cell>
        <mt-cell title="职位意向" to="/intention" is-link></mt-cell>
        <mt-cell title="注册信息" to="/settings" is-link></mt-cell>
        <div class="logout-btn">
            <mt-button type="danger" size="large">退出登录</mt-button>
        </div>
        
</mt-cell>
    </div>
</template>
<script>
export default {
    name: 'UserInfo',
    data() {
        return {
        }
    }
}
</script>
<style lang="less" scoped>
    .logout-btn{
        padding: 20px 10px;
    }
</style>
