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
div{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

input[type=search]::-webkit-search-cancel-button {
    -webkit-appearance: none;
}

a {
    text-decoration: none;
}

select{
    appearance: none;
    border: none;
}

</style>
