<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>
<script>
export default {
    name: 'app'
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

select, option, button{
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
</style>
