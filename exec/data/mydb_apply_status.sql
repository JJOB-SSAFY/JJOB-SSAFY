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
-- Table structure for table `apply_status`
--

DROP TABLE IF EXISTS `apply_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apply_status` (
  `apply_status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `step` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `recruit_id` bigint(20) DEFAULT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`apply_status_id`),
  KEY `FKovuxrs5s6pq1q63l40axdyh8a` (`member_id`),
  KEY `FKp5e13ide2y9vuumygmysprbf` (`recruit_id`),
  KEY `FKoq7illmgiwi6w2em5chj7g4dh` (`resume_id`),
  CONSTRAINT `FKoq7illmgiwi6w2em5chj7g4dh` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`),
  CONSTRAINT `FKovuxrs5s6pq1q63l40axdyh8a` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FKp5e13ide2y9vuumygmysprbf` FOREIGN KEY (`recruit_id`) REFERENCES `recruit` (`recruit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_status`
--

LOCK TABLES `apply_status` WRITE;
/*!40000 ALTER TABLE `apply_status` DISABLE KEYS */;
INSERT INTO `apply_status` VALUES (1,'','합격','결과보기','서류전형','',6,1,5),(2,NULL,NULL,'심사중','서류전형',NULL,4,1,8),(3,'','합격','결과보기','서류전형','',16,3,11),(4,NULL,NULL,'지원완료','서류전형',NULL,16,3,12),(5,'','합격','결과보기','서류전형','',12,9,14),(6,'','합격','결과보기','서류전형','',6,10,20),(7,'','합격','결과보기','서류전형','',14,11,22),(8,'','합격','결과보기','서류전형','',15,12,24),(9,NULL,NULL,'지원완료','서류전형',NULL,13,13,26),(10,NULL,NULL,'지원완료','서류전형',NULL,13,13,27);
/*!40000 ALTER TABLE `apply_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 21:35:41
