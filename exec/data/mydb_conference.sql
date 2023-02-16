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
-- Table structure for table `conference`
--

DROP TABLE IF EXISTS `conference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conference` (
  `conference_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `call_end_time` datetime NOT NULL,
  `call_start_time` datetime NOT NULL,
  `conference_category` varchar(255) DEFAULT NULL,
  `conference_title` varchar(255) NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`conference_id`),
  KEY `FKhu91l33ieytaufdcb1dum99g3` (`company_id`),
  KEY `FKj17ch4lhywk1gbm2c2jyf8b9n` (`member_id`),
  CONSTRAINT `FKhu91l33ieytaufdcb1dum99g3` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `FKj17ch4lhywk1gbm2c2jyf8b9n` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conference`
--

LOCK TABLES `conference` WRITE;
/*!40000 ALTER TABLE `conference` DISABLE KEYS */;
INSERT INTO `conference` VALUES (1,'2023-02-16 18:00:00','2023-02-16 17:00:00','INTERVIEW','싸피 교육프로 면접',2,7),(2,'2023-02-15 20:45:00','2023-02-15 20:43:00','INTERVIEW','교육생님 면접방',2,4),(5,'2023-02-17 11:43:00','2023-02-17 09:43:00','INTERVIEW','카카오 1차면접',1,18),(6,'2023-02-17 13:00:00','2023-02-17 00:00:00','INTERVIEW','삼성전자 면접방',3,19),(7,'2023-02-17 10:40:00','2023-02-17 09:40:00','INTERVIEW','현대오토에버',9,24),(8,'2023-02-28 10:30:00','2023-02-28 09:30:00','INTERVIEW','skt 3차면접',11,26),(9,'2023-06-14 22:50:00','2023-06-14 16:50:00','INTERVIEW','Google conference',12,27),(10,'2023-02-17 18:11:00','2023-02-17 17:11:00','INTERVIEW','네이버 면접',13,28);
/*!40000 ALTER TABLE `conference` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 21:35:40
