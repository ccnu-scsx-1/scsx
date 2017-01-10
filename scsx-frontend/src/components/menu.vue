<template>
    <div class="v-menu" v-show="show" 
        :class="{search: type === 'search', user: type === 'user'}"
        @click="handleClick">
    </div>
</template>
<script>
export default {
    name: 'v-menu',
    props: {
        show: Boolean,
        type: String
    },
    methods:{
        handleClick(){
            if(this.type === 'user'){
                this.$store.dispatch('changeMenu', {className: 'search'})
                this.$router.push('/userinfo?role=' + this.$store.state.user.role)
            }else{
                this.$store.dispatch('changeMenu', {className: 'user'})
                this.$router.push('/market')
            }
        }
    }
}
</script>
<style lang="less" scoped>
@menudia: 60px;
@imgdia: 30px;
@bgColor: #26a2ff;
.v-menu {
    position: fixed;
    right: 15px;
    bottom: 15px;
    width: @menudia;
    height: @menudia;
    border: 1px solid @bgColor;
    border-radius: @menudia;
    z-index: 1000;
    &.user{
        background: url('../assets/user.png') no-repeat center @bgColor;
        background-size: @imgdia @imgdia;
    }

    &.search{
        background: url('../assets/search.png') no-repeat center @bgColor;
        background-size: @imgdia @imgdia;
    }
}
</style>
