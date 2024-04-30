-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carbon_trading
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(30) DEFAULT NULL COMMENT '账号',
  `password` varchar(30) DEFAULT NULL COMMENT '密码',
  `name` varchar(30) DEFAULT NULL COMMENT '管理名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin','管理员','2024-04-10 16:28:10');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agency`
--

DROP TABLE IF EXISTS `agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agency` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(30) DEFAULT NULL COMMENT '账号',
  `password` varchar(30) DEFAULT NULL COMMENT '密码',
  `name` varchar(30) DEFAULT NULL COMMENT '机构名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
INSERT INTO `agency` VALUES (1,'1336679971','j','监管局','2024-04-10 16:29:42');
/*!40000 ALTER TABLE `agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electric_grid`
--

DROP TABLE IF EXISTS `electric_grid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `electric_grid` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(30) NOT NULL COMMENT '账号',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `status` varchar(10) NOT NULL COMMENT '状态',
  `consumption` double NOT NULL DEFAULT '0' COMMENT '消耗的碳',
  `PPGCP` double NOT NULL DEFAULT '0' COMMENT '电厂上网电量',
  `IIE` double NOT NULL DEFAULT '0' COMMENT '自外省输入电量',
  `IEE` double NOT NULL DEFAULT '0' COMMENT '向外省输出电量',
  `electricity_sales` double NOT NULL DEFAULT '0' COMMENT '售电量',
  `transmission_distribution` double NOT NULL DEFAULT '0' COMMENT '输配电量',
  `retirement_capacity` double NOT NULL DEFAULT '0' COMMENT '退休设备总容量',
  `retirement_recovery` double NOT NULL DEFAULT '0' COMMENT '退休设备总回收量',
  `fix_capacity` double NOT NULL DEFAULT '0' COMMENT '修理设备总容量',
  `fix_recovery` double NOT NULL DEFAULT '0' COMMENT '修理设备总回收量',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `map_id` varchar(40) DEFAULT NULL COMMENT '映射在fisco的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electric_grid`
--

