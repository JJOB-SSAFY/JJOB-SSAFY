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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `review_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FK1r7rw4wp2mtlsn758pdi24qdx` (`company_id`),
  KEY `FKk0ccx5i4ci2wd70vegug074w1` (`member_id`),
  CONSTRAINT `FK1r7rw4wp2mtlsn758pdi24qdx` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `FKk0ccx5i4ci2wd70vegug074w1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'조흠','조흠','조흥','싸피 면접',2,4),(2,'프로젝트에서 맡은 역활과 코드리뷰를 하였습니다.','면접 리뷰','프로젝트에 관한 질문','카카오 면접 후기',1,16),(3,'간단한 1분 자기소개\n자소서에서 말했던 내용','면접 리뷰','우선 자기소개를 해주세요. ...\n왜 우리 회사에서 일하고 싶습니까? ...\n지원자의 강점 (장점)은 무엇입니까? ...\n지원자의 약점 (단점)은 무엇입니까? ...\n우리 회사가 귀하를 채용해야 하는 이유를 말해보세요','1차 면접 리뷰',9,12),(4,'志敏视力不好，所以戴眼镜。\n我跟爱人一起去汉堡包店吃汉堡包了。','skt 최종 면접 리뷰','脸蛋漂亮','skt 최종 면접 리뷰',11,14),(5,'I\'m fine thank you and u?','Review','How are you?','Google Conference',12,15);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 21:35:39
