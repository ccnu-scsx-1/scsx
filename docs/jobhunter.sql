-- MySQL dump 10.13  Distrib 5.7.16, for osx10.12 (x86_64)
--
-- Host: localhost    Database: jobhunter
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (239),(239),(239),(239),(239),(239),(239);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_applydetail`
--

DROP TABLE IF EXISTS `t_applydetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_applydetail` (
  `id` int(11) NOT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  `pass` int(11) NOT NULL,
  `job_id` int(11) DEFAULT NULL,
  `resume_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9h01mf62rmv8vy94o0l93fqog` (`job_id`),
  KEY `FKnf7qqnx36p3ju02fxds4ywgyw` (`resume_id`),
  CONSTRAINT `FK9h01mf62rmv8vy94o0l93fqog` FOREIGN KEY (`job_id`) REFERENCES `t_job` (`id`),
  CONSTRAINT `FKnf7qqnx36p3ju02fxds4ywgyw` FOREIGN KEY (`resume_id`) REFERENCES `t_resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_applydetail`
--

LOCK TABLES `t_applydetail` WRITE;
/*!40000 ALTER TABLE `t_applydetail` DISABLE KEYS */;
INSERT INTO `t_applydetail` VALUES (238,'2017-01-15 02:13',0,1,1);
/*!40000 ALTER TABLE `t_applydetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_company`
--

DROP TABLE IF EXISTS `t_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `finanacestageid` int(11) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `industryid` int(11) NOT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `scaleid` int(11) NOT NULL,
  `shortname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_company`
--