LOCK TABLES `electric_grid` WRITE;
/*!40000 ALTER TABLE `electric_grid` DISABLE KEYS */;
INSERT INTO `electric_grid` VALUES (5,'2022117117','2024-04-10 16:16:00','已通过',402,23,123,654,123,110,30,420,43,435,'叶寄樱','5'),(7,'2022117117','2024-04-21 22:16:29','已通过',-299,213,243,321,213,8,789,67,45,34,'叶寄樱','8'),(8,'2022111335','2024-04-25 08:25:39','已通过',-227,42,23,3,435,56,45,34,39,67,'裴公','12');
/*!40000 ALTER TABLE `electric_grid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enterprise`
--

DROP TABLE IF EXISTS `enterprise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enterprise` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '企业名称',
  `type` varchar(20) NOT NULL COMMENT '企业类型',
  `account` varchar(30) NOT NULL COMMENT '账号',
  `password` varchar(30) NOT NULL COMMENT '密码',
  `carbon_coin` double NOT NULL DEFAULT '10000000' COMMENT '碳币',
  `trade_count` int NOT NULL DEFAULT '0' COMMENT '交易数量',
  `submit_count` int NOT NULL DEFAULT '0' COMMENT '提交数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enterprise`
--

LOCK TABLES `enterprise` WRITE;
/*!40000 ALTER TABLE `enterprise` DISABLE KEYS */;
INSERT INTO `enterprise` VALUES (2,'梦浮羽','发电','2022117316','j',322488.6949,10,8,'2024-04-10 16:30:39'),(3,'叶寄樱','电网','2022117117','j',23123588,7,3,'2024-04-10 16:30:40'),(5,'孙佳浩','发电','2022117127','j',9999334,2,1,'2024-04-24 15:06:21'),(6,'裴公','电网','2022111335','j',10000127,1,1,'2024-04-25 08:25:01'),(7,'yuki','发电','2022117204','j',10000000,0,0,'2024-04-25 21:56:47'),(8,'田所浩二','发电','2022114514','j',191981000,0,1,'2024-04-26 08:42:01');
/*!40000 ALTER TABLE `enterprise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generate_electricity`
--

DROP TABLE IF EXISTS `generate_electricity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generate_electricity` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(30) NOT NULL COMMENT '账号',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `status` varchar(10) NOT NULL COMMENT '状态',
  `consumption` double NOT NULL DEFAULT '0' COMMENT '消耗的碳',
  `coal_burning` double NOT NULL DEFAULT '0' COMMENT '燃煤消耗量',
  `crude_oil` double NOT NULL DEFAULT '0' COMMENT '原油消耗量',
  `fuel_oil` double NOT NULL DEFAULT '0' COMMENT '燃料油消耗量',
  `gasoline` double NOT NULL DEFAULT '0' COMMENT '汽油消耗量',
  `refinery_gas` double NOT NULL DEFAULT '0' COMMENT '炼厂干气消耗量',
  `other_products` double NOT NULL DEFAULT '0' COMMENT '其他制品消耗量',
  `natural_gas` double NOT NULL DEFAULT '0' COMMENT '天然气消耗量',
  `coke_oven_gas` double NOT NULL DEFAULT '0' COMMENT '焦炉煤气消耗量',
  `other_gas` double NOT NULL DEFAULT '0' COMMENT '其他煤气消耗量',
  `desulfurizing_agent` double NOT NULL DEFAULT '0' COMMENT '脱硫剂消耗量',
  `electricity` double NOT NULL DEFAULT '0' COMMENT '电力购入量',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `map_id` varchar(40) DEFAULT NULL COMMENT '映射在fisco的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generate_electricity`
--

LOCK TABLES `generate_electricity` WRITE;
/*!40000 ALTER TABLE `generate_electricity` DISABLE KEYS */;
INSERT INTO `generate_electricity` VALUES (9,'2022117316','2024-04-21 19:13:02','已通过',940.3051,123,23,32,435,23,3,2,213,23,1,9,'梦浮羽','9'),(10,'2022117316','2024-04-24 11:34:07','待审核',3105.1626,1423,323,78,75,76,63,64,112,5,213,45,'梦浮羽',NULL),(11,'2022117316','2024-04-24 11:34:18','待审核',3162.8089,123,923,878,75,76,63,64,142,5,213,45,'梦浮羽',NULL),(12,'2022117316','2024-04-24 11:34:34','待审核',3203.4485,233,923,878,35,76,3,64,12,65,213,45,'梦浮羽',NULL),(13,'2022117316','2024-04-24 11:35:58','待审核',2315.1284,233,93,78,435,768,3,4,172,45,213,4,'梦浮羽',NULL),(14,'2022117316','2024-04-24 11:36:15','待审核',2197.0041,23,3,728,45,78,43,34,12,4,2313,4,'梦浮羽',NULL),(15,'2022117316','2024-04-24 11:36:29','待审核',523.3907,23,3,72,5,8,3,334,12,44,23,44,'梦浮羽',NULL),(16,'2022117127','2024-04-24 15:06:43','待审核',2523.6347,231,31,456,54,23,23,345,767,768,56,2,'孙佳浩',NULL),(17,'2022114514','2024-04-26 08:43:01','待审核',6713.7955,2512,512,32,435,908,34,234,654,43,34,123,'田所浩二',NULL);
/*!40000 ALTER TABLE `generate_electricity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trade` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `initiator_account` varchar(30) NOT NULL COMMENT '发起者账号',
  `receiver_account` varchar(30) NOT NULL COMMENT '接收者账号',
  `content` varchar(4000) NOT NULL COMMENT '交易内容',
  `pay_coin` double NOT NULL COMMENT '交易碳币',
  `status` varchar(30) NOT NULL COMMENT '交易状态',
  `create_date` datetime NOT NULL COMMENT '发起时间',
  `initiator_name` varchar(30) DEFAULT NULL COMMENT '发起者名称',
  `receiver_name` varchar(30) DEFAULT NULL COMMENT '接收者名称',
  `map_id` varchar(40) DEFAULT NULL COMMENT '映射在fisco的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` VALUES (1,'2022117316','2022117117','三个纠缠之缘',30,'已接受','2024-04-05 18:36:38','梦浮羽','叶寄樱','6'),(2,'2022117117','2022117117','十个相遇之缘',20,'已接受','2024-04-07 09:12:51','叶寄樱','叶寄樱','2'),(3,'2022117316','2022117117','514个原石',114,'已接受','2024-04-23 09:37:28','梦浮羽','叶寄樱','7'),(4,'2022117316','2022117117','60级原神账号，三命山里灵活',423,'已接受','2024-04-24 10:10:06','梦浮羽','叶寄樱','10'),(5,'2022117117','2022117316','一份不要葱的牛肉面',370,'待接受','2024-04-24 13:36:17','叶寄樱','梦浮羽',NULL),(6,'2022117117','2022117316','30吨燃煤和4吨脱硫剂',900,'待接受','2024-04-24 13:36:58','叶寄樱','梦浮羽',NULL),(7,'2022117316','2022117117','10吨的燃煤，20吨磷叶石，4吨钢铁，7吨柴，1吨纯净水，30吨脱硫剂',1230,'已拒绝','2024-04-24 14:12:41','梦浮羽','叶寄樱',NULL),(8,'2022117127','2022117316','挨草10天',666,'已接受','2024-04-24 15:07:03','孙佳浩','梦浮羽','11'),(9,'2022117316','2022117127','10杯欧金金',233,'待接受','2024-04-24 15:08:47','梦浮羽','孙佳浩',NULL),(10,'2022111335','2022117316','一个满命流萤',100,'已接受','2024-04-25 08:25:25','裴公','梦浮羽','13');
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-30 19:08:14
