/*
 Navicat Premium Data Transfer

 Source Server         : Cai
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 123.207.254.19
 Source Database       : scsx

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : utf-8

 Date: 01/15/2017 11:31:44 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `scsx_company`
-- ----------------------------
DROP TABLE IF EXISTS `scsx_company`;
CREATE TABLE `scsx_company` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司id',
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司HR',
  `name` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名',
  `url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司网址',
  `tel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司电话',
  `email` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司邮箱',
  `address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司地址',
  `introduction` text COLLATE utf8_unicode_ci COMMENT '公司简介',
  `scale` int(11) DEFAULT NULL COMMENT '公司规模',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `scsx_contact`
-- ----------------------------
DROP TABLE IF EXISTS `scsx_contact`;
CREATE TABLE `scsx_contact` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户id',
  `info_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '简历id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `scsx_feed_con`
-- ----------------------------
DROP TABLE IF EXISTS `scsx_feed_con`;
CREATE TABLE `scsx_feed_con` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `feedback_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `role` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `scsx_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `scsx_feedback`;
CREATE TABLE `scsx_feedback` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '反馈id',
  `info_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '招聘贴id',
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT '反馈内容',
  `result` tinyint(1) NOT NULL COMMENT '结果',
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `scsx_recruit_info`
-- ----------------------------
DROP TABLE IF EXISTS `scsx_recruit_info`;
CREATE TABLE `scsx_recruit_info` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '招聘记录id',
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '发帖人',
  `company_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发帖人所属公司',
  `title` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '主题',
  `salary_low` int(11) DEFAULT NULL COMMENT '最低薪资',
  `salary_high` int(11) DEFAULT NULL COMMENT '最高薪资',
  `region` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '地区',
  `education` tinyint(3) DEFAULT NULL COMMENT '最低学历',
  `type` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '该职位所在的分类',
  `position` tinyint(4) DEFAULT NULL COMMENT '职位',
  `year_work` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作年限',
  `description` text COLLATE utf8_unicode_ci COMMENT '职位描述',
  `last_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `scsx_resume`
-- ----------------------------
DROP TABLE IF EXISTS `scsx_resume`;
CREATE TABLE `scsx_resume` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '简历id',
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '求职者id',
  `name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `email` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `number` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `age` tinyint(8) DEFAULT NULL COMMENT '年龄',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `position` tinyint(4) DEFAULT NULL COMMENT '所求职位类型(类型)',
  `skill_label` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '掌握技能',
  `resume_path` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附件简历地址',
  `school` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '毕业学校',
  `major` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专业',
  `education` tinyint(3) DEFAULT NULL COMMENT '学历',
  `education_start` datetime DEFAULT NULL COMMENT '在校开始时间',
  `education_end` datetime DEFAULT NULL COMMENT '离校时间',
  `company` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上家公司',
  `company_start` date DEFAULT NULL COMMENT '开始时间',
  `company_end` date DEFAULT NULL COMMENT '结束时间',
  `company_content` text COLLATE utf8_unicode_ci COMMENT '工作内容',
  `edu_exp` text COLLATE utf8_unicode_ci COMMENT '教育经历',
  `work_exp` text COLLATE utf8_unicode_ci COMMENT '工作经历',
  `pro_exp` text COLLATE utf8_unicode_ci COMMENT '项目经历',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `scsx_user`
-- ----------------------------
DROP TABLE IF EXISTS `scsx_user`;
CREATE TABLE `scsx_user` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `gender` tinyint(1) DEFAULT '0' COMMENT '0为男，1为女',
  `age` tinyint(4) DEFAULT NULL,
  `number` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `position` tinyint(4) DEFAULT NULL COMMENT '意向职位,用枚举类型表示',
  `role` tinyint(1) NOT NULL COMMENT '用户类型:0为求职者,1为HR',
  `resume_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '简历id',
  `info_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '招聘贴id',
  `year_work` tinyint(8) DEFAULT NULL COMMENT '工作年限',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
