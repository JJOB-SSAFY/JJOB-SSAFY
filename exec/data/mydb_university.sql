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
-- Table structure for table `university`
--

DROP TABLE IF EXISTS `university`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `university` (
  `university_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `major` varchar(255) DEFAULT NULL,
  `university_name` varchar(255) DEFAULT NULL,
  `university_period` varchar(255) DEFAULT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`university_id`),
  KEY `FKbq1lj7cp5kixvou7l6t3nxj7w` (`resume_id`),
  CONSTRAINT `FKbq1lj7cp5kixvou7l6t3nxj7w` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university`
--

LOCK TABLES `university` WRITE;
/*!40000 ALTER TABLE `university` DISABLE KEYS */;
INSERT INTO `university` VALUES (1,'싸피학과','싸피대학교','2022-2023',2),(3,'2반','싸피','4년',8),(4,'Computer engineering','Harvard University','2015~2019',9),(7,'컴퓨터 공학','카이스트','2015~2019',11),(9,'컴퓨터 공학','카이스트','2015~2019',12),(10,'물리천문학부','Seoul National University','2017~2022',13),(11,'물리천문학부','Seoul National University','2017~2022',14),(18,'비전공 파이썬','SSAFY','2022.07 ~ 2023.06',19),(19,'비전공 파이썬','SSAFY','2022.07 ~ 2023.06',20),(20,'응용언어학','북경대학교','2010~2022',21),(21,'중어중문학과','북경대학교','2010~2022',21),(22,'응용언어학','북경대학교','2010~2022',22),(23,'중어중문학과','북경대학교','2010~2022',22);
/*!40000 ALTER TABLE `university` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 21:35:42
