<template>
    <div>
        <mt-header title="职位详情">
            <router-link to="/" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
        </mt-header>
        <div class="job-detail">
            <div class="job-title">web前端</div>
            <div class="job-info">
                10k
            </div>
            <div class="company-info">
                <p>旺旺集团</p>
                <p>联系方式：123123123123</p>
            </div>
            <div class="job-desc">
                <div class="desc-title">职位描述</div>
                <div class="desc-content">JAVA基础扎实：熟练掌握数据结构、多线程编程，掌握常用的设计模式；熟悉JVM，包括内存模型、类加载机制以及性能优化；JAVA基础扎实：熟练掌握数据结构、多线程编程，掌握常用的设计模式；熟悉JVM，包括内存模型、类加载机制以及性能优化；JAVA基础扎实：熟练掌握数据结构、多线程编程，掌握常用的设计模式；熟悉JVM，包括内存模型、类加载机制以及性能优化；JAVA基础扎实：熟练掌握数据结构、多线程编程，掌握常用的设计模式；熟悉JVM，包括内存模型、类加载机制以及性能优化；</div>
            </div>
        </div>
        <div class="job-vote"><mt-button @click.native="clickVoteResume" type="primary" size="large">投个简历</mt-button></div>
        
    </div>
</template>
<script>
export default {
    name: 'Market',
    data() {
        return {}
    },
    methods: {
        clickVoteResume(){

        }
    }
}
</script>
<style lang="less" scoped>
.job-detail {
    width: 100%;
}

.job-title{
    width: 100%;
    height: 40px;
    line-height: 40px;
    font-size: 16px;
    font-weight: bold;
    border-bottom: 1px solid #d9d9d9;
    padding: 0 10px;
}

.job-info{
    width: 100%;
    height: 100px;
    border-bottom: 1px solid #d9d9d9;
    padding: 10px;
}

.company-info{
    width: 100%;
    height: 100px;
    border-bottom: 1px solid #d9d9d9;
    padding: 10px;
}

.job-desc{
    width: 100%;
    border-bottom: 1px solid #d9d9d9;
    font-size: 12px;
    .desc-title{
        width: 100%;
        background: #26a2ff;
        color: #fff;
        padding: 10px;
    }
    .desc-content{
        width:100%;
        padding: 15px 10px;
    }
}


.job-vote{
    padding: 20px 10px;
}

</style>
