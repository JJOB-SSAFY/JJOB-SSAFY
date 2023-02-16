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
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `card_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `github` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `preferred_job` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `visible` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (2,NULL,'admin@a.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'admin','010-1234-1234',NULL,NULL,0),(3,'','ssafy@ssafy.com','','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fjm.jpg?alt=media&token=cd57e1a8-9095-4fa7-adab-6578e298fd19','','김싸피','','','',0),(4,'blogssss','study@ssafy.com','git@gmail.com','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Flion.jpg?alt=media&token=afcc5ae1-1005-4037-9996-6fe277af1621','열심히 해보자','교육생','010-1234-1234','프론트','vue3',1),(5,NULL,'keeeeeey@naver.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'김기윤',NULL,NULL,NULL,0),(6,'https://keylog.tistory.com/','key@gmail.com','https://github.com/keeeeeey','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fimagekey.png?alt=media&token=89473fa9-3b33-4e11-8f80-7423540bb7f7','끊임없이 도전하는 개발자 김기윤입니다.','김기윤','010-0000-0000','자바 백엔드 개발자','Java, Spring, JPA',1),(7,NULL,'ssafy1@ssafy.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'싸피1',NULL,NULL,NULL,0),(8,NULL,'sseioul@naver.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'김기윤',NULL,NULL,NULL,0),(9,NULL,'gkatldus@daum.net',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'시연',NULL,NULL,NULL,0),(10,'blog.com','gobuig00@naver.com','github.com','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2FImage%20Pasted%20at%202023-2-9%2013-48.png?alt=media&token=fe8d947a-38d3-4a7b-843f-49994d8f12bd','안녕하세요 .. ','정우영','010-4222-9234','생산, 설비','JAVA,PYTHON,C',1),(11,NULL,'sseioul@gmail.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'김기윤[광주_2반_C208]팀원',NULL,NULL,NULL,0),(12,'blog.com/qkrxoghks','qkrxoghks@gmail.com','github.com/qkrxoghks','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%ED%83%9C%ED%99%98.jpg?alt=media&token=0682e805-e659-49a8-a42c-1786fcf0ff3c','안녕하세요. 외모 뿐만 아니라 실력도 뛰어난 인재입니다.','박소나','010-8293-1928','웹디자인,UI/UX 디자인','VUE,JS,REACT,NODE',1),(13,'blog.com/wkdwlsans','wkdwlsans@gmail.com','github.com/wkdwlsans','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2FImage%20Pasted%20at%202023-1-17%2017-49.png?alt=media&token=92edc9ad-25ef-4f5e-ae44-7671d1a47924','열심히 하겠습니다.','장아리','010-1423-5821','인공지능 AI','Python, Tensorflow',1),(14,'blog.com/tldus','gkatldus@gmail.com','github.com/tldus','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Frn_image_picker_lib_temp_798139f5-bda7-4868-9198-f7a83d0547c7.jpg?alt=media&token=91afb5bb-ecef-437d-97ea-3d62527f856d','안녕하세요. 중국어도 능통한 글로벌 인재 함잔나입니다.','함잔나','010-8285-2929','IT 강의','C, JAVA, ',1),(15,'blog.com/rldbs','rlarldbs@gmail.com','github/rlarldbs','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%EA%B8%B0%EC%9C%A4%EC%9D%B4%ED%98%95.jpg?alt=media&token=739bb9c2-ca54-4baf-b954-dfbfb5ac3b6e','안녕하세요. 꿈꾸는 개발자가 되고 싶은 김유미 입니다.','김유미','010-4895-7515','DBA, 데이터베이스','Linux, C',1),(16,'blog.com/dndudㅁㅁ','wjddndud@gmail.com','github.com/dndud','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%EC%9A%B0%EC%98%81%EC%9D%B4.jpg?alt=media&token=88f89872-28e4-4731-8117-cca56096aa8d','실력으로 검증합니다. 뽑아주세요','정나미','010-1242-8857','정보보안, 모의 해킹','Apache, Linux',1),(17,'blogs','jjm1261@naver.com','jm@gmail.com','https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fjm.jpg?alt=media&token=3aa14440-9cf3-41b2-93a6-8b7b8e5430b2','열심히 하겠습니다! 화이팅','장진문','010-4945-0817','프론트','Vue3',0),(18,NULL,'kakao@kakao.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'카카오 관리자1',NULL,NULL,NULL,0),(19,NULL,'samsung@samsung.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'삼성전자 관리자',NULL,NULL,NULL,0),(20,NULL,'jobis@j.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'자비스',NULL,NULL,NULL,0),(21,NULL,'swatch@s.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'스와치온',NULL,NULL,NULL,0),(22,NULL,'hey@h.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'헤이딜러',NULL,NULL,NULL,0),(23,NULL,'ncsoft@ncsoft.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'엔시소프트 관리자1',NULL,NULL,NULL,0),(24,NULL,'auto@auto.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'현대오토에버 관리자',NULL,NULL,NULL,0),(25,NULL,'hana@hana.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'하나은행 관리자',NULL,NULL,NULL,0),(26,NULL,'skt@skt.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'skt관리자1',NULL,NULL,NULL,NULL),(27,NULL,'google@google.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'구글관리자1',NULL,NULL,NULL,NULL),(28,NULL,'naver@naver.com',NULL,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2',NULL,'네이버관리자',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 21:35:36