LOCK TABLES `t_company` WRITE;
/*!40000 ALTER TABLE `t_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_dictionary`
--

DROP TABLE IF EXISTS `t_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_dictionary` (
  `dictitemid` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dicttypeid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dictitemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_dictionary`
--

LOCK TABLES `t_dictionary` WRITE;
/*!40000 ALTER TABLE `t_dictionary` DISABLE KEYS */;
INSERT INTO `t_dictionary` VALUES (1,'城市',1,'北京'),(2,'城市',1,'上海'),(3,'城市',1,'重庆'),(4,'城市',1,'石家�?'),(5,'城市',1,'郑州'),(6,'城市',1,'武汉'),(7,'城市',1,'长沙'),(8,'城市',1,'南京'),(9,'城市',1,'南昌'),(10,'城市',1,'沈阳'),(11,'城市',1,'长春'),(12,'城市',1,'哈尔�?'),(13,'城市',1,'西安'),(14,'城市',1,'太原'),(15,'城市',1,'济南'),(16,'城市',1,'成都'),(17,'城市',1,'西宁'),(18,'城市',1,'合肥'),(19,'城市',1,'海口'),(20,'城市',1,'广州'),(21,'城市',1,'贵阳'),(22,'城市',1,'杭州'),(23,'城市',1,'福州'),(24,'城市',1,'台北'),(25,'城市',1,'兰州'),(26,'城市',1,'昆明'),(27,'城市',1,'拉萨'),(28,'城市',1,'银川'),(29,'城市',1,'南宁'),(30,'城市',1,'乌鲁木齐'),(31,'城市',1,'呼和浩特'),(32,'城市',1,'香港'),(33,'城市',1,'澳门'),(34,'工资',2,'3k以下'),(35,'工资',2,'3k-5k'),(36,'工资',2,'5k-10k'),(37,'工资',2,'10k-20k'),(38,'工资',2,'20k-50k'),(39,'工资',2,'50k以上'),(40,'工作经验',3,'应届�?'),(41,'工作经验',3,'1年以�?'),(42,'工作经验',3,'1-3�?'),(43,'工作经验',3,'3-5�?'),(44,'工作经验',3,'5-10�?'),(45,'工作经验',3,'10年以�?'),(46,'学历',4,'大专'),(47,'学历',4,'本科'),(48,'学历',4,'硕士'),(49,'学历',4,'博士'),(50,'求职状�?',5,'离职-随时到岗'),(51,'求职状�?',5,'在职-考虑机会'),(52,'求职状�?',5,'在职-月内到岗'),(53,'求职状�?',5,'在职-暂不考虑'),(54,'公司规模',6,'0-20�?'),(55,'公司规模',6,'20-99�?'),(56,'公司规模',6,'100-499�?'),(57,'公司规模',6,'500-999�?'),(58,'公司规模',6,'1000-9999�?'),(59,'公司规模',6,'10000人以�?'),(60,'后端开�?',7,'Java'),(61,'后端开�?',7,'PHP'),(62,'后端开�?',7,'C++'),(63,'后端开�?',7,'.NET'),(64,'后端开�?',7,'C'),(65,'后端开�?',7,'数据挖掘'),(66,'后端开�?',7,'Python'),(67,'后端开�?',7,'C#'),(68,'后端开�?',7,'Hadoop'),(69,'后端开�?',7,'Node.js'),(70,'后端开�?',7,'算法工程�?'),(71,'后端开�?',7,'数据采集'),(72,'后端开�?',7,'Delphi'),(73,'后端开�?',7,'Ruby'),(74,'后端开�?',7,'Golang'),(75,'后端开�?',7,'自然语言处理'),(76,'后端开�?',7,'推荐算法'),(77,'后端开�?',7,'语言/视频/图形开�?'),(78,'后端开�?',7,'VB'),(79,'后端开�?',7,'Perl'),(80,'后端开�?',7,'搜索算法'),(81,'后端开�?',7,'Erlang'),(82,'移动开�?',8,'Android'),(83,'移动开�?',8,'iOS'),(84,'移动开�?',8,'Web前端'),(85,'移动开�?',8,'HTML5'),(86,'移动开�?',8,'U3D'),(87,'移动开�?',8,'COCOS2DX'),(88,'移动开�?',8,'Flash'),(89,'移动开�?',8,'JavaScript'),(90,'移动开�?',8,'WP'),(91,'测试',9,'测试工程�?'),(92,'测试',9,'软件测试'),(93,'测试',9,'功能测试'),(94,'测试',9,'自动化测�?'),(95,'测试',9,'移动端测�?'),(96,'测试',9,'硬件测试'),(97,'测试',9,'游戏测试'),(98,'测试',9,'性能测试'),(99,'测试',9,'测试开�?'),(100,'前端开�?',10,'web前端'),(101,'前端开�?',10,'HTML5'),(102,'前端开�?',10,'JavaScript'),(103,'前端开�?',10,'Flash'),(104,'项目管理',11,'项目经理'),(105,'项目管理',11,'项目主管'),(106,'项目管理',11,'项目助理'),(107,'项目管理',11,'实施顾问'),(108,'项目管理',11,'实施工程�?'),(109,'项目管理',11,'需求分析工程师'),(110,'项目管理',11,'项目专员'),(111,'运维/技术支�?',12,'运维工程�?'),(112,'运维/技术支�?',12,'网络工程�?'),(113,'运维/技术支�?',12,'IT技术支�?'),(114,'运维/技术支�?',12,'网络安全'),(115,'运维/技术支�?',12,'运维开发工程师'),(116,'运维/技术支�?',12,'系统工程�?'),(117,'运维/技术支�?',12,'系统管理�?'),(118,'运维/技术支�?',12,'系统安全'),(119,'高端技术职�?',13,'技术总监'),(120,'高端技术职�?',13,'技术经�?'),(121,'高端技术职�?',13,'架构�?'),(122,'高端技术职�?',13,'CTO'),(123,'高端技术职�?',13,'技术合伙人'),(124,'高端技术职�?',13,'测试经理'),(125,'高端技术职�?',13,'运维总监'),(126,'硬件开�?',14,'硬件'),(127,'硬件开�?',14,'嵌入�?'),(128,'硬件开�?',14,'自动�?'),(129,'硬件开�?',14,'FPGA开�?'),(130,'硬件开�?',14,'电路设计'),(131,'硬件开�?',14,'驱动开�?'),(132,'硬件开�?',14,'模具设计'),(133,'硬件开�?',14,'射频工程�?'),(134,'硬件开�?',14,'单片�?'),(135,'硬件开�?',14,'系统集成'),(136,'硬件开�?',14,'材料工程�?'),(137,'硬件开�?',14,'DSP开�?'),(138,'硬件开�?',14,'ARM开�?'),(139,'硬件开�?',14,'PCB工艺'),(140,'硬件开�?',14,'热传�?'),(141,'硬件开�?',14,'精益工程�?'),(142,'数据',15,'数据挖掘'),(143,'数据',15,'数据仓库'),(144,'数据',15,'数据处理工程�?'),(145,'数据',15,'MySQL'),(146,'数据',15,'SQLServer'),(147,'数据',15,'数据架构�?'),(148,'数据',15,'DB2'),(149,'数据',15,'MongoDB'),(150,'数据',15,'ETLHive'),(151,'通信',16,'通信技术工程师'),(152,'通信',16,'通信研发工程�?'),(153,'通信',16,'通信项目专员'),(154,'通信',16,'通信设备工程�?'),(155,'通信',16,'光通信工程�?'),(156,'通信',16,'光传输工程师'),(157,'通信',16,'光网络工程师'),(158,'通信',16,'数据通信工程�?'),(159,'通信',16,'移动通信工程�?'),(160,'通信',16,'电信网络工程�?'),(161,'通信',16,'电信交换工程�?'),(162,'通信',16,'有线传输工程�?'),(163,'通信',16,'无线射频工程�?'),(164,'通信',16,'通信电源工程�?'),(165,'通信',16,'通信标准化工程师'),(166,'通信',16,'通信项目经理'),(167,'软件销售支�?',17,'售前工程�?'),(168,'软件销售支�?',17,'售后工程�?'),(169,'产品经理',18,'产品经理'),(170,'产品经理',18,'网页产品经理'),(171,'产品经理',18,'移动产品经理'),(172,'产品经理',18,'产品助理'),(173,'产品经理',18,'数据产品经理'),(174,'产品经理',18,'电商产品经理'),(175,'产品经理',18,'游戏策划'),(176,'学校',19,'武汉大学'),(177,'学校',19,'华中科技大学'),(178,'学校',19,'华中师范大学'),(179,'学校',19,'中南财经政法大学'),(180,'学校',19,'华中农业大学'),(181,'学校',19,'中山大学'),(182,'学校',19,'华南理工大学'),(183,'学校',19,'暨南大学'),(184,'学校',19,'复旦大学'),(185,'学校',19,'同济大学'),(186,'学校',19,'上海交通大�?'),(187,'学校',19,'华东理工大学'),(188,'学校',19,'郑州大学'),(189,'学校',19,'中国海洋大学'),(190,'学校',19,'山东大学'),(191,'学校',19,'四川大学'),(192,'学校',19,'西南交通大�?'),(193,'学校',19,'电子科技大学'),(194,'学校',19,'安徽大学'),(195,'学校',19,'中国科学技术大�?'),(196,'学校',19,'东北大学'),(197,'学校',19,'大连理工大学'),(198,'学校',19,'重庆大学'),(199,'学校',19,'西南大学'),(200,'学校',19,'云南大学'),(201,'学校',19,'西安交通大�?'),(202,'学校',19,'西北工业大学'),(203,'学校',19,'西安电子科技大学'),(204,'学校',19,'南京大学'),(205,'学校',19,'南京航空航天大学'),(206,'学校',19,'东南大学'),(207,'学校',19,'湖南大学'),(208,'学校',19,'国防科学技术大�?'),(209,'学校',19,'中南大学'),(210,'学校',19,'贵州大学'),(211,'学校',19,'南昌大学'),(212,'学校',19,'北京大学'),(213,'学校',19,'清华大学'),(214,'学校',19,'北京交通大�?'),(215,'学校',19,'北京航空航天大学'),(216,'学校',19,'北京邮电大学'),(217,'学校',19,'南开大学'),(218,'学校',19,'天津大学'),(219,'学校',19,'浙江大学'),(220,'学校',19,'太原理工大学'),(221,'学校',19,'厦门大学'),(222,'学校',19,'广西大学'),(223,'学校',19,'海南大学'),(224,'学校',19,'吉林大学'),(225,'学校',19,'兰州大学'),(226,'学校',19,'哈尔滨工业大�?'),(227,'学校',19,'东北林业大学'),(228,'融资规模',20,'天使�?'),(229,'融资规模',20,'A�?'),(230,'融资规模',20,'B�?'),(231,'融资规模',20,'上市'),(232,'公司行业',21,'IT');
/*!40000 ALTER TABLE `t_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_educationexperience`
--

DROP TABLE IF EXISTS `t_educationexperience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_educationexperience` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `diplomaid` int(11) NOT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `schoolid` int(11) NOT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  `resume_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmwubmhwa8heo1im0b9r4kk2i5` (`resume_id`),
  CONSTRAINT `FKmwubmhwa8heo1im0b9r4kk2i5` FOREIGN KEY (`resume_id`) REFERENCES `t_resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_educationexperience`
--

LOCK TABLES `t_educationexperience` WRITE;
/*!40000 ALTER TABLE `t_educationexperience` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_educationexperience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_favorite`
--

DROP TABLE IF EXISTS `t_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_favorite` (
  `id` int(11) NOT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq85i466s6migef0onv1i11clb` (`user_id`),
  CONSTRAINT `FKq85i466s6migef0onv1i11clb` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_favorite`
--

LOCK TABLES `t_favorite` WRITE;
/*!40000 ALTER TABLE `t_favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_job`
--

DROP TABLE IF EXISTS `t_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cityid` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `diplomaid` int(11) NOT NULL,
  `experienceid` int(11) NOT NULL,
  `isclosed` int(11) NOT NULL,
  `jobname` varchar(255) DEFAULT NULL,
  `jobtypeid` int(11) NOT NULL,
  `salaryid` int(11) NOT NULL,
  `skillid` int(11) NOT NULL,
  `workaddress` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsc1d6mk8frghrqfuvdp2bswu7` (`user_id`),
  CONSTRAINT `FKsc1d6mk8frghrqfuvdp2bswu7` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_job`
--

LOCK TABLES `t_job` WRITE;
/*!40000 ALTER TABLE `t_job` DISABLE KEYS */;
INSERT INTO `t_job` VALUES (1,1,'面谈',47,40,0,'Java工程�?',0,37,60,'朝阳�?',2);
/*!40000 ALTER TABLE `t_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_jobstatistics`
--

DROP TABLE IF EXISTS `t_jobstatistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_jobstatistics` (
  `id` int(11) NOT NULL,
  `browsecount` int(11) NOT NULL,
  `sharecount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_jobstatistics`
--

LOCK TABLES `t_jobstatistics` WRITE;
/*!40000 ALTER TABLE `t_jobstatistics` DISABLE KEYS */;
INSERT INTO `t_jobstatistics` VALUES (1,12,4);
/*!40000 ALTER TABLE `t_jobstatistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_projectexperience`
--

DROP TABLE IF EXISTS `t_projectexperience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_projectexperience` (
  `id` int(11) NOT NULL,
  `achievement` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  `projectname` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `resume_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe5drsg2wht1wxjcdndtsibo9b` (`resume_id`),
  CONSTRAINT `FKe5drsg2wht1wxjcdndtsibo9b` FOREIGN KEY (`resume_id`) REFERENCES `t_resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_projectexperience`
--

LOCK TABLES `t_projectexperience` WRITE;
/*!40000 ALTER TABLE `t_projectexperience` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_projectexperience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_resume`
--

DROP TABLE IF EXISTS `t_resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_resume` (
  `id` int(11) NOT NULL,
  `advantage` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `ishide` int(11) NOT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `statusid` int(11) NOT NULL,
  `workexperience` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resume`
--

LOCK TABLES `t_resume` WRITE;
/*!40000 ALTER TABLE `t_resume` DISABLE KEYS */;
INSERT INTO `t_resume` VALUES (1,NULL,NULL,NULL,0,NULL,0,40),(2,'善于组织人员',NULL,NULL,0,NULL,50,43);
/*!40000 ALTER TABLE `t_resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `portrait` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `telnumber` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'534427411@qq.com','123','6',1,'18140663658','吴尚�?','wsy19941006'),(2,'892521916@qq.com','123','3',1,'15527588384','熊英','xiongying');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_workexperience`
--

DROP TABLE IF EXISTS `t_workexperience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_workexperience` (
  `id` int(11) NOT NULL,
  `cityid` int(11) NOT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  `industryid` int(11) NOT NULL,
  `ishide` int(11) NOT NULL,
  `jobname` varchar(255) DEFAULT NULL,
  `jobtypeid` int(11) NOT NULL,
  `skillid` int(11) NOT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  `resume_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK82kjso4od355kdea0v3fg8lbh` (`resume_id`),
  CONSTRAINT `FK82kjso4od355kdea0v3fg8lbh` FOREIGN KEY (`resume_id`) REFERENCES `t_resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_workexperience`
--

LOCK TABLES `t_workexperience` WRITE;
/*!40000 ALTER TABLE `t_workexperience` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_workexperience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_workpurpose`
--

DROP TABLE IF EXISTS `t_workpurpose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_workpurpose` (
  `id` int(11) NOT NULL,
  `cityid` int(11) NOT NULL,
  `industryid` int(11) NOT NULL,
  `salaryid` int(11) NOT NULL,
  `skillid` int(11) NOT NULL,
  `resume_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKajgv7g5jyod1b47x3n5lf7by2` (`resume_id`),
  CONSTRAINT `FKajgv7g5jyod1b47x3n5lf7by2` FOREIGN KEY (`resume_id`) REFERENCES `t_resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_workpurpose`
--

LOCK TABLES `t_workpurpose` WRITE;
/*!40000 ALTER TABLE `t_workpurpose` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_workpurpose` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-15  9:23:37
