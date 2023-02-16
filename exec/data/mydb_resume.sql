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
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resume` (
  `resume_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `github` varchar(255) DEFAULT NULL,
  `is_applied` bit(1) DEFAULT NULL,
  `is_opened` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `portfolio` varchar(255) DEFAULT NULL,
  `resume_title` varchar(255) NOT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`resume_id`),
  KEY `FKkmwhbubsnj7krn3wl2xbn9doc` (`member_id`),
  CONSTRAINT `FKkmwhbubsnj7krn3wl2xbn9doc` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (1,NULL,NULL,NULL,_binary '\0',_binary '\0','1234',NULL,NULL,'12314',2),(2,'kalkdjf.tistory','asdkfjaslf@dsafasdf.com','fdkafjlasdf@github',_binary '\0',_binary '\0','정우영','010-1234-1234',NULL,'싸피 자기소개서',2),(3,NULL,NULL,NULL,_binary '\0',_binary '\0','sdfzsdfsf',NULL,NULL,'sfrsdf',2),(5,NULL,NULL,NULL,_binary '',_binary '','test',NULL,NULL,'test',6),(8,'blogs','asd@naver.com','git@gmail.com',_binary '',_binary '','장아리','010-1234-1234',NULL,'삼성전자 특화 프로젝트 팀원 지원',4),(9,'blog.com/dndud','wjddndud@gmail.com','github.com/dndud',_binary '\0',_binary '\0','정우영',NULL,NULL,'삼성',16),(11,'blog.com',NULL,'github.com',_binary '',_binary '','정우영',NULL,NULL,'AA',16),(12,'blog.com',NULL,'github.com',_binary '',_binary '\0','정우영',NULL,NULL,'AA',16),(13,'blog.com/parkssuu',NULL,'github.com/xoghks',_binary '\0',_binary '\0','박태환',NULL,NULL,'자소서 a-1',12),(14,'blog.com/parkssuu',NULL,'github.com/xoghks',_binary '',_binary '','박태환',NULL,NULL,'자소서 a-1',12),(19,NULL,NULL,NULL,_binary '\0',_binary '\0','김기윤',NULL,NULL,'삼성전자 이력서',6),(20,NULL,NULL,NULL,_binary '',_binary '','김기윤',NULL,NULL,'삼성전자 이력서',6),(21,'blog.com/jjang',NULL,'github.com/jjang',_binary '\0',_binary '\0','함시연',NULL,NULL,'自我介绍书',14),(22,'blog.com/jjang',NULL,'github.com/jjang',_binary '',_binary '','함시연',NULL,NULL,'自我介绍书',14),(23,'blog/blog','rlarldbs@gmail.com','git/git',_binary '\0',_binary '\0','123123','010-1424-1345',NULL,'구글 자소서',15),(24,'blog/blog','rlarldbs@gmail.com','git/git',_binary '',_binary '','123123','010-1424-1345',NULL,'구글 자소서',15),(25,'blog/blog','wkdwlsans@naver.com','git/git',_binary '\0',_binary '\0','장진문','010-2341-2341',NULL,'1번자소서',13),(26,'blog/blog','wkdwlsans@naver.com','git/git',_binary '',_binary '\0','장진문','010-2341-2341',NULL,'1번자소서',13),(27,'blog/blog','wkdwlsans@naver.com','git/git',_binary '',_binary '\0','장진문','010-2341-2341',NULL,'1번자소서',13);
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
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
