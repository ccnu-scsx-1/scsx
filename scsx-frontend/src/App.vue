<template>
    <div id="app">
        <router-view></router-view>
        <v-menu :show="isShow" :type="menuClass"></v-menu>
    </div>
</template>
<script>
import { mapGetters } from 'vuex'
import VMenu from 'components/menu'

export default {
    name: 'app',
    components:{
        VMenu
    },
    computed: mapGetters([
        'isShow',
        'menuClass'
    ]),
    methods:{
        clickGoSearch(){
            this.$router.push('/market')
        },
        clickGoUserInfo(){
            this.$router.push('/userinfo')
        },
        clickGoStar(){
            this.$router.push('/star')
        }
    },
    mounted(){
        let path = this.$router.history.current.path

        if((['/home', '/login', '/register', '/registercom'].join(',').indexOf(path)) === -1){
            this.$store.dispatch('logStatus')
        }
    }
}
</script>
<style>
html,
body,
div {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: PingFang-SC-Regular, Helvetica Neue, Helvetica, "Microsoft Yahei", sans-serif;
}

html,
body {
    height: 100%;
    width: 100%;
}

#app {
    height: 100%;
    width: 100%;
}

input,
label,
select,
option,
textarea,
button,
fieldset,
legend {
    font-family: inherit;
}

select,
option,
button {
    font-size: 16px;
}

input[type=search]::-webkit-search-cancel-button {
    -webkit-appearance: none;
}

a {
    text-decoration: none;
}

select {
    appearance: none;
    border: none;
}

.mint-header-title {
    font-size: 16px;
}


.icon-search{
    background: url('assets/search.png') no-repeat center;
}

.icon-user{
    background: url('assets/user.png') no-repeat center;
}

.icon-star{
    background: url('assets/star.png') no-repeat center;
}

.icon-search,.icon-user,.icon-star{
    background-size: 25px 25px;
    background-color: #26a2ff;
    border-radius: 25px;
}



</style>
