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
body {
    margin: 0;
    padding: 0;
}

input[type=search]::-webkit-search-cancel-button {
    -webkit-appearance: none;
}

a {
    text-decoration: none;
}
</style>
