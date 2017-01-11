<template>
    <div class="v-container">
        <mt-header title="个人简历"></mt-header>
        <div class="info-part">
            <mt-field label="姓名" placeholder="请输入姓名" v-model="resumeName"></mt-field>
            <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="resumeEmail"></mt-field>
            <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="resumeTel"></mt-field>
            <mt-field label="年龄" placeholder="请输入年龄" type="number" v-model="resumeAge"></mt-field>
            <mt-cell title="性别">
                <select v-model="resumeGender" style="width: 250px;">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </mt-cell>
        </div>
        <div class="info-part">
            <mt-field label="教育经历" placeholder="请输入您的教育经历" type="textarea" v-model="resumeEdu"></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="工作经历" placeholder="请输入您的工作经历" type="textarea" v-model="resumeCom"></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="项目经历" placeholder="请输入您的项目经历" type="textarea" v-model="resumeProject"></mt-field>
        </div>
        <div class="info-part">
            <mt-field label="我的技能" placeholder="请输入您的技能，优势或特长" type="textarea" v-model="resumeSkill"></mt-field>
        </div>
        <div class="info-part">
            <mt-button plain @click="clickCancel">返&nbsp;回</mt-button>
            <mt-button type="primary" @click="clickSave">保&nbsp;存</mt-button>
        </div>
    </div>
</template>
<script>
import { MessageBox } from 'mint-ui'
export default {
    name: 'Resume',
    computed: {
        resumeName: {
            get() {
                return this.$store.state.resume.resumeName
            },
            set(value) {
                this.$store.state.resume.resumeName = value
            }
        },
        resumeEmail: {
            get() {
                return this.$store.state.resume.resumeEmail
            },
            set(value) {
                this.$store.state.resume.resumeEmail = value
            }
        },
        resumeTel: {
            get() {
                return this.$store.state.resume.resumeTel
            },
            set(value) {
                this.$store.state.resume.resumeTel = value
            }
        },
        resumeAge: {
            get() {
                return this.$store.state.resume.resumeAge
            },
            set(value) {
                this.$store.state.resume.resumeAge = value
            }
        },
        resumeGender: {
            get() {
                return this.$store.state.resume.resumeGender
            },
            set(value) {
                this.$store.state.resume.resumeGender = value
            }
        },
        resumeEdu: {
            get() {
                return this.$store.state.resume.resumeEdu
            },
            set(value) {
                this.$store.state.resume.resumeEdu = value
            }
        },
        resumeCom: {
            get() {
                return this.$store.state.resume.resumeCom
            },
            set(value) {
                this.$store.state.resume.resumeCom = value
            }
        },
        resumeProject: {
            get() {
                return this.$store.state.resume.resumeProject
            },
            set(value) {
                this.$store.state.resume.resumeProject = value
            }
        },
        resumeSkill: {
            get() {
                return this.$store.state.resume.resumeSkill
            },
            set(value) {
                this.$store.state.resume.resumeSkill = value
            }
        }
    },
    methods: {
        clickCancel() {
            MessageBox.confirm('当前修改未保存，是否直接返回？').then(action => {
                this.$router.push('/userinfo?role=0')
            }, action => {})
        },
        clickSave() {
            this.$store.dispatch('saveResume', { userId: this.$store.state.user.userid })
        }
    },
    mounted() {
        this.$store.dispatch('loadResume', { userId: this.$store.state.user.userid })
    }
}
</script>
<style lang="less" scoped>
.info-part {
    margin-top: 10px;
    &:last-child {
        display: flex;
        button {
            flex: 1;
            margin: 10px;
        }
    }
}
</style>
