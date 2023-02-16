-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 54.180.146.30    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `project_exp`
--

DROP TABLE IF EXISTS `project_exp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_exp` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `function` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `member_cnt` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `project_period` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `tech_env` varchar(255) DEFAULT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKbdcnvt5yb4bqv4qwt6kntm31` (`resume_id`),
  CONSTRAINT `FKbdcnvt5yb4bqv4qwt6kntm31` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_exp`
--

LOCK TABLES `project_exp` WRITE;
/*!40000 ALTER TABLE `project_exp` DISABLE KEYS */;
INSERT INTO `project_exp` VALUES (2,'지원서부터 합격까지 한 사이트에서 할 수 있게','JJOB SSAFYurl','5','프론트','JJOB SSAFY','23.01.17~23.02.17','vue3의 활용 및 배포 등','채용플랫폼','Spring, vue3',8);
/*!40000 ALTER TABLE `project_exp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 21:35:44
